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
import com.bydan.erp.inventario.util.*;//DescuentoTipoPrecioConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class DescuentoTipoPrecioDataAccess extends  DescuentoTipoPrecioDataAccessAdditional{ //DescuentoTipoPrecioDataAccessAdditional,DataAccessHelper<DescuentoTipoPrecio>
	//static Logger logger = Logger.getLogger(DescuentoTipoPrecioDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="descuento_tipo_precio";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DescuentoTipoPrecioConstantesFunciones.SCHEMA+"."+DescuentoTipoPrecioConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_usuario,id_bodega,id_tipo_precio,descripcion,porcentaje,fecha_inicio,fecha_fin,esta_activo)values(current_timestamp,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DescuentoTipoPrecioConstantesFunciones.SCHEMA+"."+DescuentoTipoPrecioConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_usuario=?,id_bodega=?,id_tipo_precio=?,descripcion=?,porcentaje=?,fecha_inicio=?,fecha_fin=?,esta_activo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DescuentoTipoPrecioConstantesFunciones.SCHEMA+"."+DescuentoTipoPrecioConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select descuentotipoprecio from "+DescuentoTipoPrecioConstantesFunciones.SPERSISTENCENAME+" descuentotipoprecio";
	public static String QUERYSELECTNATIVE="select "+DescuentoTipoPrecioConstantesFunciones.SCHEMA+"."+DescuentoTipoPrecioConstantesFunciones.TABLENAME+".id,"+DescuentoTipoPrecioConstantesFunciones.SCHEMA+"."+DescuentoTipoPrecioConstantesFunciones.TABLENAME+".version_row,"+DescuentoTipoPrecioConstantesFunciones.SCHEMA+"."+DescuentoTipoPrecioConstantesFunciones.TABLENAME+".id_empresa,"+DescuentoTipoPrecioConstantesFunciones.SCHEMA+"."+DescuentoTipoPrecioConstantesFunciones.TABLENAME+".id_sucursal,"+DescuentoTipoPrecioConstantesFunciones.SCHEMA+"."+DescuentoTipoPrecioConstantesFunciones.TABLENAME+".id_usuario,"+DescuentoTipoPrecioConstantesFunciones.SCHEMA+"."+DescuentoTipoPrecioConstantesFunciones.TABLENAME+".id_bodega,"+DescuentoTipoPrecioConstantesFunciones.SCHEMA+"."+DescuentoTipoPrecioConstantesFunciones.TABLENAME+".id_tipo_precio,"+DescuentoTipoPrecioConstantesFunciones.SCHEMA+"."+DescuentoTipoPrecioConstantesFunciones.TABLENAME+".descripcion,"+DescuentoTipoPrecioConstantesFunciones.SCHEMA+"."+DescuentoTipoPrecioConstantesFunciones.TABLENAME+".porcentaje,"+DescuentoTipoPrecioConstantesFunciones.SCHEMA+"."+DescuentoTipoPrecioConstantesFunciones.TABLENAME+".fecha_inicio,"+DescuentoTipoPrecioConstantesFunciones.SCHEMA+"."+DescuentoTipoPrecioConstantesFunciones.TABLENAME+".fecha_fin,"+DescuentoTipoPrecioConstantesFunciones.SCHEMA+"."+DescuentoTipoPrecioConstantesFunciones.TABLENAME+".esta_activo from "+DescuentoTipoPrecioConstantesFunciones.SCHEMA+"."+DescuentoTipoPrecioConstantesFunciones.TABLENAME;//+" as "+DescuentoTipoPrecioConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DescuentoTipoPrecioConstantesFunciones.SCHEMA+"."+DescuentoTipoPrecioConstantesFunciones.TABLENAME+".id,"+DescuentoTipoPrecioConstantesFunciones.SCHEMA+"."+DescuentoTipoPrecioConstantesFunciones.TABLENAME+".version_row from "+DescuentoTipoPrecioConstantesFunciones.SCHEMA+"."+DescuentoTipoPrecioConstantesFunciones.TABLENAME;//+" as "+DescuentoTipoPrecioConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DescuentoTipoPrecioConstantesFunciones.SCHEMA+"."+DescuentoTipoPrecioConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_usuario=?,id_bodega=?,id_tipo_precio=?,descripcion=?,porcentaje=?,fecha_inicio=?,fecha_fin=?,esta_activo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DESCUENTOTIPOPRECIO_INSERT(?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DESCUENTOTIPOPRECIO_UPDATE(?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DESCUENTOTIPOPRECIO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DESCUENTOTIPOPRECIO_SELECT(?,?)";
	
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
	
	
	protected DescuentoTipoPrecioDataAccessAdditional descuentotipoprecioDataAccessAdditional=null;
	
	public DescuentoTipoPrecioDataAccessAdditional getDescuentoTipoPrecioDataAccessAdditional() {
		return this.descuentotipoprecioDataAccessAdditional;
	}
	
	public void setDescuentoTipoPrecioDataAccessAdditional(DescuentoTipoPrecioDataAccessAdditional descuentotipoprecioDataAccessAdditional) {
		try {
			this.descuentotipoprecioDataAccessAdditional=descuentotipoprecioDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DescuentoTipoPrecioDataAccess() {
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
		DescuentoTipoPrecioDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DescuentoTipoPrecioDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DescuentoTipoPrecioDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDescuentoTipoPrecioOriginal(DescuentoTipoPrecio descuentotipoprecio)throws Exception  {
		descuentotipoprecio.setDescuentoTipoPrecioOriginal((DescuentoTipoPrecio)descuentotipoprecio.clone());		
	}
	
	public void setDescuentoTipoPreciosOriginal(List<DescuentoTipoPrecio> descuentotipoprecios)throws Exception  {
		
		for(DescuentoTipoPrecio descuentotipoprecio:descuentotipoprecios){
			descuentotipoprecio.setDescuentoTipoPrecioOriginal((DescuentoTipoPrecio)descuentotipoprecio.clone());
		}
	}
	
	public static void setDescuentoTipoPrecioOriginalStatic(DescuentoTipoPrecio descuentotipoprecio)throws Exception  {
		descuentotipoprecio.setDescuentoTipoPrecioOriginal((DescuentoTipoPrecio)descuentotipoprecio.clone());		
	}
	
	public static void setDescuentoTipoPreciosOriginalStatic(List<DescuentoTipoPrecio> descuentotipoprecios)throws Exception  {
		
		for(DescuentoTipoPrecio descuentotipoprecio:descuentotipoprecios){
			descuentotipoprecio.setDescuentoTipoPrecioOriginal((DescuentoTipoPrecio)descuentotipoprecio.clone());
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
	
	public  DescuentoTipoPrecio getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DescuentoTipoPrecio entity = new DescuentoTipoPrecio();		
		
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
	
	public  DescuentoTipoPrecio getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DescuentoTipoPrecio entity = new DescuentoTipoPrecio();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DescuentoTipoPrecioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DescuentoTipoPrecioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.DescuentoTipoPrecio.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDescuentoTipoPrecioOriginal(new DescuentoTipoPrecio());
      	    	entity=super.getEntity("",entity,resultSet,DescuentoTipoPrecioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDescuentoTipoPrecio("",entity,resultSet); 
				
				//entity.setDescuentoTipoPrecioOriginal(super.getEntity("",entity.getDescuentoTipoPrecioOriginal(),resultSet,DescuentoTipoPrecioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDescuentoTipoPrecioOriginal(this.getEntityDescuentoTipoPrecio("",entity.getDescuentoTipoPrecioOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDescuentoTipoPrecio(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DescuentoTipoPrecio getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DescuentoTipoPrecio entity = new DescuentoTipoPrecio();
				
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
	
	public  DescuentoTipoPrecio getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DescuentoTipoPrecio entity = new DescuentoTipoPrecio();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DescuentoTipoPrecioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DescuentoTipoPrecioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DescuentoTipoPrecioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.DescuentoTipoPrecio.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDescuentoTipoPrecioOriginal(new DescuentoTipoPrecio());
      	    	entity=super.getEntity("",entity,resultSet,DescuentoTipoPrecioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDescuentoTipoPrecio("",entity,resultSet);    
				
				//entity.setDescuentoTipoPrecioOriginal(super.getEntity("",entity.getDescuentoTipoPrecioOriginal(),resultSet,DescuentoTipoPrecioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDescuentoTipoPrecioOriginal(this.getEntityDescuentoTipoPrecio("",entity.getDescuentoTipoPrecioOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDescuentoTipoPrecio(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DescuentoTipoPrecio
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DescuentoTipoPrecio entity = new DescuentoTipoPrecio();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DescuentoTipoPrecioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DescuentoTipoPrecioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DescuentoTipoPrecioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.DescuentoTipoPrecio.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDescuentoTipoPrecio(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DescuentoTipoPrecio> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DescuentoTipoPrecio> entities = new  ArrayList<DescuentoTipoPrecio>();
		DescuentoTipoPrecio entity = new DescuentoTipoPrecio();		  
		
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
	
	public  List<DescuentoTipoPrecio> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DescuentoTipoPrecio> entities = new  ArrayList<DescuentoTipoPrecio>();
		DescuentoTipoPrecio entity = new DescuentoTipoPrecio();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DescuentoTipoPrecioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DescuentoTipoPrecioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DescuentoTipoPrecioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DescuentoTipoPrecio();
      	    	entity=super.getEntity("",entity,resultSet,DescuentoTipoPrecioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDescuentoTipoPrecio("",entity,resultSet);
      	    	
				//entity.setDescuentoTipoPrecioOriginal( new DescuentoTipoPrecio());
      	    	//entity.setDescuentoTipoPrecioOriginal(super.getEntity("",entity.getDescuentoTipoPrecioOriginal(),resultSet,DescuentoTipoPrecioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDescuentoTipoPrecioOriginal(this.getEntityDescuentoTipoPrecio("",entity.getDescuentoTipoPrecioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDescuentoTipoPrecios(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDescuentoTipoPrecio(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DescuentoTipoPrecio> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DescuentoTipoPrecio> entities = new  ArrayList<DescuentoTipoPrecio>();
		DescuentoTipoPrecio entity = new DescuentoTipoPrecio();		  
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
	
	public  List<DescuentoTipoPrecio> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DescuentoTipoPrecio> entities = new  ArrayList<DescuentoTipoPrecio>();
		DescuentoTipoPrecio entity = new DescuentoTipoPrecio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DescuentoTipoPrecio();
				
				if(conMapGenerico) {
					entity.inicializarMapDescuentoTipoPrecio();
					//entity.setMapDescuentoTipoPrecio(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDescuentoTipoPrecioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDescuentoTipoPrecio().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DescuentoTipoPrecioDataAccess.ISWITHSCHEMA);         		
					entity=DescuentoTipoPrecioDataAccess.getEntityDescuentoTipoPrecio("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDescuentoTipoPrecioOriginal( new DescuentoTipoPrecio());
					////entity.setDescuentoTipoPrecioOriginal(super.getEntity("",entity.getDescuentoTipoPrecioOriginal(),resultSet,DescuentoTipoPrecioDataAccess.ISWITHSCHEMA));         		
					////entity.setDescuentoTipoPrecioOriginal(this.getEntityDescuentoTipoPrecio("",entity.getDescuentoTipoPrecioOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDescuentoTipoPrecios(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDescuentoTipoPrecio(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DescuentoTipoPrecio getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DescuentoTipoPrecio entity = new DescuentoTipoPrecio();		  
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
	
	public  DescuentoTipoPrecio getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DescuentoTipoPrecio entity = new DescuentoTipoPrecio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DescuentoTipoPrecio();
				
				if(conMapGenerico) {
					entity.inicializarMapDescuentoTipoPrecio();
					//entity.setMapDescuentoTipoPrecio(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDescuentoTipoPrecioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDescuentoTipoPrecio().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DescuentoTipoPrecioDataAccess.ISWITHSCHEMA);         		
					entity=DescuentoTipoPrecioDataAccess.getEntityDescuentoTipoPrecio("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDescuentoTipoPrecioOriginal( new DescuentoTipoPrecio());
					////entity.setDescuentoTipoPrecioOriginal(super.getEntity("",entity.getDescuentoTipoPrecioOriginal(),resultSet,DescuentoTipoPrecioDataAccess.ISWITHSCHEMA));         		
					////entity.setDescuentoTipoPrecioOriginal(this.getEntityDescuentoTipoPrecio("",entity.getDescuentoTipoPrecioOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDescuentoTipoPrecio(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDescuentoTipoPrecio(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DescuentoTipoPrecio getEntityDescuentoTipoPrecio(String strPrefijo,DescuentoTipoPrecio entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DescuentoTipoPrecio.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DescuentoTipoPrecio.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DescuentoTipoPrecioDataAccess.setFieldReflectionDescuentoTipoPrecio(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDescuentoTipoPrecio=DescuentoTipoPrecioConstantesFunciones.getTodosTiposColumnasDescuentoTipoPrecio();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDescuentoTipoPrecio) {
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
							field = DescuentoTipoPrecio.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DescuentoTipoPrecio.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DescuentoTipoPrecioDataAccess.setFieldReflectionDescuentoTipoPrecio(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDescuentoTipoPrecio(Field field,String strPrefijo,String sColumn,DescuentoTipoPrecio entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DescuentoTipoPrecioConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DescuentoTipoPrecioConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DescuentoTipoPrecioConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DescuentoTipoPrecioConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DescuentoTipoPrecioConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DescuentoTipoPrecioConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DescuentoTipoPrecioConstantesFunciones.IDTIPOPRECIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DescuentoTipoPrecioConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DescuentoTipoPrecioConstantesFunciones.PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DescuentoTipoPrecioConstantesFunciones.FECHAINICIO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DescuentoTipoPrecioConstantesFunciones.FECHAFIN:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DescuentoTipoPrecioConstantesFunciones.ESTAACTIVO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DescuentoTipoPrecio>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DescuentoTipoPrecio> entities = new  ArrayList<DescuentoTipoPrecio>();
		DescuentoTipoPrecio entity = new DescuentoTipoPrecio();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DescuentoTipoPrecioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DescuentoTipoPrecioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DescuentoTipoPrecioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DescuentoTipoPrecio();
					entity=super.getEntity("",entity,resultSet,DescuentoTipoPrecioDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDescuentoTipoPrecio("",entity,resultSet);
					
					//entity.setDescuentoTipoPrecioOriginal( new DescuentoTipoPrecio());
					//entity.setDescuentoTipoPrecioOriginal(super.getEntity("",entity.getDescuentoTipoPrecioOriginal(),resultSet,DescuentoTipoPrecioDataAccess.ISWITHSCHEMA));         		
					//entity.setDescuentoTipoPrecioOriginal(this.getEntityDescuentoTipoPrecio("",entity.getDescuentoTipoPrecioOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDescuentoTipoPrecios(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDescuentoTipoPrecio(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DescuentoTipoPrecio>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DescuentoTipoPrecio> entities = new  ArrayList<DescuentoTipoPrecio>();
		DescuentoTipoPrecio entity = new DescuentoTipoPrecio();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DescuentoTipoPrecioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DescuentoTipoPrecioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DescuentoTipoPrecioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DescuentoTipoPrecio> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DescuentoTipoPrecio> entities = new  ArrayList<DescuentoTipoPrecio>();
		DescuentoTipoPrecio entity = new DescuentoTipoPrecio();		  
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
	
	public  List<DescuentoTipoPrecio> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DescuentoTipoPrecio> entities = new  ArrayList<DescuentoTipoPrecio>();
		DescuentoTipoPrecio entity = new DescuentoTipoPrecio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DescuentoTipoPrecio();
      	    	entity=super.getEntity("",entity,resultSet,DescuentoTipoPrecioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDescuentoTipoPrecio("",entity,resultSet);
      	    	
				//entity.setDescuentoTipoPrecioOriginal( new DescuentoTipoPrecio());
      	    	//entity.setDescuentoTipoPrecioOriginal(super.getEntity("",entity.getDescuentoTipoPrecioOriginal(),resultSet,DescuentoTipoPrecioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDescuentoTipoPrecioOriginal(this.getEntityDescuentoTipoPrecio("",entity.getDescuentoTipoPrecioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDescuentoTipoPrecios(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDescuentoTipoPrecio(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DescuentoTipoPrecio> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DescuentoTipoPrecio> entities = new  ArrayList<DescuentoTipoPrecio>();
		DescuentoTipoPrecio entity = new DescuentoTipoPrecio();		  
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
	
	public  List<DescuentoTipoPrecio> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DescuentoTipoPrecio> entities = new  ArrayList<DescuentoTipoPrecio>();
		DescuentoTipoPrecio entity = new DescuentoTipoPrecio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DescuentoTipoPrecio();
      	    	entity=super.getEntity("",entity,resultSet,DescuentoTipoPrecioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDescuentoTipoPrecio("",entity,resultSet);
      	    	
				//entity.setDescuentoTipoPrecioOriginal( new DescuentoTipoPrecio());
      	    	//entity.setDescuentoTipoPrecioOriginal(super.getEntity("",entity.getDescuentoTipoPrecioOriginal(),resultSet,DescuentoTipoPrecioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDescuentoTipoPrecioOriginal(this.getEntityDescuentoTipoPrecio("",entity.getDescuentoTipoPrecioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDescuentoTipoPrecios(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DescuentoTipoPrecio getEntityDescuentoTipoPrecio(String strPrefijo,DescuentoTipoPrecio entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+DescuentoTipoPrecioConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DescuentoTipoPrecioConstantesFunciones.IDSUCURSAL));
				entity.setid_usuario(resultSet.getLong(strPrefijo+DescuentoTipoPrecioConstantesFunciones.IDUSUARIO));
				entity.setid_bodega(resultSet.getLong(strPrefijo+DescuentoTipoPrecioConstantesFunciones.IDBODEGA));
				entity.setid_tipo_precio(resultSet.getLong(strPrefijo+DescuentoTipoPrecioConstantesFunciones.IDTIPOPRECIO));
				entity.setdescripcion(resultSet.getString(strPrefijo+DescuentoTipoPrecioConstantesFunciones.DESCRIPCION));
				entity.setporcentaje(resultSet.getDouble(strPrefijo+DescuentoTipoPrecioConstantesFunciones.PORCENTAJE));
				entity.setfecha_inicio(new Date(resultSet.getDate(strPrefijo+DescuentoTipoPrecioConstantesFunciones.FECHAINICIO).getTime()));
				entity.setfecha_fin(new Date(resultSet.getDate(strPrefijo+DescuentoTipoPrecioConstantesFunciones.FECHAFIN).getTime()));
				entity.setesta_activo(resultSet.getBoolean(strPrefijo+DescuentoTipoPrecioConstantesFunciones.ESTAACTIVO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDescuentoTipoPrecio(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DescuentoTipoPrecio entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DescuentoTipoPrecioDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DescuentoTipoPrecioDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DescuentoTipoPrecioDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DescuentoTipoPrecioDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DescuentoTipoPrecioConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DescuentoTipoPrecioDataAccess.TABLENAME,DescuentoTipoPrecioDataAccess.ISWITHSTOREPROCEDURES);
			
			DescuentoTipoPrecioDataAccess.setDescuentoTipoPrecioOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,DescuentoTipoPrecio reldescuentotipoprecio)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldescuentotipoprecio.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DescuentoTipoPrecio reldescuentotipoprecio)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldescuentotipoprecio.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Usuario getUsuario(Connexion connexion,DescuentoTipoPrecio reldescuentotipoprecio)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,reldescuentotipoprecio.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}

	public Bodega getBodega(Connexion connexion,DescuentoTipoPrecio reldescuentotipoprecio)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,reldescuentotipoprecio.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public TipoPrecio getTipoPrecio(Connexion connexion,DescuentoTipoPrecio reldescuentotipoprecio)throws SQLException,Exception {

		TipoPrecio tipoprecio= new TipoPrecio();

		try {
			TipoPrecioDataAccess tipoprecioDataAccess=new TipoPrecioDataAccess();

			tipoprecioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoprecioDataAccess.setConnexionType(this.connexionType);
			tipoprecioDataAccess.setParameterDbType(this.parameterDbType);

			tipoprecio=tipoprecioDataAccess.getEntity(connexion,reldescuentotipoprecio.getid_tipo_precio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoprecio;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DescuentoTipoPrecio descuentotipoprecio) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!descuentotipoprecio.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(descuentotipoprecio.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(descuentotipoprecio.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(descuentotipoprecio.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(descuentotipoprecio.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_precio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_precio.setValue(descuentotipoprecio.getid_tipo_precio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_precio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(descuentotipoprecio.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje.setValue(descuentotipoprecio.getporcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_inicio=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_inicio.setValue(descuentotipoprecio.getfecha_inicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_inicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_fin=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_fin.setValue(descuentotipoprecio.getfecha_fin());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_fin);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueesta_activo=new ParameterValue<Boolean>();
					parameterMaintenanceValueesta_activo.setValue(descuentotipoprecio.getesta_activo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueesta_activo);
					parametersTemp.add(parameterMaintenance);
					
						if(!descuentotipoprecio.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(descuentotipoprecio.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(descuentotipoprecio.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(descuentotipoprecio.getId());
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
	
	public void setIsNewIsChangedFalseDescuentoTipoPrecio(DescuentoTipoPrecio descuentotipoprecio)throws Exception  {		
		descuentotipoprecio.setIsNew(false);
		descuentotipoprecio.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDescuentoTipoPrecios(List<DescuentoTipoPrecio> descuentotipoprecios)throws Exception  {				
		for(DescuentoTipoPrecio descuentotipoprecio:descuentotipoprecios) {
			descuentotipoprecio.setIsNew(false);
			descuentotipoprecio.setIsChanged(false);
		}
	}
	
	public void generarExportarDescuentoTipoPrecio(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
