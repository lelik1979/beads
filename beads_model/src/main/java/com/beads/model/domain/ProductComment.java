package com.beads.model.domain;

import com.beads.model.constant.CommentStatus;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name="product_comment")
public class ProductComment {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  @Column(name = "id")
  private Integer id;

  @OneToOne
  @JoinColumn(name = "product_id")
  private Product product;

  @Column(name = "comment")
  private String comment;

  @Column(name = "disadvantages")
  private String disadvantages;

  @Column(name = "dignity")
  private String dignity;

  @Column(name = "create_date", columnDefinition = "timestamp")
  private LocalDateTime createDate = LocalDateTime.now();

  @Enumerated(EnumType.STRING)
  @Column(name = "status", columnDefinition = "ENUM('VISIBLE', 'INVISIBLE')")
  private CommentStatus status = CommentStatus.INVISIBLE;

  @Column(name = "rating")
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

  public String getDignity() {
    return dignity;
  }

  public void setDignity(String dignity) {
    this.dignity = dignity;
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

    return new EqualsBuilder()
        .append(id, that.id)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(id)
        .toHashCode();
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("product", product)
        .append("comment", comment)
        .append("disadvantages", disadvantages)
        .append("dignity", dignity)
        .append("createDate", createDate)
        .append("status", status)
        .append("rating", rating)
        .toString();
  }
}
