// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.depich1987.wsih.web;

import com.depich1987.wsih.domain.WSBudgetAccount;
import com.depich1987.wsih.domain.WSCashAccount;
import com.depich1987.wsih.domain.WSDepartment;
import com.depich1987.wsih.domain.WSHealthCare;
import com.depich1987.wsih.domain.WSHealthCareType;
import com.depich1987.wsih.domain.WSHospital;
import com.depich1987.wsih.domain.WSInsuranceCompany;
import com.depich1987.wsih.domain.WSInsuranceProduct;
import com.depich1987.wsih.domain.WSJob;
import com.depich1987.wsih.domain.WSMedecine;
import com.depich1987.wsih.domain.WSMedecineType;
import com.depich1987.wsih.domain.WSMeeting;
import com.depich1987.wsih.domain.WSPatient;
import com.depich1987.wsih.domain.WSPricing;
import com.depich1987.wsih.domain.WSStockPile;
import com.depich1987.wsih.domain.WSUser;
import com.depich1987.wsih.web.ApplicationConversionServiceFactoryBean;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;

privileged aspect ApplicationConversionServiceFactoryBean_Roo_ConversionService {
    
    declare @type: ApplicationConversionServiceFactoryBean: @Configurable;
    
    public Converter<WSBudgetAccount, String> ApplicationConversionServiceFactoryBean.getWSBudgetAccountToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.depich1987.wsih.domain.WSBudgetAccount, java.lang.String>() {
            public String convert(WSBudgetAccount wSBudgetAccount) {
                return new StringBuilder().append(wSBudgetAccount.getName()).append(' ').append(wSBudgetAccount.getAccountNumber()).append(' ').append(wSBudgetAccount.getNature()).append(' ').append(wSBudgetAccount.getDescription()).toString();
            }
        };
    }
    
    public Converter<Long, WSBudgetAccount> ApplicationConversionServiceFactoryBean.getIdToWSBudgetAccountConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.depich1987.wsih.domain.WSBudgetAccount>() {
            public com.depich1987.wsih.domain.WSBudgetAccount convert(java.lang.Long id) {
                return WSBudgetAccount.findWSBudgetAccount(id);
            }
        };
    }
    
    public Converter<String, WSBudgetAccount> ApplicationConversionServiceFactoryBean.getStringToWSBudgetAccountConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.depich1987.wsih.domain.WSBudgetAccount>() {
            public com.depich1987.wsih.domain.WSBudgetAccount convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), WSBudgetAccount.class);
            }
        };
    }
    
    public Converter<WSCashAccount, String> ApplicationConversionServiceFactoryBean.getWSCashAccountToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.depich1987.wsih.domain.WSCashAccount, java.lang.String>() {
            public String convert(WSCashAccount wSCashAccount) {
                return new StringBuilder().append(wSCashAccount.getName()).append(' ').append(wSCashAccount.getAccountNumber()).toString();
            }
        };
    }
    
    public Converter<Long, WSCashAccount> ApplicationConversionServiceFactoryBean.getIdToWSCashAccountConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.depich1987.wsih.domain.WSCashAccount>() {
            public com.depich1987.wsih.domain.WSCashAccount convert(java.lang.Long id) {
                return WSCashAccount.findWSCashAccount(id);
            }
        };
    }
    
    public Converter<String, WSCashAccount> ApplicationConversionServiceFactoryBean.getStringToWSCashAccountConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.depich1987.wsih.domain.WSCashAccount>() {
            public com.depich1987.wsih.domain.WSCashAccount convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), WSCashAccount.class);
            }
        };
    }
    
    public Converter<WSDepartment, String> ApplicationConversionServiceFactoryBean.getWSDepartmentToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.depich1987.wsih.domain.WSDepartment, java.lang.String>() {
            public String convert(WSDepartment wSDepartment) {
                return new StringBuilder().append(wSDepartment.getName()).append(' ').append(wSDepartment.getDescription()).append(' ').append(wSDepartment.getDepartmentType()).toString();
            }
        };
    }
    
    public Converter<Long, WSDepartment> ApplicationConversionServiceFactoryBean.getIdToWSDepartmentConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.depich1987.wsih.domain.WSDepartment>() {
            public com.depich1987.wsih.domain.WSDepartment convert(java.lang.Long id) {
                return WSDepartment.findWSDepartment(id);
            }
        };
    }
    
    public Converter<String, WSDepartment> ApplicationConversionServiceFactoryBean.getStringToWSDepartmentConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.depich1987.wsih.domain.WSDepartment>() {
            public com.depich1987.wsih.domain.WSDepartment convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), WSDepartment.class);
            }
        };
    }
    
    public Converter<WSHealthCare, String> ApplicationConversionServiceFactoryBean.getWSHealthCareToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.depich1987.wsih.domain.WSHealthCare, java.lang.String>() {
            public String convert(WSHealthCare wSHealthCare) {
                return new StringBuilder().append(wSHealthCare.getName()).append(' ').append(wSHealthCare.getPrice()).append(' ').append(wSHealthCare.getHospitalPart()).append(' ').append(wSHealthCare.getDoctorPart()).toString();
            }
        };
    }
    
    public Converter<Long, WSHealthCare> ApplicationConversionServiceFactoryBean.getIdToWSHealthCareConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.depich1987.wsih.domain.WSHealthCare>() {
            public com.depich1987.wsih.domain.WSHealthCare convert(java.lang.Long id) {
                return WSHealthCare.findWSHealthCare(id);
            }
        };
    }
    
    public Converter<String, WSHealthCare> ApplicationConversionServiceFactoryBean.getStringToWSHealthCareConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.depich1987.wsih.domain.WSHealthCare>() {
            public com.depich1987.wsih.domain.WSHealthCare convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), WSHealthCare.class);
            }
        };
    }
    
    public Converter<WSHealthCareType, String> ApplicationConversionServiceFactoryBean.getWSHealthCareTypeToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.depich1987.wsih.domain.WSHealthCareType, java.lang.String>() {
            public String convert(WSHealthCareType wSHealthCareType) {
                return new StringBuilder().append(wSHealthCareType.getName()).append(' ').append(wSHealthCareType.getDescription()).append(' ').append(wSHealthCareType.getColorPicker()).toString();
            }
        };
    }
    
    public Converter<Long, WSHealthCareType> ApplicationConversionServiceFactoryBean.getIdToWSHealthCareTypeConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.depich1987.wsih.domain.WSHealthCareType>() {
            public com.depich1987.wsih.domain.WSHealthCareType convert(java.lang.Long id) {
                return WSHealthCareType.findWSHealthCareType(id);
            }
        };
    }
    
    public Converter<String, WSHealthCareType> ApplicationConversionServiceFactoryBean.getStringToWSHealthCareTypeConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.depich1987.wsih.domain.WSHealthCareType>() {
            public com.depich1987.wsih.domain.WSHealthCareType convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), WSHealthCareType.class);
            }
        };
    }
    
    public Converter<WSHospital, String> ApplicationConversionServiceFactoryBean.getWSHospitalToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.depich1987.wsih.domain.WSHospital, java.lang.String>() {
            public String convert(WSHospital wSHospital) {
                return new StringBuilder().append(wSHospital.getName()).append(' ').append(wSHospital.getEmail()).append(' ').append(wSHospital.getPhoneNumber()).append(' ').append(wSHospital.getCity()).toString();
            }
        };
    }
    
    public Converter<Long, WSHospital> ApplicationConversionServiceFactoryBean.getIdToWSHospitalConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.depich1987.wsih.domain.WSHospital>() {
            public com.depich1987.wsih.domain.WSHospital convert(java.lang.Long id) {
                return WSHospital.findWSHospital(id);
            }
        };
    }
    
    public Converter<String, WSHospital> ApplicationConversionServiceFactoryBean.getStringToWSHospitalConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.depich1987.wsih.domain.WSHospital>() {
            public com.depich1987.wsih.domain.WSHospital convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), WSHospital.class);
            }
        };
    }
    
    public Converter<WSInsuranceCompany, String> ApplicationConversionServiceFactoryBean.getWSInsuranceCompanyToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.depich1987.wsih.domain.WSInsuranceCompany, java.lang.String>() {
            public String convert(WSInsuranceCompany wSInsuranceCompany) {
                return new StringBuilder().append(wSInsuranceCompany.getCompanyName()).append(' ').append(wSInsuranceCompany.getContact()).append(' ').append(wSInsuranceCompany.getEmail()).toString();
            }
        };
    }
    
    public Converter<Long, WSInsuranceCompany> ApplicationConversionServiceFactoryBean.getIdToWSInsuranceCompanyConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.depich1987.wsih.domain.WSInsuranceCompany>() {
            public com.depich1987.wsih.domain.WSInsuranceCompany convert(java.lang.Long id) {
                return WSInsuranceCompany.findWSInsuranceCompany(id);
            }
        };
    }
    
    public Converter<String, WSInsuranceCompany> ApplicationConversionServiceFactoryBean.getStringToWSInsuranceCompanyConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.depich1987.wsih.domain.WSInsuranceCompany>() {
            public com.depich1987.wsih.domain.WSInsuranceCompany convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), WSInsuranceCompany.class);
            }
        };
    }
    
    public Converter<WSInsuranceProduct, String> ApplicationConversionServiceFactoryBean.getWSInsuranceProductToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.depich1987.wsih.domain.WSInsuranceProduct, java.lang.String>() {
            public String convert(WSInsuranceProduct wSInsuranceProduct) {
                return new StringBuilder().append(wSInsuranceProduct.getName()).append(' ').append(wSInsuranceProduct.getContact()).toString();
            }
        };
    }
    
    public Converter<Long, WSInsuranceProduct> ApplicationConversionServiceFactoryBean.getIdToWSInsuranceProductConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.depich1987.wsih.domain.WSInsuranceProduct>() {
            public com.depich1987.wsih.domain.WSInsuranceProduct convert(java.lang.Long id) {
                return WSInsuranceProduct.findWSInsuranceProduct(id);
            }
        };
    }
    
    public Converter<String, WSInsuranceProduct> ApplicationConversionServiceFactoryBean.getStringToWSInsuranceProductConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.depich1987.wsih.domain.WSInsuranceProduct>() {
            public com.depich1987.wsih.domain.WSInsuranceProduct convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), WSInsuranceProduct.class);
            }
        };
    }
    
    public Converter<WSJob, String> ApplicationConversionServiceFactoryBean.getWSJobToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.depich1987.wsih.domain.WSJob, java.lang.String>() {
            public String convert(WSJob wSJob) {
                return new StringBuilder().append(wSJob.getName()).append(' ').append(wSJob.getDescription()).toString();
            }
        };
    }
    
    public Converter<Long, WSJob> ApplicationConversionServiceFactoryBean.getIdToWSJobConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.depich1987.wsih.domain.WSJob>() {
            public com.depich1987.wsih.domain.WSJob convert(java.lang.Long id) {
                return WSJob.findWSJob(id);
            }
        };
    }
    
    public Converter<String, WSJob> ApplicationConversionServiceFactoryBean.getStringToWSJobConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.depich1987.wsih.domain.WSJob>() {
            public com.depich1987.wsih.domain.WSJob convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), WSJob.class);
            }
        };
    }
    
    public Converter<WSMedecine, String> ApplicationConversionServiceFactoryBean.getWSMedecineToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.depich1987.wsih.domain.WSMedecine, java.lang.String>() {
            public String convert(WSMedecine wSMedecine) {
                return new StringBuilder().append(wSMedecine.getName()).append(' ').append(wSMedecine.getLowerQuantity()).append(' ').append(wSMedecine.getCurrentStock()).append(' ').append(wSMedecine.getCreatedBy()).toString();
            }
        };
    }
    
    public Converter<Long, WSMedecine> ApplicationConversionServiceFactoryBean.getIdToWSMedecineConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.depich1987.wsih.domain.WSMedecine>() {
            public com.depich1987.wsih.domain.WSMedecine convert(java.lang.Long id) {
                return WSMedecine.findWSMedecine(id);
            }
        };
    }
    
    public Converter<String, WSMedecine> ApplicationConversionServiceFactoryBean.getStringToWSMedecineConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.depich1987.wsih.domain.WSMedecine>() {
            public com.depich1987.wsih.domain.WSMedecine convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), WSMedecine.class);
            }
        };
    }
    
    public Converter<WSMedecineType, String> ApplicationConversionServiceFactoryBean.getWSMedecineTypeToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.depich1987.wsih.domain.WSMedecineType, java.lang.String>() {
            public String convert(WSMedecineType wSMedecineType) {
                return new StringBuilder().append(wSMedecineType.getName()).append(' ').append(wSMedecineType.getDescription()).toString();
            }
        };
    }
    
    public Converter<Long, WSMedecineType> ApplicationConversionServiceFactoryBean.getIdToWSMedecineTypeConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.depich1987.wsih.domain.WSMedecineType>() {
            public com.depich1987.wsih.domain.WSMedecineType convert(java.lang.Long id) {
                return WSMedecineType.findWSMedecineType(id);
            }
        };
    }
    
    public Converter<String, WSMedecineType> ApplicationConversionServiceFactoryBean.getStringToWSMedecineTypeConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.depich1987.wsih.domain.WSMedecineType>() {
            public com.depich1987.wsih.domain.WSMedecineType convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), WSMedecineType.class);
            }
        };
    }
    
    public Converter<WSMeeting, String> ApplicationConversionServiceFactoryBean.getWSMeetingToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.depich1987.wsih.domain.WSMeeting, java.lang.String>() {
            public String convert(WSMeeting wSMeeting) {
                return new StringBuilder().append(wSMeeting.getDescription()).append(' ').append(wSMeeting.getMeetingDate()).append(' ').append(wSMeeting.getCreationDate()).append(' ').append(wSMeeting.getCreatedBy()).toString();
            }
        };
    }
    
    public Converter<Long, WSMeeting> ApplicationConversionServiceFactoryBean.getIdToWSMeetingConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.depich1987.wsih.domain.WSMeeting>() {
            public com.depich1987.wsih.domain.WSMeeting convert(java.lang.Long id) {
                return WSMeeting.findWSMeeting(id);
            }
        };
    }
    
    public Converter<String, WSMeeting> ApplicationConversionServiceFactoryBean.getStringToWSMeetingConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.depich1987.wsih.domain.WSMeeting>() {
            public com.depich1987.wsih.domain.WSMeeting convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), WSMeeting.class);
            }
        };
    }
    
    public Converter<WSPatient, String> ApplicationConversionServiceFactoryBean.getWSPatientToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.depich1987.wsih.domain.WSPatient, java.lang.String>() {
            public String convert(WSPatient wSPatient) {
                return new StringBuilder().append(wSPatient.getFolderRegistrationId()).append(' ').append(wSPatient.getCivility()).append(' ').append(wSPatient.getFirstName()).append(' ').append(wSPatient.getLastName()).toString();
            }
        };
    }
    
    public Converter<Long, WSPatient> ApplicationConversionServiceFactoryBean.getIdToWSPatientConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.depich1987.wsih.domain.WSPatient>() {
            public com.depich1987.wsih.domain.WSPatient convert(java.lang.Long id) {
                return WSPatient.findWSPatient(id);
            }
        };
    }
    
    public Converter<String, WSPatient> ApplicationConversionServiceFactoryBean.getStringToWSPatientConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.depich1987.wsih.domain.WSPatient>() {
            public com.depich1987.wsih.domain.WSPatient convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), WSPatient.class);
            }
        };
    }
    
    public Converter<WSPricing, String> ApplicationConversionServiceFactoryBean.getWSPricingToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.depich1987.wsih.domain.WSPricing, java.lang.String>() {
            public String convert(WSPricing wSPricing) {
                return new StringBuilder().append(wSPricing.getPrice()).append(' ').append(wSPricing.getInsuranceRate()).append(' ').append(wSPricing.getRateBNC()).append(' ').append(wSPricing.getVatRate()).toString();
            }
        };
    }
    
    public Converter<Long, WSPricing> ApplicationConversionServiceFactoryBean.getIdToWSPricingConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.depich1987.wsih.domain.WSPricing>() {
            public com.depich1987.wsih.domain.WSPricing convert(java.lang.Long id) {
                return WSPricing.findWSPricing(id);
            }
        };
    }
    
    public Converter<String, WSPricing> ApplicationConversionServiceFactoryBean.getStringToWSPricingConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.depich1987.wsih.domain.WSPricing>() {
            public com.depich1987.wsih.domain.WSPricing convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), WSPricing.class);
            }
        };
    }
    
    public Converter<WSStockPile, String> ApplicationConversionServiceFactoryBean.getWSStockPileToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.depich1987.wsih.domain.WSStockPile, java.lang.String>() {
            public String convert(WSStockPile wSStockPile) {
                return new StringBuilder().append(wSStockPile.getDescription()).append(' ').append(wSStockPile.getQuantity()).append(' ').append(wSStockPile.getCreationDate()).append(' ').append(wSStockPile.getCreatedBy()).toString();
            }
        };
    }
    
    public Converter<Long, WSStockPile> ApplicationConversionServiceFactoryBean.getIdToWSStockPileConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.depich1987.wsih.domain.WSStockPile>() {
            public com.depich1987.wsih.domain.WSStockPile convert(java.lang.Long id) {
                return WSStockPile.findWSStockPile(id);
            }
        };
    }
    
    public Converter<String, WSStockPile> ApplicationConversionServiceFactoryBean.getStringToWSStockPileConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.depich1987.wsih.domain.WSStockPile>() {
            public com.depich1987.wsih.domain.WSStockPile convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), WSStockPile.class);
            }
        };
    }
    
    public Converter<WSUser, String> ApplicationConversionServiceFactoryBean.getWSUserToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.depich1987.wsih.domain.WSUser, java.lang.String>() {
            public String convert(WSUser wSUser) {
                return new StringBuilder().append(wSUser.getCivility()).append(' ').append(wSUser.getFirstName()).append(' ').append(wSUser.getLastName()).append(' ').append(wSUser.getUserName()).toString();
            }
        };
    }
    
    public Converter<Long, WSUser> ApplicationConversionServiceFactoryBean.getIdToWSUserConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.depich1987.wsih.domain.WSUser>() {
            public com.depich1987.wsih.domain.WSUser convert(java.lang.Long id) {
                return WSUser.findWSUser(id);
            }
        };
    }
    
    public Converter<String, WSUser> ApplicationConversionServiceFactoryBean.getStringToWSUserConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.depich1987.wsih.domain.WSUser>() {
            public com.depich1987.wsih.domain.WSUser convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), WSUser.class);
            }
        };
    }
    
    public void ApplicationConversionServiceFactoryBean.installLabelConverters(FormatterRegistry registry) {
        registry.addConverter(getWSBudgetAccountToStringConverter());
        registry.addConverter(getIdToWSBudgetAccountConverter());
        registry.addConverter(getStringToWSBudgetAccountConverter());
        registry.addConverter(getWSCashAccountToStringConverter());
        registry.addConverter(getIdToWSCashAccountConverter());
        registry.addConverter(getStringToWSCashAccountConverter());
        registry.addConverter(getWSDepartmentToStringConverter());
        registry.addConverter(getIdToWSDepartmentConverter());
        registry.addConverter(getStringToWSDepartmentConverter());
        registry.addConverter(getWSHealthCareToStringConverter());
        registry.addConverter(getIdToWSHealthCareConverter());
        registry.addConverter(getStringToWSHealthCareConverter());
        registry.addConverter(getWSHealthCareTypeToStringConverter());
        registry.addConverter(getIdToWSHealthCareTypeConverter());
        registry.addConverter(getStringToWSHealthCareTypeConverter());
        registry.addConverter(getWSHospitalToStringConverter());
        registry.addConverter(getIdToWSHospitalConverter());
        registry.addConverter(getStringToWSHospitalConverter());
        registry.addConverter(getWSInsuranceCompanyToStringConverter());
        registry.addConverter(getIdToWSInsuranceCompanyConverter());
        registry.addConverter(getStringToWSInsuranceCompanyConverter());
        registry.addConverter(getWSInsuranceProductToStringConverter());
        registry.addConverter(getIdToWSInsuranceProductConverter());
        registry.addConverter(getStringToWSInsuranceProductConverter());
        registry.addConverter(getWSJobToStringConverter());
        registry.addConverter(getIdToWSJobConverter());
        registry.addConverter(getStringToWSJobConverter());
        registry.addConverter(getWSMedecineToStringConverter());
        registry.addConverter(getIdToWSMedecineConverter());
        registry.addConverter(getStringToWSMedecineConverter());
        registry.addConverter(getWSMedecineTypeToStringConverter());
        registry.addConverter(getIdToWSMedecineTypeConverter());
        registry.addConverter(getStringToWSMedecineTypeConverter());
        registry.addConverter(getWSMeetingToStringConverter());
        registry.addConverter(getIdToWSMeetingConverter());
        registry.addConverter(getStringToWSMeetingConverter());
        registry.addConverter(getWSPatientToStringConverter());
        registry.addConverter(getIdToWSPatientConverter());
        registry.addConverter(getStringToWSPatientConverter());
        registry.addConverter(getWSPricingToStringConverter());
        registry.addConverter(getIdToWSPricingConverter());
        registry.addConverter(getStringToWSPricingConverter());
        registry.addConverter(getWSStockPileToStringConverter());
        registry.addConverter(getIdToWSStockPileConverter());
        registry.addConverter(getStringToWSStockPileConverter());
        registry.addConverter(getWSUserToStringConverter());
        registry.addConverter(getIdToWSUserConverter());
        registry.addConverter(getStringToWSUserConverter());
    }
    
    public void ApplicationConversionServiceFactoryBean.afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }
    
}
