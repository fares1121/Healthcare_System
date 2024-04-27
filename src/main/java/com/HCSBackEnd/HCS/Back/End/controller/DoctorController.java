package com.HCSBackEnd.HCS.Back.End.controller;

import com.HCSBackEnd.HCS.Back.End.dto.DoctorDto;
import com.HCSBackEnd.HCS.Back.End.security.config.auth.User;
import com.HCSBackEnd.HCS.Back.End.service.Doctorservice;
import com.HCSBackEnd.HCS.Back.End.security.config.auth.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Locale;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import java.io.UnsupportedEncodingException;
import org.springframework.ui.ModelMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties.Credential;

import com.HCSBackEnd.HCS.Back.End.security.config.auth.UserDto;
import com.HCSBackEnd.HCS.Back.End.security.config.auth.CredentialsDto;
import com.HCSBackEnd.util.GenericResponse;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/doctor")
public class DoctorController {

    private Doctorservice doctorservice;
    @Autowired
    private UserService userService;

    // Build add Doctor API
    @PostMapping
    public ResponseEntity<DoctorDto> createDoctor(@RequestBody DoctorDto doctorDto) {
        DoctorDto saveDoctor = doctorservice.createDoctor(doctorDto);
        return new ResponseEntity<>(saveDoctor, HttpStatus.CREATED);
    }

    // Get Doctor Method
    @GetMapping("{id}")
    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable("id") Long doctorId) {
        DoctorDto doctorDto = doctorservice.getDoctorById(doctorId);
        return ResponseEntity.ok(doctorDto);
    }

    // Get ALL Doctors
    @GetMapping("doctors")
    public ResponseEntity<List<DoctorDto>> getAllDoctors() {
        List<DoctorDto> doctors = doctorservice.getAllDoctor();
        return ResponseEntity.ok(doctors);
    }

    // Update Doctor API
    @PutMapping("{id}")
    public ResponseEntity<DoctorDto> updateDoctor(@PathVariable("id") Long doctorId,
            @RequestBody DoctorDto updatedDoctor) {
        DoctorDto doctorDto = doctorservice.updateDoctor(doctorId, updatedDoctor);
        return ResponseEntity.ok(doctorDto);
    }

    // Delete Rest API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable("id") Long doctorId) {
        doctorservice.deleteDoctor(doctorId);
        return ResponseEntity.ok("Doctor deleted successfully!");
    }

    @GetMapping("/registrationConfirm")
    public String confirmRegistration(final HttpServletRequest request, final ModelMap model,
            @RequestParam("login") final CredentialsDto login) throws UnsupportedEncodingException {
        Locale locale = request.getLocale();
        model.addAttribute("lang", locale.getLanguage());
        User user = userService.loginUser(login);
        model.addAttribute("qr", userService.generateQRUrl(user));
        return "redirect:/qrcode.html";
    }

    @PostMapping("/update/2fa")
    public GenericResponse modifyUser2FA(@RequestParam("use2FA") final boolean use2FA)
            throws UnsupportedEncodingException {
        final User user = userService.updateUser2FA(use2FA);
        if (use2FA) {
            return new GenericResponse(userService.generateQRUrl(user));
        }
        return null;
    }
}
