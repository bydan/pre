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
import com.bydan.erp.inventario.util.*;//DetalleTransferenciaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class DetalleTransferenciaDataAccess extends  DetalleTransferenciaDataAccessAdditional{ //DetalleTransferenciaDataAccessAdditional,DataAccessHelper<DetalleTransferencia>
	//static Logger logger = Logger.getLogger(DetalleTransferenciaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_transferencia";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+"(version_row,id_transferencia,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_anio,id_mes,id_bodega,id_producto,id_unidad,id_bodega_enviar,descripcion,id_novedad_producto,id_estado_detalle_inventario,cantidad,descuento,costo_unitario,costo_total,disponible,lote,fecha_elaboracion_lote,fecha_caducidad_lote,numero_comprobante,lote_cliente)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_transferencia=?,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_bodega=?,id_producto=?,id_unidad=?,id_bodega_enviar=?,descripcion=?,id_novedad_producto=?,id_estado_detalle_inventario=?,cantidad=?,descuento=?,costo_unitario=?,costo_total=?,disponible=?,lote=?,fecha_elaboracion_lote=?,fecha_caducidad_lote=?,numero_comprobante=?,lote_cliente=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detalletransferencia from "+DetalleTransferenciaConstantesFunciones.SPERSISTENCENAME+" detalletransferencia";
	public static String QUERYSELECTNATIVE="select "+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".id,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".version_row,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".id_transferencia,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".id_empresa,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".id_periodo,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".id_anio,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".id_mes,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".id_bodega,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".id_producto,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".id_unidad,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".id_bodega_enviar,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".descripcion,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".id_novedad_producto,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".id_estado_detalle_inventario,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".cantidad,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".descuento,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".costo_unitario,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".costo_total,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".disponible,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".lote,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".fecha_elaboracion_lote,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".fecha_caducidad_lote,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".numero_comprobante,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".lote_cliente from "+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME;//+" as "+DetalleTransferenciaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".id,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".version_row from "+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME;//+" as "+DetalleTransferenciaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_transferencia=?,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_bodega=?,id_producto=?,id_unidad=?,id_bodega_enviar=?,descripcion=?,id_novedad_producto=?,id_estado_detalle_inventario=?,cantidad=?,descuento=?,costo_unitario=?,costo_total=?,disponible=?,lote=?,fecha_elaboracion_lote=?,fecha_caducidad_lote=?,numero_comprobante=?,lote_cliente=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLETRANSFERENCIA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLETRANSFERENCIA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLETRANSFERENCIA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLETRANSFERENCIA_SELECT(?,?)";
	
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
	
	
	protected DetalleTransferenciaDataAccessAdditional detalletransferenciaDataAccessAdditional=null;
	
	public DetalleTransferenciaDataAccessAdditional getDetalleTransferenciaDataAccessAdditional() {
		return this.detalletransferenciaDataAccessAdditional;
	}
	
	public void setDetalleTransferenciaDataAccessAdditional(DetalleTransferenciaDataAccessAdditional detalletransferenciaDataAccessAdditional) {
		try {
			this.detalletransferenciaDataAccessAdditional=detalletransferenciaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetalleTransferenciaDataAccess() {
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
		DetalleTransferenciaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetalleTransferenciaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetalleTransferenciaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetalleTransferenciaOriginal(DetalleTransferencia detalletransferencia)throws Exception  {
		detalletransferencia.setDetalleTransferenciaOriginal((DetalleTransferencia)detalletransferencia.clone());		
	}
	
	public void setDetalleTransferenciasOriginal(List<DetalleTransferencia> detalletransferencias)throws Exception  {
		
		for(DetalleTransferencia detalletransferencia:detalletransferencias){
			detalletransferencia.setDetalleTransferenciaOriginal((DetalleTransferencia)detalletransferencia.clone());
		}
	}
	
	public static void setDetalleTransferenciaOriginalStatic(DetalleTransferencia detalletransferencia)throws Exception  {
		detalletransferencia.setDetalleTransferenciaOriginal((DetalleTransferencia)detalletransferencia.clone());		
	}
	
	public static void setDetalleTransferenciasOriginalStatic(List<DetalleTransferencia> detalletransferencias)throws Exception  {
		
		for(DetalleTransferencia detalletransferencia:detalletransferencias){
			detalletransferencia.setDetalleTransferenciaOriginal((DetalleTransferencia)detalletransferencia.clone());
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
	
	public  DetalleTransferencia getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleTransferencia entity = new DetalleTransferencia();		
		
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
	
	public  DetalleTransferencia getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleTransferencia entity = new DetalleTransferencia();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleTransferenciaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleTransferenciaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.DetalleTransferencia.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetalleTransferenciaOriginal(new DetalleTransferencia());
      	    	entity=super.getEntity("",entity,resultSet,DetalleTransferenciaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleTransferencia("",entity,resultSet); 
				
				//entity.setDetalleTransferenciaOriginal(super.getEntity("",entity.getDetalleTransferenciaOriginal(),resultSet,DetalleTransferenciaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleTransferenciaOriginal(this.getEntityDetalleTransferencia("",entity.getDetalleTransferenciaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleTransferencia(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetalleTransferencia getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleTransferencia entity = new DetalleTransferencia();
				
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
	
	public  DetalleTransferencia getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleTransferencia entity = new DetalleTransferencia();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleTransferenciaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleTransferenciaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleTransferenciaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.DetalleTransferencia.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetalleTransferenciaOriginal(new DetalleTransferencia());
      	    	entity=super.getEntity("",entity,resultSet,DetalleTransferenciaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleTransferencia("",entity,resultSet);    
				
				//entity.setDetalleTransferenciaOriginal(super.getEntity("",entity.getDetalleTransferenciaOriginal(),resultSet,DetalleTransferenciaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleTransferenciaOriginal(this.getEntityDetalleTransferencia("",entity.getDetalleTransferenciaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleTransferencia(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetalleTransferencia
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetalleTransferencia entity = new DetalleTransferencia();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleTransferenciaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleTransferenciaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleTransferenciaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.DetalleTransferencia.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetalleTransferencia(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetalleTransferencia> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleTransferencia> entities = new  ArrayList<DetalleTransferencia>();
		DetalleTransferencia entity = new DetalleTransferencia();		  
		
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
	
	public  List<DetalleTransferencia> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleTransferencia> entities = new  ArrayList<DetalleTransferencia>();
		DetalleTransferencia entity = new DetalleTransferencia();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleTransferenciaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleTransferenciaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleTransferenciaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleTransferencia();
      	    	entity=super.getEntity("",entity,resultSet,DetalleTransferenciaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleTransferencia("",entity,resultSet);
      	    	
				//entity.setDetalleTransferenciaOriginal( new DetalleTransferencia());
      	    	//entity.setDetalleTransferenciaOriginal(super.getEntity("",entity.getDetalleTransferenciaOriginal(),resultSet,DetalleTransferenciaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleTransferenciaOriginal(this.getEntityDetalleTransferencia("",entity.getDetalleTransferenciaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleTransferencias(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleTransferencia(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleTransferencia> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleTransferencia> entities = new  ArrayList<DetalleTransferencia>();
		DetalleTransferencia entity = new DetalleTransferencia();		  
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
	
	public  List<DetalleTransferencia> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleTransferencia> entities = new  ArrayList<DetalleTransferencia>();
		DetalleTransferencia entity = new DetalleTransferencia();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleTransferencia();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleTransferencia();
					//entity.setMapDetalleTransferencia(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetalleTransferenciaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleTransferencia().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleTransferenciaDataAccess.ISWITHSCHEMA);         		
					entity=DetalleTransferenciaDataAccess.getEntityDetalleTransferencia("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleTransferenciaOriginal( new DetalleTransferencia());
					////entity.setDetalleTransferenciaOriginal(super.getEntity("",entity.getDetalleTransferenciaOriginal(),resultSet,DetalleTransferenciaDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleTransferenciaOriginal(this.getEntityDetalleTransferencia("",entity.getDetalleTransferenciaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleTransferencias(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleTransferencia(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetalleTransferencia getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleTransferencia entity = new DetalleTransferencia();		  
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
	
	public  DetalleTransferencia getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleTransferencia entity = new DetalleTransferencia();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleTransferencia();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleTransferencia();
					//entity.setMapDetalleTransferencia(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetalleTransferenciaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleTransferencia().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleTransferenciaDataAccess.ISWITHSCHEMA);         		
					entity=DetalleTransferenciaDataAccess.getEntityDetalleTransferencia("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleTransferenciaOriginal( new DetalleTransferencia());
					////entity.setDetalleTransferenciaOriginal(super.getEntity("",entity.getDetalleTransferenciaOriginal(),resultSet,DetalleTransferenciaDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleTransferenciaOriginal(this.getEntityDetalleTransferencia("",entity.getDetalleTransferenciaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetalleTransferencia(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleTransferencia(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetalleTransferencia getEntityDetalleTransferencia(String strPrefijo,DetalleTransferencia entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetalleTransferencia.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetalleTransferencia.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetalleTransferenciaDataAccess.setFieldReflectionDetalleTransferencia(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetalleTransferencia=DetalleTransferenciaConstantesFunciones.getTodosTiposColumnasDetalleTransferencia();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetalleTransferencia) {
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
							field = DetalleTransferencia.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetalleTransferencia.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetalleTransferenciaDataAccess.setFieldReflectionDetalleTransferencia(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetalleTransferencia(Field field,String strPrefijo,String sColumn,DetalleTransferencia entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetalleTransferenciaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleTransferenciaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleTransferenciaConstantesFunciones.IDTRANSFERENCIA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleTransferenciaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleTransferenciaConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleTransferenciaConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleTransferenciaConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleTransferenciaConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleTransferenciaConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleTransferenciaConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleTransferenciaConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleTransferenciaConstantesFunciones.IDUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleTransferenciaConstantesFunciones.IDBODEGAENVIAR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleTransferenciaConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleTransferenciaConstantesFunciones.IDNOVEDADPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleTransferenciaConstantesFunciones.IDESTADODETALLEINVENTARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleTransferenciaConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetalleTransferenciaConstantesFunciones.DESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleTransferenciaConstantesFunciones.COSTOUNITARIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleTransferenciaConstantesFunciones.COSTOTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleTransferenciaConstantesFunciones.DISPONIBLE:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetalleTransferenciaConstantesFunciones.LOTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleTransferenciaConstantesFunciones.FECHAELABORACIONLOTE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DetalleTransferenciaConstantesFunciones.FECHACADUCIDADLOTE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DetalleTransferenciaConstantesFunciones.NUMEROCOMPROBANTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleTransferenciaConstantesFunciones.LOTECLIENTE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleTransferencia>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetalleTransferencia> entities = new  ArrayList<DetalleTransferencia>();
		DetalleTransferencia entity = new DetalleTransferencia();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleTransferenciaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleTransferenciaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleTransferenciaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetalleTransferencia();
					entity=super.getEntity("",entity,resultSet,DetalleTransferenciaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetalleTransferencia("",entity,resultSet);
					
					//entity.setDetalleTransferenciaOriginal( new DetalleTransferencia());
					//entity.setDetalleTransferenciaOriginal(super.getEntity("",entity.getDetalleTransferenciaOriginal(),resultSet,DetalleTransferenciaDataAccess.ISWITHSCHEMA));         		
					//entity.setDetalleTransferenciaOriginal(this.getEntityDetalleTransferencia("",entity.getDetalleTransferenciaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetalleTransferencias(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleTransferencia(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleTransferencia>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetalleTransferencia> entities = new  ArrayList<DetalleTransferencia>();
		DetalleTransferencia entity = new DetalleTransferencia();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleTransferenciaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleTransferenciaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleTransferenciaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetalleTransferencia> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleTransferencia> entities = new  ArrayList<DetalleTransferencia>();
		DetalleTransferencia entity = new DetalleTransferencia();		  
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
	
	public  List<DetalleTransferencia> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleTransferencia> entities = new  ArrayList<DetalleTransferencia>();
		DetalleTransferencia entity = new DetalleTransferencia();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleTransferencia();
      	    	entity=super.getEntity("",entity,resultSet,DetalleTransferenciaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleTransferencia("",entity,resultSet);
      	    	
				//entity.setDetalleTransferenciaOriginal( new DetalleTransferencia());
      	    	//entity.setDetalleTransferenciaOriginal(super.getEntity("",entity.getDetalleTransferenciaOriginal(),resultSet,DetalleTransferenciaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleTransferenciaOriginal(this.getEntityDetalleTransferencia("",entity.getDetalleTransferenciaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetalleTransferencias(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleTransferencia(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleTransferencia> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleTransferencia> entities = new  ArrayList<DetalleTransferencia>();
		DetalleTransferencia entity = new DetalleTransferencia();		  
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
	
	public  List<DetalleTransferencia> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleTransferencia> entities = new  ArrayList<DetalleTransferencia>();
		DetalleTransferencia entity = new DetalleTransferencia();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleTransferencia();
      	    	entity=super.getEntity("",entity,resultSet,DetalleTransferenciaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleTransferencia("",entity,resultSet);
      	    	
				//entity.setDetalleTransferenciaOriginal( new DetalleTransferencia());
      	    	//entity.setDetalleTransferenciaOriginal(super.getEntity("",entity.getDetalleTransferenciaOriginal(),resultSet,DetalleTransferenciaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleTransferenciaOriginal(this.getEntityDetalleTransferencia("",entity.getDetalleTransferenciaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleTransferencias(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetalleTransferencia getEntityDetalleTransferencia(String strPrefijo,DetalleTransferencia entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_transferencia(resultSet.getLong(strPrefijo+DetalleTransferenciaConstantesFunciones.IDTRANSFERENCIA));
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetalleTransferenciaConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DetalleTransferenciaConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+DetalleTransferenciaConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+DetalleTransferenciaConstantesFunciones.IDPERIODO));
				entity.setid_anio(resultSet.getLong(strPrefijo+DetalleTransferenciaConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+DetalleTransferenciaConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setid_bodega(resultSet.getLong(strPrefijo+DetalleTransferenciaConstantesFunciones.IDBODEGA));
				entity.setid_producto(resultSet.getLong(strPrefijo+DetalleTransferenciaConstantesFunciones.IDPRODUCTO));
				entity.setid_unidad(resultSet.getLong(strPrefijo+DetalleTransferenciaConstantesFunciones.IDUNIDAD));
				entity.setid_bodega_enviar(resultSet.getLong(strPrefijo+DetalleTransferenciaConstantesFunciones.IDBODEGAENVIAR));
				entity.setdescripcion(resultSet.getString(strPrefijo+DetalleTransferenciaConstantesFunciones.DESCRIPCION));
				entity.setid_novedad_producto(resultSet.getLong(strPrefijo+DetalleTransferenciaConstantesFunciones.IDNOVEDADPRODUCTO));if(resultSet.wasNull()) {entity.setid_novedad_producto(null); }
				entity.setid_estado_detalle_inventario(resultSet.getLong(strPrefijo+DetalleTransferenciaConstantesFunciones.IDESTADODETALLEINVENTARIO));
				entity.setcantidad(resultSet.getInt(strPrefijo+DetalleTransferenciaConstantesFunciones.CANTIDAD));
				entity.setdescuento(resultSet.getDouble(strPrefijo+DetalleTransferenciaConstantesFunciones.DESCUENTO));
				entity.setcosto_unitario(resultSet.getDouble(strPrefijo+DetalleTransferenciaConstantesFunciones.COSTOUNITARIO));
				entity.setcosto_total(resultSet.getDouble(strPrefijo+DetalleTransferenciaConstantesFunciones.COSTOTOTAL));
				entity.setdisponible(resultSet.getInt(strPrefijo+DetalleTransferenciaConstantesFunciones.DISPONIBLE));
				entity.setlote(resultSet.getString(strPrefijo+DetalleTransferenciaConstantesFunciones.LOTE));
				entity.setfecha_elaboracion_lote(new Date(resultSet.getDate(strPrefijo+DetalleTransferenciaConstantesFunciones.FECHAELABORACIONLOTE).getTime()));
				entity.setfecha_caducidad_lote(new Date(resultSet.getDate(strPrefijo+DetalleTransferenciaConstantesFunciones.FECHACADUCIDADLOTE).getTime()));
				entity.setnumero_comprobante(resultSet.getString(strPrefijo+DetalleTransferenciaConstantesFunciones.NUMEROCOMPROBANTE));
				entity.setlote_cliente(resultSet.getString(strPrefijo+DetalleTransferenciaConstantesFunciones.LOTECLIENTE));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetalleTransferencia(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetalleTransferencia entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetalleTransferenciaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetalleTransferenciaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetalleTransferenciaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetalleTransferenciaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetalleTransferenciaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetalleTransferenciaDataAccess.TABLENAME,DetalleTransferenciaDataAccess.ISWITHSTOREPROCEDURES);
			
			DetalleTransferenciaDataAccess.setDetalleTransferenciaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Transferencia getTransferencia(Connexion connexion,DetalleTransferencia reldetalletransferencia)throws SQLException,Exception {

		Transferencia transferencia= new Transferencia();

		try {
			TransferenciaDataAccess transferenciaDataAccess=new TransferenciaDataAccess();

			transferenciaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transferenciaDataAccess.setConnexionType(this.connexionType);
			transferenciaDataAccess.setParameterDbType(this.parameterDbType);

			transferencia=transferenciaDataAccess.getEntity(connexion,reldetalletransferencia.getid_transferencia());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transferencia;

	}

	public Empresa getEmpresa(Connexion connexion,DetalleTransferencia reldetalletransferencia)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetalletransferencia.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DetalleTransferencia reldetalletransferencia)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetalletransferencia.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,DetalleTransferencia reldetalletransferencia)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,reldetalletransferencia.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,DetalleTransferencia reldetalletransferencia)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,reldetalletransferencia.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Anio getAnio(Connexion connexion,DetalleTransferencia reldetalletransferencia)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,reldetalletransferencia.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,DetalleTransferencia reldetalletransferencia)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,reldetalletransferencia.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public Bodega getBodega(Connexion connexion,DetalleTransferencia reldetalletransferencia)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,reldetalletransferencia.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,DetalleTransferencia reldetalletransferencia)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);

			producto=productoDataAccess.getEntity(connexion,reldetalletransferencia.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Unidad getUnidad(Connexion connexion,DetalleTransferencia reldetalletransferencia)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,reldetalletransferencia.getid_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}

	public Bodega getBodegaEnviar(Connexion connexion,DetalleTransferencia reldetalletransferencia)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,reldetalletransferencia.getid_bodega_enviar());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public NovedadProducto getNovedadProducto(Connexion connexion,DetalleTransferencia reldetalletransferencia)throws SQLException,Exception {

		NovedadProducto novedadproducto= new NovedadProducto();

		try {
			NovedadProductoDataAccess novedadproductoDataAccess=new NovedadProductoDataAccess();

			novedadproductoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			novedadproductoDataAccess.setConnexionType(this.connexionType);
			novedadproductoDataAccess.setParameterDbType(this.parameterDbType);

			novedadproducto=novedadproductoDataAccess.getEntity(connexion,reldetalletransferencia.getid_novedad_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return novedadproducto;

	}

	public EstadoDetalleInventario getEstadoDetalleInventario(Connexion connexion,DetalleTransferencia reldetalletransferencia)throws SQLException,Exception {

		EstadoDetalleInventario estadodetalleinventario= new EstadoDetalleInventario();

		try {
			EstadoDetalleInventarioDataAccess estadodetalleinventarioDataAccess=new EstadoDetalleInventarioDataAccess();

			estadodetalleinventarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadodetalleinventarioDataAccess.setConnexionType(this.connexionType);
			estadodetalleinventarioDataAccess.setParameterDbType(this.parameterDbType);

			estadodetalleinventario=estadodetalleinventarioDataAccess.getEntity(connexion,reldetalletransferencia.getid_estado_detalle_inventario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadodetalleinventario;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetalleTransferencia detalletransferencia) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detalletransferencia.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transferencia=new ParameterValue<Long>();
					parameterMaintenanceValueid_transferencia.setValue(detalletransferencia.getid_transferencia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transferencia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detalletransferencia.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(detalletransferencia.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(detalletransferencia.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(detalletransferencia.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(detalletransferencia.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(detalletransferencia.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(detalletransferencia.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto.setValue(detalletransferencia.getid_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad.setValue(detalletransferencia.getid_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega_enviar=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega_enviar.setValue(detalletransferencia.getid_bodega_enviar());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega_enviar);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(detalletransferencia.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_novedad_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_novedad_producto.setValue(detalletransferencia.getid_novedad_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_novedad_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_detalle_inventario=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_detalle_inventario.setValue(detalletransferencia.getid_estado_detalle_inventario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_detalle_inventario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad.setValue(detalletransferencia.getcantidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento.setValue(detalletransferencia.getdescuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_unitario=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_unitario.setValue(detalletransferencia.getcosto_unitario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_unitario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_total=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_total.setValue(detalletransferencia.getcosto_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuedisponible=new ParameterValue<Integer>();
					parameterMaintenanceValuedisponible.setValue(detalletransferencia.getdisponible());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedisponible);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuelote=new ParameterValue<String>();
					parameterMaintenanceValuelote.setValue(detalletransferencia.getlote());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuelote);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_elaboracion_lote=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_elaboracion_lote.setValue(detalletransferencia.getfecha_elaboracion_lote());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_elaboracion_lote);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_caducidad_lote=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_caducidad_lote.setValue(detalletransferencia.getfecha_caducidad_lote());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_caducidad_lote);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_comprobante=new ParameterValue<String>();
					parameterMaintenanceValuenumero_comprobante.setValue(detalletransferencia.getnumero_comprobante());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_comprobante);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuelote_cliente=new ParameterValue<String>();
					parameterMaintenanceValuelote_cliente.setValue(detalletransferencia.getlote_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuelote_cliente);
					parametersTemp.add(parameterMaintenance);
					
						if(!detalletransferencia.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detalletransferencia.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detalletransferencia.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detalletransferencia.getId());
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
	
	public void setIsNewIsChangedFalseDetalleTransferencia(DetalleTransferencia detalletransferencia)throws Exception  {		
		detalletransferencia.setIsNew(false);
		detalletransferencia.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetalleTransferencias(List<DetalleTransferencia> detalletransferencias)throws Exception  {				
		for(DetalleTransferencia detalletransferencia:detalletransferencias) {
			detalletransferencia.setIsNew(false);
			detalletransferencia.setIsChanged(false);
		}
	}
	
	public void generarExportarDetalleTransferencia(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
