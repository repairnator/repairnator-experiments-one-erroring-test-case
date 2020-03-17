-- dit is voor de H2 database die tijdens unit tests wordt gebruikt

    alter table automatisch_proces_config 
        drop constraint FK39F3573E561B9F9B;

    alter table bericht 
        drop constraint bericht_laadprocesid_fkey;

    alter table gebruiker_groepen 
        drop constraint FKD875A48F49E041F8;

    alter table gebruiker_groepen 
        drop constraint FKD875A48FD741C965;

    alter table laadproces 
        drop constraint FK8C420DCE3DA16A8;

    drop table automatisch_proces if exists;

    drop table automatisch_proces_config if exists;

    drop table bericht if exists;

    drop table job if exists;

    drop table gebruiker_ if exists;

    drop table gebruiker_groepen if exists;

    drop table groep_ if exists;

    drop table laadproces if exists;

    create table automatisch_proces (
        dtype varchar(255) not null,
        id bigint generated by default as identity,
        cron_expressie varchar(255),
        lastrun timestamp,
        logfile clob,
        samenvatting clob,
        status varchar(255),
        primary key (id)
    );

    create table automatisch_proces_config (
        proces_id bigint not null,
        value clob,
        config_key varchar(255),
        primary key (proces_id, config_key)
    );

    create table bericht (
        id bigint generated by default as identity,
        br_orgineel_xml clob,
        br_xml clob,
        datum timestamp,
        db_xml clob,
        job_id varchar(255),
        object_ref varchar(255),
        opmerking clob,
        soort varchar(255),
        status varchar(255),
        status_datum timestamp,
        volgordenummer integer,
        xsl_version varchar(255),
        laadprocesid bigint,
        primary key (id)
    );

    create table gebruiker_ (
        gebruikersnaam varchar(255) not null,
        wachtwoord varchar(255),
        primary key (gebruikersnaam)
    );

    create table gebruiker_groepen (
        gebruikersnaam varchar(255) not null,
        groep_ varchar(255) not null,
        primary key (gebruikersnaam, groep_)
    );

    create table groep_ (
        naam varchar(255) not null,
        beschrijving clob,
        primary key (naam)
    );

    create table laadproces (
        id bigint generated by default as identity,
        bestand_datum timestamp,
        bestand_naam varchar(255),
        contact_email varchar(255),
        gebied varchar(255),
        opmerking clob,
        soort varchar(255),
        status varchar(255),
        status_datum timestamp,
        automatisch_proces bigint,
        primary key (id)
    );

    create table job (
        jid bigint generated by default as identity,
        id bigint,
        br_xml clob,
        datum timestamp,
        object_ref varchar(255),
        soort varchar(255),
        volgordenummer integer,
        primary key (jid)
    );

    alter table automatisch_proces_config 
        add constraint FK39F3573E561B9F9B 
        foreign key (proces_id) 
        references automatisch_proces;

    alter table bericht 
        add constraint bericht_laadprocesid_fkey 
        foreign key (laadprocesid) 
        references laadproces;

    alter table gebruiker_groepen 
        add constraint FKD875A48F49E041F8 
        foreign key (gebruikersnaam) 
        references gebruiker_;

    alter table gebruiker_groepen 
        add constraint FKD875A48FD741C965 
        foreign key (groep_) 
        references groep_;

    alter table laadproces 
        add constraint FK8C420DCE3DA16A8 
        foreign key (automatisch_proces) 
        references automatisch_proces;
