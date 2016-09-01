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
package com.bydan.erp.inventario.business.dataaccess;

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

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.util.*;//CentroCostoValorConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class CentroCostoValorDataAccess extends  CentroCostoValorDataAccessAdditional{ //CentroCostoValorDataAccessAdditional,DataAccessHelper<CentroCostoValor>
	//static Logger logger = Logger.getLogger(CentroCostoValorDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="centro_costo_valor";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_centro_costo,nombre,enero,febrero,marzo,abril,mayo,junio,julio,agosto,septiembre,octubre,noviembre,diciembre)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_centro_costo=?,nombre=?,enero=?,febrero=?,marzo=?,abril=?,mayo=?,junio=?,julio=?,agosto=?,septiembre=?,octubre=?,noviembre=?,diciembre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select centrocostovalor from "+CentroCostoValorConstantesFunciones.SPERSISTENCENAME+" centrocostovalor";
	public static String QUERYSELECTNATIVE="select "+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".id,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".version_row,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".id_empresa,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".id_sucursal,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".id_ejercicio,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".id_centro_costo,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".nombre,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".enero,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".febrero,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".marzo,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".abril,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".mayo,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".junio,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".julio,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".agosto,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".septiembre,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".octubre,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".noviembre,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".diciembre from "+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME;//+" as "+CentroCostoValorConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".id,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".version_row,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".nombre from "+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME;//+" as "+CentroCostoValorConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_centro_costo=?,nombre=?,enero=?,febrero=?,marzo=?,abril=?,mayo=?,junio=?,julio=?,agosto=?,septiembre=?,octubre=?,noviembre=?,diciembre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_CENTROCOSTOVALOR_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_CENTROCOSTOVALOR_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_CENTROCOSTOVALOR_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_CENTROCOSTOVALOR_SELECT(?,?)";
	
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
	
	
	protected CentroCostoValorDataAccessAdditional centrocostovalorDataAccessAdditional=null;
	
	public CentroCostoValorDataAccessAdditional getCentroCostoValorDataAccessAdditional() {
		return this.centrocostovalorDataAccessAdditional;
	}
	
	public void setCentroCostoValorDataAccessAdditional(CentroCostoValorDataAccessAdditional centrocostovalorDataAccessAdditional) {
		try {
			this.centrocostovalorDataAccessAdditional=centrocostovalorDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public CentroCostoValorDataAccess() {
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
		CentroCostoValorDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		CentroCostoValorDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		CentroCostoValorDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setCentroCostoValorOriginal(CentroCostoValor centrocostovalor)throws Exception  {
		centrocostovalor.setCentroCostoValorOriginal((CentroCostoValor)centrocostovalor.clone());		
	}
	
	public void setCentroCostoValorsOriginal(List<CentroCostoValor> centrocostovalors)throws Exception  {
		
		for(CentroCostoValor centrocostovalor:centrocostovalors){
			centrocostovalor.setCentroCostoValorOriginal((CentroCostoValor)centrocostovalor.clone());
		}
	}
	
	public static void setCentroCostoValorOriginalStatic(CentroCostoValor centrocostovalor)throws Exception  {
		centrocostovalor.setCentroCostoValorOriginal((CentroCostoValor)centrocostovalor.clone());		
	}
	
	public static void setCentroCostoValorsOriginalStatic(List<CentroCostoValor> centrocostovalors)throws Exception  {
		
		for(CentroCostoValor centrocostovalor:centrocostovalors){
			centrocostovalor.setCentroCostoValorOriginal((CentroCostoValor)centrocostovalor.clone());
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
	
	public  CentroCostoValor getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		CentroCostoValor entity = new CentroCostoValor();		
		
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
	
	public  CentroCostoValor getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		CentroCostoValor entity = new CentroCostoValor();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CentroCostoValorDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CentroCostoValorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.CentroCostoValor.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setCentroCostoValorOriginal(new CentroCostoValor());
      	    	entity=super.getEntity("",entity,resultSet,CentroCostoValorDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCentroCostoValor("",entity,resultSet); 
				
				//entity.setCentroCostoValorOriginal(super.getEntity("",entity.getCentroCostoValorOriginal(),resultSet,CentroCostoValorDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCentroCostoValorOriginal(this.getEntityCentroCostoValor("",entity.getCentroCostoValorOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseCentroCostoValor(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  CentroCostoValor getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CentroCostoValor entity = new CentroCostoValor();
				
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
	
	public  CentroCostoValor getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CentroCostoValor entity = new CentroCostoValor();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CentroCostoValorDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CentroCostoValorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CentroCostoValorDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.CentroCostoValor.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setCentroCostoValorOriginal(new CentroCostoValor());
      	    	entity=super.getEntity("",entity,resultSet,CentroCostoValorDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCentroCostoValor("",entity,resultSet);    
				
				//entity.setCentroCostoValorOriginal(super.getEntity("",entity.getCentroCostoValorOriginal(),resultSet,CentroCostoValorDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCentroCostoValorOriginal(this.getEntityCentroCostoValor("",entity.getCentroCostoValorOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseCentroCostoValor(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //CentroCostoValor
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		CentroCostoValor entity = new CentroCostoValor();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CentroCostoValorDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CentroCostoValorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CentroCostoValorDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.CentroCostoValor.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseCentroCostoValor(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<CentroCostoValor> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CentroCostoValor> entities = new  ArrayList<CentroCostoValor>();
		CentroCostoValor entity = new CentroCostoValor();		  
		
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
	
	public  List<CentroCostoValor> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CentroCostoValor> entities = new  ArrayList<CentroCostoValor>();
		CentroCostoValor entity = new CentroCostoValor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=CentroCostoValorDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CentroCostoValorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CentroCostoValorDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CentroCostoValor();
      	    	entity=super.getEntity("",entity,resultSet,CentroCostoValorDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCentroCostoValor("",entity,resultSet);
      	    	
				//entity.setCentroCostoValorOriginal( new CentroCostoValor());
      	    	//entity.setCentroCostoValorOriginal(super.getEntity("",entity.getCentroCostoValorOriginal(),resultSet,CentroCostoValorDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCentroCostoValorOriginal(this.getEntityCentroCostoValor("",entity.getCentroCostoValorOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCentroCostoValors(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCentroCostoValor(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CentroCostoValor> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CentroCostoValor> entities = new  ArrayList<CentroCostoValor>();
		CentroCostoValor entity = new CentroCostoValor();		  
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
	
	public  List<CentroCostoValor> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CentroCostoValor> entities = new  ArrayList<CentroCostoValor>();
		CentroCostoValor entity = new CentroCostoValor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CentroCostoValor();
				
				if(conMapGenerico) {
					entity.inicializarMapCentroCostoValor();
					//entity.setMapCentroCostoValor(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapCentroCostoValorValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCentroCostoValor().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CentroCostoValorDataAccess.ISWITHSCHEMA);         		
					entity=CentroCostoValorDataAccess.getEntityCentroCostoValor("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCentroCostoValorOriginal( new CentroCostoValor());
					////entity.setCentroCostoValorOriginal(super.getEntity("",entity.getCentroCostoValorOriginal(),resultSet,CentroCostoValorDataAccess.ISWITHSCHEMA));         		
					////entity.setCentroCostoValorOriginal(this.getEntityCentroCostoValor("",entity.getCentroCostoValorOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCentroCostoValors(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCentroCostoValor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public CentroCostoValor getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CentroCostoValor entity = new CentroCostoValor();		  
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
	
	public  CentroCostoValor getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CentroCostoValor entity = new CentroCostoValor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CentroCostoValor();
				
				if(conMapGenerico) {
					entity.inicializarMapCentroCostoValor();
					//entity.setMapCentroCostoValor(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapCentroCostoValorValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCentroCostoValor().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CentroCostoValorDataAccess.ISWITHSCHEMA);         		
					entity=CentroCostoValorDataAccess.getEntityCentroCostoValor("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCentroCostoValorOriginal( new CentroCostoValor());
					////entity.setCentroCostoValorOriginal(super.getEntity("",entity.getCentroCostoValorOriginal(),resultSet,CentroCostoValorDataAccess.ISWITHSCHEMA));         		
					////entity.setCentroCostoValorOriginal(this.getEntityCentroCostoValor("",entity.getCentroCostoValorOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseCentroCostoValor(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCentroCostoValor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CentroCostoValor getEntityCentroCostoValor(String strPrefijo,CentroCostoValor entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = CentroCostoValor.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = CentroCostoValor.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					CentroCostoValorDataAccess.setFieldReflectionCentroCostoValor(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasCentroCostoValor=CentroCostoValorConstantesFunciones.getTodosTiposColumnasCentroCostoValor();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasCentroCostoValor) {
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
							field = CentroCostoValor.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = CentroCostoValor.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						CentroCostoValorDataAccess.setFieldReflectionCentroCostoValor(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCentroCostoValor(Field field,String strPrefijo,String sColumn,CentroCostoValor entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CentroCostoValorConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CentroCostoValorConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CentroCostoValorConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CentroCostoValorConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CentroCostoValorConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CentroCostoValorConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CentroCostoValorConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CentroCostoValorConstantesFunciones.ENERO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CentroCostoValorConstantesFunciones.FEBRERO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CentroCostoValorConstantesFunciones.MARZO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CentroCostoValorConstantesFunciones.ABRIL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CentroCostoValorConstantesFunciones.MAYO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CentroCostoValorConstantesFunciones.JUNIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CentroCostoValorConstantesFunciones.JULIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CentroCostoValorConstantesFunciones.AGOSTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CentroCostoValorConstantesFunciones.SEPTIEMBRE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CentroCostoValorConstantesFunciones.OCTUBRE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CentroCostoValorConstantesFunciones.NOVIEMBRE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CentroCostoValorConstantesFunciones.DICIEMBRE:
					field.set(entity,resultSet.getDouble(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CentroCostoValor>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<CentroCostoValor> entities = new  ArrayList<CentroCostoValor>();
		CentroCostoValor entity = new CentroCostoValor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CentroCostoValorDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CentroCostoValorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CentroCostoValorDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new CentroCostoValor();
					entity=super.getEntity("",entity,resultSet,CentroCostoValorDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityCentroCostoValor("",entity,resultSet);
					
					//entity.setCentroCostoValorOriginal( new CentroCostoValor());
					//entity.setCentroCostoValorOriginal(super.getEntity("",entity.getCentroCostoValorOriginal(),resultSet,CentroCostoValorDataAccess.ISWITHSCHEMA));         		
					//entity.setCentroCostoValorOriginal(this.getEntityCentroCostoValor("",entity.getCentroCostoValorOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseCentroCostoValors(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCentroCostoValor(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CentroCostoValor>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<CentroCostoValor> entities = new  ArrayList<CentroCostoValor>();
		CentroCostoValor entity = new CentroCostoValor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CentroCostoValorDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CentroCostoValorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CentroCostoValorDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<CentroCostoValor> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CentroCostoValor> entities = new  ArrayList<CentroCostoValor>();
		CentroCostoValor entity = new CentroCostoValor();		  
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
	
	public  List<CentroCostoValor> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CentroCostoValor> entities = new  ArrayList<CentroCostoValor>();
		CentroCostoValor entity = new CentroCostoValor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CentroCostoValor();
      	    	entity=super.getEntity("",entity,resultSet,CentroCostoValorDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCentroCostoValor("",entity,resultSet);
      	    	
				//entity.setCentroCostoValorOriginal( new CentroCostoValor());
      	    	//entity.setCentroCostoValorOriginal(super.getEntity("",entity.getCentroCostoValorOriginal(),resultSet,CentroCostoValorDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCentroCostoValorOriginal(this.getEntityCentroCostoValor("",entity.getCentroCostoValorOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseCentroCostoValors(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCentroCostoValor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CentroCostoValor> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CentroCostoValor> entities = new  ArrayList<CentroCostoValor>();
		CentroCostoValor entity = new CentroCostoValor();		  
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
	
	public  List<CentroCostoValor> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CentroCostoValor> entities = new  ArrayList<CentroCostoValor>();
		CentroCostoValor entity = new CentroCostoValor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CentroCostoValor();
      	    	entity=super.getEntity("",entity,resultSet,CentroCostoValorDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCentroCostoValor("",entity,resultSet);
      	    	
				//entity.setCentroCostoValorOriginal( new CentroCostoValor());
      	    	//entity.setCentroCostoValorOriginal(super.getEntity("",entity.getCentroCostoValorOriginal(),resultSet,CentroCostoValorDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCentroCostoValorOriginal(this.getEntityCentroCostoValor("",entity.getCentroCostoValorOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCentroCostoValors(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public CentroCostoValor getEntityCentroCostoValor(String strPrefijo,CentroCostoValor entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+CentroCostoValorConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+CentroCostoValorConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+CentroCostoValorConstantesFunciones.IDEJERCICIO));
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+CentroCostoValorConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setnombre(resultSet.getString(strPrefijo+CentroCostoValorConstantesFunciones.NOMBRE));
				entity.setenero(resultSet.getDouble(strPrefijo+CentroCostoValorConstantesFunciones.ENERO));
				entity.setfebrero(resultSet.getDouble(strPrefijo+CentroCostoValorConstantesFunciones.FEBRERO));
				entity.setmarzo(resultSet.getDouble(strPrefijo+CentroCostoValorConstantesFunciones.MARZO));
				entity.setabril(resultSet.getDouble(strPrefijo+CentroCostoValorConstantesFunciones.ABRIL));
				entity.setmayo(resultSet.getDouble(strPrefijo+CentroCostoValorConstantesFunciones.MAYO));
				entity.setjunio(resultSet.getDouble(strPrefijo+CentroCostoValorConstantesFunciones.JUNIO));
				entity.setjulio(resultSet.getDouble(strPrefijo+CentroCostoValorConstantesFunciones.JULIO));
				entity.setagosto(resultSet.getDouble(strPrefijo+CentroCostoValorConstantesFunciones.AGOSTO));
				entity.setseptiembre(resultSet.getDouble(strPrefijo+CentroCostoValorConstantesFunciones.SEPTIEMBRE));
				entity.setoctubre(resultSet.getDouble(strPrefijo+CentroCostoValorConstantesFunciones.OCTUBRE));
				entity.setnoviembre(resultSet.getDouble(strPrefijo+CentroCostoValorConstantesFunciones.NOVIEMBRE));
				entity.setdiciembre(resultSet.getDouble(strPrefijo+CentroCostoValorConstantesFunciones.DICIEMBRE));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+CentroCostoValorConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowCentroCostoValor(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(CentroCostoValor entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=CentroCostoValorDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=CentroCostoValorDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=CentroCostoValorDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=CentroCostoValorDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(CentroCostoValorConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,CentroCostoValorDataAccess.TABLENAME,CentroCostoValorDataAccess.ISWITHSTOREPROCEDURES);
			
			CentroCostoValorDataAccess.setCentroCostoValorOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,CentroCostoValor relcentrocostovalor)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relcentrocostovalor.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,CentroCostoValor relcentrocostovalor)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relcentrocostovalor.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,CentroCostoValor relcentrocostovalor)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relcentrocostovalor.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public CentroCosto getCentroCosto(Connexion connexion,CentroCostoValor relcentrocostovalor)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,relcentrocostovalor.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,CentroCostoValor centrocostovalor) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!centrocostovalor.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(centrocostovalor.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(centrocostovalor.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(centrocostovalor.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(centrocostovalor.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(centrocostovalor.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueenero=new ParameterValue<Double>();
					parameterMaintenanceValueenero.setValue(centrocostovalor.getenero());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueenero);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuefebrero=new ParameterValue<Double>();
					parameterMaintenanceValuefebrero.setValue(centrocostovalor.getfebrero());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefebrero);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemarzo=new ParameterValue<Double>();
					parameterMaintenanceValuemarzo.setValue(centrocostovalor.getmarzo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemarzo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueabril=new ParameterValue<Double>();
					parameterMaintenanceValueabril.setValue(centrocostovalor.getabril());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueabril);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemayo=new ParameterValue<Double>();
					parameterMaintenanceValuemayo.setValue(centrocostovalor.getmayo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemayo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuejunio=new ParameterValue<Double>();
					parameterMaintenanceValuejunio.setValue(centrocostovalor.getjunio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuejunio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuejulio=new ParameterValue<Double>();
					parameterMaintenanceValuejulio.setValue(centrocostovalor.getjulio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuejulio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueagosto=new ParameterValue<Double>();
					parameterMaintenanceValueagosto.setValue(centrocostovalor.getagosto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueagosto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueseptiembre=new ParameterValue<Double>();
					parameterMaintenanceValueseptiembre.setValue(centrocostovalor.getseptiembre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueseptiembre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueoctubre=new ParameterValue<Double>();
					parameterMaintenanceValueoctubre.setValue(centrocostovalor.getoctubre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueoctubre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuenoviembre=new ParameterValue<Double>();
					parameterMaintenanceValuenoviembre.setValue(centrocostovalor.getnoviembre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenoviembre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuediciembre=new ParameterValue<Double>();
					parameterMaintenanceValuediciembre.setValue(centrocostovalor.getdiciembre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuediciembre);
					parametersTemp.add(parameterMaintenance);
					
						if(!centrocostovalor.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(centrocostovalor.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(centrocostovalor.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(centrocostovalor.getId());
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
	
	public void setIsNewIsChangedFalseCentroCostoValor(CentroCostoValor centrocostovalor)throws Exception  {		
		centrocostovalor.setIsNew(false);
		centrocostovalor.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseCentroCostoValors(List<CentroCostoValor> centrocostovalors)throws Exception  {				
		for(CentroCostoValor centrocostovalor:centrocostovalors) {
			centrocostovalor.setIsNew(false);
			centrocostovalor.setIsChanged(false);
		}
	}
	
	public void generarExportarCentroCostoValor(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
