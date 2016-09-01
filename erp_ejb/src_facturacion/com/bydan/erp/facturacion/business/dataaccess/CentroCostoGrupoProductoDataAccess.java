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
import com.bydan.erp.facturacion.util.*;//CentroCostoGrupoProductoConstantesFunciones;


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
final public class CentroCostoGrupoProductoDataAccess extends  CentroCostoGrupoProductoDataAccessAdditional{ //CentroCostoGrupoProductoDataAccessAdditional,DataAccessHelper<CentroCostoGrupoProducto>
	//static Logger logger = Logger.getLogger(CentroCostoGrupoProductoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="centro_costo_grupo_producto";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+CentroCostoGrupoProductoConstantesFunciones.SCHEMA+"."+CentroCostoGrupoProductoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_centro_costo,id_linea,id_linea_grupo,descripcion)values(current_timestamp,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+CentroCostoGrupoProductoConstantesFunciones.SCHEMA+"."+CentroCostoGrupoProductoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_centro_costo=?,id_linea=?,id_linea_grupo=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+CentroCostoGrupoProductoConstantesFunciones.SCHEMA+"."+CentroCostoGrupoProductoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select centrocostogrupoproducto from "+CentroCostoGrupoProductoConstantesFunciones.SPERSISTENCENAME+" centrocostogrupoproducto";
	public static String QUERYSELECTNATIVE="select "+CentroCostoGrupoProductoConstantesFunciones.SCHEMA+"."+CentroCostoGrupoProductoConstantesFunciones.TABLENAME+".id,"+CentroCostoGrupoProductoConstantesFunciones.SCHEMA+"."+CentroCostoGrupoProductoConstantesFunciones.TABLENAME+".version_row,"+CentroCostoGrupoProductoConstantesFunciones.SCHEMA+"."+CentroCostoGrupoProductoConstantesFunciones.TABLENAME+".id_empresa,"+CentroCostoGrupoProductoConstantesFunciones.SCHEMA+"."+CentroCostoGrupoProductoConstantesFunciones.TABLENAME+".id_sucursal,"+CentroCostoGrupoProductoConstantesFunciones.SCHEMA+"."+CentroCostoGrupoProductoConstantesFunciones.TABLENAME+".id_centro_costo,"+CentroCostoGrupoProductoConstantesFunciones.SCHEMA+"."+CentroCostoGrupoProductoConstantesFunciones.TABLENAME+".id_linea,"+CentroCostoGrupoProductoConstantesFunciones.SCHEMA+"."+CentroCostoGrupoProductoConstantesFunciones.TABLENAME+".id_linea_grupo,"+CentroCostoGrupoProductoConstantesFunciones.SCHEMA+"."+CentroCostoGrupoProductoConstantesFunciones.TABLENAME+".descripcion from "+CentroCostoGrupoProductoConstantesFunciones.SCHEMA+"."+CentroCostoGrupoProductoConstantesFunciones.TABLENAME;//+" as "+CentroCostoGrupoProductoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+CentroCostoGrupoProductoConstantesFunciones.SCHEMA+"."+CentroCostoGrupoProductoConstantesFunciones.TABLENAME+".id,"+CentroCostoGrupoProductoConstantesFunciones.SCHEMA+"."+CentroCostoGrupoProductoConstantesFunciones.TABLENAME+".version_row from "+CentroCostoGrupoProductoConstantesFunciones.SCHEMA+"."+CentroCostoGrupoProductoConstantesFunciones.TABLENAME;//+" as "+CentroCostoGrupoProductoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+CentroCostoGrupoProductoConstantesFunciones.SCHEMA+"."+CentroCostoGrupoProductoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_centro_costo=?,id_linea=?,id_linea_grupo=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_CENTROCOSTOGRUPOPRODUCTO_INSERT(?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_CENTROCOSTOGRUPOPRODUCTO_UPDATE(?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_CENTROCOSTOGRUPOPRODUCTO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_CENTROCOSTOGRUPOPRODUCTO_SELECT(?,?)";
	
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
	
	
	protected CentroCostoGrupoProductoDataAccessAdditional centrocostogrupoproductoDataAccessAdditional=null;
	
	public CentroCostoGrupoProductoDataAccessAdditional getCentroCostoGrupoProductoDataAccessAdditional() {
		return this.centrocostogrupoproductoDataAccessAdditional;
	}
	
	public void setCentroCostoGrupoProductoDataAccessAdditional(CentroCostoGrupoProductoDataAccessAdditional centrocostogrupoproductoDataAccessAdditional) {
		try {
			this.centrocostogrupoproductoDataAccessAdditional=centrocostogrupoproductoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public CentroCostoGrupoProductoDataAccess() {
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
		CentroCostoGrupoProductoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		CentroCostoGrupoProductoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		CentroCostoGrupoProductoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setCentroCostoGrupoProductoOriginal(CentroCostoGrupoProducto centrocostogrupoproducto)throws Exception  {
		centrocostogrupoproducto.setCentroCostoGrupoProductoOriginal((CentroCostoGrupoProducto)centrocostogrupoproducto.clone());		
	}
	
	public void setCentroCostoGrupoProductosOriginal(List<CentroCostoGrupoProducto> centrocostogrupoproductos)throws Exception  {
		
		for(CentroCostoGrupoProducto centrocostogrupoproducto:centrocostogrupoproductos){
			centrocostogrupoproducto.setCentroCostoGrupoProductoOriginal((CentroCostoGrupoProducto)centrocostogrupoproducto.clone());
		}
	}
	
	public static void setCentroCostoGrupoProductoOriginalStatic(CentroCostoGrupoProducto centrocostogrupoproducto)throws Exception  {
		centrocostogrupoproducto.setCentroCostoGrupoProductoOriginal((CentroCostoGrupoProducto)centrocostogrupoproducto.clone());		
	}
	
	public static void setCentroCostoGrupoProductosOriginalStatic(List<CentroCostoGrupoProducto> centrocostogrupoproductos)throws Exception  {
		
		for(CentroCostoGrupoProducto centrocostogrupoproducto:centrocostogrupoproductos){
			centrocostogrupoproducto.setCentroCostoGrupoProductoOriginal((CentroCostoGrupoProducto)centrocostogrupoproducto.clone());
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
	
	public  CentroCostoGrupoProducto getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		CentroCostoGrupoProducto entity = new CentroCostoGrupoProducto();		
		
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
	
	public  CentroCostoGrupoProducto getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		CentroCostoGrupoProducto entity = new CentroCostoGrupoProducto();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CentroCostoGrupoProductoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CentroCostoGrupoProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.CentroCostoGrupoProducto.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setCentroCostoGrupoProductoOriginal(new CentroCostoGrupoProducto());
      	    	entity=super.getEntity("",entity,resultSet,CentroCostoGrupoProductoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCentroCostoGrupoProducto("",entity,resultSet); 
				
				//entity.setCentroCostoGrupoProductoOriginal(super.getEntity("",entity.getCentroCostoGrupoProductoOriginal(),resultSet,CentroCostoGrupoProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCentroCostoGrupoProductoOriginal(this.getEntityCentroCostoGrupoProducto("",entity.getCentroCostoGrupoProductoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseCentroCostoGrupoProducto(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  CentroCostoGrupoProducto getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CentroCostoGrupoProducto entity = new CentroCostoGrupoProducto();
				
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
	
	public  CentroCostoGrupoProducto getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CentroCostoGrupoProducto entity = new CentroCostoGrupoProducto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CentroCostoGrupoProductoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CentroCostoGrupoProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CentroCostoGrupoProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.CentroCostoGrupoProducto.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setCentroCostoGrupoProductoOriginal(new CentroCostoGrupoProducto());
      	    	entity=super.getEntity("",entity,resultSet,CentroCostoGrupoProductoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCentroCostoGrupoProducto("",entity,resultSet);    
				
				//entity.setCentroCostoGrupoProductoOriginal(super.getEntity("",entity.getCentroCostoGrupoProductoOriginal(),resultSet,CentroCostoGrupoProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCentroCostoGrupoProductoOriginal(this.getEntityCentroCostoGrupoProducto("",entity.getCentroCostoGrupoProductoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseCentroCostoGrupoProducto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //CentroCostoGrupoProducto
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		CentroCostoGrupoProducto entity = new CentroCostoGrupoProducto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CentroCostoGrupoProductoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CentroCostoGrupoProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CentroCostoGrupoProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.CentroCostoGrupoProducto.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseCentroCostoGrupoProducto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<CentroCostoGrupoProducto> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CentroCostoGrupoProducto> entities = new  ArrayList<CentroCostoGrupoProducto>();
		CentroCostoGrupoProducto entity = new CentroCostoGrupoProducto();		  
		
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
	
	public  List<CentroCostoGrupoProducto> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CentroCostoGrupoProducto> entities = new  ArrayList<CentroCostoGrupoProducto>();
		CentroCostoGrupoProducto entity = new CentroCostoGrupoProducto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=CentroCostoGrupoProductoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CentroCostoGrupoProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CentroCostoGrupoProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CentroCostoGrupoProducto();
      	    	entity=super.getEntity("",entity,resultSet,CentroCostoGrupoProductoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCentroCostoGrupoProducto("",entity,resultSet);
      	    	
				//entity.setCentroCostoGrupoProductoOriginal( new CentroCostoGrupoProducto());
      	    	//entity.setCentroCostoGrupoProductoOriginal(super.getEntity("",entity.getCentroCostoGrupoProductoOriginal(),resultSet,CentroCostoGrupoProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCentroCostoGrupoProductoOriginal(this.getEntityCentroCostoGrupoProducto("",entity.getCentroCostoGrupoProductoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCentroCostoGrupoProductos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCentroCostoGrupoProducto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CentroCostoGrupoProducto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CentroCostoGrupoProducto> entities = new  ArrayList<CentroCostoGrupoProducto>();
		CentroCostoGrupoProducto entity = new CentroCostoGrupoProducto();		  
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
	
	public  List<CentroCostoGrupoProducto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CentroCostoGrupoProducto> entities = new  ArrayList<CentroCostoGrupoProducto>();
		CentroCostoGrupoProducto entity = new CentroCostoGrupoProducto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CentroCostoGrupoProducto();
				
				if(conMapGenerico) {
					entity.inicializarMapCentroCostoGrupoProducto();
					//entity.setMapCentroCostoGrupoProducto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapCentroCostoGrupoProductoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCentroCostoGrupoProducto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CentroCostoGrupoProductoDataAccess.ISWITHSCHEMA);         		
					entity=CentroCostoGrupoProductoDataAccess.getEntityCentroCostoGrupoProducto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCentroCostoGrupoProductoOriginal( new CentroCostoGrupoProducto());
					////entity.setCentroCostoGrupoProductoOriginal(super.getEntity("",entity.getCentroCostoGrupoProductoOriginal(),resultSet,CentroCostoGrupoProductoDataAccess.ISWITHSCHEMA));         		
					////entity.setCentroCostoGrupoProductoOriginal(this.getEntityCentroCostoGrupoProducto("",entity.getCentroCostoGrupoProductoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCentroCostoGrupoProductos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCentroCostoGrupoProducto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public CentroCostoGrupoProducto getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CentroCostoGrupoProducto entity = new CentroCostoGrupoProducto();		  
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
	
	public  CentroCostoGrupoProducto getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CentroCostoGrupoProducto entity = new CentroCostoGrupoProducto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CentroCostoGrupoProducto();
				
				if(conMapGenerico) {
					entity.inicializarMapCentroCostoGrupoProducto();
					//entity.setMapCentroCostoGrupoProducto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapCentroCostoGrupoProductoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCentroCostoGrupoProducto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CentroCostoGrupoProductoDataAccess.ISWITHSCHEMA);         		
					entity=CentroCostoGrupoProductoDataAccess.getEntityCentroCostoGrupoProducto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCentroCostoGrupoProductoOriginal( new CentroCostoGrupoProducto());
					////entity.setCentroCostoGrupoProductoOriginal(super.getEntity("",entity.getCentroCostoGrupoProductoOriginal(),resultSet,CentroCostoGrupoProductoDataAccess.ISWITHSCHEMA));         		
					////entity.setCentroCostoGrupoProductoOriginal(this.getEntityCentroCostoGrupoProducto("",entity.getCentroCostoGrupoProductoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseCentroCostoGrupoProducto(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCentroCostoGrupoProducto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CentroCostoGrupoProducto getEntityCentroCostoGrupoProducto(String strPrefijo,CentroCostoGrupoProducto entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = CentroCostoGrupoProducto.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = CentroCostoGrupoProducto.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					CentroCostoGrupoProductoDataAccess.setFieldReflectionCentroCostoGrupoProducto(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasCentroCostoGrupoProducto=CentroCostoGrupoProductoConstantesFunciones.getTodosTiposColumnasCentroCostoGrupoProducto();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasCentroCostoGrupoProducto) {
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
							field = CentroCostoGrupoProducto.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = CentroCostoGrupoProducto.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						CentroCostoGrupoProductoDataAccess.setFieldReflectionCentroCostoGrupoProducto(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCentroCostoGrupoProducto(Field field,String strPrefijo,String sColumn,CentroCostoGrupoProducto entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CentroCostoGrupoProductoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CentroCostoGrupoProductoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CentroCostoGrupoProductoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CentroCostoGrupoProductoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CentroCostoGrupoProductoConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CentroCostoGrupoProductoConstantesFunciones.IDLINEA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CentroCostoGrupoProductoConstantesFunciones.IDLINEAGRUPO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CentroCostoGrupoProductoConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CentroCostoGrupoProducto>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<CentroCostoGrupoProducto> entities = new  ArrayList<CentroCostoGrupoProducto>();
		CentroCostoGrupoProducto entity = new CentroCostoGrupoProducto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CentroCostoGrupoProductoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CentroCostoGrupoProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CentroCostoGrupoProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new CentroCostoGrupoProducto();
					entity=super.getEntity("",entity,resultSet,CentroCostoGrupoProductoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityCentroCostoGrupoProducto("",entity,resultSet);
					
					//entity.setCentroCostoGrupoProductoOriginal( new CentroCostoGrupoProducto());
					//entity.setCentroCostoGrupoProductoOriginal(super.getEntity("",entity.getCentroCostoGrupoProductoOriginal(),resultSet,CentroCostoGrupoProductoDataAccess.ISWITHSCHEMA));         		
					//entity.setCentroCostoGrupoProductoOriginal(this.getEntityCentroCostoGrupoProducto("",entity.getCentroCostoGrupoProductoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseCentroCostoGrupoProductos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCentroCostoGrupoProducto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CentroCostoGrupoProducto>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<CentroCostoGrupoProducto> entities = new  ArrayList<CentroCostoGrupoProducto>();
		CentroCostoGrupoProducto entity = new CentroCostoGrupoProducto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CentroCostoGrupoProductoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CentroCostoGrupoProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CentroCostoGrupoProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<CentroCostoGrupoProducto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CentroCostoGrupoProducto> entities = new  ArrayList<CentroCostoGrupoProducto>();
		CentroCostoGrupoProducto entity = new CentroCostoGrupoProducto();		  
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
	
	public  List<CentroCostoGrupoProducto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CentroCostoGrupoProducto> entities = new  ArrayList<CentroCostoGrupoProducto>();
		CentroCostoGrupoProducto entity = new CentroCostoGrupoProducto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CentroCostoGrupoProducto();
      	    	entity=super.getEntity("",entity,resultSet,CentroCostoGrupoProductoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCentroCostoGrupoProducto("",entity,resultSet);
      	    	
				//entity.setCentroCostoGrupoProductoOriginal( new CentroCostoGrupoProducto());
      	    	//entity.setCentroCostoGrupoProductoOriginal(super.getEntity("",entity.getCentroCostoGrupoProductoOriginal(),resultSet,CentroCostoGrupoProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCentroCostoGrupoProductoOriginal(this.getEntityCentroCostoGrupoProducto("",entity.getCentroCostoGrupoProductoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseCentroCostoGrupoProductos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCentroCostoGrupoProducto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CentroCostoGrupoProducto> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CentroCostoGrupoProducto> entities = new  ArrayList<CentroCostoGrupoProducto>();
		CentroCostoGrupoProducto entity = new CentroCostoGrupoProducto();		  
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
	
	public  List<CentroCostoGrupoProducto> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CentroCostoGrupoProducto> entities = new  ArrayList<CentroCostoGrupoProducto>();
		CentroCostoGrupoProducto entity = new CentroCostoGrupoProducto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CentroCostoGrupoProducto();
      	    	entity=super.getEntity("",entity,resultSet,CentroCostoGrupoProductoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCentroCostoGrupoProducto("",entity,resultSet);
      	    	
				//entity.setCentroCostoGrupoProductoOriginal( new CentroCostoGrupoProducto());
      	    	//entity.setCentroCostoGrupoProductoOriginal(super.getEntity("",entity.getCentroCostoGrupoProductoOriginal(),resultSet,CentroCostoGrupoProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCentroCostoGrupoProductoOriginal(this.getEntityCentroCostoGrupoProducto("",entity.getCentroCostoGrupoProductoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCentroCostoGrupoProductos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public CentroCostoGrupoProducto getEntityCentroCostoGrupoProducto(String strPrefijo,CentroCostoGrupoProducto entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+CentroCostoGrupoProductoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+CentroCostoGrupoProductoConstantesFunciones.IDSUCURSAL));
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+CentroCostoGrupoProductoConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setid_linea(resultSet.getLong(strPrefijo+CentroCostoGrupoProductoConstantesFunciones.IDLINEA));
				entity.setid_linea_grupo(resultSet.getLong(strPrefijo+CentroCostoGrupoProductoConstantesFunciones.IDLINEAGRUPO));
				entity.setdescripcion(resultSet.getString(strPrefijo+CentroCostoGrupoProductoConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowCentroCostoGrupoProducto(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(CentroCostoGrupoProducto entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=CentroCostoGrupoProductoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=CentroCostoGrupoProductoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=CentroCostoGrupoProductoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=CentroCostoGrupoProductoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(CentroCostoGrupoProductoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,CentroCostoGrupoProductoDataAccess.TABLENAME,CentroCostoGrupoProductoDataAccess.ISWITHSTOREPROCEDURES);
			
			CentroCostoGrupoProductoDataAccess.setCentroCostoGrupoProductoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,CentroCostoGrupoProducto relcentrocostogrupoproducto)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relcentrocostogrupoproducto.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,CentroCostoGrupoProducto relcentrocostogrupoproducto)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relcentrocostogrupoproducto.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public CentroCosto getCentroCosto(Connexion connexion,CentroCostoGrupoProducto relcentrocostogrupoproducto)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,relcentrocostogrupoproducto.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}

	public Linea getLinea(Connexion connexion,CentroCostoGrupoProducto relcentrocostogrupoproducto)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);

			linea=lineaDataAccess.getEntity(connexion,relcentrocostogrupoproducto.getid_linea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaGrupo(Connexion connexion,CentroCostoGrupoProducto relcentrocostogrupoproducto)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);

			linea=lineaDataAccess.getEntity(connexion,relcentrocostogrupoproducto.getid_linea_grupo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,CentroCostoGrupoProducto centrocostogrupoproducto) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!centrocostogrupoproducto.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(centrocostogrupoproducto.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(centrocostogrupoproducto.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(centrocostogrupoproducto.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_linea=new ParameterValue<Long>();
					parameterMaintenanceValueid_linea.setValue(centrocostogrupoproducto.getid_linea());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_linea);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_linea_grupo=new ParameterValue<Long>();
					parameterMaintenanceValueid_linea_grupo.setValue(centrocostogrupoproducto.getid_linea_grupo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_linea_grupo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(centrocostogrupoproducto.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!centrocostogrupoproducto.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(centrocostogrupoproducto.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(centrocostogrupoproducto.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(centrocostogrupoproducto.getId());
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
	
	public void setIsNewIsChangedFalseCentroCostoGrupoProducto(CentroCostoGrupoProducto centrocostogrupoproducto)throws Exception  {		
		centrocostogrupoproducto.setIsNew(false);
		centrocostogrupoproducto.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseCentroCostoGrupoProductos(List<CentroCostoGrupoProducto> centrocostogrupoproductos)throws Exception  {				
		for(CentroCostoGrupoProducto centrocostogrupoproducto:centrocostogrupoproductos) {
			centrocostogrupoproducto.setIsNew(false);
			centrocostogrupoproducto.setIsChanged(false);
		}
	}
	
	public void generarExportarCentroCostoGrupoProducto(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
