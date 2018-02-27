package com.beads.model.domain;

import com.beads.model.constant.CommentStatus;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="product_comment")
public class ProductComment {

  public static final String STATUS = "status";

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @OneToOne(fetch= FetchType.LAZY)
  @JoinColumn(name = "product_id")
  private Product product;

  @Column(name = "comment")
  private String comment;

  @Column(name = "disadvantages")
  private String disadvantages;

  @Column(name = "advantages")
  private String advantages;

  @Column(name = "create_date", columnDefinition = "timestamp")
  private LocalDateTime createDate = LocalDateTime.now();

  @Enumerated(EnumType.STRING)
  @Column(name = "status", columnDefinition = "ENUM('VISIBLE', 'INVISIBLE')")
  private CommentStatus status = CommentStatus.INVISIBLE;

  @Column(name = "rating", columnDefinition = "tinyint")
  private Integer rating;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getDisadvantages() {
    return disadvantages;
  }

  public void setDisadvantages(String disadvantages) {
    this.disadvantages = disadvantages;
  }

  public String getAdvantages() {
    return advantages;
  }

  public void setAdvantages(String advantages) {
    this.advantages = advantages;
  }

  public LocalDateTime getCreateDate() {
    return createDate;
  }

  public void setCreateDate(LocalDateTime createDate) {
    this.createDate = createDate;
  }

  public CommentStatus getStatus() {
    return status;
  }

  public void setStatus(CommentStatus status) {
    this.status = status;
  }

  public Integer getRating() {
    return rating;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ProductComment that = (ProductComment) o;
    return Objects.equal(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", id)
        .add("product", product)
        .add("comment", comment)
        .add("disadvantages", disadvantages)
        .add("advantages", advantages)
        .add("createDate", createDate)
        .add("status", status)
        .add("rating", rating)
        .toString();
  }
}
