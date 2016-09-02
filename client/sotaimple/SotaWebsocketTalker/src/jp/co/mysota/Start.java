//このソースは、VstoneMagicによって自動生成されました。
//ソースの内容を書き換えた場合、VstoneMagicで開けなくなる場合があります。
package	jp.co.mysota;
import	main.main.GlobalVariable;
import	jp.vstone.RobotLib.*;
import	jp.vstone.sotatalk.*;
import	jp.vstone.sotatalk.SpeechRecog.*;
import	jp.vstone.camera.*;
import	java.awt.Color;

public class Start
{

	public String speechRecogResult;
	public jp.co.mysota.WebsocketMessenger WebsocketMessenger;
	public RecogResult recogresult;
	public jp.co.mysota.End End;
	public CRobotPose pose;
	public void start()																									//@<BlockInfo>jp.vstone.block.func,0,304,1104,304,False,14,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.robocam.setEnableFaceSearch(false);																//@<BlockInfo>jp.vstone.block.facedetect.traking,64,304,1040,304,False,13,顔追従@</BlockInfo>
		GlobalVariable.robocam.setEnableSmileDetect(true);
		GlobalVariable.robocam.setEnableAgeSexDetect(true);

		GlobalVariable.robocam.StartFaceTraking();
		try{
			GlobalVariable.detectCount=0;


																														//@<OutputChild>
			WebsocketMessenger.connect((String)"ws://192.168.128.103:8080/ws");											//@<BlockInfo>jp.vstone.block.callfunc.base,128,304,128,304,False,12,@</BlockInfo>	@<EndOfBlock/>
			while(GlobalVariable.TRUE)																					//@<BlockInfo>jp.vstone.block.while.endless,208,304,976,304,False,11,Endless@</BlockInfo>
			{

																														//@<OutputChild>
				GlobalVariable.faceresult = GlobalVariable.robocam.getDetectResult();									//@<BlockInfo>jp.vstone.block.facedetect.isdetect,272,256,912,256,False,10,コメント@</BlockInfo>

				if(GlobalVariable.faceresult.isDetect()) GlobalVariable.detectCount++;
				else GlobalVariable.detectCount=0;

				if(GlobalVariable.detectCount>(int)2)
				{
																														//@<OutputChild>
					CRobotUtil.wait((int)1000);																			//@<BlockInfo>jp.vstone.block.wait,336,256,336,256,False,9,コメント@</BlockInfo>	@<EndOfBlock/>
					GlobalVariable.sotawish.Say((String)"性別を教えて",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,400,256,400,256,False,8,@</BlockInfo>
																														//@<EndOfBlock/>
					speechRecogResult = GlobalVariable.recog.getResponsewithAbort((int)60000,(int)3);					//@<BlockInfo>jp.vstone.block.talk.speechrecog.get,464,256,464,256,False,7,音声認識して、得られた結果（文字列）をspeechRecogResultに代入します。@</BlockInfo>
					if(speechRecogResult == null) speechRecogResult = "";

																														//@<EndOfBlock/>
					CRobotUtil.wait((int)1000);																			//@<BlockInfo>jp.vstone.block.wait,528,256,528,256,False,6,コメント@</BlockInfo>	@<EndOfBlock/>
					nod();																								//@<BlockInfo>jp.vstone.block.callfunc.base,592,256,592,256,False,5,@</BlockInfo>	@<EndOfBlock/>
					CRobotUtil.wait((int)1000);																			//@<BlockInfo>jp.vstone.block.wait,656,256,656,256,False,4,コメント@</BlockInfo>	@<EndOfBlock/>
					WebsocketMessenger.sendMessage((String)speechRecogResult);											//@<BlockInfo>jp.vstone.block.callfunc.base,720,256,720,256,False,3,@</BlockInfo>	@<EndOfBlock/>
					initial();																							//@<BlockInfo>jp.vstone.block.callfunc.base,784,256,784,256,False,2,@</BlockInfo>	@<EndOfBlock/>
					break;																								//@<BlockInfo>jp.vstone.block.break,848,256,848,256,False,1,break@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>

				}else
				{
																														//@<OutputChild>
																														//@</OutputChild>

				}
																														//@<EndOfBlock/>
																														//@</OutputChild>
			}
																														//@<EndOfBlock/>
																														//@</OutputChild>


		}finally{
			GlobalVariable.robocam.StopFaceTraking();
		}
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void recommend()																								//@<BlockInfo>jp.vstone.block.func,16,2304,640,2304,False,20,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.sotawish.Say((String)"この商品はいかがですか？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,80,2304,80,2304,False,19,@</BlockInfo>
																														//@<EndOfBlock/>
		WebsocketMessenger.sendMessage((String)speechRecogResult);														//@<BlockInfo>jp.vstone.block.callfunc.base,144,2304,144,2304,False,18,@</BlockInfo>	@<EndOfBlock/>
		GlobalVariable.sotawish.Say((String)"こちらの商品は満足いただけましたか？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,208,2304,208,2304,False,17,@</BlockInfo>
																														//@<EndOfBlock/>
		speechRecogResult = GlobalVariable.recog.getYesorNowithAbort((int)60000 , (int)3);								//@<BlockInfo>jp.vstone.block.talk.getyesno,288,2208,464,2208,False,16,音声認識を行い、肯定/否定を取得する。取得結果はメンバー変数のspeechRecogResultに格納され、肯定なら「YES」、否定なら「NO」、聞き取り失敗なら長さ0の文字列が代入される。@</BlockInfo>
		if(speechRecogResult==null) speechRecogResult="";

		if(speechRecogResult.equals("YES"))
		{
																														//@<OutputChild>
			End.end();																									//@<BlockInfo>jp.vstone.block.callfunc.base,352,2208,352,2208,False,15,@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>

		}else if(speechRecogResult.equals("NO"))
		{
																														//@<OutputChild>
																														//@</OutputChild>

		}else
		{
																														//@<OutputChild>
																														//@</OutputChild>

		}
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void ask()																									//@<BlockInfo>jp.vstone.block.func,32,1904,768,1904,False,29,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		for(int i=0;i<(int)2;i++)																						//@<BlockInfo>jp.vstone.block.for,96,1904,688,1904,False,28,コメント@</BlockInfo>
		{
																														//@<OutputChild>
			GlobalVariable.sotawish.Say((String)"その人は外で遊ぶのが好きですか？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,160,1904,160,1904,False,27,@</BlockInfo>
																														//@<EndOfBlock/>
			speechRecogResult = GlobalVariable.recog.getYesorNowithAbort((int)60000 , (int)3);							//@<BlockInfo>jp.vstone.block.talk.getyesno,240,1808,560,1808,False,26,音声認識を行い、肯定/否定を取得する。取得結果はメンバー変数のspeechRecogResultに格納され、肯定なら「YES」、否定なら「NO」、聞き取り失敗なら長さ0の文字列が代入される。@</BlockInfo>
			if(speechRecogResult==null) speechRecogResult="";

			if(speechRecogResult.equals("YES"))
			{
																														//@<OutputChild>
				nod();																									//@<BlockInfo>jp.vstone.block.callfunc.base,304,1808,304,1808,False,24,@</BlockInfo>	@<EndOfBlock/>
																														//@<BlockInfo>jp.vstone.block.freeproc,368,1808,368,1808,False,23,@</BlockInfo>










																														//@<EndOfBlock/>
				WebsocketMessenger.sendMessage((String)speechRecogResult);												//@<BlockInfo>jp.vstone.block.callfunc.base,432,1808,432,1808,False,22,@</BlockInfo>	@<EndOfBlock/>
				recommend();																							//@<BlockInfo>jp.vstone.block.callfunc.base,496,1808,496,1808,False,21,@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>

			}else if(speechRecogResult.equals("NO"))
			{
																														//@<OutputChild>
																														//@</OutputChild>

			}else
			{
																														//@<OutputChild>
				GlobalVariable.sotawish.Say((String)"もう一度お願いします",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,304,2000,304,2000,False,25,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>

			}
																														//@<EndOfBlock/>
																														//@</OutputChild>
		}																												//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void demo0901()																								//@<BlockInfo>jp.vstone.block.func,48,2976,1184,2976,False,42,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.sotawish.Say((String)"プレゼントを贈りたい人のことを教えてください",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,112,2976,112,2976,False,41,@</BlockInfo>
																														//@<EndOfBlock/>
		WebsocketMessenger.connect((String)"ws://54.238.151.211:8080/ws");												//@<BlockInfo>jp.vstone.block.callfunc.base,224,2976,224,2976,False,40,@</BlockInfo>	@<EndOfBlock/>
		while(GlobalVariable.TRUE)																						//@<BlockInfo>jp.vstone.block.while.endless,304,2976,1104,2976,False,39,Endless@</BlockInfo>
		{

																														//@<OutputChild>
			CRobotUtil.wait((int)3500);																					//@<BlockInfo>jp.vstone.block.wait,368,2976,368,2976,False,38,コメント@</BlockInfo>	@<EndOfBlock/>
			speechRecogResult = GlobalVariable.recog.getResponsewithAbort((int)60000,(int)3);							//@<BlockInfo>jp.vstone.block.talk.speechrecog.get,432,2976,432,2976,False,37,音声認識して、得られた結果（文字列）をspeechRecogResultに代入します。@</BlockInfo>
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<EndOfBlock/>
			CRobotUtil.wait((int)3000);																					//@<BlockInfo>jp.vstone.block.wait,496,2976,496,2976,False,36,コメント@</BlockInfo>	@<EndOfBlock/>
			{																											//@<BlockInfo>jp.vstone.block.thread,560,2976,768,2976,False,35,スレッド@</BlockInfo>
				Thread th = new Thread(new Runnable() {
					@Override
					public void run() {
						try{
							
							
																														//@<OutputChild>
							pose = new CRobotPose();																				//@<BlockInfo>jp.vstone.block.pose,624,2976,624,2976,False,31,コメント@</BlockInfo>
							pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
											new Short[]{0,-900,-710,900,700,0,-240,0}
											);
							pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
											new Short[]{100,100,100,100,100,100,100,100}
											);
							pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
											new Short[]{0,-255,0,180,80,0,180,80,0}
											);
							GlobalVariable.motion.play(pose,300);
							CRobotUtil.wait(300);																					//@<EndOfBlock/>
							WebsocketMessenger.sendMessage((String)speechRecogResult);												//@<BlockInfo>jp.vstone.block.callfunc.base,704,2976,704,2976,False,30,@</BlockInfo>	@<EndOfBlock/>
																																		//@</OutputChild>

							
						} catch(Exception e) {
							CRobotUtil.Err("jp.vstone.block.thread","例外が発生しました。");
							e.printStackTrace();
						}
					}
				});
				th.start();
			}
																														//@<EndOfBlock/>
			recogresult = GlobalVariable.recog.getRecognitionwithAbort((int)60000);										//@<BlockInfo>jp.vstone.block.talk.speechrecog.score2,832,2928,1024,2928,False,34,音声認識を行い、認識候補との完全一致で比較する。認識スコアが一番高い結果に分岐する。実際に認識された文字列はspeechRecogResultに代入される@</BlockInfo>
			speechRecogResult = recogresult.CheckBest(new String[]{
			 "ありがとう" ,  "" , 
			},false);
			if(speechRecogResult == null) speechRecogResult = "";

			if(speechRecogResult.contains((String)"ありがとう"))
			{
				speechRecogResult = recogresult.getBasicResult();
				if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
					GlobalVariable.sotawish.Say((String)"ばいばい～",MotionAsSotaWish.MOTION_TYPE_BYE,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,896,2928,896,2928,False,33,@</BlockInfo>
																															//@<EndOfBlock/>
					break;																									//@<BlockInfo>jp.vstone.block.break,960,2928,960,2928,False,32,break@</BlockInfo>	@<EndOfBlock/>
																																//@</OutputChild>

			}
			else
			{
				speechRecogResult = recogresult.getBasicResult();
				if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
																														//@</OutputChild>

			}
																														//@<EndOfBlock/>
																														//@</OutputChild>
		}
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void nod()																									//@<BlockInfo>jp.vstone.block.func,16,2624,464,2624,False,49,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,80,2624,80,2624,False,48,コメント@</BlockInfo>
		pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{0,-900,0,900,0,0,-240,0}
						);
		pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{100,100,100,100,100,100,100,100}
						);
		pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
						new Short[]{0,-255,0,180,80,0,180,80,0}
						);
		GlobalVariable.motion.play(pose,300);
		CRobotUtil.wait(300);																							//@<EndOfBlock/>
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,144,2624,144,2624,False,47,コメント@</BlockInfo>
		pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{0,-900,-440,900,380,20,50,10}
						);
		pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{100,100,100,100,100,100,100,100}
						);
		pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
						new Short[]{0,-255,0,180,80,0,180,80,0}
						);
		GlobalVariable.motion.play(pose,300);
		CRobotUtil.wait(300);																							//@<EndOfBlock/>
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,208,2624,208,2624,False,46,コメント@</BlockInfo>
		pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{0,-900,0,900,0,0,-270,0}
						);
		pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{100,100,100,100,100,100,100,100}
						);
		pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
						new Short[]{0,-255,0,180,80,0,180,80,0}
						);
		GlobalVariable.motion.play(pose,300);
		CRobotUtil.wait(300);																							//@<EndOfBlock/>
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,272,2624,272,2624,False,45,コメント@</BlockInfo>
		pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{0,-900,0,900,0,20,50,10}
						);
		pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{100,100,100,100,100,100,100,100}
						);
		pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
						new Short[]{0,-255,0,180,80,0,180,80,0}
						);
		GlobalVariable.motion.play(pose,300);
		CRobotUtil.wait(300);																							//@<EndOfBlock/>
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,336,2624,336,2624,False,44,コメント@</BlockInfo>
		pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{0,-900,0,900,0,0,-260,0}
						);
		pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{100,100,100,100,100,100,100,100}
						);
		pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
						new Short[]{0,-255,0,180,80,0,180,80,0}
						);
		GlobalVariable.motion.play(pose,300);
		CRobotUtil.wait(300);																							//@<EndOfBlock/>
		{																												//@<BlockInfo>jp.vstone.block.offsetpose,400,2624,400,2624,False,43,@</BlockInfo>
			pose.addServoAngle((byte)1,((short)0));
		}
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void age()																									//@<BlockInfo>jp.vstone.block.func,0,912,960,912,False,61,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		for(int i=0;i<(int)2;i++)																						//@<BlockInfo>jp.vstone.block.for,64,912,896,912,False,60,コメント@</BlockInfo>
		{
																														//@<OutputChild>
			GlobalVariable.sotawish.Say((String)"幼稚園生ですか？小学生ですか？中学生ですか？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,128,912,128,912,False,59,@</BlockInfo>
																														//@<EndOfBlock/>
			speechRecogResult = GlobalVariable.recog.getResponsewithAbort((int)60000,(int)3);							//@<BlockInfo>jp.vstone.block.talk.speechrecog.get,208,912,208,912,False,58,音声認識して、得られた結果（文字列）をspeechRecogResultに代入します。@</BlockInfo>
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<EndOfBlock/>
			nod();																										//@<BlockInfo>jp.vstone.block.callfunc.base,272,912,272,912,False,57,@</BlockInfo>	@<EndOfBlock/>
			WebsocketMessenger.sendMessage((String)speechRecogResult);													//@<BlockInfo>jp.vstone.block.callfunc.base,384,912,384,912,False,56,@</BlockInfo>	@<EndOfBlock/>
			CRobotUtil.wait((int)1000);																					//@<BlockInfo>jp.vstone.block.wait,448,912,448,912,False,55,コメント@</BlockInfo>	@<EndOfBlock/>
			GlobalVariable.sotawish.Say((String)"ですね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);		//@<BlockInfo>jp.vstone.block.talk.say,512,912,512,912,False,54,@</BlockInfo>
																														//@<EndOfBlock/>
			speechRecogResult = GlobalVariable.recog.getYesorNowithAbort((int)60000 , (int)3);							//@<BlockInfo>jp.vstone.block.talk.getyesno,576,816,768,816,False,53,音声認識を行い、肯定/否定を取得する。取得結果はメンバー変数のspeechRecogResultに格納され、肯定なら「YES」、否定なら「NO」、聞き取り失敗なら長さ0の文字列が代入される。@</BlockInfo>
			if(speechRecogResult==null) speechRecogResult="";

			if(speechRecogResult.equals("YES"))
			{
																														//@<OutputChild>
				budget();																								//@<BlockInfo>jp.vstone.block.callfunc.base,640,816,640,816,False,51,@</BlockInfo>	@<EndOfBlock/>
				break;																									//@<BlockInfo>jp.vstone.block.break,704,816,704,816,False,50,break@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>

			}else if(speechRecogResult.equals("NO"))
			{
																														//@<OutputChild>
																														//@</OutputChild>

			}else
			{
																														//@<OutputChild>
				GlobalVariable.sotawish.Say((String)"もう一度お願いします",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,640,1008,640,1008,False,52,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>

			}
																														//@<EndOfBlock/>
																														//@</OutputChild>
		}																												//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public Start()																										//@<BlockInfo>jp.vstone.block.func.constructor,16,16,720,16,False,67,@</BlockInfo>
	{
																														//@<OutputChild>
		/*String speechRecogResult*/;																					//@<BlockInfo>jp.vstone.block.variable,80,16,80,16,False,66,break@</BlockInfo>
																														//@<EndOfBlock/>
		WebsocketMessenger=new jp.co.mysota.WebsocketMessenger();														//@<BlockInfo>jp.vstone.block.variable,144,16,144,16,False,65,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*RecogResult recogresult*/;																					//@<BlockInfo>jp.vstone.block.variable,208,16,208,16,False,64,break@</BlockInfo>
																														//@<EndOfBlock/>
		End=new jp.co.mysota.End();																						//@<BlockInfo>jp.vstone.block.variable,272,16,272,16,False,63,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*CRobotPose pose*/;																							//@<BlockInfo>jp.vstone.block.variable,336,16,336,16,False,62,break@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void method()																								//@<BlockInfo>jp.vstone.block.func,16,128,416,128,False,69,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		start();																										//@<BlockInfo>jp.vstone.block.callfunc.base,192,128,192,128,False,68,@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void initial()																								//@<BlockInfo>jp.vstone.block.func,32,560,592,560,False,75,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		CRobotUtil.wait((int)1000);																						//@<BlockInfo>jp.vstone.block.wait,96,560,96,560,False,74,コメント@</BlockInfo>	@<EndOfBlock/>
		GlobalVariable.sotawish.Say((String)"ですか",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);			//@<BlockInfo>jp.vstone.block.talk.say,176,560,176,560,False,73,@</BlockInfo>
																														//@<EndOfBlock/>
		speechRecogResult = GlobalVariable.recog.getYesorNowithAbort((int)60000 , (int)3);								//@<BlockInfo>jp.vstone.block.talk.getyesno,288,464,416,464,False,72,音声認識を行い、肯定/否定を取得する。取得結果はメンバー変数のspeechRecogResultに格納され、肯定なら「YES」、否定なら「NO」、聞き取り失敗なら長さ0の文字列が代入される。@</BlockInfo>
		if(speechRecogResult==null) speechRecogResult="";

		if(speechRecogResult.equals("YES"))
		{
																														//@<OutputChild>
			age();																										//@<BlockInfo>jp.vstone.block.callfunc.base,352,464,352,464,False,70,@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>

		}else if(speechRecogResult.equals("NO"))
		{
																														//@<OutputChild>
																														//@</OutputChild>

		}else
		{
																														//@<OutputChild>
			GlobalVariable.sotawish.Say((String)"もう一度お願いします",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,352,656,352,656,False,71,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>

		}
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void interest()																								//@<BlockInfo>jp.vstone.block.func,0,1552,928,1552,False,87,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		for(int i=0;i<(int)2;i++)																						//@<BlockInfo>jp.vstone.block.for,64,1552,864,1552,False,86,コメント@</BlockInfo>
		{
																														//@<OutputChild>
			GlobalVariable.sotawish.Say((String)"その人の趣味はなんですか？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,128,1552,128,1552,False,85,@</BlockInfo>
																														//@<EndOfBlock/>
			speechRecogResult = GlobalVariable.recog.getResponsewithAbort((int)60000,(int)3);							//@<BlockInfo>jp.vstone.block.talk.speechrecog.get,208,1552,208,1552,False,84,音声認識して、得られた結果（文字列）をspeechRecogResultに代入します。@</BlockInfo>
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<EndOfBlock/>
			nod();																										//@<BlockInfo>jp.vstone.block.callfunc.base,272,1552,272,1552,False,83,@</BlockInfo>	@<EndOfBlock/>
			WebsocketMessenger.sendMessage((String)speechRecogResult);													//@<BlockInfo>jp.vstone.block.callfunc.base,352,1552,352,1552,False,82,@</BlockInfo>	@<EndOfBlock/>
			CRobotUtil.wait((int)1000);																					//@<BlockInfo>jp.vstone.block.wait,416,1552,416,1552,False,81,コメント@</BlockInfo>	@<EndOfBlock/>
			GlobalVariable.sotawish.Say((String)"ですね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);		//@<BlockInfo>jp.vstone.block.talk.say,480,1552,480,1552,False,80,@</BlockInfo>
																														//@<EndOfBlock/>
			speechRecogResult = GlobalVariable.recog.getYesorNowithAbort((int)60000 , (int)3);							//@<BlockInfo>jp.vstone.block.talk.getyesno,544,1456,736,1456,False,79,音声認識を行い、肯定/否定を取得する。取得結果はメンバー変数のspeechRecogResultに格納され、肯定なら「YES」、否定なら「NO」、聞き取り失敗なら長さ0の文字列が代入される。@</BlockInfo>
			if(speechRecogResult==null) speechRecogResult="";

			if(speechRecogResult.equals("YES"))
			{
																														//@<OutputChild>
				recommend();																							//@<BlockInfo>jp.vstone.block.callfunc.base,608,1456,608,1456,False,77,@</BlockInfo>	@<EndOfBlock/>
				break;																									//@<BlockInfo>jp.vstone.block.break,672,1456,672,1456,False,76,break@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>

			}else if(speechRecogResult.equals("NO"))
			{
																														//@<OutputChild>
																														//@</OutputChild>

			}else
			{
																														//@<OutputChild>
				GlobalVariable.sotawish.Say((String)"もう一度お願いします",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,608,1648,608,1648,False,78,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>

			}
																														//@<EndOfBlock/>
																														//@</OutputChild>
		}																												//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void budget()																								//@<BlockInfo>jp.vstone.block.func,0,1248,880,1232,False,99,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		for(int i=0;i<(int)2;i++)																						//@<BlockInfo>jp.vstone.block.for,64,1248,816,1232,False,98,コメント@</BlockInfo>
		{
																														//@<OutputChild>
			GlobalVariable.sotawish.Say((String)"予算はいくらまでですか",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,128,1248,128,1248,False,97,@</BlockInfo>
																														//@<EndOfBlock/>
			speechRecogResult = GlobalVariable.recog.getResponsewithAbort((int)60000,(int)3);							//@<BlockInfo>jp.vstone.block.talk.speechrecog.get,208,1248,208,1248,False,96,音声認識して、得られた結果（文字列）をspeechRecogResultに代入します。@</BlockInfo>
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<EndOfBlock/>
			nod();																										//@<BlockInfo>jp.vstone.block.callfunc.base,272,1248,272,1248,False,95,@</BlockInfo>	@<EndOfBlock/>
			WebsocketMessenger.sendMessage((String)speechRecogResult);													//@<BlockInfo>jp.vstone.block.callfunc.base,352,1248,352,1248,False,94,@</BlockInfo>	@<EndOfBlock/>
			CRobotUtil.wait((int)1000);																					//@<BlockInfo>jp.vstone.block.wait,416,1248,416,1248,False,93,コメント@</BlockInfo>	@<EndOfBlock/>
			GlobalVariable.sotawish.Say((String)"ですね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);		//@<BlockInfo>jp.vstone.block.talk.say,480,1248,480,1248,False,92,@</BlockInfo>
																														//@<EndOfBlock/>
			speechRecogResult = GlobalVariable.recog.getYesorNowithAbort((int)60000 , (int)3);							//@<BlockInfo>jp.vstone.block.talk.getyesno,544,1152,736,1152,False,91,音声認識を行い、肯定/否定を取得する。取得結果はメンバー変数のspeechRecogResultに格納され、肯定なら「YES」、否定なら「NO」、聞き取り失敗なら長さ0の文字列が代入される。@</BlockInfo>
			if(speechRecogResult==null) speechRecogResult="";

			if(speechRecogResult.equals("YES"))
			{
																														//@<OutputChild>
				interest();																								//@<BlockInfo>jp.vstone.block.callfunc.base,608,1152,608,1152,False,89,@</BlockInfo>	@<EndOfBlock/>
				break;																									//@<BlockInfo>jp.vstone.block.break,672,1152,672,1152,False,88,break@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>

			}else if(speechRecogResult.equals("NO"))
			{
																														//@<OutputChild>
																														//@</OutputChild>

			}else
			{
																														//@<OutputChild>
				GlobalVariable.sotawish.Say((String)"もう一度お願いします",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,608,1344,608,1344,False,90,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>

			}
																														//@<EndOfBlock/>
																														//@</OutputChild>
		}																												//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void thankyou()																								//@<BlockInfo>jp.vstone.block.func,48,2784,176,2784,False,101,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.sotawish.Say((String)"石川さん、ＴＩＳのみなさんありがとうございました。僕はやんちゃでたくさん困らせてごめんね。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,112,2784,112,2784,False,100,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

}
