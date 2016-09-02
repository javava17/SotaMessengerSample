//このソースは、VstoneMagicによって自動生成されました。
//ソースの内容を書き換えた場合、VstoneMagicで開けなくなる場合があります。
package	jp.co.mysota;
import	main.main.GlobalVariable;
import	jp.vstone.RobotLib.*;
import	jp.vstone.sotatalk.*;
import	jp.vstone.sotatalk.SpeechRecog.*;

public class End
{

	public End()																										//@<BlockInfo>jp.vstone.block.func.constructor,16,16,80,16,False,1,@</BlockInfo>
	{
																														//@<OutputChild>
																														//@</OutputChild>
	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void end()																									//@<BlockInfo>jp.vstone.block.func,32,224,160,224,False,3,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.sotawish.Say((String)"いいプレゼントが見つかってよかった",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,96,224,96,224,False,2,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

}
