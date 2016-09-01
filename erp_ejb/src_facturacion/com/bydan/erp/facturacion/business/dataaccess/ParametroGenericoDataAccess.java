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
package com.bydan.erp.facturacion.business.dataaccess;

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

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.util.*;//ParametroGenericoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class ParametroGenericoDataAccess extends  ParametroGenericoDataAccessAdditional{ //ParametroGenericoDataAccessAdditional,DataAccessHelper<ParametroGenerico>
	//static Logger logger = Logger.getLogger(ParametroGenericoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="parametro_generico";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ParametroGenericoConstantesFunciones.SCHEMA+"."+ParametroGenericoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_modulo,secuencial,codigo,id_transaccion,id_transaccion_recibo,id_bodega,id_servicio,id_formato,id_formato_recibo)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ParametroGenericoConstantesFunciones.SCHEMA+"."+ParametroGenericoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_modulo=?,secuencial=?,codigo=?,id_transaccion=?,id_transaccion_recibo=?,id_bodega=?,id_servicio=?,id_formato=?,id_formato_recibo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ParametroGenericoConstantesFunciones.SCHEMA+"."+ParametroGenericoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select parametrogenerico from "+ParametroGenericoConstantesFunciones.SPERSISTENCENAME+" parametrogenerico";
	public static String QUERYSELECTNATIVE="select "+ParametroGenericoConstantesFunciones.SCHEMA+"."+ParametroGenericoConstantesFunciones.TABLENAME+".id,"+ParametroGenericoConstantesFunciones.SCHEMA+"."+ParametroGenericoConstantesFunciones.TABLENAME+".version_row,"+ParametroGenericoConstantesFunciones.SCHEMA+"."+ParametroGenericoConstantesFunciones.TABLENAME+".id_empresa,"+ParametroGenericoConstantesFunciones.SCHEMA+"."+ParametroGenericoConstantesFunciones.TABLENAME+".id_sucursal,"+ParametroGenericoConstantesFunciones.SCHEMA+"."+ParametroGenericoConstantesFunciones.TABLENAME+".id_modulo,"+ParametroGenericoConstantesFunciones.SCHEMA+"."+ParametroGenericoConstantesFunciones.TABLENAME+".secuencial,"+ParametroGenericoConstantesFunciones.SCHEMA+"."+ParametroGenericoConstantesFunciones.TABLENAME+".codigo,"+ParametroGenericoConstantesFunciones.SCHEMA+"."+ParametroGenericoConstantesFunciones.TABLENAME+".id_transaccion,"+ParametroGenericoConstantesFunciones.SCHEMA+"."+ParametroGenericoConstantesFunciones.TABLENAME+".id_transaccion_recibo,"+ParametroGenericoConstantesFunciones.SCHEMA+"."+ParametroGenericoConstantesFunciones.TABLENAME+".id_bodega,"+ParametroGenericoConstantesFunciones.SCHEMA+"."+ParametroGenericoConstantesFunciones.TABLENAME+".id_servicio,"+ParametroGenericoConstantesFunciones.SCHEMA+"."+ParametroGenericoConstantesFunciones.TABLENAME+".id_formato,"+ParametroGenericoConstantesFunciones.SCHEMA+"."+ParametroGenericoConstantesFunciones.TABLENAME+".id_formato_recibo from "+ParametroGenericoConstantesFunciones.SCHEMA+"."+ParametroGenericoConstantesFunciones.TABLENAME;//+" as "+ParametroGenericoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ParametroGenericoConstantesFunciones.SCHEMA+"."+ParametroGenericoConstantesFunciones.TABLENAME+".id,"+ParametroGenericoConstantesFunciones.SCHEMA+"."+ParametroGenericoConstantesFunciones.TABLENAME+".version_row from "+ParametroGenericoConstantesFunciones.SCHEMA+"."+ParametroGenericoConstantesFunciones.TABLENAME;//+" as "+ParametroGenericoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ParametroGenericoConstantesFunciones.SCHEMA+"."+ParametroGenericoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_modulo=?,secuencial=?,codigo=?,id_transaccion=?,id_transaccion_recibo=?,id_bodega=?,id_servicio=?,id_formato=?,id_formato_recibo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PARAMETROGENERICO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PARAMETROGENERICO_UPDATE(?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PARAMETROGENERICO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PARAMETROGENERICO_SELECT(?,?)";
	
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
	
	
	protected ParametroGenericoDataAccessAdditional parametrogenericoDataAccessAdditional=null;
	
	public ParametroGenericoDataAccessAdditional getParametroGenericoDataAccessAdditional() {
		return this.parametrogenericoDataAccessAdditional;
	}
	
	public void setParametroGenericoDataAccessAdditional(ParametroGenericoDataAccessAdditional parametrogenericoDataAccessAdditional) {
		try {
			this.parametrogenericoDataAccessAdditional=parametrogenericoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ParametroGenericoDataAccess() {
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
		ParametroGenericoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ParametroGenericoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ParametroGenericoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setParametroGenericoOriginal(ParametroGenerico parametrogenerico)throws Exception  {
		parametrogenerico.setParametroGenericoOriginal((ParametroGenerico)parametrogenerico.clone());		
	}
	
	public void setParametroGenericosOriginal(List<ParametroGenerico> parametrogenericos)throws Exception  {
		
		for(ParametroGenerico parametrogenerico:parametrogenericos){
			parametrogenerico.setParametroGenericoOriginal((ParametroGenerico)parametrogenerico.clone());
		}
	}
	
	public static void setParametroGenericoOriginalStatic(ParametroGenerico parametrogenerico)throws Exception  {
		parametrogenerico.setParametroGenericoOriginal((ParametroGenerico)parametrogenerico.clone());		
	}
	
	public static void setParametroGenericosOriginalStatic(List<ParametroGenerico> parametrogenericos)throws Exception  {
		
		for(ParametroGenerico parametrogenerico:parametrogenericos){
			parametrogenerico.setParametroGenericoOriginal((ParametroGenerico)parametrogenerico.clone());
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
	
	public  ParametroGenerico getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroGenerico entity = new ParametroGenerico();		
		
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
	
	public  ParametroGenerico getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroGenerico entity = new ParametroGenerico();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroGenericoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroGenericoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.ParametroGenerico.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setParametroGenericoOriginal(new ParametroGenerico());
      	    	entity=super.getEntity("",entity,resultSet,ParametroGenericoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroGenerico("",entity,resultSet); 
				
				//entity.setParametroGenericoOriginal(super.getEntity("",entity.getParametroGenericoOriginal(),resultSet,ParametroGenericoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroGenericoOriginal(this.getEntityParametroGenerico("",entity.getParametroGenericoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroGenerico(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ParametroGenerico getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroGenerico entity = new ParametroGenerico();
				
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
	
	public  ParametroGenerico getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroGenerico entity = new ParametroGenerico();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroGenericoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroGenericoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroGenericoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.ParametroGenerico.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setParametroGenericoOriginal(new ParametroGenerico());
      	    	entity=super.getEntity("",entity,resultSet,ParametroGenericoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroGenerico("",entity,resultSet);    
				
				//entity.setParametroGenericoOriginal(super.getEntity("",entity.getParametroGenericoOriginal(),resultSet,ParametroGenericoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroGenericoOriginal(this.getEntityParametroGenerico("",entity.getParametroGenericoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroGenerico(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ParametroGenerico
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ParametroGenerico entity = new ParametroGenerico();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroGenericoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroGenericoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroGenericoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.ParametroGenerico.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseParametroGenerico(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ParametroGenerico> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroGenerico> entities = new  ArrayList<ParametroGenerico>();
		ParametroGenerico entity = new ParametroGenerico();		  
		
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
	
	public  List<ParametroGenerico> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroGenerico> entities = new  ArrayList<ParametroGenerico>();
		ParametroGenerico entity = new ParametroGenerico();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroGenericoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroGenericoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroGenericoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroGenerico();
      	    	entity=super.getEntity("",entity,resultSet,ParametroGenericoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroGenerico("",entity,resultSet);
      	    	
				//entity.setParametroGenericoOriginal( new ParametroGenerico());
      	    	//entity.setParametroGenericoOriginal(super.getEntity("",entity.getParametroGenericoOriginal(),resultSet,ParametroGenericoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroGenericoOriginal(this.getEntityParametroGenerico("",entity.getParametroGenericoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroGenericos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroGenerico(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroGenerico> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroGenerico> entities = new  ArrayList<ParametroGenerico>();
		ParametroGenerico entity = new ParametroGenerico();		  
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
	
	public  List<ParametroGenerico> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroGenerico> entities = new  ArrayList<ParametroGenerico>();
		ParametroGenerico entity = new ParametroGenerico();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroGenerico();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroGenerico();
					//entity.setMapParametroGenerico(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapParametroGenericoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroGenerico().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroGenericoDataAccess.ISWITHSCHEMA);         		
					entity=ParametroGenericoDataAccess.getEntityParametroGenerico("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroGenericoOriginal( new ParametroGenerico());
					////entity.setParametroGenericoOriginal(super.getEntity("",entity.getParametroGenericoOriginal(),resultSet,ParametroGenericoDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroGenericoOriginal(this.getEntityParametroGenerico("",entity.getParametroGenericoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroGenericos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroGenerico(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ParametroGenerico getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroGenerico entity = new ParametroGenerico();		  
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
	
	public  ParametroGenerico getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroGenerico entity = new ParametroGenerico();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroGenerico();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroGenerico();
					//entity.setMapParametroGenerico(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapParametroGenericoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroGenerico().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroGenericoDataAccess.ISWITHSCHEMA);         		
					entity=ParametroGenericoDataAccess.getEntityParametroGenerico("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroGenericoOriginal( new ParametroGenerico());
					////entity.setParametroGenericoOriginal(super.getEntity("",entity.getParametroGenericoOriginal(),resultSet,ParametroGenericoDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroGenericoOriginal(this.getEntityParametroGenerico("",entity.getParametroGenericoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseParametroGenerico(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroGenerico(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ParametroGenerico getEntityParametroGenerico(String strPrefijo,ParametroGenerico entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ParametroGenerico.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ParametroGenerico.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ParametroGenericoDataAccess.setFieldReflectionParametroGenerico(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasParametroGenerico=ParametroGenericoConstantesFunciones.getTodosTiposColumnasParametroGenerico();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasParametroGenerico) {
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
							field = ParametroGenerico.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ParametroGenerico.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ParametroGenericoDataAccess.setFieldReflectionParametroGenerico(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionParametroGenerico(Field field,String strPrefijo,String sColumn,ParametroGenerico entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ParametroGenericoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGenericoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroGenericoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGenericoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGenericoConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGenericoConstantesFunciones.SECUENCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroGenericoConstantesFunciones.CONPRESUPUESTOCIUDAD:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroGenericoConstantesFunciones.IDTRANSACCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGenericoConstantesFunciones.IDTRANSACCIONRECIBO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGenericoConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGenericoConstantesFunciones.IDSERVICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGenericoConstantesFunciones.IDFORMATO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGenericoConstantesFunciones.IDFORMATORECIBO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroGenerico>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ParametroGenerico> entities = new  ArrayList<ParametroGenerico>();
		ParametroGenerico entity = new ParametroGenerico();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroGenericoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroGenericoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroGenericoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ParametroGenerico();
					entity=super.getEntity("",entity,resultSet,ParametroGenericoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityParametroGenerico("",entity,resultSet);
					
					//entity.setParametroGenericoOriginal( new ParametroGenerico());
					//entity.setParametroGenericoOriginal(super.getEntity("",entity.getParametroGenericoOriginal(),resultSet,ParametroGenericoDataAccess.ISWITHSCHEMA));         		
					//entity.setParametroGenericoOriginal(this.getEntityParametroGenerico("",entity.getParametroGenericoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseParametroGenericos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroGenerico(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroGenerico>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ParametroGenerico> entities = new  ArrayList<ParametroGenerico>();
		ParametroGenerico entity = new ParametroGenerico();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroGenericoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroGenericoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroGenericoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ParametroGenerico> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroGenerico> entities = new  ArrayList<ParametroGenerico>();
		ParametroGenerico entity = new ParametroGenerico();		  
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
	
	public  List<ParametroGenerico> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroGenerico> entities = new  ArrayList<ParametroGenerico>();
		ParametroGenerico entity = new ParametroGenerico();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroGenerico();
      	    	entity=super.getEntity("",entity,resultSet,ParametroGenericoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroGenerico("",entity,resultSet);
      	    	
				//entity.setParametroGenericoOriginal( new ParametroGenerico());
      	    	//entity.setParametroGenericoOriginal(super.getEntity("",entity.getParametroGenericoOriginal(),resultSet,ParametroGenericoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroGenericoOriginal(this.getEntityParametroGenerico("",entity.getParametroGenericoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseParametroGenericos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroGenerico(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroGenerico> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroGenerico> entities = new  ArrayList<ParametroGenerico>();
		ParametroGenerico entity = new ParametroGenerico();		  
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
	
	public  List<ParametroGenerico> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroGenerico> entities = new  ArrayList<ParametroGenerico>();
		ParametroGenerico entity = new ParametroGenerico();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroGenerico();
      	    	entity=super.getEntity("",entity,resultSet,ParametroGenericoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroGenerico("",entity,resultSet);
      	    	
				//entity.setParametroGenericoOriginal( new ParametroGenerico());
      	    	//entity.setParametroGenericoOriginal(super.getEntity("",entity.getParametroGenericoOriginal(),resultSet,ParametroGenericoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroGenericoOriginal(this.getEntityParametroGenerico("",entity.getParametroGenericoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroGenericos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ParametroGenerico getEntityParametroGenerico(String strPrefijo,ParametroGenerico entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ParametroGenericoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+ParametroGenericoConstantesFunciones.IDSUCURSAL));
				entity.setid_modulo(resultSet.getLong(strPrefijo+ParametroGenericoConstantesFunciones.IDMODULO));
				entity.setsecuencial(resultSet.getString(strPrefijo+ParametroGenericoConstantesFunciones.SECUENCIAL));
				entity.setcodigo(resultSet.getBoolean(strPrefijo+ParametroGenericoConstantesFunciones.CONPRESUPUESTOCIUDAD));
				entity.setid_transaccion(resultSet.getLong(strPrefijo+ParametroGenericoConstantesFunciones.IDTRANSACCION));
				entity.setid_transaccion_recibo(resultSet.getLong(strPrefijo+ParametroGenericoConstantesFunciones.IDTRANSACCIONRECIBO));if(resultSet.wasNull()) {entity.setid_transaccion_recibo(null); }
				entity.setid_bodega(resultSet.getLong(strPrefijo+ParametroGenericoConstantesFunciones.IDBODEGA));
				entity.setid_servicio(resultSet.getLong(strPrefijo+ParametroGenericoConstantesFunciones.IDSERVICIO));
				entity.setid_formato(resultSet.getLong(strPrefijo+ParametroGenericoConstantesFunciones.IDFORMATO));
				entity.setid_formato_recibo(resultSet.getLong(strPrefijo+ParametroGenericoConstantesFunciones.IDFORMATORECIBO));if(resultSet.wasNull()) {entity.setid_formato_recibo(null); }
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowParametroGenerico(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ParametroGenerico entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ParametroGenericoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ParametroGenericoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ParametroGenericoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ParametroGenericoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ParametroGenericoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ParametroGenericoDataAccess.TABLENAME,ParametroGenericoDataAccess.ISWITHSTOREPROCEDURES);
			
			ParametroGenericoDataAccess.setParametroGenericoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ParametroGenerico relparametrogenerico)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relparametrogenerico.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ParametroGenerico relparametrogenerico)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relparametrogenerico.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Modulo getModulo(Connexion connexion,ParametroGenerico relparametrogenerico)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,relparametrogenerico.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public Transaccion getTransaccion(Connexion connexion,ParametroGenerico relparametrogenerico)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relparametrogenerico.getid_transaccion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Transaccion getTransaccionRecibo(Connexion connexion,ParametroGenerico relparametrogenerico)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relparametrogenerico.getid_transaccion_recibo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Bodega getBodega(Connexion connexion,ParametroGenerico relparametrogenerico)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,relparametrogenerico.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Servicio getServicio(Connexion connexion,ParametroGenerico relparametrogenerico)throws SQLException,Exception {

		Servicio servicio= new Servicio();

		try {
			ServicioDataAccess servicioDataAccess=new ServicioDataAccess();

			servicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			servicioDataAccess.setConnexionType(this.connexionType);
			servicioDataAccess.setParameterDbType(this.parameterDbType);

			servicio=servicioDataAccess.getEntity(connexion,relparametrogenerico.getid_servicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return servicio;

	}

	public Formato getFormato(Connexion connexion,ParametroGenerico relparametrogenerico)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relparametrogenerico.getid_formato());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public Formato getFormatoRecibo(Connexion connexion,ParametroGenerico relparametrogenerico)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relparametrogenerico.getid_formato_recibo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ParametroGenerico parametrogenerico) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!parametrogenerico.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(parametrogenerico.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(parametrogenerico.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(parametrogenerico.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesecuencial=new ParameterValue<String>();
					parameterMaintenanceValuesecuencial.setValue(parametrogenerico.getsecuencial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesecuencial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecodigo=new ParameterValue<Boolean>();
					parameterMaintenanceValuecodigo.setValue(parametrogenerico.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion.setValue(parametrogenerico.getid_transaccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion_recibo=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion_recibo.setValue(parametrogenerico.getid_transaccion_recibo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion_recibo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(parametrogenerico.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_servicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_servicio.setValue(parametrogenerico.getid_servicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_servicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato.setValue(parametrogenerico.getid_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato_recibo=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato_recibo.setValue(parametrogenerico.getid_formato_recibo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato_recibo);
					parametersTemp.add(parameterMaintenance);
					
						if(!parametrogenerico.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(parametrogenerico.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(parametrogenerico.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(parametrogenerico.getId());
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
	
	public void setIsNewIsChangedFalseParametroGenerico(ParametroGenerico parametrogenerico)throws Exception  {		
		parametrogenerico.setIsNew(false);
		parametrogenerico.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseParametroGenericos(List<ParametroGenerico> parametrogenericos)throws Exception  {				
		for(ParametroGenerico parametrogenerico:parametrogenericos) {
			parametrogenerico.setIsNew(false);
			parametrogenerico.setIsChanged(false);
		}
	}
	
	public void generarExportarParametroGenerico(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
