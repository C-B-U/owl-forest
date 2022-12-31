package com.cbu.backend.member.dto.response;

public class MemberView {
  public static class Normal {}

  public static class Admin extends Normal {}

  public static class NormalExtra extends Normal {}

  public static class AdminExtra extends NormalExtra {}

  public static class MyselfExtra extends AdminExtra {}
}
