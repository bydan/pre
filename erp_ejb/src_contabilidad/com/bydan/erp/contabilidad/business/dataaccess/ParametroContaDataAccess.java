/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.contabilidad.business.dataaccess;

import java.util.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSetMetaData;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

import java.io.File;
import java.lang.reflect.Field;

//COMODIN
import javax.persistence.EntityManagerFactory;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneralMinimo;
import com.bydan.framework.erp.business.entity.DatoGeneralMaximo;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.business.logic.QueryWhereSelectParameters;
import com.bydan.framework.erp.business.logic.ParameterSelectionGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperBase;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.util.*;//ParametroContaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class ParametroContaDataAccess extends  ParametroContaDataAccessAdditional{ //ParametroContaDataAccessAdditional,DataAccessHelper<ParametroConta>
	//static Logger logger = Logger.getLogger(ParametroContaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="parametro_conta";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_moneda,id_moneda_extranjera,con_mascara,numero_nivel,es_presupuesto,es_lote,con_secuencial_automatico,con_cuentas_niff,con_centro_costo_mascara,con_centro_costo_nueva_estructura,centro_costo_numero_nivel,id_cuenta_contable_activo,id_cuenta_contable_pasivo,id_cuenta_contable_patrimonio,id_cuenta_contable_ingreso,id_cuenta_contable_egreso,id_cuenta_contable_resumen,id_cuenta_contable_deudor,id_cuenta_contable_acreedor,id_cuenta_contable_ingreso1,id_cuenta_contable_ingreso2,id_cuenta_contable_ingreso3,id_cuenta_contable_egreso1,id_cuenta_contable_egreso2,id_cuenta_contable_egreso3)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_moneda=?,id_moneda_extranjera=?,con_mascara=?,numero_nivel=?,es_presupuesto=?,es_lote=?,con_secuencial_automatico=?,con_cuentas_niff=?,con_centro_costo_mascara=?,con_centro_costo_nueva_estructura=?,centro_costo_numero_nivel=?,id_cuenta_contable_activo=?,id_cuenta_contable_pasivo=?,id_cuenta_contable_patrimonio=?,id_cuenta_contable_ingreso=?,id_cuenta_contable_egreso=?,id_cuenta_contable_resumen=?,id_cuenta_contable_deudor=?,id_cuenta_contable_acreedor=?,id_cuenta_contable_ingreso1=?,id_cuenta_contable_ingreso2=?,id_cuenta_contable_ingreso3=?,id_cuenta_contable_egreso1=?,id_cuenta_contable_egreso2=?,id_cuenta_contable_egreso3=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select parametroconta from "+ParametroContaConstantesFunciones.SPERSISTENCENAME+" parametroconta";
	public static String QUERYSELECTNATIVE="select "+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".id,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".version_row,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".id_empresa,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".id_moneda,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".id_moneda_extranjera,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".con_mascara,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".numero_nivel,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".es_presupuesto,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".es_lote,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".con_secuencial_automatico,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".con_cuentas_niff,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".con_centro_costo_mascara,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".con_centro_costo_nueva_estructura,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".centro_costo_numero_nivel,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".id_cuenta_contable_activo,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".id_cuenta_contable_pasivo,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".id_cuenta_contable_patrimonio,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".id_cuenta_contable_ingreso,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".id_cuenta_contable_egreso,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".id_cuenta_contable_resumen,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".id_cuenta_contable_deudor,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".id_cuenta_contable_acreedor,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".id_cuenta_contable_ingreso1,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".id_cuenta_contable_ingreso2,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".id_cuenta_contable_ingreso3,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".id_cuenta_contable_egreso1,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".id_cuenta_contable_egreso2,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".id_cuenta_contable_egreso3 from "+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME;//+" as "+ParametroContaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".id,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".version_row from "+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME;//+" as "+ParametroContaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_moneda=?,id_moneda_extranjera=?,con_mascara=?,numero_nivel=?,es_presupuesto=?,es_lote=?,con_secuencial_automatico=?,con_cuentas_niff=?,con_centro_costo_mascara=?,con_centro_costo_nueva_estructura=?,centro_costo_numero_nivel=?,id_cuenta_contable_activo=?,id_cuenta_contable_pasivo=?,id_cuenta_contable_patrimonio=?,id_cuenta_contable_ingreso=?,id_cuenta_contable_egreso=?,id_cuenta_contable_resumen=?,id_cuenta_contable_deudor=?,id_cuenta_contable_acreedor=?,id_cuenta_contable_ingreso1=?,id_cuenta_contable_ingreso2=?,id_cuenta_contable_ingreso3=?,id_cuenta_contable_egreso1=?,id_cuenta_contable_egreso2=?,id_cuenta_contable_egreso3=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PARAMETROCONTA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PARAMETROCONTA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PARAMETROCONTA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PARAMETROCONTA_SELECT(?,?)";
	
	public static Boolean ISDELETECASCADE=false;
	public static boolean ISWITHSCHEMA=true;
	public static boolean ISWITHSTOREPROCEDURES=false;
	
	protected Boolean isForForeingKeyData=false;
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	
	
	private Object entityObject;
	
	private List<Object> entitiesObject;
	
	protected DatosCliente datosCliente;
	
	
	protected ParametroContaDataAccessAdditional parametrocontaDataAccessAdditional=null;
	
	public ParametroContaDataAccessAdditional getParametroContaDataAccessAdditional() {
		return this.parametrocontaDataAccessAdditional;
	}
	
	public void setParametroContaDataAccessAdditional(ParametroContaDataAccessAdditional parametrocontaDataAccessAdditional) {
		try {
			this.parametrocontaDataAccessAdditional=parametrocontaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ParametroContaDataAccess() {
		this.entityObject=new Object();
		this.entitiesObject=new ArrayList<Object>();
		this.isForForeingKeyData=false;
		this.isForForeingsKeysDataRelationships=false;
		this.datosCliente=new DatosCliente();
	}
	
	
	public Boolean getIsForForeingKeyData() {
		return this.isForForeingKeyData;
	}

	public void setIsForForeingKeyData(Boolean isForForeingKeyData) {
		this.isForForeingKeyData = isForForeingKeyData;
	}
	
	public Boolean getIsForForeingsKeysDataRelationships() {
		return this.isForForeingsKeysDataRelationships;
	}

	public void setIsForForeingsKeysDataRelationships(Boolean isForForeingsKeysDataRelationships) {
		this.isForForeingsKeysDataRelationships = isForForeingsKeysDataRelationships;
	}
	
	public static boolean getISWITHSCHEMA() {
		return ISWITHSCHEMA;
	}

	public static void setISWITHSCHEMA(boolean ANISWITHSCHEMA) {
		ISWITHSCHEMA = ANISWITHSCHEMA;
	}		
	
	public static boolean getISWITHSTOREPROCEDURES() {
		return ISWITHSTOREPROCEDURES;
	}

	public static void setISWITHSTOREPROCEDURES(boolean ANISWITHSTOREPROCEDURES) {
		ISWITHSTOREPROCEDURES =ANISWITHSTOREPROCEDURES;
	}
	
	public static String getTABLENAME() {
		return TABLENAME;
	}
	
	public static void setTABLENAME(String sTABLENAME) {
		ParametroContaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ParametroContaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ParametroContaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
	}
	
	public List<Object> getEntitiesObject() {
		return this.entitiesObject;
	}

	public void setEntitiesObject(List<Object> entitiesObject) {
		this.entitiesObject= entitiesObject;
	}
	
	public Object getEntityObject() {
		return this.entityObject;
	}

	public void setEntityObject(Object entityObject) {
		this.entityObject= entityObject;
	}
	
	public static ParametersMaintenance getParametersMaintenance(GeneralEntity generalEntity) {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
		int orderParameter;

		return parametersMaintenance;
	}
	
	public ConnexionType getConnexionType() {
		return connexionType;
	}

	public void setConnexionType(ConnexionType connexionType) {
		this.connexionType = connexionType;
	}

	public ParameterDbType getParameterDbType() {
		return parameterDbType;
	}

	public void setParameterDbType(ParameterDbType parameterDbType) {
		this.parameterDbType = parameterDbType;
	}

	//COMODIN
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		
	}
	
	public DatosCliente getDatosCliente() {
		return datosCliente;
	}

	public void setDatosCliente(DatosCliente datosCliente) {
		this.datosCliente = datosCliente;
	}
	
	public void setParametroContaOriginal(ParametroConta parametroconta)throws Exception  {
		parametroconta.setParametroContaOriginal((ParametroConta)parametroconta.clone());		
	}
	
	public void setParametroContasOriginal(List<ParametroConta> parametrocontas)throws Exception  {
		
		for(ParametroConta parametroconta:parametrocontas){
			parametroconta.setParametroContaOriginal((ParametroConta)parametroconta.clone());
		}
	}
	
	public static void setParametroContaOriginalStatic(ParametroConta parametroconta)throws Exception  {
		parametroconta.setParametroContaOriginal((ParametroConta)parametroconta.clone());		
	}
	
	public static void setParametroContasOriginalStatic(List<ParametroConta> parametrocontas)throws Exception  {
		
		for(ParametroConta parametroconta:parametrocontas){
			parametroconta.setParametroContaOriginal((ParametroConta)parametroconta.clone());
		}
	}
	
	public  void executeQuery(Connexion connexion, String sQueryExecute) throws Exception {	
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				this.executeQueryJdbc(connexion, sQueryExecute);
			} else {
				//this.executeQueryHibernate(connexion, sQueryExecute);
			}
      	} catch(Exception e) {
			throw e;
      	}		    	
    }
	
	public void executeQueryJdbc(Connexion connexion, String sQueryExecute) throws Exception {		
        try {     				
        	PreparedStatement preparedStatement = connexion.getConnection().prepareStatement(sQueryExecute);
      					
        	preparedStatement.executeUpdate();
        	preparedStatement.close();
      		   	
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	public  ParametroConta getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroConta entity = new ParametroConta();		
		
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion, id);
			} else {
			}
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	public  ParametroConta getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroConta entity = new ParametroConta();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroContaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroContaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.ParametroConta.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setParametroContaOriginal(new ParametroConta());
      	    	entity=super.getEntity("",entity,resultSet,ParametroContaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroConta("",entity,resultSet); 
				
				//entity.setParametroContaOriginal(super.getEntity("",entity.getParametroContaOriginal(),resultSet,ParametroContaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroContaOriginal(this.getEntityParametroConta("",entity.getParametroContaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroConta(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ParametroConta getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroConta entity = new ParametroConta();
				
        try  {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,queryWhereSelectParameters);
			} else {
			}
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  ParametroConta getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroConta entity = new ParametroConta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroContaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroContaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroContaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.ParametroConta.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setParametroContaOriginal(new ParametroConta());
      	    	entity=super.getEntity("",entity,resultSet,ParametroContaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroConta("",entity,resultSet);    
				
				//entity.setParametroContaOriginal(super.getEntity("",entity.getParametroContaOriginal(),resultSet,ParametroContaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroContaOriginal(this.getEntityParametroConta("",entity.getParametroContaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroConta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ParametroConta
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ParametroConta entity = new ParametroConta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroContaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroContaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroContaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.ParametroConta.isActive=1
        	 
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {
				if(resultSet.next()) {				
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMinimo,classe,resultSet);
					}
					
					/*
					int iIndexColumn = 1;
				    
					while(iIndexColumn <= iTotalCountColumn) {
						//arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }										
					*/
				} else {
					entity =null;
				}
			//}
			
			if(entity!=null) {
				//this.setIsNewIsChangedFalseParametroConta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ParametroConta> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroConta> entities = new  ArrayList<ParametroConta>();
		ParametroConta entity = new ParametroConta();		  
		
        try { 
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,queryWhereSelectParameters);	
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<ParametroConta> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroConta> entities = new  ArrayList<ParametroConta>();
		ParametroConta entity = new ParametroConta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroContaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroContaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroContaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroConta();
      	    	entity=super.getEntity("",entity,resultSet,ParametroContaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroConta("",entity,resultSet);
      	    	
				//entity.setParametroContaOriginal( new ParametroConta());
      	    	//entity.setParametroContaOriginal(super.getEntity("",entity.getParametroContaOriginal(),resultSet,ParametroContaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroContaOriginal(this.getEntityParametroConta("",entity.getParametroContaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroContas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroConta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroConta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroConta> entities = new  ArrayList<ParametroConta>();
		ParametroConta entity = new ParametroConta();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entities =this.getEntitiesHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<ParametroConta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroConta> entities = new  ArrayList<ParametroConta>();
		ParametroConta entity = new ParametroConta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroConta();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroConta();
					//entity.setMapParametroConta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapParametroContaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroConta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroContaDataAccess.ISWITHSCHEMA);         		
					entity=ParametroContaDataAccess.getEntityParametroConta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroContaOriginal( new ParametroConta());
					////entity.setParametroContaOriginal(super.getEntity("",entity.getParametroContaOriginal(),resultSet,ParametroContaDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroContaOriginal(this.getEntityParametroConta("",entity.getParametroContaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroContas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroConta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ParametroConta getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroConta entity = new ParametroConta();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entity =this.getEntityHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  ParametroConta getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroConta entity = new ParametroConta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroConta();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroConta();
					//entity.setMapParametroConta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapParametroContaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroConta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroContaDataAccess.ISWITHSCHEMA);         		
					entity=ParametroContaDataAccess.getEntityParametroConta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroContaOriginal( new ParametroConta());
					////entity.setParametroContaOriginal(super.getEntity("",entity.getParametroContaOriginal(),resultSet,ParametroContaDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroContaOriginal(this.getEntityParametroConta("",entity.getParametroContaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseParametroConta(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroConta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ParametroConta getEntityParametroConta(String strPrefijo,ParametroConta entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ParametroConta.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ParametroConta.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ParametroContaDataAccess.setFieldReflectionParametroConta(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasParametroConta=ParametroContaConstantesFunciones.getTodosTiposColumnasParametroConta();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasParametroConta) {
					existe=false;
					
					for(String sColumnExlude:listColumns) {	        	
						if(sColumn.equals(sColumnExlude)) {
							existe=true;
							break;
						}
					} 
					
					if(!existe) {
						//ESTE PROCESO ES REPETIDO DE INCLUDE
						Field field =null;
						try {
							field = ParametroConta.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ParametroConta.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ParametroContaDataAccess.setFieldReflectionParametroConta(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionParametroConta(Field field,String strPrefijo,String sColumn,ParametroConta entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ParametroContaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroContaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroContaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroContaConstantesFunciones.IDMONEDA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroContaConstantesFunciones.IDMONEDAEXTRANJERA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroContaConstantesFunciones.CONMASCARA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroContaConstantesFunciones.NUMERONIVEL:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ParametroContaConstantesFunciones.ESPRESUPUESTO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroContaConstantesFunciones.ESLOTE:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroContaConstantesFunciones.CONSECUENCIALAUTOMATICO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroContaConstantesFunciones.CONCUENTASNIFF:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroContaConstantesFunciones.CONCENTROCOSTOMASCARA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroContaConstantesFunciones.CONCENTROCOSTONUEVAESTRUCTURA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroContaConstantesFunciones.CENTROCOSTONUMERONIVEL:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ParametroContaConstantesFunciones.IDCUENTACONTABLEACTIVO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroContaConstantesFunciones.IDCUENTACONTABLEPASIVO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroContaConstantesFunciones.IDCUENTACONTABLEPATRIMONIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroContaConstantesFunciones.IDCUENTACONTABLERESUMEN:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroContaConstantesFunciones.IDCUENTACONTABLEDEUDOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroContaConstantesFunciones.IDCUENTACONTABLEACREEDOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO1:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO2:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO3:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO1:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO2:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO3:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				default: 
					//CUANDO SE UTILIZA CAMPOS DIFERENCTES A LOS ORIGINALMENTE DEFINIDOS(ADDITIONAL)
					DataAccessHelperBase.setFieldDynamic(entity,sCampo,field,resultSet);
					break;
				/*
        		case "id":
        			field.set(entity, resultSet.getLong(sCampo));
        			break;        		        			
				*/
        	}    
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroConta>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ParametroConta> entities = new  ArrayList<ParametroConta>();
		ParametroConta entity = new ParametroConta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroContaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroContaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroContaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneralMaximo=new DatoGeneralMaximo();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMaximo,classe,resultSet);
					}
					
					//int iIndexColumn = 1;
				    
					/*
					while(iIndexColumn <= iTotalCountColumn) {
				    	arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }
					*/
					
					datoGeneralMaximos.add(datoGeneralMaximo);
					
					
					
					//arrayListObjects.add(arrayListObject);
					
					/*
					entity = new ParametroConta();
					entity=super.getEntity("",entity,resultSet,ParametroContaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityParametroConta("",entity,resultSet);
					
					//entity.setParametroContaOriginal( new ParametroConta());
					//entity.setParametroContaOriginal(super.getEntity("",entity.getParametroContaOriginal(),resultSet,ParametroContaDataAccess.ISWITHSCHEMA));         		
					//entity.setParametroContaOriginal(this.getEntityParametroConta("",entity.getParametroContaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseParametroContas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroConta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroConta>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ParametroConta> entities = new  ArrayList<ParametroConta>();
		ParametroConta entity = new ParametroConta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroContaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroContaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroContaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneral=new DatoGeneral();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneral,classe,resultSet);
					}
					
					datoGenerals.add(datoGeneral);
				}
			//}
			
			statement.close(); 
			
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGenerals;
    }
	
	
	public  List<ParametroConta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroConta> entities = new  ArrayList<ParametroConta>();
		ParametroConta entity = new ParametroConta();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<ParametroConta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroConta> entities = new  ArrayList<ParametroConta>();
		ParametroConta entity = new ParametroConta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroConta();
      	    	entity=super.getEntity("",entity,resultSet,ParametroContaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroConta("",entity,resultSet);
      	    	
				//entity.setParametroContaOriginal( new ParametroConta());
      	    	//entity.setParametroContaOriginal(super.getEntity("",entity.getParametroContaOriginal(),resultSet,ParametroContaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroContaOriginal(this.getEntityParametroConta("",entity.getParametroContaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseParametroContas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroConta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroConta> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroConta> entities = new  ArrayList<ParametroConta>();
		ParametroConta entity = new ParametroConta();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesSimpleQueryBuildJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}

		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<ParametroConta> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroConta> entities = new  ArrayList<ParametroConta>();
		ParametroConta entity = new ParametroConta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroConta();
      	    	entity=super.getEntity("",entity,resultSet,ParametroContaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroConta("",entity,resultSet);
      	    	
				//entity.setParametroContaOriginal( new ParametroConta());
      	    	//entity.setParametroContaOriginal(super.getEntity("",entity.getParametroContaOriginal(),resultSet,ParametroContaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroContaOriginal(this.getEntityParametroConta("",entity.getParametroContaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroContas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ParametroConta getEntityParametroConta(String strPrefijo,ParametroConta entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ParametroContaConstantesFunciones.IDEMPRESA));
				entity.setid_moneda(resultSet.getLong(strPrefijo+ParametroContaConstantesFunciones.IDMONEDA));
				entity.setid_moneda_extranjera(resultSet.getLong(strPrefijo+ParametroContaConstantesFunciones.IDMONEDAEXTRANJERA));
				entity.setcon_mascara(resultSet.getBoolean(strPrefijo+ParametroContaConstantesFunciones.CONMASCARA));
				entity.setnumero_nivel(resultSet.getInt(strPrefijo+ParametroContaConstantesFunciones.NUMERONIVEL));
				entity.setes_presupuesto(resultSet.getBoolean(strPrefijo+ParametroContaConstantesFunciones.ESPRESUPUESTO));
				entity.setes_lote(resultSet.getBoolean(strPrefijo+ParametroContaConstantesFunciones.ESLOTE));
				entity.setcon_secuencial_automatico(resultSet.getBoolean(strPrefijo+ParametroContaConstantesFunciones.CONSECUENCIALAUTOMATICO));
				entity.setcon_cuentas_niff(resultSet.getBoolean(strPrefijo+ParametroContaConstantesFunciones.CONCUENTASNIFF));
				entity.setcon_centro_costo_mascara(resultSet.getBoolean(strPrefijo+ParametroContaConstantesFunciones.CONCENTROCOSTOMASCARA));
				entity.setcon_centro_costo_nueva_estructura(resultSet.getBoolean(strPrefijo+ParametroContaConstantesFunciones.CONCENTROCOSTONUEVAESTRUCTURA));
				entity.setcentro_costo_numero_nivel(resultSet.getInt(strPrefijo+ParametroContaConstantesFunciones.CENTROCOSTONUMERONIVEL));
				entity.setid_cuenta_contable_activo(resultSet.getLong(strPrefijo+ParametroContaConstantesFunciones.IDCUENTACONTABLEACTIVO));
				entity.setid_cuenta_contable_pasivo(resultSet.getLong(strPrefijo+ParametroContaConstantesFunciones.IDCUENTACONTABLEPASIVO));
				entity.setid_cuenta_contable_patrimonio(resultSet.getLong(strPrefijo+ParametroContaConstantesFunciones.IDCUENTACONTABLEPATRIMONIO));
				entity.setid_cuenta_contable_ingreso(resultSet.getLong(strPrefijo+ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO));
				entity.setid_cuenta_contable_egreso(resultSet.getLong(strPrefijo+ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO));
				entity.setid_cuenta_contable_resumen(resultSet.getLong(strPrefijo+ParametroContaConstantesFunciones.IDCUENTACONTABLERESUMEN));
				entity.setid_cuenta_contable_deudor(resultSet.getLong(strPrefijo+ParametroContaConstantesFunciones.IDCUENTACONTABLEDEUDOR));
				entity.setid_cuenta_contable_acreedor(resultSet.getLong(strPrefijo+ParametroContaConstantesFunciones.IDCUENTACONTABLEACREEDOR));
				entity.setid_cuenta_contable_ingreso1(resultSet.getLong(strPrefijo+ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO1));if(resultSet.wasNull()) {entity.setid_cuenta_contable_ingreso1(null); }
				entity.setid_cuenta_contable_ingreso2(resultSet.getLong(strPrefijo+ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO2));if(resultSet.wasNull()) {entity.setid_cuenta_contable_ingreso2(null); }
				entity.setid_cuenta_contable_ingreso3(resultSet.getLong(strPrefijo+ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO3));if(resultSet.wasNull()) {entity.setid_cuenta_contable_ingreso3(null); }
				entity.setid_cuenta_contable_egreso1(resultSet.getLong(strPrefijo+ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO1));if(resultSet.wasNull()) {entity.setid_cuenta_contable_egreso1(null); }
				entity.setid_cuenta_contable_egreso2(resultSet.getLong(strPrefijo+ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO2));if(resultSet.wasNull()) {entity.setid_cuenta_contable_egreso2(null); }
				entity.setid_cuenta_contable_egreso3(resultSet.getLong(strPrefijo+ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO3));if(resultSet.wasNull()) {entity.setid_cuenta_contable_egreso3(null); }
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowParametroConta(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ParametroConta entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ParametroContaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ParametroContaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ParametroContaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ParametroContaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ParametroContaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ParametroContaDataAccess.TABLENAME,ParametroContaDataAccess.ISWITHSTOREPROCEDURES);
			
			ParametroContaDataAccess.setParametroContaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ParametroConta relparametroconta)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relparametroconta.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Moneda getMoneda(Connexion connexion,ParametroConta relparametroconta)throws SQLException,Exception {

		Moneda moneda= new Moneda();

		try {
			MonedaDataAccess monedaDataAccess=new MonedaDataAccess();

			monedaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			monedaDataAccess.setConnexionType(this.connexionType);
			monedaDataAccess.setParameterDbType(this.parameterDbType);

			moneda=monedaDataAccess.getEntity(connexion,relparametroconta.getid_moneda());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return moneda;

	}

	public Moneda getMonedaExtranjera(Connexion connexion,ParametroConta relparametroconta)throws SQLException,Exception {

		Moneda moneda= new Moneda();

		try {
			MonedaDataAccess monedaDataAccess=new MonedaDataAccess();

			monedaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			monedaDataAccess.setConnexionType(this.connexionType);
			monedaDataAccess.setParameterDbType(this.parameterDbType);

			moneda=monedaDataAccess.getEntity(connexion,relparametroconta.getid_moneda_extranjera());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return moneda;

	}

	public CuentaContable getCuentaContableActivo(Connexion connexion,ParametroConta relparametroconta)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametroconta.getid_cuenta_contable_activo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContablePasivo(Connexion connexion,ParametroConta relparametroconta)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametroconta.getid_cuenta_contable_pasivo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContablePatrimonio(Connexion connexion,ParametroConta relparametroconta)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametroconta.getid_cuenta_contable_patrimonio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableIngreso(Connexion connexion,ParametroConta relparametroconta)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametroconta.getid_cuenta_contable_ingreso());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableEgreso(Connexion connexion,ParametroConta relparametroconta)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametroconta.getid_cuenta_contable_egreso());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableResumen(Connexion connexion,ParametroConta relparametroconta)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametroconta.getid_cuenta_contable_resumen());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableDeudor(Connexion connexion,ParametroConta relparametroconta)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametroconta.getid_cuenta_contable_deudor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableAcreedor(Connexion connexion,ParametroConta relparametroconta)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametroconta.getid_cuenta_contable_acreedor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableIngreso1(Connexion connexion,ParametroConta relparametroconta)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametroconta.getid_cuenta_contable_ingreso1());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableIngreso2(Connexion connexion,ParametroConta relparametroconta)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametroconta.getid_cuenta_contable_ingreso2());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableIngreso3(Connexion connexion,ParametroConta relparametroconta)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametroconta.getid_cuenta_contable_ingreso3());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableEgreso1(Connexion connexion,ParametroConta relparametroconta)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametroconta.getid_cuenta_contable_egreso1());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableEgreso2(Connexion connexion,ParametroConta relparametroconta)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametroconta.getid_cuenta_contable_egreso2());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableEgreso3(Connexion connexion,ParametroConta relparametroconta)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametroconta.getid_cuenta_contable_egreso3());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}


		
		public List<ParametroContaDetalle> getParametroContaDetalles(Connexion connexion,ParametroConta parametroconta)throws SQLException,Exception {

		List<ParametroContaDetalle> parametrocontadetalles= new ArrayList<ParametroContaDetalle>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ParametroContaConstantesFunciones.SCHEMA+".parametro_conta ON "+ParametroContaDetalleConstantesFunciones.SCHEMA+".parametro_conta_detalle.id_parametro_conta="+ParametroContaConstantesFunciones.SCHEMA+".parametro_conta.id WHERE "+ParametroContaConstantesFunciones.SCHEMA+".parametro_conta.id="+String.valueOf(parametroconta.getId());
			} else {
				sQuery=" INNER JOIN parametrocontadetalle.ParametroConta WHERE parametrocontadetalle.ParametroConta.id="+String.valueOf(parametroconta.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroContaDetalleDataAccess parametrocontadetalleDataAccess=new ParametroContaDetalleDataAccess();

			parametrocontadetalleDataAccess.setConnexionType(this.connexionType);
			parametrocontadetalleDataAccess.setParameterDbType(this.parameterDbType);
			parametrocontadetalles=parametrocontadetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametrocontadetalles;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ParametroConta parametroconta) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!parametroconta.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(parametroconta.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_moneda=new ParameterValue<Long>();
					parameterMaintenanceValueid_moneda.setValue(parametroconta.getid_moneda());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_moneda);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_moneda_extranjera=new ParameterValue<Long>();
					parameterMaintenanceValueid_moneda_extranjera.setValue(parametroconta.getid_moneda_extranjera());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_moneda_extranjera);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_mascara=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_mascara.setValue(parametroconta.getcon_mascara());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_mascara);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_nivel=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_nivel.setValue(parametroconta.getnumero_nivel());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_nivel);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_presupuesto=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_presupuesto.setValue(parametroconta.getes_presupuesto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_presupuesto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_lote=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_lote.setValue(parametroconta.getes_lote());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_lote);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_secuencial_automatico=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_secuencial_automatico.setValue(parametroconta.getcon_secuencial_automatico());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_secuencial_automatico);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_cuentas_niff=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_cuentas_niff.setValue(parametroconta.getcon_cuentas_niff());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_cuentas_niff);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_centro_costo_mascara=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_centro_costo_mascara.setValue(parametroconta.getcon_centro_costo_mascara());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_centro_costo_mascara);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_centro_costo_nueva_estructura=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_centro_costo_nueva_estructura.setValue(parametroconta.getcon_centro_costo_nueva_estructura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_centro_costo_nueva_estructura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecentro_costo_numero_nivel=new ParameterValue<Integer>();
					parameterMaintenanceValuecentro_costo_numero_nivel.setValue(parametroconta.getcentro_costo_numero_nivel());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecentro_costo_numero_nivel);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_activo=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_activo.setValue(parametroconta.getid_cuenta_contable_activo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_activo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_pasivo=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_pasivo.setValue(parametroconta.getid_cuenta_contable_pasivo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_pasivo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_patrimonio=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_patrimonio.setValue(parametroconta.getid_cuenta_contable_patrimonio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_patrimonio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_ingreso=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_ingreso.setValue(parametroconta.getid_cuenta_contable_ingreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_ingreso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_egreso=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_egreso.setValue(parametroconta.getid_cuenta_contable_egreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_egreso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_resumen=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_resumen.setValue(parametroconta.getid_cuenta_contable_resumen());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_resumen);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_deudor=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_deudor.setValue(parametroconta.getid_cuenta_contable_deudor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_deudor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_acreedor=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_acreedor.setValue(parametroconta.getid_cuenta_contable_acreedor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_acreedor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_ingreso1=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_ingreso1.setValue(parametroconta.getid_cuenta_contable_ingreso1());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_ingreso1);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_ingreso2=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_ingreso2.setValue(parametroconta.getid_cuenta_contable_ingreso2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_ingreso2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_ingreso3=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_ingreso3.setValue(parametroconta.getid_cuenta_contable_ingreso3());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_ingreso3);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_egreso1=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_egreso1.setValue(parametroconta.getid_cuenta_contable_egreso1());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_egreso1);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_egreso2=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_egreso2.setValue(parametroconta.getid_cuenta_contable_egreso2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_egreso2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_egreso3=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_egreso3.setValue(parametroconta.getid_cuenta_contable_egreso3());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_egreso3);
					parametersTemp.add(parameterMaintenance);
					
						if(!parametroconta.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(parametroconta.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(parametroconta.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(parametroconta.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
					parametersTemp.add(parameterMaintenance);
				}
			
			parametersMaintenance= new ParametersMaintenance();
			parametersMaintenance.setDbType(newDbType);
			parametersMaintenance.setParametersMaintenance(parametersTemp);
			//super.setParametersMaintenance(parametersMaintenance);		
		} catch(Exception e) {
			throw e;
		}
		
		return parametersMaintenance;
	}
	
	public void setIsNewIsChangedFalseParametroConta(ParametroConta parametroconta)throws Exception  {		
		parametroconta.setIsNew(false);
		parametroconta.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseParametroContas(List<ParametroConta> parametrocontas)throws Exception  {				
		for(ParametroConta parametroconta:parametrocontas) {
			parametroconta.setIsNew(false);
			parametroconta.setIsChanged(false);
		}
	}
	
	public void generarExportarParametroConta(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
		try {
			if(this.datosCliente.getIsConExportar()) {
				String sQueryExportar=Funciones2.getQueryExportar(this.datosCliente, sQuery, queryWhereSelectParameters);
				
				this.executeQueryJdbc(connexion,sQueryExportar);
			}
		} catch(Exception e) {
			e.printStackTrace();
			//System.out.print(e.getStackTrace());
		}
	}
}
   
