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
import com.bydan.erp.inventario.util.*;//DetalleMovimientoInventarioConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class DetalleMovimientoInventarioDataAccess extends  DetalleMovimientoInventarioDataAccessAdditional{ //DetalleMovimientoInventarioDataAccessAdditional,DataAccessHelper<DetalleMovimientoInventario>
	//static Logger logger = Logger.getLogger(DetalleMovimientoInventarioDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_movimiento_inventario";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+"(version_row,id_movimiento_inventario,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_anio,id_mes,id_estado_detalle_movimiento_inventario,id_bodega,id_producto,id_unidad,descripcion,cantidad,descuento,costo_unitario,costo_total,disponible,iva,iva_valor,costo_iva,ice,ice_valor,descuento1,descuento2,serie,lote,fecha_elaboracion_lote,fecha_caducidad_lote,id_novedad_producto,id_centro_costo,id_cuenta_contable_costo,id_tipo_detalle_movimiento_inventario,numero_comprobante,lote_cliente)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_movimiento_inventario=?,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_estado_detalle_movimiento_inventario=?,id_bodega=?,id_producto=?,id_unidad=?,descripcion=?,cantidad=?,descuento=?,costo_unitario=?,costo_total=?,disponible=?,iva=?,iva_valor=?,costo_iva=?,ice=?,ice_valor=?,descuento1=?,descuento2=?,serie=?,lote=?,fecha_elaboracion_lote=?,fecha_caducidad_lote=?,id_novedad_producto=?,id_centro_costo=?,id_cuenta_contable_costo=?,id_tipo_detalle_movimiento_inventario=?,numero_comprobante=?,lote_cliente=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detallemovimientoinventario from "+DetalleMovimientoInventarioConstantesFunciones.SPERSISTENCENAME+" detallemovimientoinventario";
	public static String QUERYSELECTNATIVE="select "+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".version_row,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id_movimiento_inventario,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id_empresa,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id_periodo,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id_anio,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id_mes,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id_estado_detalle_movimiento_inventario,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id_bodega,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id_producto,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id_unidad,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".descripcion,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".cantidad,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".descuento,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".costo_unitario,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".costo_total,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".disponible,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".iva,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".iva_valor,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".costo_iva,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".ice,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".ice_valor,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".descuento1,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".descuento2,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".serie,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".lote,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".fecha_elaboracion_lote,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".fecha_caducidad_lote,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id_novedad_producto,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id_centro_costo,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id_cuenta_contable_costo,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id_tipo_detalle_movimiento_inventario,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".numero_comprobante,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".lote_cliente from "+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME;//+" as "+DetalleMovimientoInventarioConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".version_row from "+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME;//+" as "+DetalleMovimientoInventarioConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_movimiento_inventario=?,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_estado_detalle_movimiento_inventario=?,id_bodega=?,id_producto=?,id_unidad=?,descripcion=?,cantidad=?,descuento=?,costo_unitario=?,costo_total=?,disponible=?,iva=?,iva_valor=?,costo_iva=?,ice=?,ice_valor=?,descuento1=?,descuento2=?,serie=?,lote=?,fecha_elaboracion_lote=?,fecha_caducidad_lote=?,id_novedad_producto=?,id_centro_costo=?,id_cuenta_contable_costo=?,id_tipo_detalle_movimiento_inventario=?,numero_comprobante=?,lote_cliente=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLEMOVIMIENTOINVENTARIO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLEMOVIMIENTOINVENTARIO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLEMOVIMIENTOINVENTARIO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLEMOVIMIENTOINVENTARIO_SELECT(?,?)";
	
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
	
	
	protected DetalleMovimientoInventarioDataAccessAdditional detallemovimientoinventarioDataAccessAdditional=null;
	
	public DetalleMovimientoInventarioDataAccessAdditional getDetalleMovimientoInventarioDataAccessAdditional() {
		return this.detallemovimientoinventarioDataAccessAdditional;
	}
	
	public void setDetalleMovimientoInventarioDataAccessAdditional(DetalleMovimientoInventarioDataAccessAdditional detallemovimientoinventarioDataAccessAdditional) {
		try {
			this.detallemovimientoinventarioDataAccessAdditional=detallemovimientoinventarioDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetalleMovimientoInventarioDataAccess() {
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
		DetalleMovimientoInventarioDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetalleMovimientoInventarioDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetalleMovimientoInventarioDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetalleMovimientoInventarioOriginal(DetalleMovimientoInventario detallemovimientoinventario)throws Exception  {
		detallemovimientoinventario.setDetalleMovimientoInventarioOriginal((DetalleMovimientoInventario)detallemovimientoinventario.clone());		
	}
	
	public void setDetalleMovimientoInventariosOriginal(List<DetalleMovimientoInventario> detallemovimientoinventarios)throws Exception  {
		
		for(DetalleMovimientoInventario detallemovimientoinventario:detallemovimientoinventarios){
			detallemovimientoinventario.setDetalleMovimientoInventarioOriginal((DetalleMovimientoInventario)detallemovimientoinventario.clone());
		}
	}
	
	public static void setDetalleMovimientoInventarioOriginalStatic(DetalleMovimientoInventario detallemovimientoinventario)throws Exception  {
		detallemovimientoinventario.setDetalleMovimientoInventarioOriginal((DetalleMovimientoInventario)detallemovimientoinventario.clone());		
	}
	
	public static void setDetalleMovimientoInventariosOriginalStatic(List<DetalleMovimientoInventario> detallemovimientoinventarios)throws Exception  {
		
		for(DetalleMovimientoInventario detallemovimientoinventario:detallemovimientoinventarios){
			detallemovimientoinventario.setDetalleMovimientoInventarioOriginal((DetalleMovimientoInventario)detallemovimientoinventario.clone());
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
	
	public  DetalleMovimientoInventario getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleMovimientoInventario entity = new DetalleMovimientoInventario();		
		
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
	
	public  DetalleMovimientoInventario getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleMovimientoInventario entity = new DetalleMovimientoInventario();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleMovimientoInventarioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleMovimientoInventarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.DetalleMovimientoInventario.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetalleMovimientoInventarioOriginal(new DetalleMovimientoInventario());
      	    	entity=super.getEntity("",entity,resultSet,DetalleMovimientoInventarioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleMovimientoInventario("",entity,resultSet); 
				
				//entity.setDetalleMovimientoInventarioOriginal(super.getEntity("",entity.getDetalleMovimientoInventarioOriginal(),resultSet,DetalleMovimientoInventarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleMovimientoInventarioOriginal(this.getEntityDetalleMovimientoInventario("",entity.getDetalleMovimientoInventarioOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleMovimientoInventario(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetalleMovimientoInventario getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleMovimientoInventario entity = new DetalleMovimientoInventario();
				
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
	
	public  DetalleMovimientoInventario getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleMovimientoInventario entity = new DetalleMovimientoInventario();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleMovimientoInventarioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleMovimientoInventarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleMovimientoInventarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.DetalleMovimientoInventario.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetalleMovimientoInventarioOriginal(new DetalleMovimientoInventario());
      	    	entity=super.getEntity("",entity,resultSet,DetalleMovimientoInventarioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleMovimientoInventario("",entity,resultSet);    
				
				//entity.setDetalleMovimientoInventarioOriginal(super.getEntity("",entity.getDetalleMovimientoInventarioOriginal(),resultSet,DetalleMovimientoInventarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleMovimientoInventarioOriginal(this.getEntityDetalleMovimientoInventario("",entity.getDetalleMovimientoInventarioOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleMovimientoInventario(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetalleMovimientoInventario
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetalleMovimientoInventario entity = new DetalleMovimientoInventario();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleMovimientoInventarioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleMovimientoInventarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleMovimientoInventarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.DetalleMovimientoInventario.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetalleMovimientoInventario(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetalleMovimientoInventario> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleMovimientoInventario> entities = new  ArrayList<DetalleMovimientoInventario>();
		DetalleMovimientoInventario entity = new DetalleMovimientoInventario();		  
		
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
	
	public  List<DetalleMovimientoInventario> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleMovimientoInventario> entities = new  ArrayList<DetalleMovimientoInventario>();
		DetalleMovimientoInventario entity = new DetalleMovimientoInventario();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleMovimientoInventarioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleMovimientoInventarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleMovimientoInventarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleMovimientoInventario();
      	    	entity=super.getEntity("",entity,resultSet,DetalleMovimientoInventarioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleMovimientoInventario("",entity,resultSet);
      	    	
				//entity.setDetalleMovimientoInventarioOriginal( new DetalleMovimientoInventario());
      	    	//entity.setDetalleMovimientoInventarioOriginal(super.getEntity("",entity.getDetalleMovimientoInventarioOriginal(),resultSet,DetalleMovimientoInventarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleMovimientoInventarioOriginal(this.getEntityDetalleMovimientoInventario("",entity.getDetalleMovimientoInventarioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleMovimientoInventarios(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleMovimientoInventario(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleMovimientoInventario> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleMovimientoInventario> entities = new  ArrayList<DetalleMovimientoInventario>();
		DetalleMovimientoInventario entity = new DetalleMovimientoInventario();		  
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
	
	public  List<DetalleMovimientoInventario> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleMovimientoInventario> entities = new  ArrayList<DetalleMovimientoInventario>();
		DetalleMovimientoInventario entity = new DetalleMovimientoInventario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleMovimientoInventario();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleMovimientoInventario();
					//entity.setMapDetalleMovimientoInventario(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetalleMovimientoInventarioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleMovimientoInventario().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleMovimientoInventarioDataAccess.ISWITHSCHEMA);         		
					entity=DetalleMovimientoInventarioDataAccess.getEntityDetalleMovimientoInventario("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleMovimientoInventarioOriginal( new DetalleMovimientoInventario());
					////entity.setDetalleMovimientoInventarioOriginal(super.getEntity("",entity.getDetalleMovimientoInventarioOriginal(),resultSet,DetalleMovimientoInventarioDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleMovimientoInventarioOriginal(this.getEntityDetalleMovimientoInventario("",entity.getDetalleMovimientoInventarioOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleMovimientoInventarios(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleMovimientoInventario(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetalleMovimientoInventario getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleMovimientoInventario entity = new DetalleMovimientoInventario();		  
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
	
	public  DetalleMovimientoInventario getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleMovimientoInventario entity = new DetalleMovimientoInventario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleMovimientoInventario();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleMovimientoInventario();
					//entity.setMapDetalleMovimientoInventario(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetalleMovimientoInventarioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleMovimientoInventario().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleMovimientoInventarioDataAccess.ISWITHSCHEMA);         		
					entity=DetalleMovimientoInventarioDataAccess.getEntityDetalleMovimientoInventario("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleMovimientoInventarioOriginal( new DetalleMovimientoInventario());
					////entity.setDetalleMovimientoInventarioOriginal(super.getEntity("",entity.getDetalleMovimientoInventarioOriginal(),resultSet,DetalleMovimientoInventarioDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleMovimientoInventarioOriginal(this.getEntityDetalleMovimientoInventario("",entity.getDetalleMovimientoInventarioOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetalleMovimientoInventario(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleMovimientoInventario(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetalleMovimientoInventario getEntityDetalleMovimientoInventario(String strPrefijo,DetalleMovimientoInventario entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetalleMovimientoInventario.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetalleMovimientoInventario.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetalleMovimientoInventarioDataAccess.setFieldReflectionDetalleMovimientoInventario(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetalleMovimientoInventario=DetalleMovimientoInventarioConstantesFunciones.getTodosTiposColumnasDetalleMovimientoInventario();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetalleMovimientoInventario) {
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
							field = DetalleMovimientoInventario.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetalleMovimientoInventario.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetalleMovimientoInventarioDataAccess.setFieldReflectionDetalleMovimientoInventario(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetalleMovimientoInventario(Field field,String strPrefijo,String sColumn,DetalleMovimientoInventario entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetalleMovimientoInventarioConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMovimientoInventarioConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleMovimientoInventarioConstantesFunciones.IDMOVIMIENTOINVENTARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMovimientoInventarioConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMovimientoInventarioConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMovimientoInventarioConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMovimientoInventarioConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMovimientoInventarioConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMovimientoInventarioConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMovimientoInventarioConstantesFunciones.IDESTADODETALLEMOVIMIENTOINVENTARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMovimientoInventarioConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMovimientoInventarioConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMovimientoInventarioConstantesFunciones.IDUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMovimientoInventarioConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleMovimientoInventarioConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetalleMovimientoInventarioConstantesFunciones.DESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleMovimientoInventarioConstantesFunciones.COSTOUNITARIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleMovimientoInventarioConstantesFunciones.COSTOTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleMovimientoInventarioConstantesFunciones.DISPONIBLE:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetalleMovimientoInventarioConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleMovimientoInventarioConstantesFunciones.IVAVALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleMovimientoInventarioConstantesFunciones.COSTOIVA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DetalleMovimientoInventarioConstantesFunciones.ICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleMovimientoInventarioConstantesFunciones.ICEVALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleMovimientoInventarioConstantesFunciones.DESCUENTO1:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleMovimientoInventarioConstantesFunciones.DESCUENTO2:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleMovimientoInventarioConstantesFunciones.SERIE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleMovimientoInventarioConstantesFunciones.LOTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleMovimientoInventarioConstantesFunciones.FECHAELABORACIONLOTE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DetalleMovimientoInventarioConstantesFunciones.FECHACADUCIDADLOTE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DetalleMovimientoInventarioConstantesFunciones.IDNOVEDADPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMovimientoInventarioConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMovimientoInventarioConstantesFunciones.IDCUENTACONTABLECOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMovimientoInventarioConstantesFunciones.IDTIPODETALLEMOVIMIENTOINVENTARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMovimientoInventarioConstantesFunciones.NUMEROCOMPROBANTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleMovimientoInventarioConstantesFunciones.LOTECLIENTE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleMovimientoInventario>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetalleMovimientoInventario> entities = new  ArrayList<DetalleMovimientoInventario>();
		DetalleMovimientoInventario entity = new DetalleMovimientoInventario();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleMovimientoInventarioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleMovimientoInventarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleMovimientoInventarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetalleMovimientoInventario();
					entity=super.getEntity("",entity,resultSet,DetalleMovimientoInventarioDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetalleMovimientoInventario("",entity,resultSet);
					
					//entity.setDetalleMovimientoInventarioOriginal( new DetalleMovimientoInventario());
					//entity.setDetalleMovimientoInventarioOriginal(super.getEntity("",entity.getDetalleMovimientoInventarioOriginal(),resultSet,DetalleMovimientoInventarioDataAccess.ISWITHSCHEMA));         		
					//entity.setDetalleMovimientoInventarioOriginal(this.getEntityDetalleMovimientoInventario("",entity.getDetalleMovimientoInventarioOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetalleMovimientoInventarios(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleMovimientoInventario(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleMovimientoInventario>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetalleMovimientoInventario> entities = new  ArrayList<DetalleMovimientoInventario>();
		DetalleMovimientoInventario entity = new DetalleMovimientoInventario();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleMovimientoInventarioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleMovimientoInventarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleMovimientoInventarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetalleMovimientoInventario> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleMovimientoInventario> entities = new  ArrayList<DetalleMovimientoInventario>();
		DetalleMovimientoInventario entity = new DetalleMovimientoInventario();		  
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
	
	public  List<DetalleMovimientoInventario> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleMovimientoInventario> entities = new  ArrayList<DetalleMovimientoInventario>();
		DetalleMovimientoInventario entity = new DetalleMovimientoInventario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleMovimientoInventario();
      	    	entity=super.getEntity("",entity,resultSet,DetalleMovimientoInventarioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleMovimientoInventario("",entity,resultSet);
      	    	
				//entity.setDetalleMovimientoInventarioOriginal( new DetalleMovimientoInventario());
      	    	//entity.setDetalleMovimientoInventarioOriginal(super.getEntity("",entity.getDetalleMovimientoInventarioOriginal(),resultSet,DetalleMovimientoInventarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleMovimientoInventarioOriginal(this.getEntityDetalleMovimientoInventario("",entity.getDetalleMovimientoInventarioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetalleMovimientoInventarios(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleMovimientoInventario(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleMovimientoInventario> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleMovimientoInventario> entities = new  ArrayList<DetalleMovimientoInventario>();
		DetalleMovimientoInventario entity = new DetalleMovimientoInventario();		  
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
	
	public  List<DetalleMovimientoInventario> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleMovimientoInventario> entities = new  ArrayList<DetalleMovimientoInventario>();
		DetalleMovimientoInventario entity = new DetalleMovimientoInventario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleMovimientoInventario();
      	    	entity=super.getEntity("",entity,resultSet,DetalleMovimientoInventarioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleMovimientoInventario("",entity,resultSet);
      	    	
				//entity.setDetalleMovimientoInventarioOriginal( new DetalleMovimientoInventario());
      	    	//entity.setDetalleMovimientoInventarioOriginal(super.getEntity("",entity.getDetalleMovimientoInventarioOriginal(),resultSet,DetalleMovimientoInventarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleMovimientoInventarioOriginal(this.getEntityDetalleMovimientoInventario("",entity.getDetalleMovimientoInventarioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleMovimientoInventarios(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetalleMovimientoInventario getEntityDetalleMovimientoInventario(String strPrefijo,DetalleMovimientoInventario entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_movimiento_inventario(resultSet.getLong(strPrefijo+DetalleMovimientoInventarioConstantesFunciones.IDMOVIMIENTOINVENTARIO));
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetalleMovimientoInventarioConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DetalleMovimientoInventarioConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+DetalleMovimientoInventarioConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+DetalleMovimientoInventarioConstantesFunciones.IDPERIODO));
				entity.setid_anio(resultSet.getLong(strPrefijo+DetalleMovimientoInventarioConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+DetalleMovimientoInventarioConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setid_estado_detalle_movimiento_inventario(resultSet.getLong(strPrefijo+DetalleMovimientoInventarioConstantesFunciones.IDESTADODETALLEMOVIMIENTOINVENTARIO));
				entity.setid_bodega(resultSet.getLong(strPrefijo+DetalleMovimientoInventarioConstantesFunciones.IDBODEGA));
				entity.setid_producto(resultSet.getLong(strPrefijo+DetalleMovimientoInventarioConstantesFunciones.IDPRODUCTO));
				entity.setid_unidad(resultSet.getLong(strPrefijo+DetalleMovimientoInventarioConstantesFunciones.IDUNIDAD));
				entity.setdescripcion(resultSet.getString(strPrefijo+DetalleMovimientoInventarioConstantesFunciones.DESCRIPCION));
				entity.setcantidad(resultSet.getInt(strPrefijo+DetalleMovimientoInventarioConstantesFunciones.CANTIDAD));
				entity.setdescuento(resultSet.getDouble(strPrefijo+DetalleMovimientoInventarioConstantesFunciones.DESCUENTO));
				entity.setcosto_unitario(resultSet.getDouble(strPrefijo+DetalleMovimientoInventarioConstantesFunciones.COSTOUNITARIO));
				entity.setcosto_total(resultSet.getDouble(strPrefijo+DetalleMovimientoInventarioConstantesFunciones.COSTOTOTAL));
				entity.setdisponible(resultSet.getInt(strPrefijo+DetalleMovimientoInventarioConstantesFunciones.DISPONIBLE));
				entity.setiva(resultSet.getDouble(strPrefijo+DetalleMovimientoInventarioConstantesFunciones.IVA));
				entity.setiva_valor(resultSet.getDouble(strPrefijo+DetalleMovimientoInventarioConstantesFunciones.IVAVALOR));
				entity.setcosto_iva(resultSet.getBoolean(strPrefijo+DetalleMovimientoInventarioConstantesFunciones.COSTOIVA));
				entity.setice(resultSet.getDouble(strPrefijo+DetalleMovimientoInventarioConstantesFunciones.ICE));
				entity.setice_valor(resultSet.getDouble(strPrefijo+DetalleMovimientoInventarioConstantesFunciones.ICEVALOR));
				entity.setdescuento1(resultSet.getDouble(strPrefijo+DetalleMovimientoInventarioConstantesFunciones.DESCUENTO1));
				entity.setdescuento2(resultSet.getDouble(strPrefijo+DetalleMovimientoInventarioConstantesFunciones.DESCUENTO2));
				entity.setserie(resultSet.getString(strPrefijo+DetalleMovimientoInventarioConstantesFunciones.SERIE));
				entity.setlote(resultSet.getString(strPrefijo+DetalleMovimientoInventarioConstantesFunciones.LOTE));
				entity.setfecha_elaboracion_lote(new Date(resultSet.getDate(strPrefijo+DetalleMovimientoInventarioConstantesFunciones.FECHAELABORACIONLOTE).getTime()));
				entity.setfecha_caducidad_lote(new Date(resultSet.getDate(strPrefijo+DetalleMovimientoInventarioConstantesFunciones.FECHACADUCIDADLOTE).getTime()));
				entity.setid_novedad_producto(resultSet.getLong(strPrefijo+DetalleMovimientoInventarioConstantesFunciones.IDNOVEDADPRODUCTO));if(resultSet.wasNull()) {entity.setid_novedad_producto(null); }
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+DetalleMovimientoInventarioConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setid_cuenta_contable_costo(resultSet.getLong(strPrefijo+DetalleMovimientoInventarioConstantesFunciones.IDCUENTACONTABLECOSTO));if(resultSet.wasNull()) {entity.setid_cuenta_contable_costo(null); }
				entity.setid_tipo_detalle_movimiento_inventario(resultSet.getLong(strPrefijo+DetalleMovimientoInventarioConstantesFunciones.IDTIPODETALLEMOVIMIENTOINVENTARIO));if(resultSet.wasNull()) {entity.setid_tipo_detalle_movimiento_inventario(null); }
				entity.setnumero_comprobante(resultSet.getString(strPrefijo+DetalleMovimientoInventarioConstantesFunciones.NUMEROCOMPROBANTE));
				entity.setlote_cliente(resultSet.getString(strPrefijo+DetalleMovimientoInventarioConstantesFunciones.LOTECLIENTE));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetalleMovimientoInventario(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetalleMovimientoInventario entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetalleMovimientoInventarioDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetalleMovimientoInventarioDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetalleMovimientoInventarioDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetalleMovimientoInventarioDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetalleMovimientoInventarioConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetalleMovimientoInventarioDataAccess.TABLENAME,DetalleMovimientoInventarioDataAccess.ISWITHSTOREPROCEDURES);
			
			DetalleMovimientoInventarioDataAccess.setDetalleMovimientoInventarioOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public MovimientoInventario getMovimientoInventario(Connexion connexion,DetalleMovimientoInventario reldetallemovimientoinventario)throws SQLException,Exception {

		MovimientoInventario movimientoinventario= new MovimientoInventario();

		try {
			MovimientoInventarioDataAccess movimientoinventarioDataAccess=new MovimientoInventarioDataAccess();

			movimientoinventarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			movimientoinventarioDataAccess.setConnexionType(this.connexionType);
			movimientoinventarioDataAccess.setParameterDbType(this.parameterDbType);

			movimientoinventario=movimientoinventarioDataAccess.getEntity(connexion,reldetallemovimientoinventario.getid_movimiento_inventario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return movimientoinventario;

	}

	public Empresa getEmpresa(Connexion connexion,DetalleMovimientoInventario reldetallemovimientoinventario)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetallemovimientoinventario.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DetalleMovimientoInventario reldetallemovimientoinventario)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetallemovimientoinventario.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,DetalleMovimientoInventario reldetallemovimientoinventario)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,reldetallemovimientoinventario.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,DetalleMovimientoInventario reldetallemovimientoinventario)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,reldetallemovimientoinventario.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Anio getAnio(Connexion connexion,DetalleMovimientoInventario reldetallemovimientoinventario)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,reldetallemovimientoinventario.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,DetalleMovimientoInventario reldetallemovimientoinventario)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,reldetallemovimientoinventario.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public EstadoDetalleMovimientoInventario getEstadoDetalleMovimientoInventario(Connexion connexion,DetalleMovimientoInventario reldetallemovimientoinventario)throws SQLException,Exception {

		EstadoDetalleMovimientoInventario estadodetallemovimientoinventario= new EstadoDetalleMovimientoInventario();

		try {
			EstadoDetalleMovimientoInventarioDataAccess estadodetallemovimientoinventarioDataAccess=new EstadoDetalleMovimientoInventarioDataAccess();

			estadodetallemovimientoinventarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadodetallemovimientoinventarioDataAccess.setConnexionType(this.connexionType);
			estadodetallemovimientoinventarioDataAccess.setParameterDbType(this.parameterDbType);

			estadodetallemovimientoinventario=estadodetallemovimientoinventarioDataAccess.getEntity(connexion,reldetallemovimientoinventario.getid_estado_detalle_movimiento_inventario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadodetallemovimientoinventario;

	}

	public Bodega getBodega(Connexion connexion,DetalleMovimientoInventario reldetallemovimientoinventario)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,reldetallemovimientoinventario.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,DetalleMovimientoInventario reldetallemovimientoinventario)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);

			producto=productoDataAccess.getEntity(connexion,reldetallemovimientoinventario.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Unidad getUnidad(Connexion connexion,DetalleMovimientoInventario reldetallemovimientoinventario)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,reldetallemovimientoinventario.getid_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}

	public NovedadProducto getNovedadProducto(Connexion connexion,DetalleMovimientoInventario reldetallemovimientoinventario)throws SQLException,Exception {

		NovedadProducto novedadproducto= new NovedadProducto();

		try {
			NovedadProductoDataAccess novedadproductoDataAccess=new NovedadProductoDataAccess();

			novedadproductoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			novedadproductoDataAccess.setConnexionType(this.connexionType);
			novedadproductoDataAccess.setParameterDbType(this.parameterDbType);

			novedadproducto=novedadproductoDataAccess.getEntity(connexion,reldetallemovimientoinventario.getid_novedad_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return novedadproducto;

	}

	public CentroCosto getCentroCosto(Connexion connexion,DetalleMovimientoInventario reldetallemovimientoinventario)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,reldetallemovimientoinventario.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}

	public CuentaContable getCuentaContableCosto(Connexion connexion,DetalleMovimientoInventario reldetallemovimientoinventario)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,reldetallemovimientoinventario.getid_cuenta_contable_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public TipoDetalleMovimientoInventario getTipoDetalleMovimientoInventario(Connexion connexion,DetalleMovimientoInventario reldetallemovimientoinventario)throws SQLException,Exception {

		TipoDetalleMovimientoInventario tipodetallemovimientoinventario= new TipoDetalleMovimientoInventario();

		try {
			TipoDetalleMovimientoInventarioDataAccess tipodetallemovimientoinventarioDataAccess=new TipoDetalleMovimientoInventarioDataAccess();

			tipodetallemovimientoinventarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipodetallemovimientoinventarioDataAccess.setConnexionType(this.connexionType);
			tipodetallemovimientoinventarioDataAccess.setParameterDbType(this.parameterDbType);

			tipodetallemovimientoinventario=tipodetallemovimientoinventarioDataAccess.getEntity(connexion,reldetallemovimientoinventario.getid_tipo_detalle_movimiento_inventario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipodetallemovimientoinventario;

	}


		
		public List<NovedadSeguimiento> getNovedadSeguimientos(Connexion connexion,DetalleMovimientoInventario detallemovimientoinventario)throws SQLException,Exception {

		List<NovedadSeguimiento> novedadseguimientos= new ArrayList<NovedadSeguimiento>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+".detalle_movimiento_inventario ON "+NovedadSeguimientoConstantesFunciones.SCHEMA+".novedad_seguimiento.id_detalle_movimiento_inventario="+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+".detalle_movimiento_inventario.id WHERE "+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+".detalle_movimiento_inventario.id="+String.valueOf(detallemovimientoinventario.getId());
			} else {
				sQuery=" INNER JOIN novedadseguimiento.DetalleMovimientoInventario WHERE novedadseguimiento.DetalleMovimientoInventario.id="+String.valueOf(detallemovimientoinventario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			NovedadSeguimientoDataAccess novedadseguimientoDataAccess=new NovedadSeguimientoDataAccess();

			novedadseguimientoDataAccess.setConnexionType(this.connexionType);
			novedadseguimientoDataAccess.setParameterDbType(this.parameterDbType);
			novedadseguimientos=novedadseguimientoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return novedadseguimientos;

	}

	public List<Costo> getCostos(Connexion connexion,DetalleMovimientoInventario detallemovimientoinventario)throws SQLException,Exception {

		List<Costo> costos= new ArrayList<Costo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+".detalle_movimiento_inventario ON "+CostoConstantesFunciones.SCHEMA+".costo.id_detalle_movimiento_inventario="+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+".detalle_movimiento_inventario.id WHERE "+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+".detalle_movimiento_inventario.id="+String.valueOf(detallemovimientoinventario.getId());
			} else {
				sQuery=" INNER JOIN costo.DetalleMovimientoInventario WHERE costo.DetalleMovimientoInventario.id="+String.valueOf(detallemovimientoinventario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CostoDataAccess costoDataAccess=new CostoDataAccess();

			costoDataAccess.setConnexionType(this.connexionType);
			costoDataAccess.setParameterDbType(this.parameterDbType);
			costos=costoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return costos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetalleMovimientoInventario detallemovimientoinventario) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detallemovimientoinventario.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_movimiento_inventario=new ParameterValue<Long>();
					parameterMaintenanceValueid_movimiento_inventario.setValue(detallemovimientoinventario.getid_movimiento_inventario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_movimiento_inventario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detallemovimientoinventario.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(detallemovimientoinventario.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(detallemovimientoinventario.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(detallemovimientoinventario.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(detallemovimientoinventario.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(detallemovimientoinventario.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_detalle_movimiento_inventario=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_detalle_movimiento_inventario.setValue(detallemovimientoinventario.getid_estado_detalle_movimiento_inventario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_detalle_movimiento_inventario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(detallemovimientoinventario.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto.setValue(detallemovimientoinventario.getid_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad.setValue(detallemovimientoinventario.getid_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(detallemovimientoinventario.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad.setValue(detallemovimientoinventario.getcantidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento.setValue(detallemovimientoinventario.getdescuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_unitario=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_unitario.setValue(detallemovimientoinventario.getcosto_unitario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_unitario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_total=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_total.setValue(detallemovimientoinventario.getcosto_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuedisponible=new ParameterValue<Integer>();
					parameterMaintenanceValuedisponible.setValue(detallemovimientoinventario.getdisponible());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedisponible);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva=new ParameterValue<Double>();
					parameterMaintenanceValueiva.setValue(detallemovimientoinventario.getiva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva_valor=new ParameterValue<Double>();
					parameterMaintenanceValueiva_valor.setValue(detallemovimientoinventario.getiva_valor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva_valor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecosto_iva=new ParameterValue<Boolean>();
					parameterMaintenanceValuecosto_iva.setValue(detallemovimientoinventario.getcosto_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueice=new ParameterValue<Double>();
					parameterMaintenanceValueice.setValue(detallemovimientoinventario.getice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueice_valor=new ParameterValue<Double>();
					parameterMaintenanceValueice_valor.setValue(detallemovimientoinventario.getice_valor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueice_valor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento1=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento1.setValue(detallemovimientoinventario.getdescuento1());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento1);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento2=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento2.setValue(detallemovimientoinventario.getdescuento2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueserie=new ParameterValue<String>();
					parameterMaintenanceValueserie.setValue(detallemovimientoinventario.getserie());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueserie);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuelote=new ParameterValue<String>();
					parameterMaintenanceValuelote.setValue(detallemovimientoinventario.getlote());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuelote);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_elaboracion_lote=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_elaboracion_lote.setValue(detallemovimientoinventario.getfecha_elaboracion_lote());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_elaboracion_lote);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_caducidad_lote=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_caducidad_lote.setValue(detallemovimientoinventario.getfecha_caducidad_lote());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_caducidad_lote);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_novedad_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_novedad_producto.setValue(detallemovimientoinventario.getid_novedad_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_novedad_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(detallemovimientoinventario.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_costo.setValue(detallemovimientoinventario.getid_cuenta_contable_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_detalle_movimiento_inventario=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_detalle_movimiento_inventario.setValue(detallemovimientoinventario.getid_tipo_detalle_movimiento_inventario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_detalle_movimiento_inventario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_comprobante=new ParameterValue<String>();
					parameterMaintenanceValuenumero_comprobante.setValue(detallemovimientoinventario.getnumero_comprobante());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_comprobante);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuelote_cliente=new ParameterValue<String>();
					parameterMaintenanceValuelote_cliente.setValue(detallemovimientoinventario.getlote_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuelote_cliente);
					parametersTemp.add(parameterMaintenance);
					
						if(!detallemovimientoinventario.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detallemovimientoinventario.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detallemovimientoinventario.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detallemovimientoinventario.getId());
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
	
	public void setIsNewIsChangedFalseDetalleMovimientoInventario(DetalleMovimientoInventario detallemovimientoinventario)throws Exception  {		
		detallemovimientoinventario.setIsNew(false);
		detallemovimientoinventario.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetalleMovimientoInventarios(List<DetalleMovimientoInventario> detallemovimientoinventarios)throws Exception  {				
		for(DetalleMovimientoInventario detallemovimientoinventario:detallemovimientoinventarios) {
			detallemovimientoinventario.setIsNew(false);
			detallemovimientoinventario.setIsChanged(false);
		}
	}
	
	public void generarExportarDetalleMovimientoInventario(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
