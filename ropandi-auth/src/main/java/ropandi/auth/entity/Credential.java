package ropandi.auth.entity;





import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Table(name="mst_credential")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Credential {

  @Id
  private String id;

  private String name;

  private String email;

  private String password;
  
  private Long created_at;
  private String created_by;
  private Long updated_at;
  private String updated_by;



}
