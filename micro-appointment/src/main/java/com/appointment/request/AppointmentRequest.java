package com.appointment.request;

public class AppointmentRequest {
	private long aid;
		

		private long did;
		

		private long pid;
		private String date;
		private String time;
		public long getAid() {
			return aid;
		}
		public void setAid(long aid) {
			this.aid = aid;
		}
		public long getDid() {
			return did;
		}
		public void setDid(long did) {
			this.did = did;
		}
		public long getPid() {
			return pid;
		}
		public void setPid(long pid) {
			this.pid = pid;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		
		
		
}

