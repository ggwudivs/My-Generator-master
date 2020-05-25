package cn.org.chtf.card.common.utils;


import java.util.Map;

import cn.org.chtf.card.common.enums.ResultFailureEnum;
import cn.org.chtf.card.common.vo.ResultVO;

public class ResultVOUtil {
    
	public static <T> ResultVO success(T object) {
		ResultVO<T> resultVO = new ResultVO<>();
		resultVO.setCode(200);
		resultVO.setMsg("成功");
		resultVO.setData(object);
		return resultVO;
	}
	
    public static <T> ResultVO success(T object, int count) {
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setCode(200);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        resultVO.setCount(count);
        return resultVO;
    }
    
    public static ResultVO success() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(200);
        resultVO.setMsg("成功");
        return resultVO;
    }
    
    public static ResultVO failure(ResultFailureEnum resultEnum) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(500);
        resultVO.setMsg(resultEnum.getMsg());
        return resultVO;
    }
    
    /**
	 * 调整分页信息
	 * @param map
	 * @return
	 */
    public static Map<String,Object> TiaoZhengFenYe(Map<String,Object> map){
    	String page = "";
    	if(map.containsKey("page")){
    		page = map.get("page").toString();
    	}else{
    		page = "1";
    	}
    	
    	String size = "";
    	if(map.containsKey("limit")){
    		size = map.get("limit").toString();
    	}else{
    		size = "10";
    	}
		
		Integer a = (Integer.valueOf(page)-1)*Integer.valueOf(size);
		map.put("index", a);
		map.put("size",Integer.valueOf(size));
    	return map;
    	
    } 
    
}
