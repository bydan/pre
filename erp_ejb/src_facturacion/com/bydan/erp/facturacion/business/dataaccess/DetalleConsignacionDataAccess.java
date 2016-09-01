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
import com.bydan.erp.facturacion.util.*;//DetalleConsignacionConstantesFunciones;


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
final public class DetalleConsignacionDataAccess extends  DetalleConsignacionDataAccessAdditional{ //DetalleConsignacionDataAccessAdditional,DataAccessHelper<DetalleConsignacion>
	//static Logger logger = Logger.getLogger(DetalleConsignacionDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_consignacion";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_anio,id_mes,id_consignacion,id_producto,id_bodega,id_unidad,id_estado_detalle_pedido,cantidad,precio,descuento_porcentaje,descuento_valor,iva,total,ice,costo,utilidad)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_consignacion=?,id_producto=?,id_bodega=?,id_unidad=?,id_estado_detalle_pedido=?,cantidad=?,precio=?,descuento_porcentaje=?,descuento_valor=?,iva=?,total=?,ice=?,costo=?,utilidad=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detalleconsignacion from "+DetalleConsignacionConstantesFunciones.SPERSISTENCENAME+" detalleconsignacion";
	public static String QUERYSELECTNATIVE="select "+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".id,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".version_row,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".id_empresa,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".id_periodo,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".id_anio,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".id_mes,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".id_consignacion,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".id_producto,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".id_bodega,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".id_unidad,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".id_estado_detalle_pedido,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".cantidad,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".precio,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".descuento_porcentaje,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".descuento_valor,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".iva,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".total,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".ice,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".costo,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".utilidad from "+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME;//+" as "+DetalleConsignacionConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".id,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".version_row from "+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME;//+" as "+DetalleConsignacionConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_consignacion=?,id_producto=?,id_bodega=?,id_unidad=?,id_estado_detalle_pedido=?,cantidad=?,precio=?,descuento_porcentaje=?,descuento_valor=?,iva=?,total=?,ice=?,costo=?,utilidad=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLECONSIGNACION_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLECONSIGNACION_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLECONSIGNACION_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLECONSIGNACION_SELECT(?,?)";
	
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
	
	
	protected DetalleConsignacionDataAccessAdditional detalleconsignacionDataAccessAdditional=null;
	
	public DetalleConsignacionDataAccessAdditional getDetalleConsignacionDataAccessAdditional() {
		return this.detalleconsignacionDataAccessAdditional;
	}
	
	public void setDetalleConsignacionDataAccessAdditional(DetalleConsignacionDataAccessAdditional detalleconsignacionDataAccessAdditional) {
		try {
			this.detalleconsignacionDataAccessAdditional=detalleconsignacionDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetalleConsignacionDataAccess() {
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
		DetalleConsignacionDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetalleConsignacionDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetalleConsignacionDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetalleConsignacionOriginal(DetalleConsignacion detalleconsignacion)throws Exception  {
		detalleconsignacion.setDetalleConsignacionOriginal((DetalleConsignacion)detalleconsignacion.clone());		
	}
	
	public void setDetalleConsignacionsOriginal(List<DetalleConsignacion> detalleconsignacions)throws Exception  {
		
		for(DetalleConsignacion detalleconsignacion:detalleconsignacions){
			detalleconsignacion.setDetalleConsignacionOriginal((DetalleConsignacion)detalleconsignacion.clone());
		}
	}
	
	public static void setDetalleConsignacionOriginalStatic(DetalleConsignacion detalleconsignacion)throws Exception  {
		detalleconsignacion.setDetalleConsignacionOriginal((DetalleConsignacion)detalleconsignacion.clone());		
	}
	
	public static void setDetalleConsignacionsOriginalStatic(List<DetalleConsignacion> detalleconsignacions)throws Exception  {
		
		for(DetalleConsignacion detalleconsignacion:detalleconsignacions){
			detalleconsignacion.setDetalleConsignacionOriginal((DetalleConsignacion)detalleconsignacion.clone());
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
	
	public  DetalleConsignacion getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleConsignacion entity = new DetalleConsignacion();		
		
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
	
	public  DetalleConsignacion getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleConsignacion entity = new DetalleConsignacion();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleConsignacionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleConsignacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.DetalleConsignacion.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetalleConsignacionOriginal(new DetalleConsignacion());
      	    	entity=super.getEntity("",entity,resultSet,DetalleConsignacionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleConsignacion("",entity,resultSet); 
				
				//entity.setDetalleConsignacionOriginal(super.getEntity("",entity.getDetalleConsignacionOriginal(),resultSet,DetalleConsignacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleConsignacionOriginal(this.getEntityDetalleConsignacion("",entity.getDetalleConsignacionOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleConsignacion(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetalleConsignacion getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleConsignacion entity = new DetalleConsignacion();
				
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
	
	public  DetalleConsignacion getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleConsignacion entity = new DetalleConsignacion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleConsignacionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleConsignacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleConsignacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.DetalleConsignacion.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetalleConsignacionOriginal(new DetalleConsignacion());
      	    	entity=super.getEntity("",entity,resultSet,DetalleConsignacionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleConsignacion("",entity,resultSet);    
				
				//entity.setDetalleConsignacionOriginal(super.getEntity("",entity.getDetalleConsignacionOriginal(),resultSet,DetalleConsignacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleConsignacionOriginal(this.getEntityDetalleConsignacion("",entity.getDetalleConsignacionOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleConsignacion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetalleConsignacion
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetalleConsignacion entity = new DetalleConsignacion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleConsignacionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleConsignacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleConsignacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.DetalleConsignacion.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetalleConsignacion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetalleConsignacion> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleConsignacion> entities = new  ArrayList<DetalleConsignacion>();
		DetalleConsignacion entity = new DetalleConsignacion();		  
		
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
	
	public  List<DetalleConsignacion> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleConsignacion> entities = new  ArrayList<DetalleConsignacion>();
		DetalleConsignacion entity = new DetalleConsignacion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleConsignacionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleConsignacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleConsignacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleConsignacion();
      	    	entity=super.getEntity("",entity,resultSet,DetalleConsignacionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleConsignacion("",entity,resultSet);
      	    	
				//entity.setDetalleConsignacionOriginal( new DetalleConsignacion());
      	    	//entity.setDetalleConsignacionOriginal(super.getEntity("",entity.getDetalleConsignacionOriginal(),resultSet,DetalleConsignacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleConsignacionOriginal(this.getEntityDetalleConsignacion("",entity.getDetalleConsignacionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleConsignacions(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleConsignacion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleConsignacion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleConsignacion> entities = new  ArrayList<DetalleConsignacion>();
		DetalleConsignacion entity = new DetalleConsignacion();		  
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
	
	public  List<DetalleConsignacion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleConsignacion> entities = new  ArrayList<DetalleConsignacion>();
		DetalleConsignacion entity = new DetalleConsignacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleConsignacion();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleConsignacion();
					//entity.setMapDetalleConsignacion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetalleConsignacionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleConsignacion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleConsignacionDataAccess.ISWITHSCHEMA);         		
					entity=DetalleConsignacionDataAccess.getEntityDetalleConsignacion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleConsignacionOriginal( new DetalleConsignacion());
					////entity.setDetalleConsignacionOriginal(super.getEntity("",entity.getDetalleConsignacionOriginal(),resultSet,DetalleConsignacionDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleConsignacionOriginal(this.getEntityDetalleConsignacion("",entity.getDetalleConsignacionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleConsignacions(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleConsignacion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetalleConsignacion getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleConsignacion entity = new DetalleConsignacion();		  
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
	
	public  DetalleConsignacion getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleConsignacion entity = new DetalleConsignacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleConsignacion();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleConsignacion();
					//entity.setMapDetalleConsignacion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetalleConsignacionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleConsignacion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleConsignacionDataAccess.ISWITHSCHEMA);         		
					entity=DetalleConsignacionDataAccess.getEntityDetalleConsignacion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleConsignacionOriginal( new DetalleConsignacion());
					////entity.setDetalleConsignacionOriginal(super.getEntity("",entity.getDetalleConsignacionOriginal(),resultSet,DetalleConsignacionDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleConsignacionOriginal(this.getEntityDetalleConsignacion("",entity.getDetalleConsignacionOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetalleConsignacion(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleConsignacion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetalleConsignacion getEntityDetalleConsignacion(String strPrefijo,DetalleConsignacion entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetalleConsignacion.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetalleConsignacion.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetalleConsignacionDataAccess.setFieldReflectionDetalleConsignacion(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetalleConsignacion=DetalleConsignacionConstantesFunciones.getTodosTiposColumnasDetalleConsignacion();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetalleConsignacion) {
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
							field = DetalleConsignacion.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetalleConsignacion.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetalleConsignacionDataAccess.setFieldReflectionDetalleConsignacion(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetalleConsignacion(Field field,String strPrefijo,String sColumn,DetalleConsignacion entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetalleConsignacionConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleConsignacionConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleConsignacionConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleConsignacionConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleConsignacionConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleConsignacionConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleConsignacionConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleConsignacionConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleConsignacionConstantesFunciones.IDCONSIGNACION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleConsignacionConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleConsignacionConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleConsignacionConstantesFunciones.IDUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleConsignacionConstantesFunciones.IDESTADODETALLEPEDIDO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleConsignacionConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetalleConsignacionConstantesFunciones.PRECIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleConsignacionConstantesFunciones.DESCUENTOPORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleConsignacionConstantesFunciones.DESCUENTOVALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleConsignacionConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleConsignacionConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleConsignacionConstantesFunciones.ICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleConsignacionConstantesFunciones.COSTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleConsignacionConstantesFunciones.UTILIDAD:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleConsignacion>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetalleConsignacion> entities = new  ArrayList<DetalleConsignacion>();
		DetalleConsignacion entity = new DetalleConsignacion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleConsignacionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleConsignacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleConsignacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetalleConsignacion();
					entity=super.getEntity("",entity,resultSet,DetalleConsignacionDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetalleConsignacion("",entity,resultSet);
					
					//entity.setDetalleConsignacionOriginal( new DetalleConsignacion());
					//entity.setDetalleConsignacionOriginal(super.getEntity("",entity.getDetalleConsignacionOriginal(),resultSet,DetalleConsignacionDataAccess.ISWITHSCHEMA));         		
					//entity.setDetalleConsignacionOriginal(this.getEntityDetalleConsignacion("",entity.getDetalleConsignacionOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetalleConsignacions(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleConsignacion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleConsignacion>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetalleConsignacion> entities = new  ArrayList<DetalleConsignacion>();
		DetalleConsignacion entity = new DetalleConsignacion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleConsignacionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleConsignacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleConsignacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetalleConsignacion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleConsignacion> entities = new  ArrayList<DetalleConsignacion>();
		DetalleConsignacion entity = new DetalleConsignacion();		  
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
	
	public  List<DetalleConsignacion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleConsignacion> entities = new  ArrayList<DetalleConsignacion>();
		DetalleConsignacion entity = new DetalleConsignacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleConsignacion();
      	    	entity=super.getEntity("",entity,resultSet,DetalleConsignacionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleConsignacion("",entity,resultSet);
      	    	
				//entity.setDetalleConsignacionOriginal( new DetalleConsignacion());
      	    	//entity.setDetalleConsignacionOriginal(super.getEntity("",entity.getDetalleConsignacionOriginal(),resultSet,DetalleConsignacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleConsignacionOriginal(this.getEntityDetalleConsignacion("",entity.getDetalleConsignacionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetalleConsignacions(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleConsignacion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleConsignacion> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleConsignacion> entities = new  ArrayList<DetalleConsignacion>();
		DetalleConsignacion entity = new DetalleConsignacion();		  
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
	
	public  List<DetalleConsignacion> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleConsignacion> entities = new  ArrayList<DetalleConsignacion>();
		DetalleConsignacion entity = new DetalleConsignacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleConsignacion();
      	    	entity=super.getEntity("",entity,resultSet,DetalleConsignacionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleConsignacion("",entity,resultSet);
      	    	
				//entity.setDetalleConsignacionOriginal( new DetalleConsignacion());
      	    	//entity.setDetalleConsignacionOriginal(super.getEntity("",entity.getDetalleConsignacionOriginal(),resultSet,DetalleConsignacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleConsignacionOriginal(this.getEntityDetalleConsignacion("",entity.getDetalleConsignacionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleConsignacions(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetalleConsignacion getEntityDetalleConsignacion(String strPrefijo,DetalleConsignacion entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetalleConsignacionConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DetalleConsignacionConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+DetalleConsignacionConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+DetalleConsignacionConstantesFunciones.IDPERIODO));
				entity.setid_anio(resultSet.getLong(strPrefijo+DetalleConsignacionConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+DetalleConsignacionConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setid_consignacion(resultSet.getLong(strPrefijo+DetalleConsignacionConstantesFunciones.IDCONSIGNACION));
				entity.setid_producto(resultSet.getLong(strPrefijo+DetalleConsignacionConstantesFunciones.IDPRODUCTO));
				entity.setid_bodega(resultSet.getLong(strPrefijo+DetalleConsignacionConstantesFunciones.IDBODEGA));
				entity.setid_unidad(resultSet.getLong(strPrefijo+DetalleConsignacionConstantesFunciones.IDUNIDAD));
				entity.setid_estado_detalle_pedido(resultSet.getLong(strPrefijo+DetalleConsignacionConstantesFunciones.IDESTADODETALLEPEDIDO));
				entity.setcantidad(resultSet.getInt(strPrefijo+DetalleConsignacionConstantesFunciones.CANTIDAD));
				entity.setprecio(resultSet.getDouble(strPrefijo+DetalleConsignacionConstantesFunciones.PRECIO));
				entity.setdescuento_porcentaje(resultSet.getDouble(strPrefijo+DetalleConsignacionConstantesFunciones.DESCUENTOPORCENTAJE));
				entity.setdescuento_valor(resultSet.getDouble(strPrefijo+DetalleConsignacionConstantesFunciones.DESCUENTOVALOR));
				entity.setiva(resultSet.getDouble(strPrefijo+DetalleConsignacionConstantesFunciones.IVA));
				entity.settotal(resultSet.getDouble(strPrefijo+DetalleConsignacionConstantesFunciones.TOTAL));
				entity.setice(resultSet.getDouble(strPrefijo+DetalleConsignacionConstantesFunciones.ICE));
				entity.setcosto(resultSet.getDouble(strPrefijo+DetalleConsignacionConstantesFunciones.COSTO));
				entity.setutilidad(resultSet.getDouble(strPrefijo+DetalleConsignacionConstantesFunciones.UTILIDAD));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetalleConsignacion(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetalleConsignacion entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetalleConsignacionDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetalleConsignacionDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetalleConsignacionDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetalleConsignacionDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetalleConsignacionConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetalleConsignacionDataAccess.TABLENAME,DetalleConsignacionDataAccess.ISWITHSTOREPROCEDURES);
			
			DetalleConsignacionDataAccess.setDetalleConsignacionOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,DetalleConsignacion reldetalleconsignacion)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetalleconsignacion.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DetalleConsignacion reldetalleconsignacion)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetalleconsignacion.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,DetalleConsignacion reldetalleconsignacion)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,reldetalleconsignacion.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,DetalleConsignacion reldetalleconsignacion)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,reldetalleconsignacion.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Anio getAnio(Connexion connexion,DetalleConsignacion reldetalleconsignacion)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,reldetalleconsignacion.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,DetalleConsignacion reldetalleconsignacion)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,reldetalleconsignacion.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public Consignacion getConsignacion(Connexion connexion,DetalleConsignacion reldetalleconsignacion)throws SQLException,Exception {

		Consignacion consignacion= new Consignacion();

		try {
			ConsignacionDataAccess consignacionDataAccess=new ConsignacionDataAccess();

			consignacionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			consignacionDataAccess.setConnexionType(this.connexionType);
			consignacionDataAccess.setParameterDbType(this.parameterDbType);

			consignacion=consignacionDataAccess.getEntity(connexion,reldetalleconsignacion.getid_consignacion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return consignacion;

	}

	public Producto getProducto(Connexion connexion,DetalleConsignacion reldetalleconsignacion)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);

			producto=productoDataAccess.getEntity(connexion,reldetalleconsignacion.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Bodega getBodega(Connexion connexion,DetalleConsignacion reldetalleconsignacion)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,reldetalleconsignacion.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Unidad getUnidad(Connexion connexion,DetalleConsignacion reldetalleconsignacion)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,reldetalleconsignacion.getid_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}

	public EstadoDetallePedido getEstadoDetallePedido(Connexion connexion,DetalleConsignacion reldetalleconsignacion)throws SQLException,Exception {

		EstadoDetallePedido estadodetallepedido= new EstadoDetallePedido();

		try {
			EstadoDetallePedidoDataAccess estadodetallepedidoDataAccess=new EstadoDetallePedidoDataAccess();

			estadodetallepedidoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadodetallepedidoDataAccess.setConnexionType(this.connexionType);
			estadodetallepedidoDataAccess.setParameterDbType(this.parameterDbType);

			estadodetallepedido=estadodetallepedidoDataAccess.getEntity(connexion,reldetalleconsignacion.getid_estado_detalle_pedido());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadodetallepedido;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetalleConsignacion detalleconsignacion) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detalleconsignacion.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detalleconsignacion.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(detalleconsignacion.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(detalleconsignacion.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(detalleconsignacion.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(detalleconsignacion.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(detalleconsignacion.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_consignacion=new ParameterValue<Long>();
					parameterMaintenanceValueid_consignacion.setValue(detalleconsignacion.getid_consignacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_consignacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto.setValue(detalleconsignacion.getid_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(detalleconsignacion.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad.setValue(detalleconsignacion.getid_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_detalle_pedido=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_detalle_pedido.setValue(detalleconsignacion.getid_estado_detalle_pedido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_detalle_pedido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad.setValue(detalleconsignacion.getcantidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueprecio=new ParameterValue<Double>();
					parameterMaintenanceValueprecio.setValue(detalleconsignacion.getprecio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueprecio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento_porcentaje=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento_porcentaje.setValue(detalleconsignacion.getdescuento_porcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento_porcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento_valor=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento_valor.setValue(detalleconsignacion.getdescuento_valor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento_valor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva=new ParameterValue<Double>();
					parameterMaintenanceValueiva.setValue(detalleconsignacion.getiva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal=new ParameterValue<Double>();
					parameterMaintenanceValuetotal.setValue(detalleconsignacion.gettotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueice=new ParameterValue<Double>();
					parameterMaintenanceValueice.setValue(detalleconsignacion.getice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto=new ParameterValue<Double>();
					parameterMaintenanceValuecosto.setValue(detalleconsignacion.getcosto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueutilidad=new ParameterValue<Double>();
					parameterMaintenanceValueutilidad.setValue(detalleconsignacion.getutilidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueutilidad);
					parametersTemp.add(parameterMaintenance);
					
						if(!detalleconsignacion.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detalleconsignacion.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detalleconsignacion.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detalleconsignacion.getId());
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
	
	public void setIsNewIsChangedFalseDetalleConsignacion(DetalleConsignacion detalleconsignacion)throws Exception  {		
		detalleconsignacion.setIsNew(false);
		detalleconsignacion.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetalleConsignacions(List<DetalleConsignacion> detalleconsignacions)throws Exception  {				
		for(DetalleConsignacion detalleconsignacion:detalleconsignacions) {
			detalleconsignacion.setIsNew(false);
			detalleconsignacion.setIsChanged(false);
		}
	}
	
	public void generarExportarDetalleConsignacion(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
