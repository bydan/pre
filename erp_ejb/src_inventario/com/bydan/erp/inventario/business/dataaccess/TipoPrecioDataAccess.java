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
import com.bydan.erp.inventario.util.*;//TipoPrecioConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.tesoreria.util.*;




@SuppressWarnings("unused")
final public class TipoPrecioDataAccess extends  TipoPrecioDataAccessAdditional{ //TipoPrecioDataAccessAdditional,DataAccessHelper<TipoPrecio>
	//static Logger logger = Logger.getLogger(TipoPrecioDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_precio";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoPrecioConstantesFunciones.SCHEMA+"."+TipoPrecioConstantesFunciones.TABLENAME+"(version_row,id_empresa,codigo,nombre,fecha_desde,fecha_hasta,monto,esta_activo,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+TipoPrecioConstantesFunciones.SCHEMA+"."+TipoPrecioConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?,fecha_desde=?,fecha_hasta=?,monto=?,esta_activo=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoPrecioConstantesFunciones.SCHEMA+"."+TipoPrecioConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipoprecio from "+TipoPrecioConstantesFunciones.SPERSISTENCENAME+" tipoprecio";
	public static String QUERYSELECTNATIVE="select "+TipoPrecioConstantesFunciones.SCHEMA+"."+TipoPrecioConstantesFunciones.TABLENAME+".id,"+TipoPrecioConstantesFunciones.SCHEMA+"."+TipoPrecioConstantesFunciones.TABLENAME+".version_row,"+TipoPrecioConstantesFunciones.SCHEMA+"."+TipoPrecioConstantesFunciones.TABLENAME+".id_empresa,"+TipoPrecioConstantesFunciones.SCHEMA+"."+TipoPrecioConstantesFunciones.TABLENAME+".codigo,"+TipoPrecioConstantesFunciones.SCHEMA+"."+TipoPrecioConstantesFunciones.TABLENAME+".nombre,"+TipoPrecioConstantesFunciones.SCHEMA+"."+TipoPrecioConstantesFunciones.TABLENAME+".fecha_desde,"+TipoPrecioConstantesFunciones.SCHEMA+"."+TipoPrecioConstantesFunciones.TABLENAME+".fecha_hasta,"+TipoPrecioConstantesFunciones.SCHEMA+"."+TipoPrecioConstantesFunciones.TABLENAME+".monto,"+TipoPrecioConstantesFunciones.SCHEMA+"."+TipoPrecioConstantesFunciones.TABLENAME+".esta_activo,"+TipoPrecioConstantesFunciones.SCHEMA+"."+TipoPrecioConstantesFunciones.TABLENAME+".descripcion from "+TipoPrecioConstantesFunciones.SCHEMA+"."+TipoPrecioConstantesFunciones.TABLENAME;//+" as "+TipoPrecioConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoPrecioConstantesFunciones.SCHEMA+"."+TipoPrecioConstantesFunciones.TABLENAME+".id,"+TipoPrecioConstantesFunciones.SCHEMA+"."+TipoPrecioConstantesFunciones.TABLENAME+".version_row,"+TipoPrecioConstantesFunciones.SCHEMA+"."+TipoPrecioConstantesFunciones.TABLENAME+".codigo from "+TipoPrecioConstantesFunciones.SCHEMA+"."+TipoPrecioConstantesFunciones.TABLENAME;//+" as "+TipoPrecioConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoPrecioConstantesFunciones.SCHEMA+"."+TipoPrecioConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?,fecha_desde=?,fecha_hasta=?,monto=?,esta_activo=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOPRECIO_INSERT(?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOPRECIO_UPDATE(?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOPRECIO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOPRECIO_SELECT(?,?)";
	
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
	
	
	protected TipoPrecioDataAccessAdditional tipoprecioDataAccessAdditional=null;
	
	public TipoPrecioDataAccessAdditional getTipoPrecioDataAccessAdditional() {
		return this.tipoprecioDataAccessAdditional;
	}
	
	public void setTipoPrecioDataAccessAdditional(TipoPrecioDataAccessAdditional tipoprecioDataAccessAdditional) {
		try {
			this.tipoprecioDataAccessAdditional=tipoprecioDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoPrecioDataAccess() {
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
		TipoPrecioDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoPrecioDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoPrecioDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoPrecioOriginal(TipoPrecio tipoprecio)throws Exception  {
		tipoprecio.setTipoPrecioOriginal((TipoPrecio)tipoprecio.clone());		
	}
	
	public void setTipoPreciosOriginal(List<TipoPrecio> tipoprecios)throws Exception  {
		
		for(TipoPrecio tipoprecio:tipoprecios){
			tipoprecio.setTipoPrecioOriginal((TipoPrecio)tipoprecio.clone());
		}
	}
	
	public static void setTipoPrecioOriginalStatic(TipoPrecio tipoprecio)throws Exception  {
		tipoprecio.setTipoPrecioOriginal((TipoPrecio)tipoprecio.clone());		
	}
	
	public static void setTipoPreciosOriginalStatic(List<TipoPrecio> tipoprecios)throws Exception  {
		
		for(TipoPrecio tipoprecio:tipoprecios){
			tipoprecio.setTipoPrecioOriginal((TipoPrecio)tipoprecio.clone());
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
	
	public  TipoPrecio getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoPrecio entity = new TipoPrecio();		
		
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
	
	public  TipoPrecio getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoPrecio entity = new TipoPrecio();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoPrecioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoPrecioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.TipoPrecio.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoPrecioOriginal(new TipoPrecio());
      	    	entity=super.getEntity("",entity,resultSet,TipoPrecioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoPrecio("",entity,resultSet); 
				
				//entity.setTipoPrecioOriginal(super.getEntity("",entity.getTipoPrecioOriginal(),resultSet,TipoPrecioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoPrecioOriginal(this.getEntityTipoPrecio("",entity.getTipoPrecioOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoPrecio(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoPrecio getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoPrecio entity = new TipoPrecio();
				
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
	
	public  TipoPrecio getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoPrecio entity = new TipoPrecio();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoPrecioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoPrecioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoPrecioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.TipoPrecio.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoPrecioOriginal(new TipoPrecio());
      	    	entity=super.getEntity("",entity,resultSet,TipoPrecioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoPrecio("",entity,resultSet);    
				
				//entity.setTipoPrecioOriginal(super.getEntity("",entity.getTipoPrecioOriginal(),resultSet,TipoPrecioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoPrecioOriginal(this.getEntityTipoPrecio("",entity.getTipoPrecioOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoPrecio(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoPrecio
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoPrecio entity = new TipoPrecio();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoPrecioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoPrecioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoPrecioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.TipoPrecio.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoPrecio(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoPrecio> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoPrecio> entities = new  ArrayList<TipoPrecio>();
		TipoPrecio entity = new TipoPrecio();		  
		
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
	
	public  List<TipoPrecio> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoPrecio> entities = new  ArrayList<TipoPrecio>();
		TipoPrecio entity = new TipoPrecio();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoPrecioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoPrecioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoPrecioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoPrecio();
      	    	entity=super.getEntity("",entity,resultSet,TipoPrecioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoPrecio("",entity,resultSet);
      	    	
				//entity.setTipoPrecioOriginal( new TipoPrecio());
      	    	//entity.setTipoPrecioOriginal(super.getEntity("",entity.getTipoPrecioOriginal(),resultSet,TipoPrecioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoPrecioOriginal(this.getEntityTipoPrecio("",entity.getTipoPrecioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoPrecios(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoPrecio(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoPrecio> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoPrecio> entities = new  ArrayList<TipoPrecio>();
		TipoPrecio entity = new TipoPrecio();		  
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
	
	public  List<TipoPrecio> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoPrecio> entities = new  ArrayList<TipoPrecio>();
		TipoPrecio entity = new TipoPrecio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoPrecio();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoPrecio();
					//entity.setMapTipoPrecio(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoPrecioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoPrecio().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoPrecioDataAccess.ISWITHSCHEMA);         		
					entity=TipoPrecioDataAccess.getEntityTipoPrecio("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoPrecioOriginal( new TipoPrecio());
					////entity.setTipoPrecioOriginal(super.getEntity("",entity.getTipoPrecioOriginal(),resultSet,TipoPrecioDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoPrecioOriginal(this.getEntityTipoPrecio("",entity.getTipoPrecioOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoPrecios(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoPrecio(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoPrecio getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoPrecio entity = new TipoPrecio();		  
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
	
	public  TipoPrecio getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoPrecio entity = new TipoPrecio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoPrecio();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoPrecio();
					//entity.setMapTipoPrecio(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoPrecioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoPrecio().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoPrecioDataAccess.ISWITHSCHEMA);         		
					entity=TipoPrecioDataAccess.getEntityTipoPrecio("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoPrecioOriginal( new TipoPrecio());
					////entity.setTipoPrecioOriginal(super.getEntity("",entity.getTipoPrecioOriginal(),resultSet,TipoPrecioDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoPrecioOriginal(this.getEntityTipoPrecio("",entity.getTipoPrecioOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoPrecio(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoPrecio(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoPrecio getEntityTipoPrecio(String strPrefijo,TipoPrecio entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoPrecio.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoPrecio.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoPrecioDataAccess.setFieldReflectionTipoPrecio(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoPrecio=TipoPrecioConstantesFunciones.getTodosTiposColumnasTipoPrecio();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoPrecio) {
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
							field = TipoPrecio.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoPrecio.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoPrecioDataAccess.setFieldReflectionTipoPrecio(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoPrecio(Field field,String strPrefijo,String sColumn,TipoPrecio entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoPrecioConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoPrecioConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoPrecioConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoPrecioConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoPrecioConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoPrecioConstantesFunciones.FECHADESDE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case TipoPrecioConstantesFunciones.FECHAHASTA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case TipoPrecioConstantesFunciones.MONTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TipoPrecioConstantesFunciones.ESTAACTIVO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case TipoPrecioConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoPrecio>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoPrecio> entities = new  ArrayList<TipoPrecio>();
		TipoPrecio entity = new TipoPrecio();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoPrecioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoPrecioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoPrecioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoPrecio();
					entity=super.getEntity("",entity,resultSet,TipoPrecioDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoPrecio("",entity,resultSet);
					
					//entity.setTipoPrecioOriginal( new TipoPrecio());
					//entity.setTipoPrecioOriginal(super.getEntity("",entity.getTipoPrecioOriginal(),resultSet,TipoPrecioDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoPrecioOriginal(this.getEntityTipoPrecio("",entity.getTipoPrecioOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoPrecios(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoPrecio(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoPrecio>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoPrecio> entities = new  ArrayList<TipoPrecio>();
		TipoPrecio entity = new TipoPrecio();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoPrecioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoPrecioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoPrecioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoPrecio> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoPrecio> entities = new  ArrayList<TipoPrecio>();
		TipoPrecio entity = new TipoPrecio();		  
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
	
	public  List<TipoPrecio> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoPrecio> entities = new  ArrayList<TipoPrecio>();
		TipoPrecio entity = new TipoPrecio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoPrecio();
      	    	entity=super.getEntity("",entity,resultSet,TipoPrecioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoPrecio("",entity,resultSet);
      	    	
				//entity.setTipoPrecioOriginal( new TipoPrecio());
      	    	//entity.setTipoPrecioOriginal(super.getEntity("",entity.getTipoPrecioOriginal(),resultSet,TipoPrecioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoPrecioOriginal(this.getEntityTipoPrecio("",entity.getTipoPrecioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoPrecios(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoPrecio(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoPrecio> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoPrecio> entities = new  ArrayList<TipoPrecio>();
		TipoPrecio entity = new TipoPrecio();		  
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
	
	public  List<TipoPrecio> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoPrecio> entities = new  ArrayList<TipoPrecio>();
		TipoPrecio entity = new TipoPrecio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoPrecio();
      	    	entity=super.getEntity("",entity,resultSet,TipoPrecioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoPrecio("",entity,resultSet);
      	    	
				//entity.setTipoPrecioOriginal( new TipoPrecio());
      	    	//entity.setTipoPrecioOriginal(super.getEntity("",entity.getTipoPrecioOriginal(),resultSet,TipoPrecioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoPrecioOriginal(this.getEntityTipoPrecio("",entity.getTipoPrecioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoPrecios(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoPrecio getEntityTipoPrecio(String strPrefijo,TipoPrecio entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TipoPrecioConstantesFunciones.IDEMPRESA));
				entity.setcodigo(resultSet.getString(strPrefijo+TipoPrecioConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoPrecioConstantesFunciones.NOMBRE));
				entity.setfecha_desde(new Date(resultSet.getDate(strPrefijo+TipoPrecioConstantesFunciones.FECHADESDE).getTime()));
				entity.setfecha_hasta(new Date(resultSet.getDate(strPrefijo+TipoPrecioConstantesFunciones.FECHAHASTA).getTime()));
				entity.setmonto(resultSet.getDouble(strPrefijo+TipoPrecioConstantesFunciones.MONTO));
				entity.setesta_activo(resultSet.getBoolean(strPrefijo+TipoPrecioConstantesFunciones.ESTAACTIVO));
				entity.setdescripcion(resultSet.getString(strPrefijo+TipoPrecioConstantesFunciones.DESCRIPCION));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoPrecioConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoPrecio(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoPrecio entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoPrecioDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoPrecioDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoPrecioDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoPrecioDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoPrecioConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoPrecioDataAccess.TABLENAME,TipoPrecioDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoPrecioDataAccess.setTipoPrecioOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TipoPrecio reltipoprecio)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltipoprecio.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
		public List<Precio> getPrecios(Connexion connexion,TipoPrecio tipoprecio)throws SQLException,Exception {

		List<Precio> precios= new ArrayList<Precio>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio ON "+PrecioConstantesFunciones.SCHEMA+".precio.id_tipo_precio="+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio.id WHERE "+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio.id="+String.valueOf(tipoprecio.getId());
			} else {
				sQuery=" INNER JOIN precio.TipoPrecio WHERE precio.TipoPrecio.id="+String.valueOf(tipoprecio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PrecioDataAccess precioDataAccess=new PrecioDataAccess();

			precioDataAccess.setConnexionType(this.connexionType);
			precioDataAccess.setParameterDbType(this.parameterDbType);
			precios=precioDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return precios;

	}

	public List<UtilidadTipoPrecio> getUtilidadTipoPrecios(Connexion connexion,TipoPrecio tipoprecio)throws SQLException,Exception {

		List<UtilidadTipoPrecio> utilidadtipoprecios= new ArrayList<UtilidadTipoPrecio>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio ON "+UtilidadTipoPrecioConstantesFunciones.SCHEMA+".utilidad_tipo_precio.id_tipo_precio="+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio.id WHERE "+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio.id="+String.valueOf(tipoprecio.getId());
			} else {
				sQuery=" INNER JOIN utilidadtipoprecio.TipoPrecio WHERE utilidadtipoprecio.TipoPrecio.id="+String.valueOf(tipoprecio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			UtilidadTipoPrecioDataAccess utilidadtipoprecioDataAccess=new UtilidadTipoPrecioDataAccess();

			utilidadtipoprecioDataAccess.setConnexionType(this.connexionType);
			utilidadtipoprecioDataAccess.setParameterDbType(this.parameterDbType);
			utilidadtipoprecios=utilidadtipoprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return utilidadtipoprecios;

	}

	public List<PedidoPuntoVenta> getPedidoPuntoVentas(Connexion connexion,TipoPrecio tipoprecio)throws SQLException,Exception {

		List<PedidoPuntoVenta> pedidopuntoventas= new ArrayList<PedidoPuntoVenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio ON "+PedidoPuntoVentaConstantesFunciones.SCHEMA+".pedido_punto_venta.id_tipo_precio="+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio.id WHERE "+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio.id="+String.valueOf(tipoprecio.getId());
			} else {
				sQuery=" INNER JOIN pedidopuntoventa.TipoPrecio WHERE pedidopuntoventa.TipoPrecio.id="+String.valueOf(tipoprecio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PedidoPuntoVentaDataAccess pedidopuntoventaDataAccess=new PedidoPuntoVentaDataAccess();

			pedidopuntoventaDataAccess.setConnexionType(this.connexionType);
			pedidopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			pedidopuntoventas=pedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidopuntoventas;

	}

	public List<ParametroCarteraDefecto> getParametroCarteraDefectos(Connexion connexion,TipoPrecio tipoprecio)throws SQLException,Exception {

		List<ParametroCarteraDefecto> parametrocarteradefectos= new ArrayList<ParametroCarteraDefecto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio ON "+ParametroCarteraDefectoConstantesFunciones.SCHEMA+".parametro_cartera_defecto.id_tipo_precio="+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio.id WHERE "+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio.id="+String.valueOf(tipoprecio.getId());
			} else {
				sQuery=" INNER JOIN parametrocarteradefecto.TipoPrecio WHERE parametrocarteradefecto.TipoPrecio.id="+String.valueOf(tipoprecio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroCarteraDefectoDataAccess parametrocarteradefectoDataAccess=new ParametroCarteraDefectoDataAccess();

			parametrocarteradefectoDataAccess.setConnexionType(this.connexionType);
			parametrocarteradefectoDataAccess.setParameterDbType(this.parameterDbType);
			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametrocarteradefectos;

	}

	public List<DescuentoTipoPrecio> getDescuentoTipoPrecios(Connexion connexion,TipoPrecio tipoprecio)throws SQLException,Exception {

		List<DescuentoTipoPrecio> descuentotipoprecios= new ArrayList<DescuentoTipoPrecio>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio ON "+DescuentoTipoPrecioConstantesFunciones.SCHEMA+".descuento_tipo_precio.id_tipo_precio="+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio.id WHERE "+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio.id="+String.valueOf(tipoprecio.getId());
			} else {
				sQuery=" INNER JOIN descuentotipoprecio.TipoPrecio WHERE descuentotipoprecio.TipoPrecio.id="+String.valueOf(tipoprecio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DescuentoTipoPrecioDataAccess descuentotipoprecioDataAccess=new DescuentoTipoPrecioDataAccess();

			descuentotipoprecioDataAccess.setConnexionType(this.connexionType);
			descuentotipoprecioDataAccess.setParameterDbType(this.parameterDbType);
			descuentotipoprecios=descuentotipoprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return descuentotipoprecios;

	}

	public List<PoliticasCliente> getPoliticasClientes(Connexion connexion,TipoPrecio tipoprecio)throws SQLException,Exception {

		List<PoliticasCliente> politicasclientes= new ArrayList<PoliticasCliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio ON "+PoliticasClienteConstantesFunciones.SCHEMA+".politicas_cliente.id_tipo_precio="+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio.id WHERE "+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio.id="+String.valueOf(tipoprecio.getId());
			} else {
				sQuery=" INNER JOIN politicascliente.TipoPrecio WHERE politicascliente.TipoPrecio.id="+String.valueOf(tipoprecio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PoliticasClienteDataAccess politicasclienteDataAccess=new PoliticasClienteDataAccess();

			politicasclienteDataAccess.setConnexionType(this.connexionType);
			politicasclienteDataAccess.setParameterDbType(this.parameterDbType);
			politicasclientes=politicasclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return politicasclientes;

	}

	public List<Proforma> getProformas(Connexion connexion,TipoPrecio tipoprecio)throws SQLException,Exception {

		List<Proforma> proformas= new ArrayList<Proforma>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio ON "+ProformaConstantesFunciones.SCHEMA+".proforma.id_tipo_precio="+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio.id WHERE "+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio.id="+String.valueOf(tipoprecio.getId());
			} else {
				sQuery=" INNER JOIN proforma.TipoPrecio WHERE proforma.TipoPrecio.id="+String.valueOf(tipoprecio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProformaDataAccess proformaDataAccess=new ProformaDataAccess();

			proformaDataAccess.setConnexionType(this.connexionType);
			proformaDataAccess.setParameterDbType(this.parameterDbType);
			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return proformas;

	}

	public List<Factura> getFacturas(Connexion connexion,TipoPrecio tipoprecio)throws SQLException,Exception {

		List<Factura> facturas= new ArrayList<Factura>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio ON "+FacturaConstantesFunciones.SCHEMA+".factura.id_tipo_precio="+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio.id WHERE "+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio.id="+String.valueOf(tipoprecio.getId());
			} else {
				sQuery=" INNER JOIN factura.TipoPrecio WHERE factura.TipoPrecio.id="+String.valueOf(tipoprecio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FacturaDataAccess facturaDataAccess=new FacturaDataAccess();

			facturaDataAccess.setConnexionType(this.connexionType);
			facturaDataAccess.setParameterDbType(this.parameterDbType);
			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return facturas;

	}

	public List<NotaCreditoSoli> getNotaCreditoSolis(Connexion connexion,TipoPrecio tipoprecio)throws SQLException,Exception {

		List<NotaCreditoSoli> notacreditosolis= new ArrayList<NotaCreditoSoli>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio ON "+NotaCreditoSoliConstantesFunciones.SCHEMA+".nota_credito_soli.id_tipo_precio="+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio.id WHERE "+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio.id="+String.valueOf(tipoprecio.getId());
			} else {
				sQuery=" INNER JOIN notacreditosoli.TipoPrecio WHERE notacreditosoli.TipoPrecio.id="+String.valueOf(tipoprecio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			NotaCreditoSoliDataAccess notacreditosoliDataAccess=new NotaCreditoSoliDataAccess();

			notacreditosoliDataAccess.setConnexionType(this.connexionType);
			notacreditosoliDataAccess.setParameterDbType(this.parameterDbType);
			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return notacreditosolis;

	}

	public List<Consignacion> getConsignacions(Connexion connexion,TipoPrecio tipoprecio)throws SQLException,Exception {

		List<Consignacion> consignacions= new ArrayList<Consignacion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio ON "+ConsignacionConstantesFunciones.SCHEMA+".consignacion.id_tipo_precio="+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio.id WHERE "+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio.id="+String.valueOf(tipoprecio.getId());
			} else {
				sQuery=" INNER JOIN consignacion.TipoPrecio WHERE consignacion.TipoPrecio.id="+String.valueOf(tipoprecio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ConsignacionDataAccess consignacionDataAccess=new ConsignacionDataAccess();

			consignacionDataAccess.setConnexionType(this.connexionType);
			consignacionDataAccess.setParameterDbType(this.parameterDbType);
			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return consignacions;

	}

	public List<PedidoExpor> getPedidoExpors(Connexion connexion,TipoPrecio tipoprecio)throws SQLException,Exception {

		List<PedidoExpor> pedidoexpors= new ArrayList<PedidoExpor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio ON "+PedidoExporConstantesFunciones.SCHEMA+".pedido_expor.id_tipo_precio="+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio.id WHERE "+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio.id="+String.valueOf(tipoprecio.getId());
			} else {
				sQuery=" INNER JOIN pedidoexpor.TipoPrecio WHERE pedidoexpor.TipoPrecio.id="+String.valueOf(tipoprecio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PedidoExporDataAccess pedidoexporDataAccess=new PedidoExporDataAccess();

			pedidoexporDataAccess.setConnexionType(this.connexionType);
			pedidoexporDataAccess.setParameterDbType(this.parameterDbType);
			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidoexpors;

	}

	public List<ServicioCliente> getServicioClientes(Connexion connexion,TipoPrecio tipoprecio)throws SQLException,Exception {

		List<ServicioCliente> servicioclientes= new ArrayList<ServicioCliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio ON "+ServicioClienteConstantesFunciones.SCHEMA+".servicio_cliente.id_tipo_precio="+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio.id WHERE "+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio.id="+String.valueOf(tipoprecio.getId());
			} else {
				sQuery=" INNER JOIN serviciocliente.TipoPrecio WHERE serviciocliente.TipoPrecio.id="+String.valueOf(tipoprecio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ServicioClienteDataAccess servicioclienteDataAccess=new ServicioClienteDataAccess();

			servicioclienteDataAccess.setConnexionType(this.connexionType);
			servicioclienteDataAccess.setParameterDbType(this.parameterDbType);
			servicioclientes=servicioclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return servicioclientes;

	}

	public List<FacturaPuntoVenta> getFacturaPuntoVentas(Connexion connexion,TipoPrecio tipoprecio)throws SQLException,Exception {

		List<FacturaPuntoVenta> facturapuntoventas= new ArrayList<FacturaPuntoVenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio ON "+FacturaPuntoVentaConstantesFunciones.SCHEMA+".factura_punto_venta.id_tipo_precio="+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio.id WHERE "+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio.id="+String.valueOf(tipoprecio.getId());
			} else {
				sQuery=" INNER JOIN facturapuntoventa.TipoPrecio WHERE facturapuntoventa.TipoPrecio.id="+String.valueOf(tipoprecio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FacturaPuntoVentaDataAccess facturapuntoventaDataAccess=new FacturaPuntoVentaDataAccess();

			facturapuntoventaDataAccess.setConnexionType(this.connexionType);
			facturapuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			facturapuntoventas=facturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return facturapuntoventas;

	}

	public List<GuiaRemision> getGuiaRemisions(Connexion connexion,TipoPrecio tipoprecio)throws SQLException,Exception {

		List<GuiaRemision> guiaremisions= new ArrayList<GuiaRemision>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio ON "+GuiaRemisionConstantesFunciones.SCHEMA+".guia_remision.id_tipo_precio="+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio.id WHERE "+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio.id="+String.valueOf(tipoprecio.getId());
			} else {
				sQuery=" INNER JOIN guiaremision.TipoPrecio WHERE guiaremision.TipoPrecio.id="+String.valueOf(tipoprecio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			GuiaRemisionDataAccess guiaremisionDataAccess=new GuiaRemisionDataAccess();

			guiaremisionDataAccess.setConnexionType(this.connexionType);
			guiaremisionDataAccess.setParameterDbType(this.parameterDbType);
			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return guiaremisions;

	}

	public List<NotaCredito> getNotaCreditos(Connexion connexion,TipoPrecio tipoprecio)throws SQLException,Exception {

		List<NotaCredito> notacreditos= new ArrayList<NotaCredito>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio ON "+NotaCreditoConstantesFunciones.SCHEMA+".nota_credito.id_tipo_precio="+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio.id WHERE "+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio.id="+String.valueOf(tipoprecio.getId());
			} else {
				sQuery=" INNER JOIN notacredito.TipoPrecio WHERE notacredito.TipoPrecio.id="+String.valueOf(tipoprecio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			NotaCreditoDataAccess notacreditoDataAccess=new NotaCreditoDataAccess();

			notacreditoDataAccess.setConnexionType(this.connexionType);
			notacreditoDataAccess.setParameterDbType(this.parameterDbType);
			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return notacreditos;

	}

	public List<Pedido> getPedidos(Connexion connexion,TipoPrecio tipoprecio)throws SQLException,Exception {

		List<Pedido> pedidos= new ArrayList<Pedido>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio ON "+PedidoConstantesFunciones.SCHEMA+".pedido.id_tipo_precio="+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio.id WHERE "+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio.id="+String.valueOf(tipoprecio.getId());
			} else {
				sQuery=" INNER JOIN pedido.TipoPrecio WHERE pedido.TipoPrecio.id="+String.valueOf(tipoprecio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PedidoDataAccess pedidoDataAccess=new PedidoDataAccess();

			pedidoDataAccess.setConnexionType(this.connexionType);
			pedidoDataAccess.setParameterDbType(this.parameterDbType);
			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidos;

	}

	public List<Cliente> getClientes(Connexion connexion,TipoPrecio tipoprecio)throws SQLException,Exception {

		List<Cliente> clientes= new ArrayList<Cliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio ON "+ClienteConstantesFunciones.SCHEMA+".cliente.id_tipo_precio="+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio.id WHERE "+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio.id="+String.valueOf(tipoprecio.getId());
			} else {
				sQuery=" INNER JOIN cliente.TipoPrecio WHERE cliente.TipoPrecio.id="+String.valueOf(tipoprecio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);
			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return clientes;

	}

	public List<NotaCreditoPuntoVenta> getNotaCreditoPuntoVentas(Connexion connexion,TipoPrecio tipoprecio)throws SQLException,Exception {

		List<NotaCreditoPuntoVenta> notacreditopuntoventas= new ArrayList<NotaCreditoPuntoVenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio ON "+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+".nota_credito_punto_venta.id_tipo_precio="+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio.id WHERE "+TipoPrecioConstantesFunciones.SCHEMA+".tipo_precio.id="+String.valueOf(tipoprecio.getId());
			} else {
				sQuery=" INNER JOIN notacreditopuntoventa.TipoPrecio WHERE notacreditopuntoventa.TipoPrecio.id="+String.valueOf(tipoprecio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			NotaCreditoPuntoVentaDataAccess notacreditopuntoventaDataAccess=new NotaCreditoPuntoVentaDataAccess();

			notacreditopuntoventaDataAccess.setConnexionType(this.connexionType);
			notacreditopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return notacreditopuntoventas;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoPrecio tipoprecio) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipoprecio.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tipoprecio.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipoprecio.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipoprecio.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_desde=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_desde.setValue(tipoprecio.getfecha_desde());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_desde);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_hasta=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_hasta.setValue(tipoprecio.getfecha_hasta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_hasta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto=new ParameterValue<Double>();
					parameterMaintenanceValuemonto.setValue(tipoprecio.getmonto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueesta_activo=new ParameterValue<Boolean>();
					parameterMaintenanceValueesta_activo.setValue(tipoprecio.getesta_activo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueesta_activo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(tipoprecio.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipoprecio.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipoprecio.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipoprecio.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipoprecio.getId());
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
	
	public void setIsNewIsChangedFalseTipoPrecio(TipoPrecio tipoprecio)throws Exception  {		
		tipoprecio.setIsNew(false);
		tipoprecio.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoPrecios(List<TipoPrecio> tipoprecios)throws Exception  {				
		for(TipoPrecio tipoprecio:tipoprecios) {
			tipoprecio.setIsNew(false);
			tipoprecio.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoPrecio(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
