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
import com.bydan.erp.facturacion.util.*;//ParametroFactuPrincipalConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class ParametroFactuPrincipalDataAccess extends  ParametroFactuPrincipalDataAccessAdditional{ //ParametroFactuPrincipalDataAccessAdditional,DataAccessHelper<ParametroFactuPrincipal>
	//static Logger logger = Logger.getLogger(ParametroFactuPrincipalDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="parametro_factu_principal";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_tipo_param_factu_descuento,id_tipo_param_factu_listado_cliente,id_tipo_param_factu_secuencia_trabajo,id_tipo_documento_factura,id_tipo_documento_nota_credito,id_tipo_documento_nota_debito,en_linea,con_cuenta_tipo_cliente,con_cliente_impuesto,id_libro_contable,id_moneda,con_impresion,id_formato,con_secuencial_usuario,con_secuencial_editable,con_precio_por_cliente,con_modificar_precio,con_modificar_servicio,con_cambiar_unidad,numero_decimales_unidad,con_activar_serie,con_activar_lote,con_activar_multi_empresa,con_centro_costos,con_unidades,con_cupo_disponible,con_forma_pago,con_envio_mail,con_autorizar_proforma,con_bloqueo_pedido,con_control_anticipo,con_factura_auto,con_grabar_valor_cero,con_agregar_item,numero_copias,leyenda,con_sin_factura,id_cuenta_contable_flete_venta,id_cuenta_contable_otro_cargo,id_cuenta_contable_finan,id_cuenta_contable_boni,id_cuenta_contable_boni_devol,id_cuenta_contable_ice)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_tipo_param_factu_descuento=?,id_tipo_param_factu_listado_cliente=?,id_tipo_param_factu_secuencia_trabajo=?,id_tipo_documento_factura=?,id_tipo_documento_nota_credito=?,id_tipo_documento_nota_debito=?,en_linea=?,con_cuenta_tipo_cliente=?,con_cliente_impuesto=?,id_libro_contable=?,id_moneda=?,con_impresion=?,id_formato=?,con_secuencial_usuario=?,con_secuencial_editable=?,con_precio_por_cliente=?,con_modificar_precio=?,con_modificar_servicio=?,con_cambiar_unidad=?,numero_decimales_unidad=?,con_activar_serie=?,con_activar_lote=?,con_activar_multi_empresa=?,con_centro_costos=?,con_unidades=?,con_cupo_disponible=?,con_forma_pago=?,con_envio_mail=?,con_autorizar_proforma=?,con_bloqueo_pedido=?,con_control_anticipo=?,con_factura_auto=?,con_grabar_valor_cero=?,con_agregar_item=?,numero_copias=?,leyenda=?,con_sin_factura=?,id_cuenta_contable_flete_venta=?,id_cuenta_contable_otro_cargo=?,id_cuenta_contable_finan=?,id_cuenta_contable_boni=?,id_cuenta_contable_boni_devol=?,id_cuenta_contable_ice=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select parametrofactuprincipal from "+ParametroFactuPrincipalConstantesFunciones.SPERSISTENCENAME+" parametrofactuprincipal";
	public static String QUERYSELECTNATIVE="select "+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".id,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".version_row,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".id_empresa,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".id_sucursal,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".id_tipo_param_factu_descuento,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".id_tipo_param_factu_listado_cliente,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".id_tipo_param_factu_secuencia_trabajo,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".id_tipo_documento_factura,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".id_tipo_documento_nota_credito,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".id_tipo_documento_nota_debito,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".en_linea,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_cuenta_tipo_cliente,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_cliente_impuesto,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".id_libro_contable,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".id_moneda,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_impresion,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".id_formato,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_secuencial_usuario,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_secuencial_editable,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_precio_por_cliente,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_modificar_precio,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_modificar_servicio,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_cambiar_unidad,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".numero_decimales_unidad,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_activar_serie,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_activar_lote,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_activar_multi_empresa,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_centro_costos,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_unidades,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_cupo_disponible,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_forma_pago,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_envio_mail,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_autorizar_proforma,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_bloqueo_pedido,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_control_anticipo,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_factura_auto,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_grabar_valor_cero,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_agregar_item,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".numero_copias,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".leyenda,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".con_sin_factura,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".id_cuenta_contable_flete_venta,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".id_cuenta_contable_otro_cargo,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".id_cuenta_contable_finan,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".id_cuenta_contable_boni,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".id_cuenta_contable_boni_devol,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".id_cuenta_contable_ice from "+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME;//+" as "+ParametroFactuPrincipalConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".id,"+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+".version_row from "+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME;//+" as "+ParametroFactuPrincipalConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ParametroFactuPrincipalConstantesFunciones.SCHEMA+"."+ParametroFactuPrincipalConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_tipo_param_factu_descuento=?,id_tipo_param_factu_listado_cliente=?,id_tipo_param_factu_secuencia_trabajo=?,id_tipo_documento_factura=?,id_tipo_documento_nota_credito=?,id_tipo_documento_nota_debito=?,en_linea=?,con_cuenta_tipo_cliente=?,con_cliente_impuesto=?,id_libro_contable=?,id_moneda=?,con_impresion=?,id_formato=?,con_secuencial_usuario=?,con_secuencial_editable=?,con_precio_por_cliente=?,con_modificar_precio=?,con_modificar_servicio=?,con_cambiar_unidad=?,numero_decimales_unidad=?,con_activar_serie=?,con_activar_lote=?,con_activar_multi_empresa=?,con_centro_costos=?,con_unidades=?,con_cupo_disponible=?,con_forma_pago=?,con_envio_mail=?,con_autorizar_proforma=?,con_bloqueo_pedido=?,con_control_anticipo=?,con_factura_auto=?,con_grabar_valor_cero=?,con_agregar_item=?,numero_copias=?,leyenda=?,con_sin_factura=?,id_cuenta_contable_flete_venta=?,id_cuenta_contable_otro_cargo=?,id_cuenta_contable_finan=?,id_cuenta_contable_boni=?,id_cuenta_contable_boni_devol=?,id_cuenta_contable_ice=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PARAMETROFACTUPRINCIPAL_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PARAMETROFACTUPRINCIPAL_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PARAMETROFACTUPRINCIPAL_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PARAMETROFACTUPRINCIPAL_SELECT(?,?)";
	
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
	
	
	protected ParametroFactuPrincipalDataAccessAdditional parametrofactuprincipalDataAccessAdditional=null;
	
	public ParametroFactuPrincipalDataAccessAdditional getParametroFactuPrincipalDataAccessAdditional() {
		return this.parametrofactuprincipalDataAccessAdditional;
	}
	
	public void setParametroFactuPrincipalDataAccessAdditional(ParametroFactuPrincipalDataAccessAdditional parametrofactuprincipalDataAccessAdditional) {
		try {
			this.parametrofactuprincipalDataAccessAdditional=parametrofactuprincipalDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ParametroFactuPrincipalDataAccess() {
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
		ParametroFactuPrincipalDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ParametroFactuPrincipalDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ParametroFactuPrincipalDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setParametroFactuPrincipalOriginal(ParametroFactuPrincipal parametrofactuprincipal)throws Exception  {
		parametrofactuprincipal.setParametroFactuPrincipalOriginal((ParametroFactuPrincipal)parametrofactuprincipal.clone());		
	}
	
	public void setParametroFactuPrincipalsOriginal(List<ParametroFactuPrincipal> parametrofactuprincipals)throws Exception  {
		
		for(ParametroFactuPrincipal parametrofactuprincipal:parametrofactuprincipals){
			parametrofactuprincipal.setParametroFactuPrincipalOriginal((ParametroFactuPrincipal)parametrofactuprincipal.clone());
		}
	}
	
	public static void setParametroFactuPrincipalOriginalStatic(ParametroFactuPrincipal parametrofactuprincipal)throws Exception  {
		parametrofactuprincipal.setParametroFactuPrincipalOriginal((ParametroFactuPrincipal)parametrofactuprincipal.clone());		
	}
	
	public static void setParametroFactuPrincipalsOriginalStatic(List<ParametroFactuPrincipal> parametrofactuprincipals)throws Exception  {
		
		for(ParametroFactuPrincipal parametrofactuprincipal:parametrofactuprincipals){
			parametrofactuprincipal.setParametroFactuPrincipalOriginal((ParametroFactuPrincipal)parametrofactuprincipal.clone());
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
	
	public  ParametroFactuPrincipal getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroFactuPrincipal entity = new ParametroFactuPrincipal();		
		
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
	
	public  ParametroFactuPrincipal getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroFactuPrincipal entity = new ParametroFactuPrincipal();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroFactuPrincipalDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroFactuPrincipalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.ParametroFactuPrincipal.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setParametroFactuPrincipalOriginal(new ParametroFactuPrincipal());
      	    	entity=super.getEntity("",entity,resultSet,ParametroFactuPrincipalDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroFactuPrincipal("",entity,resultSet); 
				
				//entity.setParametroFactuPrincipalOriginal(super.getEntity("",entity.getParametroFactuPrincipalOriginal(),resultSet,ParametroFactuPrincipalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFactuPrincipalOriginal(this.getEntityParametroFactuPrincipal("",entity.getParametroFactuPrincipalOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroFactuPrincipal(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ParametroFactuPrincipal getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroFactuPrincipal entity = new ParametroFactuPrincipal();
				
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
	
	public  ParametroFactuPrincipal getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroFactuPrincipal entity = new ParametroFactuPrincipal();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroFactuPrincipalDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroFactuPrincipalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFactuPrincipalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.ParametroFactuPrincipal.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setParametroFactuPrincipalOriginal(new ParametroFactuPrincipal());
      	    	entity=super.getEntity("",entity,resultSet,ParametroFactuPrincipalDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroFactuPrincipal("",entity,resultSet);    
				
				//entity.setParametroFactuPrincipalOriginal(super.getEntity("",entity.getParametroFactuPrincipalOriginal(),resultSet,ParametroFactuPrincipalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFactuPrincipalOriginal(this.getEntityParametroFactuPrincipal("",entity.getParametroFactuPrincipalOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroFactuPrincipal(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ParametroFactuPrincipal
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ParametroFactuPrincipal entity = new ParametroFactuPrincipal();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroFactuPrincipalDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroFactuPrincipalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFactuPrincipalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.ParametroFactuPrincipal.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseParametroFactuPrincipal(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ParametroFactuPrincipal> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroFactuPrincipal> entities = new  ArrayList<ParametroFactuPrincipal>();
		ParametroFactuPrincipal entity = new ParametroFactuPrincipal();		  
		
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
	
	public  List<ParametroFactuPrincipal> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroFactuPrincipal> entities = new  ArrayList<ParametroFactuPrincipal>();
		ParametroFactuPrincipal entity = new ParametroFactuPrincipal();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroFactuPrincipalDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroFactuPrincipalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFactuPrincipalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFactuPrincipal();
      	    	entity=super.getEntity("",entity,resultSet,ParametroFactuPrincipalDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroFactuPrincipal("",entity,resultSet);
      	    	
				//entity.setParametroFactuPrincipalOriginal( new ParametroFactuPrincipal());
      	    	//entity.setParametroFactuPrincipalOriginal(super.getEntity("",entity.getParametroFactuPrincipalOriginal(),resultSet,ParametroFactuPrincipalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFactuPrincipalOriginal(this.getEntityParametroFactuPrincipal("",entity.getParametroFactuPrincipalOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroFactuPrincipals(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFactuPrincipal(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroFactuPrincipal> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroFactuPrincipal> entities = new  ArrayList<ParametroFactuPrincipal>();
		ParametroFactuPrincipal entity = new ParametroFactuPrincipal();		  
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
	
	public  List<ParametroFactuPrincipal> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroFactuPrincipal> entities = new  ArrayList<ParametroFactuPrincipal>();
		ParametroFactuPrincipal entity = new ParametroFactuPrincipal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFactuPrincipal();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroFactuPrincipal();
					//entity.setMapParametroFactuPrincipal(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapParametroFactuPrincipalValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroFactuPrincipal().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroFactuPrincipalDataAccess.ISWITHSCHEMA);         		
					entity=ParametroFactuPrincipalDataAccess.getEntityParametroFactuPrincipal("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroFactuPrincipalOriginal( new ParametroFactuPrincipal());
					////entity.setParametroFactuPrincipalOriginal(super.getEntity("",entity.getParametroFactuPrincipalOriginal(),resultSet,ParametroFactuPrincipalDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroFactuPrincipalOriginal(this.getEntityParametroFactuPrincipal("",entity.getParametroFactuPrincipalOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroFactuPrincipals(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFactuPrincipal(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ParametroFactuPrincipal getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroFactuPrincipal entity = new ParametroFactuPrincipal();		  
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
	
	public  ParametroFactuPrincipal getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroFactuPrincipal entity = new ParametroFactuPrincipal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFactuPrincipal();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroFactuPrincipal();
					//entity.setMapParametroFactuPrincipal(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapParametroFactuPrincipalValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroFactuPrincipal().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroFactuPrincipalDataAccess.ISWITHSCHEMA);         		
					entity=ParametroFactuPrincipalDataAccess.getEntityParametroFactuPrincipal("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroFactuPrincipalOriginal( new ParametroFactuPrincipal());
					////entity.setParametroFactuPrincipalOriginal(super.getEntity("",entity.getParametroFactuPrincipalOriginal(),resultSet,ParametroFactuPrincipalDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroFactuPrincipalOriginal(this.getEntityParametroFactuPrincipal("",entity.getParametroFactuPrincipalOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseParametroFactuPrincipal(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFactuPrincipal(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ParametroFactuPrincipal getEntityParametroFactuPrincipal(String strPrefijo,ParametroFactuPrincipal entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ParametroFactuPrincipal.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ParametroFactuPrincipal.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ParametroFactuPrincipalDataAccess.setFieldReflectionParametroFactuPrincipal(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasParametroFactuPrincipal=ParametroFactuPrincipalConstantesFunciones.getTodosTiposColumnasParametroFactuPrincipal();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasParametroFactuPrincipal) {
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
							field = ParametroFactuPrincipal.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ParametroFactuPrincipal.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ParametroFactuPrincipalDataAccess.setFieldReflectionParametroFactuPrincipal(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionParametroFactuPrincipal(Field field,String strPrefijo,String sColumn,ParametroFactuPrincipal entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ParametroFactuPrincipalConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.IDTIPOPARAMFACTUDESCUENTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.IDTIPOPARAMFACTULISTADOCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.IDTIPOPARAMFACTUSECUENCIATRABAJO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.IDTIPODOCUMENTOFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.IDTIPODOCUMENTONOTACREDITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.IDTIPODOCUMENTONOTADEBITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.ENLINEA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.CONCUENTATIPOCLIENTE:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.CONCLIENTEIMPUESTO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.IDLIBROCONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.IDMONEDA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.CONIMPRESION:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.IDFORMATO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.CONSECUENCIALUSUARIO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.CONSECUENCIALEDITABLE:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.CONPRECIOPORCLIENTE:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.CONMODIFICARPRECIO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.CONMODIFICARSERVICIO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.CONCAMBIARUNIDAD:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.NUMERODECIMALESUNIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.CONACTIVARSERIE:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.CONACTIVARLOTE:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.CONACTIVARMULTIEMPRESA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.CONCENTROCOSTOS:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.CONUNIDADES:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.CONCUPODISPONIBLE:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.CONFORMAPAGO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.CONENVIOMAIL:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.CONAUTORIZARPROFORMA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.CONBLOQUEOPEDIDO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.CONCONTROLANTICIPO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.CONFACTURAAUTO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.CONGRABARVALORCERO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.CONAGREGARITEM:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.NUMEROCOPIAS:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.LEYENDA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.CONSINFACTURA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEFLETEVENTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEOTROCARGO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEFINAN:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEBONI:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEBONIDEVOL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEICE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroFactuPrincipal>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ParametroFactuPrincipal> entities = new  ArrayList<ParametroFactuPrincipal>();
		ParametroFactuPrincipal entity = new ParametroFactuPrincipal();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroFactuPrincipalDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroFactuPrincipalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFactuPrincipalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ParametroFactuPrincipal();
					entity=super.getEntity("",entity,resultSet,ParametroFactuPrincipalDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityParametroFactuPrincipal("",entity,resultSet);
					
					//entity.setParametroFactuPrincipalOriginal( new ParametroFactuPrincipal());
					//entity.setParametroFactuPrincipalOriginal(super.getEntity("",entity.getParametroFactuPrincipalOriginal(),resultSet,ParametroFactuPrincipalDataAccess.ISWITHSCHEMA));         		
					//entity.setParametroFactuPrincipalOriginal(this.getEntityParametroFactuPrincipal("",entity.getParametroFactuPrincipalOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseParametroFactuPrincipals(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFactuPrincipal(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroFactuPrincipal>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ParametroFactuPrincipal> entities = new  ArrayList<ParametroFactuPrincipal>();
		ParametroFactuPrincipal entity = new ParametroFactuPrincipal();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroFactuPrincipalDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroFactuPrincipalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFactuPrincipalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ParametroFactuPrincipal> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroFactuPrincipal> entities = new  ArrayList<ParametroFactuPrincipal>();
		ParametroFactuPrincipal entity = new ParametroFactuPrincipal();		  
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
	
	public  List<ParametroFactuPrincipal> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroFactuPrincipal> entities = new  ArrayList<ParametroFactuPrincipal>();
		ParametroFactuPrincipal entity = new ParametroFactuPrincipal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFactuPrincipal();
      	    	entity=super.getEntity("",entity,resultSet,ParametroFactuPrincipalDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroFactuPrincipal("",entity,resultSet);
      	    	
				//entity.setParametroFactuPrincipalOriginal( new ParametroFactuPrincipal());
      	    	//entity.setParametroFactuPrincipalOriginal(super.getEntity("",entity.getParametroFactuPrincipalOriginal(),resultSet,ParametroFactuPrincipalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFactuPrincipalOriginal(this.getEntityParametroFactuPrincipal("",entity.getParametroFactuPrincipalOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseParametroFactuPrincipals(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFactuPrincipal(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroFactuPrincipal> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroFactuPrincipal> entities = new  ArrayList<ParametroFactuPrincipal>();
		ParametroFactuPrincipal entity = new ParametroFactuPrincipal();		  
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
	
	public  List<ParametroFactuPrincipal> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroFactuPrincipal> entities = new  ArrayList<ParametroFactuPrincipal>();
		ParametroFactuPrincipal entity = new ParametroFactuPrincipal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFactuPrincipal();
      	    	entity=super.getEntity("",entity,resultSet,ParametroFactuPrincipalDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroFactuPrincipal("",entity,resultSet);
      	    	
				//entity.setParametroFactuPrincipalOriginal( new ParametroFactuPrincipal());
      	    	//entity.setParametroFactuPrincipalOriginal(super.getEntity("",entity.getParametroFactuPrincipalOriginal(),resultSet,ParametroFactuPrincipalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFactuPrincipalOriginal(this.getEntityParametroFactuPrincipal("",entity.getParametroFactuPrincipalOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroFactuPrincipals(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ParametroFactuPrincipal getEntityParametroFactuPrincipal(String strPrefijo,ParametroFactuPrincipal entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ParametroFactuPrincipalConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+ParametroFactuPrincipalConstantesFunciones.IDSUCURSAL));
				entity.setid_tipo_param_factu_descuento(resultSet.getLong(strPrefijo+ParametroFactuPrincipalConstantesFunciones.IDTIPOPARAMFACTUDESCUENTO));
				entity.setid_tipo_param_factu_listado_cliente(resultSet.getLong(strPrefijo+ParametroFactuPrincipalConstantesFunciones.IDTIPOPARAMFACTULISTADOCLIENTE));
				entity.setid_tipo_param_factu_secuencia_trabajo(resultSet.getLong(strPrefijo+ParametroFactuPrincipalConstantesFunciones.IDTIPOPARAMFACTUSECUENCIATRABAJO));
				entity.setid_tipo_documento_factura(resultSet.getLong(strPrefijo+ParametroFactuPrincipalConstantesFunciones.IDTIPODOCUMENTOFACTURA));
				entity.setid_tipo_documento_nota_credito(resultSet.getLong(strPrefijo+ParametroFactuPrincipalConstantesFunciones.IDTIPODOCUMENTONOTACREDITO));
				entity.setid_tipo_documento_nota_debito(resultSet.getLong(strPrefijo+ParametroFactuPrincipalConstantesFunciones.IDTIPODOCUMENTONOTADEBITO));
				entity.seten_linea(resultSet.getBoolean(strPrefijo+ParametroFactuPrincipalConstantesFunciones.ENLINEA));
				entity.setcon_cuenta_tipo_cliente(resultSet.getBoolean(strPrefijo+ParametroFactuPrincipalConstantesFunciones.CONCUENTATIPOCLIENTE));
				entity.setcon_cliente_impuesto(resultSet.getBoolean(strPrefijo+ParametroFactuPrincipalConstantesFunciones.CONCLIENTEIMPUESTO));
				entity.setid_libro_contable(resultSet.getLong(strPrefijo+ParametroFactuPrincipalConstantesFunciones.IDLIBROCONTABLE));
				entity.setid_moneda(resultSet.getLong(strPrefijo+ParametroFactuPrincipalConstantesFunciones.IDMONEDA));
				entity.setcon_impresion(resultSet.getBoolean(strPrefijo+ParametroFactuPrincipalConstantesFunciones.CONIMPRESION));
				entity.setid_formato(resultSet.getLong(strPrefijo+ParametroFactuPrincipalConstantesFunciones.IDFORMATO));
				entity.setcon_secuencial_usuario(resultSet.getBoolean(strPrefijo+ParametroFactuPrincipalConstantesFunciones.CONSECUENCIALUSUARIO));
				entity.setcon_secuencial_editable(resultSet.getBoolean(strPrefijo+ParametroFactuPrincipalConstantesFunciones.CONSECUENCIALEDITABLE));
				entity.setcon_precio_por_cliente(resultSet.getBoolean(strPrefijo+ParametroFactuPrincipalConstantesFunciones.CONPRECIOPORCLIENTE));
				entity.setcon_modificar_precio(resultSet.getBoolean(strPrefijo+ParametroFactuPrincipalConstantesFunciones.CONMODIFICARPRECIO));
				entity.setcon_modificar_servicio(resultSet.getBoolean(strPrefijo+ParametroFactuPrincipalConstantesFunciones.CONMODIFICARSERVICIO));
				entity.setcon_cambiar_unidad(resultSet.getBoolean(strPrefijo+ParametroFactuPrincipalConstantesFunciones.CONCAMBIARUNIDAD));
				entity.setnumero_decimales_unidad(resultSet.getInt(strPrefijo+ParametroFactuPrincipalConstantesFunciones.NUMERODECIMALESUNIDAD));
				entity.setcon_activar_serie(resultSet.getBoolean(strPrefijo+ParametroFactuPrincipalConstantesFunciones.CONACTIVARSERIE));
				entity.setcon_activar_lote(resultSet.getBoolean(strPrefijo+ParametroFactuPrincipalConstantesFunciones.CONACTIVARLOTE));
				entity.setcon_activar_multi_empresa(resultSet.getBoolean(strPrefijo+ParametroFactuPrincipalConstantesFunciones.CONACTIVARMULTIEMPRESA));
				entity.setcon_centro_costos(resultSet.getBoolean(strPrefijo+ParametroFactuPrincipalConstantesFunciones.CONCENTROCOSTOS));
				entity.setcon_unidades(resultSet.getBoolean(strPrefijo+ParametroFactuPrincipalConstantesFunciones.CONUNIDADES));
				entity.setcon_cupo_disponible(resultSet.getBoolean(strPrefijo+ParametroFactuPrincipalConstantesFunciones.CONCUPODISPONIBLE));
				entity.setcon_forma_pago(resultSet.getBoolean(strPrefijo+ParametroFactuPrincipalConstantesFunciones.CONFORMAPAGO));
				entity.setcon_envio_mail(resultSet.getBoolean(strPrefijo+ParametroFactuPrincipalConstantesFunciones.CONENVIOMAIL));
				entity.setcon_autorizar_proforma(resultSet.getBoolean(strPrefijo+ParametroFactuPrincipalConstantesFunciones.CONAUTORIZARPROFORMA));
				entity.setcon_bloqueo_pedido(resultSet.getBoolean(strPrefijo+ParametroFactuPrincipalConstantesFunciones.CONBLOQUEOPEDIDO));
				entity.setcon_control_anticipo(resultSet.getBoolean(strPrefijo+ParametroFactuPrincipalConstantesFunciones.CONCONTROLANTICIPO));
				entity.setcon_factura_auto(resultSet.getBoolean(strPrefijo+ParametroFactuPrincipalConstantesFunciones.CONFACTURAAUTO));
				entity.setcon_grabar_valor_cero(resultSet.getBoolean(strPrefijo+ParametroFactuPrincipalConstantesFunciones.CONGRABARVALORCERO));
				entity.setcon_agregar_item(resultSet.getBoolean(strPrefijo+ParametroFactuPrincipalConstantesFunciones.CONAGREGARITEM));
				entity.setnumero_copias(resultSet.getInt(strPrefijo+ParametroFactuPrincipalConstantesFunciones.NUMEROCOPIAS));
				entity.setleyenda(resultSet.getString(strPrefijo+ParametroFactuPrincipalConstantesFunciones.LEYENDA));
				entity.setcon_sin_factura(resultSet.getBoolean(strPrefijo+ParametroFactuPrincipalConstantesFunciones.CONSINFACTURA));
				entity.setid_cuenta_contable_flete_venta(resultSet.getLong(strPrefijo+ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEFLETEVENTA));
				entity.setid_cuenta_contable_otro_cargo(resultSet.getLong(strPrefijo+ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEOTROCARGO));
				entity.setid_cuenta_contable_finan(resultSet.getLong(strPrefijo+ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEFINAN));
				entity.setid_cuenta_contable_boni(resultSet.getLong(strPrefijo+ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEBONI));
				entity.setid_cuenta_contable_boni_devol(resultSet.getLong(strPrefijo+ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEBONIDEVOL));
				entity.setid_cuenta_contable_ice(resultSet.getLong(strPrefijo+ParametroFactuPrincipalConstantesFunciones.IDCUENTACONTABLEICE));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowParametroFactuPrincipal(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ParametroFactuPrincipal entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ParametroFactuPrincipalDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ParametroFactuPrincipalDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ParametroFactuPrincipalDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ParametroFactuPrincipalDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ParametroFactuPrincipalConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ParametroFactuPrincipalDataAccess.TABLENAME,ParametroFactuPrincipalDataAccess.ISWITHSTOREPROCEDURES);
			
			ParametroFactuPrincipalDataAccess.setParametroFactuPrincipalOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ParametroFactuPrincipal relparametrofactuprincipal)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relparametrofactuprincipal.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ParametroFactuPrincipal relparametrofactuprincipal)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relparametrofactuprincipal.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public TipoParamFactuDescuento getTipoParamFactuDescuento(Connexion connexion,ParametroFactuPrincipal relparametrofactuprincipal)throws SQLException,Exception {

		TipoParamFactuDescuento tipoparamfactudescuento= new TipoParamFactuDescuento();

		try {
			TipoParamFactuDescuentoDataAccess tipoparamfactudescuentoDataAccess=new TipoParamFactuDescuentoDataAccess();

			tipoparamfactudescuentoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoparamfactudescuentoDataAccess.setConnexionType(this.connexionType);
			tipoparamfactudescuentoDataAccess.setParameterDbType(this.parameterDbType);

			tipoparamfactudescuento=tipoparamfactudescuentoDataAccess.getEntity(connexion,relparametrofactuprincipal.getid_tipo_param_factu_descuento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoparamfactudescuento;

	}

	public TipoParamFactuListadoCliente getTipoParamFactuListadoCliente(Connexion connexion,ParametroFactuPrincipal relparametrofactuprincipal)throws SQLException,Exception {

		TipoParamFactuListadoCliente tipoparamfactulistadocliente= new TipoParamFactuListadoCliente();

		try {
			TipoParamFactuListadoClienteDataAccess tipoparamfactulistadoclienteDataAccess=new TipoParamFactuListadoClienteDataAccess();

			tipoparamfactulistadoclienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoparamfactulistadoclienteDataAccess.setConnexionType(this.connexionType);
			tipoparamfactulistadoclienteDataAccess.setParameterDbType(this.parameterDbType);

			tipoparamfactulistadocliente=tipoparamfactulistadoclienteDataAccess.getEntity(connexion,relparametrofactuprincipal.getid_tipo_param_factu_listado_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoparamfactulistadocliente;

	}

	public TipoParamFactuSecuenciaTrabajo getTipoParamFactuSecuenciaTrabajo(Connexion connexion,ParametroFactuPrincipal relparametrofactuprincipal)throws SQLException,Exception {

		TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo= new TipoParamFactuSecuenciaTrabajo();

		try {
			TipoParamFactuSecuenciaTrabajoDataAccess tipoparamfactusecuenciatrabajoDataAccess=new TipoParamFactuSecuenciaTrabajoDataAccess();

			tipoparamfactusecuenciatrabajoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoparamfactusecuenciatrabajoDataAccess.setConnexionType(this.connexionType);
			tipoparamfactusecuenciatrabajoDataAccess.setParameterDbType(this.parameterDbType);

			tipoparamfactusecuenciatrabajo=tipoparamfactusecuenciatrabajoDataAccess.getEntity(connexion,relparametrofactuprincipal.getid_tipo_param_factu_secuencia_trabajo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoparamfactusecuenciatrabajo;

	}

	public TipoDocumento getTipoDocumentoFactura(Connexion connexion,ParametroFactuPrincipal relparametrofactuprincipal)throws SQLException,Exception {

		TipoDocumento tipodocumento= new TipoDocumento();

		try {
			TipoDocumentoDataAccess tipodocumentoDataAccess=new TipoDocumentoDataAccess();

			tipodocumentoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipodocumentoDataAccess.setConnexionType(this.connexionType);
			tipodocumentoDataAccess.setParameterDbType(this.parameterDbType);

			tipodocumento=tipodocumentoDataAccess.getEntity(connexion,relparametrofactuprincipal.getid_tipo_documento_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipodocumento;

	}

	public TipoDocumento getTipoDocumentoNotaCredito(Connexion connexion,ParametroFactuPrincipal relparametrofactuprincipal)throws SQLException,Exception {

		TipoDocumento tipodocumento= new TipoDocumento();

		try {
			TipoDocumentoDataAccess tipodocumentoDataAccess=new TipoDocumentoDataAccess();

			tipodocumentoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipodocumentoDataAccess.setConnexionType(this.connexionType);
			tipodocumentoDataAccess.setParameterDbType(this.parameterDbType);

			tipodocumento=tipodocumentoDataAccess.getEntity(connexion,relparametrofactuprincipal.getid_tipo_documento_nota_credito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipodocumento;

	}

	public TipoDocumento getTipoDocumentoNotaDebito(Connexion connexion,ParametroFactuPrincipal relparametrofactuprincipal)throws SQLException,Exception {

		TipoDocumento tipodocumento= new TipoDocumento();

		try {
			TipoDocumentoDataAccess tipodocumentoDataAccess=new TipoDocumentoDataAccess();

			tipodocumentoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipodocumentoDataAccess.setConnexionType(this.connexionType);
			tipodocumentoDataAccess.setParameterDbType(this.parameterDbType);

			tipodocumento=tipodocumentoDataAccess.getEntity(connexion,relparametrofactuprincipal.getid_tipo_documento_nota_debito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipodocumento;

	}

	public LibroContable getLibroContable(Connexion connexion,ParametroFactuPrincipal relparametrofactuprincipal)throws SQLException,Exception {

		LibroContable librocontable= new LibroContable();

		try {
			LibroContableDataAccess librocontableDataAccess=new LibroContableDataAccess();

			librocontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			librocontableDataAccess.setConnexionType(this.connexionType);
			librocontableDataAccess.setParameterDbType(this.parameterDbType);

			librocontable=librocontableDataAccess.getEntity(connexion,relparametrofactuprincipal.getid_libro_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return librocontable;

	}

	public Moneda getMoneda(Connexion connexion,ParametroFactuPrincipal relparametrofactuprincipal)throws SQLException,Exception {

		Moneda moneda= new Moneda();

		try {
			MonedaDataAccess monedaDataAccess=new MonedaDataAccess();

			monedaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			monedaDataAccess.setConnexionType(this.connexionType);
			monedaDataAccess.setParameterDbType(this.parameterDbType);

			moneda=monedaDataAccess.getEntity(connexion,relparametrofactuprincipal.getid_moneda());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return moneda;

	}

	public Formato getFormato(Connexion connexion,ParametroFactuPrincipal relparametrofactuprincipal)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relparametrofactuprincipal.getid_formato());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public CuentaContable getCuentaContableFleteVenta(Connexion connexion,ParametroFactuPrincipal relparametrofactuprincipal)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametrofactuprincipal.getid_cuenta_contable_flete_venta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableOtroCargo(Connexion connexion,ParametroFactuPrincipal relparametrofactuprincipal)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametrofactuprincipal.getid_cuenta_contable_otro_cargo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableFinan(Connexion connexion,ParametroFactuPrincipal relparametrofactuprincipal)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametrofactuprincipal.getid_cuenta_contable_finan());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableBoni(Connexion connexion,ParametroFactuPrincipal relparametrofactuprincipal)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametrofactuprincipal.getid_cuenta_contable_boni());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableBoniDevol(Connexion connexion,ParametroFactuPrincipal relparametrofactuprincipal)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametrofactuprincipal.getid_cuenta_contable_boni_devol());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableIce(Connexion connexion,ParametroFactuPrincipal relparametrofactuprincipal)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametrofactuprincipal.getid_cuenta_contable_ice());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ParametroFactuPrincipal parametrofactuprincipal) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!parametrofactuprincipal.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(parametrofactuprincipal.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(parametrofactuprincipal.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_param_factu_descuento=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_param_factu_descuento.setValue(parametrofactuprincipal.getid_tipo_param_factu_descuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_param_factu_descuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_param_factu_listado_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_param_factu_listado_cliente.setValue(parametrofactuprincipal.getid_tipo_param_factu_listado_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_param_factu_listado_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_param_factu_secuencia_trabajo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_param_factu_secuencia_trabajo.setValue(parametrofactuprincipal.getid_tipo_param_factu_secuencia_trabajo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_param_factu_secuencia_trabajo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_documento_factura=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_documento_factura.setValue(parametrofactuprincipal.getid_tipo_documento_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_documento_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_documento_nota_credito=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_documento_nota_credito.setValue(parametrofactuprincipal.getid_tipo_documento_nota_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_documento_nota_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_documento_nota_debito=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_documento_nota_debito.setValue(parametrofactuprincipal.getid_tipo_documento_nota_debito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_documento_nota_debito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueen_linea=new ParameterValue<Boolean>();
					parameterMaintenanceValueen_linea.setValue(parametrofactuprincipal.geten_linea());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueen_linea);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_cuenta_tipo_cliente=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_cuenta_tipo_cliente.setValue(parametrofactuprincipal.getcon_cuenta_tipo_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_cuenta_tipo_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_cliente_impuesto=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_cliente_impuesto.setValue(parametrofactuprincipal.getcon_cliente_impuesto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_cliente_impuesto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_libro_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_libro_contable.setValue(parametrofactuprincipal.getid_libro_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_libro_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_moneda=new ParameterValue<Long>();
					parameterMaintenanceValueid_moneda.setValue(parametrofactuprincipal.getid_moneda());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_moneda);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_impresion=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_impresion.setValue(parametrofactuprincipal.getcon_impresion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_impresion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato.setValue(parametrofactuprincipal.getid_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_secuencial_usuario=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_secuencial_usuario.setValue(parametrofactuprincipal.getcon_secuencial_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_secuencial_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_secuencial_editable=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_secuencial_editable.setValue(parametrofactuprincipal.getcon_secuencial_editable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_secuencial_editable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_precio_por_cliente=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_precio_por_cliente.setValue(parametrofactuprincipal.getcon_precio_por_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_precio_por_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_modificar_precio=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_modificar_precio.setValue(parametrofactuprincipal.getcon_modificar_precio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_modificar_precio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_modificar_servicio=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_modificar_servicio.setValue(parametrofactuprincipal.getcon_modificar_servicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_modificar_servicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_cambiar_unidad=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_cambiar_unidad.setValue(parametrofactuprincipal.getcon_cambiar_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_cambiar_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_decimales_unidad=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_decimales_unidad.setValue(parametrofactuprincipal.getnumero_decimales_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_decimales_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_activar_serie=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_activar_serie.setValue(parametrofactuprincipal.getcon_activar_serie());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_activar_serie);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_activar_lote=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_activar_lote.setValue(parametrofactuprincipal.getcon_activar_lote());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_activar_lote);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_activar_multi_empresa=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_activar_multi_empresa.setValue(parametrofactuprincipal.getcon_activar_multi_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_activar_multi_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_centro_costos=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_centro_costos.setValue(parametrofactuprincipal.getcon_centro_costos());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_centro_costos);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_unidades=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_unidades.setValue(parametrofactuprincipal.getcon_unidades());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_unidades);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_cupo_disponible=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_cupo_disponible.setValue(parametrofactuprincipal.getcon_cupo_disponible());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_cupo_disponible);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_forma_pago=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_forma_pago.setValue(parametrofactuprincipal.getcon_forma_pago());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_forma_pago);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_envio_mail=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_envio_mail.setValue(parametrofactuprincipal.getcon_envio_mail());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_envio_mail);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_autorizar_proforma=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_autorizar_proforma.setValue(parametrofactuprincipal.getcon_autorizar_proforma());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_autorizar_proforma);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_bloqueo_pedido=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_bloqueo_pedido.setValue(parametrofactuprincipal.getcon_bloqueo_pedido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_bloqueo_pedido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_control_anticipo=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_control_anticipo.setValue(parametrofactuprincipal.getcon_control_anticipo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_control_anticipo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_factura_auto=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_factura_auto.setValue(parametrofactuprincipal.getcon_factura_auto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_factura_auto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_grabar_valor_cero=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_grabar_valor_cero.setValue(parametrofactuprincipal.getcon_grabar_valor_cero());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_grabar_valor_cero);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_agregar_item=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_agregar_item.setValue(parametrofactuprincipal.getcon_agregar_item());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_agregar_item);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_copias=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_copias.setValue(parametrofactuprincipal.getnumero_copias());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_copias);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueleyenda=new ParameterValue<String>();
					parameterMaintenanceValueleyenda.setValue(parametrofactuprincipal.getleyenda());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueleyenda);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_sin_factura=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_sin_factura.setValue(parametrofactuprincipal.getcon_sin_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_sin_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_flete_venta=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_flete_venta.setValue(parametrofactuprincipal.getid_cuenta_contable_flete_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_flete_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_otro_cargo=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_otro_cargo.setValue(parametrofactuprincipal.getid_cuenta_contable_otro_cargo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_otro_cargo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_finan=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_finan.setValue(parametrofactuprincipal.getid_cuenta_contable_finan());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_finan);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_boni=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_boni.setValue(parametrofactuprincipal.getid_cuenta_contable_boni());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_boni);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_boni_devol=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_boni_devol.setValue(parametrofactuprincipal.getid_cuenta_contable_boni_devol());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_boni_devol);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_ice=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_ice.setValue(parametrofactuprincipal.getid_cuenta_contable_ice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_ice);
					parametersTemp.add(parameterMaintenance);
					
						if(!parametrofactuprincipal.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(parametrofactuprincipal.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(parametrofactuprincipal.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(parametrofactuprincipal.getId());
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
	
	public void setIsNewIsChangedFalseParametroFactuPrincipal(ParametroFactuPrincipal parametrofactuprincipal)throws Exception  {		
		parametrofactuprincipal.setIsNew(false);
		parametrofactuprincipal.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseParametroFactuPrincipals(List<ParametroFactuPrincipal> parametrofactuprincipals)throws Exception  {				
		for(ParametroFactuPrincipal parametrofactuprincipal:parametrofactuprincipals) {
			parametrofactuprincipal.setIsNew(false);
			parametrofactuprincipal.setIsChanged(false);
		}
	}
	
	public void generarExportarParametroFactuPrincipal(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
