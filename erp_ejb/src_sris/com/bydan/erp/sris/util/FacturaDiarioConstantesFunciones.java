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
package com.bydan.erp.sris.util;

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


import com.bydan.erp.sris.util.FacturaDiarioConstantesFunciones;
import com.bydan.erp.sris.util.FacturaDiarioParameterReturnGeneral;
//import com.bydan.erp.sris.util.FacturaDiarioParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.sris.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.sris.business.dataaccess.*;
//import com.bydan.erp.sris.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class FacturaDiarioConstantesFunciones extends FacturaDiarioConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="FacturaDiario";
	public static final String SPATHOPCION="Sris";	
	public static final String SPATHMODULO="sris/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="FacturaDiario"+FacturaDiarioConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="FacturaDiarioHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="FacturaDiarioHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=FacturaDiarioConstantesFunciones.SCHEMA+"_"+FacturaDiarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/FacturaDiarioHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=FacturaDiarioConstantesFunciones.SCHEMA+"_"+FacturaDiarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=FacturaDiarioConstantesFunciones.SCHEMA+"_"+FacturaDiarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/FacturaDiarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=FacturaDiarioConstantesFunciones.SCHEMA+"_"+FacturaDiarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturaDiarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FacturaDiarioHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturaDiarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturaDiarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FacturaDiarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturaDiarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=FacturaDiarioConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+FacturaDiarioConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=FacturaDiarioConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+FacturaDiarioConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Factura Diarios";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Factura Diario";
	public static final String SCLASSWEBTITULO_LOWER="Factura Diario";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="FacturaDiario";
	public static final String OBJECTNAME="facturadiario";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SRIS;	
	public static final String TABLENAME="factura_diario";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select facturadiario from "+FacturaDiarioConstantesFunciones.SPERSISTENCENAME+" facturadiario";
	public static String QUERYSELECTNATIVE="select "+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+".id,"+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+".version_row,"+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+".id_empresa,"+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+".id_sucursal,"+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+".id_cliente,"+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+".id_periodo_declara,"+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+".id_tipo_iva,"+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+".fecha_emision,"+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+".fecha_vencimiento,"+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+".numero_serie,"+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+".ruc,"+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+".numero_autoriza,"+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+".es_devolucion,"+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+".valor_factura,"+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+".base_imponible,"+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+".monto_iva,"+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+".bim_tarjeta from "+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME;//+" as "+FacturaDiarioConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected FacturaDiarioConstantesFuncionesAdditional facturadiarioConstantesFuncionesAdditional=null;
	
	public FacturaDiarioConstantesFuncionesAdditional getFacturaDiarioConstantesFuncionesAdditional() {
		return this.facturadiarioConstantesFuncionesAdditional;
	}
	
	public void setFacturaDiarioConstantesFuncionesAdditional(FacturaDiarioConstantesFuncionesAdditional facturadiarioConstantesFuncionesAdditional) {
		try {
			this.facturadiarioConstantesFuncionesAdditional=facturadiarioConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDPERIODODECLARA= "id_periodo_declara";
    public static final String IDTIPOIVA= "id_tipo_iva";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAVENCIMIENTO= "fecha_vencimiento";
    public static final String NUMEROSERIE= "numero_serie";
    public static final String RUC= "ruc";
    public static final String NUMEROAUTORIZA= "numero_autoriza";
    public static final String ESDEVOLUCION= "es_devolucion";
    public static final String VALORFACTURA= "valor_factura";
    public static final String BASEIMPONIBLE= "base_imponible";
    public static final String MONTOIVA= "monto_iva";
    public static final String BIMTARJETA= "bim_tarjeta";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDPERIODODECLARA= "Periodo Declara";
		public static final String LABEL_IDPERIODODECLARA_LOWER= "Periodo Declara";
    	public static final String LABEL_IDTIPOIVA= "Tipo Iva";
		public static final String LABEL_IDTIPOIVA_LOWER= "Tipo Iva";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_FECHAVENCIMIENTO= "Fecha Vencimiento";
		public static final String LABEL_FECHAVENCIMIENTO_LOWER= "Fecha Vencimiento";
    	public static final String LABEL_NUMEROSERIE= "Numero Serie";
		public static final String LABEL_NUMEROSERIE_LOWER= "Numero Serie";
    	public static final String LABEL_RUC= "Ruc";
		public static final String LABEL_RUC_LOWER= "Ruc";
    	public static final String LABEL_NUMEROAUTORIZA= "Numero Autoriza";
		public static final String LABEL_NUMEROAUTORIZA_LOWER= "Numero Autoriza";
    	public static final String LABEL_ESDEVOLUCION= "Es Devolucion";
		public static final String LABEL_ESDEVOLUCION_LOWER= "Es Devolucion";
    	public static final String LABEL_VALORFACTURA= "Valor Factura";
		public static final String LABEL_VALORFACTURA_LOWER= "Valor Factura";
    	public static final String LABEL_BASEIMPONIBLE= "Base Imponible";
		public static final String LABEL_BASEIMPONIBLE_LOWER= "Base Imponible";
    	public static final String LABEL_MONTOIVA= "Monto Iva";
		public static final String LABEL_MONTOIVA_LOWER= "Monto Iva";
    	public static final String LABEL_BIMTARJETA= "Bim Tarjeta";
		public static final String LABEL_BIMTARJETA_LOWER= "Bim Tarjeta";
	
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_SERIE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_SERIE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXRUC=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_AUTORIZA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_AUTORIZA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	
	public static String getFacturaDiarioLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(FacturaDiarioConstantesFunciones.IDEMPRESA)) {sLabelColumna=FacturaDiarioConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(FacturaDiarioConstantesFunciones.IDSUCURSAL)) {sLabelColumna=FacturaDiarioConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(FacturaDiarioConstantesFunciones.IDCLIENTE)) {sLabelColumna=FacturaDiarioConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(FacturaDiarioConstantesFunciones.IDPERIODODECLARA)) {sLabelColumna=FacturaDiarioConstantesFunciones.LABEL_IDPERIODODECLARA;}
		if(sNombreColumna.equals(FacturaDiarioConstantesFunciones.IDTIPOIVA)) {sLabelColumna=FacturaDiarioConstantesFunciones.LABEL_IDTIPOIVA;}
		if(sNombreColumna.equals(FacturaDiarioConstantesFunciones.FECHAEMISION)) {sLabelColumna=FacturaDiarioConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(FacturaDiarioConstantesFunciones.FECHAVENCIMIENTO)) {sLabelColumna=FacturaDiarioConstantesFunciones.LABEL_FECHAVENCIMIENTO;}
		if(sNombreColumna.equals(FacturaDiarioConstantesFunciones.NUMEROSERIE)) {sLabelColumna=FacturaDiarioConstantesFunciones.LABEL_NUMEROSERIE;}
		if(sNombreColumna.equals(FacturaDiarioConstantesFunciones.RUC)) {sLabelColumna=FacturaDiarioConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(FacturaDiarioConstantesFunciones.NUMEROAUTORIZA)) {sLabelColumna=FacturaDiarioConstantesFunciones.LABEL_NUMEROAUTORIZA;}
		if(sNombreColumna.equals(FacturaDiarioConstantesFunciones.ESDEVOLUCION)) {sLabelColumna=FacturaDiarioConstantesFunciones.LABEL_ESDEVOLUCION;}
		if(sNombreColumna.equals(FacturaDiarioConstantesFunciones.VALORFACTURA)) {sLabelColumna=FacturaDiarioConstantesFunciones.LABEL_VALORFACTURA;}
		if(sNombreColumna.equals(FacturaDiarioConstantesFunciones.BASEIMPONIBLE)) {sLabelColumna=FacturaDiarioConstantesFunciones.LABEL_BASEIMPONIBLE;}
		if(sNombreColumna.equals(FacturaDiarioConstantesFunciones.MONTOIVA)) {sLabelColumna=FacturaDiarioConstantesFunciones.LABEL_MONTOIVA;}
		if(sNombreColumna.equals(FacturaDiarioConstantesFunciones.BIMTARJETA)) {sLabelColumna=FacturaDiarioConstantesFunciones.LABEL_BIMTARJETA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getes_devolucionDescripcion(FacturaDiario facturadiario) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!facturadiario.getes_devolucion()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_devolucionHtmlDescripcion(FacturaDiario facturadiario) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(facturadiario.getId(),facturadiario.getes_devolucion());

		return sDescripcion;
	}	
			
			
			
			
	
	public static String getFacturaDiarioDescripcion(FacturaDiario facturadiario) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(facturadiario !=null/* && facturadiario.getId()!=0*/) {
			if(facturadiario.getId()!=null) {
				sDescripcion=facturadiario.getId().toString();
			}//facturadiariofacturadiario.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getFacturaDiarioDescripcionDetallado(FacturaDiario facturadiario) {
		String sDescripcion="";
			
		sDescripcion+=FacturaDiarioConstantesFunciones.ID+"=";
		sDescripcion+=facturadiario.getId().toString()+",";
		sDescripcion+=FacturaDiarioConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=facturadiario.getVersionRow().toString()+",";
		sDescripcion+=FacturaDiarioConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=facturadiario.getid_empresa().toString()+",";
		sDescripcion+=FacturaDiarioConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=facturadiario.getid_sucursal().toString()+",";
		sDescripcion+=FacturaDiarioConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=facturadiario.getid_cliente().toString()+",";
		sDescripcion+=FacturaDiarioConstantesFunciones.IDPERIODODECLARA+"=";
		sDescripcion+=facturadiario.getid_periodo_declara().toString()+",";
		sDescripcion+=FacturaDiarioConstantesFunciones.IDTIPOIVA+"=";
		sDescripcion+=facturadiario.getid_tipo_iva().toString()+",";
		sDescripcion+=FacturaDiarioConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=facturadiario.getfecha_emision().toString()+",";
		sDescripcion+=FacturaDiarioConstantesFunciones.FECHAVENCIMIENTO+"=";
		sDescripcion+=facturadiario.getfecha_vencimiento().toString()+",";
		sDescripcion+=FacturaDiarioConstantesFunciones.NUMEROSERIE+"=";
		sDescripcion+=facturadiario.getnumero_serie()+",";
		sDescripcion+=FacturaDiarioConstantesFunciones.RUC+"=";
		sDescripcion+=facturadiario.getruc()+",";
		sDescripcion+=FacturaDiarioConstantesFunciones.NUMEROAUTORIZA+"=";
		sDescripcion+=facturadiario.getnumero_autoriza()+",";
		sDescripcion+=FacturaDiarioConstantesFunciones.ESDEVOLUCION+"=";
		sDescripcion+=facturadiario.getes_devolucion().toString()+",";
		sDescripcion+=FacturaDiarioConstantesFunciones.VALORFACTURA+"=";
		sDescripcion+=facturadiario.getvalor_factura().toString()+",";
		sDescripcion+=FacturaDiarioConstantesFunciones.BASEIMPONIBLE+"=";
		sDescripcion+=facturadiario.getbase_imponible().toString()+",";
		sDescripcion+=FacturaDiarioConstantesFunciones.MONTOIVA+"=";
		sDescripcion+=facturadiario.getmonto_iva().toString()+",";
		sDescripcion+=FacturaDiarioConstantesFunciones.BIMTARJETA+"=";
		sDescripcion+=facturadiario.getbim_tarjeta().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setFacturaDiarioDescripcion(FacturaDiario facturadiario,String sValor) throws Exception {			
		if(facturadiario !=null) {
			//facturadiariofacturadiario.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getPeriodoDeclaraDescripcion(PeriodoDeclara periododeclara) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(periododeclara!=null/*&&periododeclara.getId()>0*/) {
			sDescripcion=PeriodoDeclaraConstantesFunciones.getPeriodoDeclaraDescripcion(periododeclara);
		}

		return sDescripcion;
	}

	public static String getTipoIvaDescripcion(TipoIva tipoiva) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoiva!=null/*&&tipoiva.getId()>0*/) {
			sDescripcion=TipoIvaConstantesFunciones.getTipoIvaDescripcion(tipoiva);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdPeriodoDeclara")) {
			sNombreIndice="Tipo=  Por Periodo Declara";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoIva")) {
			sNombreIndice="Tipo=  Por Tipo Iva";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodoDeclara(Long id_periodo_declara) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo_declara!=null) {sDetalleIndice+=" Codigo Unico De Periodo Declara="+id_periodo_declara.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoIva(Long id_tipo_iva) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_iva!=null) {sDetalleIndice+=" Codigo Unico De Tipo Iva="+id_tipo_iva.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosFacturaDiario(FacturaDiario facturadiario,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		facturadiario.setnumero_serie(facturadiario.getnumero_serie().trim());
		facturadiario.setruc(facturadiario.getruc().trim());
		facturadiario.setnumero_autoriza(facturadiario.getnumero_autoriza().trim());
	}
	
	public static void quitarEspaciosFacturaDiarios(List<FacturaDiario> facturadiarios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(FacturaDiario facturadiario: facturadiarios) {
			facturadiario.setnumero_serie(facturadiario.getnumero_serie().trim());
			facturadiario.setruc(facturadiario.getruc().trim());
			facturadiario.setnumero_autoriza(facturadiario.getnumero_autoriza().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFacturaDiario(FacturaDiario facturadiario,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && facturadiario.getConCambioAuxiliar()) {
			facturadiario.setIsDeleted(facturadiario.getIsDeletedAuxiliar());	
			facturadiario.setIsNew(facturadiario.getIsNewAuxiliar());	
			facturadiario.setIsChanged(facturadiario.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			facturadiario.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			facturadiario.setIsDeletedAuxiliar(false);	
			facturadiario.setIsNewAuxiliar(false);	
			facturadiario.setIsChangedAuxiliar(false);
			
			facturadiario.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFacturaDiarios(List<FacturaDiario> facturadiarios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(FacturaDiario facturadiario : facturadiarios) {
			if(conAsignarBase && facturadiario.getConCambioAuxiliar()) {
				facturadiario.setIsDeleted(facturadiario.getIsDeletedAuxiliar());	
				facturadiario.setIsNew(facturadiario.getIsNewAuxiliar());	
				facturadiario.setIsChanged(facturadiario.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				facturadiario.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				facturadiario.setIsDeletedAuxiliar(false);	
				facturadiario.setIsNewAuxiliar(false);	
				facturadiario.setIsChangedAuxiliar(false);
				
				facturadiario.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresFacturaDiario(FacturaDiario facturadiario,Boolean conEnteros) throws Exception  {
		facturadiario.setvalor_factura(0.0);
		facturadiario.setbase_imponible(0.0);
		facturadiario.setmonto_iva(0.0);
		facturadiario.setbim_tarjeta(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresFacturaDiarios(List<FacturaDiario> facturadiarios,Boolean conEnteros) throws Exception  {
		
		for(FacturaDiario facturadiario: facturadiarios) {
			facturadiario.setvalor_factura(0.0);
			facturadiario.setbase_imponible(0.0);
			facturadiario.setmonto_iva(0.0);
			facturadiario.setbim_tarjeta(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaFacturaDiario(List<FacturaDiario> facturadiarios,FacturaDiario facturadiarioAux) throws Exception  {
		FacturaDiarioConstantesFunciones.InicializarValoresFacturaDiario(facturadiarioAux,true);
		
		for(FacturaDiario facturadiario: facturadiarios) {
			if(facturadiario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			facturadiarioAux.setvalor_factura(facturadiarioAux.getvalor_factura()+facturadiario.getvalor_factura());			
			facturadiarioAux.setbase_imponible(facturadiarioAux.getbase_imponible()+facturadiario.getbase_imponible());			
			facturadiarioAux.setmonto_iva(facturadiarioAux.getmonto_iva()+facturadiario.getmonto_iva());			
			facturadiarioAux.setbim_tarjeta(facturadiarioAux.getbim_tarjeta()+facturadiario.getbim_tarjeta());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesFacturaDiario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=FacturaDiarioConstantesFunciones.getArrayColumnasGlobalesFacturaDiario(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesFacturaDiario(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FacturaDiarioConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FacturaDiarioConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FacturaDiarioConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FacturaDiarioConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoFacturaDiario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<FacturaDiario> facturadiarios,FacturaDiario facturadiario,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(FacturaDiario facturadiarioAux: facturadiarios) {
			if(facturadiarioAux!=null && facturadiario!=null) {
				if((facturadiarioAux.getId()==null && facturadiario.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(facturadiarioAux.getId()!=null && facturadiario.getId()!=null){
					if(facturadiarioAux.getId().equals(facturadiario.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaFacturaDiario(List<FacturaDiario> facturadiarios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_facturaTotal=0.0;
		Double base_imponibleTotal=0.0;
		Double monto_ivaTotal=0.0;
		Double bim_tarjetaTotal=0.0;
	
		for(FacturaDiario facturadiario: facturadiarios) {			
			if(facturadiario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_facturaTotal+=facturadiario.getvalor_factura();
			base_imponibleTotal+=facturadiario.getbase_imponible();
			monto_ivaTotal+=facturadiario.getmonto_iva();
			bim_tarjetaTotal+=facturadiario.getbim_tarjeta();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaDiarioConstantesFunciones.VALORFACTURA);
		datoGeneral.setsDescripcion(FacturaDiarioConstantesFunciones.LABEL_VALORFACTURA);
		datoGeneral.setdValorDouble(valor_facturaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaDiarioConstantesFunciones.BASEIMPONIBLE);
		datoGeneral.setsDescripcion(FacturaDiarioConstantesFunciones.LABEL_BASEIMPONIBLE);
		datoGeneral.setdValorDouble(base_imponibleTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaDiarioConstantesFunciones.MONTOIVA);
		datoGeneral.setsDescripcion(FacturaDiarioConstantesFunciones.LABEL_MONTOIVA);
		datoGeneral.setdValorDouble(monto_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaDiarioConstantesFunciones.BIMTARJETA);
		datoGeneral.setsDescripcion(FacturaDiarioConstantesFunciones.LABEL_BIMTARJETA);
		datoGeneral.setdValorDouble(bim_tarjetaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaFacturaDiario() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,FacturaDiarioConstantesFunciones.LABEL_ID, FacturaDiarioConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaDiarioConstantesFunciones.LABEL_VERSIONROW, FacturaDiarioConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaDiarioConstantesFunciones.LABEL_IDEMPRESA, FacturaDiarioConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaDiarioConstantesFunciones.LABEL_IDSUCURSAL, FacturaDiarioConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaDiarioConstantesFunciones.LABEL_IDCLIENTE, FacturaDiarioConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaDiarioConstantesFunciones.LABEL_IDPERIODODECLARA, FacturaDiarioConstantesFunciones.IDPERIODODECLARA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaDiarioConstantesFunciones.LABEL_IDTIPOIVA, FacturaDiarioConstantesFunciones.IDTIPOIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaDiarioConstantesFunciones.LABEL_FECHAEMISION, FacturaDiarioConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaDiarioConstantesFunciones.LABEL_FECHAVENCIMIENTO, FacturaDiarioConstantesFunciones.FECHAVENCIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaDiarioConstantesFunciones.LABEL_NUMEROSERIE, FacturaDiarioConstantesFunciones.NUMEROSERIE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaDiarioConstantesFunciones.LABEL_RUC, FacturaDiarioConstantesFunciones.RUC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaDiarioConstantesFunciones.LABEL_NUMEROAUTORIZA, FacturaDiarioConstantesFunciones.NUMEROAUTORIZA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaDiarioConstantesFunciones.LABEL_ESDEVOLUCION, FacturaDiarioConstantesFunciones.ESDEVOLUCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaDiarioConstantesFunciones.LABEL_VALORFACTURA, FacturaDiarioConstantesFunciones.VALORFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaDiarioConstantesFunciones.LABEL_BASEIMPONIBLE, FacturaDiarioConstantesFunciones.BASEIMPONIBLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaDiarioConstantesFunciones.LABEL_MONTOIVA, FacturaDiarioConstantesFunciones.MONTOIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaDiarioConstantesFunciones.LABEL_BIMTARJETA, FacturaDiarioConstantesFunciones.BIMTARJETA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasFacturaDiario() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=FacturaDiarioConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaDiarioConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaDiarioConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaDiarioConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaDiarioConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaDiarioConstantesFunciones.IDPERIODODECLARA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaDiarioConstantesFunciones.IDTIPOIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaDiarioConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaDiarioConstantesFunciones.FECHAVENCIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaDiarioConstantesFunciones.NUMEROSERIE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaDiarioConstantesFunciones.RUC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaDiarioConstantesFunciones.NUMEROAUTORIZA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaDiarioConstantesFunciones.ESDEVOLUCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaDiarioConstantesFunciones.VALORFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaDiarioConstantesFunciones.BASEIMPONIBLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaDiarioConstantesFunciones.MONTOIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaDiarioConstantesFunciones.BIMTARJETA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFacturaDiario() throws Exception  {
		return FacturaDiarioConstantesFunciones.getTiposSeleccionarFacturaDiario(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFacturaDiario(Boolean conFk) throws Exception  {
		return FacturaDiarioConstantesFunciones.getTiposSeleccionarFacturaDiario(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFacturaDiario(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaDiarioConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(FacturaDiarioConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaDiarioConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(FacturaDiarioConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaDiarioConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(FacturaDiarioConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaDiarioConstantesFunciones.LABEL_IDPERIODODECLARA);
			reporte.setsDescripcion(FacturaDiarioConstantesFunciones.LABEL_IDPERIODODECLARA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaDiarioConstantesFunciones.LABEL_IDTIPOIVA);
			reporte.setsDescripcion(FacturaDiarioConstantesFunciones.LABEL_IDTIPOIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaDiarioConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(FacturaDiarioConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaDiarioConstantesFunciones.LABEL_FECHAVENCIMIENTO);
			reporte.setsDescripcion(FacturaDiarioConstantesFunciones.LABEL_FECHAVENCIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaDiarioConstantesFunciones.LABEL_NUMEROSERIE);
			reporte.setsDescripcion(FacturaDiarioConstantesFunciones.LABEL_NUMEROSERIE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaDiarioConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(FacturaDiarioConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaDiarioConstantesFunciones.LABEL_NUMEROAUTORIZA);
			reporte.setsDescripcion(FacturaDiarioConstantesFunciones.LABEL_NUMEROAUTORIZA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaDiarioConstantesFunciones.LABEL_ESDEVOLUCION);
			reporte.setsDescripcion(FacturaDiarioConstantesFunciones.LABEL_ESDEVOLUCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaDiarioConstantesFunciones.LABEL_VALORFACTURA);
			reporte.setsDescripcion(FacturaDiarioConstantesFunciones.LABEL_VALORFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaDiarioConstantesFunciones.LABEL_BASEIMPONIBLE);
			reporte.setsDescripcion(FacturaDiarioConstantesFunciones.LABEL_BASEIMPONIBLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaDiarioConstantesFunciones.LABEL_MONTOIVA);
			reporte.setsDescripcion(FacturaDiarioConstantesFunciones.LABEL_MONTOIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaDiarioConstantesFunciones.LABEL_BIMTARJETA);
			reporte.setsDescripcion(FacturaDiarioConstantesFunciones.LABEL_BIMTARJETA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesFacturaDiario(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesFacturaDiario(FacturaDiario facturadiarioAux) throws Exception {
		
			facturadiarioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(facturadiarioAux.getEmpresa()));
			facturadiarioAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(facturadiarioAux.getSucursal()));
			facturadiarioAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(facturadiarioAux.getCliente()));
			facturadiarioAux.setperiododeclara_descripcion(PeriodoDeclaraConstantesFunciones.getPeriodoDeclaraDescripcion(facturadiarioAux.getPeriodoDeclara()));
			facturadiarioAux.settipoiva_descripcion(TipoIvaConstantesFunciones.getTipoIvaDescripcion(facturadiarioAux.getTipoIva()));		
	}
	
	public static void refrescarForeignKeysDescripcionesFacturaDiario(List<FacturaDiario> facturadiariosTemp) throws Exception {
		for(FacturaDiario facturadiarioAux:facturadiariosTemp) {
			
			facturadiarioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(facturadiarioAux.getEmpresa()));
			facturadiarioAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(facturadiarioAux.getSucursal()));
			facturadiarioAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(facturadiarioAux.getCliente()));
			facturadiarioAux.setperiododeclara_descripcion(PeriodoDeclaraConstantesFunciones.getPeriodoDeclaraDescripcion(facturadiarioAux.getPeriodoDeclara()));
			facturadiarioAux.settipoiva_descripcion(TipoIvaConstantesFunciones.getTipoIvaDescripcion(facturadiarioAux.getTipoIva()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfFacturaDiario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(PeriodoDeclara.class));
				classes.add(new Classe(TipoIva.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PeriodoDeclara.class)) {
						classes.add(new Classe(PeriodoDeclara.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoIva.class)) {
						classes.add(new Classe(TipoIva.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfFacturaDiario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(PeriodoDeclara.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PeriodoDeclara.class)); continue;
					}

					if(TipoIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoIva.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(PeriodoDeclara.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PeriodoDeclara.class)); continue;
					}

					if(TipoIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoIva.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfFacturaDiario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return FacturaDiarioConstantesFunciones.getClassesRelationshipsOfFacturaDiario(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFacturaDiario(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFacturaDiario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return FacturaDiarioConstantesFunciones.getClassesRelationshipsFromStringsOfFacturaDiario(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFacturaDiario(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {
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
	public static void actualizarLista(FacturaDiario facturadiario,List<FacturaDiario> facturadiarios,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			FacturaDiario facturadiarioEncontrado=null;
			
			for(FacturaDiario facturadiarioLocal:facturadiarios) {
				if(facturadiarioLocal.getId().equals(facturadiario.getId())) {
					facturadiarioEncontrado=facturadiarioLocal;
					
					facturadiarioLocal.setIsChanged(facturadiario.getIsChanged());
					facturadiarioLocal.setIsNew(facturadiario.getIsNew());
					facturadiarioLocal.setIsDeleted(facturadiario.getIsDeleted());
					
					facturadiarioLocal.setGeneralEntityOriginal(facturadiario.getGeneralEntityOriginal());
					
					facturadiarioLocal.setId(facturadiario.getId());	
					facturadiarioLocal.setVersionRow(facturadiario.getVersionRow());	
					facturadiarioLocal.setid_empresa(facturadiario.getid_empresa());	
					facturadiarioLocal.setid_sucursal(facturadiario.getid_sucursal());	
					facturadiarioLocal.setid_cliente(facturadiario.getid_cliente());	
					facturadiarioLocal.setid_periodo_declara(facturadiario.getid_periodo_declara());	
					facturadiarioLocal.setid_tipo_iva(facturadiario.getid_tipo_iva());	
					facturadiarioLocal.setfecha_emision(facturadiario.getfecha_emision());	
					facturadiarioLocal.setfecha_vencimiento(facturadiario.getfecha_vencimiento());	
					facturadiarioLocal.setnumero_serie(facturadiario.getnumero_serie());	
					facturadiarioLocal.setruc(facturadiario.getruc());	
					facturadiarioLocal.setnumero_autoriza(facturadiario.getnumero_autoriza());	
					facturadiarioLocal.setes_devolucion(facturadiario.getes_devolucion());	
					facturadiarioLocal.setvalor_factura(facturadiario.getvalor_factura());	
					facturadiarioLocal.setbase_imponible(facturadiario.getbase_imponible());	
					facturadiarioLocal.setmonto_iva(facturadiario.getmonto_iva());	
					facturadiarioLocal.setbim_tarjeta(facturadiario.getbim_tarjeta());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!facturadiario.getIsDeleted()) {
				if(!existe) {
					facturadiarios.add(facturadiario);
				}
			} else {
				if(facturadiarioEncontrado!=null && permiteQuitar)  {
					facturadiarios.remove(facturadiarioEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(FacturaDiario facturadiario,List<FacturaDiario> facturadiarios) throws Exception {
		try	{			
			for(FacturaDiario facturadiarioLocal:facturadiarios) {
				if(facturadiarioLocal.getId().equals(facturadiario.getId())) {
					facturadiarioLocal.setIsSelected(facturadiario.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesFacturaDiario(List<FacturaDiario> facturadiariosAux) throws Exception {
		//this.facturadiariosAux=facturadiariosAux;
		
		for(FacturaDiario facturadiarioAux:facturadiariosAux) {
			if(facturadiarioAux.getIsChanged()) {
				facturadiarioAux.setIsChanged(false);
			}		
			
			if(facturadiarioAux.getIsNew()) {
				facturadiarioAux.setIsNew(false);
			}	
			
			if(facturadiarioAux.getIsDeleted()) {
				facturadiarioAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesFacturaDiario(FacturaDiario facturadiarioAux) throws Exception {
		//this.facturadiarioAux=facturadiarioAux;
		
			if(facturadiarioAux.getIsChanged()) {
				facturadiarioAux.setIsChanged(false);
			}		
			
			if(facturadiarioAux.getIsNew()) {
				facturadiarioAux.setIsNew(false);
			}	
			
			if(facturadiarioAux.getIsDeleted()) {
				facturadiarioAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(FacturaDiario facturadiarioAsignar,FacturaDiario facturadiario) throws Exception {
		facturadiarioAsignar.setId(facturadiario.getId());	
		facturadiarioAsignar.setVersionRow(facturadiario.getVersionRow());	
		facturadiarioAsignar.setid_empresa(facturadiario.getid_empresa());
		facturadiarioAsignar.setempresa_descripcion(facturadiario.getempresa_descripcion());	
		facturadiarioAsignar.setid_sucursal(facturadiario.getid_sucursal());
		facturadiarioAsignar.setsucursal_descripcion(facturadiario.getsucursal_descripcion());	
		facturadiarioAsignar.setid_cliente(facturadiario.getid_cliente());
		facturadiarioAsignar.setcliente_descripcion(facturadiario.getcliente_descripcion());	
		facturadiarioAsignar.setid_periodo_declara(facturadiario.getid_periodo_declara());
		facturadiarioAsignar.setperiododeclara_descripcion(facturadiario.getperiododeclara_descripcion());	
		facturadiarioAsignar.setid_tipo_iva(facturadiario.getid_tipo_iva());
		facturadiarioAsignar.settipoiva_descripcion(facturadiario.gettipoiva_descripcion());	
		facturadiarioAsignar.setfecha_emision(facturadiario.getfecha_emision());	
		facturadiarioAsignar.setfecha_vencimiento(facturadiario.getfecha_vencimiento());	
		facturadiarioAsignar.setnumero_serie(facturadiario.getnumero_serie());	
		facturadiarioAsignar.setruc(facturadiario.getruc());	
		facturadiarioAsignar.setnumero_autoriza(facturadiario.getnumero_autoriza());	
		facturadiarioAsignar.setes_devolucion(facturadiario.getes_devolucion());	
		facturadiarioAsignar.setvalor_factura(facturadiario.getvalor_factura());	
		facturadiarioAsignar.setbase_imponible(facturadiario.getbase_imponible());	
		facturadiarioAsignar.setmonto_iva(facturadiario.getmonto_iva());	
		facturadiarioAsignar.setbim_tarjeta(facturadiario.getbim_tarjeta());	
	}
	
	public static void inicializarFacturaDiario(FacturaDiario facturadiario) throws Exception {
		try {
				facturadiario.setId(0L);	
					
				facturadiario.setid_empresa(-1L);	
				facturadiario.setid_sucursal(-1L);	
				facturadiario.setid_cliente(-1L);	
				facturadiario.setid_periodo_declara(-1L);	
				facturadiario.setid_tipo_iva(-1L);	
				facturadiario.setfecha_emision(new Date());	
				facturadiario.setfecha_vencimiento(new Date());	
				facturadiario.setnumero_serie("");	
				facturadiario.setruc("");	
				facturadiario.setnumero_autoriza("");	
				facturadiario.setes_devolucion(false);	
				facturadiario.setvalor_factura(0.0);	
				facturadiario.setbase_imponible(0.0);	
				facturadiario.setmonto_iva(0.0);	
				facturadiario.setbim_tarjeta(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderFacturaDiario(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaDiarioConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaDiarioConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaDiarioConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaDiarioConstantesFunciones.LABEL_IDPERIODODECLARA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaDiarioConstantesFunciones.LABEL_IDTIPOIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaDiarioConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaDiarioConstantesFunciones.LABEL_FECHAVENCIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaDiarioConstantesFunciones.LABEL_NUMEROSERIE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaDiarioConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaDiarioConstantesFunciones.LABEL_NUMEROAUTORIZA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaDiarioConstantesFunciones.LABEL_ESDEVOLUCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaDiarioConstantesFunciones.LABEL_VALORFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaDiarioConstantesFunciones.LABEL_BASEIMPONIBLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaDiarioConstantesFunciones.LABEL_MONTOIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaDiarioConstantesFunciones.LABEL_BIMTARJETA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataFacturaDiario(String sTipo,Row row,Workbook workbook,FacturaDiario facturadiario,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(facturadiario.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturadiario.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturadiario.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturadiario.getperiododeclara_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturadiario.gettipoiva_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturadiario.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturadiario.getfecha_vencimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturadiario.getnumero_serie());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturadiario.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturadiario.getnumero_autoriza());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(facturadiario.getes_devolucion()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturadiario.getvalor_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturadiario.getbase_imponible());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturadiario.getmonto_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturadiario.getbim_tarjeta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryFacturaDiario=Constantes.SFINALQUERY;
	
	public String getsFinalQueryFacturaDiario() {
		return this.sFinalQueryFacturaDiario;
	}
	
	public void setsFinalQueryFacturaDiario(String sFinalQueryFacturaDiario) {
		this.sFinalQueryFacturaDiario= sFinalQueryFacturaDiario;
	}
	
	public Border resaltarSeleccionarFacturaDiario=null;
	
	public Border setResaltarSeleccionarFacturaDiario(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDiarioBeanSwingJInternalFrame facturadiarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//facturadiarioBeanSwingJInternalFrame.jTtoolBarFacturaDiario.setBorder(borderResaltar);
		
		this.resaltarSeleccionarFacturaDiario= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarFacturaDiario() {
		return this.resaltarSeleccionarFacturaDiario;
	}
	
	public void setResaltarSeleccionarFacturaDiario(Border borderResaltarSeleccionarFacturaDiario) {
		this.resaltarSeleccionarFacturaDiario= borderResaltarSeleccionarFacturaDiario;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridFacturaDiario=null;
	public Boolean mostraridFacturaDiario=true;
	public Boolean activaridFacturaDiario=true;

	public Border resaltarid_empresaFacturaDiario=null;
	public Boolean mostrarid_empresaFacturaDiario=true;
	public Boolean activarid_empresaFacturaDiario=true;
	public Boolean cargarid_empresaFacturaDiario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaFacturaDiario=false;//ConEventDepend=true

	public Border resaltarid_sucursalFacturaDiario=null;
	public Boolean mostrarid_sucursalFacturaDiario=true;
	public Boolean activarid_sucursalFacturaDiario=true;
	public Boolean cargarid_sucursalFacturaDiario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalFacturaDiario=false;//ConEventDepend=true

	public Border resaltarid_clienteFacturaDiario=null;
	public Boolean mostrarid_clienteFacturaDiario=true;
	public Boolean activarid_clienteFacturaDiario=true;
	public Boolean cargarid_clienteFacturaDiario=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteFacturaDiario=false;//ConEventDepend=true

	public Border resaltarid_periodo_declaraFacturaDiario=null;
	public Boolean mostrarid_periodo_declaraFacturaDiario=true;
	public Boolean activarid_periodo_declaraFacturaDiario=true;
	public Boolean cargarid_periodo_declaraFacturaDiario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodo_declaraFacturaDiario=false;//ConEventDepend=true

	public Border resaltarid_tipo_ivaFacturaDiario=null;
	public Boolean mostrarid_tipo_ivaFacturaDiario=true;
	public Boolean activarid_tipo_ivaFacturaDiario=true;
	public Boolean cargarid_tipo_ivaFacturaDiario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_ivaFacturaDiario=false;//ConEventDepend=true

	public Border resaltarfecha_emisionFacturaDiario=null;
	public Boolean mostrarfecha_emisionFacturaDiario=true;
	public Boolean activarfecha_emisionFacturaDiario=true;

	public Border resaltarfecha_vencimientoFacturaDiario=null;
	public Boolean mostrarfecha_vencimientoFacturaDiario=true;
	public Boolean activarfecha_vencimientoFacturaDiario=true;

	public Border resaltarnumero_serieFacturaDiario=null;
	public Boolean mostrarnumero_serieFacturaDiario=true;
	public Boolean activarnumero_serieFacturaDiario=true;

	public Border resaltarrucFacturaDiario=null;
	public Boolean mostrarrucFacturaDiario=true;
	public Boolean activarrucFacturaDiario=true;

	public Border resaltarnumero_autorizaFacturaDiario=null;
	public Boolean mostrarnumero_autorizaFacturaDiario=true;
	public Boolean activarnumero_autorizaFacturaDiario=true;

	public Border resaltares_devolucionFacturaDiario=null;
	public Boolean mostrares_devolucionFacturaDiario=true;
	public Boolean activares_devolucionFacturaDiario=true;

	public Border resaltarvalor_facturaFacturaDiario=null;
	public Boolean mostrarvalor_facturaFacturaDiario=true;
	public Boolean activarvalor_facturaFacturaDiario=true;

	public Border resaltarbase_imponibleFacturaDiario=null;
	public Boolean mostrarbase_imponibleFacturaDiario=true;
	public Boolean activarbase_imponibleFacturaDiario=true;

	public Border resaltarmonto_ivaFacturaDiario=null;
	public Boolean mostrarmonto_ivaFacturaDiario=true;
	public Boolean activarmonto_ivaFacturaDiario=true;

	public Border resaltarbim_tarjetaFacturaDiario=null;
	public Boolean mostrarbim_tarjetaFacturaDiario=true;
	public Boolean activarbim_tarjetaFacturaDiario=true;

	
	

	public Border setResaltaridFacturaDiario(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDiarioBeanSwingJInternalFrame facturadiarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturadiarioBeanSwingJInternalFrame.jTtoolBarFacturaDiario.setBorder(borderResaltar);
		
		this.resaltaridFacturaDiario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridFacturaDiario() {
		return this.resaltaridFacturaDiario;
	}

	public void setResaltaridFacturaDiario(Border borderResaltar) {
		this.resaltaridFacturaDiario= borderResaltar;
	}

	public Boolean getMostraridFacturaDiario() {
		return this.mostraridFacturaDiario;
	}

	public void setMostraridFacturaDiario(Boolean mostraridFacturaDiario) {
		this.mostraridFacturaDiario= mostraridFacturaDiario;
	}

	public Boolean getActivaridFacturaDiario() {
		return this.activaridFacturaDiario;
	}

	public void setActivaridFacturaDiario(Boolean activaridFacturaDiario) {
		this.activaridFacturaDiario= activaridFacturaDiario;
	}

	public Border setResaltarid_empresaFacturaDiario(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDiarioBeanSwingJInternalFrame facturadiarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturadiarioBeanSwingJInternalFrame.jTtoolBarFacturaDiario.setBorder(borderResaltar);
		
		this.resaltarid_empresaFacturaDiario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaFacturaDiario() {
		return this.resaltarid_empresaFacturaDiario;
	}

	public void setResaltarid_empresaFacturaDiario(Border borderResaltar) {
		this.resaltarid_empresaFacturaDiario= borderResaltar;
	}

	public Boolean getMostrarid_empresaFacturaDiario() {
		return this.mostrarid_empresaFacturaDiario;
	}

	public void setMostrarid_empresaFacturaDiario(Boolean mostrarid_empresaFacturaDiario) {
		this.mostrarid_empresaFacturaDiario= mostrarid_empresaFacturaDiario;
	}

	public Boolean getActivarid_empresaFacturaDiario() {
		return this.activarid_empresaFacturaDiario;
	}

	public void setActivarid_empresaFacturaDiario(Boolean activarid_empresaFacturaDiario) {
		this.activarid_empresaFacturaDiario= activarid_empresaFacturaDiario;
	}

	public Boolean getCargarid_empresaFacturaDiario() {
		return this.cargarid_empresaFacturaDiario;
	}

	public void setCargarid_empresaFacturaDiario(Boolean cargarid_empresaFacturaDiario) {
		this.cargarid_empresaFacturaDiario= cargarid_empresaFacturaDiario;
	}

	public Border setResaltarid_sucursalFacturaDiario(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDiarioBeanSwingJInternalFrame facturadiarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturadiarioBeanSwingJInternalFrame.jTtoolBarFacturaDiario.setBorder(borderResaltar);
		
		this.resaltarid_sucursalFacturaDiario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalFacturaDiario() {
		return this.resaltarid_sucursalFacturaDiario;
	}

	public void setResaltarid_sucursalFacturaDiario(Border borderResaltar) {
		this.resaltarid_sucursalFacturaDiario= borderResaltar;
	}

	public Boolean getMostrarid_sucursalFacturaDiario() {
		return this.mostrarid_sucursalFacturaDiario;
	}

	public void setMostrarid_sucursalFacturaDiario(Boolean mostrarid_sucursalFacturaDiario) {
		this.mostrarid_sucursalFacturaDiario= mostrarid_sucursalFacturaDiario;
	}

	public Boolean getActivarid_sucursalFacturaDiario() {
		return this.activarid_sucursalFacturaDiario;
	}

	public void setActivarid_sucursalFacturaDiario(Boolean activarid_sucursalFacturaDiario) {
		this.activarid_sucursalFacturaDiario= activarid_sucursalFacturaDiario;
	}

	public Boolean getCargarid_sucursalFacturaDiario() {
		return this.cargarid_sucursalFacturaDiario;
	}

	public void setCargarid_sucursalFacturaDiario(Boolean cargarid_sucursalFacturaDiario) {
		this.cargarid_sucursalFacturaDiario= cargarid_sucursalFacturaDiario;
	}

	public Border setResaltarid_clienteFacturaDiario(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDiarioBeanSwingJInternalFrame facturadiarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturadiarioBeanSwingJInternalFrame.jTtoolBarFacturaDiario.setBorder(borderResaltar);
		
		this.resaltarid_clienteFacturaDiario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteFacturaDiario() {
		return this.resaltarid_clienteFacturaDiario;
	}

	public void setResaltarid_clienteFacturaDiario(Border borderResaltar) {
		this.resaltarid_clienteFacturaDiario= borderResaltar;
	}

	public Boolean getMostrarid_clienteFacturaDiario() {
		return this.mostrarid_clienteFacturaDiario;
	}

	public void setMostrarid_clienteFacturaDiario(Boolean mostrarid_clienteFacturaDiario) {
		this.mostrarid_clienteFacturaDiario= mostrarid_clienteFacturaDiario;
	}

	public Boolean getActivarid_clienteFacturaDiario() {
		return this.activarid_clienteFacturaDiario;
	}

	public void setActivarid_clienteFacturaDiario(Boolean activarid_clienteFacturaDiario) {
		this.activarid_clienteFacturaDiario= activarid_clienteFacturaDiario;
	}

	public Boolean getCargarid_clienteFacturaDiario() {
		return this.cargarid_clienteFacturaDiario;
	}

	public void setCargarid_clienteFacturaDiario(Boolean cargarid_clienteFacturaDiario) {
		this.cargarid_clienteFacturaDiario= cargarid_clienteFacturaDiario;
	}

	public Border setResaltarid_periodo_declaraFacturaDiario(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDiarioBeanSwingJInternalFrame facturadiarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturadiarioBeanSwingJInternalFrame.jTtoolBarFacturaDiario.setBorder(borderResaltar);
		
		this.resaltarid_periodo_declaraFacturaDiario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodo_declaraFacturaDiario() {
		return this.resaltarid_periodo_declaraFacturaDiario;
	}

	public void setResaltarid_periodo_declaraFacturaDiario(Border borderResaltar) {
		this.resaltarid_periodo_declaraFacturaDiario= borderResaltar;
	}

	public Boolean getMostrarid_periodo_declaraFacturaDiario() {
		return this.mostrarid_periodo_declaraFacturaDiario;
	}

	public void setMostrarid_periodo_declaraFacturaDiario(Boolean mostrarid_periodo_declaraFacturaDiario) {
		this.mostrarid_periodo_declaraFacturaDiario= mostrarid_periodo_declaraFacturaDiario;
	}

	public Boolean getActivarid_periodo_declaraFacturaDiario() {
		return this.activarid_periodo_declaraFacturaDiario;
	}

	public void setActivarid_periodo_declaraFacturaDiario(Boolean activarid_periodo_declaraFacturaDiario) {
		this.activarid_periodo_declaraFacturaDiario= activarid_periodo_declaraFacturaDiario;
	}

	public Boolean getCargarid_periodo_declaraFacturaDiario() {
		return this.cargarid_periodo_declaraFacturaDiario;
	}

	public void setCargarid_periodo_declaraFacturaDiario(Boolean cargarid_periodo_declaraFacturaDiario) {
		this.cargarid_periodo_declaraFacturaDiario= cargarid_periodo_declaraFacturaDiario;
	}

	public Border setResaltarid_tipo_ivaFacturaDiario(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDiarioBeanSwingJInternalFrame facturadiarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturadiarioBeanSwingJInternalFrame.jTtoolBarFacturaDiario.setBorder(borderResaltar);
		
		this.resaltarid_tipo_ivaFacturaDiario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_ivaFacturaDiario() {
		return this.resaltarid_tipo_ivaFacturaDiario;
	}

	public void setResaltarid_tipo_ivaFacturaDiario(Border borderResaltar) {
		this.resaltarid_tipo_ivaFacturaDiario= borderResaltar;
	}

	public Boolean getMostrarid_tipo_ivaFacturaDiario() {
		return this.mostrarid_tipo_ivaFacturaDiario;
	}

	public void setMostrarid_tipo_ivaFacturaDiario(Boolean mostrarid_tipo_ivaFacturaDiario) {
		this.mostrarid_tipo_ivaFacturaDiario= mostrarid_tipo_ivaFacturaDiario;
	}

	public Boolean getActivarid_tipo_ivaFacturaDiario() {
		return this.activarid_tipo_ivaFacturaDiario;
	}

	public void setActivarid_tipo_ivaFacturaDiario(Boolean activarid_tipo_ivaFacturaDiario) {
		this.activarid_tipo_ivaFacturaDiario= activarid_tipo_ivaFacturaDiario;
	}

	public Boolean getCargarid_tipo_ivaFacturaDiario() {
		return this.cargarid_tipo_ivaFacturaDiario;
	}

	public void setCargarid_tipo_ivaFacturaDiario(Boolean cargarid_tipo_ivaFacturaDiario) {
		this.cargarid_tipo_ivaFacturaDiario= cargarid_tipo_ivaFacturaDiario;
	}

	public Border setResaltarfecha_emisionFacturaDiario(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDiarioBeanSwingJInternalFrame facturadiarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturadiarioBeanSwingJInternalFrame.jTtoolBarFacturaDiario.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionFacturaDiario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionFacturaDiario() {
		return this.resaltarfecha_emisionFacturaDiario;
	}

	public void setResaltarfecha_emisionFacturaDiario(Border borderResaltar) {
		this.resaltarfecha_emisionFacturaDiario= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionFacturaDiario() {
		return this.mostrarfecha_emisionFacturaDiario;
	}

	public void setMostrarfecha_emisionFacturaDiario(Boolean mostrarfecha_emisionFacturaDiario) {
		this.mostrarfecha_emisionFacturaDiario= mostrarfecha_emisionFacturaDiario;
	}

	public Boolean getActivarfecha_emisionFacturaDiario() {
		return this.activarfecha_emisionFacturaDiario;
	}

	public void setActivarfecha_emisionFacturaDiario(Boolean activarfecha_emisionFacturaDiario) {
		this.activarfecha_emisionFacturaDiario= activarfecha_emisionFacturaDiario;
	}

	public Border setResaltarfecha_vencimientoFacturaDiario(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDiarioBeanSwingJInternalFrame facturadiarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturadiarioBeanSwingJInternalFrame.jTtoolBarFacturaDiario.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimientoFacturaDiario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimientoFacturaDiario() {
		return this.resaltarfecha_vencimientoFacturaDiario;
	}

	public void setResaltarfecha_vencimientoFacturaDiario(Border borderResaltar) {
		this.resaltarfecha_vencimientoFacturaDiario= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimientoFacturaDiario() {
		return this.mostrarfecha_vencimientoFacturaDiario;
	}

	public void setMostrarfecha_vencimientoFacturaDiario(Boolean mostrarfecha_vencimientoFacturaDiario) {
		this.mostrarfecha_vencimientoFacturaDiario= mostrarfecha_vencimientoFacturaDiario;
	}

	public Boolean getActivarfecha_vencimientoFacturaDiario() {
		return this.activarfecha_vencimientoFacturaDiario;
	}

	public void setActivarfecha_vencimientoFacturaDiario(Boolean activarfecha_vencimientoFacturaDiario) {
		this.activarfecha_vencimientoFacturaDiario= activarfecha_vencimientoFacturaDiario;
	}

	public Border setResaltarnumero_serieFacturaDiario(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDiarioBeanSwingJInternalFrame facturadiarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturadiarioBeanSwingJInternalFrame.jTtoolBarFacturaDiario.setBorder(borderResaltar);
		
		this.resaltarnumero_serieFacturaDiario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_serieFacturaDiario() {
		return this.resaltarnumero_serieFacturaDiario;
	}

	public void setResaltarnumero_serieFacturaDiario(Border borderResaltar) {
		this.resaltarnumero_serieFacturaDiario= borderResaltar;
	}

	public Boolean getMostrarnumero_serieFacturaDiario() {
		return this.mostrarnumero_serieFacturaDiario;
	}

	public void setMostrarnumero_serieFacturaDiario(Boolean mostrarnumero_serieFacturaDiario) {
		this.mostrarnumero_serieFacturaDiario= mostrarnumero_serieFacturaDiario;
	}

	public Boolean getActivarnumero_serieFacturaDiario() {
		return this.activarnumero_serieFacturaDiario;
	}

	public void setActivarnumero_serieFacturaDiario(Boolean activarnumero_serieFacturaDiario) {
		this.activarnumero_serieFacturaDiario= activarnumero_serieFacturaDiario;
	}

	public Border setResaltarrucFacturaDiario(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDiarioBeanSwingJInternalFrame facturadiarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturadiarioBeanSwingJInternalFrame.jTtoolBarFacturaDiario.setBorder(borderResaltar);
		
		this.resaltarrucFacturaDiario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucFacturaDiario() {
		return this.resaltarrucFacturaDiario;
	}

	public void setResaltarrucFacturaDiario(Border borderResaltar) {
		this.resaltarrucFacturaDiario= borderResaltar;
	}

	public Boolean getMostrarrucFacturaDiario() {
		return this.mostrarrucFacturaDiario;
	}

	public void setMostrarrucFacturaDiario(Boolean mostrarrucFacturaDiario) {
		this.mostrarrucFacturaDiario= mostrarrucFacturaDiario;
	}

	public Boolean getActivarrucFacturaDiario() {
		return this.activarrucFacturaDiario;
	}

	public void setActivarrucFacturaDiario(Boolean activarrucFacturaDiario) {
		this.activarrucFacturaDiario= activarrucFacturaDiario;
	}

	public Border setResaltarnumero_autorizaFacturaDiario(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDiarioBeanSwingJInternalFrame facturadiarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturadiarioBeanSwingJInternalFrame.jTtoolBarFacturaDiario.setBorder(borderResaltar);
		
		this.resaltarnumero_autorizaFacturaDiario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_autorizaFacturaDiario() {
		return this.resaltarnumero_autorizaFacturaDiario;
	}

	public void setResaltarnumero_autorizaFacturaDiario(Border borderResaltar) {
		this.resaltarnumero_autorizaFacturaDiario= borderResaltar;
	}

	public Boolean getMostrarnumero_autorizaFacturaDiario() {
		return this.mostrarnumero_autorizaFacturaDiario;
	}

	public void setMostrarnumero_autorizaFacturaDiario(Boolean mostrarnumero_autorizaFacturaDiario) {
		this.mostrarnumero_autorizaFacturaDiario= mostrarnumero_autorizaFacturaDiario;
	}

	public Boolean getActivarnumero_autorizaFacturaDiario() {
		return this.activarnumero_autorizaFacturaDiario;
	}

	public void setActivarnumero_autorizaFacturaDiario(Boolean activarnumero_autorizaFacturaDiario) {
		this.activarnumero_autorizaFacturaDiario= activarnumero_autorizaFacturaDiario;
	}

	public Border setResaltares_devolucionFacturaDiario(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDiarioBeanSwingJInternalFrame facturadiarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturadiarioBeanSwingJInternalFrame.jTtoolBarFacturaDiario.setBorder(borderResaltar);
		
		this.resaltares_devolucionFacturaDiario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_devolucionFacturaDiario() {
		return this.resaltares_devolucionFacturaDiario;
	}

	public void setResaltares_devolucionFacturaDiario(Border borderResaltar) {
		this.resaltares_devolucionFacturaDiario= borderResaltar;
	}

	public Boolean getMostrares_devolucionFacturaDiario() {
		return this.mostrares_devolucionFacturaDiario;
	}

	public void setMostrares_devolucionFacturaDiario(Boolean mostrares_devolucionFacturaDiario) {
		this.mostrares_devolucionFacturaDiario= mostrares_devolucionFacturaDiario;
	}

	public Boolean getActivares_devolucionFacturaDiario() {
		return this.activares_devolucionFacturaDiario;
	}

	public void setActivares_devolucionFacturaDiario(Boolean activares_devolucionFacturaDiario) {
		this.activares_devolucionFacturaDiario= activares_devolucionFacturaDiario;
	}

	public Border setResaltarvalor_facturaFacturaDiario(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDiarioBeanSwingJInternalFrame facturadiarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturadiarioBeanSwingJInternalFrame.jTtoolBarFacturaDiario.setBorder(borderResaltar);
		
		this.resaltarvalor_facturaFacturaDiario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_facturaFacturaDiario() {
		return this.resaltarvalor_facturaFacturaDiario;
	}

	public void setResaltarvalor_facturaFacturaDiario(Border borderResaltar) {
		this.resaltarvalor_facturaFacturaDiario= borderResaltar;
	}

	public Boolean getMostrarvalor_facturaFacturaDiario() {
		return this.mostrarvalor_facturaFacturaDiario;
	}

	public void setMostrarvalor_facturaFacturaDiario(Boolean mostrarvalor_facturaFacturaDiario) {
		this.mostrarvalor_facturaFacturaDiario= mostrarvalor_facturaFacturaDiario;
	}

	public Boolean getActivarvalor_facturaFacturaDiario() {
		return this.activarvalor_facturaFacturaDiario;
	}

	public void setActivarvalor_facturaFacturaDiario(Boolean activarvalor_facturaFacturaDiario) {
		this.activarvalor_facturaFacturaDiario= activarvalor_facturaFacturaDiario;
	}

	public Border setResaltarbase_imponibleFacturaDiario(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDiarioBeanSwingJInternalFrame facturadiarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturadiarioBeanSwingJInternalFrame.jTtoolBarFacturaDiario.setBorder(borderResaltar);
		
		this.resaltarbase_imponibleFacturaDiario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbase_imponibleFacturaDiario() {
		return this.resaltarbase_imponibleFacturaDiario;
	}

	public void setResaltarbase_imponibleFacturaDiario(Border borderResaltar) {
		this.resaltarbase_imponibleFacturaDiario= borderResaltar;
	}

	public Boolean getMostrarbase_imponibleFacturaDiario() {
		return this.mostrarbase_imponibleFacturaDiario;
	}

	public void setMostrarbase_imponibleFacturaDiario(Boolean mostrarbase_imponibleFacturaDiario) {
		this.mostrarbase_imponibleFacturaDiario= mostrarbase_imponibleFacturaDiario;
	}

	public Boolean getActivarbase_imponibleFacturaDiario() {
		return this.activarbase_imponibleFacturaDiario;
	}

	public void setActivarbase_imponibleFacturaDiario(Boolean activarbase_imponibleFacturaDiario) {
		this.activarbase_imponibleFacturaDiario= activarbase_imponibleFacturaDiario;
	}

	public Border setResaltarmonto_ivaFacturaDiario(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDiarioBeanSwingJInternalFrame facturadiarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturadiarioBeanSwingJInternalFrame.jTtoolBarFacturaDiario.setBorder(borderResaltar);
		
		this.resaltarmonto_ivaFacturaDiario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_ivaFacturaDiario() {
		return this.resaltarmonto_ivaFacturaDiario;
	}

	public void setResaltarmonto_ivaFacturaDiario(Border borderResaltar) {
		this.resaltarmonto_ivaFacturaDiario= borderResaltar;
	}

	public Boolean getMostrarmonto_ivaFacturaDiario() {
		return this.mostrarmonto_ivaFacturaDiario;
	}

	public void setMostrarmonto_ivaFacturaDiario(Boolean mostrarmonto_ivaFacturaDiario) {
		this.mostrarmonto_ivaFacturaDiario= mostrarmonto_ivaFacturaDiario;
	}

	public Boolean getActivarmonto_ivaFacturaDiario() {
		return this.activarmonto_ivaFacturaDiario;
	}

	public void setActivarmonto_ivaFacturaDiario(Boolean activarmonto_ivaFacturaDiario) {
		this.activarmonto_ivaFacturaDiario= activarmonto_ivaFacturaDiario;
	}

	public Border setResaltarbim_tarjetaFacturaDiario(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDiarioBeanSwingJInternalFrame facturadiarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturadiarioBeanSwingJInternalFrame.jTtoolBarFacturaDiario.setBorder(borderResaltar);
		
		this.resaltarbim_tarjetaFacturaDiario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbim_tarjetaFacturaDiario() {
		return this.resaltarbim_tarjetaFacturaDiario;
	}

	public void setResaltarbim_tarjetaFacturaDiario(Border borderResaltar) {
		this.resaltarbim_tarjetaFacturaDiario= borderResaltar;
	}

	public Boolean getMostrarbim_tarjetaFacturaDiario() {
		return this.mostrarbim_tarjetaFacturaDiario;
	}

	public void setMostrarbim_tarjetaFacturaDiario(Boolean mostrarbim_tarjetaFacturaDiario) {
		this.mostrarbim_tarjetaFacturaDiario= mostrarbim_tarjetaFacturaDiario;
	}

	public Boolean getActivarbim_tarjetaFacturaDiario() {
		return this.activarbim_tarjetaFacturaDiario;
	}

	public void setActivarbim_tarjetaFacturaDiario(Boolean activarbim_tarjetaFacturaDiario) {
		this.activarbim_tarjetaFacturaDiario= activarbim_tarjetaFacturaDiario;
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
		
		
		this.setMostraridFacturaDiario(esInicial);
		this.setMostrarid_empresaFacturaDiario(esInicial);
		this.setMostrarid_sucursalFacturaDiario(esInicial);
		this.setMostrarid_clienteFacturaDiario(esInicial);
		this.setMostrarid_periodo_declaraFacturaDiario(esInicial);
		this.setMostrarid_tipo_ivaFacturaDiario(esInicial);
		this.setMostrarfecha_emisionFacturaDiario(esInicial);
		this.setMostrarfecha_vencimientoFacturaDiario(esInicial);
		this.setMostrarnumero_serieFacturaDiario(esInicial);
		this.setMostrarrucFacturaDiario(esInicial);
		this.setMostrarnumero_autorizaFacturaDiario(esInicial);
		this.setMostrares_devolucionFacturaDiario(esInicial);
		this.setMostrarvalor_facturaFacturaDiario(esInicial);
		this.setMostrarbase_imponibleFacturaDiario(esInicial);
		this.setMostrarmonto_ivaFacturaDiario(esInicial);
		this.setMostrarbim_tarjetaFacturaDiario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.ID)) {
				this.setMostraridFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.IDPERIODODECLARA)) {
				this.setMostrarid_periodo_declaraFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.IDTIPOIVA)) {
				this.setMostrarid_tipo_ivaFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setMostrarfecha_vencimientoFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.NUMEROSERIE)) {
				this.setMostrarnumero_serieFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.RUC)) {
				this.setMostrarrucFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.NUMEROAUTORIZA)) {
				this.setMostrarnumero_autorizaFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.ESDEVOLUCION)) {
				this.setMostrares_devolucionFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.VALORFACTURA)) {
				this.setMostrarvalor_facturaFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.BASEIMPONIBLE)) {
				this.setMostrarbase_imponibleFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.MONTOIVA)) {
				this.setMostrarmonto_ivaFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.BIMTARJETA)) {
				this.setMostrarbim_tarjetaFacturaDiario(esAsigna);
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
		
		
		this.setActivaridFacturaDiario(esInicial);
		this.setActivarid_empresaFacturaDiario(esInicial);
		this.setActivarid_sucursalFacturaDiario(esInicial);
		this.setActivarid_clienteFacturaDiario(esInicial);
		this.setActivarid_periodo_declaraFacturaDiario(esInicial);
		this.setActivarid_tipo_ivaFacturaDiario(esInicial);
		this.setActivarfecha_emisionFacturaDiario(esInicial);
		this.setActivarfecha_vencimientoFacturaDiario(esInicial);
		this.setActivarnumero_serieFacturaDiario(esInicial);
		this.setActivarrucFacturaDiario(esInicial);
		this.setActivarnumero_autorizaFacturaDiario(esInicial);
		this.setActivares_devolucionFacturaDiario(esInicial);
		this.setActivarvalor_facturaFacturaDiario(esInicial);
		this.setActivarbase_imponibleFacturaDiario(esInicial);
		this.setActivarmonto_ivaFacturaDiario(esInicial);
		this.setActivarbim_tarjetaFacturaDiario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.ID)) {
				this.setActivaridFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.IDPERIODODECLARA)) {
				this.setActivarid_periodo_declaraFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.IDTIPOIVA)) {
				this.setActivarid_tipo_ivaFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setActivarfecha_vencimientoFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.NUMEROSERIE)) {
				this.setActivarnumero_serieFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.RUC)) {
				this.setActivarrucFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.NUMEROAUTORIZA)) {
				this.setActivarnumero_autorizaFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.ESDEVOLUCION)) {
				this.setActivares_devolucionFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.VALORFACTURA)) {
				this.setActivarvalor_facturaFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.BASEIMPONIBLE)) {
				this.setActivarbase_imponibleFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.MONTOIVA)) {
				this.setActivarmonto_ivaFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.BIMTARJETA)) {
				this.setActivarbim_tarjetaFacturaDiario(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,FacturaDiarioBeanSwingJInternalFrame facturadiarioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridFacturaDiario(esInicial);
		this.setResaltarid_empresaFacturaDiario(esInicial);
		this.setResaltarid_sucursalFacturaDiario(esInicial);
		this.setResaltarid_clienteFacturaDiario(esInicial);
		this.setResaltarid_periodo_declaraFacturaDiario(esInicial);
		this.setResaltarid_tipo_ivaFacturaDiario(esInicial);
		this.setResaltarfecha_emisionFacturaDiario(esInicial);
		this.setResaltarfecha_vencimientoFacturaDiario(esInicial);
		this.setResaltarnumero_serieFacturaDiario(esInicial);
		this.setResaltarrucFacturaDiario(esInicial);
		this.setResaltarnumero_autorizaFacturaDiario(esInicial);
		this.setResaltares_devolucionFacturaDiario(esInicial);
		this.setResaltarvalor_facturaFacturaDiario(esInicial);
		this.setResaltarbase_imponibleFacturaDiario(esInicial);
		this.setResaltarmonto_ivaFacturaDiario(esInicial);
		this.setResaltarbim_tarjetaFacturaDiario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.ID)) {
				this.setResaltaridFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.IDPERIODODECLARA)) {
				this.setResaltarid_periodo_declaraFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.IDTIPOIVA)) {
				this.setResaltarid_tipo_ivaFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setResaltarfecha_vencimientoFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.NUMEROSERIE)) {
				this.setResaltarnumero_serieFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.RUC)) {
				this.setResaltarrucFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.NUMEROAUTORIZA)) {
				this.setResaltarnumero_autorizaFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.ESDEVOLUCION)) {
				this.setResaltares_devolucionFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.VALORFACTURA)) {
				this.setResaltarvalor_facturaFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.BASEIMPONIBLE)) {
				this.setResaltarbase_imponibleFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.MONTOIVA)) {
				this.setResaltarmonto_ivaFacturaDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDiarioConstantesFunciones.BIMTARJETA)) {
				this.setResaltarbim_tarjetaFacturaDiario(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,FacturaDiarioBeanSwingJInternalFrame facturadiarioBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdClienteFacturaDiario=true;

	public Boolean getMostrarFK_IdClienteFacturaDiario() {
		return this.mostrarFK_IdClienteFacturaDiario;
	}

	public void setMostrarFK_IdClienteFacturaDiario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteFacturaDiario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaFacturaDiario=true;

	public Boolean getMostrarFK_IdEmpresaFacturaDiario() {
		return this.mostrarFK_IdEmpresaFacturaDiario;
	}

	public void setMostrarFK_IdEmpresaFacturaDiario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaFacturaDiario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoDeclaraFacturaDiario=true;

	public Boolean getMostrarFK_IdPeriodoDeclaraFacturaDiario() {
		return this.mostrarFK_IdPeriodoDeclaraFacturaDiario;
	}

	public void setMostrarFK_IdPeriodoDeclaraFacturaDiario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoDeclaraFacturaDiario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalFacturaDiario=true;

	public Boolean getMostrarFK_IdSucursalFacturaDiario() {
		return this.mostrarFK_IdSucursalFacturaDiario;
	}

	public void setMostrarFK_IdSucursalFacturaDiario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalFacturaDiario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoIvaFacturaDiario=true;

	public Boolean getMostrarFK_IdTipoIvaFacturaDiario() {
		return this.mostrarFK_IdTipoIvaFacturaDiario;
	}

	public void setMostrarFK_IdTipoIvaFacturaDiario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoIvaFacturaDiario= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClienteFacturaDiario=true;

	public Boolean getActivarFK_IdClienteFacturaDiario() {
		return this.activarFK_IdClienteFacturaDiario;
	}

	public void setActivarFK_IdClienteFacturaDiario(Boolean habilitarResaltar) {
		this.activarFK_IdClienteFacturaDiario= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaFacturaDiario=true;

	public Boolean getActivarFK_IdEmpresaFacturaDiario() {
		return this.activarFK_IdEmpresaFacturaDiario;
	}

	public void setActivarFK_IdEmpresaFacturaDiario(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaFacturaDiario= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoDeclaraFacturaDiario=true;

	public Boolean getActivarFK_IdPeriodoDeclaraFacturaDiario() {
		return this.activarFK_IdPeriodoDeclaraFacturaDiario;
	}

	public void setActivarFK_IdPeriodoDeclaraFacturaDiario(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoDeclaraFacturaDiario= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalFacturaDiario=true;

	public Boolean getActivarFK_IdSucursalFacturaDiario() {
		return this.activarFK_IdSucursalFacturaDiario;
	}

	public void setActivarFK_IdSucursalFacturaDiario(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalFacturaDiario= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoIvaFacturaDiario=true;

	public Boolean getActivarFK_IdTipoIvaFacturaDiario() {
		return this.activarFK_IdTipoIvaFacturaDiario;
	}

	public void setActivarFK_IdTipoIvaFacturaDiario(Boolean habilitarResaltar) {
		this.activarFK_IdTipoIvaFacturaDiario= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClienteFacturaDiario=null;

	public Border getResaltarFK_IdClienteFacturaDiario() {
		return this.resaltarFK_IdClienteFacturaDiario;
	}

	public void setResaltarFK_IdClienteFacturaDiario(Border borderResaltar) {
		this.resaltarFK_IdClienteFacturaDiario= borderResaltar;
	}

	public void setResaltarFK_IdClienteFacturaDiario(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDiarioBeanSwingJInternalFrame facturadiarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteFacturaDiario= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaFacturaDiario=null;

	public Border getResaltarFK_IdEmpresaFacturaDiario() {
		return this.resaltarFK_IdEmpresaFacturaDiario;
	}

	public void setResaltarFK_IdEmpresaFacturaDiario(Border borderResaltar) {
		this.resaltarFK_IdEmpresaFacturaDiario= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaFacturaDiario(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDiarioBeanSwingJInternalFrame facturadiarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaFacturaDiario= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoDeclaraFacturaDiario=null;

	public Border getResaltarFK_IdPeriodoDeclaraFacturaDiario() {
		return this.resaltarFK_IdPeriodoDeclaraFacturaDiario;
	}

	public void setResaltarFK_IdPeriodoDeclaraFacturaDiario(Border borderResaltar) {
		this.resaltarFK_IdPeriodoDeclaraFacturaDiario= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoDeclaraFacturaDiario(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDiarioBeanSwingJInternalFrame facturadiarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoDeclaraFacturaDiario= borderResaltar;
	}

	public Border resaltarFK_IdSucursalFacturaDiario=null;

	public Border getResaltarFK_IdSucursalFacturaDiario() {
		return this.resaltarFK_IdSucursalFacturaDiario;
	}

	public void setResaltarFK_IdSucursalFacturaDiario(Border borderResaltar) {
		this.resaltarFK_IdSucursalFacturaDiario= borderResaltar;
	}

	public void setResaltarFK_IdSucursalFacturaDiario(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDiarioBeanSwingJInternalFrame facturadiarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalFacturaDiario= borderResaltar;
	}

	public Border resaltarFK_IdTipoIvaFacturaDiario=null;

	public Border getResaltarFK_IdTipoIvaFacturaDiario() {
		return this.resaltarFK_IdTipoIvaFacturaDiario;
	}

	public void setResaltarFK_IdTipoIvaFacturaDiario(Border borderResaltar) {
		this.resaltarFK_IdTipoIvaFacturaDiario= borderResaltar;
	}

	public void setResaltarFK_IdTipoIvaFacturaDiario(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDiarioBeanSwingJInternalFrame facturadiarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoIvaFacturaDiario= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}