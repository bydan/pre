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
import com.bydan.erp.inventario.util.*;//PlaneacionCompraConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;




@SuppressWarnings("unused")
final public class PlaneacionCompraDataAccess extends  PlaneacionCompraDataAccessAdditional{ //PlaneacionCompraDataAccessAdditional,DataAccessHelper<PlaneacionCompra>
	//static Logger logger = Logger.getLogger(PlaneacionCompraDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="planeacion_compra";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_empleado,id_usuario,id_formato,numero_pre_impreso,fecha,id_mes_inicio,id_mes_fin,numero_meses,fecha_corte,codigo_pedido,descripcion1,descripcion2,descripcion3)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_empleado=?,id_usuario=?,id_formato=?,numero_pre_impreso=?,fecha=?,id_mes_inicio=?,id_mes_fin=?,numero_meses=?,fecha_corte=?,codigo_pedido=?,descripcion1=?,descripcion2=?,descripcion3=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select planeacioncompra from "+PlaneacionCompraConstantesFunciones.SPERSISTENCENAME+" planeacioncompra";
	public static String QUERYSELECTNATIVE="select "+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".id,"+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".version_row,"+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".id_empresa,"+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".id_sucursal,"+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".id_ejercicio,"+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".id_periodo,"+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".id_empleado,"+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".id_usuario,"+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".id_formato,"+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".numero_pre_impreso,"+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".fecha,"+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".id_mes_inicio,"+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".id_mes_fin,"+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".numero_meses,"+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".fecha_corte,"+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".codigo_pedido,"+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".descripcion1,"+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".descripcion2,"+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".descripcion3 from "+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME;//+" as "+PlaneacionCompraConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".id,"+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".version_row from "+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME;//+" as "+PlaneacionCompraConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_empleado=?,id_usuario=?,id_formato=?,numero_pre_impreso=?,fecha=?,id_mes_inicio=?,id_mes_fin=?,numero_meses=?,fecha_corte=?,codigo_pedido=?,descripcion1=?,descripcion2=?,descripcion3=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PLANEACIONCOMPRA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PLANEACIONCOMPRA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PLANEACIONCOMPRA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PLANEACIONCOMPRA_SELECT(?,?)";
	
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
	
	
	protected PlaneacionCompraDataAccessAdditional planeacioncompraDataAccessAdditional=null;
	
	public PlaneacionCompraDataAccessAdditional getPlaneacionCompraDataAccessAdditional() {
		return this.planeacioncompraDataAccessAdditional;
	}
	
	public void setPlaneacionCompraDataAccessAdditional(PlaneacionCompraDataAccessAdditional planeacioncompraDataAccessAdditional) {
		try {
			this.planeacioncompraDataAccessAdditional=planeacioncompraDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public PlaneacionCompraDataAccess() {
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
		PlaneacionCompraDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		PlaneacionCompraDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		PlaneacionCompraDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setPlaneacionCompraOriginal(PlaneacionCompra planeacioncompra)throws Exception  {
		planeacioncompra.setPlaneacionCompraOriginal((PlaneacionCompra)planeacioncompra.clone());		
	}
	
	public void setPlaneacionComprasOriginal(List<PlaneacionCompra> planeacioncompras)throws Exception  {
		
		for(PlaneacionCompra planeacioncompra:planeacioncompras){
			planeacioncompra.setPlaneacionCompraOriginal((PlaneacionCompra)planeacioncompra.clone());
		}
	}
	
	public static void setPlaneacionCompraOriginalStatic(PlaneacionCompra planeacioncompra)throws Exception  {
		planeacioncompra.setPlaneacionCompraOriginal((PlaneacionCompra)planeacioncompra.clone());		
	}
	
	public static void setPlaneacionComprasOriginalStatic(List<PlaneacionCompra> planeacioncompras)throws Exception  {
		
		for(PlaneacionCompra planeacioncompra:planeacioncompras){
			planeacioncompra.setPlaneacionCompraOriginal((PlaneacionCompra)planeacioncompra.clone());
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
	
	public  PlaneacionCompra getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		PlaneacionCompra entity = new PlaneacionCompra();		
		
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
	
	public  PlaneacionCompra getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		PlaneacionCompra entity = new PlaneacionCompra();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PlaneacionCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PlaneacionCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.PlaneacionCompra.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setPlaneacionCompraOriginal(new PlaneacionCompra());
      	    	entity=super.getEntity("",entity,resultSet,PlaneacionCompraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPlaneacionCompra("",entity,resultSet); 
				
				//entity.setPlaneacionCompraOriginal(super.getEntity("",entity.getPlaneacionCompraOriginal(),resultSet,PlaneacionCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPlaneacionCompraOriginal(this.getEntityPlaneacionCompra("",entity.getPlaneacionCompraOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalsePlaneacionCompra(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  PlaneacionCompra getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PlaneacionCompra entity = new PlaneacionCompra();
				
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
	
	public  PlaneacionCompra getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PlaneacionCompra entity = new PlaneacionCompra();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PlaneacionCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PlaneacionCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PlaneacionCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.PlaneacionCompra.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setPlaneacionCompraOriginal(new PlaneacionCompra());
      	    	entity=super.getEntity("",entity,resultSet,PlaneacionCompraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPlaneacionCompra("",entity,resultSet);    
				
				//entity.setPlaneacionCompraOriginal(super.getEntity("",entity.getPlaneacionCompraOriginal(),resultSet,PlaneacionCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPlaneacionCompraOriginal(this.getEntityPlaneacionCompra("",entity.getPlaneacionCompraOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalsePlaneacionCompra(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //PlaneacionCompra
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		PlaneacionCompra entity = new PlaneacionCompra();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PlaneacionCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PlaneacionCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PlaneacionCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.PlaneacionCompra.isActive=1
        	 
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
				//this.setIsNewIsChangedFalsePlaneacionCompra(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<PlaneacionCompra> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PlaneacionCompra> entities = new  ArrayList<PlaneacionCompra>();
		PlaneacionCompra entity = new PlaneacionCompra();		  
		
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
	
	public  List<PlaneacionCompra> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PlaneacionCompra> entities = new  ArrayList<PlaneacionCompra>();
		PlaneacionCompra entity = new PlaneacionCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=PlaneacionCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PlaneacionCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PlaneacionCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PlaneacionCompra();
      	    	entity=super.getEntity("",entity,resultSet,PlaneacionCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPlaneacionCompra("",entity,resultSet);
      	    	
				//entity.setPlaneacionCompraOriginal( new PlaneacionCompra());
      	    	//entity.setPlaneacionCompraOriginal(super.getEntity("",entity.getPlaneacionCompraOriginal(),resultSet,PlaneacionCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPlaneacionCompraOriginal(this.getEntityPlaneacionCompra("",entity.getPlaneacionCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePlaneacionCompras(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPlaneacionCompra(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PlaneacionCompra> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PlaneacionCompra> entities = new  ArrayList<PlaneacionCompra>();
		PlaneacionCompra entity = new PlaneacionCompra();		  
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
	
	public  List<PlaneacionCompra> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PlaneacionCompra> entities = new  ArrayList<PlaneacionCompra>();
		PlaneacionCompra entity = new PlaneacionCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PlaneacionCompra();
				
				if(conMapGenerico) {
					entity.inicializarMapPlaneacionCompra();
					//entity.setMapPlaneacionCompra(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapPlaneacionCompraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPlaneacionCompra().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PlaneacionCompraDataAccess.ISWITHSCHEMA);         		
					entity=PlaneacionCompraDataAccess.getEntityPlaneacionCompra("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPlaneacionCompraOriginal( new PlaneacionCompra());
					////entity.setPlaneacionCompraOriginal(super.getEntity("",entity.getPlaneacionCompraOriginal(),resultSet,PlaneacionCompraDataAccess.ISWITHSCHEMA));         		
					////entity.setPlaneacionCompraOriginal(this.getEntityPlaneacionCompra("",entity.getPlaneacionCompraOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePlaneacionCompras(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPlaneacionCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public PlaneacionCompra getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PlaneacionCompra entity = new PlaneacionCompra();		  
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
	
	public  PlaneacionCompra getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PlaneacionCompra entity = new PlaneacionCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PlaneacionCompra();
				
				if(conMapGenerico) {
					entity.inicializarMapPlaneacionCompra();
					//entity.setMapPlaneacionCompra(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapPlaneacionCompraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPlaneacionCompra().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PlaneacionCompraDataAccess.ISWITHSCHEMA);         		
					entity=PlaneacionCompraDataAccess.getEntityPlaneacionCompra("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPlaneacionCompraOriginal( new PlaneacionCompra());
					////entity.setPlaneacionCompraOriginal(super.getEntity("",entity.getPlaneacionCompraOriginal(),resultSet,PlaneacionCompraDataAccess.ISWITHSCHEMA));         		
					////entity.setPlaneacionCompraOriginal(this.getEntityPlaneacionCompra("",entity.getPlaneacionCompraOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalsePlaneacionCompra(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPlaneacionCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PlaneacionCompra getEntityPlaneacionCompra(String strPrefijo,PlaneacionCompra entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = PlaneacionCompra.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = PlaneacionCompra.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					PlaneacionCompraDataAccess.setFieldReflectionPlaneacionCompra(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasPlaneacionCompra=PlaneacionCompraConstantesFunciones.getTodosTiposColumnasPlaneacionCompra();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasPlaneacionCompra) {
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
							field = PlaneacionCompra.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = PlaneacionCompra.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						PlaneacionCompraDataAccess.setFieldReflectionPlaneacionCompra(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPlaneacionCompra(Field field,String strPrefijo,String sColumn,PlaneacionCompra entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PlaneacionCompraConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PlaneacionCompraConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PlaneacionCompraConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PlaneacionCompraConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PlaneacionCompraConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PlaneacionCompraConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PlaneacionCompraConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PlaneacionCompraConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PlaneacionCompraConstantesFunciones.IDFORMATO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PlaneacionCompraConstantesFunciones.NUMEROPREIMPRESO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PlaneacionCompraConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PlaneacionCompraConstantesFunciones.IDMESINICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PlaneacionCompraConstantesFunciones.IDMESFIN:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PlaneacionCompraConstantesFunciones.NUMEROMESES:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case PlaneacionCompraConstantesFunciones.FECHACORTE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PlaneacionCompraConstantesFunciones.CODIGOPEDIDO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PlaneacionCompraConstantesFunciones.DESCRIPCION1:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PlaneacionCompraConstantesFunciones.DESCRIPCION2:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PlaneacionCompraConstantesFunciones.DESCRIPCION3:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PlaneacionCompra>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<PlaneacionCompra> entities = new  ArrayList<PlaneacionCompra>();
		PlaneacionCompra entity = new PlaneacionCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PlaneacionCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PlaneacionCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PlaneacionCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new PlaneacionCompra();
					entity=super.getEntity("",entity,resultSet,PlaneacionCompraDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityPlaneacionCompra("",entity,resultSet);
					
					//entity.setPlaneacionCompraOriginal( new PlaneacionCompra());
					//entity.setPlaneacionCompraOriginal(super.getEntity("",entity.getPlaneacionCompraOriginal(),resultSet,PlaneacionCompraDataAccess.ISWITHSCHEMA));         		
					//entity.setPlaneacionCompraOriginal(this.getEntityPlaneacionCompra("",entity.getPlaneacionCompraOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalsePlaneacionCompras(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPlaneacionCompra(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PlaneacionCompra>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<PlaneacionCompra> entities = new  ArrayList<PlaneacionCompra>();
		PlaneacionCompra entity = new PlaneacionCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PlaneacionCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PlaneacionCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PlaneacionCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<PlaneacionCompra> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PlaneacionCompra> entities = new  ArrayList<PlaneacionCompra>();
		PlaneacionCompra entity = new PlaneacionCompra();		  
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
	
	public  List<PlaneacionCompra> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PlaneacionCompra> entities = new  ArrayList<PlaneacionCompra>();
		PlaneacionCompra entity = new PlaneacionCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PlaneacionCompra();
      	    	entity=super.getEntity("",entity,resultSet,PlaneacionCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPlaneacionCompra("",entity,resultSet);
      	    	
				//entity.setPlaneacionCompraOriginal( new PlaneacionCompra());
      	    	//entity.setPlaneacionCompraOriginal(super.getEntity("",entity.getPlaneacionCompraOriginal(),resultSet,PlaneacionCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPlaneacionCompraOriginal(this.getEntityPlaneacionCompra("",entity.getPlaneacionCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalsePlaneacionCompras(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPlaneacionCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PlaneacionCompra> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PlaneacionCompra> entities = new  ArrayList<PlaneacionCompra>();
		PlaneacionCompra entity = new PlaneacionCompra();		  
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
	
	public  List<PlaneacionCompra> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PlaneacionCompra> entities = new  ArrayList<PlaneacionCompra>();
		PlaneacionCompra entity = new PlaneacionCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PlaneacionCompra();
      	    	entity=super.getEntity("",entity,resultSet,PlaneacionCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPlaneacionCompra("",entity,resultSet);
      	    	
				//entity.setPlaneacionCompraOriginal( new PlaneacionCompra());
      	    	//entity.setPlaneacionCompraOriginal(super.getEntity("",entity.getPlaneacionCompraOriginal(),resultSet,PlaneacionCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPlaneacionCompraOriginal(this.getEntityPlaneacionCompra("",entity.getPlaneacionCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePlaneacionCompras(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public PlaneacionCompra getEntityPlaneacionCompra(String strPrefijo,PlaneacionCompra entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+PlaneacionCompraConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+PlaneacionCompraConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+PlaneacionCompraConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+PlaneacionCompraConstantesFunciones.IDPERIODO));
				entity.setid_empleado(resultSet.getLong(strPrefijo+PlaneacionCompraConstantesFunciones.IDEMPLEADO));
				entity.setid_usuario(resultSet.getLong(strPrefijo+PlaneacionCompraConstantesFunciones.IDUSUARIO));
				entity.setid_formato(resultSet.getLong(strPrefijo+PlaneacionCompraConstantesFunciones.IDFORMATO));
				entity.setnumero_pre_impreso(resultSet.getString(strPrefijo+PlaneacionCompraConstantesFunciones.NUMEROPREIMPRESO));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+PlaneacionCompraConstantesFunciones.FECHA).getTime()));
				entity.setid_mes_inicio(resultSet.getLong(strPrefijo+PlaneacionCompraConstantesFunciones.IDMESINICIO));
				entity.setid_mes_fin(resultSet.getLong(strPrefijo+PlaneacionCompraConstantesFunciones.IDMESFIN));
				entity.setnumero_meses(resultSet.getInt(strPrefijo+PlaneacionCompraConstantesFunciones.NUMEROMESES));
				entity.setfecha_corte(new Date(resultSet.getDate(strPrefijo+PlaneacionCompraConstantesFunciones.FECHACORTE).getTime()));
				entity.setcodigo_pedido(resultSet.getString(strPrefijo+PlaneacionCompraConstantesFunciones.CODIGOPEDIDO));
				entity.setdescripcion1(resultSet.getString(strPrefijo+PlaneacionCompraConstantesFunciones.DESCRIPCION1));
				entity.setdescripcion2(resultSet.getString(strPrefijo+PlaneacionCompraConstantesFunciones.DESCRIPCION2));
				entity.setdescripcion3(resultSet.getString(strPrefijo+PlaneacionCompraConstantesFunciones.DESCRIPCION3));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowPlaneacionCompra(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(PlaneacionCompra entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=PlaneacionCompraDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=PlaneacionCompraDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=PlaneacionCompraDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=PlaneacionCompraDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(PlaneacionCompraConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,PlaneacionCompraDataAccess.TABLENAME,PlaneacionCompraDataAccess.ISWITHSTOREPROCEDURES);
			
			PlaneacionCompraDataAccess.setPlaneacionCompraOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,PlaneacionCompra relplaneacioncompra)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relplaneacioncompra.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,PlaneacionCompra relplaneacioncompra)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relplaneacioncompra.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,PlaneacionCompra relplaneacioncompra)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relplaneacioncompra.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,PlaneacionCompra relplaneacioncompra)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relplaneacioncompra.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Empleado getEmpleado(Connexion connexion,PlaneacionCompra relplaneacioncompra)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relplaneacioncompra.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Usuario getUsuario(Connexion connexion,PlaneacionCompra relplaneacioncompra)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,relplaneacioncompra.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}

	public Formato getFormato(Connexion connexion,PlaneacionCompra relplaneacioncompra)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relplaneacioncompra.getid_formato());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public Mes getMesInicio(Connexion connexion,PlaneacionCompra relplaneacioncompra)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relplaneacioncompra.getid_mes_inicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public Mes getMesFin(Connexion connexion,PlaneacionCompra relplaneacioncompra)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relplaneacioncompra.getid_mes_fin());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}


		
		public List<DetallePlaneacionCompra> getDetallePlaneacionCompras(Connexion connexion,PlaneacionCompra planeacioncompra)throws SQLException,Exception {

		List<DetallePlaneacionCompra> detalleplaneacioncompras= new ArrayList<DetallePlaneacionCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PlaneacionCompraConstantesFunciones.SCHEMA+".planeacion_compra ON "+DetallePlaneacionCompraConstantesFunciones.SCHEMA+".detalle_planeacion_compra.id_planeacion_compra="+PlaneacionCompraConstantesFunciones.SCHEMA+".planeacion_compra.id WHERE "+PlaneacionCompraConstantesFunciones.SCHEMA+".planeacion_compra.id="+String.valueOf(planeacioncompra.getId());
			} else {
				sQuery=" INNER JOIN detalleplaneacioncompra.PlaneacionCompra WHERE detalleplaneacioncompra.PlaneacionCompra.id="+String.valueOf(planeacioncompra.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetallePlaneacionCompraDataAccess detalleplaneacioncompraDataAccess=new DetallePlaneacionCompraDataAccess();

			detalleplaneacioncompraDataAccess.setConnexionType(this.connexionType);
			detalleplaneacioncompraDataAccess.setParameterDbType(this.parameterDbType);
			detalleplaneacioncompras=detalleplaneacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleplaneacioncompras;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,PlaneacionCompra planeacioncompra) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!planeacioncompra.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(planeacioncompra.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(planeacioncompra.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(planeacioncompra.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(planeacioncompra.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(planeacioncompra.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(planeacioncompra.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato.setValue(planeacioncompra.getid_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_pre_impreso=new ParameterValue<String>();
					parameterMaintenanceValuenumero_pre_impreso.setValue(planeacioncompra.getnumero_pre_impreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_pre_impreso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(planeacioncompra.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes_inicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes_inicio.setValue(planeacioncompra.getid_mes_inicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes_inicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes_fin=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes_fin.setValue(planeacioncompra.getid_mes_fin());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes_fin);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_meses=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_meses.setValue(planeacioncompra.getnumero_meses());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_meses);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_corte=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_corte.setValue(planeacioncompra.getfecha_corte());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_corte);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo_pedido=new ParameterValue<String>();
					parameterMaintenanceValuecodigo_pedido.setValue(planeacioncompra.getcodigo_pedido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo_pedido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion1=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion1.setValue(planeacioncompra.getdescripcion1());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion1);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion2=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion2.setValue(planeacioncompra.getdescripcion2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion3=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion3.setValue(planeacioncompra.getdescripcion3());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion3);
					parametersTemp.add(parameterMaintenance);
					
						if(!planeacioncompra.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(planeacioncompra.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(planeacioncompra.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(planeacioncompra.getId());
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
	
	public void setIsNewIsChangedFalsePlaneacionCompra(PlaneacionCompra planeacioncompra)throws Exception  {		
		planeacioncompra.setIsNew(false);
		planeacioncompra.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalsePlaneacionCompras(List<PlaneacionCompra> planeacioncompras)throws Exception  {				
		for(PlaneacionCompra planeacioncompra:planeacioncompras) {
			planeacioncompra.setIsNew(false);
			planeacioncompra.setIsChanged(false);
		}
	}
	
	public void generarExportarPlaneacionCompra(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
