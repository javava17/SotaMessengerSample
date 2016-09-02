//このソースは、VstoneMagicによって自動生成されました。
//ソースの内容を書き換えた場合、VstoneMagicで開けなくなる場合があります。
package	jp.co.mysota;
import	main.main.GlobalVariable;
import	jp.vstone.RobotLib.*;
import	jp.vstone.sotatalk.*;
import	jp.vstone.sotatalk.SpeechRecog.*;

public class Initial
{

	public String speechRecogResult;
	public jp.co.mysota.WebsocketMessenger WebsocketMessenger;
	public RecogResult recogresult;
	public jp.co.mysota.AskInterest AskInterest;
	public Initial()																									//@<BlockInfo>jp.vstone.block.func.constructor,16,16,400,16,False,5,@</BlockInfo>
	{
																														//@<OutputChild>
		/*String speechRecogResult*/;																					//@<BlockInfo>jp.vstone.block.variable,80,16,80,16,False,4,break@</BlockInfo>
																														//@<EndOfBlock/>
		WebsocketMessenger=new jp.co.mysota.WebsocketMessenger();														//@<BlockInfo>jp.vstone.block.variable,208,16,208,16,False,3,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*RecogResult recogresult*/;																					//@<BlockInfo>jp.vstone.block.variable,272,16,272,16,False,2,break@</BlockInfo>
																														//@<EndOfBlock/>
		AskInterest=new jp.co.mysota.AskInterest();																		//@<BlockInfo>jp.vstone.block.variable,336,16,336,16,False,1,break@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void age()																									//@<BlockInfo>jp.vstone.block.func,0,688,672,688,False,13,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.sotawish.Say((String)"年齢は何歳ですか？？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,64,688,64,688,False,12,@</BlockInfo>
																														//@<EndOfBlock/>
		speechRecogResult = GlobalVariable.recog.getResponsewithAbort((int)60000,(int)3);								//@<BlockInfo>jp.vstone.block.talk.speechrecog.get,144,688,144,688,False,11,音声認識して、得られた結果（文字列）をspeechRecogResultに代入します。@</BlockInfo>
		if(speechRecogResult == null) speechRecogResult = "";

																														//@<EndOfBlock/>
		WebsocketMessenger.sendMessage((String)speechRecogResult);														//@<BlockInfo>jp.vstone.block.callfunc.base,208,688,208,688,False,10,@</BlockInfo>	@<EndOfBlock/>
		CRobotUtil.wait((int)1000);																						//@<BlockInfo>jp.vstone.block.wait,272,688,272,688,False,9,コメント@</BlockInfo>	@<EndOfBlock/>
		GlobalVariable.sotawish.Say((String)"ですね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);			//@<BlockInfo>jp.vstone.block.talk.say,336,688,336,688,False,8,@</BlockInfo>
																														//@<EndOfBlock/>
		speechRecogResult = GlobalVariable.recog.getYesorNowithAbort((int)60000 , (int)3);								//@<BlockInfo>jp.vstone.block.talk.getyesno,400,592,528,592,False,7,音声認識を行い、肯定/否定を取得する。取得結果はメンバー変数のspeechRecogResultに格納され、肯定なら「YES」、否定なら「NO」、聞き取り失敗なら長さ0の文字列が代入される。@</BlockInfo>
		if(speechRecogResult==null) speechRecogResult="";

		if(speechRecogResult.equals("YES"))
		{
																														//@<OutputChild>
			budget();																									//@<BlockInfo>jp.vstone.block.callfunc.base,464,592,464,592,False,6,@</BlockInfo>	@<EndOfBlock/>
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
	public void budget()																								//@<BlockInfo>jp.vstone.block.func,0,1056,672,1056,False,21,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.sotawish.Say((String)"予算はいくらまでですか",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,64,1056,64,1056,False,20,@</BlockInfo>
																														//@<EndOfBlock/>
		speechRecogResult = GlobalVariable.recog.getResponsewithAbort((int)60000,(int)3);								//@<BlockInfo>jp.vstone.block.talk.speechrecog.get,144,1056,144,1056,False,19,音声認識して、得られた結果（文字列）をspeechRecogResultに代入します。@</BlockInfo>
		if(speechRecogResult == null) speechRecogResult = "";

																														//@<EndOfBlock/>
		WebsocketMessenger.sendMessage((String)speechRecogResult);														//@<BlockInfo>jp.vstone.block.callfunc.base,208,1056,208,1056,False,18,@</BlockInfo>	@<EndOfBlock/>
		CRobotUtil.wait((int)1000);																						//@<BlockInfo>jp.vstone.block.wait,272,1056,272,1056,False,17,コメント@</BlockInfo>	@<EndOfBlock/>
		GlobalVariable.sotawish.Say((String)"ですね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);			//@<BlockInfo>jp.vstone.block.talk.say,336,1056,336,1056,False,16,@</BlockInfo>
																														//@<EndOfBlock/>
		speechRecogResult = GlobalVariable.recog.getYesorNowithAbort((int)60000 , (int)3);								//@<BlockInfo>jp.vstone.block.talk.getyesno,400,960,528,960,False,15,音声認識を行い、肯定/否定を取得する。取得結果はメンバー変数のspeechRecogResultに格納され、肯定なら「YES」、否定なら「NO」、聞き取り失敗なら長さ0の文字列が代入される。@</BlockInfo>
		if(speechRecogResult==null) speechRecogResult="";

		if(speechRecogResult.equals("YES"))
		{
																														//@<OutputChild>
			AskInterest.Askinterest();																					//@<BlockInfo>jp.vstone.block.callfunc.base,464,960,464,960,False,14,@</BlockInfo>	@<EndOfBlock/>
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
	public void initial()																								//@<BlockInfo>jp.vstone.block.func,48,416,576,416,False,26,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		CRobotUtil.wait((int)1000);																						//@<BlockInfo>jp.vstone.block.wait,112,416,112,416,False,25,コメント@</BlockInfo>	@<EndOfBlock/>
		GlobalVariable.sotawish.Say((String)"ですか",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);			//@<BlockInfo>jp.vstone.block.talk.say,192,416,192,416,False,24,@</BlockInfo>
																														//@<EndOfBlock/>
		speechRecogResult = GlobalVariable.recog.getYesorNowithAbort((int)60000 , (int)3);								//@<BlockInfo>jp.vstone.block.talk.getyesno,304,320,432,320,False,23,音声認識を行い、肯定/否定を取得する。取得結果はメンバー変数のspeechRecogResultに格納され、肯定なら「YES」、否定なら「NO」、聞き取り失敗なら長さ0の文字列が代入される。@</BlockInfo>
		if(speechRecogResult==null) speechRecogResult="";

		if(speechRecogResult.equals("YES"))
		{
																														//@<OutputChild>
			age();																										//@<BlockInfo>jp.vstone.block.callfunc.base,368,320,368,320,False,22,@</BlockInfo>	@<EndOfBlock/>
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
	/*
	/*String speechRecogResult*/;																						//@<BlockInfo>jp.vstone.block.variable,144,80,144,80,False,30,break@</BlockInfo>
																														//@<EndOfBlock/>
	WebsocketMessenger=new jp.co.mysota.WebsocketMessenger();															//@<BlockInfo>jp.vstone.block.variable,272,80,272,80,False,29,break@</BlockInfo>
																														//@<EndOfBlock/>
	/*RecogResult recogresult*/;																						//@<BlockInfo>jp.vstone.block.variable,336,80,336,80,False,28,break@</BlockInfo>
																														//@<EndOfBlock/>
	AskInterest=new jp.co.mysota.AskInterest();																			//@<BlockInfo>jp.vstone.block.variable,400,80,400,80,False,27,break@</BlockInfo>
																														//@<EndOfBlock/>

	*/

}
