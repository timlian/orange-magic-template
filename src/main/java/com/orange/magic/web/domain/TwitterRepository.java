package com.orange.magic.web.domain;

import com.orange.magic.web.Twitter;

public interface TwitterRepository {

  Twitter save(Twitter spitter);
  
  Twitter findByUsername(String username);

}
