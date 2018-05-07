package com.fgoa.web.constant;

public abstract interface StatusConstant
{
  public static abstract interface LeaveApproveStatus
  {
    public static final int APPLY = 0;
    public static final int APPROVE = 1;
    public static final int REJECT = 2;
  }
  
  public static abstract interface YesOrNo
  {
    public static final int YES = 0;
    public static final int NO = 1;
  }
  
  public static abstract interface PetitionStatus
  {
    public static final int BACKLOG = 0;
    public static final int ARCHIVE = 1;
    public static final int LEADER_REAMRKED = 2;
    public static final int LEADER_DISTRIBUTE = 3;
  }
  
  public static abstract interface PostStatus
  {
    public static final int AUDIT = 0;
    public static final int SECTION_AUDITING = 1;
    public static final int VICE_DIRECTOR_AUDITING = 2;
    public static final int DIRECTOR_AUDITING = 3;
    public static final int REJECT = 4;
    public static final int COMPLETE = 5;
  }
  
  public static abstract interface InboxStatus
  {
    public static final int BACKLOG = 0;
    public static final int ARCHIVE = 1;
    public static final int LEADER_REAMRKED = 2;
    public static final int LEADER_DISTRIBUTE = 3;
  }
}


/* Location:              C:\Users\Administrator\Desktop\base\!\com\fgoa\web\constant\StatusConstant.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */