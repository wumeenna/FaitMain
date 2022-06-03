package com.faitmain.domain.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.faitmain.domain.product.domain.Product;
import com.faitmain.domain.user.domain.StoreApplicationDocument;
import com.faitmain.domain.user.domain.User;
import com.faitmain.domain.user.mapper.UserMapper;
import com.faitmain.global.common.Image;
import com.faitmain.global.common.Search;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class UserServiceImpl implements UserSerivce {

 
		
	    @Autowired
		@Qualifier("userMapper")
	 	private UserMapper userMapper ;

	    public void setUserMapper ( UserMapper userMapper ){
	        this.userMapper = userMapper;
	    }
		
		public UserServiceImpl() {
			System.out.println(this.getClass());
		}
		
		//  insert 유저	
	 	public int addUser(User user) throws Exception {
			// TODO Auto-generated method stub
			return userMapper.addUser(user);
		}

		//insert 신청서 
		public int AddStoreApplicationDocument(StoreApplicationDocument storeApplicationDocument) throws Exception {
			// TODO Auto-generated method stub
			return userMapper.addStoreApplicationDocument(storeApplicationDocument);
		}
		//insert  이미지 
		
		public int addImage(Image image)throws Exception {
			return  userMapper.addImage(image);
			
		}
		
		//SELECT  유저 상세 조회 
	 	public User getUser(User user) throws Exception {
	 		return userMapper.getUser(user);
		}
 

	 	
	 // SELECT 아이디/PW 찾기 할때 사용하는 findUser
	 	public int findUser(Map<String, Object> Map) throws Exception {
	 			// TODO Auto-generated method stub
	 			return userMapper.findUser(Map);
	 		}

		//이것은 아이디,휴대폰,닉네임,스토어네임 중복 체크시 사용 
	 	public int getchechDuplication(Map<String, Object> map) throws Exception {
			// TODO Auto-generated method stub
			return userMapper.getchechDuplicationCount(map);
		}
				 	
	 	//SELECT id로 스토어 신청서 넘버 가져오기
		public int getStoreApplicationDocumenNumber(String id ) throws Exception{
		
			return userMapper.getStoreApplicationDocumentNumber(id) ; 
		}	
		
		//SELECT 스토어 신청서 넘버로 스토어 가져오기  신청서 + 이미지 
		public StoreApplicationDocument getStoreApplicationDocument(int StoreApplicationDocumenNumber)
				throws Exception {
			// TODO Auto-generated method stub
			
			StoreApplicationDocument storeDoc = userMapper.getStoreApplicationDocument(StoreApplicationDocumenNumber);
			System.out.println( "Impl");
			List<Image> list   = userMapper.getImage(StoreApplicationDocumenNumber) ;
			System.out.println(list) ;
			storeDoc.setProductmanufacturingImage(list);
			
			System.out.println("스토어 신청서 출력 출력 "+storeDoc);
			
			return storeDoc ;
		}
		
 
		//SELECT 스토어 이미지 조회  사라질 운명 
		public List<Image> getImageList(int  storeApplicationDocumentNumber) throws Exception{
			List<Image> list ;
			list = userMapper.getImage(storeApplicationDocumentNumber) ;
			return list; 
			
		}
		
		//SELECT USER 리스트 조회
		public Map<String, Object> getUserList(Map<String,Object> map )  throws Exception{
			List<User> list ;
			list = userMapper.getUserList(map) ;
			
			int totalCount = userMapper.getUserTotalCount(map) ;
			
		
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("list", list);
			resultMap.put("totalCount", new Integer(totalCount));
			
			
			
			return resultMap; 
			
		}
		
		//SELECT 스토어 리스트 조회
		public Map<String, Object> getStoreApplicationDocumentList(Map<String,Object> map )  throws Exception{
			List<StoreApplicationDocument> list ;
			list = userMapper.getStoreApplicationDocumentList(map) ;
			int totalCount = userMapper.getStoreApplicationDocumenTotalCount(map) ;

			Map<String,Object> resultMap = new HashMap<String,Object>();
			resultMap.put("list", list);
			resultMap.put("totalCount", new Integer(totalCount));
			
			
			return resultMap; 	
		}


		////////////////////////////////UPDATE////////////////////////////////////////////////////

		 //유저 UPDATE - 유저 상태 update
	 	
	 	public int updateUser(User user) throws Exception {
	 		return userMapper.updateUser(user);
		}

	 
	 	//패스워드 재설정 
		public int updateUserPassword(User user) throws Exception {
			// TODO Auto-generated method stub
			return userMapper.updateUserPassword(user);
		}
		//  UPDATE - 스토어로 업데이트 

		public int updatUserStore(User user) throws Exception {
			// TODO Auto-generated method stub
			return userMapper.updatUserStore(user);
		}

		// UPDATE 스토어문서 상태 examination_status
		public int updateStoreApplicationDocument(StoreApplicationDocument storeApplicationDocument) throws Exception {
			// TODO Auto-generated method stub
			return userMapper.updateStoreApplicationDocument(storeApplicationDocument);
		}


		// 거의 안쓸듯
		public void deleteUser(String id ) throws Exception {
			
			userMapper.deleteUser(id) ;
		};


		public void updateWithdrawalStatus(String id) throws Exception {
	
			userMapper.updateWithdrawalStatus(id) ;

			
		}

		 

		//네이버 로그인시 토큰 가져와
	 	public String getAccessToken(String authorize_code) throws Exception {
			// TODO Auto-generated method stub
			return null;
		}

	//네이버 로그인시 아이디에 대한 정보를 가져옴 
	 	public HashMap<String, Object> getUserInfo(String access_Token) throws Exception {
			// TODO Auto-generated method stub
			return null;
		}

	 
		//인증 문자 보내기 
		public void sendCertificationSms(String userPhoneNumber, int randomNumber) throws Exception {
			// TODO Auto-generated method stub
			
		}

		//문자 인증 
		public void certifiedPhoneNumber(String userPhoneNumber, String smsCertification) throws Exception {
			// TODO Auto-generated method stub
			
		}
		
		
	}
