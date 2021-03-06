/*
 * Copyright 2016 ELIXIR EBI
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eu.elixir.ega.ebi.downloader.domain.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author asenf
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "download_log")
public class DownloadLog implements Serializable {
        
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @NotNull
        @Column(name="download_log_id", nullable=false)
        private Long downloadLogId;
        
        @NotNull
        @Size(max=45)
        @Column(name="client_ip", nullable=false, length=45)
        private String clientIp;
        
        @NotNull
        @Size(max=45)
        @Column(nullable=false, length=45)
        private String server;
        
        @NotNull
        @Size(max=256)
        @Column(name="user_email", nullable=false, length=256)
        private String userEmail;
        
        @NotNull
        @Size(max=15)
        @Column(name="fileStableId", nullable=false, length=15)        
        private String fileStableId;
        
        @NotNull
        @Column(name="download_speed", nullable=false)
        private double downloadSpeed;
        
        @NotNull
        @Size(max=256)
        @Column(name="download_status", nullable=false, length=256)
        private String downloadStatus;

        @NotNull
        @Size(max=256)
        @Column(name="download_protocol", nullable=false, length=256)
        private String downloadProtocol;
        
        @NotNull
        @Size(max=256)
        @Column(name="encryption_type", nullable=false, length=256)
        private String encryptionType;
        
        @NotNull
        @Column(nullable=false)
        private Timestamp created;
        
        
        /*
         * 
         */
        public String toString() {
            String line = "";
            
            line += "ID: " + downloadLogId + "\n" +
                    "Client IP: " + clientIp + "\n" +
                    "Server: " + server + "\n" +
                    "User Email: " + userEmail + "\n" +
                    "File Stable ID: " + fileStableId + "\n" +
                    "Download Speed: " + downloadSpeed + "\n" +
                    "Download Status: " + downloadStatus + "\n" +
                    "Download Protocol: " + downloadProtocol + "\n" +
                    "Encryption Type: " + encryptionType + "\n" +
                    "Created: " + created.toString();

            return line;
        }
        
}
