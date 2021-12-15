package com.highradius.db;

public class test_data {
	
		private int id;
		private String file_name;

		public String getFile_name() {
			return file_name;
		}


		public void setFile_name(String file_name) {
			this.file_name = file_name;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}
		
		@Override
		public String toString() {
			return "test_deba{" +
					"id="+id+", file_name='" +file_name+'\''
					+'}';
		}
		

}
