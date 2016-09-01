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
package com.bydan.erp.contabilidad.util;

import org.apache.log4j.Logger;
import java.sql.Time;
import java.sql.Timestamp;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.border.Border;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.contabilidad.util.PlantillaFacturaConstantesFunciones;
import com.bydan.erp.contabilidad.util.PlantillaFacturaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.PlantillaFacturaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PlantillaFacturaConstantesFunciones extends PlantillaFacturaConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
	//PARA CAMBIAR TODO--> SE CAMBIA EN TABLA RELACIONES Y TABLAS RELACIONADOS
	/*
	PARA MANEJAR EL TAB RELACIONES CON TABLA DE DATOS SE DEBE MODIFICAR Y VERIFICAR LOS VALORES CONTANTES:	
		final public static Integer ISWING_TAMANIOMAXIMO_TABLADATOSREL=240;//230;350;		
		final public static Integer ISWING_TAMANIOMINIMO_TABLADATOSREL=240;//230;260
		
		final public static Integer ISWING_ALTO_TABPANE=375;//375;400;260;
	CASO CONTRARIO, ESTOS VALORES SERIAN PARA CADA CASO (NO CONSTANTES)
	
	NOTA:
	* LA ALINEACION HORIZONTAL,FALTA
	*/
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="PlantillaFactura";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PlantillaFactura"+PlantillaFacturaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PlantillaFacturaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PlantillaFacturaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PlantillaFacturaConstantesFunciones.SCHEMA+"_"+PlantillaFacturaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PlantillaFacturaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PlantillaFacturaConstantesFunciones.SCHEMA+"_"+PlantillaFacturaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PlantillaFacturaConstantesFunciones.SCHEMA+"_"+PlantillaFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PlantillaFacturaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PlantillaFacturaConstantesFunciones.SCHEMA+"_"+PlantillaFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PlantillaFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PlantillaFacturaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PlantillaFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PlantillaFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PlantillaFacturaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PlantillaFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PlantillaFacturaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PlantillaFacturaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PlantillaFacturaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PlantillaFacturaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Plantilla Facturas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Plantilla Factura";
	public static final String SCLASSWEBTITULO_LOWER="Plantilla Factura";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PlantillaFactura";
	public static final String OBJECTNAME="plantillafactura";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="plantilla_factura";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select plantillafactura from "+PlantillaFacturaConstantesFunciones.SPERSISTENCENAME+" plantillafactura";
	public static String QUERYSELECTNATIVE="select "+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME+".id,"+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME+".version_row,"+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME+".id_empresa,"+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME+".codigo,"+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME+".nombre,"+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME+".descripcion,"+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME+".es_proveedor,"+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME+".id_cuenta_contable_aplicada,"+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME+".id_cuenta_contable_credito_bien,"+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME+".id_cuenta_contable_credito_servicio,"+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME+".id_tipo_retencion_fuente_bien,"+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME+".id_tipo_retencion_fuente_servicio,"+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME+".id_tipo_retencion_iva_bien,"+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME+".id_tipo_retencion_iva_servicio,"+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME+".id_cuenta_contable_gasto from "+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME;//+" as "+PlantillaFacturaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PlantillaFacturaConstantesFuncionesAdditional plantillafacturaConstantesFuncionesAdditional=null;
	
	public PlantillaFacturaConstantesFuncionesAdditional getPlantillaFacturaConstantesFuncionesAdditional() {
		return this.plantillafacturaConstantesFuncionesAdditional;
	}
	
	public void setPlantillaFacturaConstantesFuncionesAdditional(PlantillaFacturaConstantesFuncionesAdditional plantillafacturaConstantesFuncionesAdditional) {
		try {
			this.plantillafacturaConstantesFuncionesAdditional=plantillafacturaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String DESCRIPCION= "descripcion";
    public static final String ESPROVEEDOR= "es_proveedor";
    public static final String IDCUENTACONTABLEAPLICADA= "id_cuenta_contable_aplicada";
    public static final String IDCUENTACONTABLECREDITOBIEN= "id_cuenta_contable_credito_bien";
    public static final String IDCUENTACONTABLECREDITOSERVICIO= "id_cuenta_contable_credito_servicio";
    public static final String IDTIPORETENCIONFUENTEBIEN= "id_tipo_retencion_fuente_bien";
    public static final String IDTIPORETENCIONFUENTESERVICIO= "id_tipo_retencion_fuente_servicio";
    public static final String IDTIPORETENCIONIVABIEN= "id_tipo_retencion_iva_bien";
    public static final String IDTIPORETENCIONIVASERVICIO= "id_tipo_retencion_iva_servicio";
    public static final String IDCUENTACONTABLEGASTO= "id_cuenta_contable_gasto";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_ESPROVEEDOR= "Es Proveedor";
		public static final String LABEL_ESPROVEEDOR_LOWER= "Es Proveedor";
    	public static final String LABEL_IDCUENTACONTABLEAPLICADA= "Cta. Aplicada";
		public static final String LABEL_IDCUENTACONTABLEAPLICADA_LOWER= "Cuenta Contable Aplicada";
    	public static final String LABEL_IDCUENTACONTABLECREDITOBIEN= "Cta. Credito Bien";
		public static final String LABEL_IDCUENTACONTABLECREDITOBIEN_LOWER= "Cuenta Contable Credito Bien";
    	public static final String LABEL_IDCUENTACONTABLECREDITOSERVICIO= "Cta. Credito Servicio";
		public static final String LABEL_IDCUENTACONTABLECREDITOSERVICIO_LOWER= "Cuenta Contable Credito Servicio";
    	public static final String LABEL_IDTIPORETENCIONFUENTEBIEN= "Ret Fuente Bien";
		public static final String LABEL_IDTIPORETENCIONFUENTEBIEN_LOWER= "Tipo Retencion Fuente Bien";
    	public static final String LABEL_IDTIPORETENCIONFUENTESERVICIO= "Ret. Fuente Servicio";
		public static final String LABEL_IDTIPORETENCIONFUENTESERVICIO_LOWER= "Tipo Retencion Fuente Servicio";
    	public static final String LABEL_IDTIPORETENCIONIVABIEN= "Ret. Iva Bien";
		public static final String LABEL_IDTIPORETENCIONIVABIEN_LOWER= "Tipo Retencion Iva Bien";
    	public static final String LABEL_IDTIPORETENCIONIVASERVICIO= "Ret. Iva Servicio";
		public static final String LABEL_IDTIPORETENCIONIVASERVICIO_LOWER= "Tipo Retencion Iva Servicio";
    	public static final String LABEL_IDCUENTACONTABLEGASTO= "C. Gasto";
		public static final String LABEL_IDCUENTACONTABLEGASTO_LOWER= "Cuenta Contable Gasto";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
	
	public static String getPlantillaFacturaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PlantillaFacturaConstantesFunciones.IDEMPRESA)) {sLabelColumna=PlantillaFacturaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PlantillaFacturaConstantesFunciones.CODIGO)) {sLabelColumna=PlantillaFacturaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(PlantillaFacturaConstantesFunciones.NOMBRE)) {sLabelColumna=PlantillaFacturaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(PlantillaFacturaConstantesFunciones.DESCRIPCION)) {sLabelColumna=PlantillaFacturaConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(PlantillaFacturaConstantesFunciones.ESPROVEEDOR)) {sLabelColumna=PlantillaFacturaConstantesFunciones.LABEL_ESPROVEEDOR;}
		if(sNombreColumna.equals(PlantillaFacturaConstantesFunciones.IDCUENTACONTABLEAPLICADA)) {sLabelColumna=PlantillaFacturaConstantesFunciones.LABEL_IDCUENTACONTABLEAPLICADA;}
		if(sNombreColumna.equals(PlantillaFacturaConstantesFunciones.IDCUENTACONTABLECREDITOBIEN)) {sLabelColumna=PlantillaFacturaConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOBIEN;}
		if(sNombreColumna.equals(PlantillaFacturaConstantesFunciones.IDCUENTACONTABLECREDITOSERVICIO)) {sLabelColumna=PlantillaFacturaConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOSERVICIO;}
		if(sNombreColumna.equals(PlantillaFacturaConstantesFunciones.IDTIPORETENCIONFUENTEBIEN)) {sLabelColumna=PlantillaFacturaConstantesFunciones.LABEL_IDTIPORETENCIONFUENTEBIEN;}
		if(sNombreColumna.equals(PlantillaFacturaConstantesFunciones.IDTIPORETENCIONFUENTESERVICIO)) {sLabelColumna=PlantillaFacturaConstantesFunciones.LABEL_IDTIPORETENCIONFUENTESERVICIO;}
		if(sNombreColumna.equals(PlantillaFacturaConstantesFunciones.IDTIPORETENCIONIVABIEN)) {sLabelColumna=PlantillaFacturaConstantesFunciones.LABEL_IDTIPORETENCIONIVABIEN;}
		if(sNombreColumna.equals(PlantillaFacturaConstantesFunciones.IDTIPORETENCIONIVASERVICIO)) {sLabelColumna=PlantillaFacturaConstantesFunciones.LABEL_IDTIPORETENCIONIVASERVICIO;}
		if(sNombreColumna.equals(PlantillaFacturaConstantesFunciones.IDCUENTACONTABLEGASTO)) {sLabelColumna=PlantillaFacturaConstantesFunciones.LABEL_IDCUENTACONTABLEGASTO;}
		
		if(sLabelColumna.equals("")) {
			sLabelColumna=sNombreColumna;	
		}
		return sLabelColumna;
	}
	
	
	
	public static String getNombreEjb_JBoss81(String sAplicacion,String sModule,String sClaseEjb,String sInterfaceEjb) throws Exception {
		String sDescripcion="";

		sDescripcion="ejb:"+sAplicacion+"/"+sModule+"/"+sClaseEjb+"!" + sInterfaceEjb;
		
		return sDescripcion;
	}
	
	
	
			
			
			
			
			
			
		
	public static String getes_proveedorDescripcion(PlantillaFactura plantillafactura) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!plantillafactura.getes_proveedor()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_proveedorHtmlDescripcion(PlantillaFactura plantillafactura) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(plantillafactura.getId(),plantillafactura.getes_proveedor());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
	
	public static String getPlantillaFacturaDescripcion(PlantillaFactura plantillafactura) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(plantillafactura !=null/* && plantillafactura.getId()!=0*/) {
			sDescripcion=plantillafactura.getcodigo();//plantillafacturaplantillafactura.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getPlantillaFacturaDescripcionDetallado(PlantillaFactura plantillafactura) {
		String sDescripcion="";
			
		sDescripcion+=PlantillaFacturaConstantesFunciones.ID+"=";
		sDescripcion+=plantillafactura.getId().toString()+",";
		sDescripcion+=PlantillaFacturaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=plantillafactura.getVersionRow().toString()+",";
		sDescripcion+=PlantillaFacturaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=plantillafactura.getid_empresa().toString()+",";
		sDescripcion+=PlantillaFacturaConstantesFunciones.CODIGO+"=";
		sDescripcion+=plantillafactura.getcodigo()+",";
		sDescripcion+=PlantillaFacturaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=plantillafactura.getnombre()+",";
		sDescripcion+=PlantillaFacturaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=plantillafactura.getdescripcion()+",";
		sDescripcion+=PlantillaFacturaConstantesFunciones.ESPROVEEDOR+"=";
		sDescripcion+=plantillafactura.getes_proveedor().toString()+",";
		sDescripcion+=PlantillaFacturaConstantesFunciones.IDCUENTACONTABLEAPLICADA+"=";
		sDescripcion+=plantillafactura.getid_cuenta_contable_aplicada().toString()+",";
		sDescripcion+=PlantillaFacturaConstantesFunciones.IDCUENTACONTABLECREDITOBIEN+"=";
		sDescripcion+=plantillafactura.getid_cuenta_contable_credito_bien().toString()+",";
		sDescripcion+=PlantillaFacturaConstantesFunciones.IDCUENTACONTABLECREDITOSERVICIO+"=";
		sDescripcion+=plantillafactura.getid_cuenta_contable_credito_servicio().toString()+",";
		sDescripcion+=PlantillaFacturaConstantesFunciones.IDTIPORETENCIONFUENTEBIEN+"=";
		sDescripcion+=plantillafactura.getid_tipo_retencion_fuente_bien().toString()+",";
		sDescripcion+=PlantillaFacturaConstantesFunciones.IDTIPORETENCIONFUENTESERVICIO+"=";
		sDescripcion+=plantillafactura.getid_tipo_retencion_fuente_servicio().toString()+",";
		sDescripcion+=PlantillaFacturaConstantesFunciones.IDTIPORETENCIONIVABIEN+"=";
		sDescripcion+=plantillafactura.getid_tipo_retencion_iva_bien().toString()+",";
		sDescripcion+=PlantillaFacturaConstantesFunciones.IDTIPORETENCIONIVASERVICIO+"=";
		sDescripcion+=plantillafactura.getid_tipo_retencion_iva_servicio().toString()+",";
		sDescripcion+=PlantillaFacturaConstantesFunciones.IDCUENTACONTABLEGASTO+"=";
		sDescripcion+=plantillafactura.getid_cuenta_contable_gasto().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setPlantillaFacturaDescripcion(PlantillaFactura plantillafactura,String sValor) throws Exception {			
		if(plantillafactura !=null) {
			plantillafactura.setcodigo(sValor);;//plantillafacturaplantillafactura.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getCuentaContableAplicadaDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableCreditoBienDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableCreditoServicioDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getTipoRetencionFuenteBienDescripcion(TipoRetencion tiporetencion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiporetencion!=null/*&&tiporetencion.getId()>0*/) {
			sDescripcion=TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(tiporetencion);
		}

		return sDescripcion;
	}

	public static String getTipoRetencionFuenteServicioDescripcion(TipoRetencion tiporetencion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiporetencion!=null/*&&tiporetencion.getId()>0*/) {
			sDescripcion=TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(tiporetencion);
		}

		return sDescripcion;
	}

	public static String getTipoRetencionIvaBienDescripcion(TipoRetencion tiporetencion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiporetencion!=null/*&&tiporetencion.getId()>0*/) {
			sDescripcion=TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(tiporetencion);
		}

		return sDescripcion;
	}

	public static String getTipoRetencionIvaServicioDescripcion(TipoRetencion tiporetencion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiporetencion!=null/*&&tiporetencion.getId()>0*/) {
			sDescripcion=TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(tiporetencion);
		}

		return sDescripcion;
	}

	public static String getCuentaContableGastoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdCuentaContableCredito")) {
			sNombreIndice="Tipo=  Por Cta. Aplicada";
		} else if(sNombreIndice.equals("FK_IdCuentaContableCreditoBien")) {
			sNombreIndice="Tipo=  Por Cta. Credito Bien";
		} else if(sNombreIndice.equals("FK_IdCuentaContableCreditoFinServicio")) {
			sNombreIndice="Tipo=  Por Cta. Credito Servicio";
		} else if(sNombreIndice.equals("FK_IdCuentaContableGasto")) {
			sNombreIndice="Tipo=  Por C. Gasto";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdTipoRetencionFuenteBien")) {
			sNombreIndice="Tipo=  Por Ret Fuente Bien";
		} else if(sNombreIndice.equals("FK_IdTipoRetencionFuenteServicio")) {
			sNombreIndice="Tipo=  Por Ret. Fuente Servicio";
		} else if(sNombreIndice.equals("FK_IdTipoRetencionIvaBien")) {
			sNombreIndice="Tipo=  Por Ret. Iva Bien";
		} else if(sNombreIndice.equals("FK_IdTipoRetencionIvaServicio")) {
			sNombreIndice="Tipo=  Por Ret. Iva Servicio";
		} else if(sNombreIndice.equals("PorIdEmpresaPorCodigo")) {
			sNombreIndice="Tipo=  Por Empresa Por Codigo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableCredito(Long id_cuenta_contable_aplicada) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_aplicada!=null) {sDetalleIndice+=" Codigo Unico De Cta. Aplicada="+id_cuenta_contable_aplicada.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableCreditoBien(Long id_cuenta_contable_credito_bien) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_credito_bien!=null) {sDetalleIndice+=" Codigo Unico De Cta. Credito Bien="+id_cuenta_contable_credito_bien.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableCreditoFinServicio(Long id_cuenta_contable_credito_servicio) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_credito_servicio!=null) {sDetalleIndice+=" Codigo Unico De Cta. Credito Servicio="+id_cuenta_contable_credito_servicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableGasto(Long id_cuenta_contable_gasto) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_gasto!=null) {sDetalleIndice+=" Codigo Unico De C. Gasto="+id_cuenta_contable_gasto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoRetencionFuenteBien(Long id_tipo_retencion_fuente_bien) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_retencion_fuente_bien!=null) {sDetalleIndice+=" Codigo Unico De Ret Fuente Bien="+id_tipo_retencion_fuente_bien.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoRetencionFuenteServicio(Long id_tipo_retencion_fuente_servicio) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_retencion_fuente_servicio!=null) {sDetalleIndice+=" Codigo Unico De Ret. Fuente Servicio="+id_tipo_retencion_fuente_servicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoRetencionIvaBien(Long id_tipo_retencion_iva_bien) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_retencion_iva_bien!=null) {sDetalleIndice+=" Codigo Unico De Ret. Iva Bien="+id_tipo_retencion_iva_bien.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoRetencionIvaServicio(Long id_tipo_retencion_iva_servicio) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_retencion_iva_servicio!=null) {sDetalleIndice+=" Codigo Unico De Ret. Iva Servicio="+id_tipo_retencion_iva_servicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorIdEmpresaPorCodigo(Long id_empresa,String codigo) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();}
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPlantillaFactura(PlantillaFactura plantillafactura,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		plantillafactura.setcodigo(plantillafactura.getcodigo().trim());
		plantillafactura.setnombre(plantillafactura.getnombre().trim());
		plantillafactura.setdescripcion(plantillafactura.getdescripcion().trim());
	}
	
	public static void quitarEspaciosPlantillaFacturas(List<PlantillaFactura> plantillafacturas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PlantillaFactura plantillafactura: plantillafacturas) {
			plantillafactura.setcodigo(plantillafactura.getcodigo().trim());
			plantillafactura.setnombre(plantillafactura.getnombre().trim());
			plantillafactura.setdescripcion(plantillafactura.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPlantillaFactura(PlantillaFactura plantillafactura,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && plantillafactura.getConCambioAuxiliar()) {
			plantillafactura.setIsDeleted(plantillafactura.getIsDeletedAuxiliar());	
			plantillafactura.setIsNew(plantillafactura.getIsNewAuxiliar());	
			plantillafactura.setIsChanged(plantillafactura.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			plantillafactura.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			plantillafactura.setIsDeletedAuxiliar(false);	
			plantillafactura.setIsNewAuxiliar(false);	
			plantillafactura.setIsChangedAuxiliar(false);
			
			plantillafactura.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPlantillaFacturas(List<PlantillaFactura> plantillafacturas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PlantillaFactura plantillafactura : plantillafacturas) {
			if(conAsignarBase && plantillafactura.getConCambioAuxiliar()) {
				plantillafactura.setIsDeleted(plantillafactura.getIsDeletedAuxiliar());	
				plantillafactura.setIsNew(plantillafactura.getIsNewAuxiliar());	
				plantillafactura.setIsChanged(plantillafactura.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				plantillafactura.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				plantillafactura.setIsDeletedAuxiliar(false);	
				plantillafactura.setIsNewAuxiliar(false);	
				plantillafactura.setIsChangedAuxiliar(false);
				
				plantillafactura.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPlantillaFactura(PlantillaFactura plantillafactura,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPlantillaFacturas(List<PlantillaFactura> plantillafacturas,Boolean conEnteros) throws Exception  {
		
		for(PlantillaFactura plantillafactura: plantillafacturas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPlantillaFactura(List<PlantillaFactura> plantillafacturas,PlantillaFactura plantillafacturaAux) throws Exception  {
		PlantillaFacturaConstantesFunciones.InicializarValoresPlantillaFactura(plantillafacturaAux,true);
		
		for(PlantillaFactura plantillafactura: plantillafacturas) {
			if(plantillafactura.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPlantillaFactura(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PlantillaFacturaConstantesFunciones.getArrayColumnasGlobalesPlantillaFactura(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPlantillaFactura(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PlantillaFacturaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PlantillaFacturaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPlantillaFactura(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PlantillaFactura> plantillafacturas,PlantillaFactura plantillafactura,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PlantillaFactura plantillafacturaAux: plantillafacturas) {
			if(plantillafacturaAux!=null && plantillafactura!=null) {
				if((plantillafacturaAux.getId()==null && plantillafactura.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(plantillafacturaAux.getId()!=null && plantillafactura.getId()!=null){
					if(plantillafacturaAux.getId().equals(plantillafactura.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPlantillaFactura(List<PlantillaFactura> plantillafacturas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(PlantillaFactura plantillafactura: plantillafacturas) {			
			if(plantillafactura.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPlantillaFactura() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PlantillaFacturaConstantesFunciones.LABEL_ID, PlantillaFacturaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlantillaFacturaConstantesFunciones.LABEL_VERSIONROW, PlantillaFacturaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlantillaFacturaConstantesFunciones.LABEL_IDEMPRESA, PlantillaFacturaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlantillaFacturaConstantesFunciones.LABEL_CODIGO, PlantillaFacturaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlantillaFacturaConstantesFunciones.LABEL_NOMBRE, PlantillaFacturaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlantillaFacturaConstantesFunciones.LABEL_DESCRIPCION, PlantillaFacturaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlantillaFacturaConstantesFunciones.LABEL_ESPROVEEDOR, PlantillaFacturaConstantesFunciones.ESPROVEEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlantillaFacturaConstantesFunciones.LABEL_IDCUENTACONTABLEAPLICADA, PlantillaFacturaConstantesFunciones.IDCUENTACONTABLEAPLICADA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlantillaFacturaConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOBIEN, PlantillaFacturaConstantesFunciones.IDCUENTACONTABLECREDITOBIEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlantillaFacturaConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOSERVICIO, PlantillaFacturaConstantesFunciones.IDCUENTACONTABLECREDITOSERVICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlantillaFacturaConstantesFunciones.LABEL_IDTIPORETENCIONFUENTEBIEN, PlantillaFacturaConstantesFunciones.IDTIPORETENCIONFUENTEBIEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlantillaFacturaConstantesFunciones.LABEL_IDTIPORETENCIONFUENTESERVICIO, PlantillaFacturaConstantesFunciones.IDTIPORETENCIONFUENTESERVICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlantillaFacturaConstantesFunciones.LABEL_IDTIPORETENCIONIVABIEN, PlantillaFacturaConstantesFunciones.IDTIPORETENCIONIVABIEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlantillaFacturaConstantesFunciones.LABEL_IDTIPORETENCIONIVASERVICIO, PlantillaFacturaConstantesFunciones.IDTIPORETENCIONIVASERVICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlantillaFacturaConstantesFunciones.LABEL_IDCUENTACONTABLEGASTO, PlantillaFacturaConstantesFunciones.IDCUENTACONTABLEGASTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPlantillaFactura() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PlantillaFacturaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlantillaFacturaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlantillaFacturaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlantillaFacturaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlantillaFacturaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlantillaFacturaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlantillaFacturaConstantesFunciones.ESPROVEEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlantillaFacturaConstantesFunciones.IDCUENTACONTABLEAPLICADA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlantillaFacturaConstantesFunciones.IDCUENTACONTABLECREDITOBIEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlantillaFacturaConstantesFunciones.IDCUENTACONTABLECREDITOSERVICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlantillaFacturaConstantesFunciones.IDTIPORETENCIONFUENTEBIEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlantillaFacturaConstantesFunciones.IDTIPORETENCIONFUENTESERVICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlantillaFacturaConstantesFunciones.IDTIPORETENCIONIVABIEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlantillaFacturaConstantesFunciones.IDTIPORETENCIONIVASERVICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlantillaFacturaConstantesFunciones.IDCUENTACONTABLEGASTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPlantillaFactura() throws Exception  {
		return PlantillaFacturaConstantesFunciones.getTiposSeleccionarPlantillaFactura(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPlantillaFactura(Boolean conFk) throws Exception  {
		return PlantillaFacturaConstantesFunciones.getTiposSeleccionarPlantillaFactura(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPlantillaFactura(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PlantillaFacturaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PlantillaFacturaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PlantillaFacturaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(PlantillaFacturaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PlantillaFacturaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(PlantillaFacturaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PlantillaFacturaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(PlantillaFacturaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PlantillaFacturaConstantesFunciones.LABEL_ESPROVEEDOR);
			reporte.setsDescripcion(PlantillaFacturaConstantesFunciones.LABEL_ESPROVEEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PlantillaFacturaConstantesFunciones.LABEL_IDCUENTACONTABLEAPLICADA);
			reporte.setsDescripcion(PlantillaFacturaConstantesFunciones.LABEL_IDCUENTACONTABLEAPLICADA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PlantillaFacturaConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOBIEN);
			reporte.setsDescripcion(PlantillaFacturaConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOBIEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PlantillaFacturaConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOSERVICIO);
			reporte.setsDescripcion(PlantillaFacturaConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOSERVICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PlantillaFacturaConstantesFunciones.LABEL_IDTIPORETENCIONFUENTEBIEN);
			reporte.setsDescripcion(PlantillaFacturaConstantesFunciones.LABEL_IDTIPORETENCIONFUENTEBIEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PlantillaFacturaConstantesFunciones.LABEL_IDTIPORETENCIONFUENTESERVICIO);
			reporte.setsDescripcion(PlantillaFacturaConstantesFunciones.LABEL_IDTIPORETENCIONFUENTESERVICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PlantillaFacturaConstantesFunciones.LABEL_IDTIPORETENCIONIVABIEN);
			reporte.setsDescripcion(PlantillaFacturaConstantesFunciones.LABEL_IDTIPORETENCIONIVABIEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PlantillaFacturaConstantesFunciones.LABEL_IDTIPORETENCIONIVASERVICIO);
			reporte.setsDescripcion(PlantillaFacturaConstantesFunciones.LABEL_IDTIPORETENCIONIVASERVICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PlantillaFacturaConstantesFunciones.LABEL_IDCUENTACONTABLEGASTO);
			reporte.setsDescripcion(PlantillaFacturaConstantesFunciones.LABEL_IDCUENTACONTABLEGASTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPlantillaFactura(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPlantillaFactura(PlantillaFactura plantillafacturaAux) throws Exception {
		
			plantillafacturaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(plantillafacturaAux.getEmpresa()));
			plantillafacturaAux.setcuentacontableaplicada_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(plantillafacturaAux.getCuentaContableAplicada()));
			plantillafacturaAux.setcuentacontablecreditobien_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(plantillafacturaAux.getCuentaContableCreditoBien()));
			plantillafacturaAux.setcuentacontablecreditoservicio_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(plantillafacturaAux.getCuentaContableCreditoServicio()));
			plantillafacturaAux.settiporetencionfuentebien_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(plantillafacturaAux.getTipoRetencionFuenteBien()));
			plantillafacturaAux.settiporetencionfuenteservicio_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(plantillafacturaAux.getTipoRetencionFuenteServicio()));
			plantillafacturaAux.settiporetencionivabien_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(plantillafacturaAux.getTipoRetencionIvaBien()));
			plantillafacturaAux.settiporetencionivaservicio_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(plantillafacturaAux.getTipoRetencionIvaServicio()));
			plantillafacturaAux.setcuentacontablegasto_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(plantillafacturaAux.getCuentaContableGasto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPlantillaFactura(List<PlantillaFactura> plantillafacturasTemp) throws Exception {
		for(PlantillaFactura plantillafacturaAux:plantillafacturasTemp) {
			
			plantillafacturaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(plantillafacturaAux.getEmpresa()));
			plantillafacturaAux.setcuentacontableaplicada_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(plantillafacturaAux.getCuentaContableAplicada()));
			plantillafacturaAux.setcuentacontablecreditobien_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(plantillafacturaAux.getCuentaContableCreditoBien()));
			plantillafacturaAux.setcuentacontablecreditoservicio_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(plantillafacturaAux.getCuentaContableCreditoServicio()));
			plantillafacturaAux.settiporetencionfuentebien_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(plantillafacturaAux.getTipoRetencionFuenteBien()));
			plantillafacturaAux.settiporetencionfuenteservicio_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(plantillafacturaAux.getTipoRetencionFuenteServicio()));
			plantillafacturaAux.settiporetencionivabien_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(plantillafacturaAux.getTipoRetencionIvaBien()));
			plantillafacturaAux.settiporetencionivaservicio_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(plantillafacturaAux.getTipoRetencionIvaServicio()));
			plantillafacturaAux.setcuentacontablegasto_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(plantillafacturaAux.getCuentaContableGasto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPlantillaFactura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(TipoRetencion.class));
				classes.add(new Classe(TipoRetencion.class));
				classes.add(new Classe(TipoRetencion.class));
				classes.add(new Classe(TipoRetencion.class));
				classes.add(new Classe(CuentaContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoRetencion.class)) {
						classes.add(new Classe(TipoRetencion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoRetencion.class)) {
						classes.add(new Classe(TipoRetencion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoRetencion.class)) {
						classes.add(new Classe(TipoRetencion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoRetencion.class)) {
						classes.add(new Classe(TipoRetencion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPlantillaFactura(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPlantillaFactura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PlantillaFacturaConstantesFunciones.getClassesRelationshipsOfPlantillaFactura(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPlantillaFactura(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(FacturaProveedor.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(FacturaProveedor.class)) {
						classes.add(new Classe(FacturaProveedor.class)); break;
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPlantillaFactura(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PlantillaFacturaConstantesFunciones.getClassesRelationshipsFromStringsOfPlantillaFactura(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPlantillaFactura(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(FacturaProveedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FacturaProveedor.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(FacturaProveedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FacturaProveedor.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}		
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(PlantillaFactura plantillafactura,List<PlantillaFactura> plantillafacturas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PlantillaFactura plantillafacturaEncontrado=null;
			
			for(PlantillaFactura plantillafacturaLocal:plantillafacturas) {
				if(plantillafacturaLocal.getId().equals(plantillafactura.getId())) {
					plantillafacturaEncontrado=plantillafacturaLocal;
					
					plantillafacturaLocal.setIsChanged(plantillafactura.getIsChanged());
					plantillafacturaLocal.setIsNew(plantillafactura.getIsNew());
					plantillafacturaLocal.setIsDeleted(plantillafactura.getIsDeleted());
					
					plantillafacturaLocal.setGeneralEntityOriginal(plantillafactura.getGeneralEntityOriginal());
					
					plantillafacturaLocal.setId(plantillafactura.getId());	
					plantillafacturaLocal.setVersionRow(plantillafactura.getVersionRow());	
					plantillafacturaLocal.setid_empresa(plantillafactura.getid_empresa());	
					plantillafacturaLocal.setcodigo(plantillafactura.getcodigo());	
					plantillafacturaLocal.setnombre(plantillafactura.getnombre());	
					plantillafacturaLocal.setdescripcion(plantillafactura.getdescripcion());	
					plantillafacturaLocal.setes_proveedor(plantillafactura.getes_proveedor());	
					plantillafacturaLocal.setid_cuenta_contable_aplicada(plantillafactura.getid_cuenta_contable_aplicada());	
					plantillafacturaLocal.setid_cuenta_contable_credito_bien(plantillafactura.getid_cuenta_contable_credito_bien());	
					plantillafacturaLocal.setid_cuenta_contable_credito_servicio(plantillafactura.getid_cuenta_contable_credito_servicio());	
					plantillafacturaLocal.setid_tipo_retencion_fuente_bien(plantillafactura.getid_tipo_retencion_fuente_bien());	
					plantillafacturaLocal.setid_tipo_retencion_fuente_servicio(plantillafactura.getid_tipo_retencion_fuente_servicio());	
					plantillafacturaLocal.setid_tipo_retencion_iva_bien(plantillafactura.getid_tipo_retencion_iva_bien());	
					plantillafacturaLocal.setid_tipo_retencion_iva_servicio(plantillafactura.getid_tipo_retencion_iva_servicio());	
					plantillafacturaLocal.setid_cuenta_contable_gasto(plantillafactura.getid_cuenta_contable_gasto());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!plantillafactura.getIsDeleted()) {
				if(!existe) {
					plantillafacturas.add(plantillafactura);
				}
			} else {
				if(plantillafacturaEncontrado!=null && permiteQuitar)  {
					plantillafacturas.remove(plantillafacturaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PlantillaFactura plantillafactura,List<PlantillaFactura> plantillafacturas) throws Exception {
		try	{			
			for(PlantillaFactura plantillafacturaLocal:plantillafacturas) {
				if(plantillafacturaLocal.getId().equals(plantillafactura.getId())) {
					plantillafacturaLocal.setIsSelected(plantillafactura.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPlantillaFactura(List<PlantillaFactura> plantillafacturasAux) throws Exception {
		//this.plantillafacturasAux=plantillafacturasAux;
		
		for(PlantillaFactura plantillafacturaAux:plantillafacturasAux) {
			if(plantillafacturaAux.getIsChanged()) {
				plantillafacturaAux.setIsChanged(false);
			}		
			
			if(plantillafacturaAux.getIsNew()) {
				plantillafacturaAux.setIsNew(false);
			}	
			
			if(plantillafacturaAux.getIsDeleted()) {
				plantillafacturaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPlantillaFactura(PlantillaFactura plantillafacturaAux) throws Exception {
		//this.plantillafacturaAux=plantillafacturaAux;
		
			if(plantillafacturaAux.getIsChanged()) {
				plantillafacturaAux.setIsChanged(false);
			}		
			
			if(plantillafacturaAux.getIsNew()) {
				plantillafacturaAux.setIsNew(false);
			}	
			
			if(plantillafacturaAux.getIsDeleted()) {
				plantillafacturaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PlantillaFactura plantillafacturaAsignar,PlantillaFactura plantillafactura) throws Exception {
		plantillafacturaAsignar.setId(plantillafactura.getId());	
		plantillafacturaAsignar.setVersionRow(plantillafactura.getVersionRow());	
		plantillafacturaAsignar.setid_empresa(plantillafactura.getid_empresa());
		plantillafacturaAsignar.setempresa_descripcion(plantillafactura.getempresa_descripcion());	
		plantillafacturaAsignar.setcodigo(plantillafactura.getcodigo());	
		plantillafacturaAsignar.setnombre(plantillafactura.getnombre());	
		plantillafacturaAsignar.setdescripcion(plantillafactura.getdescripcion());	
		plantillafacturaAsignar.setes_proveedor(plantillafactura.getes_proveedor());	
		plantillafacturaAsignar.setid_cuenta_contable_aplicada(plantillafactura.getid_cuenta_contable_aplicada());
		plantillafacturaAsignar.setcuentacontableaplicada_descripcion(plantillafactura.getcuentacontableaplicada_descripcion());	
		plantillafacturaAsignar.setid_cuenta_contable_credito_bien(plantillafactura.getid_cuenta_contable_credito_bien());
		plantillafacturaAsignar.setcuentacontablecreditobien_descripcion(plantillafactura.getcuentacontablecreditobien_descripcion());	
		plantillafacturaAsignar.setid_cuenta_contable_credito_servicio(plantillafactura.getid_cuenta_contable_credito_servicio());
		plantillafacturaAsignar.setcuentacontablecreditoservicio_descripcion(plantillafactura.getcuentacontablecreditoservicio_descripcion());	
		plantillafacturaAsignar.setid_tipo_retencion_fuente_bien(plantillafactura.getid_tipo_retencion_fuente_bien());
		plantillafacturaAsignar.settiporetencionfuentebien_descripcion(plantillafactura.gettiporetencionfuentebien_descripcion());	
		plantillafacturaAsignar.setid_tipo_retencion_fuente_servicio(plantillafactura.getid_tipo_retencion_fuente_servicio());
		plantillafacturaAsignar.settiporetencionfuenteservicio_descripcion(plantillafactura.gettiporetencionfuenteservicio_descripcion());	
		plantillafacturaAsignar.setid_tipo_retencion_iva_bien(plantillafactura.getid_tipo_retencion_iva_bien());
		plantillafacturaAsignar.settiporetencionivabien_descripcion(plantillafactura.gettiporetencionivabien_descripcion());	
		plantillafacturaAsignar.setid_tipo_retencion_iva_servicio(plantillafactura.getid_tipo_retencion_iva_servicio());
		plantillafacturaAsignar.settiporetencionivaservicio_descripcion(plantillafactura.gettiporetencionivaservicio_descripcion());	
		plantillafacturaAsignar.setid_cuenta_contable_gasto(plantillafactura.getid_cuenta_contable_gasto());
		plantillafacturaAsignar.setcuentacontablegasto_descripcion(plantillafactura.getcuentacontablegasto_descripcion());	
	}
	
	public static void inicializarPlantillaFactura(PlantillaFactura plantillafactura) throws Exception {
		try {
				plantillafactura.setId(0L);	
					
				plantillafactura.setid_empresa(-1L);	
				plantillafactura.setcodigo("");	
				plantillafactura.setnombre("");	
				plantillafactura.setdescripcion("");	
				plantillafactura.setes_proveedor(false);	
				plantillafactura.setid_cuenta_contable_aplicada(null);	
				plantillafactura.setid_cuenta_contable_credito_bien(null);	
				plantillafactura.setid_cuenta_contable_credito_servicio(null);	
				plantillafactura.setid_tipo_retencion_fuente_bien(null);	
				plantillafactura.setid_tipo_retencion_fuente_servicio(null);	
				plantillafactura.setid_tipo_retencion_iva_bien(null);	
				plantillafactura.setid_tipo_retencion_iva_servicio(null);	
				plantillafactura.setid_cuenta_contable_gasto(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPlantillaFactura(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PlantillaFacturaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlantillaFacturaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlantillaFacturaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlantillaFacturaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlantillaFacturaConstantesFunciones.LABEL_ESPROVEEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlantillaFacturaConstantesFunciones.LABEL_IDCUENTACONTABLEAPLICADA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlantillaFacturaConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOBIEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlantillaFacturaConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOSERVICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlantillaFacturaConstantesFunciones.LABEL_IDTIPORETENCIONFUENTEBIEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlantillaFacturaConstantesFunciones.LABEL_IDTIPORETENCIONFUENTESERVICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlantillaFacturaConstantesFunciones.LABEL_IDTIPORETENCIONIVABIEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlantillaFacturaConstantesFunciones.LABEL_IDTIPORETENCIONIVASERVICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlantillaFacturaConstantesFunciones.LABEL_IDCUENTACONTABLEGASTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPlantillaFactura(String sTipo,Row row,Workbook workbook,PlantillaFactura plantillafactura,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(plantillafactura.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(plantillafactura.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(plantillafactura.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(plantillafactura.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(plantillafactura.getes_proveedor()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(plantillafactura.getcuentacontableaplicada_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(plantillafactura.getcuentacontablecreditobien_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(plantillafactura.getcuentacontablecreditoservicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(plantillafactura.gettiporetencionfuentebien_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(plantillafactura.gettiporetencionfuenteservicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(plantillafactura.gettiporetencionivabien_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(plantillafactura.gettiporetencionivaservicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(plantillafactura.getcuentacontablegasto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPlantillaFactura=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPlantillaFactura() {
		return this.sFinalQueryPlantillaFactura;
	}
	
	public void setsFinalQueryPlantillaFactura(String sFinalQueryPlantillaFactura) {
		this.sFinalQueryPlantillaFactura= sFinalQueryPlantillaFactura;
	}
	
	public Border resaltarSeleccionarPlantillaFactura=null;
	
	public Border setResaltarSeleccionarPlantillaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*PlantillaFacturaBeanSwingJInternalFrame plantillafacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//plantillafacturaBeanSwingJInternalFrame.jTtoolBarPlantillaFactura.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPlantillaFactura= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPlantillaFactura() {
		return this.resaltarSeleccionarPlantillaFactura;
	}
	
	public void setResaltarSeleccionarPlantillaFactura(Border borderResaltarSeleccionarPlantillaFactura) {
		this.resaltarSeleccionarPlantillaFactura= borderResaltarSeleccionarPlantillaFactura;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPlantillaFactura=null;
	public Boolean mostraridPlantillaFactura=true;
	public Boolean activaridPlantillaFactura=true;

	public Border resaltarid_empresaPlantillaFactura=null;
	public Boolean mostrarid_empresaPlantillaFactura=true;
	public Boolean activarid_empresaPlantillaFactura=true;
	public Boolean cargarid_empresaPlantillaFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPlantillaFactura=false;//ConEventDepend=true

	public Border resaltarcodigoPlantillaFactura=null;
	public Boolean mostrarcodigoPlantillaFactura=true;
	public Boolean activarcodigoPlantillaFactura=true;

	public Border resaltarnombrePlantillaFactura=null;
	public Boolean mostrarnombrePlantillaFactura=true;
	public Boolean activarnombrePlantillaFactura=true;

	public Border resaltardescripcionPlantillaFactura=null;
	public Boolean mostrardescripcionPlantillaFactura=true;
	public Boolean activardescripcionPlantillaFactura=true;

	public Border resaltares_proveedorPlantillaFactura=null;
	public Boolean mostrares_proveedorPlantillaFactura=true;
	public Boolean activares_proveedorPlantillaFactura=true;

	public Border resaltarid_cuenta_contable_aplicadaPlantillaFactura=null;
	public Boolean mostrarid_cuenta_contable_aplicadaPlantillaFactura=true;
	public Boolean activarid_cuenta_contable_aplicadaPlantillaFactura=true;
	public Boolean cargarid_cuenta_contable_aplicadaPlantillaFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_aplicadaPlantillaFactura=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_credito_bienPlantillaFactura=null;
	public Boolean mostrarid_cuenta_contable_credito_bienPlantillaFactura=true;
	public Boolean activarid_cuenta_contable_credito_bienPlantillaFactura=true;
	public Boolean cargarid_cuenta_contable_credito_bienPlantillaFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_credito_bienPlantillaFactura=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_credito_servicioPlantillaFactura=null;
	public Boolean mostrarid_cuenta_contable_credito_servicioPlantillaFactura=true;
	public Boolean activarid_cuenta_contable_credito_servicioPlantillaFactura=true;
	public Boolean cargarid_cuenta_contable_credito_servicioPlantillaFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_credito_servicioPlantillaFactura=false;//ConEventDepend=true

	public Border resaltarid_tipo_retencion_fuente_bienPlantillaFactura=null;
	public Boolean mostrarid_tipo_retencion_fuente_bienPlantillaFactura=true;
	public Boolean activarid_tipo_retencion_fuente_bienPlantillaFactura=true;
	public Boolean cargarid_tipo_retencion_fuente_bienPlantillaFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_retencion_fuente_bienPlantillaFactura=false;//ConEventDepend=true

	public Border resaltarid_tipo_retencion_fuente_servicioPlantillaFactura=null;
	public Boolean mostrarid_tipo_retencion_fuente_servicioPlantillaFactura=true;
	public Boolean activarid_tipo_retencion_fuente_servicioPlantillaFactura=true;
	public Boolean cargarid_tipo_retencion_fuente_servicioPlantillaFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_retencion_fuente_servicioPlantillaFactura=false;//ConEventDepend=true

	public Border resaltarid_tipo_retencion_iva_bienPlantillaFactura=null;
	public Boolean mostrarid_tipo_retencion_iva_bienPlantillaFactura=true;
	public Boolean activarid_tipo_retencion_iva_bienPlantillaFactura=true;
	public Boolean cargarid_tipo_retencion_iva_bienPlantillaFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_retencion_iva_bienPlantillaFactura=false;//ConEventDepend=true

	public Border resaltarid_tipo_retencion_iva_servicioPlantillaFactura=null;
	public Boolean mostrarid_tipo_retencion_iva_servicioPlantillaFactura=true;
	public Boolean activarid_tipo_retencion_iva_servicioPlantillaFactura=true;
	public Boolean cargarid_tipo_retencion_iva_servicioPlantillaFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_retencion_iva_servicioPlantillaFactura=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_gastoPlantillaFactura=null;
	public Boolean mostrarid_cuenta_contable_gastoPlantillaFactura=true;
	public Boolean activarid_cuenta_contable_gastoPlantillaFactura=false;
	public Boolean cargarid_cuenta_contable_gastoPlantillaFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_gastoPlantillaFactura=false;//ConEventDepend=true

	
	

	public Border setResaltaridPlantillaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*PlantillaFacturaBeanSwingJInternalFrame plantillafacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//plantillafacturaBeanSwingJInternalFrame.jTtoolBarPlantillaFactura.setBorder(borderResaltar);
		
		this.resaltaridPlantillaFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPlantillaFactura() {
		return this.resaltaridPlantillaFactura;
	}

	public void setResaltaridPlantillaFactura(Border borderResaltar) {
		this.resaltaridPlantillaFactura= borderResaltar;
	}

	public Boolean getMostraridPlantillaFactura() {
		return this.mostraridPlantillaFactura;
	}

	public void setMostraridPlantillaFactura(Boolean mostraridPlantillaFactura) {
		this.mostraridPlantillaFactura= mostraridPlantillaFactura;
	}

	public Boolean getActivaridPlantillaFactura() {
		return this.activaridPlantillaFactura;
	}

	public void setActivaridPlantillaFactura(Boolean activaridPlantillaFactura) {
		this.activaridPlantillaFactura= activaridPlantillaFactura;
	}

	public Border setResaltarid_empresaPlantillaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*PlantillaFacturaBeanSwingJInternalFrame plantillafacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//plantillafacturaBeanSwingJInternalFrame.jTtoolBarPlantillaFactura.setBorder(borderResaltar);
		
		this.resaltarid_empresaPlantillaFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPlantillaFactura() {
		return this.resaltarid_empresaPlantillaFactura;
	}

	public void setResaltarid_empresaPlantillaFactura(Border borderResaltar) {
		this.resaltarid_empresaPlantillaFactura= borderResaltar;
	}

	public Boolean getMostrarid_empresaPlantillaFactura() {
		return this.mostrarid_empresaPlantillaFactura;
	}

	public void setMostrarid_empresaPlantillaFactura(Boolean mostrarid_empresaPlantillaFactura) {
		this.mostrarid_empresaPlantillaFactura= mostrarid_empresaPlantillaFactura;
	}

	public Boolean getActivarid_empresaPlantillaFactura() {
		return this.activarid_empresaPlantillaFactura;
	}

	public void setActivarid_empresaPlantillaFactura(Boolean activarid_empresaPlantillaFactura) {
		this.activarid_empresaPlantillaFactura= activarid_empresaPlantillaFactura;
	}

	public Boolean getCargarid_empresaPlantillaFactura() {
		return this.cargarid_empresaPlantillaFactura;
	}

	public void setCargarid_empresaPlantillaFactura(Boolean cargarid_empresaPlantillaFactura) {
		this.cargarid_empresaPlantillaFactura= cargarid_empresaPlantillaFactura;
	}

	public Border setResaltarcodigoPlantillaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*PlantillaFacturaBeanSwingJInternalFrame plantillafacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//plantillafacturaBeanSwingJInternalFrame.jTtoolBarPlantillaFactura.setBorder(borderResaltar);
		
		this.resaltarcodigoPlantillaFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoPlantillaFactura() {
		return this.resaltarcodigoPlantillaFactura;
	}

	public void setResaltarcodigoPlantillaFactura(Border borderResaltar) {
		this.resaltarcodigoPlantillaFactura= borderResaltar;
	}

	public Boolean getMostrarcodigoPlantillaFactura() {
		return this.mostrarcodigoPlantillaFactura;
	}

	public void setMostrarcodigoPlantillaFactura(Boolean mostrarcodigoPlantillaFactura) {
		this.mostrarcodigoPlantillaFactura= mostrarcodigoPlantillaFactura;
	}

	public Boolean getActivarcodigoPlantillaFactura() {
		return this.activarcodigoPlantillaFactura;
	}

	public void setActivarcodigoPlantillaFactura(Boolean activarcodigoPlantillaFactura) {
		this.activarcodigoPlantillaFactura= activarcodigoPlantillaFactura;
	}

	public Border setResaltarnombrePlantillaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*PlantillaFacturaBeanSwingJInternalFrame plantillafacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//plantillafacturaBeanSwingJInternalFrame.jTtoolBarPlantillaFactura.setBorder(borderResaltar);
		
		this.resaltarnombrePlantillaFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombrePlantillaFactura() {
		return this.resaltarnombrePlantillaFactura;
	}

	public void setResaltarnombrePlantillaFactura(Border borderResaltar) {
		this.resaltarnombrePlantillaFactura= borderResaltar;
	}

	public Boolean getMostrarnombrePlantillaFactura() {
		return this.mostrarnombrePlantillaFactura;
	}

	public void setMostrarnombrePlantillaFactura(Boolean mostrarnombrePlantillaFactura) {
		this.mostrarnombrePlantillaFactura= mostrarnombrePlantillaFactura;
	}

	public Boolean getActivarnombrePlantillaFactura() {
		return this.activarnombrePlantillaFactura;
	}

	public void setActivarnombrePlantillaFactura(Boolean activarnombrePlantillaFactura) {
		this.activarnombrePlantillaFactura= activarnombrePlantillaFactura;
	}

	public Border setResaltardescripcionPlantillaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*PlantillaFacturaBeanSwingJInternalFrame plantillafacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//plantillafacturaBeanSwingJInternalFrame.jTtoolBarPlantillaFactura.setBorder(borderResaltar);
		
		this.resaltardescripcionPlantillaFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionPlantillaFactura() {
		return this.resaltardescripcionPlantillaFactura;
	}

	public void setResaltardescripcionPlantillaFactura(Border borderResaltar) {
		this.resaltardescripcionPlantillaFactura= borderResaltar;
	}

	public Boolean getMostrardescripcionPlantillaFactura() {
		return this.mostrardescripcionPlantillaFactura;
	}

	public void setMostrardescripcionPlantillaFactura(Boolean mostrardescripcionPlantillaFactura) {
		this.mostrardescripcionPlantillaFactura= mostrardescripcionPlantillaFactura;
	}

	public Boolean getActivardescripcionPlantillaFactura() {
		return this.activardescripcionPlantillaFactura;
	}

	public void setActivardescripcionPlantillaFactura(Boolean activardescripcionPlantillaFactura) {
		this.activardescripcionPlantillaFactura= activardescripcionPlantillaFactura;
	}

	public Border setResaltares_proveedorPlantillaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*PlantillaFacturaBeanSwingJInternalFrame plantillafacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//plantillafacturaBeanSwingJInternalFrame.jTtoolBarPlantillaFactura.setBorder(borderResaltar);
		
		this.resaltares_proveedorPlantillaFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_proveedorPlantillaFactura() {
		return this.resaltares_proveedorPlantillaFactura;
	}

	public void setResaltares_proveedorPlantillaFactura(Border borderResaltar) {
		this.resaltares_proveedorPlantillaFactura= borderResaltar;
	}

	public Boolean getMostrares_proveedorPlantillaFactura() {
		return this.mostrares_proveedorPlantillaFactura;
	}

	public void setMostrares_proveedorPlantillaFactura(Boolean mostrares_proveedorPlantillaFactura) {
		this.mostrares_proveedorPlantillaFactura= mostrares_proveedorPlantillaFactura;
	}

	public Boolean getActivares_proveedorPlantillaFactura() {
		return this.activares_proveedorPlantillaFactura;
	}

	public void setActivares_proveedorPlantillaFactura(Boolean activares_proveedorPlantillaFactura) {
		this.activares_proveedorPlantillaFactura= activares_proveedorPlantillaFactura;
	}

	public Border setResaltarid_cuenta_contable_aplicadaPlantillaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*PlantillaFacturaBeanSwingJInternalFrame plantillafacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//plantillafacturaBeanSwingJInternalFrame.jTtoolBarPlantillaFactura.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_aplicadaPlantillaFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_aplicadaPlantillaFactura() {
		return this.resaltarid_cuenta_contable_aplicadaPlantillaFactura;
	}

	public void setResaltarid_cuenta_contable_aplicadaPlantillaFactura(Border borderResaltar) {
		this.resaltarid_cuenta_contable_aplicadaPlantillaFactura= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_aplicadaPlantillaFactura() {
		return this.mostrarid_cuenta_contable_aplicadaPlantillaFactura;
	}

	public void setMostrarid_cuenta_contable_aplicadaPlantillaFactura(Boolean mostrarid_cuenta_contable_aplicadaPlantillaFactura) {
		this.mostrarid_cuenta_contable_aplicadaPlantillaFactura= mostrarid_cuenta_contable_aplicadaPlantillaFactura;
	}

	public Boolean getActivarid_cuenta_contable_aplicadaPlantillaFactura() {
		return this.activarid_cuenta_contable_aplicadaPlantillaFactura;
	}

	public void setActivarid_cuenta_contable_aplicadaPlantillaFactura(Boolean activarid_cuenta_contable_aplicadaPlantillaFactura) {
		this.activarid_cuenta_contable_aplicadaPlantillaFactura= activarid_cuenta_contable_aplicadaPlantillaFactura;
	}

	public Boolean getCargarid_cuenta_contable_aplicadaPlantillaFactura() {
		return this.cargarid_cuenta_contable_aplicadaPlantillaFactura;
	}

	public void setCargarid_cuenta_contable_aplicadaPlantillaFactura(Boolean cargarid_cuenta_contable_aplicadaPlantillaFactura) {
		this.cargarid_cuenta_contable_aplicadaPlantillaFactura= cargarid_cuenta_contable_aplicadaPlantillaFactura;
	}

	public Border setResaltarid_cuenta_contable_credito_bienPlantillaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*PlantillaFacturaBeanSwingJInternalFrame plantillafacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//plantillafacturaBeanSwingJInternalFrame.jTtoolBarPlantillaFactura.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_credito_bienPlantillaFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_credito_bienPlantillaFactura() {
		return this.resaltarid_cuenta_contable_credito_bienPlantillaFactura;
	}

	public void setResaltarid_cuenta_contable_credito_bienPlantillaFactura(Border borderResaltar) {
		this.resaltarid_cuenta_contable_credito_bienPlantillaFactura= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_credito_bienPlantillaFactura() {
		return this.mostrarid_cuenta_contable_credito_bienPlantillaFactura;
	}

	public void setMostrarid_cuenta_contable_credito_bienPlantillaFactura(Boolean mostrarid_cuenta_contable_credito_bienPlantillaFactura) {
		this.mostrarid_cuenta_contable_credito_bienPlantillaFactura= mostrarid_cuenta_contable_credito_bienPlantillaFactura;
	}

	public Boolean getActivarid_cuenta_contable_credito_bienPlantillaFactura() {
		return this.activarid_cuenta_contable_credito_bienPlantillaFactura;
	}

	public void setActivarid_cuenta_contable_credito_bienPlantillaFactura(Boolean activarid_cuenta_contable_credito_bienPlantillaFactura) {
		this.activarid_cuenta_contable_credito_bienPlantillaFactura= activarid_cuenta_contable_credito_bienPlantillaFactura;
	}

	public Boolean getCargarid_cuenta_contable_credito_bienPlantillaFactura() {
		return this.cargarid_cuenta_contable_credito_bienPlantillaFactura;
	}

	public void setCargarid_cuenta_contable_credito_bienPlantillaFactura(Boolean cargarid_cuenta_contable_credito_bienPlantillaFactura) {
		this.cargarid_cuenta_contable_credito_bienPlantillaFactura= cargarid_cuenta_contable_credito_bienPlantillaFactura;
	}

	public Border setResaltarid_cuenta_contable_credito_servicioPlantillaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*PlantillaFacturaBeanSwingJInternalFrame plantillafacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//plantillafacturaBeanSwingJInternalFrame.jTtoolBarPlantillaFactura.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_credito_servicioPlantillaFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_credito_servicioPlantillaFactura() {
		return this.resaltarid_cuenta_contable_credito_servicioPlantillaFactura;
	}

	public void setResaltarid_cuenta_contable_credito_servicioPlantillaFactura(Border borderResaltar) {
		this.resaltarid_cuenta_contable_credito_servicioPlantillaFactura= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_credito_servicioPlantillaFactura() {
		return this.mostrarid_cuenta_contable_credito_servicioPlantillaFactura;
	}

	public void setMostrarid_cuenta_contable_credito_servicioPlantillaFactura(Boolean mostrarid_cuenta_contable_credito_servicioPlantillaFactura) {
		this.mostrarid_cuenta_contable_credito_servicioPlantillaFactura= mostrarid_cuenta_contable_credito_servicioPlantillaFactura;
	}

	public Boolean getActivarid_cuenta_contable_credito_servicioPlantillaFactura() {
		return this.activarid_cuenta_contable_credito_servicioPlantillaFactura;
	}

	public void setActivarid_cuenta_contable_credito_servicioPlantillaFactura(Boolean activarid_cuenta_contable_credito_servicioPlantillaFactura) {
		this.activarid_cuenta_contable_credito_servicioPlantillaFactura= activarid_cuenta_contable_credito_servicioPlantillaFactura;
	}

	public Boolean getCargarid_cuenta_contable_credito_servicioPlantillaFactura() {
		return this.cargarid_cuenta_contable_credito_servicioPlantillaFactura;
	}

	public void setCargarid_cuenta_contable_credito_servicioPlantillaFactura(Boolean cargarid_cuenta_contable_credito_servicioPlantillaFactura) {
		this.cargarid_cuenta_contable_credito_servicioPlantillaFactura= cargarid_cuenta_contable_credito_servicioPlantillaFactura;
	}

	public Border setResaltarid_tipo_retencion_fuente_bienPlantillaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*PlantillaFacturaBeanSwingJInternalFrame plantillafacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//plantillafacturaBeanSwingJInternalFrame.jTtoolBarPlantillaFactura.setBorder(borderResaltar);
		
		this.resaltarid_tipo_retencion_fuente_bienPlantillaFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_retencion_fuente_bienPlantillaFactura() {
		return this.resaltarid_tipo_retencion_fuente_bienPlantillaFactura;
	}

	public void setResaltarid_tipo_retencion_fuente_bienPlantillaFactura(Border borderResaltar) {
		this.resaltarid_tipo_retencion_fuente_bienPlantillaFactura= borderResaltar;
	}

	public Boolean getMostrarid_tipo_retencion_fuente_bienPlantillaFactura() {
		return this.mostrarid_tipo_retencion_fuente_bienPlantillaFactura;
	}

	public void setMostrarid_tipo_retencion_fuente_bienPlantillaFactura(Boolean mostrarid_tipo_retencion_fuente_bienPlantillaFactura) {
		this.mostrarid_tipo_retencion_fuente_bienPlantillaFactura= mostrarid_tipo_retencion_fuente_bienPlantillaFactura;
	}

	public Boolean getActivarid_tipo_retencion_fuente_bienPlantillaFactura() {
		return this.activarid_tipo_retencion_fuente_bienPlantillaFactura;
	}

	public void setActivarid_tipo_retencion_fuente_bienPlantillaFactura(Boolean activarid_tipo_retencion_fuente_bienPlantillaFactura) {
		this.activarid_tipo_retencion_fuente_bienPlantillaFactura= activarid_tipo_retencion_fuente_bienPlantillaFactura;
	}

	public Boolean getCargarid_tipo_retencion_fuente_bienPlantillaFactura() {
		return this.cargarid_tipo_retencion_fuente_bienPlantillaFactura;
	}

	public void setCargarid_tipo_retencion_fuente_bienPlantillaFactura(Boolean cargarid_tipo_retencion_fuente_bienPlantillaFactura) {
		this.cargarid_tipo_retencion_fuente_bienPlantillaFactura= cargarid_tipo_retencion_fuente_bienPlantillaFactura;
	}

	public Border setResaltarid_tipo_retencion_fuente_servicioPlantillaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*PlantillaFacturaBeanSwingJInternalFrame plantillafacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//plantillafacturaBeanSwingJInternalFrame.jTtoolBarPlantillaFactura.setBorder(borderResaltar);
		
		this.resaltarid_tipo_retencion_fuente_servicioPlantillaFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_retencion_fuente_servicioPlantillaFactura() {
		return this.resaltarid_tipo_retencion_fuente_servicioPlantillaFactura;
	}

	public void setResaltarid_tipo_retencion_fuente_servicioPlantillaFactura(Border borderResaltar) {
		this.resaltarid_tipo_retencion_fuente_servicioPlantillaFactura= borderResaltar;
	}

	public Boolean getMostrarid_tipo_retencion_fuente_servicioPlantillaFactura() {
		return this.mostrarid_tipo_retencion_fuente_servicioPlantillaFactura;
	}

	public void setMostrarid_tipo_retencion_fuente_servicioPlantillaFactura(Boolean mostrarid_tipo_retencion_fuente_servicioPlantillaFactura) {
		this.mostrarid_tipo_retencion_fuente_servicioPlantillaFactura= mostrarid_tipo_retencion_fuente_servicioPlantillaFactura;
	}

	public Boolean getActivarid_tipo_retencion_fuente_servicioPlantillaFactura() {
		return this.activarid_tipo_retencion_fuente_servicioPlantillaFactura;
	}

	public void setActivarid_tipo_retencion_fuente_servicioPlantillaFactura(Boolean activarid_tipo_retencion_fuente_servicioPlantillaFactura) {
		this.activarid_tipo_retencion_fuente_servicioPlantillaFactura= activarid_tipo_retencion_fuente_servicioPlantillaFactura;
	}

	public Boolean getCargarid_tipo_retencion_fuente_servicioPlantillaFactura() {
		return this.cargarid_tipo_retencion_fuente_servicioPlantillaFactura;
	}

	public void setCargarid_tipo_retencion_fuente_servicioPlantillaFactura(Boolean cargarid_tipo_retencion_fuente_servicioPlantillaFactura) {
		this.cargarid_tipo_retencion_fuente_servicioPlantillaFactura= cargarid_tipo_retencion_fuente_servicioPlantillaFactura;
	}

	public Border setResaltarid_tipo_retencion_iva_bienPlantillaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*PlantillaFacturaBeanSwingJInternalFrame plantillafacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//plantillafacturaBeanSwingJInternalFrame.jTtoolBarPlantillaFactura.setBorder(borderResaltar);
		
		this.resaltarid_tipo_retencion_iva_bienPlantillaFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_retencion_iva_bienPlantillaFactura() {
		return this.resaltarid_tipo_retencion_iva_bienPlantillaFactura;
	}

	public void setResaltarid_tipo_retencion_iva_bienPlantillaFactura(Border borderResaltar) {
		this.resaltarid_tipo_retencion_iva_bienPlantillaFactura= borderResaltar;
	}

	public Boolean getMostrarid_tipo_retencion_iva_bienPlantillaFactura() {
		return this.mostrarid_tipo_retencion_iva_bienPlantillaFactura;
	}

	public void setMostrarid_tipo_retencion_iva_bienPlantillaFactura(Boolean mostrarid_tipo_retencion_iva_bienPlantillaFactura) {
		this.mostrarid_tipo_retencion_iva_bienPlantillaFactura= mostrarid_tipo_retencion_iva_bienPlantillaFactura;
	}

	public Boolean getActivarid_tipo_retencion_iva_bienPlantillaFactura() {
		return this.activarid_tipo_retencion_iva_bienPlantillaFactura;
	}

	public void setActivarid_tipo_retencion_iva_bienPlantillaFactura(Boolean activarid_tipo_retencion_iva_bienPlantillaFactura) {
		this.activarid_tipo_retencion_iva_bienPlantillaFactura= activarid_tipo_retencion_iva_bienPlantillaFactura;
	}

	public Boolean getCargarid_tipo_retencion_iva_bienPlantillaFactura() {
		return this.cargarid_tipo_retencion_iva_bienPlantillaFactura;
	}

	public void setCargarid_tipo_retencion_iva_bienPlantillaFactura(Boolean cargarid_tipo_retencion_iva_bienPlantillaFactura) {
		this.cargarid_tipo_retencion_iva_bienPlantillaFactura= cargarid_tipo_retencion_iva_bienPlantillaFactura;
	}

	public Border setResaltarid_tipo_retencion_iva_servicioPlantillaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*PlantillaFacturaBeanSwingJInternalFrame plantillafacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//plantillafacturaBeanSwingJInternalFrame.jTtoolBarPlantillaFactura.setBorder(borderResaltar);
		
		this.resaltarid_tipo_retencion_iva_servicioPlantillaFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_retencion_iva_servicioPlantillaFactura() {
		return this.resaltarid_tipo_retencion_iva_servicioPlantillaFactura;
	}

	public void setResaltarid_tipo_retencion_iva_servicioPlantillaFactura(Border borderResaltar) {
		this.resaltarid_tipo_retencion_iva_servicioPlantillaFactura= borderResaltar;
	}

	public Boolean getMostrarid_tipo_retencion_iva_servicioPlantillaFactura() {
		return this.mostrarid_tipo_retencion_iva_servicioPlantillaFactura;
	}

	public void setMostrarid_tipo_retencion_iva_servicioPlantillaFactura(Boolean mostrarid_tipo_retencion_iva_servicioPlantillaFactura) {
		this.mostrarid_tipo_retencion_iva_servicioPlantillaFactura= mostrarid_tipo_retencion_iva_servicioPlantillaFactura;
	}

	public Boolean getActivarid_tipo_retencion_iva_servicioPlantillaFactura() {
		return this.activarid_tipo_retencion_iva_servicioPlantillaFactura;
	}

	public void setActivarid_tipo_retencion_iva_servicioPlantillaFactura(Boolean activarid_tipo_retencion_iva_servicioPlantillaFactura) {
		this.activarid_tipo_retencion_iva_servicioPlantillaFactura= activarid_tipo_retencion_iva_servicioPlantillaFactura;
	}

	public Boolean getCargarid_tipo_retencion_iva_servicioPlantillaFactura() {
		return this.cargarid_tipo_retencion_iva_servicioPlantillaFactura;
	}

	public void setCargarid_tipo_retencion_iva_servicioPlantillaFactura(Boolean cargarid_tipo_retencion_iva_servicioPlantillaFactura) {
		this.cargarid_tipo_retencion_iva_servicioPlantillaFactura= cargarid_tipo_retencion_iva_servicioPlantillaFactura;
	}

	public Border setResaltarid_cuenta_contable_gastoPlantillaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*PlantillaFacturaBeanSwingJInternalFrame plantillafacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//plantillafacturaBeanSwingJInternalFrame.jTtoolBarPlantillaFactura.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_gastoPlantillaFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_gastoPlantillaFactura() {
		return this.resaltarid_cuenta_contable_gastoPlantillaFactura;
	}

	public void setResaltarid_cuenta_contable_gastoPlantillaFactura(Border borderResaltar) {
		this.resaltarid_cuenta_contable_gastoPlantillaFactura= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_gastoPlantillaFactura() {
		return this.mostrarid_cuenta_contable_gastoPlantillaFactura;
	}

	public void setMostrarid_cuenta_contable_gastoPlantillaFactura(Boolean mostrarid_cuenta_contable_gastoPlantillaFactura) {
		this.mostrarid_cuenta_contable_gastoPlantillaFactura= mostrarid_cuenta_contable_gastoPlantillaFactura;
	}

	public Boolean getActivarid_cuenta_contable_gastoPlantillaFactura() {
		return this.activarid_cuenta_contable_gastoPlantillaFactura;
	}

	public void setActivarid_cuenta_contable_gastoPlantillaFactura(Boolean activarid_cuenta_contable_gastoPlantillaFactura) {
		this.activarid_cuenta_contable_gastoPlantillaFactura= activarid_cuenta_contable_gastoPlantillaFactura;
	}

	public Boolean getCargarid_cuenta_contable_gastoPlantillaFactura() {
		return this.cargarid_cuenta_contable_gastoPlantillaFactura;
	}

	public void setCargarid_cuenta_contable_gastoPlantillaFactura(Boolean cargarid_cuenta_contable_gastoPlantillaFactura) {
		this.cargarid_cuenta_contable_gastoPlantillaFactura= cargarid_cuenta_contable_gastoPlantillaFactura;
	}
	
	public void setMostrarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setMostraridPlantillaFactura(esInicial);
		this.setMostrarid_empresaPlantillaFactura(esInicial);
		this.setMostrarcodigoPlantillaFactura(esInicial);
		this.setMostrarnombrePlantillaFactura(esInicial);
		this.setMostrardescripcionPlantillaFactura(esInicial);
		this.setMostrares_proveedorPlantillaFactura(esInicial);
		this.setMostrarid_cuenta_contable_aplicadaPlantillaFactura(esInicial);
		this.setMostrarid_cuenta_contable_credito_bienPlantillaFactura(esInicial);
		this.setMostrarid_cuenta_contable_credito_servicioPlantillaFactura(esInicial);
		this.setMostrarid_tipo_retencion_fuente_bienPlantillaFactura(esInicial);
		this.setMostrarid_tipo_retencion_fuente_servicioPlantillaFactura(esInicial);
		this.setMostrarid_tipo_retencion_iva_bienPlantillaFactura(esInicial);
		this.setMostrarid_tipo_retencion_iva_servicioPlantillaFactura(esInicial);
		this.setMostrarid_cuenta_contable_gastoPlantillaFactura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.ID)) {
				this.setMostraridPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombrePlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.ESPROVEEDOR)) {
				this.setMostrares_proveedorPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.IDCUENTACONTABLEAPLICADA)) {
				this.setMostrarid_cuenta_contable_aplicadaPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.IDCUENTACONTABLECREDITOBIEN)) {
				this.setMostrarid_cuenta_contable_credito_bienPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.IDCUENTACONTABLECREDITOSERVICIO)) {
				this.setMostrarid_cuenta_contable_credito_servicioPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.IDTIPORETENCIONFUENTEBIEN)) {
				this.setMostrarid_tipo_retencion_fuente_bienPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.IDTIPORETENCIONFUENTESERVICIO)) {
				this.setMostrarid_tipo_retencion_fuente_servicioPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.IDTIPORETENCIONIVABIEN)) {
				this.setMostrarid_tipo_retencion_iva_bienPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.IDTIPORETENCIONIVASERVICIO)) {
				this.setMostrarid_tipo_retencion_iva_servicioPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.IDCUENTACONTABLEGASTO)) {
				this.setMostrarid_cuenta_contable_gastoPlantillaFactura(esAsigna);
				continue;
			}
		}
	}
	
	public void setActivarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setActivaridPlantillaFactura(esInicial);
		this.setActivarid_empresaPlantillaFactura(esInicial);
		this.setActivarcodigoPlantillaFactura(esInicial);
		this.setActivarnombrePlantillaFactura(esInicial);
		this.setActivardescripcionPlantillaFactura(esInicial);
		this.setActivares_proveedorPlantillaFactura(esInicial);
		this.setActivarid_cuenta_contable_aplicadaPlantillaFactura(esInicial);
		this.setActivarid_cuenta_contable_credito_bienPlantillaFactura(esInicial);
		this.setActivarid_cuenta_contable_credito_servicioPlantillaFactura(esInicial);
		this.setActivarid_tipo_retencion_fuente_bienPlantillaFactura(esInicial);
		this.setActivarid_tipo_retencion_fuente_servicioPlantillaFactura(esInicial);
		this.setActivarid_tipo_retencion_iva_bienPlantillaFactura(esInicial);
		this.setActivarid_tipo_retencion_iva_servicioPlantillaFactura(esInicial);
		this.setActivarid_cuenta_contable_gastoPlantillaFactura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.ID)) {
				this.setActivaridPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.NOMBRE)) {
				this.setActivarnombrePlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.ESPROVEEDOR)) {
				this.setActivares_proveedorPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.IDCUENTACONTABLEAPLICADA)) {
				this.setActivarid_cuenta_contable_aplicadaPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.IDCUENTACONTABLECREDITOBIEN)) {
				this.setActivarid_cuenta_contable_credito_bienPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.IDCUENTACONTABLECREDITOSERVICIO)) {
				this.setActivarid_cuenta_contable_credito_servicioPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.IDTIPORETENCIONFUENTEBIEN)) {
				this.setActivarid_tipo_retencion_fuente_bienPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.IDTIPORETENCIONFUENTESERVICIO)) {
				this.setActivarid_tipo_retencion_fuente_servicioPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.IDTIPORETENCIONIVABIEN)) {
				this.setActivarid_tipo_retencion_iva_bienPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.IDTIPORETENCIONIVASERVICIO)) {
				this.setActivarid_tipo_retencion_iva_servicioPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.IDCUENTACONTABLEGASTO)) {
				this.setActivarid_cuenta_contable_gastoPlantillaFactura(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PlantillaFacturaBeanSwingJInternalFrame plantillafacturaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPlantillaFactura(esInicial);
		this.setResaltarid_empresaPlantillaFactura(esInicial);
		this.setResaltarcodigoPlantillaFactura(esInicial);
		this.setResaltarnombrePlantillaFactura(esInicial);
		this.setResaltardescripcionPlantillaFactura(esInicial);
		this.setResaltares_proveedorPlantillaFactura(esInicial);
		this.setResaltarid_cuenta_contable_aplicadaPlantillaFactura(esInicial);
		this.setResaltarid_cuenta_contable_credito_bienPlantillaFactura(esInicial);
		this.setResaltarid_cuenta_contable_credito_servicioPlantillaFactura(esInicial);
		this.setResaltarid_tipo_retencion_fuente_bienPlantillaFactura(esInicial);
		this.setResaltarid_tipo_retencion_fuente_servicioPlantillaFactura(esInicial);
		this.setResaltarid_tipo_retencion_iva_bienPlantillaFactura(esInicial);
		this.setResaltarid_tipo_retencion_iva_servicioPlantillaFactura(esInicial);
		this.setResaltarid_cuenta_contable_gastoPlantillaFactura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.ID)) {
				this.setResaltaridPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombrePlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.ESPROVEEDOR)) {
				this.setResaltares_proveedorPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.IDCUENTACONTABLEAPLICADA)) {
				this.setResaltarid_cuenta_contable_aplicadaPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.IDCUENTACONTABLECREDITOBIEN)) {
				this.setResaltarid_cuenta_contable_credito_bienPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.IDCUENTACONTABLECREDITOSERVICIO)) {
				this.setResaltarid_cuenta_contable_credito_servicioPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.IDTIPORETENCIONFUENTEBIEN)) {
				this.setResaltarid_tipo_retencion_fuente_bienPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.IDTIPORETENCIONFUENTESERVICIO)) {
				this.setResaltarid_tipo_retencion_fuente_servicioPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.IDTIPORETENCIONIVABIEN)) {
				this.setResaltarid_tipo_retencion_iva_bienPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.IDTIPORETENCIONIVASERVICIO)) {
				this.setResaltarid_tipo_retencion_iva_servicioPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlantillaFacturaConstantesFunciones.IDCUENTACONTABLEGASTO)) {
				this.setResaltarid_cuenta_contable_gastoPlantillaFactura(esAsigna);
				continue;
			}
		}
	}
	
			
		
	public void setMostrarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}


		for(Classe clase:clases) {
		}		
	}
	
	public void setActivarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}


		for(Classe clase:clases) {
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PlantillaFacturaBeanSwingJInternalFrame plantillafacturaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}


		for(Classe clase:clases) {
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoPlantillaFactura=true;

	public Boolean getMostrarBusquedaPorCodigoPlantillaFactura() {
		return this.mostrarBusquedaPorCodigoPlantillaFactura;
	}

	public void setMostrarBusquedaPorCodigoPlantillaFactura(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoPlantillaFactura= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombrePlantillaFactura=true;

	public Boolean getMostrarBusquedaPorNombrePlantillaFactura() {
		return this.mostrarBusquedaPorNombrePlantillaFactura;
	}

	public void setMostrarBusquedaPorNombrePlantillaFactura(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombrePlantillaFactura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableCreditoBienPlantillaFactura=true;

	public Boolean getMostrarFK_IdCuentaContableCreditoBienPlantillaFactura() {
		return this.mostrarFK_IdCuentaContableCreditoBienPlantillaFactura;
	}

	public void setMostrarFK_IdCuentaContableCreditoBienPlantillaFactura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableCreditoBienPlantillaFactura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableCreditoFinServicioPlantillaFactura=true;

	public Boolean getMostrarFK_IdCuentaContableCreditoFinServicioPlantillaFactura() {
		return this.mostrarFK_IdCuentaContableCreditoFinServicioPlantillaFactura;
	}

	public void setMostrarFK_IdCuentaContableCreditoFinServicioPlantillaFactura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableCreditoFinServicioPlantillaFactura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaPlantillaFactura=true;

	public Boolean getMostrarFK_IdEmpresaPlantillaFactura() {
		return this.mostrarFK_IdEmpresaPlantillaFactura;
	}

	public void setMostrarFK_IdEmpresaPlantillaFactura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaPlantillaFactura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoRetencionFuenteBienPlantillaFactura=true;

	public Boolean getMostrarFK_IdTipoRetencionFuenteBienPlantillaFactura() {
		return this.mostrarFK_IdTipoRetencionFuenteBienPlantillaFactura;
	}

	public void setMostrarFK_IdTipoRetencionFuenteBienPlantillaFactura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoRetencionFuenteBienPlantillaFactura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoRetencionFuenteServicioPlantillaFactura=true;

	public Boolean getMostrarFK_IdTipoRetencionFuenteServicioPlantillaFactura() {
		return this.mostrarFK_IdTipoRetencionFuenteServicioPlantillaFactura;
	}

	public void setMostrarFK_IdTipoRetencionFuenteServicioPlantillaFactura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoRetencionFuenteServicioPlantillaFactura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoRetencionIvaBienPlantillaFactura=true;

	public Boolean getMostrarFK_IdTipoRetencionIvaBienPlantillaFactura() {
		return this.mostrarFK_IdTipoRetencionIvaBienPlantillaFactura;
	}

	public void setMostrarFK_IdTipoRetencionIvaBienPlantillaFactura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoRetencionIvaBienPlantillaFactura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoRetencionIvaServicioPlantillaFactura=true;

	public Boolean getMostrarFK_IdTipoRetencionIvaServicioPlantillaFactura() {
		return this.mostrarFK_IdTipoRetencionIvaServicioPlantillaFactura;
	}

	public void setMostrarFK_IdTipoRetencionIvaServicioPlantillaFactura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoRetencionIvaServicioPlantillaFactura= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoPlantillaFactura=true;

	public Boolean getActivarBusquedaPorCodigoPlantillaFactura() {
		return this.activarBusquedaPorCodigoPlantillaFactura;
	}

	public void setActivarBusquedaPorCodigoPlantillaFactura(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoPlantillaFactura= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombrePlantillaFactura=true;

	public Boolean getActivarBusquedaPorNombrePlantillaFactura() {
		return this.activarBusquedaPorNombrePlantillaFactura;
	}

	public void setActivarBusquedaPorNombrePlantillaFactura(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombrePlantillaFactura= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableCreditoBienPlantillaFactura=true;

	public Boolean getActivarFK_IdCuentaContableCreditoBienPlantillaFactura() {
		return this.activarFK_IdCuentaContableCreditoBienPlantillaFactura;
	}

	public void setActivarFK_IdCuentaContableCreditoBienPlantillaFactura(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableCreditoBienPlantillaFactura= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableCreditoFinServicioPlantillaFactura=true;

	public Boolean getActivarFK_IdCuentaContableCreditoFinServicioPlantillaFactura() {
		return this.activarFK_IdCuentaContableCreditoFinServicioPlantillaFactura;
	}

	public void setActivarFK_IdCuentaContableCreditoFinServicioPlantillaFactura(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableCreditoFinServicioPlantillaFactura= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaPlantillaFactura=true;

	public Boolean getActivarFK_IdEmpresaPlantillaFactura() {
		return this.activarFK_IdEmpresaPlantillaFactura;
	}

	public void setActivarFK_IdEmpresaPlantillaFactura(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaPlantillaFactura= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoRetencionFuenteBienPlantillaFactura=true;

	public Boolean getActivarFK_IdTipoRetencionFuenteBienPlantillaFactura() {
		return this.activarFK_IdTipoRetencionFuenteBienPlantillaFactura;
	}

	public void setActivarFK_IdTipoRetencionFuenteBienPlantillaFactura(Boolean habilitarResaltar) {
		this.activarFK_IdTipoRetencionFuenteBienPlantillaFactura= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoRetencionFuenteServicioPlantillaFactura=true;

	public Boolean getActivarFK_IdTipoRetencionFuenteServicioPlantillaFactura() {
		return this.activarFK_IdTipoRetencionFuenteServicioPlantillaFactura;
	}

	public void setActivarFK_IdTipoRetencionFuenteServicioPlantillaFactura(Boolean habilitarResaltar) {
		this.activarFK_IdTipoRetencionFuenteServicioPlantillaFactura= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoRetencionIvaBienPlantillaFactura=true;

	public Boolean getActivarFK_IdTipoRetencionIvaBienPlantillaFactura() {
		return this.activarFK_IdTipoRetencionIvaBienPlantillaFactura;
	}

	public void setActivarFK_IdTipoRetencionIvaBienPlantillaFactura(Boolean habilitarResaltar) {
		this.activarFK_IdTipoRetencionIvaBienPlantillaFactura= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoRetencionIvaServicioPlantillaFactura=true;

	public Boolean getActivarFK_IdTipoRetencionIvaServicioPlantillaFactura() {
		return this.activarFK_IdTipoRetencionIvaServicioPlantillaFactura;
	}

	public void setActivarFK_IdTipoRetencionIvaServicioPlantillaFactura(Boolean habilitarResaltar) {
		this.activarFK_IdTipoRetencionIvaServicioPlantillaFactura= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoPlantillaFactura=null;

	public Border getResaltarBusquedaPorCodigoPlantillaFactura() {
		return this.resaltarBusquedaPorCodigoPlantillaFactura;
	}

	public void setResaltarBusquedaPorCodigoPlantillaFactura(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoPlantillaFactura= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoPlantillaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*PlantillaFacturaBeanSwingJInternalFrame plantillafacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoPlantillaFactura= borderResaltar;
	}

	public Border resaltarBusquedaPorNombrePlantillaFactura=null;

	public Border getResaltarBusquedaPorNombrePlantillaFactura() {
		return this.resaltarBusquedaPorNombrePlantillaFactura;
	}

	public void setResaltarBusquedaPorNombrePlantillaFactura(Border borderResaltar) {
		this.resaltarBusquedaPorNombrePlantillaFactura= borderResaltar;
	}

	public void setResaltarBusquedaPorNombrePlantillaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*PlantillaFacturaBeanSwingJInternalFrame plantillafacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombrePlantillaFactura= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableCreditoBienPlantillaFactura=null;

	public Border getResaltarFK_IdCuentaContableCreditoBienPlantillaFactura() {
		return this.resaltarFK_IdCuentaContableCreditoBienPlantillaFactura;
	}

	public void setResaltarFK_IdCuentaContableCreditoBienPlantillaFactura(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableCreditoBienPlantillaFactura= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableCreditoBienPlantillaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*PlantillaFacturaBeanSwingJInternalFrame plantillafacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableCreditoBienPlantillaFactura= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableCreditoFinServicioPlantillaFactura=null;

	public Border getResaltarFK_IdCuentaContableCreditoFinServicioPlantillaFactura() {
		return this.resaltarFK_IdCuentaContableCreditoFinServicioPlantillaFactura;
	}

	public void setResaltarFK_IdCuentaContableCreditoFinServicioPlantillaFactura(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableCreditoFinServicioPlantillaFactura= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableCreditoFinServicioPlantillaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*PlantillaFacturaBeanSwingJInternalFrame plantillafacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableCreditoFinServicioPlantillaFactura= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaPlantillaFactura=null;

	public Border getResaltarFK_IdEmpresaPlantillaFactura() {
		return this.resaltarFK_IdEmpresaPlantillaFactura;
	}

	public void setResaltarFK_IdEmpresaPlantillaFactura(Border borderResaltar) {
		this.resaltarFK_IdEmpresaPlantillaFactura= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaPlantillaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*PlantillaFacturaBeanSwingJInternalFrame plantillafacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaPlantillaFactura= borderResaltar;
	}

	public Border resaltarFK_IdTipoRetencionFuenteBienPlantillaFactura=null;

	public Border getResaltarFK_IdTipoRetencionFuenteBienPlantillaFactura() {
		return this.resaltarFK_IdTipoRetencionFuenteBienPlantillaFactura;
	}

	public void setResaltarFK_IdTipoRetencionFuenteBienPlantillaFactura(Border borderResaltar) {
		this.resaltarFK_IdTipoRetencionFuenteBienPlantillaFactura= borderResaltar;
	}

	public void setResaltarFK_IdTipoRetencionFuenteBienPlantillaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*PlantillaFacturaBeanSwingJInternalFrame plantillafacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoRetencionFuenteBienPlantillaFactura= borderResaltar;
	}

	public Border resaltarFK_IdTipoRetencionFuenteServicioPlantillaFactura=null;

	public Border getResaltarFK_IdTipoRetencionFuenteServicioPlantillaFactura() {
		return this.resaltarFK_IdTipoRetencionFuenteServicioPlantillaFactura;
	}

	public void setResaltarFK_IdTipoRetencionFuenteServicioPlantillaFactura(Border borderResaltar) {
		this.resaltarFK_IdTipoRetencionFuenteServicioPlantillaFactura= borderResaltar;
	}

	public void setResaltarFK_IdTipoRetencionFuenteServicioPlantillaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*PlantillaFacturaBeanSwingJInternalFrame plantillafacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoRetencionFuenteServicioPlantillaFactura= borderResaltar;
	}

	public Border resaltarFK_IdTipoRetencionIvaBienPlantillaFactura=null;

	public Border getResaltarFK_IdTipoRetencionIvaBienPlantillaFactura() {
		return this.resaltarFK_IdTipoRetencionIvaBienPlantillaFactura;
	}

	public void setResaltarFK_IdTipoRetencionIvaBienPlantillaFactura(Border borderResaltar) {
		this.resaltarFK_IdTipoRetencionIvaBienPlantillaFactura= borderResaltar;
	}

	public void setResaltarFK_IdTipoRetencionIvaBienPlantillaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*PlantillaFacturaBeanSwingJInternalFrame plantillafacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoRetencionIvaBienPlantillaFactura= borderResaltar;
	}

	public Border resaltarFK_IdTipoRetencionIvaServicioPlantillaFactura=null;

	public Border getResaltarFK_IdTipoRetencionIvaServicioPlantillaFactura() {
		return this.resaltarFK_IdTipoRetencionIvaServicioPlantillaFactura;
	}

	public void setResaltarFK_IdTipoRetencionIvaServicioPlantillaFactura(Border borderResaltar) {
		this.resaltarFK_IdTipoRetencionIvaServicioPlantillaFactura= borderResaltar;
	}

	public void setResaltarFK_IdTipoRetencionIvaServicioPlantillaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*PlantillaFacturaBeanSwingJInternalFrame plantillafacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoRetencionIvaServicioPlantillaFactura= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}