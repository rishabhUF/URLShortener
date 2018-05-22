package com.rishabh.URLShortener.web;

import com.rishabh.URLShortener.domain.URLShortener;
import com.rishabh.URLShortener.dto.URLShortenerDTO;
import com.rishabh.URLShortener.service.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/api/url")
public class URLShortenerController {

    @Autowired
    URLService urlService;

    @RequestMapping(value = "/shorten/{longURL}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<URLShortenerDTO> URLShortenerDTO(@PathVariable(value = "longURL") String longURL)
    {
        URLShortenerDTO urlShortenerdto = urlService.saveURL(longURL);
        return new ResponseEntity<>(urlShortenerdto,HttpStatus.OK);
    }

    @RequestMapping(value = "/expand/{shortenedURL}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<URLShortenerDTO> getURL(@PathVariable(value = "shortenedURL") String shortenedURL)
    {
        URLShortenerDTO urlShortenerdto = urlService.getURL(shortenedURL);
        return new ResponseEntity<>(urlShortenerdto,HttpStatus.OK);
    }

 }
