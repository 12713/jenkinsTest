package rocketDemo;

import com.alibaba.rocketmq.client.ClientConfig;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.impl.MQClientAPIImpl;
import com.alibaba.rocketmq.client.impl.factory.MQClientInstance;
import com.alibaba.rocketmq.common.protocol.RequestCode;
import com.alibaba.rocketmq.common.protocol.ResponseCode;
import com.alibaba.rocketmq.common.protocol.body.TopicList;
import com.alibaba.rocketmq.remoting.InvokeCallback;
import com.alibaba.rocketmq.remoting.RemotingClient;
import com.alibaba.rocketmq.remoting.exception.RemotingException;
import com.alibaba.rocketmq.remoting.netty.ResponseFuture;
import com.alibaba.rocketmq.remoting.protocol.RemotingCommand;

/**
 * @author tingxiu.zhou@hand-china.com
 * @version 1.0
 * @name Demo
 * @description
 * @date 2017/12/15 10:16
 */
public class Demo implements InvokeCallback {
	private final MQClientInstance mqClientInstance;
	private final ClientConfig clientConfig;

	public Demo(ClientConfig clientConfig){
		this.clientConfig=clientConfig;
		this.mqClientInstance = new MQClientInstance(this.clientConfig,1,clientConfig.getClientIP(),null);
		try {
			System.out.println("RocketMQ client is connecting server!");
			//启动
			MQClientAPIImpl impl = mqClientInstance.getMQClientAPIImpl();
			impl.start();
			TopicList topicList = impl.getTopicListFromNameServer(6000);
			for (String str:topicList.getTopicList()
					) {
				System.out.println("------------->"+str);
			}
			System.out.println("RocketMQ client connect server success!");
		} catch (MQClientException e) {
			e.printStackTrace();
		} catch (RemotingException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public ClientConfig getClientConfig() {
		return clientConfig;
	}

	public MQClientInstance getMqClientInstance() {
		return mqClientInstance;
	}


	@Override
	public void operationComplete(ResponseFuture responseFuture) {
		switch (responseFuture.getResponseCommand().getCode()) {
			case ResponseCode.SUCCESS: {
				byte[] body = responseFuture.getResponseCommand().getBody();
				if (body != null) {
					TopicList topicList = TopicList.decode(body, TopicList.class);
					for (String str:topicList.getTopicList()
							) {
						System.out.println("------------->"+str);
					}
				}
			}
			default:
				break;
		}
	}
}
