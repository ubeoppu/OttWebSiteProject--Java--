package com.ott.controller.action;


public class ActionFactory {

	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory() {}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		
		Action action = null;
		
		System.out.println("ActionFactory : " + command);
		
		if(command.equals("bulletin_list")) {
			action = new BulletinListAction();
		}else if(command.equals("bulletin_write_form")) {
			action = new BulletinInsertFormAction();
		}else if(command.equals("bulletin_write")) {
			action = new BulletinInsertAction();
		}else if(command.equals("bulletin_view")) {
			action = new BulletinViewAction();
		}else if(command.equals("bulletin_update_form")) {
			action = new BulletinUpdateFormAction();
		}else if(command.equals("bulletin_update")) {
			action = new BulletinUpdateAction();
		}else if(command.equals("bulletin_delete")) {
			action = new BulletinDeleteAction();
		}else if(command.equals("comment_Insert")) {
			action = new commentInsertAction();
		}
		return action;
	}
}
