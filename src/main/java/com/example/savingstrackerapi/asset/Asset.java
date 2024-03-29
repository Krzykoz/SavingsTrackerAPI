package com.example.savingstrackerapi.asset;

import com.example.savingstrackerapi.assetType.AssetType;
import com.example.savingstrackerapi.saving.Saving;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "assets")
@Getter
@Setter
public class Asset {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private String name;
  private String code;

  @OneToMany(mappedBy = "asset", cascade = CascadeType.ALL)
  List<Saving> savingList;

  @ManyToOne
  private AssetType assetType;
  @Override
  public String toString() {
    return "Asset{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", code='" + code + '\'' +
            ", savingList=" + savingList +
            '}';
  }
}
