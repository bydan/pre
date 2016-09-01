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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.util.*;//DetalleFacturaProveedorConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class DetalleFacturaProveedorDataAccess extends  DetalleFacturaProveedorDataAccessAdditional{ //DetalleFacturaProveedorDataAccessAdditional,DataAccessHelper<DetalleFacturaProveedor>
	//static Logger logger = Logger.getLogger(DetalleFacturaProveedorDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_factura_proveedor";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+"(version_row,id_factura_proveedor,id_empresa,id_sucursal,id_bodega,id_producto,id_unidad,id_ejercicio,id_periodo,numero_comprobante,cantidad,cantidad_auxiliar,descuento,iva,lote,fecha_elaboracion_lote,fecha_caducidad_lote,costo_iva,costo_unitario,costo_total,ice,descuento1,descuento2,descripcion,precio_venta,id_novedad_producto,id_centro_costo,id_cuenta_contable_costo,id_bodega_enviar,lote_cliente,disponible,serie,ice_valor,id_anio,id_mes)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_factura_proveedor=?,id_empresa=?,id_sucursal=?,id_bodega=?,id_producto=?,id_unidad=?,id_ejercicio=?,id_periodo=?,numero_comprobante=?,cantidad=?,cantidad_auxiliar=?,descuento=?,iva=?,lote=?,fecha_elaboracion_lote=?,fecha_caducidad_lote=?,costo_iva=?,costo_unitario=?,costo_total=?,ice=?,descuento1=?,descuento2=?,descripcion=?,precio_venta=?,id_novedad_producto=?,id_centro_costo=?,id_cuenta_contable_costo=?,id_bodega_enviar=?,lote_cliente=?,disponible=?,serie=?,ice_valor=?,id_anio=?,id_mes=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detallefacturaproveedor from "+DetalleFacturaProveedorConstantesFunciones.SPERSISTENCENAME+" detallefacturaproveedor";
	public static String QUERYSELECTNATIVE="select "+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".id,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".version_row,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".id_factura_proveedor,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".id_empresa,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".id_bodega,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".id_producto,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".id_unidad,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".id_periodo,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".numero_comprobante,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".cantidad,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".cantidad_auxiliar,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".descuento,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".iva,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".lote,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".fecha_elaboracion_lote,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".fecha_caducidad_lote,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".costo_iva,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".costo_unitario,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".costo_total,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".ice,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".descuento1,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".descuento2,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".descripcion,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".precio_venta,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".id_novedad_producto,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".id_centro_costo,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".id_cuenta_contable_costo,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".id_bodega_enviar,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".lote_cliente,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".disponible,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".serie,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".ice_valor,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".id_anio,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".id_mes from "+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME;//+" as "+DetalleFacturaProveedorConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".id,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".version_row from "+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME;//+" as "+DetalleFacturaProveedorConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_factura_proveedor=?,id_empresa=?,id_sucursal=?,id_bodega=?,id_producto=?,id_unidad=?,id_ejercicio=?,id_periodo=?,numero_comprobante=?,cantidad=?,cantidad_auxiliar=?,descuento=?,iva=?,lote=?,fecha_elaboracion_lote=?,fecha_caducidad_lote=?,costo_iva=?,costo_unitario=?,costo_total=?,ice=?,descuento1=?,descuento2=?,descripcion=?,precio_venta=?,id_novedad_producto=?,id_centro_costo=?,id_cuenta_contable_costo=?,id_bodega_enviar=?,lote_cliente=?,disponible=?,serie=?,ice_valor=?,id_anio=?,id_mes=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLEFACTURAPROVEEDOR_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLEFACTURAPROVEEDOR_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLEFACTURAPROVEEDOR_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLEFACTURAPROVEEDOR_SELECT(?,?)";
	
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
	
	
	protected DetalleFacturaProveedorDataAccessAdditional detallefacturaproveedorDataAccessAdditional=null;
	
	public DetalleFacturaProveedorDataAccessAdditional getDetalleFacturaProveedorDataAccessAdditional() {
		return this.detallefacturaproveedorDataAccessAdditional;
	}
	
	public void setDetalleFacturaProveedorDataAccessAdditional(DetalleFacturaProveedorDataAccessAdditional detallefacturaproveedorDataAccessAdditional) {
		try {
			this.detallefacturaproveedorDataAccessAdditional=detallefacturaproveedorDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetalleFacturaProveedorDataAccess() {
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
		DetalleFacturaProveedorDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetalleFacturaProveedorDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetalleFacturaProveedorDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetalleFacturaProveedorOriginal(DetalleFacturaProveedor detallefacturaproveedor)throws Exception  {
		detallefacturaproveedor.setDetalleFacturaProveedorOriginal((DetalleFacturaProveedor)detallefacturaproveedor.clone());		
	}
	
	public void setDetalleFacturaProveedorsOriginal(List<DetalleFacturaProveedor> detallefacturaproveedors)throws Exception  {
		
		for(DetalleFacturaProveedor detallefacturaproveedor:detallefacturaproveedors){
			detallefacturaproveedor.setDetalleFacturaProveedorOriginal((DetalleFacturaProveedor)detallefacturaproveedor.clone());
		}
	}
	
	public static void setDetalleFacturaProveedorOriginalStatic(DetalleFacturaProveedor detallefacturaproveedor)throws Exception  {
		detallefacturaproveedor.setDetalleFacturaProveedorOriginal((DetalleFacturaProveedor)detallefacturaproveedor.clone());		
	}
	
	public static void setDetalleFacturaProveedorsOriginalStatic(List<DetalleFacturaProveedor> detallefacturaproveedors)throws Exception  {
		
		for(DetalleFacturaProveedor detallefacturaproveedor:detallefacturaproveedors){
			detallefacturaproveedor.setDetalleFacturaProveedorOriginal((DetalleFacturaProveedor)detallefacturaproveedor.clone());
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
	
	public  DetalleFacturaProveedor getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleFacturaProveedor entity = new DetalleFacturaProveedor();		
		
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
	
	public  DetalleFacturaProveedor getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleFacturaProveedor entity = new DetalleFacturaProveedor();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleFacturaProveedorDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleFacturaProveedorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.DetalleFacturaProveedor.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetalleFacturaProveedorOriginal(new DetalleFacturaProveedor());
      	    	entity=super.getEntity("",entity,resultSet,DetalleFacturaProveedorDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleFacturaProveedor("",entity,resultSet); 
				
				//entity.setDetalleFacturaProveedorOriginal(super.getEntity("",entity.getDetalleFacturaProveedorOriginal(),resultSet,DetalleFacturaProveedorDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleFacturaProveedorOriginal(this.getEntityDetalleFacturaProveedor("",entity.getDetalleFacturaProveedorOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleFacturaProveedor(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetalleFacturaProveedor getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleFacturaProveedor entity = new DetalleFacturaProveedor();
				
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
	
	public  DetalleFacturaProveedor getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleFacturaProveedor entity = new DetalleFacturaProveedor();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleFacturaProveedorDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleFacturaProveedorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleFacturaProveedorDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.DetalleFacturaProveedor.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetalleFacturaProveedorOriginal(new DetalleFacturaProveedor());
      	    	entity=super.getEntity("",entity,resultSet,DetalleFacturaProveedorDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleFacturaProveedor("",entity,resultSet);    
				
				//entity.setDetalleFacturaProveedorOriginal(super.getEntity("",entity.getDetalleFacturaProveedorOriginal(),resultSet,DetalleFacturaProveedorDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleFacturaProveedorOriginal(this.getEntityDetalleFacturaProveedor("",entity.getDetalleFacturaProveedorOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleFacturaProveedor(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetalleFacturaProveedor
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetalleFacturaProveedor entity = new DetalleFacturaProveedor();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleFacturaProveedorDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleFacturaProveedorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleFacturaProveedorDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.DetalleFacturaProveedor.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetalleFacturaProveedor(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetalleFacturaProveedor> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleFacturaProveedor> entities = new  ArrayList<DetalleFacturaProveedor>();
		DetalleFacturaProveedor entity = new DetalleFacturaProveedor();		  
		
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
	
	public  List<DetalleFacturaProveedor> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleFacturaProveedor> entities = new  ArrayList<DetalleFacturaProveedor>();
		DetalleFacturaProveedor entity = new DetalleFacturaProveedor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleFacturaProveedorDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleFacturaProveedorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleFacturaProveedorDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleFacturaProveedor();
      	    	entity=super.getEntity("",entity,resultSet,DetalleFacturaProveedorDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleFacturaProveedor("",entity,resultSet);
      	    	
				//entity.setDetalleFacturaProveedorOriginal( new DetalleFacturaProveedor());
      	    	//entity.setDetalleFacturaProveedorOriginal(super.getEntity("",entity.getDetalleFacturaProveedorOriginal(),resultSet,DetalleFacturaProveedorDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleFacturaProveedorOriginal(this.getEntityDetalleFacturaProveedor("",entity.getDetalleFacturaProveedorOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleFacturaProveedors(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleFacturaProveedor(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleFacturaProveedor> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleFacturaProveedor> entities = new  ArrayList<DetalleFacturaProveedor>();
		DetalleFacturaProveedor entity = new DetalleFacturaProveedor();		  
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
	
	public  List<DetalleFacturaProveedor> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleFacturaProveedor> entities = new  ArrayList<DetalleFacturaProveedor>();
		DetalleFacturaProveedor entity = new DetalleFacturaProveedor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleFacturaProveedor();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleFacturaProveedor();
					//entity.setMapDetalleFacturaProveedor(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetalleFacturaProveedorValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleFacturaProveedor().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleFacturaProveedorDataAccess.ISWITHSCHEMA);         		
					entity=DetalleFacturaProveedorDataAccess.getEntityDetalleFacturaProveedor("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleFacturaProveedorOriginal( new DetalleFacturaProveedor());
					////entity.setDetalleFacturaProveedorOriginal(super.getEntity("",entity.getDetalleFacturaProveedorOriginal(),resultSet,DetalleFacturaProveedorDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleFacturaProveedorOriginal(this.getEntityDetalleFacturaProveedor("",entity.getDetalleFacturaProveedorOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleFacturaProveedors(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleFacturaProveedor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetalleFacturaProveedor getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleFacturaProveedor entity = new DetalleFacturaProveedor();		  
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
	
	public  DetalleFacturaProveedor getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleFacturaProveedor entity = new DetalleFacturaProveedor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleFacturaProveedor();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleFacturaProveedor();
					//entity.setMapDetalleFacturaProveedor(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetalleFacturaProveedorValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleFacturaProveedor().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleFacturaProveedorDataAccess.ISWITHSCHEMA);         		
					entity=DetalleFacturaProveedorDataAccess.getEntityDetalleFacturaProveedor("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleFacturaProveedorOriginal( new DetalleFacturaProveedor());
					////entity.setDetalleFacturaProveedorOriginal(super.getEntity("",entity.getDetalleFacturaProveedorOriginal(),resultSet,DetalleFacturaProveedorDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleFacturaProveedorOriginal(this.getEntityDetalleFacturaProveedor("",entity.getDetalleFacturaProveedorOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetalleFacturaProveedor(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleFacturaProveedor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetalleFacturaProveedor getEntityDetalleFacturaProveedor(String strPrefijo,DetalleFacturaProveedor entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetalleFacturaProveedor.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetalleFacturaProveedor.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetalleFacturaProveedorDataAccess.setFieldReflectionDetalleFacturaProveedor(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetalleFacturaProveedor=DetalleFacturaProveedorConstantesFunciones.getTodosTiposColumnasDetalleFacturaProveedor();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetalleFacturaProveedor) {
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
							field = DetalleFacturaProveedor.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetalleFacturaProveedor.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetalleFacturaProveedorDataAccess.setFieldReflectionDetalleFacturaProveedor(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetalleFacturaProveedor(Field field,String strPrefijo,String sColumn,DetalleFacturaProveedor entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetalleFacturaProveedorConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleFacturaProveedorConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleFacturaProveedorConstantesFunciones.IDFACTURAPROVEEDOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleFacturaProveedorConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleFacturaProveedorConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleFacturaProveedorConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleFacturaProveedorConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleFacturaProveedorConstantesFunciones.IDUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleFacturaProveedorConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleFacturaProveedorConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleFacturaProveedorConstantesFunciones.NUMEROCOMPROBANTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleFacturaProveedorConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetalleFacturaProveedorConstantesFunciones.CANTIDADAUXILIAR:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetalleFacturaProveedorConstantesFunciones.DESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFacturaProveedorConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFacturaProveedorConstantesFunciones.LOTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleFacturaProveedorConstantesFunciones.FECHAELABORACIONLOTE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DetalleFacturaProveedorConstantesFunciones.FECHACADUCIDADLOTE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DetalleFacturaProveedorConstantesFunciones.COSTOIVA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DetalleFacturaProveedorConstantesFunciones.COSTOUNITARIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFacturaProveedorConstantesFunciones.COSTOTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFacturaProveedorConstantesFunciones.ICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFacturaProveedorConstantesFunciones.DESCUENTO1:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFacturaProveedorConstantesFunciones.DESCUENTO2:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFacturaProveedorConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleFacturaProveedorConstantesFunciones.PRECIOVENTA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFacturaProveedorConstantesFunciones.IDNOVEDADPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleFacturaProveedorConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleFacturaProveedorConstantesFunciones.IDCUENTACONTABLECOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleFacturaProveedorConstantesFunciones.IDBODEGAENVIAR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleFacturaProveedorConstantesFunciones.LOTECLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleFacturaProveedorConstantesFunciones.DISPONIBLE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFacturaProveedorConstantesFunciones.SERIE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleFacturaProveedorConstantesFunciones.ICEVALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFacturaProveedorConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleFacturaProveedorConstantesFunciones.IDMES:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleFacturaProveedor>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetalleFacturaProveedor> entities = new  ArrayList<DetalleFacturaProveedor>();
		DetalleFacturaProveedor entity = new DetalleFacturaProveedor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleFacturaProveedorDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleFacturaProveedorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleFacturaProveedorDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetalleFacturaProveedor();
					entity=super.getEntity("",entity,resultSet,DetalleFacturaProveedorDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetalleFacturaProveedor("",entity,resultSet);
					
					//entity.setDetalleFacturaProveedorOriginal( new DetalleFacturaProveedor());
					//entity.setDetalleFacturaProveedorOriginal(super.getEntity("",entity.getDetalleFacturaProveedorOriginal(),resultSet,DetalleFacturaProveedorDataAccess.ISWITHSCHEMA));         		
					//entity.setDetalleFacturaProveedorOriginal(this.getEntityDetalleFacturaProveedor("",entity.getDetalleFacturaProveedorOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetalleFacturaProveedors(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleFacturaProveedor(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleFacturaProveedor>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetalleFacturaProveedor> entities = new  ArrayList<DetalleFacturaProveedor>();
		DetalleFacturaProveedor entity = new DetalleFacturaProveedor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleFacturaProveedorDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleFacturaProveedorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleFacturaProveedorDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetalleFacturaProveedor> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleFacturaProveedor> entities = new  ArrayList<DetalleFacturaProveedor>();
		DetalleFacturaProveedor entity = new DetalleFacturaProveedor();		  
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
	
	public  List<DetalleFacturaProveedor> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleFacturaProveedor> entities = new  ArrayList<DetalleFacturaProveedor>();
		DetalleFacturaProveedor entity = new DetalleFacturaProveedor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleFacturaProveedor();
      	    	entity=super.getEntity("",entity,resultSet,DetalleFacturaProveedorDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleFacturaProveedor("",entity,resultSet);
      	    	
				//entity.setDetalleFacturaProveedorOriginal( new DetalleFacturaProveedor());
      	    	//entity.setDetalleFacturaProveedorOriginal(super.getEntity("",entity.getDetalleFacturaProveedorOriginal(),resultSet,DetalleFacturaProveedorDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleFacturaProveedorOriginal(this.getEntityDetalleFacturaProveedor("",entity.getDetalleFacturaProveedorOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetalleFacturaProveedors(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleFacturaProveedor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleFacturaProveedor> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleFacturaProveedor> entities = new  ArrayList<DetalleFacturaProveedor>();
		DetalleFacturaProveedor entity = new DetalleFacturaProveedor();		  
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
	
	public  List<DetalleFacturaProveedor> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleFacturaProveedor> entities = new  ArrayList<DetalleFacturaProveedor>();
		DetalleFacturaProveedor entity = new DetalleFacturaProveedor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleFacturaProveedor();
      	    	entity=super.getEntity("",entity,resultSet,DetalleFacturaProveedorDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleFacturaProveedor("",entity,resultSet);
      	    	
				//entity.setDetalleFacturaProveedorOriginal( new DetalleFacturaProveedor());
      	    	//entity.setDetalleFacturaProveedorOriginal(super.getEntity("",entity.getDetalleFacturaProveedorOriginal(),resultSet,DetalleFacturaProveedorDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleFacturaProveedorOriginal(this.getEntityDetalleFacturaProveedor("",entity.getDetalleFacturaProveedorOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleFacturaProveedors(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetalleFacturaProveedor getEntityDetalleFacturaProveedor(String strPrefijo,DetalleFacturaProveedor entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_factura_proveedor(resultSet.getLong(strPrefijo+DetalleFacturaProveedorConstantesFunciones.IDFACTURAPROVEEDOR));
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetalleFacturaProveedorConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DetalleFacturaProveedorConstantesFunciones.IDSUCURSAL));
				entity.setid_bodega(resultSet.getLong(strPrefijo+DetalleFacturaProveedorConstantesFunciones.IDBODEGA));
				entity.setid_producto(resultSet.getLong(strPrefijo+DetalleFacturaProveedorConstantesFunciones.IDPRODUCTO));
				entity.setid_unidad(resultSet.getLong(strPrefijo+DetalleFacturaProveedorConstantesFunciones.IDUNIDAD));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+DetalleFacturaProveedorConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+DetalleFacturaProveedorConstantesFunciones.IDPERIODO));
				entity.setnumero_comprobante(resultSet.getString(strPrefijo+DetalleFacturaProveedorConstantesFunciones.NUMEROCOMPROBANTE));
				entity.setcantidad(resultSet.getInt(strPrefijo+DetalleFacturaProveedorConstantesFunciones.CANTIDAD));
				entity.setcantidad_auxiliar(resultSet.getInt(strPrefijo+DetalleFacturaProveedorConstantesFunciones.CANTIDADAUXILIAR));
				entity.setdescuento(resultSet.getDouble(strPrefijo+DetalleFacturaProveedorConstantesFunciones.DESCUENTO));
				entity.setiva(resultSet.getDouble(strPrefijo+DetalleFacturaProveedorConstantesFunciones.IVA));
				entity.setlote(resultSet.getString(strPrefijo+DetalleFacturaProveedorConstantesFunciones.LOTE));
				entity.setfecha_elaboracion_lote(new Date(resultSet.getDate(strPrefijo+DetalleFacturaProveedorConstantesFunciones.FECHAELABORACIONLOTE).getTime()));
				entity.setfecha_caducidad_lote(new Date(resultSet.getDate(strPrefijo+DetalleFacturaProveedorConstantesFunciones.FECHACADUCIDADLOTE).getTime()));
				entity.setcosto_iva(resultSet.getBoolean(strPrefijo+DetalleFacturaProveedorConstantesFunciones.COSTOIVA));
				entity.setcosto_unitario(resultSet.getDouble(strPrefijo+DetalleFacturaProveedorConstantesFunciones.COSTOUNITARIO));
				entity.setcosto_total(resultSet.getDouble(strPrefijo+DetalleFacturaProveedorConstantesFunciones.COSTOTOTAL));
				entity.setice(resultSet.getDouble(strPrefijo+DetalleFacturaProveedorConstantesFunciones.ICE));
				entity.setdescuento1(resultSet.getDouble(strPrefijo+DetalleFacturaProveedorConstantesFunciones.DESCUENTO1));
				entity.setdescuento2(resultSet.getDouble(strPrefijo+DetalleFacturaProveedorConstantesFunciones.DESCUENTO2));
				entity.setdescripcion(resultSet.getString(strPrefijo+DetalleFacturaProveedorConstantesFunciones.DESCRIPCION));
				entity.setprecio_venta(resultSet.getDouble(strPrefijo+DetalleFacturaProveedorConstantesFunciones.PRECIOVENTA));
				entity.setid_novedad_producto(resultSet.getLong(strPrefijo+DetalleFacturaProveedorConstantesFunciones.IDNOVEDADPRODUCTO));
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+DetalleFacturaProveedorConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setid_cuenta_contable_costo(resultSet.getLong(strPrefijo+DetalleFacturaProveedorConstantesFunciones.IDCUENTACONTABLECOSTO));
				entity.setid_bodega_enviar(resultSet.getLong(strPrefijo+DetalleFacturaProveedorConstantesFunciones.IDBODEGAENVIAR));
				entity.setlote_cliente(resultSet.getString(strPrefijo+DetalleFacturaProveedorConstantesFunciones.LOTECLIENTE));
				entity.setdisponible(resultSet.getDouble(strPrefijo+DetalleFacturaProveedorConstantesFunciones.DISPONIBLE));
				entity.setserie(resultSet.getString(strPrefijo+DetalleFacturaProveedorConstantesFunciones.SERIE));
				entity.setice_valor(resultSet.getDouble(strPrefijo+DetalleFacturaProveedorConstantesFunciones.ICEVALOR));
				entity.setid_anio(resultSet.getLong(strPrefijo+DetalleFacturaProveedorConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+DetalleFacturaProveedorConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetalleFacturaProveedor(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetalleFacturaProveedor entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetalleFacturaProveedorDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetalleFacturaProveedorDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetalleFacturaProveedorDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetalleFacturaProveedorDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetalleFacturaProveedorConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetalleFacturaProveedorDataAccess.TABLENAME,DetalleFacturaProveedorDataAccess.ISWITHSTOREPROCEDURES);
			
			DetalleFacturaProveedorDataAccess.setDetalleFacturaProveedorOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public FacturaProveedor getFacturaProveedor(Connexion connexion,DetalleFacturaProveedor reldetallefacturaproveedor)throws SQLException,Exception {

		FacturaProveedor facturaproveedor= new FacturaProveedor();

		try {
			FacturaProveedorDataAccess facturaproveedorDataAccess=new FacturaProveedorDataAccess();

			facturaproveedorDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			facturaproveedorDataAccess.setConnexionType(this.connexionType);
			facturaproveedorDataAccess.setParameterDbType(this.parameterDbType);

			facturaproveedor=facturaproveedorDataAccess.getEntity(connexion,reldetallefacturaproveedor.getid_factura_proveedor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return facturaproveedor;

	}

	public Empresa getEmpresa(Connexion connexion,DetalleFacturaProveedor reldetallefacturaproveedor)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetallefacturaproveedor.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DetalleFacturaProveedor reldetallefacturaproveedor)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetallefacturaproveedor.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Bodega getBodega(Connexion connexion,DetalleFacturaProveedor reldetallefacturaproveedor)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,reldetallefacturaproveedor.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,DetalleFacturaProveedor reldetallefacturaproveedor)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);

			producto=productoDataAccess.getEntity(connexion,reldetallefacturaproveedor.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Unidad getUnidad(Connexion connexion,DetalleFacturaProveedor reldetallefacturaproveedor)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,reldetallefacturaproveedor.getid_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}

	public Ejercicio getEjercicio(Connexion connexion,DetalleFacturaProveedor reldetallefacturaproveedor)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,reldetallefacturaproveedor.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,DetalleFacturaProveedor reldetallefacturaproveedor)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,reldetallefacturaproveedor.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public NovedadProducto getNovedadProducto(Connexion connexion,DetalleFacturaProveedor reldetallefacturaproveedor)throws SQLException,Exception {

		NovedadProducto novedadproducto= new NovedadProducto();

		try {
			NovedadProductoDataAccess novedadproductoDataAccess=new NovedadProductoDataAccess();

			novedadproductoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			novedadproductoDataAccess.setConnexionType(this.connexionType);
			novedadproductoDataAccess.setParameterDbType(this.parameterDbType);

			novedadproducto=novedadproductoDataAccess.getEntity(connexion,reldetallefacturaproveedor.getid_novedad_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return novedadproducto;

	}

	public CentroCosto getCentroCosto(Connexion connexion,DetalleFacturaProveedor reldetallefacturaproveedor)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,reldetallefacturaproveedor.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}

	public CuentaContable getCuentaContableCosto(Connexion connexion,DetalleFacturaProveedor reldetallefacturaproveedor)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,reldetallefacturaproveedor.getid_cuenta_contable_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public Bodega getBodegaEnviar(Connexion connexion,DetalleFacturaProveedor reldetallefacturaproveedor)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,reldetallefacturaproveedor.getid_bodega_enviar());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Anio getAnio(Connexion connexion,DetalleFacturaProveedor reldetallefacturaproveedor)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,reldetallefacturaproveedor.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,DetalleFacturaProveedor reldetallefacturaproveedor)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,reldetallefacturaproveedor.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetalleFacturaProveedor detallefacturaproveedor) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detallefacturaproveedor.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_factura_proveedor=new ParameterValue<Long>();
					parameterMaintenanceValueid_factura_proveedor.setValue(detallefacturaproveedor.getid_factura_proveedor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_factura_proveedor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detallefacturaproveedor.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(detallefacturaproveedor.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(detallefacturaproveedor.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto.setValue(detallefacturaproveedor.getid_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad.setValue(detallefacturaproveedor.getid_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(detallefacturaproveedor.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(detallefacturaproveedor.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_comprobante=new ParameterValue<String>();
					parameterMaintenanceValuenumero_comprobante.setValue(detallefacturaproveedor.getnumero_comprobante());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_comprobante);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad.setValue(detallefacturaproveedor.getcantidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad_auxiliar=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad_auxiliar.setValue(detallefacturaproveedor.getcantidad_auxiliar());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad_auxiliar);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento.setValue(detallefacturaproveedor.getdescuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva=new ParameterValue<Double>();
					parameterMaintenanceValueiva.setValue(detallefacturaproveedor.getiva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuelote=new ParameterValue<String>();
					parameterMaintenanceValuelote.setValue(detallefacturaproveedor.getlote());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuelote);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_elaboracion_lote=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_elaboracion_lote.setValue(detallefacturaproveedor.getfecha_elaboracion_lote());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_elaboracion_lote);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_caducidad_lote=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_caducidad_lote.setValue(detallefacturaproveedor.getfecha_caducidad_lote());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_caducidad_lote);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecosto_iva=new ParameterValue<Boolean>();
					parameterMaintenanceValuecosto_iva.setValue(detallefacturaproveedor.getcosto_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_unitario=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_unitario.setValue(detallefacturaproveedor.getcosto_unitario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_unitario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_total=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_total.setValue(detallefacturaproveedor.getcosto_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueice=new ParameterValue<Double>();
					parameterMaintenanceValueice.setValue(detallefacturaproveedor.getice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento1=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento1.setValue(detallefacturaproveedor.getdescuento1());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento1);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento2=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento2.setValue(detallefacturaproveedor.getdescuento2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(detallefacturaproveedor.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueprecio_venta=new ParameterValue<Double>();
					parameterMaintenanceValueprecio_venta.setValue(detallefacturaproveedor.getprecio_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueprecio_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_novedad_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_novedad_producto.setValue(detallefacturaproveedor.getid_novedad_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_novedad_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(detallefacturaproveedor.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_costo.setValue(detallefacturaproveedor.getid_cuenta_contable_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega_enviar=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega_enviar.setValue(detallefacturaproveedor.getid_bodega_enviar());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega_enviar);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuelote_cliente=new ParameterValue<String>();
					parameterMaintenanceValuelote_cliente.setValue(detallefacturaproveedor.getlote_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuelote_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedisponible=new ParameterValue<Double>();
					parameterMaintenanceValuedisponible.setValue(detallefacturaproveedor.getdisponible());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedisponible);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueserie=new ParameterValue<String>();
					parameterMaintenanceValueserie.setValue(detallefacturaproveedor.getserie());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueserie);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueice_valor=new ParameterValue<Double>();
					parameterMaintenanceValueice_valor.setValue(detallefacturaproveedor.getice_valor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueice_valor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(detallefacturaproveedor.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(detallefacturaproveedor.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
						if(!detallefacturaproveedor.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detallefacturaproveedor.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detallefacturaproveedor.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detallefacturaproveedor.getId());
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
	
	public void setIsNewIsChangedFalseDetalleFacturaProveedor(DetalleFacturaProveedor detallefacturaproveedor)throws Exception  {		
		detallefacturaproveedor.setIsNew(false);
		detallefacturaproveedor.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetalleFacturaProveedors(List<DetalleFacturaProveedor> detallefacturaproveedors)throws Exception  {				
		for(DetalleFacturaProveedor detallefacturaproveedor:detallefacturaproveedors) {
			detallefacturaproveedor.setIsNew(false);
			detallefacturaproveedor.setIsChanged(false);
		}
	}
	
	public void generarExportarDetalleFacturaProveedor(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
