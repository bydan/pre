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
package com.bydan.erp.importaciones.business.dataaccess;

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

import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.importaciones.util.*;//LiquidacionImporConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class LiquidacionImporDataAccess extends  LiquidacionImporDataAccessAdditional{ //LiquidacionImporDataAccessAdditional,DataAccessHelper<LiquidacionImpor>
	//static Logger logger = Logger.getLogger(LiquidacionImporDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="liquidacion_impor";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_centro_costo,id_cuenta_contable,id_pais,id_puerto,nombre,descripcion,fecha,fecha_liquidacion,flete,tipo)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_centro_costo=?,id_cuenta_contable=?,id_pais=?,id_puerto=?,nombre=?,descripcion=?,fecha=?,fecha_liquidacion=?,flete=?,tipo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select liquidacionimpor from "+LiquidacionImporConstantesFunciones.SPERSISTENCENAME+" liquidacionimpor";
	public static String QUERYSELECTNATIVE="select "+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME+".id,"+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME+".version_row,"+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME+".id_empresa,"+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME+".id_sucursal,"+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME+".id_centro_costo,"+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME+".id_cuenta_contable,"+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME+".id_pais,"+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME+".id_puerto,"+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME+".nombre,"+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME+".descripcion,"+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME+".fecha,"+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME+".fecha_liquidacion,"+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME+".flete,"+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME+".tipo from "+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME;//+" as "+LiquidacionImporConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME+".id,"+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME+".version_row,"+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME+".nombre from "+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME;//+" as "+LiquidacionImporConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_centro_costo=?,id_cuenta_contable=?,id_pais=?,id_puerto=?,nombre=?,descripcion=?,fecha=?,fecha_liquidacion=?,flete=?,tipo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_LIQUIDACIONIMPOR_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_LIQUIDACIONIMPOR_UPDATE(?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_LIQUIDACIONIMPOR_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_LIQUIDACIONIMPOR_SELECT(?,?)";
	
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
	
	
	protected LiquidacionImporDataAccessAdditional liquidacionimporDataAccessAdditional=null;
	
	public LiquidacionImporDataAccessAdditional getLiquidacionImporDataAccessAdditional() {
		return this.liquidacionimporDataAccessAdditional;
	}
	
	public void setLiquidacionImporDataAccessAdditional(LiquidacionImporDataAccessAdditional liquidacionimporDataAccessAdditional) {
		try {
			this.liquidacionimporDataAccessAdditional=liquidacionimporDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public LiquidacionImporDataAccess() {
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
		LiquidacionImporDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		LiquidacionImporDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		LiquidacionImporDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setLiquidacionImporOriginal(LiquidacionImpor liquidacionimpor)throws Exception  {
		liquidacionimpor.setLiquidacionImporOriginal((LiquidacionImpor)liquidacionimpor.clone());		
	}
	
	public void setLiquidacionImporsOriginal(List<LiquidacionImpor> liquidacionimpors)throws Exception  {
		
		for(LiquidacionImpor liquidacionimpor:liquidacionimpors){
			liquidacionimpor.setLiquidacionImporOriginal((LiquidacionImpor)liquidacionimpor.clone());
		}
	}
	
	public static void setLiquidacionImporOriginalStatic(LiquidacionImpor liquidacionimpor)throws Exception  {
		liquidacionimpor.setLiquidacionImporOriginal((LiquidacionImpor)liquidacionimpor.clone());		
	}
	
	public static void setLiquidacionImporsOriginalStatic(List<LiquidacionImpor> liquidacionimpors)throws Exception  {
		
		for(LiquidacionImpor liquidacionimpor:liquidacionimpors){
			liquidacionimpor.setLiquidacionImporOriginal((LiquidacionImpor)liquidacionimpor.clone());
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
	
	public  LiquidacionImpor getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		LiquidacionImpor entity = new LiquidacionImpor();		
		
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
	
	public  LiquidacionImpor getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		LiquidacionImpor entity = new LiquidacionImpor();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=LiquidacionImporDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=LiquidacionImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Importaciones.LiquidacionImpor.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setLiquidacionImporOriginal(new LiquidacionImpor());
      	    	entity=super.getEntity("",entity,resultSet,LiquidacionImporDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityLiquidacionImpor("",entity,resultSet); 
				
				//entity.setLiquidacionImporOriginal(super.getEntity("",entity.getLiquidacionImporOriginal(),resultSet,LiquidacionImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setLiquidacionImporOriginal(this.getEntityLiquidacionImpor("",entity.getLiquidacionImporOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseLiquidacionImpor(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  LiquidacionImpor getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		LiquidacionImpor entity = new LiquidacionImpor();
				
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
	
	public  LiquidacionImpor getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		LiquidacionImpor entity = new LiquidacionImpor();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=LiquidacionImporDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=LiquidacionImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,LiquidacionImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Importaciones.LiquidacionImpor.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setLiquidacionImporOriginal(new LiquidacionImpor());
      	    	entity=super.getEntity("",entity,resultSet,LiquidacionImporDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityLiquidacionImpor("",entity,resultSet);    
				
				//entity.setLiquidacionImporOriginal(super.getEntity("",entity.getLiquidacionImporOriginal(),resultSet,LiquidacionImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setLiquidacionImporOriginal(this.getEntityLiquidacionImpor("",entity.getLiquidacionImporOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseLiquidacionImpor(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //LiquidacionImpor
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		LiquidacionImpor entity = new LiquidacionImpor();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=LiquidacionImporDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=LiquidacionImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,LiquidacionImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Importaciones.LiquidacionImpor.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseLiquidacionImpor(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<LiquidacionImpor> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<LiquidacionImpor> entities = new  ArrayList<LiquidacionImpor>();
		LiquidacionImpor entity = new LiquidacionImpor();		  
		
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
	
	public  List<LiquidacionImpor> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<LiquidacionImpor> entities = new  ArrayList<LiquidacionImpor>();
		LiquidacionImpor entity = new LiquidacionImpor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=LiquidacionImporDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=LiquidacionImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,LiquidacionImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new LiquidacionImpor();
      	    	entity=super.getEntity("",entity,resultSet,LiquidacionImporDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityLiquidacionImpor("",entity,resultSet);
      	    	
				//entity.setLiquidacionImporOriginal( new LiquidacionImpor());
      	    	//entity.setLiquidacionImporOriginal(super.getEntity("",entity.getLiquidacionImporOriginal(),resultSet,LiquidacionImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setLiquidacionImporOriginal(this.getEntityLiquidacionImpor("",entity.getLiquidacionImporOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseLiquidacionImpors(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarLiquidacionImpor(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<LiquidacionImpor> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<LiquidacionImpor> entities = new  ArrayList<LiquidacionImpor>();
		LiquidacionImpor entity = new LiquidacionImpor();		  
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
	
	public  List<LiquidacionImpor> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<LiquidacionImpor> entities = new  ArrayList<LiquidacionImpor>();
		LiquidacionImpor entity = new LiquidacionImpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new LiquidacionImpor();
				
				if(conMapGenerico) {
					entity.inicializarMapLiquidacionImpor();
					//entity.setMapLiquidacionImpor(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapLiquidacionImporValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapLiquidacionImpor().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,LiquidacionImporDataAccess.ISWITHSCHEMA);         		
					entity=LiquidacionImporDataAccess.getEntityLiquidacionImpor("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setLiquidacionImporOriginal( new LiquidacionImpor());
					////entity.setLiquidacionImporOriginal(super.getEntity("",entity.getLiquidacionImporOriginal(),resultSet,LiquidacionImporDataAccess.ISWITHSCHEMA));         		
					////entity.setLiquidacionImporOriginal(this.getEntityLiquidacionImpor("",entity.getLiquidacionImporOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseLiquidacionImpors(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarLiquidacionImpor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public LiquidacionImpor getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		LiquidacionImpor entity = new LiquidacionImpor();		  
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
	
	public  LiquidacionImpor getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		LiquidacionImpor entity = new LiquidacionImpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new LiquidacionImpor();
				
				if(conMapGenerico) {
					entity.inicializarMapLiquidacionImpor();
					//entity.setMapLiquidacionImpor(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapLiquidacionImporValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapLiquidacionImpor().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,LiquidacionImporDataAccess.ISWITHSCHEMA);         		
					entity=LiquidacionImporDataAccess.getEntityLiquidacionImpor("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setLiquidacionImporOriginal( new LiquidacionImpor());
					////entity.setLiquidacionImporOriginal(super.getEntity("",entity.getLiquidacionImporOriginal(),resultSet,LiquidacionImporDataAccess.ISWITHSCHEMA));         		
					////entity.setLiquidacionImporOriginal(this.getEntityLiquidacionImpor("",entity.getLiquidacionImporOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseLiquidacionImpor(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarLiquidacionImpor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static LiquidacionImpor getEntityLiquidacionImpor(String strPrefijo,LiquidacionImpor entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = LiquidacionImpor.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = LiquidacionImpor.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					LiquidacionImporDataAccess.setFieldReflectionLiquidacionImpor(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasLiquidacionImpor=LiquidacionImporConstantesFunciones.getTodosTiposColumnasLiquidacionImpor();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasLiquidacionImpor) {
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
							field = LiquidacionImpor.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = LiquidacionImpor.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						LiquidacionImporDataAccess.setFieldReflectionLiquidacionImpor(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionLiquidacionImpor(Field field,String strPrefijo,String sColumn,LiquidacionImpor entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case LiquidacionImporConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case LiquidacionImporConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case LiquidacionImporConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case LiquidacionImporConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case LiquidacionImporConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case LiquidacionImporConstantesFunciones.IDCUENTACONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case LiquidacionImporConstantesFunciones.IDPAIS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case LiquidacionImporConstantesFunciones.IDPUERTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case LiquidacionImporConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case LiquidacionImporConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case LiquidacionImporConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case LiquidacionImporConstantesFunciones.FECHALIQUIDACION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case LiquidacionImporConstantesFunciones.FLETE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case LiquidacionImporConstantesFunciones.TIPO:
					field.set(entity,resultSet.getString(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<LiquidacionImpor>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<LiquidacionImpor> entities = new  ArrayList<LiquidacionImpor>();
		LiquidacionImpor entity = new LiquidacionImpor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=LiquidacionImporDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=LiquidacionImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,LiquidacionImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new LiquidacionImpor();
					entity=super.getEntity("",entity,resultSet,LiquidacionImporDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityLiquidacionImpor("",entity,resultSet);
					
					//entity.setLiquidacionImporOriginal( new LiquidacionImpor());
					//entity.setLiquidacionImporOriginal(super.getEntity("",entity.getLiquidacionImporOriginal(),resultSet,LiquidacionImporDataAccess.ISWITHSCHEMA));         		
					//entity.setLiquidacionImporOriginal(this.getEntityLiquidacionImpor("",entity.getLiquidacionImporOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseLiquidacionImpors(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarLiquidacionImpor(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<LiquidacionImpor>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<LiquidacionImpor> entities = new  ArrayList<LiquidacionImpor>();
		LiquidacionImpor entity = new LiquidacionImpor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=LiquidacionImporDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=LiquidacionImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,LiquidacionImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<LiquidacionImpor> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<LiquidacionImpor> entities = new  ArrayList<LiquidacionImpor>();
		LiquidacionImpor entity = new LiquidacionImpor();		  
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
	
	public  List<LiquidacionImpor> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<LiquidacionImpor> entities = new  ArrayList<LiquidacionImpor>();
		LiquidacionImpor entity = new LiquidacionImpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new LiquidacionImpor();
      	    	entity=super.getEntity("",entity,resultSet,LiquidacionImporDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityLiquidacionImpor("",entity,resultSet);
      	    	
				//entity.setLiquidacionImporOriginal( new LiquidacionImpor());
      	    	//entity.setLiquidacionImporOriginal(super.getEntity("",entity.getLiquidacionImporOriginal(),resultSet,LiquidacionImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setLiquidacionImporOriginal(this.getEntityLiquidacionImpor("",entity.getLiquidacionImporOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseLiquidacionImpors(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarLiquidacionImpor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<LiquidacionImpor> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<LiquidacionImpor> entities = new  ArrayList<LiquidacionImpor>();
		LiquidacionImpor entity = new LiquidacionImpor();		  
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
	
	public  List<LiquidacionImpor> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<LiquidacionImpor> entities = new  ArrayList<LiquidacionImpor>();
		LiquidacionImpor entity = new LiquidacionImpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new LiquidacionImpor();
      	    	entity=super.getEntity("",entity,resultSet,LiquidacionImporDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityLiquidacionImpor("",entity,resultSet);
      	    	
				//entity.setLiquidacionImporOriginal( new LiquidacionImpor());
      	    	//entity.setLiquidacionImporOriginal(super.getEntity("",entity.getLiquidacionImporOriginal(),resultSet,LiquidacionImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setLiquidacionImporOriginal(this.getEntityLiquidacionImpor("",entity.getLiquidacionImporOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseLiquidacionImpors(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public LiquidacionImpor getEntityLiquidacionImpor(String strPrefijo,LiquidacionImpor entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+LiquidacionImporConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+LiquidacionImporConstantesFunciones.IDSUCURSAL));
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+LiquidacionImporConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setid_cuenta_contable(resultSet.getLong(strPrefijo+LiquidacionImporConstantesFunciones.IDCUENTACONTABLE));
				entity.setid_pais(resultSet.getLong(strPrefijo+LiquidacionImporConstantesFunciones.IDPAIS));
				entity.setid_puerto(resultSet.getLong(strPrefijo+LiquidacionImporConstantesFunciones.IDPUERTO));
				entity.setnombre(resultSet.getString(strPrefijo+LiquidacionImporConstantesFunciones.NOMBRE));
				entity.setdescripcion(resultSet.getString(strPrefijo+LiquidacionImporConstantesFunciones.DESCRIPCION));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+LiquidacionImporConstantesFunciones.FECHA).getTime()));
				entity.setfecha_liquidacion(new Date(resultSet.getDate(strPrefijo+LiquidacionImporConstantesFunciones.FECHALIQUIDACION).getTime()));
				entity.setflete(resultSet.getDouble(strPrefijo+LiquidacionImporConstantesFunciones.FLETE));
				entity.settipo(resultSet.getString(strPrefijo+LiquidacionImporConstantesFunciones.TIPO));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+LiquidacionImporConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowLiquidacionImpor(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(LiquidacionImpor entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=LiquidacionImporDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=LiquidacionImporDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=LiquidacionImporDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=LiquidacionImporDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(LiquidacionImporConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,LiquidacionImporDataAccess.TABLENAME,LiquidacionImporDataAccess.ISWITHSTOREPROCEDURES);
			
			LiquidacionImporDataAccess.setLiquidacionImporOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,LiquidacionImpor relliquidacionimpor)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relliquidacionimpor.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,LiquidacionImpor relliquidacionimpor)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relliquidacionimpor.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public CentroCosto getCentroCosto(Connexion connexion,LiquidacionImpor relliquidacionimpor)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,relliquidacionimpor.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}

	public CuentaContable getCuentaContable(Connexion connexion,LiquidacionImpor relliquidacionimpor)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relliquidacionimpor.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public Pais getPais(Connexion connexion,LiquidacionImpor relliquidacionimpor)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,relliquidacionimpor.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}

	public Puerto getPuerto(Connexion connexion,LiquidacionImpor relliquidacionimpor)throws SQLException,Exception {

		Puerto puerto= new Puerto();

		try {
			PuertoDataAccess puertoDataAccess=new PuertoDataAccess();

			puertoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			puertoDataAccess.setConnexionType(this.connexionType);
			puertoDataAccess.setParameterDbType(this.parameterDbType);

			puerto=puertoDataAccess.getEntity(connexion,relliquidacionimpor.getid_puerto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return puerto;

	}


		
		public List<DetalleLiquidacionImpor> getDetalleLiquidacionImpors(Connexion connexion,LiquidacionImpor liquidacionimpor)throws SQLException,Exception {

		List<DetalleLiquidacionImpor> detalleliquidacionimpors= new ArrayList<DetalleLiquidacionImpor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+LiquidacionImporConstantesFunciones.SCHEMA+".liquidacion_impor ON "+DetalleLiquidacionImporConstantesFunciones.SCHEMA+".detalle_liquidacion_impor.id_liquidacion_impor="+LiquidacionImporConstantesFunciones.SCHEMA+".liquidacion_impor.id WHERE "+LiquidacionImporConstantesFunciones.SCHEMA+".liquidacion_impor.id="+String.valueOf(liquidacionimpor.getId());
			} else {
				sQuery=" INNER JOIN detalleliquidacionimpor.LiquidacionImpor WHERE detalleliquidacionimpor.LiquidacionImpor.id="+String.valueOf(liquidacionimpor.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleLiquidacionImporDataAccess detalleliquidacionimporDataAccess=new DetalleLiquidacionImporDataAccess();

			detalleliquidacionimporDataAccess.setConnexionType(this.connexionType);
			detalleliquidacionimporDataAccess.setParameterDbType(this.parameterDbType);
			detalleliquidacionimpors=detalleliquidacionimporDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleliquidacionimpors;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,LiquidacionImpor liquidacionimpor) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!liquidacionimpor.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(liquidacionimpor.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(liquidacionimpor.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(liquidacionimpor.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable.setValue(liquidacionimpor.getid_cuenta_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais.setValue(liquidacionimpor.getid_pais());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_puerto=new ParameterValue<Long>();
					parameterMaintenanceValueid_puerto.setValue(liquidacionimpor.getid_puerto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_puerto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(liquidacionimpor.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(liquidacionimpor.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(liquidacionimpor.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_liquidacion=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_liquidacion.setValue(liquidacionimpor.getfecha_liquidacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_liquidacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueflete=new ParameterValue<Double>();
					parameterMaintenanceValueflete.setValue(liquidacionimpor.getflete());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueflete);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetipo=new ParameterValue<String>();
					parameterMaintenanceValuetipo.setValue(liquidacionimpor.gettipo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetipo);
					parametersTemp.add(parameterMaintenance);
					
						if(!liquidacionimpor.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(liquidacionimpor.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(liquidacionimpor.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(liquidacionimpor.getId());
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
	
	public void setIsNewIsChangedFalseLiquidacionImpor(LiquidacionImpor liquidacionimpor)throws Exception  {		
		liquidacionimpor.setIsNew(false);
		liquidacionimpor.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseLiquidacionImpors(List<LiquidacionImpor> liquidacionimpors)throws Exception  {				
		for(LiquidacionImpor liquidacionimpor:liquidacionimpors) {
			liquidacionimpor.setIsNew(false);
			liquidacionimpor.setIsChanged(false);
		}
	}
	
	public void generarExportarLiquidacionImpor(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
