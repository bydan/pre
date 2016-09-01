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
package com.bydan.erp.facturacion.util;

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


import com.bydan.erp.facturacion.util.RetencionConstantesFunciones;
import com.bydan.erp.facturacion.util.RetencionParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.RetencionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class RetencionConstantesFunciones extends RetencionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Retencion";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Retencion"+RetencionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="RetencionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="RetencionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=RetencionConstantesFunciones.SCHEMA+"_"+RetencionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/RetencionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=RetencionConstantesFunciones.SCHEMA+"_"+RetencionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=RetencionConstantesFunciones.SCHEMA+"_"+RetencionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/RetencionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=RetencionConstantesFunciones.SCHEMA+"_"+RetencionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RetencionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RetencionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RetencionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RetencionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RetencionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RetencionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=RetencionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+RetencionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=RetencionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+RetencionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Retenciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Retencion";
	public static final String SCLASSWEBTITULO_LOWER="Retencion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Retencion";
	public static final String OBJECTNAME="retencion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="retencion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select retencion from "+RetencionConstantesFunciones.SPERSISTENCENAME+" retencion";
	public static String QUERYSELECTNATIVE="select "+RetencionConstantesFunciones.SCHEMA+"."+RetencionConstantesFunciones.TABLENAME+".id,"+RetencionConstantesFunciones.SCHEMA+"."+RetencionConstantesFunciones.TABLENAME+".version_row,"+RetencionConstantesFunciones.SCHEMA+"."+RetencionConstantesFunciones.TABLENAME+".id_empresa,"+RetencionConstantesFunciones.SCHEMA+"."+RetencionConstantesFunciones.TABLENAME+".id_sucursal,"+RetencionConstantesFunciones.SCHEMA+"."+RetencionConstantesFunciones.TABLENAME+".id_ejercicio,"+RetencionConstantesFunciones.SCHEMA+"."+RetencionConstantesFunciones.TABLENAME+".id_periodo,"+RetencionConstantesFunciones.SCHEMA+"."+RetencionConstantesFunciones.TABLENAME+".id_anio,"+RetencionConstantesFunciones.SCHEMA+"."+RetencionConstantesFunciones.TABLENAME+".id_mes,"+RetencionConstantesFunciones.SCHEMA+"."+RetencionConstantesFunciones.TABLENAME+".id_asiento_contable,"+RetencionConstantesFunciones.SCHEMA+"."+RetencionConstantesFunciones.TABLENAME+".id_tipo_retencion,"+RetencionConstantesFunciones.SCHEMA+"."+RetencionConstantesFunciones.TABLENAME+".id_cliente,"+RetencionConstantesFunciones.SCHEMA+"."+RetencionConstantesFunciones.TABLENAME+".porcentaje,"+RetencionConstantesFunciones.SCHEMA+"."+RetencionConstantesFunciones.TABLENAME+".base_imponible,"+RetencionConstantesFunciones.SCHEMA+"."+RetencionConstantesFunciones.TABLENAME+".valor,"+RetencionConstantesFunciones.SCHEMA+"."+RetencionConstantesFunciones.TABLENAME+".numero,"+RetencionConstantesFunciones.SCHEMA+"."+RetencionConstantesFunciones.TABLENAME+".id_factura,"+RetencionConstantesFunciones.SCHEMA+"."+RetencionConstantesFunciones.TABLENAME+".descripcion,"+RetencionConstantesFunciones.SCHEMA+"."+RetencionConstantesFunciones.TABLENAME+".debito_mone_local,"+RetencionConstantesFunciones.SCHEMA+"."+RetencionConstantesFunciones.TABLENAME+".credito_mone_local,"+RetencionConstantesFunciones.SCHEMA+"."+RetencionConstantesFunciones.TABLENAME+".debito_mone_extra,"+RetencionConstantesFunciones.SCHEMA+"."+RetencionConstantesFunciones.TABLENAME+".credito_mone_extra,"+RetencionConstantesFunciones.SCHEMA+"."+RetencionConstantesFunciones.TABLENAME+".id_moneda,"+RetencionConstantesFunciones.SCHEMA+"."+RetencionConstantesFunciones.TABLENAME+".cotizacion,"+RetencionConstantesFunciones.SCHEMA+"."+RetencionConstantesFunciones.TABLENAME+".nombre_benef,"+RetencionConstantesFunciones.SCHEMA+"."+RetencionConstantesFunciones.TABLENAME+".direccion_benef,"+RetencionConstantesFunciones.SCHEMA+"."+RetencionConstantesFunciones.TABLENAME+".ruc_benef,"+RetencionConstantesFunciones.SCHEMA+"."+RetencionConstantesFunciones.TABLENAME+".telefono_benef,"+RetencionConstantesFunciones.SCHEMA+"."+RetencionConstantesFunciones.TABLENAME+".fecha,"+RetencionConstantesFunciones.SCHEMA+"."+RetencionConstantesFunciones.TABLENAME+".id_cuenta_contable_retencion,"+RetencionConstantesFunciones.SCHEMA+"."+RetencionConstantesFunciones.TABLENAME+".id_estado_retencion,"+RetencionConstantesFunciones.SCHEMA+"."+RetencionConstantesFunciones.TABLENAME+".beneficiario from "+RetencionConstantesFunciones.SCHEMA+"."+RetencionConstantesFunciones.TABLENAME;//+" as "+RetencionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected RetencionConstantesFuncionesAdditional retencionConstantesFuncionesAdditional=null;
	
	public RetencionConstantesFuncionesAdditional getRetencionConstantesFuncionesAdditional() {
		return this.retencionConstantesFuncionesAdditional;
	}
	
	public void setRetencionConstantesFuncionesAdditional(RetencionConstantesFuncionesAdditional retencionConstantesFuncionesAdditional) {
		try {
			this.retencionConstantesFuncionesAdditional=retencionConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String IDASIENTOCONTABLE= "id_asiento_contable";
    public static final String IDTIPORETENCION= "id_tipo_retencion";
    public static final String IDCLIENTE= "id_cliente";
    public static final String PORCENTAJE= "porcentaje";
    public static final String BASEIMPONIBLE= "base_imponible";
    public static final String VALOR= "valor";
    public static final String NUMERO= "numero";
    public static final String IDFACTURA= "id_factura";
    public static final String DESCRIPCION= "descripcion";
    public static final String DEBITOMONELOCAL= "debito_mone_local";
    public static final String CREDITOMONELOCAL= "credito_mone_local";
    public static final String DEBITOMONEEXTRA= "debito_mone_extra";
    public static final String CREDITOMONEEXTRA= "credito_mone_extra";
    public static final String IDMONEDA= "id_moneda";
    public static final String COTIZACION= "cotizacion";
    public static final String NOMBREBENEF= "nombre_benef";
    public static final String DIRECCIONBENEF= "direccion_benef";
    public static final String RUCBENEF= "ruc_benef";
    public static final String TELEFONOBENEF= "telefono_benef";
    public static final String FECHA= "fecha";
    public static final String IDCUENTACONTABLERETENCION= "id_cuenta_contable_retencion";
    public static final String IDESTADORETENCION= "id_estado_retencion";
    public static final String BENEFICIARIO= "beneficiario";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_IDASIENTOCONTABLE= "Asiento Contable";
		public static final String LABEL_IDASIENTOCONTABLE_LOWER= "Asiento Contable";
    	public static final String LABEL_IDTIPORETENCION= "Tipo Retencion";
		public static final String LABEL_IDTIPORETENCION_LOWER= "Tipo Retencion";
    	public static final String LABEL_IDCLIENTE= "Proveedor";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_PORCENTAJE= "Porcentaje(%)";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_BASEIMPONIBLE= "Base Imponible";
		public static final String LABEL_BASEIMPONIBLE_LOWER= "Base Imponible";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_NUMERO= "No Retencion";
		public static final String LABEL_NUMERO_LOWER= "Numero";
    	public static final String LABEL_IDFACTURA= "Factura";
		public static final String LABEL_IDFACTURA_LOWER= "Factura";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_DEBITOMONELOCAL= "Debito Local";
		public static final String LABEL_DEBITOMONELOCAL_LOWER= "Debito Mone Local";
    	public static final String LABEL_CREDITOMONELOCAL= "Credito Local";
		public static final String LABEL_CREDITOMONELOCAL_LOWER= "Credito Mone Local";
    	public static final String LABEL_DEBITOMONEEXTRA= "Debito Extran";
		public static final String LABEL_DEBITOMONEEXTRA_LOWER= "Debito Mone Extra";
    	public static final String LABEL_CREDITOMONEEXTRA= "Credito Extran";
		public static final String LABEL_CREDITOMONEEXTRA_LOWER= "Credito Mone Extra";
    	public static final String LABEL_IDMONEDA= "Moneda";
		public static final String LABEL_IDMONEDA_LOWER= "Moneda";
    	public static final String LABEL_COTIZACION= "Cotizacion";
		public static final String LABEL_COTIZACION_LOWER= "Cotizacion";
    	public static final String LABEL_NOMBREBENEF= "Nombre";
		public static final String LABEL_NOMBREBENEF_LOWER= "Nombre Benef";
    	public static final String LABEL_DIRECCIONBENEF= "Direccion";
		public static final String LABEL_DIRECCIONBENEF_LOWER= "Direccion Benef";
    	public static final String LABEL_RUCBENEF= "Ruc";
		public static final String LABEL_RUCBENEF_LOWER= "Ruc Benef";
    	public static final String LABEL_TELEFONOBENEF= "Telefono";
		public static final String LABEL_TELEFONOBENEF_LOWER= "Telefono Benef";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_IDCUENTACONTABLERETENCION= "Cuenta Retencion";
		public static final String LABEL_IDCUENTACONTABLERETENCION_LOWER= "Cuenta Contable Retencion";
    	public static final String LABEL_IDESTADORETENCION= "Estado Retencion";
		public static final String LABEL_IDESTADORETENCION_LOWER= "Estado Retencion";
    	public static final String LABEL_BENEFICIARIO= "Beneficiario";
		public static final String LABEL_BENEFICIARIO_LOWER= "Beneficiario";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_BENEF=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_BENEF=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDIRECCION_BENEF=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION_BENEF=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXRUC_BENEF=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC_BENEF=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO_BENEF=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO_BENEF=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
		
		
		
	public static final String SREGEXBENEFICIARIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXBENEFICIARIO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getRetencionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(RetencionConstantesFunciones.IDEMPRESA)) {sLabelColumna=RetencionConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(RetencionConstantesFunciones.IDSUCURSAL)) {sLabelColumna=RetencionConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(RetencionConstantesFunciones.IDEJERCICIO)) {sLabelColumna=RetencionConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(RetencionConstantesFunciones.IDPERIODO)) {sLabelColumna=RetencionConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(RetencionConstantesFunciones.IDANIO)) {sLabelColumna=RetencionConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(RetencionConstantesFunciones.IDMES)) {sLabelColumna=RetencionConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(RetencionConstantesFunciones.IDASIENTOCONTABLE)) {sLabelColumna=RetencionConstantesFunciones.LABEL_IDASIENTOCONTABLE;}
		if(sNombreColumna.equals(RetencionConstantesFunciones.IDTIPORETENCION)) {sLabelColumna=RetencionConstantesFunciones.LABEL_IDTIPORETENCION;}
		if(sNombreColumna.equals(RetencionConstantesFunciones.IDCLIENTE)) {sLabelColumna=RetencionConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(RetencionConstantesFunciones.PORCENTAJE)) {sLabelColumna=RetencionConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(RetencionConstantesFunciones.BASEIMPONIBLE)) {sLabelColumna=RetencionConstantesFunciones.LABEL_BASEIMPONIBLE;}
		if(sNombreColumna.equals(RetencionConstantesFunciones.VALOR)) {sLabelColumna=RetencionConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(RetencionConstantesFunciones.NUMERO)) {sLabelColumna=RetencionConstantesFunciones.LABEL_NUMERO;}
		if(sNombreColumna.equals(RetencionConstantesFunciones.IDFACTURA)) {sLabelColumna=RetencionConstantesFunciones.LABEL_IDFACTURA;}
		if(sNombreColumna.equals(RetencionConstantesFunciones.DESCRIPCION)) {sLabelColumna=RetencionConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(RetencionConstantesFunciones.DEBITOMONELOCAL)) {sLabelColumna=RetencionConstantesFunciones.LABEL_DEBITOMONELOCAL;}
		if(sNombreColumna.equals(RetencionConstantesFunciones.CREDITOMONELOCAL)) {sLabelColumna=RetencionConstantesFunciones.LABEL_CREDITOMONELOCAL;}
		if(sNombreColumna.equals(RetencionConstantesFunciones.DEBITOMONEEXTRA)) {sLabelColumna=RetencionConstantesFunciones.LABEL_DEBITOMONEEXTRA;}
		if(sNombreColumna.equals(RetencionConstantesFunciones.CREDITOMONEEXTRA)) {sLabelColumna=RetencionConstantesFunciones.LABEL_CREDITOMONEEXTRA;}
		if(sNombreColumna.equals(RetencionConstantesFunciones.IDMONEDA)) {sLabelColumna=RetencionConstantesFunciones.LABEL_IDMONEDA;}
		if(sNombreColumna.equals(RetencionConstantesFunciones.COTIZACION)) {sLabelColumna=RetencionConstantesFunciones.LABEL_COTIZACION;}
		if(sNombreColumna.equals(RetencionConstantesFunciones.NOMBREBENEF)) {sLabelColumna=RetencionConstantesFunciones.LABEL_NOMBREBENEF;}
		if(sNombreColumna.equals(RetencionConstantesFunciones.DIRECCIONBENEF)) {sLabelColumna=RetencionConstantesFunciones.LABEL_DIRECCIONBENEF;}
		if(sNombreColumna.equals(RetencionConstantesFunciones.RUCBENEF)) {sLabelColumna=RetencionConstantesFunciones.LABEL_RUCBENEF;}
		if(sNombreColumna.equals(RetencionConstantesFunciones.TELEFONOBENEF)) {sLabelColumna=RetencionConstantesFunciones.LABEL_TELEFONOBENEF;}
		if(sNombreColumna.equals(RetencionConstantesFunciones.FECHA)) {sLabelColumna=RetencionConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(RetencionConstantesFunciones.IDCUENTACONTABLERETENCION)) {sLabelColumna=RetencionConstantesFunciones.LABEL_IDCUENTACONTABLERETENCION;}
		if(sNombreColumna.equals(RetencionConstantesFunciones.IDESTADORETENCION)) {sLabelColumna=RetencionConstantesFunciones.LABEL_IDESTADORETENCION;}
		if(sNombreColumna.equals(RetencionConstantesFunciones.BENEFICIARIO)) {sLabelColumna=RetencionConstantesFunciones.LABEL_BENEFICIARIO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getRetencionDescripcion(Retencion retencion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(retencion !=null/* && retencion.getId()!=0*/) {
			if(retencion.getId()!=null) {
				sDescripcion=retencion.getId().toString();
			}//retencionretencion.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getRetencionDescripcionDetallado(Retencion retencion) {
		String sDescripcion="";
			
		sDescripcion+=RetencionConstantesFunciones.ID+"=";
		sDescripcion+=retencion.getId().toString()+",";
		sDescripcion+=RetencionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=retencion.getVersionRow().toString()+",";
		sDescripcion+=RetencionConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=retencion.getid_empresa().toString()+",";
		sDescripcion+=RetencionConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=retencion.getid_sucursal().toString()+",";
		sDescripcion+=RetencionConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=retencion.getid_ejercicio().toString()+",";
		sDescripcion+=RetencionConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=retencion.getid_periodo().toString()+",";
		sDescripcion+=RetencionConstantesFunciones.IDANIO+"=";
		sDescripcion+=retencion.getid_anio().toString()+",";
		sDescripcion+=RetencionConstantesFunciones.IDMES+"=";
		sDescripcion+=retencion.getid_mes().toString()+",";
		sDescripcion+=RetencionConstantesFunciones.IDASIENTOCONTABLE+"=";
		sDescripcion+=retencion.getid_asiento_contable().toString()+",";
		sDescripcion+=RetencionConstantesFunciones.IDTIPORETENCION+"=";
		sDescripcion+=retencion.getid_tipo_retencion().toString()+",";
		sDescripcion+=RetencionConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=retencion.getid_cliente().toString()+",";
		sDescripcion+=RetencionConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=retencion.getporcentaje().toString()+",";
		sDescripcion+=RetencionConstantesFunciones.BASEIMPONIBLE+"=";
		sDescripcion+=retencion.getbase_imponible().toString()+",";
		sDescripcion+=RetencionConstantesFunciones.VALOR+"=";
		sDescripcion+=retencion.getvalor().toString()+",";
		sDescripcion+=RetencionConstantesFunciones.NUMERO+"=";
		sDescripcion+=retencion.getnumero()+",";
		sDescripcion+=RetencionConstantesFunciones.IDFACTURA+"=";
		sDescripcion+=retencion.getid_factura().toString()+",";
		sDescripcion+=RetencionConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=retencion.getdescripcion()+",";
		sDescripcion+=RetencionConstantesFunciones.DEBITOMONELOCAL+"=";
		sDescripcion+=retencion.getdebito_mone_local().toString()+",";
		sDescripcion+=RetencionConstantesFunciones.CREDITOMONELOCAL+"=";
		sDescripcion+=retencion.getcredito_mone_local().toString()+",";
		sDescripcion+=RetencionConstantesFunciones.DEBITOMONEEXTRA+"=";
		sDescripcion+=retencion.getdebito_mone_extra().toString()+",";
		sDescripcion+=RetencionConstantesFunciones.CREDITOMONEEXTRA+"=";
		sDescripcion+=retencion.getcredito_mone_extra().toString()+",";
		sDescripcion+=RetencionConstantesFunciones.IDMONEDA+"=";
		sDescripcion+=retencion.getid_moneda().toString()+",";
		sDescripcion+=RetencionConstantesFunciones.COTIZACION+"=";
		sDescripcion+=retencion.getcotizacion().toString()+",";
		sDescripcion+=RetencionConstantesFunciones.NOMBREBENEF+"=";
		sDescripcion+=retencion.getnombre_benef()+",";
		sDescripcion+=RetencionConstantesFunciones.DIRECCIONBENEF+"=";
		sDescripcion+=retencion.getdireccion_benef()+",";
		sDescripcion+=RetencionConstantesFunciones.RUCBENEF+"=";
		sDescripcion+=retencion.getruc_benef()+",";
		sDescripcion+=RetencionConstantesFunciones.TELEFONOBENEF+"=";
		sDescripcion+=retencion.gettelefono_benef()+",";
		sDescripcion+=RetencionConstantesFunciones.FECHA+"=";
		sDescripcion+=retencion.getfecha().toString()+",";
		sDescripcion+=RetencionConstantesFunciones.IDCUENTACONTABLERETENCION+"=";
		sDescripcion+=retencion.getid_cuenta_contable_retencion().toString()+",";
		sDescripcion+=RetencionConstantesFunciones.IDESTADORETENCION+"=";
		sDescripcion+=retencion.getid_estado_retencion().toString()+",";
		sDescripcion+=RetencionConstantesFunciones.BENEFICIARIO+"=";
		sDescripcion+=retencion.getbeneficiario()+",";
			
		return sDescripcion;
	}
	
	public static void setRetencionDescripcion(Retencion retencion,String sValor) throws Exception {			
		if(retencion !=null) {
			//retencionretencion.getId().toString();
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

	public static String getEjercicioDescripcion(Ejercicio ejercicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ejercicio!=null/*&&ejercicio.getId()>0*/) {
			sDescripcion=EjercicioConstantesFunciones.getEjercicioDescripcion(ejercicio);
		}

		return sDescripcion;
	}

	public static String getPeriodoDescripcion(Periodo periodo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(periodo!=null/*&&periodo.getId()>0*/) {
			sDescripcion=PeriodoConstantesFunciones.getPeriodoDescripcion(periodo);
		}

		return sDescripcion;
	}

	public static String getAnioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}

	public static String getMesDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mes!=null/*&&mes.getId()>0*/) {
			sDescripcion=MesConstantesFunciones.getMesDescripcion(mes);
		}

		return sDescripcion;
	}

	public static String getAsientoContableDescripcion(AsientoContable asientocontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(asientocontable!=null/*&&asientocontable.getId()>0*/) {
			sDescripcion=AsientoContableConstantesFunciones.getAsientoContableDescripcion(asientocontable);
		}

		return sDescripcion;
	}

	public static String getTipoRetencionDescripcion(TipoRetencion tiporetencion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiporetencion!=null/*&&tiporetencion.getId()>0*/) {
			sDescripcion=TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(tiporetencion);
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

	public static String getFacturaDescripcion(Factura factura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(factura!=null/*&&factura.getId()>0*/) {
			sDescripcion=FacturaConstantesFunciones.getFacturaDescripcion(factura);
		}

		return sDescripcion;
	}

	public static String getMonedaDescripcion(Moneda moneda) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(moneda!=null/*&&moneda.getId()>0*/) {
			sDescripcion=MonedaConstantesFunciones.getMonedaDescripcion(moneda);
		}

		return sDescripcion;
	}

	public static String getCuentaContableRetencionDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getEstadoRetencionDescripcion(EstadoRetencion estadoretencion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadoretencion!=null/*&&estadoretencion.getId()>0*/) {
			sDescripcion=EstadoRetencionConstantesFunciones.getEstadoRetencionDescripcion(estadoretencion);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdAsientoContable")) {
			sNombreIndice="Tipo=  Por Asiento Contable";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Proveedor";
		} else if(sNombreIndice.equals("FK_IdCuentaContableRetencion")) {
			sNombreIndice="Tipo=  Por Cuenta Retencion";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoRetencion")) {
			sNombreIndice="Tipo=  Por Estado Retencion";
		} else if(sNombreIndice.equals("FK_IdFactura")) {
			sNombreIndice="Tipo=  Por Factura";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdMoneda")) {
			sNombreIndice="Tipo=  Por Moneda";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoRetencion")) {
			sNombreIndice="Tipo=  Por Tipo Retencion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdAsientoContable(Long id_asiento_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_asiento_contable!=null) {sDetalleIndice+=" Codigo Unico De Asiento Contable="+id_asiento_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Proveedor="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableRetencion(Long id_cuenta_contable_retencion) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_retencion!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Retencion="+id_cuenta_contable_retencion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoRetencion(Long id_estado_retencion) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_retencion!=null) {sDetalleIndice+=" Codigo Unico De Estado Retencion="+id_estado_retencion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFactura(Long id_factura) {
		String sDetalleIndice=" Parametros->";
		if(id_factura!=null) {sDetalleIndice+=" Codigo Unico De Factura="+id_factura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMoneda(Long id_moneda) {
		String sDetalleIndice=" Parametros->";
		if(id_moneda!=null) {sDetalleIndice+=" Codigo Unico De Moneda="+id_moneda.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoRetencion(Long id_tipo_retencion) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_retencion!=null) {sDetalleIndice+=" Codigo Unico De Tipo Retencion="+id_tipo_retencion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosRetencion(Retencion retencion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		retencion.setnumero(retencion.getnumero().trim());
		retencion.setdescripcion(retencion.getdescripcion().trim());
		retencion.setnombre_benef(retencion.getnombre_benef().trim());
		retencion.setdireccion_benef(retencion.getdireccion_benef().trim());
		retencion.setruc_benef(retencion.getruc_benef().trim());
		retencion.settelefono_benef(retencion.gettelefono_benef().trim());
		retencion.setbeneficiario(retencion.getbeneficiario().trim());
	}
	
	public static void quitarEspaciosRetencions(List<Retencion> retencions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Retencion retencion: retencions) {
			retencion.setnumero(retencion.getnumero().trim());
			retencion.setdescripcion(retencion.getdescripcion().trim());
			retencion.setnombre_benef(retencion.getnombre_benef().trim());
			retencion.setdireccion_benef(retencion.getdireccion_benef().trim());
			retencion.setruc_benef(retencion.getruc_benef().trim());
			retencion.settelefono_benef(retencion.gettelefono_benef().trim());
			retencion.setbeneficiario(retencion.getbeneficiario().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRetencion(Retencion retencion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && retencion.getConCambioAuxiliar()) {
			retencion.setIsDeleted(retencion.getIsDeletedAuxiliar());	
			retencion.setIsNew(retencion.getIsNewAuxiliar());	
			retencion.setIsChanged(retencion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			retencion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			retencion.setIsDeletedAuxiliar(false);	
			retencion.setIsNewAuxiliar(false);	
			retencion.setIsChangedAuxiliar(false);
			
			retencion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRetencions(List<Retencion> retencions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Retencion retencion : retencions) {
			if(conAsignarBase && retencion.getConCambioAuxiliar()) {
				retencion.setIsDeleted(retencion.getIsDeletedAuxiliar());	
				retencion.setIsNew(retencion.getIsNewAuxiliar());	
				retencion.setIsChanged(retencion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				retencion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				retencion.setIsDeletedAuxiliar(false);	
				retencion.setIsNewAuxiliar(false);	
				retencion.setIsChangedAuxiliar(false);
				
				retencion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresRetencion(Retencion retencion,Boolean conEnteros) throws Exception  {
		retencion.setporcentaje(0.0);
		retencion.setbase_imponible(0.0);
		retencion.setvalor(0.0);
		retencion.setdebito_mone_local(0.0);
		retencion.setcredito_mone_local(0.0);
		retencion.setdebito_mone_extra(0.0);
		retencion.setcredito_mone_extra(0.0);
		retencion.setcotizacion(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresRetencions(List<Retencion> retencions,Boolean conEnteros) throws Exception  {
		
		for(Retencion retencion: retencions) {
			retencion.setporcentaje(0.0);
			retencion.setbase_imponible(0.0);
			retencion.setvalor(0.0);
			retencion.setdebito_mone_local(0.0);
			retencion.setcredito_mone_local(0.0);
			retencion.setdebito_mone_extra(0.0);
			retencion.setcredito_mone_extra(0.0);
			retencion.setcotizacion(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaRetencion(List<Retencion> retencions,Retencion retencionAux) throws Exception  {
		RetencionConstantesFunciones.InicializarValoresRetencion(retencionAux,true);
		
		for(Retencion retencion: retencions) {
			if(retencion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			retencionAux.setporcentaje(retencionAux.getporcentaje()+retencion.getporcentaje());			
			retencionAux.setbase_imponible(retencionAux.getbase_imponible()+retencion.getbase_imponible());			
			retencionAux.setvalor(retencionAux.getvalor()+retencion.getvalor());			
			retencionAux.setdebito_mone_local(retencionAux.getdebito_mone_local()+retencion.getdebito_mone_local());			
			retencionAux.setcredito_mone_local(retencionAux.getcredito_mone_local()+retencion.getcredito_mone_local());			
			retencionAux.setdebito_mone_extra(retencionAux.getdebito_mone_extra()+retencion.getdebito_mone_extra());			
			retencionAux.setcredito_mone_extra(retencionAux.getcredito_mone_extra()+retencion.getcredito_mone_extra());			
			retencionAux.setcotizacion(retencionAux.getcotizacion()+retencion.getcotizacion());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesRetencion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=RetencionConstantesFunciones.getArrayColumnasGlobalesRetencion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesRetencion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RetencionConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RetencionConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RetencionConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RetencionConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RetencionConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RetencionConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RetencionConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RetencionConstantesFunciones.IDPERIODO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RetencionConstantesFunciones.IDMONEDA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RetencionConstantesFunciones.IDMONEDA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoRetencion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Retencion> retencions,Retencion retencion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Retencion retencionAux: retencions) {
			if(retencionAux!=null && retencion!=null) {
				if((retencionAux.getId()==null && retencion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(retencionAux.getId()!=null && retencion.getId()!=null){
					if(retencionAux.getId().equals(retencion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaRetencion(List<Retencion> retencions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
		Double base_imponibleTotal=0.0;
		Double valorTotal=0.0;
		Double debito_mone_localTotal=0.0;
		Double credito_mone_localTotal=0.0;
		Double debito_mone_extraTotal=0.0;
		Double credito_mone_extraTotal=0.0;
		Double cotizacionTotal=0.0;
	
		for(Retencion retencion: retencions) {			
			if(retencion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=retencion.getporcentaje();
			base_imponibleTotal+=retencion.getbase_imponible();
			valorTotal+=retencion.getvalor();
			debito_mone_localTotal+=retencion.getdebito_mone_local();
			credito_mone_localTotal+=retencion.getcredito_mone_local();
			debito_mone_extraTotal+=retencion.getdebito_mone_extra();
			credito_mone_extraTotal+=retencion.getcredito_mone_extra();
			cotizacionTotal+=retencion.getcotizacion();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RetencionConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(RetencionConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RetencionConstantesFunciones.BASEIMPONIBLE);
		datoGeneral.setsDescripcion(RetencionConstantesFunciones.LABEL_BASEIMPONIBLE);
		datoGeneral.setdValorDouble(base_imponibleTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RetencionConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(RetencionConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RetencionConstantesFunciones.DEBITOMONELOCAL);
		datoGeneral.setsDescripcion(RetencionConstantesFunciones.LABEL_DEBITOMONELOCAL);
		datoGeneral.setdValorDouble(debito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RetencionConstantesFunciones.CREDITOMONELOCAL);
		datoGeneral.setsDescripcion(RetencionConstantesFunciones.LABEL_CREDITOMONELOCAL);
		datoGeneral.setdValorDouble(credito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RetencionConstantesFunciones.DEBITOMONEEXTRA);
		datoGeneral.setsDescripcion(RetencionConstantesFunciones.LABEL_DEBITOMONEEXTRA);
		datoGeneral.setdValorDouble(debito_mone_extraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RetencionConstantesFunciones.CREDITOMONEEXTRA);
		datoGeneral.setsDescripcion(RetencionConstantesFunciones.LABEL_CREDITOMONEEXTRA);
		datoGeneral.setdValorDouble(credito_mone_extraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RetencionConstantesFunciones.COTIZACION);
		datoGeneral.setsDescripcion(RetencionConstantesFunciones.LABEL_COTIZACION);
		datoGeneral.setdValorDouble(cotizacionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaRetencion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,RetencionConstantesFunciones.LABEL_ID, RetencionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionConstantesFunciones.LABEL_VERSIONROW, RetencionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionConstantesFunciones.LABEL_IDEMPRESA, RetencionConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionConstantesFunciones.LABEL_IDSUCURSAL, RetencionConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionConstantesFunciones.LABEL_IDEJERCICIO, RetencionConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionConstantesFunciones.LABEL_IDPERIODO, RetencionConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionConstantesFunciones.LABEL_IDANIO, RetencionConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionConstantesFunciones.LABEL_IDMES, RetencionConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionConstantesFunciones.LABEL_IDASIENTOCONTABLE, RetencionConstantesFunciones.IDASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionConstantesFunciones.LABEL_IDTIPORETENCION, RetencionConstantesFunciones.IDTIPORETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionConstantesFunciones.LABEL_IDCLIENTE, RetencionConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionConstantesFunciones.LABEL_PORCENTAJE, RetencionConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionConstantesFunciones.LABEL_BASEIMPONIBLE, RetencionConstantesFunciones.BASEIMPONIBLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionConstantesFunciones.LABEL_VALOR, RetencionConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionConstantesFunciones.LABEL_NUMERO, RetencionConstantesFunciones.NUMERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionConstantesFunciones.LABEL_IDFACTURA, RetencionConstantesFunciones.IDFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionConstantesFunciones.LABEL_DESCRIPCION, RetencionConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionConstantesFunciones.LABEL_DEBITOMONELOCAL, RetencionConstantesFunciones.DEBITOMONELOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionConstantesFunciones.LABEL_CREDITOMONELOCAL, RetencionConstantesFunciones.CREDITOMONELOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionConstantesFunciones.LABEL_DEBITOMONEEXTRA, RetencionConstantesFunciones.DEBITOMONEEXTRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionConstantesFunciones.LABEL_CREDITOMONEEXTRA, RetencionConstantesFunciones.CREDITOMONEEXTRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionConstantesFunciones.LABEL_IDMONEDA, RetencionConstantesFunciones.IDMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionConstantesFunciones.LABEL_COTIZACION, RetencionConstantesFunciones.COTIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionConstantesFunciones.LABEL_NOMBREBENEF, RetencionConstantesFunciones.NOMBREBENEF,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionConstantesFunciones.LABEL_DIRECCIONBENEF, RetencionConstantesFunciones.DIRECCIONBENEF,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionConstantesFunciones.LABEL_RUCBENEF, RetencionConstantesFunciones.RUCBENEF,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionConstantesFunciones.LABEL_TELEFONOBENEF, RetencionConstantesFunciones.TELEFONOBENEF,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionConstantesFunciones.LABEL_FECHA, RetencionConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionConstantesFunciones.LABEL_IDCUENTACONTABLERETENCION, RetencionConstantesFunciones.IDCUENTACONTABLERETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionConstantesFunciones.LABEL_IDESTADORETENCION, RetencionConstantesFunciones.IDESTADORETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionConstantesFunciones.LABEL_BENEFICIARIO, RetencionConstantesFunciones.BENEFICIARIO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasRetencion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=RetencionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionConstantesFunciones.IDASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionConstantesFunciones.IDTIPORETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionConstantesFunciones.BASEIMPONIBLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionConstantesFunciones.NUMERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionConstantesFunciones.IDFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionConstantesFunciones.DEBITOMONELOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionConstantesFunciones.CREDITOMONELOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionConstantesFunciones.DEBITOMONEEXTRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionConstantesFunciones.CREDITOMONEEXTRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionConstantesFunciones.IDMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionConstantesFunciones.COTIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionConstantesFunciones.NOMBREBENEF;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionConstantesFunciones.DIRECCIONBENEF;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionConstantesFunciones.RUCBENEF;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionConstantesFunciones.TELEFONOBENEF;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionConstantesFunciones.IDCUENTACONTABLERETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionConstantesFunciones.IDESTADORETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionConstantesFunciones.BENEFICIARIO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRetencion() throws Exception  {
		return RetencionConstantesFunciones.getTiposSeleccionarRetencion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRetencion(Boolean conFk) throws Exception  {
		return RetencionConstantesFunciones.getTiposSeleccionarRetencion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRetencion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(RetencionConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(RetencionConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(RetencionConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(RetencionConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(RetencionConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(RetencionConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionConstantesFunciones.LABEL_IDASIENTOCONTABLE);
			reporte.setsDescripcion(RetencionConstantesFunciones.LABEL_IDASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionConstantesFunciones.LABEL_IDTIPORETENCION);
			reporte.setsDescripcion(RetencionConstantesFunciones.LABEL_IDTIPORETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(RetencionConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(RetencionConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionConstantesFunciones.LABEL_BASEIMPONIBLE);
			reporte.setsDescripcion(RetencionConstantesFunciones.LABEL_BASEIMPONIBLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(RetencionConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionConstantesFunciones.LABEL_NUMERO);
			reporte.setsDescripcion(RetencionConstantesFunciones.LABEL_NUMERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionConstantesFunciones.LABEL_IDFACTURA);
			reporte.setsDescripcion(RetencionConstantesFunciones.LABEL_IDFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(RetencionConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionConstantesFunciones.LABEL_DEBITOMONELOCAL);
			reporte.setsDescripcion(RetencionConstantesFunciones.LABEL_DEBITOMONELOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionConstantesFunciones.LABEL_CREDITOMONELOCAL);
			reporte.setsDescripcion(RetencionConstantesFunciones.LABEL_CREDITOMONELOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionConstantesFunciones.LABEL_DEBITOMONEEXTRA);
			reporte.setsDescripcion(RetencionConstantesFunciones.LABEL_DEBITOMONEEXTRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionConstantesFunciones.LABEL_CREDITOMONEEXTRA);
			reporte.setsDescripcion(RetencionConstantesFunciones.LABEL_CREDITOMONEEXTRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionConstantesFunciones.LABEL_IDMONEDA);
			reporte.setsDescripcion(RetencionConstantesFunciones.LABEL_IDMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionConstantesFunciones.LABEL_COTIZACION);
			reporte.setsDescripcion(RetencionConstantesFunciones.LABEL_COTIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionConstantesFunciones.LABEL_NOMBREBENEF);
			reporte.setsDescripcion(RetencionConstantesFunciones.LABEL_NOMBREBENEF);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionConstantesFunciones.LABEL_DIRECCIONBENEF);
			reporte.setsDescripcion(RetencionConstantesFunciones.LABEL_DIRECCIONBENEF);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionConstantesFunciones.LABEL_RUCBENEF);
			reporte.setsDescripcion(RetencionConstantesFunciones.LABEL_RUCBENEF);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionConstantesFunciones.LABEL_TELEFONOBENEF);
			reporte.setsDescripcion(RetencionConstantesFunciones.LABEL_TELEFONOBENEF);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(RetencionConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionConstantesFunciones.LABEL_IDCUENTACONTABLERETENCION);
			reporte.setsDescripcion(RetencionConstantesFunciones.LABEL_IDCUENTACONTABLERETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionConstantesFunciones.LABEL_IDESTADORETENCION);
			reporte.setsDescripcion(RetencionConstantesFunciones.LABEL_IDESTADORETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionConstantesFunciones.LABEL_BENEFICIARIO);
			reporte.setsDescripcion(RetencionConstantesFunciones.LABEL_BENEFICIARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesRetencion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesRetencion(Retencion retencionAux) throws Exception {
		
			retencionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(retencionAux.getEmpresa()));
			retencionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(retencionAux.getSucursal()));
			retencionAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(retencionAux.getEjercicio()));
			retencionAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(retencionAux.getPeriodo()));
			retencionAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(retencionAux.getAnio()));
			retencionAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(retencionAux.getMes()));
			retencionAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(retencionAux.getAsientoContable()));
			retencionAux.settiporetencion_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(retencionAux.getTipoRetencion()));
			retencionAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(retencionAux.getCliente()));
			retencionAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(retencionAux.getFactura()));
			retencionAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(retencionAux.getMoneda()));
			retencionAux.setcuentacontableretencion_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(retencionAux.getCuentaContableRetencion()));
			retencionAux.setestadoretencion_descripcion(EstadoRetencionConstantesFunciones.getEstadoRetencionDescripcion(retencionAux.getEstadoRetencion()));		
	}
	
	public static void refrescarForeignKeysDescripcionesRetencion(List<Retencion> retencionsTemp) throws Exception {
		for(Retencion retencionAux:retencionsTemp) {
			
			retencionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(retencionAux.getEmpresa()));
			retencionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(retencionAux.getSucursal()));
			retencionAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(retencionAux.getEjercicio()));
			retencionAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(retencionAux.getPeriodo()));
			retencionAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(retencionAux.getAnio()));
			retencionAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(retencionAux.getMes()));
			retencionAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(retencionAux.getAsientoContable()));
			retencionAux.settiporetencion_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(retencionAux.getTipoRetencion()));
			retencionAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(retencionAux.getCliente()));
			retencionAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(retencionAux.getFactura()));
			retencionAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(retencionAux.getMoneda()));
			retencionAux.setcuentacontableretencion_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(retencionAux.getCuentaContableRetencion()));
			retencionAux.setestadoretencion_descripcion(EstadoRetencionConstantesFunciones.getEstadoRetencionDescripcion(retencionAux.getEstadoRetencion()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfRetencion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(AsientoContable.class));
				classes.add(new Classe(TipoRetencion.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Factura.class));
				classes.add(new Classe(Moneda.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(EstadoRetencion.class));
				
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
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Periodo.class)) {
						classes.add(new Classe(Periodo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(AsientoContable.class)) {
						classes.add(new Classe(AsientoContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoRetencion.class)) {
						classes.add(new Classe(TipoRetencion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Factura.class)) {
						classes.add(new Classe(Factura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Moneda.class)) {
						classes.add(new Classe(Moneda.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoRetencion.class)) {
						classes.add(new Classe(EstadoRetencion.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfRetencion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(EstadoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoRetencion.class)); continue;
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

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(EstadoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoRetencion.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfRetencion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return RetencionConstantesFunciones.getClassesRelationshipsOfRetencion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRetencion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRetencion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return RetencionConstantesFunciones.getClassesRelationshipsFromStringsOfRetencion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRetencion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Retencion retencion,List<Retencion> retencions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Retencion retencionEncontrado=null;
			
			for(Retencion retencionLocal:retencions) {
				if(retencionLocal.getId().equals(retencion.getId())) {
					retencionEncontrado=retencionLocal;
					
					retencionLocal.setIsChanged(retencion.getIsChanged());
					retencionLocal.setIsNew(retencion.getIsNew());
					retencionLocal.setIsDeleted(retencion.getIsDeleted());
					
					retencionLocal.setGeneralEntityOriginal(retencion.getGeneralEntityOriginal());
					
					retencionLocal.setId(retencion.getId());	
					retencionLocal.setVersionRow(retencion.getVersionRow());	
					retencionLocal.setid_empresa(retencion.getid_empresa());	
					retencionLocal.setid_sucursal(retencion.getid_sucursal());	
					retencionLocal.setid_ejercicio(retencion.getid_ejercicio());	
					retencionLocal.setid_periodo(retencion.getid_periodo());	
					retencionLocal.setid_anio(retencion.getid_anio());	
					retencionLocal.setid_mes(retencion.getid_mes());	
					retencionLocal.setid_asiento_contable(retencion.getid_asiento_contable());	
					retencionLocal.setid_tipo_retencion(retencion.getid_tipo_retencion());	
					retencionLocal.setid_cliente(retencion.getid_cliente());	
					retencionLocal.setporcentaje(retencion.getporcentaje());	
					retencionLocal.setbase_imponible(retencion.getbase_imponible());	
					retencionLocal.setvalor(retencion.getvalor());	
					retencionLocal.setnumero(retencion.getnumero());	
					retencionLocal.setid_factura(retencion.getid_factura());	
					retencionLocal.setdescripcion(retencion.getdescripcion());	
					retencionLocal.setdebito_mone_local(retencion.getdebito_mone_local());	
					retencionLocal.setcredito_mone_local(retencion.getcredito_mone_local());	
					retencionLocal.setdebito_mone_extra(retencion.getdebito_mone_extra());	
					retencionLocal.setcredito_mone_extra(retencion.getcredito_mone_extra());	
					retencionLocal.setid_moneda(retencion.getid_moneda());	
					retencionLocal.setcotizacion(retencion.getcotizacion());	
					retencionLocal.setnombre_benef(retencion.getnombre_benef());	
					retencionLocal.setdireccion_benef(retencion.getdireccion_benef());	
					retencionLocal.setruc_benef(retencion.getruc_benef());	
					retencionLocal.settelefono_benef(retencion.gettelefono_benef());	
					retencionLocal.setfecha(retencion.getfecha());	
					retencionLocal.setid_cuenta_contable_retencion(retencion.getid_cuenta_contable_retencion());	
					retencionLocal.setid_estado_retencion(retencion.getid_estado_retencion());	
					retencionLocal.setbeneficiario(retencion.getbeneficiario());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!retencion.getIsDeleted()) {
				if(!existe) {
					retencions.add(retencion);
				}
			} else {
				if(retencionEncontrado!=null && permiteQuitar)  {
					retencions.remove(retencionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Retencion retencion,List<Retencion> retencions) throws Exception {
		try	{			
			for(Retencion retencionLocal:retencions) {
				if(retencionLocal.getId().equals(retencion.getId())) {
					retencionLocal.setIsSelected(retencion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesRetencion(List<Retencion> retencionsAux) throws Exception {
		//this.retencionsAux=retencionsAux;
		
		for(Retencion retencionAux:retencionsAux) {
			if(retencionAux.getIsChanged()) {
				retencionAux.setIsChanged(false);
			}		
			
			if(retencionAux.getIsNew()) {
				retencionAux.setIsNew(false);
			}	
			
			if(retencionAux.getIsDeleted()) {
				retencionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesRetencion(Retencion retencionAux) throws Exception {
		//this.retencionAux=retencionAux;
		
			if(retencionAux.getIsChanged()) {
				retencionAux.setIsChanged(false);
			}		
			
			if(retencionAux.getIsNew()) {
				retencionAux.setIsNew(false);
			}	
			
			if(retencionAux.getIsDeleted()) {
				retencionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Retencion retencionAsignar,Retencion retencion) throws Exception {
		retencionAsignar.setId(retencion.getId());	
		retencionAsignar.setVersionRow(retencion.getVersionRow());	
		retencionAsignar.setid_empresa(retencion.getid_empresa());
		retencionAsignar.setempresa_descripcion(retencion.getempresa_descripcion());	
		retencionAsignar.setid_sucursal(retencion.getid_sucursal());
		retencionAsignar.setsucursal_descripcion(retencion.getsucursal_descripcion());	
		retencionAsignar.setid_ejercicio(retencion.getid_ejercicio());
		retencionAsignar.setejercicio_descripcion(retencion.getejercicio_descripcion());	
		retencionAsignar.setid_periodo(retencion.getid_periodo());
		retencionAsignar.setperiodo_descripcion(retencion.getperiodo_descripcion());	
		retencionAsignar.setid_anio(retencion.getid_anio());
		retencionAsignar.setanio_descripcion(retencion.getanio_descripcion());	
		retencionAsignar.setid_mes(retencion.getid_mes());
		retencionAsignar.setmes_descripcion(retencion.getmes_descripcion());	
		retencionAsignar.setid_asiento_contable(retencion.getid_asiento_contable());
		retencionAsignar.setasientocontable_descripcion(retencion.getasientocontable_descripcion());	
		retencionAsignar.setid_tipo_retencion(retencion.getid_tipo_retencion());
		retencionAsignar.settiporetencion_descripcion(retencion.gettiporetencion_descripcion());	
		retencionAsignar.setid_cliente(retencion.getid_cliente());
		retencionAsignar.setcliente_descripcion(retencion.getcliente_descripcion());	
		retencionAsignar.setporcentaje(retencion.getporcentaje());	
		retencionAsignar.setbase_imponible(retencion.getbase_imponible());	
		retencionAsignar.setvalor(retencion.getvalor());	
		retencionAsignar.setnumero(retencion.getnumero());	
		retencionAsignar.setid_factura(retencion.getid_factura());
		retencionAsignar.setfactura_descripcion(retencion.getfactura_descripcion());	
		retencionAsignar.setdescripcion(retencion.getdescripcion());	
		retencionAsignar.setdebito_mone_local(retencion.getdebito_mone_local());	
		retencionAsignar.setcredito_mone_local(retencion.getcredito_mone_local());	
		retencionAsignar.setdebito_mone_extra(retencion.getdebito_mone_extra());	
		retencionAsignar.setcredito_mone_extra(retencion.getcredito_mone_extra());	
		retencionAsignar.setid_moneda(retencion.getid_moneda());
		retencionAsignar.setmoneda_descripcion(retencion.getmoneda_descripcion());	
		retencionAsignar.setcotizacion(retencion.getcotizacion());	
		retencionAsignar.setnombre_benef(retencion.getnombre_benef());	
		retencionAsignar.setdireccion_benef(retencion.getdireccion_benef());	
		retencionAsignar.setruc_benef(retencion.getruc_benef());	
		retencionAsignar.settelefono_benef(retencion.gettelefono_benef());	
		retencionAsignar.setfecha(retencion.getfecha());	
		retencionAsignar.setid_cuenta_contable_retencion(retencion.getid_cuenta_contable_retencion());
		retencionAsignar.setcuentacontableretencion_descripcion(retencion.getcuentacontableretencion_descripcion());	
		retencionAsignar.setid_estado_retencion(retencion.getid_estado_retencion());
		retencionAsignar.setestadoretencion_descripcion(retencion.getestadoretencion_descripcion());	
		retencionAsignar.setbeneficiario(retencion.getbeneficiario());	
	}
	
	public static void inicializarRetencion(Retencion retencion) throws Exception {
		try {
				retencion.setId(0L);	
					
				retencion.setid_empresa(-1L);	
				retencion.setid_sucursal(-1L);	
				retencion.setid_ejercicio(-1L);	
				retencion.setid_periodo(-1L);	
				retencion.setid_anio(null);	
				retencion.setid_mes(null);	
				retencion.setid_asiento_contable(-1L);	
				retencion.setid_tipo_retencion(-1L);	
				retencion.setid_cliente(-1L);	
				retencion.setporcentaje(0.0);	
				retencion.setbase_imponible(0.0);	
				retencion.setvalor(0.0);	
				retencion.setnumero("");	
				retencion.setid_factura(null);	
				retencion.setdescripcion("");	
				retencion.setdebito_mone_local(0.0);	
				retencion.setcredito_mone_local(0.0);	
				retencion.setdebito_mone_extra(0.0);	
				retencion.setcredito_mone_extra(0.0);	
				retencion.setid_moneda(-1L);	
				retencion.setcotizacion(0.0);	
				retencion.setnombre_benef("");	
				retencion.setdireccion_benef("");	
				retencion.setruc_benef("");	
				retencion.settelefono_benef("");	
				retencion.setfecha(new Date());	
				retencion.setid_cuenta_contable_retencion(-1L);	
				retencion.setid_estado_retencion(-1L);	
				retencion.setbeneficiario("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderRetencion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionConstantesFunciones.LABEL_IDASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionConstantesFunciones.LABEL_IDTIPORETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionConstantesFunciones.LABEL_BASEIMPONIBLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionConstantesFunciones.LABEL_NUMERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionConstantesFunciones.LABEL_IDFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionConstantesFunciones.LABEL_DEBITOMONELOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionConstantesFunciones.LABEL_CREDITOMONELOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionConstantesFunciones.LABEL_DEBITOMONEEXTRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionConstantesFunciones.LABEL_CREDITOMONEEXTRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionConstantesFunciones.LABEL_IDMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionConstantesFunciones.LABEL_COTIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionConstantesFunciones.LABEL_NOMBREBENEF);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionConstantesFunciones.LABEL_DIRECCIONBENEF);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionConstantesFunciones.LABEL_RUCBENEF);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionConstantesFunciones.LABEL_TELEFONOBENEF);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionConstantesFunciones.LABEL_IDCUENTACONTABLERETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionConstantesFunciones.LABEL_IDESTADORETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionConstantesFunciones.LABEL_BENEFICIARIO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataRetencion(String sTipo,Row row,Workbook workbook,Retencion retencion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(retencion.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencion.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencion.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencion.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencion.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencion.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencion.getasientocontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencion.gettiporetencion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencion.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencion.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencion.getbase_imponible());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencion.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencion.getnumero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencion.getfactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencion.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencion.getdebito_mone_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencion.getcredito_mone_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencion.getdebito_mone_extra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencion.getcredito_mone_extra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencion.getmoneda_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencion.getcotizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencion.getnombre_benef());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencion.getdireccion_benef());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencion.getruc_benef());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencion.gettelefono_benef());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencion.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencion.getcuentacontableretencion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencion.getestadoretencion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencion.getbeneficiario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryRetencion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryRetencion() {
		return this.sFinalQueryRetencion;
	}
	
	public void setsFinalQueryRetencion(String sFinalQueryRetencion) {
		this.sFinalQueryRetencion= sFinalQueryRetencion;
	}
	
	public Border resaltarSeleccionarRetencion=null;
	
	public Border setResaltarSeleccionarRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		/*
		//retencionBeanSwingJInternalFrame.jTtoolBarRetencion.setBorder(borderResaltar);
		*/
		this.resaltarSeleccionarRetencion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarRetencion() {
		return this.resaltarSeleccionarRetencion;
	}
	
	public void setResaltarSeleccionarRetencion(Border borderResaltarSeleccionarRetencion) {
		this.resaltarSeleccionarRetencion= borderResaltarSeleccionarRetencion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridRetencion=null;
	public Boolean mostraridRetencion=true;
	public Boolean activaridRetencion=true;

	public Border resaltarid_empresaRetencion=null;
	public Boolean mostrarid_empresaRetencion=true;
	public Boolean activarid_empresaRetencion=true;
	public Boolean cargarid_empresaRetencion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaRetencion=false;//ConEventDepend=true

	public Border resaltarid_sucursalRetencion=null;
	public Boolean mostrarid_sucursalRetencion=true;
	public Boolean activarid_sucursalRetencion=true;
	public Boolean cargarid_sucursalRetencion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalRetencion=false;//ConEventDepend=true

	public Border resaltarid_ejercicioRetencion=null;
	public Boolean mostrarid_ejercicioRetencion=true;
	public Boolean activarid_ejercicioRetencion=true;
	public Boolean cargarid_ejercicioRetencion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioRetencion=false;//ConEventDepend=true

	public Border resaltarid_periodoRetencion=null;
	public Boolean mostrarid_periodoRetencion=true;
	public Boolean activarid_periodoRetencion=true;
	public Boolean cargarid_periodoRetencion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoRetencion=false;//ConEventDepend=true

	public Border resaltarid_anioRetencion=null;
	public Boolean mostrarid_anioRetencion=true;
	public Boolean activarid_anioRetencion=false;
	public Boolean cargarid_anioRetencion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioRetencion=false;//ConEventDepend=true

	public Border resaltarid_mesRetencion=null;
	public Boolean mostrarid_mesRetencion=true;
	public Boolean activarid_mesRetencion=false;
	public Boolean cargarid_mesRetencion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesRetencion=false;//ConEventDepend=true

	public Border resaltarid_asiento_contableRetencion=null;
	public Boolean mostrarid_asiento_contableRetencion=true;
	public Boolean activarid_asiento_contableRetencion=true;
	public Boolean cargarid_asiento_contableRetencion=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_asiento_contableRetencion=false;//ConEventDepend=true

	public Border resaltarid_tipo_retencionRetencion=null;
	public Boolean mostrarid_tipo_retencionRetencion=true;
	public Boolean activarid_tipo_retencionRetencion=true;
	public Boolean cargarid_tipo_retencionRetencion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_retencionRetencion=false;//ConEventDepend=true

	public Border resaltarid_clienteRetencion=null;
	public Boolean mostrarid_clienteRetencion=true;
	public Boolean activarid_clienteRetencion=true;
	public Boolean cargarid_clienteRetencion=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteRetencion=false;//ConEventDepend=true

	public Border resaltarporcentajeRetencion=null;
	public Boolean mostrarporcentajeRetencion=true;
	public Boolean activarporcentajeRetencion=true;

	public Border resaltarbase_imponibleRetencion=null;
	public Boolean mostrarbase_imponibleRetencion=true;
	public Boolean activarbase_imponibleRetencion=true;

	public Border resaltarvalorRetencion=null;
	public Boolean mostrarvalorRetencion=true;
	public Boolean activarvalorRetencion=true;

	public Border resaltarnumeroRetencion=null;
	public Boolean mostrarnumeroRetencion=true;
	public Boolean activarnumeroRetencion=true;

	public Border resaltarid_facturaRetencion=null;
	public Boolean mostrarid_facturaRetencion=true;
	public Boolean activarid_facturaRetencion=true;
	public Boolean cargarid_facturaRetencion=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_facturaRetencion=false;//ConEventDepend=true

	public Border resaltardescripcionRetencion=null;
	public Boolean mostrardescripcionRetencion=true;
	public Boolean activardescripcionRetencion=true;

	public Border resaltardebito_mone_localRetencion=null;
	public Boolean mostrardebito_mone_localRetencion=true;
	public Boolean activardebito_mone_localRetencion=true;

	public Border resaltarcredito_mone_localRetencion=null;
	public Boolean mostrarcredito_mone_localRetencion=true;
	public Boolean activarcredito_mone_localRetencion=true;

	public Border resaltardebito_mone_extraRetencion=null;
	public Boolean mostrardebito_mone_extraRetencion=true;
	public Boolean activardebito_mone_extraRetencion=true;

	public Border resaltarcredito_mone_extraRetencion=null;
	public Boolean mostrarcredito_mone_extraRetencion=true;
	public Boolean activarcredito_mone_extraRetencion=true;

	public Border resaltarid_monedaRetencion=null;
	public Boolean mostrarid_monedaRetencion=true;
	public Boolean activarid_monedaRetencion=true;
	public Boolean cargarid_monedaRetencion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_monedaRetencion=false;//ConEventDepend=true

	public Border resaltarcotizacionRetencion=null;
	public Boolean mostrarcotizacionRetencion=true;
	public Boolean activarcotizacionRetencion=true;

	public Border resaltarnombre_benefRetencion=null;
	public Boolean mostrarnombre_benefRetencion=true;
	public Boolean activarnombre_benefRetencion=true;

	public Border resaltardireccion_benefRetencion=null;
	public Boolean mostrardireccion_benefRetencion=true;
	public Boolean activardireccion_benefRetencion=true;

	public Border resaltarruc_benefRetencion=null;
	public Boolean mostrarruc_benefRetencion=true;
	public Boolean activarruc_benefRetencion=true;

	public Border resaltartelefono_benefRetencion=null;
	public Boolean mostrartelefono_benefRetencion=true;
	public Boolean activartelefono_benefRetencion=true;

	public Border resaltarfechaRetencion=null;
	public Boolean mostrarfechaRetencion=true;
	public Boolean activarfechaRetencion=false;

	public Border resaltarid_cuenta_contable_retencionRetencion=null;
	public Boolean mostrarid_cuenta_contable_retencionRetencion=true;
	public Boolean activarid_cuenta_contable_retencionRetencion=false;
	public Boolean cargarid_cuenta_contable_retencionRetencion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_retencionRetencion=false;//ConEventDepend=true

	public Border resaltarid_estado_retencionRetencion=null;
	public Boolean mostrarid_estado_retencionRetencion=true;
	public Boolean activarid_estado_retencionRetencion=false;
	public Boolean cargarid_estado_retencionRetencion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_retencionRetencion=false;//ConEventDepend=true

	public Border resaltarbeneficiarioRetencion=null;
	public Boolean mostrarbeneficiarioRetencion=true;
	public Boolean activarbeneficiarioRetencion=false;

	
	

	public Border setResaltaridRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//retencionBeanSwingJInternalFrame.jTtoolBarRetencion.setBorder(borderResaltar);
		*/
		this.resaltaridRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridRetencion() {
		return this.resaltaridRetencion;
	}

	public void setResaltaridRetencion(Border borderResaltar) {
		this.resaltaridRetencion= borderResaltar;
	}

	public Boolean getMostraridRetencion() {
		return this.mostraridRetencion;
	}

	public void setMostraridRetencion(Boolean mostraridRetencion) {
		this.mostraridRetencion= mostraridRetencion;
	}

	public Boolean getActivaridRetencion() {
		return this.activaridRetencion;
	}

	public void setActivaridRetencion(Boolean activaridRetencion) {
		this.activaridRetencion= activaridRetencion;
	}

	public Border setResaltarid_empresaRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//retencionBeanSwingJInternalFrame.jTtoolBarRetencion.setBorder(borderResaltar);
		*/
		this.resaltarid_empresaRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaRetencion() {
		return this.resaltarid_empresaRetencion;
	}

	public void setResaltarid_empresaRetencion(Border borderResaltar) {
		this.resaltarid_empresaRetencion= borderResaltar;
	}

	public Boolean getMostrarid_empresaRetencion() {
		return this.mostrarid_empresaRetencion;
	}

	public void setMostrarid_empresaRetencion(Boolean mostrarid_empresaRetencion) {
		this.mostrarid_empresaRetencion= mostrarid_empresaRetencion;
	}

	public Boolean getActivarid_empresaRetencion() {
		return this.activarid_empresaRetencion;
	}

	public void setActivarid_empresaRetencion(Boolean activarid_empresaRetencion) {
		this.activarid_empresaRetencion= activarid_empresaRetencion;
	}

	public Boolean getCargarid_empresaRetencion() {
		return this.cargarid_empresaRetencion;
	}

	public void setCargarid_empresaRetencion(Boolean cargarid_empresaRetencion) {
		this.cargarid_empresaRetencion= cargarid_empresaRetencion;
	}

	public Border setResaltarid_sucursalRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//retencionBeanSwingJInternalFrame.jTtoolBarRetencion.setBorder(borderResaltar);
		*/
		this.resaltarid_sucursalRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalRetencion() {
		return this.resaltarid_sucursalRetencion;
	}

	public void setResaltarid_sucursalRetencion(Border borderResaltar) {
		this.resaltarid_sucursalRetencion= borderResaltar;
	}

	public Boolean getMostrarid_sucursalRetencion() {
		return this.mostrarid_sucursalRetencion;
	}

	public void setMostrarid_sucursalRetencion(Boolean mostrarid_sucursalRetencion) {
		this.mostrarid_sucursalRetencion= mostrarid_sucursalRetencion;
	}

	public Boolean getActivarid_sucursalRetencion() {
		return this.activarid_sucursalRetencion;
	}

	public void setActivarid_sucursalRetencion(Boolean activarid_sucursalRetencion) {
		this.activarid_sucursalRetencion= activarid_sucursalRetencion;
	}

	public Boolean getCargarid_sucursalRetencion() {
		return this.cargarid_sucursalRetencion;
	}

	public void setCargarid_sucursalRetencion(Boolean cargarid_sucursalRetencion) {
		this.cargarid_sucursalRetencion= cargarid_sucursalRetencion;
	}

	public Border setResaltarid_ejercicioRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//retencionBeanSwingJInternalFrame.jTtoolBarRetencion.setBorder(borderResaltar);
		*/
		this.resaltarid_ejercicioRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioRetencion() {
		return this.resaltarid_ejercicioRetencion;
	}

	public void setResaltarid_ejercicioRetencion(Border borderResaltar) {
		this.resaltarid_ejercicioRetencion= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioRetencion() {
		return this.mostrarid_ejercicioRetencion;
	}

	public void setMostrarid_ejercicioRetencion(Boolean mostrarid_ejercicioRetencion) {
		this.mostrarid_ejercicioRetencion= mostrarid_ejercicioRetencion;
	}

	public Boolean getActivarid_ejercicioRetencion() {
		return this.activarid_ejercicioRetencion;
	}

	public void setActivarid_ejercicioRetencion(Boolean activarid_ejercicioRetencion) {
		this.activarid_ejercicioRetencion= activarid_ejercicioRetencion;
	}

	public Boolean getCargarid_ejercicioRetencion() {
		return this.cargarid_ejercicioRetencion;
	}

	public void setCargarid_ejercicioRetencion(Boolean cargarid_ejercicioRetencion) {
		this.cargarid_ejercicioRetencion= cargarid_ejercicioRetencion;
	}

	public Border setResaltarid_periodoRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//retencionBeanSwingJInternalFrame.jTtoolBarRetencion.setBorder(borderResaltar);
		*/
		this.resaltarid_periodoRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoRetencion() {
		return this.resaltarid_periodoRetencion;
	}

	public void setResaltarid_periodoRetencion(Border borderResaltar) {
		this.resaltarid_periodoRetencion= borderResaltar;
	}

	public Boolean getMostrarid_periodoRetencion() {
		return this.mostrarid_periodoRetencion;
	}

	public void setMostrarid_periodoRetencion(Boolean mostrarid_periodoRetencion) {
		this.mostrarid_periodoRetencion= mostrarid_periodoRetencion;
	}

	public Boolean getActivarid_periodoRetencion() {
		return this.activarid_periodoRetencion;
	}

	public void setActivarid_periodoRetencion(Boolean activarid_periodoRetencion) {
		this.activarid_periodoRetencion= activarid_periodoRetencion;
	}

	public Boolean getCargarid_periodoRetencion() {
		return this.cargarid_periodoRetencion;
	}

	public void setCargarid_periodoRetencion(Boolean cargarid_periodoRetencion) {
		this.cargarid_periodoRetencion= cargarid_periodoRetencion;
	}

	public Border setResaltarid_anioRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//retencionBeanSwingJInternalFrame.jTtoolBarRetencion.setBorder(borderResaltar);
		*/
		this.resaltarid_anioRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioRetencion() {
		return this.resaltarid_anioRetencion;
	}

	public void setResaltarid_anioRetencion(Border borderResaltar) {
		this.resaltarid_anioRetencion= borderResaltar;
	}

	public Boolean getMostrarid_anioRetencion() {
		return this.mostrarid_anioRetencion;
	}

	public void setMostrarid_anioRetencion(Boolean mostrarid_anioRetencion) {
		this.mostrarid_anioRetencion= mostrarid_anioRetencion;
	}

	public Boolean getActivarid_anioRetencion() {
		return this.activarid_anioRetencion;
	}

	public void setActivarid_anioRetencion(Boolean activarid_anioRetencion) {
		this.activarid_anioRetencion= activarid_anioRetencion;
	}

	public Boolean getCargarid_anioRetencion() {
		return this.cargarid_anioRetencion;
	}

	public void setCargarid_anioRetencion(Boolean cargarid_anioRetencion) {
		this.cargarid_anioRetencion= cargarid_anioRetencion;
	}

	public Border setResaltarid_mesRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//retencionBeanSwingJInternalFrame.jTtoolBarRetencion.setBorder(borderResaltar);
		*/
		this.resaltarid_mesRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesRetencion() {
		return this.resaltarid_mesRetencion;
	}

	public void setResaltarid_mesRetencion(Border borderResaltar) {
		this.resaltarid_mesRetencion= borderResaltar;
	}

	public Boolean getMostrarid_mesRetencion() {
		return this.mostrarid_mesRetencion;
	}

	public void setMostrarid_mesRetencion(Boolean mostrarid_mesRetencion) {
		this.mostrarid_mesRetencion= mostrarid_mesRetencion;
	}

	public Boolean getActivarid_mesRetencion() {
		return this.activarid_mesRetencion;
	}

	public void setActivarid_mesRetencion(Boolean activarid_mesRetencion) {
		this.activarid_mesRetencion= activarid_mesRetencion;
	}

	public Boolean getCargarid_mesRetencion() {
		return this.cargarid_mesRetencion;
	}

	public void setCargarid_mesRetencion(Boolean cargarid_mesRetencion) {
		this.cargarid_mesRetencion= cargarid_mesRetencion;
	}

	public Border setResaltarid_asiento_contableRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//retencionBeanSwingJInternalFrame.jTtoolBarRetencion.setBorder(borderResaltar);
		*/
		this.resaltarid_asiento_contableRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_asiento_contableRetencion() {
		return this.resaltarid_asiento_contableRetencion;
	}

	public void setResaltarid_asiento_contableRetencion(Border borderResaltar) {
		this.resaltarid_asiento_contableRetencion= borderResaltar;
	}

	public Boolean getMostrarid_asiento_contableRetencion() {
		return this.mostrarid_asiento_contableRetencion;
	}

	public void setMostrarid_asiento_contableRetencion(Boolean mostrarid_asiento_contableRetencion) {
		this.mostrarid_asiento_contableRetencion= mostrarid_asiento_contableRetencion;
	}

	public Boolean getActivarid_asiento_contableRetencion() {
		return this.activarid_asiento_contableRetencion;
	}

	public void setActivarid_asiento_contableRetencion(Boolean activarid_asiento_contableRetencion) {
		this.activarid_asiento_contableRetencion= activarid_asiento_contableRetencion;
	}

	public Boolean getCargarid_asiento_contableRetencion() {
		return this.cargarid_asiento_contableRetencion;
	}

	public void setCargarid_asiento_contableRetencion(Boolean cargarid_asiento_contableRetencion) {
		this.cargarid_asiento_contableRetencion= cargarid_asiento_contableRetencion;
	}

	public Border setResaltarid_tipo_retencionRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//retencionBeanSwingJInternalFrame.jTtoolBarRetencion.setBorder(borderResaltar);
		*/
		this.resaltarid_tipo_retencionRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_retencionRetencion() {
		return this.resaltarid_tipo_retencionRetencion;
	}

	public void setResaltarid_tipo_retencionRetencion(Border borderResaltar) {
		this.resaltarid_tipo_retencionRetencion= borderResaltar;
	}

	public Boolean getMostrarid_tipo_retencionRetencion() {
		return this.mostrarid_tipo_retencionRetencion;
	}

	public void setMostrarid_tipo_retencionRetencion(Boolean mostrarid_tipo_retencionRetencion) {
		this.mostrarid_tipo_retencionRetencion= mostrarid_tipo_retencionRetencion;
	}

	public Boolean getActivarid_tipo_retencionRetencion() {
		return this.activarid_tipo_retencionRetencion;
	}

	public void setActivarid_tipo_retencionRetencion(Boolean activarid_tipo_retencionRetencion) {
		this.activarid_tipo_retencionRetencion= activarid_tipo_retencionRetencion;
	}

	public Boolean getCargarid_tipo_retencionRetencion() {
		return this.cargarid_tipo_retencionRetencion;
	}

	public void setCargarid_tipo_retencionRetencion(Boolean cargarid_tipo_retencionRetencion) {
		this.cargarid_tipo_retencionRetencion= cargarid_tipo_retencionRetencion;
	}

	public Border setResaltarid_clienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//retencionBeanSwingJInternalFrame.jTtoolBarRetencion.setBorder(borderResaltar);
		*/
		this.resaltarid_clienteRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteRetencion() {
		return this.resaltarid_clienteRetencion;
	}

	public void setResaltarid_clienteRetencion(Border borderResaltar) {
		this.resaltarid_clienteRetencion= borderResaltar;
	}

	public Boolean getMostrarid_clienteRetencion() {
		return this.mostrarid_clienteRetencion;
	}

	public void setMostrarid_clienteRetencion(Boolean mostrarid_clienteRetencion) {
		this.mostrarid_clienteRetencion= mostrarid_clienteRetencion;
	}

	public Boolean getActivarid_clienteRetencion() {
		return this.activarid_clienteRetencion;
	}

	public void setActivarid_clienteRetencion(Boolean activarid_clienteRetencion) {
		this.activarid_clienteRetencion= activarid_clienteRetencion;
	}

	public Boolean getCargarid_clienteRetencion() {
		return this.cargarid_clienteRetencion;
	}

	public void setCargarid_clienteRetencion(Boolean cargarid_clienteRetencion) {
		this.cargarid_clienteRetencion= cargarid_clienteRetencion;
	}

	public Border setResaltarporcentajeRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//retencionBeanSwingJInternalFrame.jTtoolBarRetencion.setBorder(borderResaltar);
		*/
		this.resaltarporcentajeRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeRetencion() {
		return this.resaltarporcentajeRetencion;
	}

	public void setResaltarporcentajeRetencion(Border borderResaltar) {
		this.resaltarporcentajeRetencion= borderResaltar;
	}

	public Boolean getMostrarporcentajeRetencion() {
		return this.mostrarporcentajeRetencion;
	}

	public void setMostrarporcentajeRetencion(Boolean mostrarporcentajeRetencion) {
		this.mostrarporcentajeRetencion= mostrarporcentajeRetencion;
	}

	public Boolean getActivarporcentajeRetencion() {
		return this.activarporcentajeRetencion;
	}

	public void setActivarporcentajeRetencion(Boolean activarporcentajeRetencion) {
		this.activarporcentajeRetencion= activarporcentajeRetencion;
	}

	public Border setResaltarbase_imponibleRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//retencionBeanSwingJInternalFrame.jTtoolBarRetencion.setBorder(borderResaltar);
		*/
		this.resaltarbase_imponibleRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbase_imponibleRetencion() {
		return this.resaltarbase_imponibleRetencion;
	}

	public void setResaltarbase_imponibleRetencion(Border borderResaltar) {
		this.resaltarbase_imponibleRetencion= borderResaltar;
	}

	public Boolean getMostrarbase_imponibleRetencion() {
		return this.mostrarbase_imponibleRetencion;
	}

	public void setMostrarbase_imponibleRetencion(Boolean mostrarbase_imponibleRetencion) {
		this.mostrarbase_imponibleRetencion= mostrarbase_imponibleRetencion;
	}

	public Boolean getActivarbase_imponibleRetencion() {
		return this.activarbase_imponibleRetencion;
	}

	public void setActivarbase_imponibleRetencion(Boolean activarbase_imponibleRetencion) {
		this.activarbase_imponibleRetencion= activarbase_imponibleRetencion;
	}

	public Border setResaltarvalorRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//retencionBeanSwingJInternalFrame.jTtoolBarRetencion.setBorder(borderResaltar);
		*/
		this.resaltarvalorRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorRetencion() {
		return this.resaltarvalorRetencion;
	}

	public void setResaltarvalorRetencion(Border borderResaltar) {
		this.resaltarvalorRetencion= borderResaltar;
	}

	public Boolean getMostrarvalorRetencion() {
		return this.mostrarvalorRetencion;
	}

	public void setMostrarvalorRetencion(Boolean mostrarvalorRetencion) {
		this.mostrarvalorRetencion= mostrarvalorRetencion;
	}

	public Boolean getActivarvalorRetencion() {
		return this.activarvalorRetencion;
	}

	public void setActivarvalorRetencion(Boolean activarvalorRetencion) {
		this.activarvalorRetencion= activarvalorRetencion;
	}

	public Border setResaltarnumeroRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//retencionBeanSwingJInternalFrame.jTtoolBarRetencion.setBorder(borderResaltar);
		*/
		this.resaltarnumeroRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumeroRetencion() {
		return this.resaltarnumeroRetencion;
	}

	public void setResaltarnumeroRetencion(Border borderResaltar) {
		this.resaltarnumeroRetencion= borderResaltar;
	}

	public Boolean getMostrarnumeroRetencion() {
		return this.mostrarnumeroRetencion;
	}

	public void setMostrarnumeroRetencion(Boolean mostrarnumeroRetencion) {
		this.mostrarnumeroRetencion= mostrarnumeroRetencion;
	}

	public Boolean getActivarnumeroRetencion() {
		return this.activarnumeroRetencion;
	}

	public void setActivarnumeroRetencion(Boolean activarnumeroRetencion) {
		this.activarnumeroRetencion= activarnumeroRetencion;
	}

	public Border setResaltarid_facturaRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//retencionBeanSwingJInternalFrame.jTtoolBarRetencion.setBorder(borderResaltar);
		*/
		this.resaltarid_facturaRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_facturaRetencion() {
		return this.resaltarid_facturaRetencion;
	}

	public void setResaltarid_facturaRetencion(Border borderResaltar) {
		this.resaltarid_facturaRetencion= borderResaltar;
	}

	public Boolean getMostrarid_facturaRetencion() {
		return this.mostrarid_facturaRetencion;
	}

	public void setMostrarid_facturaRetencion(Boolean mostrarid_facturaRetencion) {
		this.mostrarid_facturaRetencion= mostrarid_facturaRetencion;
	}

	public Boolean getActivarid_facturaRetencion() {
		return this.activarid_facturaRetencion;
	}

	public void setActivarid_facturaRetencion(Boolean activarid_facturaRetencion) {
		this.activarid_facturaRetencion= activarid_facturaRetencion;
	}

	public Boolean getCargarid_facturaRetencion() {
		return this.cargarid_facturaRetencion;
	}

	public void setCargarid_facturaRetencion(Boolean cargarid_facturaRetencion) {
		this.cargarid_facturaRetencion= cargarid_facturaRetencion;
	}

	public Border setResaltardescripcionRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//retencionBeanSwingJInternalFrame.jTtoolBarRetencion.setBorder(borderResaltar);
		*/
		this.resaltardescripcionRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionRetencion() {
		return this.resaltardescripcionRetencion;
	}

	public void setResaltardescripcionRetencion(Border borderResaltar) {
		this.resaltardescripcionRetencion= borderResaltar;
	}

	public Boolean getMostrardescripcionRetencion() {
		return this.mostrardescripcionRetencion;
	}

	public void setMostrardescripcionRetencion(Boolean mostrardescripcionRetencion) {
		this.mostrardescripcionRetencion= mostrardescripcionRetencion;
	}

	public Boolean getActivardescripcionRetencion() {
		return this.activardescripcionRetencion;
	}

	public void setActivardescripcionRetencion(Boolean activardescripcionRetencion) {
		this.activardescripcionRetencion= activardescripcionRetencion;
	}

	public Border setResaltardebito_mone_localRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//retencionBeanSwingJInternalFrame.jTtoolBarRetencion.setBorder(borderResaltar);
		*/
		this.resaltardebito_mone_localRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebito_mone_localRetencion() {
		return this.resaltardebito_mone_localRetencion;
	}

	public void setResaltardebito_mone_localRetencion(Border borderResaltar) {
		this.resaltardebito_mone_localRetencion= borderResaltar;
	}

	public Boolean getMostrardebito_mone_localRetencion() {
		return this.mostrardebito_mone_localRetencion;
	}

	public void setMostrardebito_mone_localRetencion(Boolean mostrardebito_mone_localRetencion) {
		this.mostrardebito_mone_localRetencion= mostrardebito_mone_localRetencion;
	}

	public Boolean getActivardebito_mone_localRetencion() {
		return this.activardebito_mone_localRetencion;
	}

	public void setActivardebito_mone_localRetencion(Boolean activardebito_mone_localRetencion) {
		this.activardebito_mone_localRetencion= activardebito_mone_localRetencion;
	}

	public Border setResaltarcredito_mone_localRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//retencionBeanSwingJInternalFrame.jTtoolBarRetencion.setBorder(borderResaltar);
		*/
		this.resaltarcredito_mone_localRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_mone_localRetencion() {
		return this.resaltarcredito_mone_localRetencion;
	}

	public void setResaltarcredito_mone_localRetencion(Border borderResaltar) {
		this.resaltarcredito_mone_localRetencion= borderResaltar;
	}

	public Boolean getMostrarcredito_mone_localRetencion() {
		return this.mostrarcredito_mone_localRetencion;
	}

	public void setMostrarcredito_mone_localRetencion(Boolean mostrarcredito_mone_localRetencion) {
		this.mostrarcredito_mone_localRetencion= mostrarcredito_mone_localRetencion;
	}

	public Boolean getActivarcredito_mone_localRetencion() {
		return this.activarcredito_mone_localRetencion;
	}

	public void setActivarcredito_mone_localRetencion(Boolean activarcredito_mone_localRetencion) {
		this.activarcredito_mone_localRetencion= activarcredito_mone_localRetencion;
	}

	public Border setResaltardebito_mone_extraRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//retencionBeanSwingJInternalFrame.jTtoolBarRetencion.setBorder(borderResaltar);
		*/
		this.resaltardebito_mone_extraRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebito_mone_extraRetencion() {
		return this.resaltardebito_mone_extraRetencion;
	}

	public void setResaltardebito_mone_extraRetencion(Border borderResaltar) {
		this.resaltardebito_mone_extraRetencion= borderResaltar;
	}

	public Boolean getMostrardebito_mone_extraRetencion() {
		return this.mostrardebito_mone_extraRetencion;
	}

	public void setMostrardebito_mone_extraRetencion(Boolean mostrardebito_mone_extraRetencion) {
		this.mostrardebito_mone_extraRetencion= mostrardebito_mone_extraRetencion;
	}

	public Boolean getActivardebito_mone_extraRetencion() {
		return this.activardebito_mone_extraRetencion;
	}

	public void setActivardebito_mone_extraRetencion(Boolean activardebito_mone_extraRetencion) {
		this.activardebito_mone_extraRetencion= activardebito_mone_extraRetencion;
	}

	public Border setResaltarcredito_mone_extraRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//retencionBeanSwingJInternalFrame.jTtoolBarRetencion.setBorder(borderResaltar);
		*/
		this.resaltarcredito_mone_extraRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_mone_extraRetencion() {
		return this.resaltarcredito_mone_extraRetencion;
	}

	public void setResaltarcredito_mone_extraRetencion(Border borderResaltar) {
		this.resaltarcredito_mone_extraRetencion= borderResaltar;
	}

	public Boolean getMostrarcredito_mone_extraRetencion() {
		return this.mostrarcredito_mone_extraRetencion;
	}

	public void setMostrarcredito_mone_extraRetencion(Boolean mostrarcredito_mone_extraRetencion) {
		this.mostrarcredito_mone_extraRetencion= mostrarcredito_mone_extraRetencion;
	}

	public Boolean getActivarcredito_mone_extraRetencion() {
		return this.activarcredito_mone_extraRetencion;
	}

	public void setActivarcredito_mone_extraRetencion(Boolean activarcredito_mone_extraRetencion) {
		this.activarcredito_mone_extraRetencion= activarcredito_mone_extraRetencion;
	}

	public Border setResaltarid_monedaRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//retencionBeanSwingJInternalFrame.jTtoolBarRetencion.setBorder(borderResaltar);
		*/
		this.resaltarid_monedaRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_monedaRetencion() {
		return this.resaltarid_monedaRetencion;
	}

	public void setResaltarid_monedaRetencion(Border borderResaltar) {
		this.resaltarid_monedaRetencion= borderResaltar;
	}

	public Boolean getMostrarid_monedaRetencion() {
		return this.mostrarid_monedaRetencion;
	}

	public void setMostrarid_monedaRetencion(Boolean mostrarid_monedaRetencion) {
		this.mostrarid_monedaRetencion= mostrarid_monedaRetencion;
	}

	public Boolean getActivarid_monedaRetencion() {
		return this.activarid_monedaRetencion;
	}

	public void setActivarid_monedaRetencion(Boolean activarid_monedaRetencion) {
		this.activarid_monedaRetencion= activarid_monedaRetencion;
	}

	public Boolean getCargarid_monedaRetencion() {
		return this.cargarid_monedaRetencion;
	}

	public void setCargarid_monedaRetencion(Boolean cargarid_monedaRetencion) {
		this.cargarid_monedaRetencion= cargarid_monedaRetencion;
	}

	public Border setResaltarcotizacionRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//retencionBeanSwingJInternalFrame.jTtoolBarRetencion.setBorder(borderResaltar);
		*/
		this.resaltarcotizacionRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcotizacionRetencion() {
		return this.resaltarcotizacionRetencion;
	}

	public void setResaltarcotizacionRetencion(Border borderResaltar) {
		this.resaltarcotizacionRetencion= borderResaltar;
	}

	public Boolean getMostrarcotizacionRetencion() {
		return this.mostrarcotizacionRetencion;
	}

	public void setMostrarcotizacionRetencion(Boolean mostrarcotizacionRetencion) {
		this.mostrarcotizacionRetencion= mostrarcotizacionRetencion;
	}

	public Boolean getActivarcotizacionRetencion() {
		return this.activarcotizacionRetencion;
	}

	public void setActivarcotizacionRetencion(Boolean activarcotizacionRetencion) {
		this.activarcotizacionRetencion= activarcotizacionRetencion;
	}

	public Border setResaltarnombre_benefRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//retencionBeanSwingJInternalFrame.jTtoolBarRetencion.setBorder(borderResaltar);
		*/
		this.resaltarnombre_benefRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_benefRetencion() {
		return this.resaltarnombre_benefRetencion;
	}

	public void setResaltarnombre_benefRetencion(Border borderResaltar) {
		this.resaltarnombre_benefRetencion= borderResaltar;
	}

	public Boolean getMostrarnombre_benefRetencion() {
		return this.mostrarnombre_benefRetencion;
	}

	public void setMostrarnombre_benefRetencion(Boolean mostrarnombre_benefRetencion) {
		this.mostrarnombre_benefRetencion= mostrarnombre_benefRetencion;
	}

	public Boolean getActivarnombre_benefRetencion() {
		return this.activarnombre_benefRetencion;
	}

	public void setActivarnombre_benefRetencion(Boolean activarnombre_benefRetencion) {
		this.activarnombre_benefRetencion= activarnombre_benefRetencion;
	}

	public Border setResaltardireccion_benefRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//retencionBeanSwingJInternalFrame.jTtoolBarRetencion.setBorder(borderResaltar);
		*/
		this.resaltardireccion_benefRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccion_benefRetencion() {
		return this.resaltardireccion_benefRetencion;
	}

	public void setResaltardireccion_benefRetencion(Border borderResaltar) {
		this.resaltardireccion_benefRetencion= borderResaltar;
	}

	public Boolean getMostrardireccion_benefRetencion() {
		return this.mostrardireccion_benefRetencion;
	}

	public void setMostrardireccion_benefRetencion(Boolean mostrardireccion_benefRetencion) {
		this.mostrardireccion_benefRetencion= mostrardireccion_benefRetencion;
	}

	public Boolean getActivardireccion_benefRetencion() {
		return this.activardireccion_benefRetencion;
	}

	public void setActivardireccion_benefRetencion(Boolean activardireccion_benefRetencion) {
		this.activardireccion_benefRetencion= activardireccion_benefRetencion;
	}

	public Border setResaltarruc_benefRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//retencionBeanSwingJInternalFrame.jTtoolBarRetencion.setBorder(borderResaltar);
		*/
		this.resaltarruc_benefRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarruc_benefRetencion() {
		return this.resaltarruc_benefRetencion;
	}

	public void setResaltarruc_benefRetencion(Border borderResaltar) {
		this.resaltarruc_benefRetencion= borderResaltar;
	}

	public Boolean getMostrarruc_benefRetencion() {
		return this.mostrarruc_benefRetencion;
	}

	public void setMostrarruc_benefRetencion(Boolean mostrarruc_benefRetencion) {
		this.mostrarruc_benefRetencion= mostrarruc_benefRetencion;
	}

	public Boolean getActivarruc_benefRetencion() {
		return this.activarruc_benefRetencion;
	}

	public void setActivarruc_benefRetencion(Boolean activarruc_benefRetencion) {
		this.activarruc_benefRetencion= activarruc_benefRetencion;
	}

	public Border setResaltartelefono_benefRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//retencionBeanSwingJInternalFrame.jTtoolBarRetencion.setBorder(borderResaltar);
		*/
		this.resaltartelefono_benefRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefono_benefRetencion() {
		return this.resaltartelefono_benefRetencion;
	}

	public void setResaltartelefono_benefRetencion(Border borderResaltar) {
		this.resaltartelefono_benefRetencion= borderResaltar;
	}

	public Boolean getMostrartelefono_benefRetencion() {
		return this.mostrartelefono_benefRetencion;
	}

	public void setMostrartelefono_benefRetencion(Boolean mostrartelefono_benefRetencion) {
		this.mostrartelefono_benefRetencion= mostrartelefono_benefRetencion;
	}

	public Boolean getActivartelefono_benefRetencion() {
		return this.activartelefono_benefRetencion;
	}

	public void setActivartelefono_benefRetencion(Boolean activartelefono_benefRetencion) {
		this.activartelefono_benefRetencion= activartelefono_benefRetencion;
	}

	public Border setResaltarfechaRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//retencionBeanSwingJInternalFrame.jTtoolBarRetencion.setBorder(borderResaltar);
		*/
		this.resaltarfechaRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaRetencion() {
		return this.resaltarfechaRetencion;
	}

	public void setResaltarfechaRetencion(Border borderResaltar) {
		this.resaltarfechaRetencion= borderResaltar;
	}

	public Boolean getMostrarfechaRetencion() {
		return this.mostrarfechaRetencion;
	}

	public void setMostrarfechaRetencion(Boolean mostrarfechaRetencion) {
		this.mostrarfechaRetencion= mostrarfechaRetencion;
	}

	public Boolean getActivarfechaRetencion() {
		return this.activarfechaRetencion;
	}

	public void setActivarfechaRetencion(Boolean activarfechaRetencion) {
		this.activarfechaRetencion= activarfechaRetencion;
	}

	public Border setResaltarid_cuenta_contable_retencionRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//retencionBeanSwingJInternalFrame.jTtoolBarRetencion.setBorder(borderResaltar);
		*/
		this.resaltarid_cuenta_contable_retencionRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_retencionRetencion() {
		return this.resaltarid_cuenta_contable_retencionRetencion;
	}

	public void setResaltarid_cuenta_contable_retencionRetencion(Border borderResaltar) {
		this.resaltarid_cuenta_contable_retencionRetencion= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_retencionRetencion() {
		return this.mostrarid_cuenta_contable_retencionRetencion;
	}

	public void setMostrarid_cuenta_contable_retencionRetencion(Boolean mostrarid_cuenta_contable_retencionRetencion) {
		this.mostrarid_cuenta_contable_retencionRetencion= mostrarid_cuenta_contable_retencionRetencion;
	}

	public Boolean getActivarid_cuenta_contable_retencionRetencion() {
		return this.activarid_cuenta_contable_retencionRetencion;
	}

	public void setActivarid_cuenta_contable_retencionRetencion(Boolean activarid_cuenta_contable_retencionRetencion) {
		this.activarid_cuenta_contable_retencionRetencion= activarid_cuenta_contable_retencionRetencion;
	}

	public Boolean getCargarid_cuenta_contable_retencionRetencion() {
		return this.cargarid_cuenta_contable_retencionRetencion;
	}

	public void setCargarid_cuenta_contable_retencionRetencion(Boolean cargarid_cuenta_contable_retencionRetencion) {
		this.cargarid_cuenta_contable_retencionRetencion= cargarid_cuenta_contable_retencionRetencion;
	}

	public Border setResaltarid_estado_retencionRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//retencionBeanSwingJInternalFrame.jTtoolBarRetencion.setBorder(borderResaltar);
		*/
		this.resaltarid_estado_retencionRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_retencionRetencion() {
		return this.resaltarid_estado_retencionRetencion;
	}

	public void setResaltarid_estado_retencionRetencion(Border borderResaltar) {
		this.resaltarid_estado_retencionRetencion= borderResaltar;
	}

	public Boolean getMostrarid_estado_retencionRetencion() {
		return this.mostrarid_estado_retencionRetencion;
	}

	public void setMostrarid_estado_retencionRetencion(Boolean mostrarid_estado_retencionRetencion) {
		this.mostrarid_estado_retencionRetencion= mostrarid_estado_retencionRetencion;
	}

	public Boolean getActivarid_estado_retencionRetencion() {
		return this.activarid_estado_retencionRetencion;
	}

	public void setActivarid_estado_retencionRetencion(Boolean activarid_estado_retencionRetencion) {
		this.activarid_estado_retencionRetencion= activarid_estado_retencionRetencion;
	}

	public Boolean getCargarid_estado_retencionRetencion() {
		return this.cargarid_estado_retencionRetencion;
	}

	public void setCargarid_estado_retencionRetencion(Boolean cargarid_estado_retencionRetencion) {
		this.cargarid_estado_retencionRetencion= cargarid_estado_retencionRetencion;
	}

	public Border setResaltarbeneficiarioRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//retencionBeanSwingJInternalFrame.jTtoolBarRetencion.setBorder(borderResaltar);
		*/
		this.resaltarbeneficiarioRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbeneficiarioRetencion() {
		return this.resaltarbeneficiarioRetencion;
	}

	public void setResaltarbeneficiarioRetencion(Border borderResaltar) {
		this.resaltarbeneficiarioRetencion= borderResaltar;
	}

	public Boolean getMostrarbeneficiarioRetencion() {
		return this.mostrarbeneficiarioRetencion;
	}

	public void setMostrarbeneficiarioRetencion(Boolean mostrarbeneficiarioRetencion) {
		this.mostrarbeneficiarioRetencion= mostrarbeneficiarioRetencion;
	}

	public Boolean getActivarbeneficiarioRetencion() {
		return this.activarbeneficiarioRetencion;
	}

	public void setActivarbeneficiarioRetencion(Boolean activarbeneficiarioRetencion) {
		this.activarbeneficiarioRetencion= activarbeneficiarioRetencion;
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
		
		
		this.setMostraridRetencion(esInicial);
		this.setMostrarid_empresaRetencion(esInicial);
		this.setMostrarid_sucursalRetencion(esInicial);
		this.setMostrarid_ejercicioRetencion(esInicial);
		this.setMostrarid_periodoRetencion(esInicial);
		this.setMostrarid_anioRetencion(esInicial);
		this.setMostrarid_mesRetencion(esInicial);
		this.setMostrarid_asiento_contableRetencion(esInicial);
		this.setMostrarid_tipo_retencionRetencion(esInicial);
		this.setMostrarid_clienteRetencion(esInicial);
		this.setMostrarporcentajeRetencion(esInicial);
		this.setMostrarbase_imponibleRetencion(esInicial);
		this.setMostrarvalorRetencion(esInicial);
		this.setMostrarnumeroRetencion(esInicial);
		this.setMostrarid_facturaRetencion(esInicial);
		this.setMostrardescripcionRetencion(esInicial);
		this.setMostrardebito_mone_localRetencion(esInicial);
		this.setMostrarcredito_mone_localRetencion(esInicial);
		this.setMostrardebito_mone_extraRetencion(esInicial);
		this.setMostrarcredito_mone_extraRetencion(esInicial);
		this.setMostrarid_monedaRetencion(esInicial);
		this.setMostrarcotizacionRetencion(esInicial);
		this.setMostrarnombre_benefRetencion(esInicial);
		this.setMostrardireccion_benefRetencion(esInicial);
		this.setMostrarruc_benefRetencion(esInicial);
		this.setMostrartelefono_benefRetencion(esInicial);
		this.setMostrarfechaRetencion(esInicial);
		this.setMostrarid_cuenta_contable_retencionRetencion(esInicial);
		this.setMostrarid_estado_retencionRetencion(esInicial);
		this.setMostrarbeneficiarioRetencion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RetencionConstantesFunciones.ID)) {
				this.setMostraridRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDMES)) {
				this.setMostrarid_mesRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setMostrarid_asiento_contableRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDTIPORETENCION)) {
				this.setMostrarid_tipo_retencionRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.BASEIMPONIBLE)) {
				this.setMostrarbase_imponibleRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.VALOR)) {
				this.setMostrarvalorRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.NUMERO)) {
				this.setMostrarnumeroRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDFACTURA)) {
				this.setMostrarid_facturaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.DEBITOMONELOCAL)) {
				this.setMostrardebito_mone_localRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.CREDITOMONELOCAL)) {
				this.setMostrarcredito_mone_localRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.DEBITOMONEEXTRA)) {
				this.setMostrardebito_mone_extraRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.CREDITOMONEEXTRA)) {
				this.setMostrarcredito_mone_extraRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDMONEDA)) {
				this.setMostrarid_monedaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.COTIZACION)) {
				this.setMostrarcotizacionRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.NOMBREBENEF)) {
				this.setMostrarnombre_benefRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.DIRECCIONBENEF)) {
				this.setMostrardireccion_benefRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.RUCBENEF)) {
				this.setMostrarruc_benefRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.TELEFONOBENEF)) {
				this.setMostrartelefono_benefRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.FECHA)) {
				this.setMostrarfechaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDCUENTACONTABLERETENCION)) {
				this.setMostrarid_cuenta_contable_retencionRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDESTADORETENCION)) {
				this.setMostrarid_estado_retencionRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.BENEFICIARIO)) {
				this.setMostrarbeneficiarioRetencion(esAsigna);
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
		
		
		this.setActivaridRetencion(esInicial);
		this.setActivarid_empresaRetencion(esInicial);
		this.setActivarid_sucursalRetencion(esInicial);
		this.setActivarid_ejercicioRetencion(esInicial);
		this.setActivarid_periodoRetencion(esInicial);
		this.setActivarid_anioRetencion(esInicial);
		this.setActivarid_mesRetencion(esInicial);
		this.setActivarid_asiento_contableRetencion(esInicial);
		this.setActivarid_tipo_retencionRetencion(esInicial);
		this.setActivarid_clienteRetencion(esInicial);
		this.setActivarporcentajeRetencion(esInicial);
		this.setActivarbase_imponibleRetencion(esInicial);
		this.setActivarvalorRetencion(esInicial);
		this.setActivarnumeroRetencion(esInicial);
		this.setActivarid_facturaRetencion(esInicial);
		this.setActivardescripcionRetencion(esInicial);
		this.setActivardebito_mone_localRetencion(esInicial);
		this.setActivarcredito_mone_localRetencion(esInicial);
		this.setActivardebito_mone_extraRetencion(esInicial);
		this.setActivarcredito_mone_extraRetencion(esInicial);
		this.setActivarid_monedaRetencion(esInicial);
		this.setActivarcotizacionRetencion(esInicial);
		this.setActivarnombre_benefRetencion(esInicial);
		this.setActivardireccion_benefRetencion(esInicial);
		this.setActivarruc_benefRetencion(esInicial);
		this.setActivartelefono_benefRetencion(esInicial);
		this.setActivarfechaRetencion(esInicial);
		this.setActivarid_cuenta_contable_retencionRetencion(esInicial);
		this.setActivarid_estado_retencionRetencion(esInicial);
		this.setActivarbeneficiarioRetencion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RetencionConstantesFunciones.ID)) {
				this.setActivaridRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDANIO)) {
				this.setActivarid_anioRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDMES)) {
				this.setActivarid_mesRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setActivarid_asiento_contableRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDTIPORETENCION)) {
				this.setActivarid_tipo_retencionRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.BASEIMPONIBLE)) {
				this.setActivarbase_imponibleRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.VALOR)) {
				this.setActivarvalorRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.NUMERO)) {
				this.setActivarnumeroRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDFACTURA)) {
				this.setActivarid_facturaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.DEBITOMONELOCAL)) {
				this.setActivardebito_mone_localRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.CREDITOMONELOCAL)) {
				this.setActivarcredito_mone_localRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.DEBITOMONEEXTRA)) {
				this.setActivardebito_mone_extraRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.CREDITOMONEEXTRA)) {
				this.setActivarcredito_mone_extraRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDMONEDA)) {
				this.setActivarid_monedaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.COTIZACION)) {
				this.setActivarcotizacionRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.NOMBREBENEF)) {
				this.setActivarnombre_benefRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.DIRECCIONBENEF)) {
				this.setActivardireccion_benefRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.RUCBENEF)) {
				this.setActivarruc_benefRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.TELEFONOBENEF)) {
				this.setActivartelefono_benefRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.FECHA)) {
				this.setActivarfechaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDCUENTACONTABLERETENCION)) {
				this.setActivarid_cuenta_contable_retencionRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDESTADORETENCION)) {
				this.setActivarid_estado_retencionRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.BENEFICIARIO)) {
				this.setActivarbeneficiarioRetencion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridRetencion(esInicial);
		this.setResaltarid_empresaRetencion(esInicial);
		this.setResaltarid_sucursalRetencion(esInicial);
		this.setResaltarid_ejercicioRetencion(esInicial);
		this.setResaltarid_periodoRetencion(esInicial);
		this.setResaltarid_anioRetencion(esInicial);
		this.setResaltarid_mesRetencion(esInicial);
		this.setResaltarid_asiento_contableRetencion(esInicial);
		this.setResaltarid_tipo_retencionRetencion(esInicial);
		this.setResaltarid_clienteRetencion(esInicial);
		this.setResaltarporcentajeRetencion(esInicial);
		this.setResaltarbase_imponibleRetencion(esInicial);
		this.setResaltarvalorRetencion(esInicial);
		this.setResaltarnumeroRetencion(esInicial);
		this.setResaltarid_facturaRetencion(esInicial);
		this.setResaltardescripcionRetencion(esInicial);
		this.setResaltardebito_mone_localRetencion(esInicial);
		this.setResaltarcredito_mone_localRetencion(esInicial);
		this.setResaltardebito_mone_extraRetencion(esInicial);
		this.setResaltarcredito_mone_extraRetencion(esInicial);
		this.setResaltarid_monedaRetencion(esInicial);
		this.setResaltarcotizacionRetencion(esInicial);
		this.setResaltarnombre_benefRetencion(esInicial);
		this.setResaltardireccion_benefRetencion(esInicial);
		this.setResaltarruc_benefRetencion(esInicial);
		this.setResaltartelefono_benefRetencion(esInicial);
		this.setResaltarfechaRetencion(esInicial);
		this.setResaltarid_cuenta_contable_retencionRetencion(esInicial);
		this.setResaltarid_estado_retencionRetencion(esInicial);
		this.setResaltarbeneficiarioRetencion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RetencionConstantesFunciones.ID)) {
				this.setResaltaridRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDMES)) {
				this.setResaltarid_mesRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setResaltarid_asiento_contableRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDTIPORETENCION)) {
				this.setResaltarid_tipo_retencionRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.BASEIMPONIBLE)) {
				this.setResaltarbase_imponibleRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.VALOR)) {
				this.setResaltarvalorRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.NUMERO)) {
				this.setResaltarnumeroRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDFACTURA)) {
				this.setResaltarid_facturaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.DEBITOMONELOCAL)) {
				this.setResaltardebito_mone_localRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.CREDITOMONELOCAL)) {
				this.setResaltarcredito_mone_localRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.DEBITOMONEEXTRA)) {
				this.setResaltardebito_mone_extraRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.CREDITOMONEEXTRA)) {
				this.setResaltarcredito_mone_extraRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDMONEDA)) {
				this.setResaltarid_monedaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.COTIZACION)) {
				this.setResaltarcotizacionRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.NOMBREBENEF)) {
				this.setResaltarnombre_benefRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.DIRECCIONBENEF)) {
				this.setResaltardireccion_benefRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.RUCBENEF)) {
				this.setResaltarruc_benefRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.TELEFONOBENEF)) {
				this.setResaltartelefono_benefRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.FECHA)) {
				this.setResaltarfechaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDCUENTACONTABLERETENCION)) {
				this.setResaltarid_cuenta_contable_retencionRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.IDESTADORETENCION)) {
				this.setResaltarid_estado_retencionRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionConstantesFunciones.BENEFICIARIO)) {
				this.setResaltarbeneficiarioRetencion(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdAsientoContableRetencion=true;

	public Boolean getMostrarFK_IdAsientoContableRetencion() {
		return this.mostrarFK_IdAsientoContableRetencion;
	}

	public void setMostrarFK_IdAsientoContableRetencion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAsientoContableRetencion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteRetencion=true;

	public Boolean getMostrarFK_IdClienteRetencion() {
		return this.mostrarFK_IdClienteRetencion;
	}

	public void setMostrarFK_IdClienteRetencion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteRetencion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableRetencionRetencion=true;

	public Boolean getMostrarFK_IdCuentaContableRetencionRetencion() {
		return this.mostrarFK_IdCuentaContableRetencionRetencion;
	}

	public void setMostrarFK_IdCuentaContableRetencionRetencion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableRetencionRetencion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioRetencion=true;

	public Boolean getMostrarFK_IdEjercicioRetencion() {
		return this.mostrarFK_IdEjercicioRetencion;
	}

	public void setMostrarFK_IdEjercicioRetencion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioRetencion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaRetencion=true;

	public Boolean getMostrarFK_IdEmpresaRetencion() {
		return this.mostrarFK_IdEmpresaRetencion;
	}

	public void setMostrarFK_IdEmpresaRetencion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaRetencion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoRetencionRetencion=true;

	public Boolean getMostrarFK_IdEstadoRetencionRetencion() {
		return this.mostrarFK_IdEstadoRetencionRetencion;
	}

	public void setMostrarFK_IdEstadoRetencionRetencion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoRetencionRetencion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFacturaRetencion=true;

	public Boolean getMostrarFK_IdFacturaRetencion() {
		return this.mostrarFK_IdFacturaRetencion;
	}

	public void setMostrarFK_IdFacturaRetencion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFacturaRetencion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMonedaRetencion=true;

	public Boolean getMostrarFK_IdMonedaRetencion() {
		return this.mostrarFK_IdMonedaRetencion;
	}

	public void setMostrarFK_IdMonedaRetencion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMonedaRetencion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoRetencion=true;

	public Boolean getMostrarFK_IdPeriodoRetencion() {
		return this.mostrarFK_IdPeriodoRetencion;
	}

	public void setMostrarFK_IdPeriodoRetencion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoRetencion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalRetencion=true;

	public Boolean getMostrarFK_IdSucursalRetencion() {
		return this.mostrarFK_IdSucursalRetencion;
	}

	public void setMostrarFK_IdSucursalRetencion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalRetencion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoRetencionRetencion=true;

	public Boolean getMostrarFK_IdTipoRetencionRetencion() {
		return this.mostrarFK_IdTipoRetencionRetencion;
	}

	public void setMostrarFK_IdTipoRetencionRetencion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoRetencionRetencion= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAsientoContableRetencion=true;

	public Boolean getActivarFK_IdAsientoContableRetencion() {
		return this.activarFK_IdAsientoContableRetencion;
	}

	public void setActivarFK_IdAsientoContableRetencion(Boolean habilitarResaltar) {
		this.activarFK_IdAsientoContableRetencion= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteRetencion=true;

	public Boolean getActivarFK_IdClienteRetencion() {
		return this.activarFK_IdClienteRetencion;
	}

	public void setActivarFK_IdClienteRetencion(Boolean habilitarResaltar) {
		this.activarFK_IdClienteRetencion= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableRetencionRetencion=true;

	public Boolean getActivarFK_IdCuentaContableRetencionRetencion() {
		return this.activarFK_IdCuentaContableRetencionRetencion;
	}

	public void setActivarFK_IdCuentaContableRetencionRetencion(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableRetencionRetencion= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioRetencion=true;

	public Boolean getActivarFK_IdEjercicioRetencion() {
		return this.activarFK_IdEjercicioRetencion;
	}

	public void setActivarFK_IdEjercicioRetencion(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioRetencion= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaRetencion=true;

	public Boolean getActivarFK_IdEmpresaRetencion() {
		return this.activarFK_IdEmpresaRetencion;
	}

	public void setActivarFK_IdEmpresaRetencion(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaRetencion= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoRetencionRetencion=true;

	public Boolean getActivarFK_IdEstadoRetencionRetencion() {
		return this.activarFK_IdEstadoRetencionRetencion;
	}

	public void setActivarFK_IdEstadoRetencionRetencion(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoRetencionRetencion= habilitarResaltar;
	}

	public Boolean activarFK_IdFacturaRetencion=true;

	public Boolean getActivarFK_IdFacturaRetencion() {
		return this.activarFK_IdFacturaRetencion;
	}

	public void setActivarFK_IdFacturaRetencion(Boolean habilitarResaltar) {
		this.activarFK_IdFacturaRetencion= habilitarResaltar;
	}

	public Boolean activarFK_IdMonedaRetencion=true;

	public Boolean getActivarFK_IdMonedaRetencion() {
		return this.activarFK_IdMonedaRetencion;
	}

	public void setActivarFK_IdMonedaRetencion(Boolean habilitarResaltar) {
		this.activarFK_IdMonedaRetencion= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoRetencion=true;

	public Boolean getActivarFK_IdPeriodoRetencion() {
		return this.activarFK_IdPeriodoRetencion;
	}

	public void setActivarFK_IdPeriodoRetencion(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoRetencion= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalRetencion=true;

	public Boolean getActivarFK_IdSucursalRetencion() {
		return this.activarFK_IdSucursalRetencion;
	}

	public void setActivarFK_IdSucursalRetencion(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalRetencion= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoRetencionRetencion=true;

	public Boolean getActivarFK_IdTipoRetencionRetencion() {
		return this.activarFK_IdTipoRetencionRetencion;
	}

	public void setActivarFK_IdTipoRetencionRetencion(Boolean habilitarResaltar) {
		this.activarFK_IdTipoRetencionRetencion= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAsientoContableRetencion=null;

	public Border getResaltarFK_IdAsientoContableRetencion() {
		return this.resaltarFK_IdAsientoContableRetencion;
	}

	public void setResaltarFK_IdAsientoContableRetencion(Border borderResaltar) {
		this.resaltarFK_IdAsientoContableRetencion= borderResaltar;
	}

	public void setResaltarFK_IdAsientoContableRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAsientoContableRetencion= borderResaltar;
	}

	public Border resaltarFK_IdClienteRetencion=null;

	public Border getResaltarFK_IdClienteRetencion() {
		return this.resaltarFK_IdClienteRetencion;
	}

	public void setResaltarFK_IdClienteRetencion(Border borderResaltar) {
		this.resaltarFK_IdClienteRetencion= borderResaltar;
	}

	public void setResaltarFK_IdClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteRetencion= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableRetencionRetencion=null;

	public Border getResaltarFK_IdCuentaContableRetencionRetencion() {
		return this.resaltarFK_IdCuentaContableRetencionRetencion;
	}

	public void setResaltarFK_IdCuentaContableRetencionRetencion(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableRetencionRetencion= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableRetencionRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableRetencionRetencion= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioRetencion=null;

	public Border getResaltarFK_IdEjercicioRetencion() {
		return this.resaltarFK_IdEjercicioRetencion;
	}

	public void setResaltarFK_IdEjercicioRetencion(Border borderResaltar) {
		this.resaltarFK_IdEjercicioRetencion= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioRetencion= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaRetencion=null;

	public Border getResaltarFK_IdEmpresaRetencion() {
		return this.resaltarFK_IdEmpresaRetencion;
	}

	public void setResaltarFK_IdEmpresaRetencion(Border borderResaltar) {
		this.resaltarFK_IdEmpresaRetencion= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaRetencion= borderResaltar;
	}

	public Border resaltarFK_IdEstadoRetencionRetencion=null;

	public Border getResaltarFK_IdEstadoRetencionRetencion() {
		return this.resaltarFK_IdEstadoRetencionRetencion;
	}

	public void setResaltarFK_IdEstadoRetencionRetencion(Border borderResaltar) {
		this.resaltarFK_IdEstadoRetencionRetencion= borderResaltar;
	}

	public void setResaltarFK_IdEstadoRetencionRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoRetencionRetencion= borderResaltar;
	}

	public Border resaltarFK_IdFacturaRetencion=null;

	public Border getResaltarFK_IdFacturaRetencion() {
		return this.resaltarFK_IdFacturaRetencion;
	}

	public void setResaltarFK_IdFacturaRetencion(Border borderResaltar) {
		this.resaltarFK_IdFacturaRetencion= borderResaltar;
	}

	public void setResaltarFK_IdFacturaRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFacturaRetencion= borderResaltar;
	}

	public Border resaltarFK_IdMonedaRetencion=null;

	public Border getResaltarFK_IdMonedaRetencion() {
		return this.resaltarFK_IdMonedaRetencion;
	}

	public void setResaltarFK_IdMonedaRetencion(Border borderResaltar) {
		this.resaltarFK_IdMonedaRetencion= borderResaltar;
	}

	public void setResaltarFK_IdMonedaRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMonedaRetencion= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoRetencion=null;

	public Border getResaltarFK_IdPeriodoRetencion() {
		return this.resaltarFK_IdPeriodoRetencion;
	}

	public void setResaltarFK_IdPeriodoRetencion(Border borderResaltar) {
		this.resaltarFK_IdPeriodoRetencion= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoRetencion= borderResaltar;
	}

	public Border resaltarFK_IdSucursalRetencion=null;

	public Border getResaltarFK_IdSucursalRetencion() {
		return this.resaltarFK_IdSucursalRetencion;
	}

	public void setResaltarFK_IdSucursalRetencion(Border borderResaltar) {
		this.resaltarFK_IdSucursalRetencion= borderResaltar;
	}

	public void setResaltarFK_IdSucursalRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalRetencion= borderResaltar;
	}

	public Border resaltarFK_IdTipoRetencionRetencion=null;

	public Border getResaltarFK_IdTipoRetencionRetencion() {
		return this.resaltarFK_IdTipoRetencionRetencion;
	}

	public void setResaltarFK_IdTipoRetencionRetencion(Border borderResaltar) {
		this.resaltarFK_IdTipoRetencionRetencion= borderResaltar;
	}

	public void setResaltarFK_IdTipoRetencionRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionBeanSwingJInternalFrame retencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoRetencionRetencion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}