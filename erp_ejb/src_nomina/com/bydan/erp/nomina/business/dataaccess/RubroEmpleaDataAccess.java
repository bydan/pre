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
package com.bydan.erp.nomina.business.dataaccess;

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

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.util.*;//RubroEmpleaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class RubroEmpleaDataAccess extends  RubroEmpleaDataAccessAdditional{ //RubroEmpleaDataAccessAdditional,DataAccessHelper<RubroEmplea>
	//static Logger logger = Logger.getLogger(RubroEmpleaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="rubro_emplea";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_tipo_calculo,id_tipo_rubro_emplea,id_tipo_grupo_rubro_emplea,codigo,nombre,formula,alias,secuencial,para_rol_pagos,para_sueldo,para_vacaciones,para_impuesto_renta,para_seguro_social,para_provisiones,para_utilidades,para_rubro_iess,es_fondo_reserva,es_decimo_tercero,es_decimo_cuarto)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_tipo_calculo=?,id_tipo_rubro_emplea=?,id_tipo_grupo_rubro_emplea=?,codigo=?,nombre=?,formula=?,alias=?,secuencial=?,para_rol_pagos=?,para_sueldo=?,para_vacaciones=?,para_impuesto_renta=?,para_seguro_social=?,para_provisiones=?,para_utilidades=?,para_rubro_iess=?,es_fondo_reserva=?,es_decimo_tercero=?,es_decimo_cuarto=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select rubroemplea from "+RubroEmpleaConstantesFunciones.SPERSISTENCENAME+" rubroemplea";
	public static String QUERYSELECTNATIVE="select "+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".id,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".version_row,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".id_empresa,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".id_tipo_calculo,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".id_tipo_rubro_emplea,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".id_tipo_grupo_rubro_emplea,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".codigo,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".nombre,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".formula,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".alias,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".secuencial,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".para_rol_pagos,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".para_sueldo,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".para_vacaciones,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".para_impuesto_renta,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".para_seguro_social,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".para_provisiones,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".para_utilidades,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".para_rubro_iess,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".es_fondo_reserva,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".es_decimo_tercero,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".es_decimo_cuarto from "+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME;//+" as "+RubroEmpleaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".id,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".version_row,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".codigo,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".nombre from "+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME;//+" as "+RubroEmpleaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_tipo_calculo=?,id_tipo_rubro_emplea=?,id_tipo_grupo_rubro_emplea=?,codigo=?,nombre=?,formula=?,alias=?,secuencial=?,para_rol_pagos=?,para_sueldo=?,para_vacaciones=?,para_impuesto_renta=?,para_seguro_social=?,para_provisiones=?,para_utilidades=?,para_rubro_iess=?,es_fondo_reserva=?,es_decimo_tercero=?,es_decimo_cuarto=?";
	
	public static String STOREPROCEDUREINSERT="call SP_RUBROEMPLEA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_RUBROEMPLEA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_RUBROEMPLEA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_RUBROEMPLEA_SELECT(?,?)";
	
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
	
	
	protected RubroEmpleaDataAccessAdditional rubroempleaDataAccessAdditional=null;
	
	public RubroEmpleaDataAccessAdditional getRubroEmpleaDataAccessAdditional() {
		return this.rubroempleaDataAccessAdditional;
	}
	
	public void setRubroEmpleaDataAccessAdditional(RubroEmpleaDataAccessAdditional rubroempleaDataAccessAdditional) {
		try {
			this.rubroempleaDataAccessAdditional=rubroempleaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public RubroEmpleaDataAccess() {
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
		RubroEmpleaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		RubroEmpleaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		RubroEmpleaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setRubroEmpleaOriginal(RubroEmplea rubroemplea)throws Exception  {
		rubroemplea.setRubroEmpleaOriginal((RubroEmplea)rubroemplea.clone());		
	}
	
	public void setRubroEmpleasOriginal(List<RubroEmplea> rubroempleas)throws Exception  {
		
		for(RubroEmplea rubroemplea:rubroempleas){
			rubroemplea.setRubroEmpleaOriginal((RubroEmplea)rubroemplea.clone());
		}
	}
	
	public static void setRubroEmpleaOriginalStatic(RubroEmplea rubroemplea)throws Exception  {
		rubroemplea.setRubroEmpleaOriginal((RubroEmplea)rubroemplea.clone());		
	}
	
	public static void setRubroEmpleasOriginalStatic(List<RubroEmplea> rubroempleas)throws Exception  {
		
		for(RubroEmplea rubroemplea:rubroempleas){
			rubroemplea.setRubroEmpleaOriginal((RubroEmplea)rubroemplea.clone());
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
	
	public  RubroEmplea getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		RubroEmplea entity = new RubroEmplea();		
		
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
	
	public  RubroEmplea getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		RubroEmplea entity = new RubroEmplea();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=RubroEmpleaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RubroEmpleaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.RubroEmplea.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setRubroEmpleaOriginal(new RubroEmplea());
      	    	entity=super.getEntity("",entity,resultSet,RubroEmpleaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityRubroEmplea("",entity,resultSet); 
				
				//entity.setRubroEmpleaOriginal(super.getEntity("",entity.getRubroEmpleaOriginal(),resultSet,RubroEmpleaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRubroEmpleaOriginal(this.getEntityRubroEmplea("",entity.getRubroEmpleaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseRubroEmplea(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  RubroEmplea getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		RubroEmplea entity = new RubroEmplea();
				
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
	
	public  RubroEmplea getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		RubroEmplea entity = new RubroEmplea();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=RubroEmpleaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RubroEmpleaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RubroEmpleaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.RubroEmplea.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setRubroEmpleaOriginal(new RubroEmplea());
      	    	entity=super.getEntity("",entity,resultSet,RubroEmpleaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityRubroEmplea("",entity,resultSet);    
				
				//entity.setRubroEmpleaOriginal(super.getEntity("",entity.getRubroEmpleaOriginal(),resultSet,RubroEmpleaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRubroEmpleaOriginal(this.getEntityRubroEmplea("",entity.getRubroEmpleaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseRubroEmplea(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //RubroEmplea
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		RubroEmplea entity = new RubroEmplea();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RubroEmpleaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RubroEmpleaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RubroEmpleaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.RubroEmplea.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseRubroEmplea(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<RubroEmplea> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<RubroEmplea> entities = new  ArrayList<RubroEmplea>();
		RubroEmplea entity = new RubroEmplea();		  
		
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
	
	public  List<RubroEmplea> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<RubroEmplea> entities = new  ArrayList<RubroEmplea>();
		RubroEmplea entity = new RubroEmplea();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=RubroEmpleaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RubroEmpleaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RubroEmpleaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RubroEmplea();
      	    	entity=super.getEntity("",entity,resultSet,RubroEmpleaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRubroEmplea("",entity,resultSet);
      	    	
				//entity.setRubroEmpleaOriginal( new RubroEmplea());
      	    	//entity.setRubroEmpleaOriginal(super.getEntity("",entity.getRubroEmpleaOriginal(),resultSet,RubroEmpleaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRubroEmpleaOriginal(this.getEntityRubroEmplea("",entity.getRubroEmpleaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRubroEmpleas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRubroEmplea(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<RubroEmplea> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<RubroEmplea> entities = new  ArrayList<RubroEmplea>();
		RubroEmplea entity = new RubroEmplea();		  
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
	
	public  List<RubroEmplea> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<RubroEmplea> entities = new  ArrayList<RubroEmplea>();
		RubroEmplea entity = new RubroEmplea();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RubroEmplea();
				
				if(conMapGenerico) {
					entity.inicializarMapRubroEmplea();
					//entity.setMapRubroEmplea(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapRubroEmpleaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapRubroEmplea().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,RubroEmpleaDataAccess.ISWITHSCHEMA);         		
					entity=RubroEmpleaDataAccess.getEntityRubroEmplea("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setRubroEmpleaOriginal( new RubroEmplea());
					////entity.setRubroEmpleaOriginal(super.getEntity("",entity.getRubroEmpleaOriginal(),resultSet,RubroEmpleaDataAccess.ISWITHSCHEMA));         		
					////entity.setRubroEmpleaOriginal(this.getEntityRubroEmplea("",entity.getRubroEmpleaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRubroEmpleas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRubroEmplea(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public RubroEmplea getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		RubroEmplea entity = new RubroEmplea();		  
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
	
	public  RubroEmplea getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		RubroEmplea entity = new RubroEmplea();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RubroEmplea();
				
				if(conMapGenerico) {
					entity.inicializarMapRubroEmplea();
					//entity.setMapRubroEmplea(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapRubroEmpleaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapRubroEmplea().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,RubroEmpleaDataAccess.ISWITHSCHEMA);         		
					entity=RubroEmpleaDataAccess.getEntityRubroEmplea("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setRubroEmpleaOriginal( new RubroEmplea());
					////entity.setRubroEmpleaOriginal(super.getEntity("",entity.getRubroEmpleaOriginal(),resultSet,RubroEmpleaDataAccess.ISWITHSCHEMA));         		
					////entity.setRubroEmpleaOriginal(this.getEntityRubroEmplea("",entity.getRubroEmpleaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseRubroEmplea(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRubroEmplea(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static RubroEmplea getEntityRubroEmplea(String strPrefijo,RubroEmplea entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = RubroEmplea.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = RubroEmplea.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					RubroEmpleaDataAccess.setFieldReflectionRubroEmplea(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasRubroEmplea=RubroEmpleaConstantesFunciones.getTodosTiposColumnasRubroEmplea();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasRubroEmplea) {
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
							field = RubroEmplea.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = RubroEmplea.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						RubroEmpleaDataAccess.setFieldReflectionRubroEmplea(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionRubroEmplea(Field field,String strPrefijo,String sColumn,RubroEmplea entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case RubroEmpleaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RubroEmpleaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RubroEmpleaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RubroEmpleaConstantesFunciones.IDTIPOCALCULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RubroEmpleaConstantesFunciones.IDTIPORUBROEMPLEA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RubroEmpleaConstantesFunciones.IDTIPOGRUPORUBROEMPLEA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RubroEmpleaConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RubroEmpleaConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RubroEmpleaConstantesFunciones.FORMULA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RubroEmpleaConstantesFunciones.ALIAS:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RubroEmpleaConstantesFunciones.SECUENCIAL:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case RubroEmpleaConstantesFunciones.PARAROLPAGOS:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case RubroEmpleaConstantesFunciones.PARASUELDO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case RubroEmpleaConstantesFunciones.PARAVACACIONES:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case RubroEmpleaConstantesFunciones.PARAIMPUESTORENTA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case RubroEmpleaConstantesFunciones.PARASEGUROSOCIAL:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case RubroEmpleaConstantesFunciones.PARAPROVISIONES:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case RubroEmpleaConstantesFunciones.PARAUTILIDADES:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case RubroEmpleaConstantesFunciones.PARARUBROIESS:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case RubroEmpleaConstantesFunciones.ESFONDORESERVA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case RubroEmpleaConstantesFunciones.ESDECIMOTERCERO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case RubroEmpleaConstantesFunciones.ESDECIMOCUARTO:
					field.set(entity,resultSet.getBoolean(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<RubroEmplea>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<RubroEmplea> entities = new  ArrayList<RubroEmplea>();
		RubroEmplea entity = new RubroEmplea();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RubroEmpleaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RubroEmpleaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RubroEmpleaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new RubroEmplea();
					entity=super.getEntity("",entity,resultSet,RubroEmpleaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityRubroEmplea("",entity,resultSet);
					
					//entity.setRubroEmpleaOriginal( new RubroEmplea());
					//entity.setRubroEmpleaOriginal(super.getEntity("",entity.getRubroEmpleaOriginal(),resultSet,RubroEmpleaDataAccess.ISWITHSCHEMA));         		
					//entity.setRubroEmpleaOriginal(this.getEntityRubroEmplea("",entity.getRubroEmpleaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseRubroEmpleas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRubroEmplea(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<RubroEmplea>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<RubroEmplea> entities = new  ArrayList<RubroEmplea>();
		RubroEmplea entity = new RubroEmplea();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RubroEmpleaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RubroEmpleaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RubroEmpleaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<RubroEmplea> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RubroEmplea> entities = new  ArrayList<RubroEmplea>();
		RubroEmplea entity = new RubroEmplea();		  
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
	
	public  List<RubroEmplea> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RubroEmplea> entities = new  ArrayList<RubroEmplea>();
		RubroEmplea entity = new RubroEmplea();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RubroEmplea();
      	    	entity=super.getEntity("",entity,resultSet,RubroEmpleaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRubroEmplea("",entity,resultSet);
      	    	
				//entity.setRubroEmpleaOriginal( new RubroEmplea());
      	    	//entity.setRubroEmpleaOriginal(super.getEntity("",entity.getRubroEmpleaOriginal(),resultSet,RubroEmpleaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRubroEmpleaOriginal(this.getEntityRubroEmplea("",entity.getRubroEmpleaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseRubroEmpleas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRubroEmplea(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<RubroEmplea> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RubroEmplea> entities = new  ArrayList<RubroEmplea>();
		RubroEmplea entity = new RubroEmplea();		  
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
	
	public  List<RubroEmplea> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RubroEmplea> entities = new  ArrayList<RubroEmplea>();
		RubroEmplea entity = new RubroEmplea();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RubroEmplea();
      	    	entity=super.getEntity("",entity,resultSet,RubroEmpleaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRubroEmplea("",entity,resultSet);
      	    	
				//entity.setRubroEmpleaOriginal( new RubroEmplea());
      	    	//entity.setRubroEmpleaOriginal(super.getEntity("",entity.getRubroEmpleaOriginal(),resultSet,RubroEmpleaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRubroEmpleaOriginal(this.getEntityRubroEmplea("",entity.getRubroEmpleaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRubroEmpleas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public RubroEmplea getEntityRubroEmplea(String strPrefijo,RubroEmplea entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+RubroEmpleaConstantesFunciones.IDEMPRESA));
				entity.setid_tipo_calculo(resultSet.getLong(strPrefijo+RubroEmpleaConstantesFunciones.IDTIPOCALCULO));
				entity.setid_tipo_rubro_emplea(resultSet.getLong(strPrefijo+RubroEmpleaConstantesFunciones.IDTIPORUBROEMPLEA));
				entity.setid_tipo_grupo_rubro_emplea(resultSet.getLong(strPrefijo+RubroEmpleaConstantesFunciones.IDTIPOGRUPORUBROEMPLEA));
				entity.setcodigo(resultSet.getString(strPrefijo+RubroEmpleaConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+RubroEmpleaConstantesFunciones.NOMBRE));
				entity.setformula(resultSet.getString(strPrefijo+RubroEmpleaConstantesFunciones.FORMULA));
				entity.setalias(resultSet.getString(strPrefijo+RubroEmpleaConstantesFunciones.ALIAS));
				entity.setsecuencial(resultSet.getInt(strPrefijo+RubroEmpleaConstantesFunciones.SECUENCIAL));
				entity.setpara_rol_pagos(resultSet.getBoolean(strPrefijo+RubroEmpleaConstantesFunciones.PARAROLPAGOS));
				entity.setpara_sueldo(resultSet.getBoolean(strPrefijo+RubroEmpleaConstantesFunciones.PARASUELDO));
				entity.setpara_vacaciones(resultSet.getBoolean(strPrefijo+RubroEmpleaConstantesFunciones.PARAVACACIONES));
				entity.setpara_impuesto_renta(resultSet.getBoolean(strPrefijo+RubroEmpleaConstantesFunciones.PARAIMPUESTORENTA));
				entity.setpara_seguro_social(resultSet.getBoolean(strPrefijo+RubroEmpleaConstantesFunciones.PARASEGUROSOCIAL));
				entity.setpara_provisiones(resultSet.getBoolean(strPrefijo+RubroEmpleaConstantesFunciones.PARAPROVISIONES));
				entity.setpara_utilidades(resultSet.getBoolean(strPrefijo+RubroEmpleaConstantesFunciones.PARAUTILIDADES));
				entity.setpara_rubro_iess(resultSet.getBoolean(strPrefijo+RubroEmpleaConstantesFunciones.PARARUBROIESS));
				entity.setes_fondo_reserva(resultSet.getBoolean(strPrefijo+RubroEmpleaConstantesFunciones.ESFONDORESERVA));
				entity.setes_decimo_tercero(resultSet.getBoolean(strPrefijo+RubroEmpleaConstantesFunciones.ESDECIMOTERCERO));
				entity.setes_decimo_cuarto(resultSet.getBoolean(strPrefijo+RubroEmpleaConstantesFunciones.ESDECIMOCUARTO));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+RubroEmpleaConstantesFunciones.CODIGO));entity.setnombre(resultSet.getString(strPrefijo+RubroEmpleaConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowRubroEmplea(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(RubroEmplea entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=RubroEmpleaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=RubroEmpleaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=RubroEmpleaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=RubroEmpleaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(RubroEmpleaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,RubroEmpleaDataAccess.TABLENAME,RubroEmpleaDataAccess.ISWITHSTOREPROCEDURES);
			
			RubroEmpleaDataAccess.setRubroEmpleaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,RubroEmplea relrubroemplea)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relrubroemplea.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public TipoCalculo getTipoCalculo(Connexion connexion,RubroEmplea relrubroemplea)throws SQLException,Exception {

		TipoCalculo tipocalculo= new TipoCalculo();

		try {
			TipoCalculoDataAccess tipocalculoDataAccess=new TipoCalculoDataAccess();

			tipocalculoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocalculoDataAccess.setConnexionType(this.connexionType);
			tipocalculoDataAccess.setParameterDbType(this.parameterDbType);

			tipocalculo=tipocalculoDataAccess.getEntity(connexion,relrubroemplea.getid_tipo_calculo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocalculo;

	}

	public TipoRubroEmplea getTipoRubroEmplea(Connexion connexion,RubroEmplea relrubroemplea)throws SQLException,Exception {

		TipoRubroEmplea tiporubroemplea= new TipoRubroEmplea();

		try {
			TipoRubroEmpleaDataAccess tiporubroempleaDataAccess=new TipoRubroEmpleaDataAccess();

			tiporubroempleaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporubroempleaDataAccess.setConnexionType(this.connexionType);
			tiporubroempleaDataAccess.setParameterDbType(this.parameterDbType);

			tiporubroemplea=tiporubroempleaDataAccess.getEntity(connexion,relrubroemplea.getid_tipo_rubro_emplea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporubroemplea;

	}

	public TipoGrupoRubroEmplea getTipoGrupoRubroEmplea(Connexion connexion,RubroEmplea relrubroemplea)throws SQLException,Exception {

		TipoGrupoRubroEmplea tipogruporubroemplea= new TipoGrupoRubroEmplea();

		try {
			TipoGrupoRubroEmpleaDataAccess tipogruporubroempleaDataAccess=new TipoGrupoRubroEmpleaDataAccess();

			tipogruporubroempleaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipogruporubroempleaDataAccess.setConnexionType(this.connexionType);
			tipogruporubroempleaDataAccess.setParameterDbType(this.parameterDbType);

			tipogruporubroemplea=tipogruporubroempleaDataAccess.getEntity(connexion,relrubroemplea.getid_tipo_grupo_rubro_emplea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipogruporubroemplea;

	}


		
		public List<HistorialPagoNomi> getHistorialPagoNomis(Connexion connexion,RubroEmplea rubroemplea)throws SQLException,Exception {

		List<HistorialPagoNomi> historialpagonomis= new ArrayList<HistorialPagoNomi>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+RubroEmpleaConstantesFunciones.SCHEMA+".rubro_emplea ON "+HistorialPagoNomiConstantesFunciones.SCHEMA+".historial_pago_nomi.id_rubro_emplea="+RubroEmpleaConstantesFunciones.SCHEMA+".rubro_emplea.id WHERE "+RubroEmpleaConstantesFunciones.SCHEMA+".rubro_emplea.id="+String.valueOf(rubroemplea.getId());
			} else {
				sQuery=" INNER JOIN historialpagonomi.RubroEmplea WHERE historialpagonomi.RubroEmplea.id="+String.valueOf(rubroemplea.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			HistorialPagoNomiDataAccess historialpagonomiDataAccess=new HistorialPagoNomiDataAccess();

			historialpagonomiDataAccess.setConnexionType(this.connexionType);
			historialpagonomiDataAccess.setParameterDbType(this.parameterDbType);
			historialpagonomis=historialpagonomiDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return historialpagonomis;

	}

	public List<RubroEstructura> getRubroEstructuras(Connexion connexion,RubroEmplea rubroemplea)throws SQLException,Exception {

		List<RubroEstructura> rubroestructuras= new ArrayList<RubroEstructura>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+RubroEmpleaConstantesFunciones.SCHEMA+".rubro_emplea ON "+RubroEstructuraConstantesFunciones.SCHEMA+".rubro_estructura.id_rubro_emplea="+RubroEmpleaConstantesFunciones.SCHEMA+".rubro_emplea.id WHERE "+RubroEmpleaConstantesFunciones.SCHEMA+".rubro_emplea.id="+String.valueOf(rubroemplea.getId());
			} else {
				sQuery=" INNER JOIN rubroestructura.RubroEmplea WHERE rubroestructura.RubroEmplea.id="+String.valueOf(rubroemplea.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			RubroEstructuraDataAccess rubroestructuraDataAccess=new RubroEstructuraDataAccess();

			rubroestructuraDataAccess.setConnexionType(this.connexionType);
			rubroestructuraDataAccess.setParameterDbType(this.parameterDbType);
			rubroestructuras=rubroestructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return rubroestructuras;

	}

	public List<DefiProvisionEmpleado> getDefiProvisionEmpleados(Connexion connexion,RubroEmplea rubroemplea)throws SQLException,Exception {

		List<DefiProvisionEmpleado> defiprovisionempleados= new ArrayList<DefiProvisionEmpleado>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+RubroEmpleaConstantesFunciones.SCHEMA+".rubro_emplea ON "+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+".defi_provision_empleado.id_rubro_emplea="+RubroEmpleaConstantesFunciones.SCHEMA+".rubro_emplea.id WHERE "+RubroEmpleaConstantesFunciones.SCHEMA+".rubro_emplea.id="+String.valueOf(rubroemplea.getId());
			} else {
				sQuery=" INNER JOIN defiprovisionempleado.RubroEmplea WHERE defiprovisionempleado.RubroEmplea.id="+String.valueOf(rubroemplea.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DefiProvisionEmpleadoDataAccess defiprovisionempleadoDataAccess=new DefiProvisionEmpleadoDataAccess();

			defiprovisionempleadoDataAccess.setConnexionType(this.connexionType);
			defiprovisionempleadoDataAccess.setParameterDbType(this.parameterDbType);
			defiprovisionempleados=defiprovisionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return defiprovisionempleados;

	}

	public List<EmpleadoPagoRubro> getEmpleadoPagoRubros(Connexion connexion,RubroEmplea rubroemplea)throws SQLException,Exception {

		List<EmpleadoPagoRubro> empleadopagorubros= new ArrayList<EmpleadoPagoRubro>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+RubroEmpleaConstantesFunciones.SCHEMA+".rubro_emplea ON "+EmpleadoPagoRubroConstantesFunciones.SCHEMA+".empleado_pago_rubro.id_rubro_emplea="+RubroEmpleaConstantesFunciones.SCHEMA+".rubro_emplea.id WHERE "+RubroEmpleaConstantesFunciones.SCHEMA+".rubro_emplea.id="+String.valueOf(rubroemplea.getId());
			} else {
				sQuery=" INNER JOIN empleadopagorubro.RubroEmplea WHERE empleadopagorubro.RubroEmplea.id="+String.valueOf(rubroemplea.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			EmpleadoPagoRubroDataAccess empleadopagorubroDataAccess=new EmpleadoPagoRubroDataAccess();

			empleadopagorubroDataAccess.setConnexionType(this.connexionType);
			empleadopagorubroDataAccess.setParameterDbType(this.parameterDbType);
			empleadopagorubros=empleadopagorubroDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleadopagorubros;

	}

	public List<HistorialPagoMesNomi> getHistorialPagoMesNomis(Connexion connexion,RubroEmplea rubroemplea)throws SQLException,Exception {

		List<HistorialPagoMesNomi> historialpagomesnomis= new ArrayList<HistorialPagoMesNomi>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+RubroEmpleaConstantesFunciones.SCHEMA+".rubro_emplea ON "+HistorialPagoMesNomiConstantesFunciones.SCHEMA+".historial_pago_mes_nomi.id_rubro_emplea="+RubroEmpleaConstantesFunciones.SCHEMA+".rubro_emplea.id WHERE "+RubroEmpleaConstantesFunciones.SCHEMA+".rubro_emplea.id="+String.valueOf(rubroemplea.getId());
			} else {
				sQuery=" INNER JOIN historialpagomesnomi.RubroEmplea WHERE historialpagomesnomi.RubroEmplea.id="+String.valueOf(rubroemplea.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			HistorialPagoMesNomiDataAccess historialpagomesnomiDataAccess=new HistorialPagoMesNomiDataAccess();

			historialpagomesnomiDataAccess.setConnexionType(this.connexionType);
			historialpagomesnomiDataAccess.setParameterDbType(this.parameterDbType);
			historialpagomesnomis=historialpagomesnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return historialpagomesnomis;

	}

	public List<RubroEmpleado> getRubroEmpleados(Connexion connexion,RubroEmplea rubroemplea)throws SQLException,Exception {

		List<RubroEmpleado> rubroempleados= new ArrayList<RubroEmpleado>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+RubroEmpleaConstantesFunciones.SCHEMA+".rubro_emplea ON "+RubroEmpleadoConstantesFunciones.SCHEMA+".rubro_empleado.id_rubro_emplea="+RubroEmpleaConstantesFunciones.SCHEMA+".rubro_emplea.id WHERE "+RubroEmpleaConstantesFunciones.SCHEMA+".rubro_emplea.id="+String.valueOf(rubroemplea.getId());
			} else {
				sQuery=" INNER JOIN rubroempleado.RubroEmplea WHERE rubroempleado.RubroEmplea.id="+String.valueOf(rubroemplea.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			RubroEmpleadoDataAccess rubroempleadoDataAccess=new RubroEmpleadoDataAccess();

			rubroempleadoDataAccess.setConnexionType(this.connexionType);
			rubroempleadoDataAccess.setParameterDbType(this.parameterDbType);
			rubroempleados=rubroempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return rubroempleados;

	}

	public List<ValorRubroVariable> getValorRubroVariables(Connexion connexion,RubroEmplea rubroemplea)throws SQLException,Exception {

		List<ValorRubroVariable> valorrubrovariables= new ArrayList<ValorRubroVariable>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+RubroEmpleaConstantesFunciones.SCHEMA+".rubro_emplea ON "+ValorRubroVariableConstantesFunciones.SCHEMA+".valor_rubro_variable.id_rubro_emplea="+RubroEmpleaConstantesFunciones.SCHEMA+".rubro_emplea.id WHERE "+RubroEmpleaConstantesFunciones.SCHEMA+".rubro_emplea.id="+String.valueOf(rubroemplea.getId());
			} else {
				sQuery=" INNER JOIN valorrubrovariable.RubroEmplea WHERE valorrubrovariable.RubroEmplea.id="+String.valueOf(rubroemplea.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ValorRubroVariableDataAccess valorrubrovariableDataAccess=new ValorRubroVariableDataAccess();

			valorrubrovariableDataAccess.setConnexionType(this.connexionType);
			valorrubrovariableDataAccess.setParameterDbType(this.parameterDbType);
			valorrubrovariables=valorrubrovariableDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return valorrubrovariables;

	}

	public List<TipoPrestamo> getTipoPrestamos(Connexion connexion,RubroEmplea rubroemplea)throws SQLException,Exception {

		List<TipoPrestamo> tipoprestamos= new ArrayList<TipoPrestamo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+RubroEmpleaConstantesFunciones.SCHEMA+".rubro_emplea ON "+TipoPrestamoConstantesFunciones.SCHEMA+".tipo_prestamo.id_rubro_emplea="+RubroEmpleaConstantesFunciones.SCHEMA+".rubro_emplea.id WHERE "+RubroEmpleaConstantesFunciones.SCHEMA+".rubro_emplea.id="+String.valueOf(rubroemplea.getId());
			} else {
				sQuery=" INNER JOIN tipoprestamo.RubroEmplea WHERE tipoprestamo.RubroEmplea.id="+String.valueOf(rubroemplea.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			TipoPrestamoDataAccess tipoprestamoDataAccess=new TipoPrestamoDataAccess();

			tipoprestamoDataAccess.setConnexionType(this.connexionType);
			tipoprestamoDataAccess.setParameterDbType(this.parameterDbType);
			tipoprestamos=tipoprestamoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoprestamos;

	}

	public List<RubroEmpleaCuentaContable> getRubroEmpleaCuentaContables(Connexion connexion,RubroEmplea rubroemplea)throws SQLException,Exception {

		List<RubroEmpleaCuentaContable> rubroempleacuentacontables= new ArrayList<RubroEmpleaCuentaContable>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+RubroEmpleaConstantesFunciones.SCHEMA+".rubro_emplea ON "+RubroEmpleaCuentaContableConstantesFunciones.SCHEMA+".rubro_emplea_cuenta_contable.id_rubro_emplea="+RubroEmpleaConstantesFunciones.SCHEMA+".rubro_emplea.id WHERE "+RubroEmpleaConstantesFunciones.SCHEMA+".rubro_emplea.id="+String.valueOf(rubroemplea.getId());
			} else {
				sQuery=" INNER JOIN rubroempleacuentacontable.RubroEmplea WHERE rubroempleacuentacontable.RubroEmplea.id="+String.valueOf(rubroemplea.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			RubroEmpleaCuentaContableDataAccess rubroempleacuentacontableDataAccess=new RubroEmpleaCuentaContableDataAccess();

			rubroempleacuentacontableDataAccess.setConnexionType(this.connexionType);
			rubroempleacuentacontableDataAccess.setParameterDbType(this.parameterDbType);
			rubroempleacuentacontables=rubroempleacuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return rubroempleacuentacontables;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,RubroEmplea rubroemplea) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!rubroemplea.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(rubroemplea.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_calculo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_calculo.setValue(rubroemplea.getid_tipo_calculo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_calculo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_rubro_emplea=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_rubro_emplea.setValue(rubroemplea.getid_tipo_rubro_emplea());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_rubro_emplea);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_grupo_rubro_emplea=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_grupo_rubro_emplea.setValue(rubroemplea.getid_tipo_grupo_rubro_emplea());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_grupo_rubro_emplea);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(rubroemplea.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(rubroemplea.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueformula=new ParameterValue<String>();
					parameterMaintenanceValueformula.setValue(rubroemplea.getformula());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueformula);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuealias=new ParameterValue<String>();
					parameterMaintenanceValuealias.setValue(rubroemplea.getalias());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuealias);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuesecuencial=new ParameterValue<Integer>();
					parameterMaintenanceValuesecuencial.setValue(rubroemplea.getsecuencial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesecuencial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuepara_rol_pagos=new ParameterValue<Boolean>();
					parameterMaintenanceValuepara_rol_pagos.setValue(rubroemplea.getpara_rol_pagos());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepara_rol_pagos);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuepara_sueldo=new ParameterValue<Boolean>();
					parameterMaintenanceValuepara_sueldo.setValue(rubroemplea.getpara_sueldo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepara_sueldo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuepara_vacaciones=new ParameterValue<Boolean>();
					parameterMaintenanceValuepara_vacaciones.setValue(rubroemplea.getpara_vacaciones());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepara_vacaciones);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuepara_impuesto_renta=new ParameterValue<Boolean>();
					parameterMaintenanceValuepara_impuesto_renta.setValue(rubroemplea.getpara_impuesto_renta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepara_impuesto_renta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuepara_seguro_social=new ParameterValue<Boolean>();
					parameterMaintenanceValuepara_seguro_social.setValue(rubroemplea.getpara_seguro_social());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepara_seguro_social);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuepara_provisiones=new ParameterValue<Boolean>();
					parameterMaintenanceValuepara_provisiones.setValue(rubroemplea.getpara_provisiones());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepara_provisiones);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuepara_utilidades=new ParameterValue<Boolean>();
					parameterMaintenanceValuepara_utilidades.setValue(rubroemplea.getpara_utilidades());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepara_utilidades);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuepara_rubro_iess=new ParameterValue<Boolean>();
					parameterMaintenanceValuepara_rubro_iess.setValue(rubroemplea.getpara_rubro_iess());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepara_rubro_iess);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_fondo_reserva=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_fondo_reserva.setValue(rubroemplea.getes_fondo_reserva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_fondo_reserva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_decimo_tercero=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_decimo_tercero.setValue(rubroemplea.getes_decimo_tercero());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_decimo_tercero);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_decimo_cuarto=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_decimo_cuarto.setValue(rubroemplea.getes_decimo_cuarto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_decimo_cuarto);
					parametersTemp.add(parameterMaintenance);
					
						if(!rubroemplea.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(rubroemplea.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(rubroemplea.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(rubroemplea.getId());
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
	
	public void setIsNewIsChangedFalseRubroEmplea(RubroEmplea rubroemplea)throws Exception  {		
		rubroemplea.setIsNew(false);
		rubroemplea.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseRubroEmpleas(List<RubroEmplea> rubroempleas)throws Exception  {				
		for(RubroEmplea rubroemplea:rubroempleas) {
			rubroemplea.setIsNew(false);
			rubroemplea.setIsChanged(false);
		}
	}
	
	public void generarExportarRubroEmplea(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
