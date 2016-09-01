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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.util.*;//TipoTransaccionModuloConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;




@SuppressWarnings("unused")
final public class TipoTransaccionModuloDataAccess extends  TipoTransaccionModuloDataAccessAdditional{ //TipoTransaccionModuloDataAccessAdditional,DataAccessHelper<TipoTransaccionModulo>
	//static Logger logger = Logger.getLogger(TipoTransaccionModuloDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_transaccion_modulo";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoTransaccionModuloConstantesFunciones.SCHEMA+"."+TipoTransaccionModuloConstantesFunciones.TABLENAME+"(id,version_row,id_modulo,nombre,siglas)values(?,current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+TipoTransaccionModuloConstantesFunciones.SCHEMA+"."+TipoTransaccionModuloConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,id_modulo=?,nombre=?,siglas=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoTransaccionModuloConstantesFunciones.SCHEMA+"."+TipoTransaccionModuloConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipotransaccionmodulo from "+TipoTransaccionModuloConstantesFunciones.SPERSISTENCENAME+" tipotransaccionmodulo";
	public static String QUERYSELECTNATIVE="select "+TipoTransaccionModuloConstantesFunciones.SCHEMA+"."+TipoTransaccionModuloConstantesFunciones.TABLENAME+".id,"+TipoTransaccionModuloConstantesFunciones.SCHEMA+"."+TipoTransaccionModuloConstantesFunciones.TABLENAME+".version_row,"+TipoTransaccionModuloConstantesFunciones.SCHEMA+"."+TipoTransaccionModuloConstantesFunciones.TABLENAME+".id_modulo,"+TipoTransaccionModuloConstantesFunciones.SCHEMA+"."+TipoTransaccionModuloConstantesFunciones.TABLENAME+".nombre,"+TipoTransaccionModuloConstantesFunciones.SCHEMA+"."+TipoTransaccionModuloConstantesFunciones.TABLENAME+".siglas from "+TipoTransaccionModuloConstantesFunciones.SCHEMA+"."+TipoTransaccionModuloConstantesFunciones.TABLENAME;//+" as "+TipoTransaccionModuloConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoTransaccionModuloConstantesFunciones.SCHEMA+"."+TipoTransaccionModuloConstantesFunciones.TABLENAME+".id,"+TipoTransaccionModuloConstantesFunciones.SCHEMA+"."+TipoTransaccionModuloConstantesFunciones.TABLENAME+".version_row,"+TipoTransaccionModuloConstantesFunciones.SCHEMA+"."+TipoTransaccionModuloConstantesFunciones.TABLENAME+".nombre from "+TipoTransaccionModuloConstantesFunciones.SCHEMA+"."+TipoTransaccionModuloConstantesFunciones.TABLENAME;//+" as "+TipoTransaccionModuloConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoTransaccionModuloConstantesFunciones.SCHEMA+"."+TipoTransaccionModuloConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,id_modulo=?,nombre=?,siglas=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOTRANSACCIONMODULO_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOTRANSACCIONMODULO_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOTRANSACCIONMODULO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOTRANSACCIONMODULO_SELECT(?,?)";
	
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
	
	
	protected TipoTransaccionModuloDataAccessAdditional tipotransaccionmoduloDataAccessAdditional=null;
	
	public TipoTransaccionModuloDataAccessAdditional getTipoTransaccionModuloDataAccessAdditional() {
		return this.tipotransaccionmoduloDataAccessAdditional;
	}
	
	public void setTipoTransaccionModuloDataAccessAdditional(TipoTransaccionModuloDataAccessAdditional tipotransaccionmoduloDataAccessAdditional) {
		try {
			this.tipotransaccionmoduloDataAccessAdditional=tipotransaccionmoduloDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoTransaccionModuloDataAccess() {
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
		TipoTransaccionModuloDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoTransaccionModuloDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoTransaccionModuloDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoTransaccionModuloOriginal(TipoTransaccionModulo tipotransaccionmodulo)throws Exception  {
		tipotransaccionmodulo.setTipoTransaccionModuloOriginal((TipoTransaccionModulo)tipotransaccionmodulo.clone());		
	}
	
	public void setTipoTransaccionModulosOriginal(List<TipoTransaccionModulo> tipotransaccionmodulos)throws Exception  {
		
		for(TipoTransaccionModulo tipotransaccionmodulo:tipotransaccionmodulos){
			tipotransaccionmodulo.setTipoTransaccionModuloOriginal((TipoTransaccionModulo)tipotransaccionmodulo.clone());
		}
	}
	
	public static void setTipoTransaccionModuloOriginalStatic(TipoTransaccionModulo tipotransaccionmodulo)throws Exception  {
		tipotransaccionmodulo.setTipoTransaccionModuloOriginal((TipoTransaccionModulo)tipotransaccionmodulo.clone());		
	}
	
	public static void setTipoTransaccionModulosOriginalStatic(List<TipoTransaccionModulo> tipotransaccionmodulos)throws Exception  {
		
		for(TipoTransaccionModulo tipotransaccionmodulo:tipotransaccionmodulos){
			tipotransaccionmodulo.setTipoTransaccionModuloOriginal((TipoTransaccionModulo)tipotransaccionmodulo.clone());
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
	
	public  TipoTransaccionModulo getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoTransaccionModulo entity = new TipoTransaccionModulo();		
		
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
	
	public  TipoTransaccionModulo getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoTransaccionModulo entity = new TipoTransaccionModulo();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoTransaccionModuloDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoTransaccionModuloDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.TipoTransaccionModulo.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoTransaccionModuloOriginal(new TipoTransaccionModulo());
      	    	entity=super.getEntity("",entity,resultSet,TipoTransaccionModuloDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoTransaccionModulo("",entity,resultSet); 
				
				//entity.setTipoTransaccionModuloOriginal(super.getEntity("",entity.getTipoTransaccionModuloOriginal(),resultSet,TipoTransaccionModuloDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoTransaccionModuloOriginal(this.getEntityTipoTransaccionModulo("",entity.getTipoTransaccionModuloOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoTransaccionModulo(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoTransaccionModulo getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoTransaccionModulo entity = new TipoTransaccionModulo();
				
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
	
	public  TipoTransaccionModulo getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoTransaccionModulo entity = new TipoTransaccionModulo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoTransaccionModuloDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoTransaccionModuloDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoTransaccionModuloDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.TipoTransaccionModulo.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoTransaccionModuloOriginal(new TipoTransaccionModulo());
      	    	entity=super.getEntity("",entity,resultSet,TipoTransaccionModuloDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoTransaccionModulo("",entity,resultSet);    
				
				//entity.setTipoTransaccionModuloOriginal(super.getEntity("",entity.getTipoTransaccionModuloOriginal(),resultSet,TipoTransaccionModuloDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoTransaccionModuloOriginal(this.getEntityTipoTransaccionModulo("",entity.getTipoTransaccionModuloOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoTransaccionModulo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoTransaccionModulo
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoTransaccionModulo entity = new TipoTransaccionModulo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoTransaccionModuloDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoTransaccionModuloDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoTransaccionModuloDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.TipoTransaccionModulo.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoTransaccionModulo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoTransaccionModulo> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoTransaccionModulo> entities = new  ArrayList<TipoTransaccionModulo>();
		TipoTransaccionModulo entity = new TipoTransaccionModulo();		  
		
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
	
	public  List<TipoTransaccionModulo> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoTransaccionModulo> entities = new  ArrayList<TipoTransaccionModulo>();
		TipoTransaccionModulo entity = new TipoTransaccionModulo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoTransaccionModuloDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoTransaccionModuloDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoTransaccionModuloDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoTransaccionModulo();
      	    	entity=super.getEntity("",entity,resultSet,TipoTransaccionModuloDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoTransaccionModulo("",entity,resultSet);
      	    	
				//entity.setTipoTransaccionModuloOriginal( new TipoTransaccionModulo());
      	    	//entity.setTipoTransaccionModuloOriginal(super.getEntity("",entity.getTipoTransaccionModuloOriginal(),resultSet,TipoTransaccionModuloDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoTransaccionModuloOriginal(this.getEntityTipoTransaccionModulo("",entity.getTipoTransaccionModuloOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoTransaccionModulos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoTransaccionModulo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoTransaccionModulo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoTransaccionModulo> entities = new  ArrayList<TipoTransaccionModulo>();
		TipoTransaccionModulo entity = new TipoTransaccionModulo();		  
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
	
	public  List<TipoTransaccionModulo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoTransaccionModulo> entities = new  ArrayList<TipoTransaccionModulo>();
		TipoTransaccionModulo entity = new TipoTransaccionModulo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoTransaccionModulo();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoTransaccionModulo();
					//entity.setMapTipoTransaccionModulo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoTransaccionModuloValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoTransaccionModulo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoTransaccionModuloDataAccess.ISWITHSCHEMA);         		
					entity=TipoTransaccionModuloDataAccess.getEntityTipoTransaccionModulo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoTransaccionModuloOriginal( new TipoTransaccionModulo());
					////entity.setTipoTransaccionModuloOriginal(super.getEntity("",entity.getTipoTransaccionModuloOriginal(),resultSet,TipoTransaccionModuloDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoTransaccionModuloOriginal(this.getEntityTipoTransaccionModulo("",entity.getTipoTransaccionModuloOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoTransaccionModulos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoTransaccionModulo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoTransaccionModulo getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoTransaccionModulo entity = new TipoTransaccionModulo();		  
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
	
	public  TipoTransaccionModulo getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoTransaccionModulo entity = new TipoTransaccionModulo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoTransaccionModulo();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoTransaccionModulo();
					//entity.setMapTipoTransaccionModulo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoTransaccionModuloValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoTransaccionModulo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoTransaccionModuloDataAccess.ISWITHSCHEMA);         		
					entity=TipoTransaccionModuloDataAccess.getEntityTipoTransaccionModulo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoTransaccionModuloOriginal( new TipoTransaccionModulo());
					////entity.setTipoTransaccionModuloOriginal(super.getEntity("",entity.getTipoTransaccionModuloOriginal(),resultSet,TipoTransaccionModuloDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoTransaccionModuloOriginal(this.getEntityTipoTransaccionModulo("",entity.getTipoTransaccionModuloOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoTransaccionModulo(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoTransaccionModulo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoTransaccionModulo getEntityTipoTransaccionModulo(String strPrefijo,TipoTransaccionModulo entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoTransaccionModulo.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoTransaccionModulo.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoTransaccionModuloDataAccess.setFieldReflectionTipoTransaccionModulo(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoTransaccionModulo=TipoTransaccionModuloConstantesFunciones.getTodosTiposColumnasTipoTransaccionModulo();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoTransaccionModulo) {
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
							field = TipoTransaccionModulo.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoTransaccionModulo.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoTransaccionModuloDataAccess.setFieldReflectionTipoTransaccionModulo(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoTransaccionModulo(Field field,String strPrefijo,String sColumn,TipoTransaccionModulo entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoTransaccionModuloConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoTransaccionModuloConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoTransaccionModuloConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoTransaccionModuloConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoTransaccionModuloConstantesFunciones.SIGLAS:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoTransaccionModulo>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoTransaccionModulo> entities = new  ArrayList<TipoTransaccionModulo>();
		TipoTransaccionModulo entity = new TipoTransaccionModulo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoTransaccionModuloDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoTransaccionModuloDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoTransaccionModuloDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoTransaccionModulo();
					entity=super.getEntity("",entity,resultSet,TipoTransaccionModuloDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoTransaccionModulo("",entity,resultSet);
					
					//entity.setTipoTransaccionModuloOriginal( new TipoTransaccionModulo());
					//entity.setTipoTransaccionModuloOriginal(super.getEntity("",entity.getTipoTransaccionModuloOriginal(),resultSet,TipoTransaccionModuloDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoTransaccionModuloOriginal(this.getEntityTipoTransaccionModulo("",entity.getTipoTransaccionModuloOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoTransaccionModulos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoTransaccionModulo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoTransaccionModulo>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoTransaccionModulo> entities = new  ArrayList<TipoTransaccionModulo>();
		TipoTransaccionModulo entity = new TipoTransaccionModulo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoTransaccionModuloDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoTransaccionModuloDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoTransaccionModuloDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoTransaccionModulo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoTransaccionModulo> entities = new  ArrayList<TipoTransaccionModulo>();
		TipoTransaccionModulo entity = new TipoTransaccionModulo();		  
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
	
	public  List<TipoTransaccionModulo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoTransaccionModulo> entities = new  ArrayList<TipoTransaccionModulo>();
		TipoTransaccionModulo entity = new TipoTransaccionModulo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoTransaccionModulo();
      	    	entity=super.getEntity("",entity,resultSet,TipoTransaccionModuloDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoTransaccionModulo("",entity,resultSet);
      	    	
				//entity.setTipoTransaccionModuloOriginal( new TipoTransaccionModulo());
      	    	//entity.setTipoTransaccionModuloOriginal(super.getEntity("",entity.getTipoTransaccionModuloOriginal(),resultSet,TipoTransaccionModuloDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoTransaccionModuloOriginal(this.getEntityTipoTransaccionModulo("",entity.getTipoTransaccionModuloOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoTransaccionModulos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoTransaccionModulo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoTransaccionModulo> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoTransaccionModulo> entities = new  ArrayList<TipoTransaccionModulo>();
		TipoTransaccionModulo entity = new TipoTransaccionModulo();		  
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
	
	public  List<TipoTransaccionModulo> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoTransaccionModulo> entities = new  ArrayList<TipoTransaccionModulo>();
		TipoTransaccionModulo entity = new TipoTransaccionModulo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoTransaccionModulo();
      	    	entity=super.getEntity("",entity,resultSet,TipoTransaccionModuloDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoTransaccionModulo("",entity,resultSet);
      	    	
				//entity.setTipoTransaccionModuloOriginal( new TipoTransaccionModulo());
      	    	//entity.setTipoTransaccionModuloOriginal(super.getEntity("",entity.getTipoTransaccionModuloOriginal(),resultSet,TipoTransaccionModuloDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoTransaccionModuloOriginal(this.getEntityTipoTransaccionModulo("",entity.getTipoTransaccionModuloOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoTransaccionModulos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoTransaccionModulo getEntityTipoTransaccionModulo(String strPrefijo,TipoTransaccionModulo entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_modulo(resultSet.getLong(strPrefijo+TipoTransaccionModuloConstantesFunciones.IDMODULO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoTransaccionModuloConstantesFunciones.NOMBRE));
				entity.setsiglas(resultSet.getString(strPrefijo+TipoTransaccionModuloConstantesFunciones.SIGLAS));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TipoTransaccionModuloConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoTransaccionModulo(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoTransaccionModulo entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoTransaccionModuloDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoTransaccionModuloDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoTransaccionModuloDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoTransaccionModuloDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoTransaccionModuloConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TipoTransaccionModuloDataAccess.TABLENAME,TipoTransaccionModuloDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoTransaccionModuloDataAccess.setTipoTransaccionModuloOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Modulo getModulo(Connexion connexion,TipoTransaccionModulo reltipotransaccionmodulo)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,reltipotransaccionmodulo.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}


		
		public List<FacturaProveedorServicio> getFacturaProveedorServicios(Connexion connexion,TipoTransaccionModulo tipotransaccionmodulo)throws SQLException,Exception {

		List<FacturaProveedorServicio> facturaproveedorservicios= new ArrayList<FacturaProveedorServicio>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo ON "+FacturaProveedorServicioConstantesFunciones.SCHEMA+".factura_proveedor_servicio.id_tipo_transaccion_modulo="+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo.id WHERE "+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo.id="+String.valueOf(tipotransaccionmodulo.getId());
			} else {
				sQuery=" INNER JOIN facturaproveedorservicio.TipoTransaccionModulo WHERE facturaproveedorservicio.TipoTransaccionModulo.id="+String.valueOf(tipotransaccionmodulo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FacturaProveedorServicioDataAccess facturaproveedorservicioDataAccess=new FacturaProveedorServicioDataAccess();

			facturaproveedorservicioDataAccess.setConnexionType(this.connexionType);
			facturaproveedorservicioDataAccess.setParameterDbType(this.parameterDbType);
			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return facturaproveedorservicios;

	}

	public List<TipoFormaPago> getTipoFormaPagos(Connexion connexion,TipoTransaccionModulo tipotransaccionmodulo)throws SQLException,Exception {

		List<TipoFormaPago> tipoformapagos= new ArrayList<TipoFormaPago>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo ON "+TipoFormaPagoConstantesFunciones.SCHEMA+".tipo_forma_pago.id_tipo_transaccion_modulo="+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo.id WHERE "+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo.id="+String.valueOf(tipotransaccionmodulo.getId());
			} else {
				sQuery=" INNER JOIN tipoformapago.TipoTransaccionModulo WHERE tipoformapago.TipoTransaccionModulo.id="+String.valueOf(tipotransaccionmodulo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			TipoFormaPagoDataAccess tipoformapagoDataAccess=new TipoFormaPagoDataAccess();

			tipoformapagoDataAccess.setConnexionType(this.connexionType);
			tipoformapagoDataAccess.setParameterDbType(this.parameterDbType);
			tipoformapagos=tipoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoformapagos;

	}

	public List<FacturaProveedor> getFacturaProveedors(Connexion connexion,TipoTransaccionModulo tipotransaccionmodulo)throws SQLException,Exception {

		List<FacturaProveedor> facturaproveedors= new ArrayList<FacturaProveedor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo ON "+FacturaProveedorConstantesFunciones.SCHEMA+".factura_proveedor.id_tipo_transaccion_modulo="+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo.id WHERE "+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo.id="+String.valueOf(tipotransaccionmodulo.getId());
			} else {
				sQuery=" INNER JOIN facturaproveedor.TipoTransaccionModulo WHERE facturaproveedor.TipoTransaccionModulo.id="+String.valueOf(tipotransaccionmodulo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FacturaProveedorDataAccess facturaproveedorDataAccess=new FacturaProveedorDataAccess();

			facturaproveedorDataAccess.setConnexionType(this.connexionType);
			facturaproveedorDataAccess.setParameterDbType(this.parameterDbType);
			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return facturaproveedors;

	}

	public List<Definicion> getDefinicions(Connexion connexion,TipoTransaccionModulo tipotransaccionmodulo)throws SQLException,Exception {

		List<Definicion> definicions= new ArrayList<Definicion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo ON "+DefinicionConstantesFunciones.SCHEMA+".definicion.id_tipo_transaccion_modulo="+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo.id WHERE "+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo.id="+String.valueOf(tipotransaccionmodulo.getId());
			} else {
				sQuery=" INNER JOIN definicion.TipoTransaccionModulo WHERE definicion.TipoTransaccionModulo.id="+String.valueOf(tipotransaccionmodulo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DefinicionDataAccess definicionDataAccess=new DefinicionDataAccess();

			definicionDataAccess.setConnexionType(this.connexionType);
			definicionDataAccess.setParameterDbType(this.parameterDbType);
			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return definicions;

	}

	public List<MovimientoInventario> getMovimientoInventarios(Connexion connexion,TipoTransaccionModulo tipotransaccionmodulo)throws SQLException,Exception {

		List<MovimientoInventario> movimientoinventarios= new ArrayList<MovimientoInventario>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo ON "+MovimientoInventarioConstantesFunciones.SCHEMA+".movimiento_inventario.id_tipo_transaccion_modulo="+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo.id WHERE "+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo.id="+String.valueOf(tipotransaccionmodulo.getId());
			} else {
				sQuery=" INNER JOIN movimientoinventario.TipoTransaccionModulo WHERE movimientoinventario.TipoTransaccionModulo.id="+String.valueOf(tipotransaccionmodulo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			MovimientoInventarioDataAccess movimientoinventarioDataAccess=new MovimientoInventarioDataAccess();

			movimientoinventarioDataAccess.setConnexionType(this.connexionType);
			movimientoinventarioDataAccess.setParameterDbType(this.parameterDbType);
			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return movimientoinventarios;

	}

	public List<DetalleCliente> getDetalleClientes(Connexion connexion,TipoTransaccionModulo tipotransaccionmodulo)throws SQLException,Exception {

		List<DetalleCliente> detalleclientes= new ArrayList<DetalleCliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo ON "+DetalleClienteConstantesFunciones.SCHEMA+".detalle_cliente.id_tipo_transaccion_modulo="+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo.id WHERE "+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo.id="+String.valueOf(tipotransaccionmodulo.getId());
			} else {
				sQuery=" INNER JOIN detallecliente.TipoTransaccionModulo WHERE detallecliente.TipoTransaccionModulo.id="+String.valueOf(tipotransaccionmodulo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleClienteDataAccess detalleclienteDataAccess=new DetalleClienteDataAccess();

			detalleclienteDataAccess.setConnexionType(this.connexionType);
			detalleclienteDataAccess.setParameterDbType(this.parameterDbType);
			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleclientes;

	}

	public List<AsientoContableCajaChica> getAsientoContableCajaChicas(Connexion connexion,TipoTransaccionModulo tipotransaccionmodulo)throws SQLException,Exception {

		List<AsientoContableCajaChica> asientocontablecajachicas= new ArrayList<AsientoContableCajaChica>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo ON "+AsientoContableCajaChicaConstantesFunciones.SCHEMA+".asiento_contable_caja_chica.id_tipo_transaccion_modulo="+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo.id WHERE "+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo.id="+String.valueOf(tipotransaccionmodulo.getId());
			} else {
				sQuery=" INNER JOIN asientocontablecajachica.TipoTransaccionModulo WHERE asientocontablecajachica.TipoTransaccionModulo.id="+String.valueOf(tipotransaccionmodulo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AsientoContableCajaChicaDataAccess asientocontablecajachicaDataAccess=new AsientoContableCajaChicaDataAccess();

			asientocontablecajachicaDataAccess.setConnexionType(this.connexionType);
			asientocontablecajachicaDataAccess.setParameterDbType(this.parameterDbType);
			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontablecajachicas;

	}

	public List<DetalleAsientoContableCajaChica> getDetalleAsientoContableCajaChicas(Connexion connexion,TipoTransaccionModulo tipotransaccionmodulo)throws SQLException,Exception {

		List<DetalleAsientoContableCajaChica> detalleasientocontablecajachicas= new ArrayList<DetalleAsientoContableCajaChica>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo ON "+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+".detalle_asiento_contable_caja_chica.id_tipo_transaccion_modulo="+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo.id WHERE "+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo.id="+String.valueOf(tipotransaccionmodulo.getId());
			} else {
				sQuery=" INNER JOIN detalleasientocontablecajachica.TipoTransaccionModulo WHERE detalleasientocontablecajachica.TipoTransaccionModulo.id="+String.valueOf(tipotransaccionmodulo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleAsientoContableCajaChicaDataAccess detalleasientocontablecajachicaDataAccess=new DetalleAsientoContableCajaChicaDataAccess();

			detalleasientocontablecajachicaDataAccess.setConnexionType(this.connexionType);
			detalleasientocontablecajachicaDataAccess.setParameterDbType(this.parameterDbType);
			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleasientocontablecajachicas;

	}

	public List<ParametroProducto> getParametroProductos(Connexion connexion,TipoTransaccionModulo tipotransaccionmodulo)throws SQLException,Exception {

		List<ParametroProducto> parametroproductos= new ArrayList<ParametroProducto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo ON "+ParametroProductoConstantesFunciones.SCHEMA+".parametro_producto.id_tipo_transaccion_modulo="+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo.id WHERE "+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo.id="+String.valueOf(tipotransaccionmodulo.getId());
			} else {
				sQuery=" INNER JOIN parametroproducto.TipoTransaccionModulo WHERE parametroproducto.TipoTransaccionModulo.id="+String.valueOf(tipotransaccionmodulo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroProductoDataAccess parametroproductoDataAccess=new ParametroProductoDataAccess();

			parametroproductoDataAccess.setConnexionType(this.connexionType);
			parametroproductoDataAccess.setParameterDbType(this.parameterDbType);
			parametroproductos=parametroproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametroproductos;

	}

	public List<OrdenCompra> getOrdenCompras(Connexion connexion,TipoTransaccionModulo tipotransaccionmodulo)throws SQLException,Exception {

		List<OrdenCompra> ordencompras= new ArrayList<OrdenCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo ON "+OrdenCompraConstantesFunciones.SCHEMA+".orden_compra.id_tipo_transaccion_modulo="+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo.id WHERE "+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo.id="+String.valueOf(tipotransaccionmodulo.getId());
			} else {
				sQuery=" INNER JOIN ordencompra.TipoTransaccionModulo WHERE ordencompra.TipoTransaccionModulo.id="+String.valueOf(tipotransaccionmodulo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			OrdenCompraDataAccess ordencompraDataAccess=new OrdenCompraDataAccess();

			ordencompraDataAccess.setConnexionType(this.connexionType);
			ordencompraDataAccess.setParameterDbType(this.parameterDbType);
			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ordencompras;

	}

	public List<DetalleMoviClienProve> getDetalleMoviClienProves(Connexion connexion,TipoTransaccionModulo tipotransaccionmodulo)throws SQLException,Exception {

		List<DetalleMoviClienProve> detallemoviclienproves= new ArrayList<DetalleMoviClienProve>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo ON "+DetalleMoviClienProveConstantesFunciones.SCHEMA+".detalle_movi_clien_prove.id_tipo_transaccion_modulo="+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo.id WHERE "+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo.id="+String.valueOf(tipotransaccionmodulo.getId());
			} else {
				sQuery=" INNER JOIN detallemoviclienprove.TipoTransaccionModulo WHERE detallemoviclienprove.TipoTransaccionModulo.id="+String.valueOf(tipotransaccionmodulo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleMoviClienProveDataAccess detallemoviclienproveDataAccess=new DetalleMoviClienProveDataAccess();

			detallemoviclienproveDataAccess.setConnexionType(this.connexionType);
			detallemoviclienproveDataAccess.setParameterDbType(this.parameterDbType);
			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallemoviclienproves;

	}

	public List<FormaPago> getFormaPagos(Connexion connexion,TipoTransaccionModulo tipotransaccionmodulo)throws SQLException,Exception {

		List<FormaPago> formapagos= new ArrayList<FormaPago>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo ON "+FormaPagoConstantesFunciones.SCHEMA+".forma_pago.id_tipo_transaccion_modulo="+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo.id WHERE "+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo.id="+String.valueOf(tipotransaccionmodulo.getId());
			} else {
				sQuery=" INNER JOIN formapago.TipoTransaccionModulo WHERE formapago.TipoTransaccionModulo.id="+String.valueOf(tipotransaccionmodulo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FormaPagoDataAccess formapagoDataAccess=new FormaPagoDataAccess();

			formapagoDataAccess.setConnexionType(this.connexionType);
			formapagoDataAccess.setParameterDbType(this.parameterDbType);
			formapagos=formapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formapagos;

	}

	public List<Transaccion> getTransaccions(Connexion connexion,TipoTransaccionModulo tipotransaccionmodulo)throws SQLException,Exception {

		List<Transaccion> transaccions= new ArrayList<Transaccion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo ON "+TransaccionConstantesFunciones.SCHEMA+".transaccion.id_tipo_transaccion_modulo="+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo.id WHERE "+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo.id="+String.valueOf(tipotransaccionmodulo.getId());
			} else {
				sQuery=" INNER JOIN transaccion.TipoTransaccionModulo WHERE transaccion.TipoTransaccionModulo.id="+String.valueOf(tipotransaccionmodulo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);
			transaccions=transaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccions;

	}

	public List<DetalleProve> getDetalleProves(Connexion connexion,TipoTransaccionModulo tipotransaccionmodulo)throws SQLException,Exception {

		List<DetalleProve> detalleproves= new ArrayList<DetalleProve>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo ON "+DetalleProveConstantesFunciones.SCHEMA+".detalle_prove.id_tipo_transaccion_modulo="+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo.id WHERE "+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo.id="+String.valueOf(tipotransaccionmodulo.getId());
			} else {
				sQuery=" INNER JOIN detalleprove.TipoTransaccionModulo WHERE detalleprove.TipoTransaccionModulo.id="+String.valueOf(tipotransaccionmodulo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleProveDataAccess detalleproveDataAccess=new DetalleProveDataAccess();

			detalleproveDataAccess.setConnexionType(this.connexionType);
			detalleproveDataAccess.setParameterDbType(this.parameterDbType);
			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleproves;

	}

	public List<CuentaPorCobrar> getCuentaPorCobrars(Connexion connexion,TipoTransaccionModulo tipotransaccionmodulo)throws SQLException,Exception {

		List<CuentaPorCobrar> cuentaporcobrars= new ArrayList<CuentaPorCobrar>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo ON "+CuentaPorCobrarConstantesFunciones.SCHEMA+".cuenta_por_cobrar.id_tipo_transaccion_modulo="+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo.id WHERE "+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo.id="+String.valueOf(tipotransaccionmodulo.getId());
			} else {
				sQuery=" INNER JOIN cuentaporcobrar.TipoTransaccionModulo WHERE cuentaporcobrar.TipoTransaccionModulo.id="+String.valueOf(tipotransaccionmodulo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CuentaPorCobrarDataAccess cuentaporcobrarDataAccess=new CuentaPorCobrarDataAccess();

			cuentaporcobrarDataAccess.setConnexionType(this.connexionType);
			cuentaporcobrarDataAccess.setParameterDbType(this.parameterDbType);
			cuentaporcobrars=cuentaporcobrarDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentaporcobrars;

	}

	public List<DetalleDocumento> getDetalleDocumentos(Connexion connexion,TipoTransaccionModulo tipotransaccionmodulo)throws SQLException,Exception {

		List<DetalleDocumento> detalledocumentos= new ArrayList<DetalleDocumento>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo ON "+DetalleDocumentoConstantesFunciones.SCHEMA+".detalle_documento.id_tipo_transaccion_modulo="+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo.id WHERE "+TipoTransaccionModuloConstantesFunciones.SCHEMA+".tipo_transaccion_modulo.id="+String.valueOf(tipotransaccionmodulo.getId());
			} else {
				sQuery=" INNER JOIN detalledocumento.TipoTransaccionModulo WHERE detalledocumento.TipoTransaccionModulo.id="+String.valueOf(tipotransaccionmodulo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleDocumentoDataAccess detalledocumentoDataAccess=new DetalleDocumentoDataAccess();

			detalledocumentoDataAccess.setConnexionType(this.connexionType);
			detalledocumentoDataAccess.setParameterDbType(this.parameterDbType);
			detalledocumentos=detalledocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalledocumentos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoTransaccionModulo tipotransaccionmodulo) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipotransaccionmodulo.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(tipotransaccionmodulo.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(tipotransaccionmodulo.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipotransaccionmodulo.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesiglas=new ParameterValue<String>();
					parameterMaintenanceValuesiglas.setValue(tipotransaccionmodulo.getsiglas());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesiglas);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipotransaccionmodulo.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipotransaccionmodulo.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipotransaccionmodulo.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipotransaccionmodulo.getId());
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
	
	public void setIsNewIsChangedFalseTipoTransaccionModulo(TipoTransaccionModulo tipotransaccionmodulo)throws Exception  {		
		tipotransaccionmodulo.setIsNew(false);
		tipotransaccionmodulo.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoTransaccionModulos(List<TipoTransaccionModulo> tipotransaccionmodulos)throws Exception  {				
		for(TipoTransaccionModulo tipotransaccionmodulo:tipotransaccionmodulos) {
			tipotransaccionmodulo.setIsNew(false);
			tipotransaccionmodulo.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoTransaccionModulo(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
