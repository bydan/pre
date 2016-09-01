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
package com.bydan.erp.puntoventa.business.dataaccess;

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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.util.*;//TipoPagoTarjetaConstantesFunciones;










@SuppressWarnings("unused")
final public class TipoPagoTarjetaDataAccess extends  DataAccessHelperSinIdGenerated<TipoPagoTarjeta>{ //TipoPagoTarjetaDataAccessAdditional,DataAccessHelper<TipoPagoTarjeta>
	//static Logger logger = Logger.getLogger(TipoPagoTarjetaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_pago_tarjeta";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoPagoTarjetaConstantesFunciones.SCHEMA+"."+TipoPagoTarjetaConstantesFunciones.TABLENAME+"(id,version_row,nombre,descripcion)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+TipoPagoTarjetaConstantesFunciones.SCHEMA+"."+TipoPagoTarjetaConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoPagoTarjetaConstantesFunciones.SCHEMA+"."+TipoPagoTarjetaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipopagotarjeta from "+TipoPagoTarjetaConstantesFunciones.SPERSISTENCENAME+" tipopagotarjeta";
	public static String QUERYSELECTNATIVE="select "+TipoPagoTarjetaConstantesFunciones.SCHEMA+"."+TipoPagoTarjetaConstantesFunciones.TABLENAME+".id,"+TipoPagoTarjetaConstantesFunciones.SCHEMA+"."+TipoPagoTarjetaConstantesFunciones.TABLENAME+".version_row,"+TipoPagoTarjetaConstantesFunciones.SCHEMA+"."+TipoPagoTarjetaConstantesFunciones.TABLENAME+".nombre,"+TipoPagoTarjetaConstantesFunciones.SCHEMA+"."+TipoPagoTarjetaConstantesFunciones.TABLENAME+".descripcion from "+TipoPagoTarjetaConstantesFunciones.SCHEMA+"."+TipoPagoTarjetaConstantesFunciones.TABLENAME;//+" as "+TipoPagoTarjetaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoPagoTarjetaConstantesFunciones.SCHEMA+"."+TipoPagoTarjetaConstantesFunciones.TABLENAME+".id,"+TipoPagoTarjetaConstantesFunciones.SCHEMA+"."+TipoPagoTarjetaConstantesFunciones.TABLENAME+".version_row,"+TipoPagoTarjetaConstantesFunciones.SCHEMA+"."+TipoPagoTarjetaConstantesFunciones.TABLENAME+".nombre from "+TipoPagoTarjetaConstantesFunciones.SCHEMA+"."+TipoPagoTarjetaConstantesFunciones.TABLENAME;//+" as "+TipoPagoTarjetaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoPagoTarjetaConstantesFunciones.SCHEMA+"."+TipoPagoTarjetaConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOPAGOTARJETA_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOPAGOTARJETA_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOPAGOTARJETA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOPAGOTARJETA_SELECT(?,?)";
	
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
	
	
	public TipoPagoTarjetaDataAccess() {
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
		TipoPagoTarjetaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoPagoTarjetaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoPagoTarjetaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoPagoTarjetaOriginal(TipoPagoTarjeta tipopagotarjeta)throws Exception  {
		tipopagotarjeta.setTipoPagoTarjetaOriginal((TipoPagoTarjeta)tipopagotarjeta.clone());		
	}
	
	public void setTipoPagoTarjetasOriginal(List<TipoPagoTarjeta> tipopagotarjetas)throws Exception  {
		
		for(TipoPagoTarjeta tipopagotarjeta:tipopagotarjetas){
			tipopagotarjeta.setTipoPagoTarjetaOriginal((TipoPagoTarjeta)tipopagotarjeta.clone());
		}
	}
	
	public static void setTipoPagoTarjetaOriginalStatic(TipoPagoTarjeta tipopagotarjeta)throws Exception  {
		tipopagotarjeta.setTipoPagoTarjetaOriginal((TipoPagoTarjeta)tipopagotarjeta.clone());		
	}
	
	public static void setTipoPagoTarjetasOriginalStatic(List<TipoPagoTarjeta> tipopagotarjetas)throws Exception  {
		
		for(TipoPagoTarjeta tipopagotarjeta:tipopagotarjetas){
			tipopagotarjeta.setTipoPagoTarjetaOriginal((TipoPagoTarjeta)tipopagotarjeta.clone());
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
	
	public  TipoPagoTarjeta getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoPagoTarjeta entity = new TipoPagoTarjeta();		
		
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
	
	public  TipoPagoTarjeta getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoPagoTarjeta entity = new TipoPagoTarjeta();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoPagoTarjetaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoPagoTarjetaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//PuntoVenta.TipoPagoTarjeta.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoPagoTarjetaOriginal(new TipoPagoTarjeta());
      	    	entity=super.getEntity("",entity,resultSet,TipoPagoTarjetaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoPagoTarjeta("",entity,resultSet); 
				
				//entity.setTipoPagoTarjetaOriginal(super.getEntity("",entity.getTipoPagoTarjetaOriginal(),resultSet,TipoPagoTarjetaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoPagoTarjetaOriginal(this.getEntityTipoPagoTarjeta("",entity.getTipoPagoTarjetaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoPagoTarjeta(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoPagoTarjeta getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoPagoTarjeta entity = new TipoPagoTarjeta();
				
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
	
	public  TipoPagoTarjeta getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoPagoTarjeta entity = new TipoPagoTarjeta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoPagoTarjetaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoPagoTarjetaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoPagoTarjetaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.TipoPagoTarjeta.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoPagoTarjetaOriginal(new TipoPagoTarjeta());
      	    	entity=super.getEntity("",entity,resultSet,TipoPagoTarjetaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoPagoTarjeta("",entity,resultSet);    
				
				//entity.setTipoPagoTarjetaOriginal(super.getEntity("",entity.getTipoPagoTarjetaOriginal(),resultSet,TipoPagoTarjetaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoPagoTarjetaOriginal(this.getEntityTipoPagoTarjeta("",entity.getTipoPagoTarjetaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoPagoTarjeta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoPagoTarjeta
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoPagoTarjeta entity = new TipoPagoTarjeta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoPagoTarjetaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoPagoTarjetaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoPagoTarjetaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.TipoPagoTarjeta.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoPagoTarjeta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoPagoTarjeta> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoPagoTarjeta> entities = new  ArrayList<TipoPagoTarjeta>();
		TipoPagoTarjeta entity = new TipoPagoTarjeta();		  
		
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
	
	public  List<TipoPagoTarjeta> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoPagoTarjeta> entities = new  ArrayList<TipoPagoTarjeta>();
		TipoPagoTarjeta entity = new TipoPagoTarjeta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoPagoTarjetaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoPagoTarjetaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoPagoTarjetaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoPagoTarjeta();
      	    	entity=super.getEntity("",entity,resultSet,TipoPagoTarjetaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoPagoTarjeta("",entity,resultSet);
      	    	
				//entity.setTipoPagoTarjetaOriginal( new TipoPagoTarjeta());
      	    	//entity.setTipoPagoTarjetaOriginal(super.getEntity("",entity.getTipoPagoTarjetaOriginal(),resultSet,TipoPagoTarjetaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoPagoTarjetaOriginal(this.getEntityTipoPagoTarjeta("",entity.getTipoPagoTarjetaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoPagoTarjetas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoPagoTarjeta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoPagoTarjeta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoPagoTarjeta> entities = new  ArrayList<TipoPagoTarjeta>();
		TipoPagoTarjeta entity = new TipoPagoTarjeta();		  
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
	
	public  List<TipoPagoTarjeta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoPagoTarjeta> entities = new  ArrayList<TipoPagoTarjeta>();
		TipoPagoTarjeta entity = new TipoPagoTarjeta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoPagoTarjeta();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoPagoTarjeta();
					//entity.setMapTipoPagoTarjeta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoPagoTarjetaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoPagoTarjeta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoPagoTarjetaDataAccess.ISWITHSCHEMA);         		
					entity=TipoPagoTarjetaDataAccess.getEntityTipoPagoTarjeta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoPagoTarjetaOriginal( new TipoPagoTarjeta());
					////entity.setTipoPagoTarjetaOriginal(super.getEntity("",entity.getTipoPagoTarjetaOriginal(),resultSet,TipoPagoTarjetaDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoPagoTarjetaOriginal(this.getEntityTipoPagoTarjeta("",entity.getTipoPagoTarjetaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoPagoTarjetas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoPagoTarjeta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoPagoTarjeta getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoPagoTarjeta entity = new TipoPagoTarjeta();		  
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
	
	public  TipoPagoTarjeta getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoPagoTarjeta entity = new TipoPagoTarjeta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoPagoTarjeta();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoPagoTarjeta();
					//entity.setMapTipoPagoTarjeta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoPagoTarjetaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoPagoTarjeta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoPagoTarjetaDataAccess.ISWITHSCHEMA);         		
					entity=TipoPagoTarjetaDataAccess.getEntityTipoPagoTarjeta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoPagoTarjetaOriginal( new TipoPagoTarjeta());
					////entity.setTipoPagoTarjetaOriginal(super.getEntity("",entity.getTipoPagoTarjetaOriginal(),resultSet,TipoPagoTarjetaDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoPagoTarjetaOriginal(this.getEntityTipoPagoTarjeta("",entity.getTipoPagoTarjetaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoPagoTarjeta(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoPagoTarjeta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoPagoTarjeta getEntityTipoPagoTarjeta(String strPrefijo,TipoPagoTarjeta entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoPagoTarjeta.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoPagoTarjeta.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoPagoTarjetaDataAccess.setFieldReflectionTipoPagoTarjeta(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoPagoTarjeta=TipoPagoTarjetaConstantesFunciones.getTodosTiposColumnasTipoPagoTarjeta();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoPagoTarjeta) {
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
							field = TipoPagoTarjeta.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoPagoTarjeta.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoPagoTarjetaDataAccess.setFieldReflectionTipoPagoTarjeta(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoPagoTarjeta(Field field,String strPrefijo,String sColumn,TipoPagoTarjeta entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoPagoTarjetaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoPagoTarjetaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoPagoTarjetaConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoPagoTarjetaConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoPagoTarjeta>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoPagoTarjeta> entities = new  ArrayList<TipoPagoTarjeta>();
		TipoPagoTarjeta entity = new TipoPagoTarjeta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoPagoTarjetaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoPagoTarjetaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoPagoTarjetaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoPagoTarjeta();
					entity=super.getEntity("",entity,resultSet,TipoPagoTarjetaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoPagoTarjeta("",entity,resultSet);
					
					//entity.setTipoPagoTarjetaOriginal( new TipoPagoTarjeta());
					//entity.setTipoPagoTarjetaOriginal(super.getEntity("",entity.getTipoPagoTarjetaOriginal(),resultSet,TipoPagoTarjetaDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoPagoTarjetaOriginal(this.getEntityTipoPagoTarjeta("",entity.getTipoPagoTarjetaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoPagoTarjetas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoPagoTarjeta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoPagoTarjeta>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoPagoTarjeta> entities = new  ArrayList<TipoPagoTarjeta>();
		TipoPagoTarjeta entity = new TipoPagoTarjeta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoPagoTarjetaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoPagoTarjetaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoPagoTarjetaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoPagoTarjeta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoPagoTarjeta> entities = new  ArrayList<TipoPagoTarjeta>();
		TipoPagoTarjeta entity = new TipoPagoTarjeta();		  
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
	
	public  List<TipoPagoTarjeta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoPagoTarjeta> entities = new  ArrayList<TipoPagoTarjeta>();
		TipoPagoTarjeta entity = new TipoPagoTarjeta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoPagoTarjeta();
      	    	entity=super.getEntity("",entity,resultSet,TipoPagoTarjetaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoPagoTarjeta("",entity,resultSet);
      	    	
				//entity.setTipoPagoTarjetaOriginal( new TipoPagoTarjeta());
      	    	//entity.setTipoPagoTarjetaOriginal(super.getEntity("",entity.getTipoPagoTarjetaOriginal(),resultSet,TipoPagoTarjetaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoPagoTarjetaOriginal(this.getEntityTipoPagoTarjeta("",entity.getTipoPagoTarjetaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoPagoTarjetas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoPagoTarjeta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public TipoPagoTarjeta getEntityTipoPagoTarjeta(String strPrefijo,TipoPagoTarjeta entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setnombre(resultSet.getString(strPrefijo+TipoPagoTarjetaConstantesFunciones.NOMBRE));
				entity.setdescripcion(resultSet.getString(strPrefijo+TipoPagoTarjetaConstantesFunciones.DESCRIPCION));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TipoPagoTarjetaConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoPagoTarjeta(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoPagoTarjeta entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoPagoTarjetaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoPagoTarjetaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoPagoTarjetaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoPagoTarjetaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoPagoTarjetaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TipoPagoTarjetaDataAccess.TABLENAME,TipoPagoTarjetaDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoPagoTarjetaDataAccess.setTipoPagoTarjetaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<FormaPagoPuntoVenta> getFormaPagoPuntoVentas(Connexion connexion,TipoPagoTarjeta tipopagotarjeta)throws SQLException,Exception {

		List<FormaPagoPuntoVenta> formapagopuntoventas= new ArrayList<FormaPagoPuntoVenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoPagoTarjetaConstantesFunciones.SCHEMA+".tipo_pago_tarjeta ON "+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+".forma_pago_punto_venta.id_tipo_pago_tarjeta="+TipoPagoTarjetaConstantesFunciones.SCHEMA+".tipo_pago_tarjeta.id WHERE "+TipoPagoTarjetaConstantesFunciones.SCHEMA+".tipo_pago_tarjeta.id="+String.valueOf(tipopagotarjeta.getId());
			} else {
				sQuery=" INNER JOIN formapagopuntoventa.TipoPagoTarjeta WHERE formapagopuntoventa.TipoPagoTarjeta.id="+String.valueOf(tipopagotarjeta.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FormaPagoPuntoVentaDataAccess formapagopuntoventaDataAccess=new FormaPagoPuntoVentaDataAccess();

			formapagopuntoventaDataAccess.setConnexionType(this.connexionType);
			formapagopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formapagopuntoventas;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoPagoTarjeta tipopagotarjeta) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipopagotarjeta.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(tipopagotarjeta.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipopagotarjeta.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(tipopagotarjeta.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipopagotarjeta.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipopagotarjeta.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipopagotarjeta.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipopagotarjeta.getId());
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
	
	public void setIsNewIsChangedFalseTipoPagoTarjeta(TipoPagoTarjeta tipopagotarjeta)throws Exception  {		
		tipopagotarjeta.setIsNew(false);
		tipopagotarjeta.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoPagoTarjetas(List<TipoPagoTarjeta> tipopagotarjetas)throws Exception  {				
		for(TipoPagoTarjeta tipopagotarjeta:tipopagotarjetas) {
			tipopagotarjeta.setIsNew(false);
			tipopagotarjeta.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoPagoTarjeta(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
