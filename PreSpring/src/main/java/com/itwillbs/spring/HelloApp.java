package com.itwillbs.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class HelloApp {

	public static void main(String[] args) {
		
		// 데이터 저장 --> 변수
		// 실행문 저장 --> 메서드
		
		// 변수 + 메서드 --> 객체
		
		// "안녕하세요!" 출력
		System.out.println("안녕하세요!");
		
		// -----------
		
		// MsgBean 객체를 생성 - 메서드 호출
		// --> 강한 결합
		//   --> HelloApp은 (출력하기위해서) MsgBean 필요함
		//     --> HelloApp은 (출력하기위해서) MsgBean 없으면 안됨
		//       --> HelloApp은 (출력하기위해서) MsgBean 의존하고 있음
		
		MsgBean mb = new MsgBean();
		mb.sayHello("아이티윌");
		
		System.out.println("------------------------------------------------");
		////////////////////////////////////////////////////////////////////////////////
		
		// MsgBeanKr 객체 생성 - 메서드 호출
		MsgBeanKr mbkr = new MsgBeanKr();
		mbkr.sayHello(" 아이티윌 kr ");
		
		// 약한결합 : 인터페이스 객체에 업캐스팅된 객체를 사용
		MsgBeanI mbi1 = new MsgBeanKr();
		mbi1.sayHello(" 아이티윌 i ");
		
		System.out.println("--------------- 자바에서의 강한/약한 결합 ---------------");
		////////////////////////////////////////////////////////////////////////////////
		
		
		// 스프링을 사용한 약한 결합
		
		// beans.xml 파일의 정보 가져오기
		/*BeanFactory factory 
			= new XmlBeanFactory(new FileSystemResource("beans.xml"));
		System.out.println(" factory : "+factory);*/
		// --> 생략 (자동 호출)
		
		// MsgBeanI 객체 생성 (X)
		// --> 객체 정보를 가져와서 사용 --> 의존관계 객체 주입
		// MsgBeanI mbi2 = (MsgBeanI) factory.getBean("mbi"); // (다운캐스팅)오브젝트
		/*MsgBeanI mbi2 = factory.getBean("mbi",MsgBeanI.class);
		mbi2.sayHello(" mbi2 ");*/
		
		/*@Inject @Autowired
		private MsgBeanI mbi3;
		mbi3.sayHello(" mbi3 ");*/
		// --> 최종 형태 : 약한 결합의 관계 객체를 의존관계주입을
		// 				   @Inject 사용해서 객체를 주입받아서 처리
		
		
	}

}
