package mn.and.datacollector.entity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mn.and.datacollector.enumType.FlagEnum;
import mn.and.datacollector.enumType.FlagStatus;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "keyword")
public class Keyword extends PanacheEntityBase {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "", length = 255, nullable = false)
  private Industry industry;

  @Column(name = "keyword", length = 255, nullable = false)
  private String keyword;

  @Column(name = "status", columnDefinition = "ENUM('ACTIVE', 'INACTIVE')", nullable = false)
  private FlagStatus status;

  @Column(name = "flag", columnDefinition = "ENUM('REGULAR', 'WHITE', 'GRAY', 'BLACK')", nullable = false)
  private FlagEnum flag;

  @Column(name = "flag_order", nullable = false)
  private int flagOrder;

  @UpdateTimestamp
  @Column(name = "updated_at", columnDefinition = "datetime(6)")
  private Instant updatedAt;

  @CreationTimestamp
  @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "datetime(6)")
  private Instant createdAt;

}