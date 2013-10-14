package com.depich1987.wsih.web;
import com.depich1987.wsih.domain.WSMeeting;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/wsmeetings")
@Controller
@RooWebScaffold(path = "wsmeetings", formBackingObject = WSMeeting.class)
public class MeetingController {
}
