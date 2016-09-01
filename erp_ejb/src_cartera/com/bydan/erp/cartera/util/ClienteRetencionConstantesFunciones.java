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
package com.bydan.erp.cartera.util;

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


import com.bydan.erp.cartera.util.ClienteRetencionConstantesFunciones;
import com.bydan.erp.cartera.util.ClienteRetencionParameterReturnGeneral;
//import com.bydan.erp.cartera.util.ClienteRetencionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ClienteRetencionConstantesFunciones extends ClienteRetencionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ClienteRetencion";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ClienteRetencion"+ClienteRetencionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ClienteRetencionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ClienteRetencionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ClienteRetencionConstantesFunciones.SCHEMA+"_"+ClienteRetencionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ClienteRetencionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ClienteRetencionConstantesFunciones.SCHEMA+"_"+ClienteRetencionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ClienteRetencionConstantesFunciones.SCHEMA+"_"+ClienteRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ClienteRetencionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ClienteRetencionConstantesFunciones.SCHEMA+"_"+ClienteRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ClienteRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ClienteRetencionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ClienteRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ClienteRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ClienteRetencionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ClienteRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ClienteRetencionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ClienteRetencionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ClienteRetencionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ClienteRetencionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Retenciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Retencion";
	public static final String SCLASSWEBTITULO_LOWER="Cliente Retencion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ClienteRetencion";
	public static final String OBJECTNAME="clienteretencion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="cliente_retencion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select clienteretencion from "+ClienteRetencionConstantesFunciones.SPERSISTENCENAME+" clienteretencion";
	public static String QUERYSELECTNATIVE="select "+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".id,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".version_row,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".id_empresa,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".id_sucursal,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".id_ejercicio,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".id_periodo,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".id_anio,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".id_mes,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".fecha,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".id_cliente,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".id_factura,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".id_transaccion,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".id_tipo_retencion,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".porcentaje,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".base_imponible,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".valor,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".numero_retencion,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".descripcion,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".id_asiento_contable,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".id_cuenta_contable_retencion,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".valor_tipo_cambio,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".debito_mone_local,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".credito_mone_local,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".debito_mone_extra,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".credito_mone_extra,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".beneficiario,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".nombre_benef,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".direccion_benef,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".telefono_benef,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".ruc_benef,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".id_estado_retencion from "+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME;//+" as "+ClienteRetencionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ClienteRetencionConstantesFuncionesAdditional clienteretencionConstantesFuncionesAdditional=null;
	
	public ClienteRetencionConstantesFuncionesAdditional getClienteRetencionConstantesFuncionesAdditional() {
		return this.clienteretencionConstantesFuncionesAdditional;
	}
	
	public void setClienteRetencionConstantesFuncionesAdditional(ClienteRetencionConstantesFuncionesAdditional clienteretencionConstantesFuncionesAdditional) {
		try {
			this.clienteretencionConstantesFuncionesAdditional=clienteretencionConstantesFuncionesAdditional;
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
    public static final String FECHA= "fecha";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDFACTURA= "id_factura";
    public static final String IDTRANSACCION= "id_transaccion";
    public static final String IDTIPORETENCION= "id_tipo_retencion";
    public static final String PORCENTAJE= "porcentaje";
    public static final String BASEIMPONIBLE= "base_imponible";
    public static final String VALOR= "valor";
    public static final String NUMERORETENCION= "numero_retencion";
    public static final String DESCRIPCION= "descripcion";
    public static final String IDASIENTOCONTABLE= "id_asiento_contable";
    public static final String IDCUENTACONTABLECLIENTERETENCION= "id_cuenta_contable_retencion";
    public static final String VALORTIPOCAMBIO= "valor_tipo_cambio";
    public static final String DEBITOMONELOCAL= "debito_mone_local";
    public static final String CREDITOMONELOCAL= "credito_mone_local";
    public static final String DEBITOMONEEXTRA= "debito_mone_extra";
    public static final String CREDITOMONEEXTRA= "credito_mone_extra";
    public static final String BENEFICIARIO= "beneficiario";
    public static final String NOMBREBENEF= "nombre_benef";
    public static final String DIRECCIONBENEF= "direccion_benef";
    public static final String TELEFONOBENEF= "telefono_benef";
    public static final String RUCBENEF= "ruc_benef";
    public static final String IDESTADORETENCION= "id_estado_retencion";
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
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDFACTURA= "Factura";
		public static final String LABEL_IDFACTURA_LOWER= "Factura";
    	public static final String LABEL_IDTRANSACCION= "Tipo";
		public static final String LABEL_IDTRANSACCION_LOWER= "Transaccion";
    	public static final String LABEL_IDTIPORETENCION= "Tipo Retencion";
		public static final String LABEL_IDTIPORETENCION_LOWER= "Tipo Retencion";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_BASEIMPONIBLE= "Base Imponible";
		public static final String LABEL_BASEIMPONIBLE_LOWER= "Base Imponible";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_NUMERORETENCION= "No Retencion";
		public static final String LABEL_NUMERORETENCION_LOWER= "Numero Retencion";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_IDASIENTOCONTABLE= "Asiento Contable";
		public static final String LABEL_IDASIENTOCONTABLE_LOWER= "Asiento Contable";
    	public static final String LABEL_IDCUENTACONTABLECLIENTERETENCION= "Cuenta Retencion";
		public static final String LABEL_IDCUENTACONTABLECLIENTERETENCION_LOWER= "Cuenta Contable Cliente Retencion";
    	public static final String LABEL_VALORTIPOCAMBIO= "Valor Tipo Cambio";
		public static final String LABEL_VALORTIPOCAMBIO_LOWER= "Valor Tipo Cambio";
    	public static final String LABEL_DEBITOMONELOCAL= "Debito Mone Local";
		public static final String LABEL_DEBITOMONELOCAL_LOWER= "Debito Mone Local";
    	public static final String LABEL_CREDITOMONELOCAL= "Credito Mone Local";
		public static final String LABEL_CREDITOMONELOCAL_LOWER= "Credito Mone Local";
    	public static final String LABEL_DEBITOMONEEXTRA= "Debito Mone Extra";
		public static final String LABEL_DEBITOMONEEXTRA_LOWER= "Debito Mone Extra";
    	public static final String LABEL_CREDITOMONEEXTRA= "Credito Mone Extra";
		public static final String LABEL_CREDITOMONEEXTRA_LOWER= "Credito Mone Extra";
    	public static final String LABEL_BENEFICIARIO= "Beneficiario";
		public static final String LABEL_BENEFICIARIO_LOWER= "Beneficiario";
    	public static final String LABEL_NOMBREBENEF= "Nombre Benef";
		public static final String LABEL_NOMBREBENEF_LOWER= "Nombre Benef";
    	public static final String LABEL_DIRECCIONBENEF= "Direccion Benef";
		public static final String LABEL_DIRECCIONBENEF_LOWER= "Direccion Benef";
    	public static final String LABEL_TELEFONOBENEF= "Telefono Benef";
		public static final String LABEL_TELEFONOBENEF_LOWER= "Telefono Benef";
    	public static final String LABEL_RUCBENEF= "Ruc Benef";
		public static final String LABEL_RUCBENEF_LOWER= "Ruc Benef";
    	public static final String LABEL_IDESTADORETENCION= "Estado Retencion";
		public static final String LABEL_IDESTADORETENCION_LOWER= "Estado Retencion";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_RETENCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_RETENCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
	public static final String SREGEXBENEFICIARIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXBENEFICIARIO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_BENEF=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_BENEF=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDIRECCION_BENEF=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION_BENEF=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO_BENEF=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO_BENEF=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
	public static final String SREGEXRUC_BENEF=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC_BENEF=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getClienteRetencionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ClienteRetencionConstantesFunciones.IDEMPRESA)) {sLabelColumna=ClienteRetencionConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ClienteRetencionConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ClienteRetencionConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ClienteRetencionConstantesFunciones.IDEJERCICIO)) {sLabelColumna=ClienteRetencionConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(ClienteRetencionConstantesFunciones.IDPERIODO)) {sLabelColumna=ClienteRetencionConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(ClienteRetencionConstantesFunciones.IDANIO)) {sLabelColumna=ClienteRetencionConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(ClienteRetencionConstantesFunciones.IDMES)) {sLabelColumna=ClienteRetencionConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(ClienteRetencionConstantesFunciones.FECHA)) {sLabelColumna=ClienteRetencionConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(ClienteRetencionConstantesFunciones.IDCLIENTE)) {sLabelColumna=ClienteRetencionConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(ClienteRetencionConstantesFunciones.IDFACTURA)) {sLabelColumna=ClienteRetencionConstantesFunciones.LABEL_IDFACTURA;}
		if(sNombreColumna.equals(ClienteRetencionConstantesFunciones.IDTRANSACCION)) {sLabelColumna=ClienteRetencionConstantesFunciones.LABEL_IDTRANSACCION;}
		if(sNombreColumna.equals(ClienteRetencionConstantesFunciones.IDTIPORETENCION)) {sLabelColumna=ClienteRetencionConstantesFunciones.LABEL_IDTIPORETENCION;}
		if(sNombreColumna.equals(ClienteRetencionConstantesFunciones.PORCENTAJE)) {sLabelColumna=ClienteRetencionConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(ClienteRetencionConstantesFunciones.BASEIMPONIBLE)) {sLabelColumna=ClienteRetencionConstantesFunciones.LABEL_BASEIMPONIBLE;}
		if(sNombreColumna.equals(ClienteRetencionConstantesFunciones.VALOR)) {sLabelColumna=ClienteRetencionConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(ClienteRetencionConstantesFunciones.NUMERORETENCION)) {sLabelColumna=ClienteRetencionConstantesFunciones.LABEL_NUMERORETENCION;}
		if(sNombreColumna.equals(ClienteRetencionConstantesFunciones.DESCRIPCION)) {sLabelColumna=ClienteRetencionConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(ClienteRetencionConstantesFunciones.IDASIENTOCONTABLE)) {sLabelColumna=ClienteRetencionConstantesFunciones.LABEL_IDASIENTOCONTABLE;}
		if(sNombreColumna.equals(ClienteRetencionConstantesFunciones.IDCUENTACONTABLECLIENTERETENCION)) {sLabelColumna=ClienteRetencionConstantesFunciones.LABEL_IDCUENTACONTABLECLIENTERETENCION;}
		if(sNombreColumna.equals(ClienteRetencionConstantesFunciones.VALORTIPOCAMBIO)) {sLabelColumna=ClienteRetencionConstantesFunciones.LABEL_VALORTIPOCAMBIO;}
		if(sNombreColumna.equals(ClienteRetencionConstantesFunciones.DEBITOMONELOCAL)) {sLabelColumna=ClienteRetencionConstantesFunciones.LABEL_DEBITOMONELOCAL;}
		if(sNombreColumna.equals(ClienteRetencionConstantesFunciones.CREDITOMONELOCAL)) {sLabelColumna=ClienteRetencionConstantesFunciones.LABEL_CREDITOMONELOCAL;}
		if(sNombreColumna.equals(ClienteRetencionConstantesFunciones.DEBITOMONEEXTRA)) {sLabelColumna=ClienteRetencionConstantesFunciones.LABEL_DEBITOMONEEXTRA;}
		if(sNombreColumna.equals(ClienteRetencionConstantesFunciones.CREDITOMONEEXTRA)) {sLabelColumna=ClienteRetencionConstantesFunciones.LABEL_CREDITOMONEEXTRA;}
		if(sNombreColumna.equals(ClienteRetencionConstantesFunciones.BENEFICIARIO)) {sLabelColumna=ClienteRetencionConstantesFunciones.LABEL_BENEFICIARIO;}
		if(sNombreColumna.equals(ClienteRetencionConstantesFunciones.NOMBREBENEF)) {sLabelColumna=ClienteRetencionConstantesFunciones.LABEL_NOMBREBENEF;}
		if(sNombreColumna.equals(ClienteRetencionConstantesFunciones.DIRECCIONBENEF)) {sLabelColumna=ClienteRetencionConstantesFunciones.LABEL_DIRECCIONBENEF;}
		if(sNombreColumna.equals(ClienteRetencionConstantesFunciones.TELEFONOBENEF)) {sLabelColumna=ClienteRetencionConstantesFunciones.LABEL_TELEFONOBENEF;}
		if(sNombreColumna.equals(ClienteRetencionConstantesFunciones.RUCBENEF)) {sLabelColumna=ClienteRetencionConstantesFunciones.LABEL_RUCBENEF;}
		if(sNombreColumna.equals(ClienteRetencionConstantesFunciones.IDESTADORETENCION)) {sLabelColumna=ClienteRetencionConstantesFunciones.LABEL_IDESTADORETENCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getClienteRetencionDescripcion(ClienteRetencion clienteretencion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(clienteretencion !=null/* && clienteretencion.getId()!=0*/) {
			if(clienteretencion.getId()!=null) {
				sDescripcion=clienteretencion.getId().toString();
			}//clienteretencionclienteretencion.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getClienteRetencionDescripcionDetallado(ClienteRetencion clienteretencion) {
		String sDescripcion="";
			
		sDescripcion+=ClienteRetencionConstantesFunciones.ID+"=";
		sDescripcion+=clienteretencion.getId().toString()+",";
		sDescripcion+=ClienteRetencionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=clienteretencion.getVersionRow().toString()+",";
		sDescripcion+=ClienteRetencionConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=clienteretencion.getid_empresa().toString()+",";
		sDescripcion+=ClienteRetencionConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=clienteretencion.getid_sucursal().toString()+",";
		sDescripcion+=ClienteRetencionConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=clienteretencion.getid_ejercicio().toString()+",";
		sDescripcion+=ClienteRetencionConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=clienteretencion.getid_periodo().toString()+",";
		sDescripcion+=ClienteRetencionConstantesFunciones.IDANIO+"=";
		sDescripcion+=clienteretencion.getid_anio().toString()+",";
		sDescripcion+=ClienteRetencionConstantesFunciones.IDMES+"=";
		sDescripcion+=clienteretencion.getid_mes().toString()+",";
		sDescripcion+=ClienteRetencionConstantesFunciones.FECHA+"=";
		sDescripcion+=clienteretencion.getfecha().toString()+",";
		sDescripcion+=ClienteRetencionConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=clienteretencion.getid_cliente().toString()+",";
		sDescripcion+=ClienteRetencionConstantesFunciones.IDFACTURA+"=";
		sDescripcion+=clienteretencion.getid_factura().toString()+",";
		sDescripcion+=ClienteRetencionConstantesFunciones.IDTRANSACCION+"=";
		sDescripcion+=clienteretencion.getid_transaccion().toString()+",";
		sDescripcion+=ClienteRetencionConstantesFunciones.IDTIPORETENCION+"=";
		sDescripcion+=clienteretencion.getid_tipo_retencion().toString()+",";
		sDescripcion+=ClienteRetencionConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=clienteretencion.getporcentaje().toString()+",";
		sDescripcion+=ClienteRetencionConstantesFunciones.BASEIMPONIBLE+"=";
		sDescripcion+=clienteretencion.getbase_imponible().toString()+",";
		sDescripcion+=ClienteRetencionConstantesFunciones.VALOR+"=";
		sDescripcion+=clienteretencion.getvalor().toString()+",";
		sDescripcion+=ClienteRetencionConstantesFunciones.NUMERORETENCION+"=";
		sDescripcion+=clienteretencion.getnumero_retencion()+",";
		sDescripcion+=ClienteRetencionConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=clienteretencion.getdescripcion()+",";
		sDescripcion+=ClienteRetencionConstantesFunciones.IDASIENTOCONTABLE+"=";
		sDescripcion+=clienteretencion.getid_asiento_contable().toString()+",";
		sDescripcion+=ClienteRetencionConstantesFunciones.IDCUENTACONTABLECLIENTERETENCION+"=";
		sDescripcion+=clienteretencion.getid_cuenta_contable_retencion().toString()+",";
		sDescripcion+=ClienteRetencionConstantesFunciones.VALORTIPOCAMBIO+"=";
		sDescripcion+=clienteretencion.getvalor_tipo_cambio().toString()+",";
		sDescripcion+=ClienteRetencionConstantesFunciones.DEBITOMONELOCAL+"=";
		sDescripcion+=clienteretencion.getdebito_mone_local().toString()+",";
		sDescripcion+=ClienteRetencionConstantesFunciones.CREDITOMONELOCAL+"=";
		sDescripcion+=clienteretencion.getcredito_mone_local().toString()+",";
		sDescripcion+=ClienteRetencionConstantesFunciones.DEBITOMONEEXTRA+"=";
		sDescripcion+=clienteretencion.getdebito_mone_extra().toString()+",";
		sDescripcion+=ClienteRetencionConstantesFunciones.CREDITOMONEEXTRA+"=";
		sDescripcion+=clienteretencion.getcredito_mone_extra().toString()+",";
		sDescripcion+=ClienteRetencionConstantesFunciones.BENEFICIARIO+"=";
		sDescripcion+=clienteretencion.getbeneficiario()+",";
		sDescripcion+=ClienteRetencionConstantesFunciones.NOMBREBENEF+"=";
		sDescripcion+=clienteretencion.getnombre_benef()+",";
		sDescripcion+=ClienteRetencionConstantesFunciones.DIRECCIONBENEF+"=";
		sDescripcion+=clienteretencion.getdireccion_benef()+",";
		sDescripcion+=ClienteRetencionConstantesFunciones.TELEFONOBENEF+"=";
		sDescripcion+=clienteretencion.gettelefono_benef()+",";
		sDescripcion+=ClienteRetencionConstantesFunciones.RUCBENEF+"=";
		sDescripcion+=clienteretencion.getruc_benef()+",";
		sDescripcion+=ClienteRetencionConstantesFunciones.IDESTADORETENCION+"=";
		sDescripcion+=clienteretencion.getid_estado_retencion().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setClienteRetencionDescripcion(ClienteRetencion clienteretencion,String sValor) throws Exception {			
		if(clienteretencion !=null) {
			//clienteretencionclienteretencion.getId().toString();
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

	public static String getTransaccionDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
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

	public static String getAsientoContableDescripcion(AsientoContable asientocontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(asientocontable!=null/*&&asientocontable.getId()>0*/) {
			sDescripcion=AsientoContableConstantesFunciones.getAsientoContableDescripcion(asientocontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableClienteRetencionDescripcion(CuentaContable cuentacontable) {
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
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdCuentaContableClienteRetencion")) {
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
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoRetencion")) {
			sNombreIndice="Tipo=  Por Tipo Retencion";
		} else if(sNombreIndice.equals("FK_IdTransaccion")) {
			sNombreIndice="Tipo=  Por Tipo";
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
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableClienteRetencion(Long id_cuenta_contable_retencion) {
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

	public static String getDetalleIndiceFK_IdTransaccion(Long id_transaccion) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion!=null) {sDetalleIndice+=" Codigo Unico De Tipo="+id_transaccion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosClienteRetencion(ClienteRetencion clienteretencion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		clienteretencion.setnumero_retencion(clienteretencion.getnumero_retencion().trim());
		clienteretencion.setdescripcion(clienteretencion.getdescripcion().trim());
		clienteretencion.setbeneficiario(clienteretencion.getbeneficiario().trim());
		clienteretencion.setnombre_benef(clienteretencion.getnombre_benef().trim());
		clienteretencion.setdireccion_benef(clienteretencion.getdireccion_benef().trim());
		clienteretencion.settelefono_benef(clienteretencion.gettelefono_benef().trim());
		clienteretencion.setruc_benef(clienteretencion.getruc_benef().trim());
	}
	
	public static void quitarEspaciosClienteRetencions(List<ClienteRetencion> clienteretencions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ClienteRetencion clienteretencion: clienteretencions) {
			clienteretencion.setnumero_retencion(clienteretencion.getnumero_retencion().trim());
			clienteretencion.setdescripcion(clienteretencion.getdescripcion().trim());
			clienteretencion.setbeneficiario(clienteretencion.getbeneficiario().trim());
			clienteretencion.setnombre_benef(clienteretencion.getnombre_benef().trim());
			clienteretencion.setdireccion_benef(clienteretencion.getdireccion_benef().trim());
			clienteretencion.settelefono_benef(clienteretencion.gettelefono_benef().trim());
			clienteretencion.setruc_benef(clienteretencion.getruc_benef().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresClienteRetencion(ClienteRetencion clienteretencion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && clienteretencion.getConCambioAuxiliar()) {
			clienteretencion.setIsDeleted(clienteretencion.getIsDeletedAuxiliar());	
			clienteretencion.setIsNew(clienteretencion.getIsNewAuxiliar());	
			clienteretencion.setIsChanged(clienteretencion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			clienteretencion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			clienteretencion.setIsDeletedAuxiliar(false);	
			clienteretencion.setIsNewAuxiliar(false);	
			clienteretencion.setIsChangedAuxiliar(false);
			
			clienteretencion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresClienteRetencions(List<ClienteRetencion> clienteretencions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ClienteRetencion clienteretencion : clienteretencions) {
			if(conAsignarBase && clienteretencion.getConCambioAuxiliar()) {
				clienteretencion.setIsDeleted(clienteretencion.getIsDeletedAuxiliar());	
				clienteretencion.setIsNew(clienteretencion.getIsNewAuxiliar());	
				clienteretencion.setIsChanged(clienteretencion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				clienteretencion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				clienteretencion.setIsDeletedAuxiliar(false);	
				clienteretencion.setIsNewAuxiliar(false);	
				clienteretencion.setIsChangedAuxiliar(false);
				
				clienteretencion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresClienteRetencion(ClienteRetencion clienteretencion,Boolean conEnteros) throws Exception  {
		clienteretencion.setporcentaje(0.0);
		clienteretencion.setbase_imponible(0.0);
		clienteretencion.setvalor(0.0);
		clienteretencion.setvalor_tipo_cambio(0.0);
		clienteretencion.setdebito_mone_local(0.0);
		clienteretencion.setcredito_mone_local(0.0);
		clienteretencion.setdebito_mone_extra(0.0);
		clienteretencion.setcredito_mone_extra(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresClienteRetencions(List<ClienteRetencion> clienteretencions,Boolean conEnteros) throws Exception  {
		
		for(ClienteRetencion clienteretencion: clienteretencions) {
			clienteretencion.setporcentaje(0.0);
			clienteretencion.setbase_imponible(0.0);
			clienteretencion.setvalor(0.0);
			clienteretencion.setvalor_tipo_cambio(0.0);
			clienteretencion.setdebito_mone_local(0.0);
			clienteretencion.setcredito_mone_local(0.0);
			clienteretencion.setdebito_mone_extra(0.0);
			clienteretencion.setcredito_mone_extra(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaClienteRetencion(List<ClienteRetencion> clienteretencions,ClienteRetencion clienteretencionAux) throws Exception  {
		ClienteRetencionConstantesFunciones.InicializarValoresClienteRetencion(clienteretencionAux,true);
		
		for(ClienteRetencion clienteretencion: clienteretencions) {
			if(clienteretencion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			clienteretencionAux.setporcentaje(clienteretencionAux.getporcentaje()+clienteretencion.getporcentaje());			
			clienteretencionAux.setbase_imponible(clienteretencionAux.getbase_imponible()+clienteretencion.getbase_imponible());			
			clienteretencionAux.setvalor(clienteretencionAux.getvalor()+clienteretencion.getvalor());			
			clienteretencionAux.setvalor_tipo_cambio(clienteretencionAux.getvalor_tipo_cambio()+clienteretencion.getvalor_tipo_cambio());			
			clienteretencionAux.setdebito_mone_local(clienteretencionAux.getdebito_mone_local()+clienteretencion.getdebito_mone_local());			
			clienteretencionAux.setcredito_mone_local(clienteretencionAux.getcredito_mone_local()+clienteretencion.getcredito_mone_local());			
			clienteretencionAux.setdebito_mone_extra(clienteretencionAux.getdebito_mone_extra()+clienteretencion.getdebito_mone_extra());			
			clienteretencionAux.setcredito_mone_extra(clienteretencionAux.getcredito_mone_extra()+clienteretencion.getcredito_mone_extra());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesClienteRetencion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ClienteRetencionConstantesFunciones.getArrayColumnasGlobalesClienteRetencion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesClienteRetencion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ClienteRetencionConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ClienteRetencionConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ClienteRetencionConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ClienteRetencionConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ClienteRetencionConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ClienteRetencionConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ClienteRetencionConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ClienteRetencionConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoClienteRetencion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ClienteRetencion> clienteretencions,ClienteRetencion clienteretencion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ClienteRetencion clienteretencionAux: clienteretencions) {
			if(clienteretencionAux!=null && clienteretencion!=null) {
				if((clienteretencionAux.getId()==null && clienteretencion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(clienteretencionAux.getId()!=null && clienteretencion.getId()!=null){
					if(clienteretencionAux.getId().equals(clienteretencion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaClienteRetencion(List<ClienteRetencion> clienteretencions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
		Double base_imponibleTotal=0.0;
		Double valorTotal=0.0;
		Double valor_tipo_cambioTotal=0.0;
		Double debito_mone_localTotal=0.0;
		Double credito_mone_localTotal=0.0;
		Double debito_mone_extraTotal=0.0;
		Double credito_mone_extraTotal=0.0;
	
		for(ClienteRetencion clienteretencion: clienteretencions) {			
			if(clienteretencion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=clienteretencion.getporcentaje();
			base_imponibleTotal+=clienteretencion.getbase_imponible();
			valorTotal+=clienteretencion.getvalor();
			valor_tipo_cambioTotal+=clienteretencion.getvalor_tipo_cambio();
			debito_mone_localTotal+=clienteretencion.getdebito_mone_local();
			credito_mone_localTotal+=clienteretencion.getcredito_mone_local();
			debito_mone_extraTotal+=clienteretencion.getdebito_mone_extra();
			credito_mone_extraTotal+=clienteretencion.getcredito_mone_extra();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ClienteRetencionConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(ClienteRetencionConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ClienteRetencionConstantesFunciones.BASEIMPONIBLE);
		datoGeneral.setsDescripcion(ClienteRetencionConstantesFunciones.LABEL_BASEIMPONIBLE);
		datoGeneral.setdValorDouble(base_imponibleTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ClienteRetencionConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(ClienteRetencionConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ClienteRetencionConstantesFunciones.VALORTIPOCAMBIO);
		datoGeneral.setsDescripcion(ClienteRetencionConstantesFunciones.LABEL_VALORTIPOCAMBIO);
		datoGeneral.setdValorDouble(valor_tipo_cambioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ClienteRetencionConstantesFunciones.DEBITOMONELOCAL);
		datoGeneral.setsDescripcion(ClienteRetencionConstantesFunciones.LABEL_DEBITOMONELOCAL);
		datoGeneral.setdValorDouble(debito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ClienteRetencionConstantesFunciones.CREDITOMONELOCAL);
		datoGeneral.setsDescripcion(ClienteRetencionConstantesFunciones.LABEL_CREDITOMONELOCAL);
		datoGeneral.setdValorDouble(credito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ClienteRetencionConstantesFunciones.DEBITOMONEEXTRA);
		datoGeneral.setsDescripcion(ClienteRetencionConstantesFunciones.LABEL_DEBITOMONEEXTRA);
		datoGeneral.setdValorDouble(debito_mone_extraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ClienteRetencionConstantesFunciones.CREDITOMONEEXTRA);
		datoGeneral.setsDescripcion(ClienteRetencionConstantesFunciones.LABEL_CREDITOMONEEXTRA);
		datoGeneral.setdValorDouble(credito_mone_extraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaClienteRetencion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ClienteRetencionConstantesFunciones.LABEL_ID, ClienteRetencionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteRetencionConstantesFunciones.LABEL_VERSIONROW, ClienteRetencionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteRetencionConstantesFunciones.LABEL_IDEMPRESA, ClienteRetencionConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteRetencionConstantesFunciones.LABEL_IDSUCURSAL, ClienteRetencionConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteRetencionConstantesFunciones.LABEL_IDEJERCICIO, ClienteRetencionConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteRetencionConstantesFunciones.LABEL_IDPERIODO, ClienteRetencionConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteRetencionConstantesFunciones.LABEL_IDANIO, ClienteRetencionConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteRetencionConstantesFunciones.LABEL_IDMES, ClienteRetencionConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteRetencionConstantesFunciones.LABEL_FECHA, ClienteRetencionConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteRetencionConstantesFunciones.LABEL_IDCLIENTE, ClienteRetencionConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteRetencionConstantesFunciones.LABEL_IDFACTURA, ClienteRetencionConstantesFunciones.IDFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteRetencionConstantesFunciones.LABEL_IDTRANSACCION, ClienteRetencionConstantesFunciones.IDTRANSACCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteRetencionConstantesFunciones.LABEL_IDTIPORETENCION, ClienteRetencionConstantesFunciones.IDTIPORETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteRetencionConstantesFunciones.LABEL_PORCENTAJE, ClienteRetencionConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteRetencionConstantesFunciones.LABEL_BASEIMPONIBLE, ClienteRetencionConstantesFunciones.BASEIMPONIBLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteRetencionConstantesFunciones.LABEL_VALOR, ClienteRetencionConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteRetencionConstantesFunciones.LABEL_NUMERORETENCION, ClienteRetencionConstantesFunciones.NUMERORETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteRetencionConstantesFunciones.LABEL_DESCRIPCION, ClienteRetencionConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteRetencionConstantesFunciones.LABEL_IDASIENTOCONTABLE, ClienteRetencionConstantesFunciones.IDASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteRetencionConstantesFunciones.LABEL_IDCUENTACONTABLECLIENTERETENCION, ClienteRetencionConstantesFunciones.IDCUENTACONTABLECLIENTERETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteRetencionConstantesFunciones.LABEL_VALORTIPOCAMBIO, ClienteRetencionConstantesFunciones.VALORTIPOCAMBIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteRetencionConstantesFunciones.LABEL_DEBITOMONELOCAL, ClienteRetencionConstantesFunciones.DEBITOMONELOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteRetencionConstantesFunciones.LABEL_CREDITOMONELOCAL, ClienteRetencionConstantesFunciones.CREDITOMONELOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteRetencionConstantesFunciones.LABEL_DEBITOMONEEXTRA, ClienteRetencionConstantesFunciones.DEBITOMONEEXTRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteRetencionConstantesFunciones.LABEL_CREDITOMONEEXTRA, ClienteRetencionConstantesFunciones.CREDITOMONEEXTRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteRetencionConstantesFunciones.LABEL_BENEFICIARIO, ClienteRetencionConstantesFunciones.BENEFICIARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteRetencionConstantesFunciones.LABEL_NOMBREBENEF, ClienteRetencionConstantesFunciones.NOMBREBENEF,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteRetencionConstantesFunciones.LABEL_DIRECCIONBENEF, ClienteRetencionConstantesFunciones.DIRECCIONBENEF,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteRetencionConstantesFunciones.LABEL_TELEFONOBENEF, ClienteRetencionConstantesFunciones.TELEFONOBENEF,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteRetencionConstantesFunciones.LABEL_RUCBENEF, ClienteRetencionConstantesFunciones.RUCBENEF,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteRetencionConstantesFunciones.LABEL_IDESTADORETENCION, ClienteRetencionConstantesFunciones.IDESTADORETENCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasClienteRetencion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ClienteRetencionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteRetencionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteRetencionConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteRetencionConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteRetencionConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteRetencionConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteRetencionConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteRetencionConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteRetencionConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteRetencionConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteRetencionConstantesFunciones.IDFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteRetencionConstantesFunciones.IDTRANSACCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteRetencionConstantesFunciones.IDTIPORETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteRetencionConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteRetencionConstantesFunciones.BASEIMPONIBLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteRetencionConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteRetencionConstantesFunciones.NUMERORETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteRetencionConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteRetencionConstantesFunciones.IDASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteRetencionConstantesFunciones.IDCUENTACONTABLECLIENTERETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteRetencionConstantesFunciones.VALORTIPOCAMBIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteRetencionConstantesFunciones.DEBITOMONELOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteRetencionConstantesFunciones.CREDITOMONELOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteRetencionConstantesFunciones.DEBITOMONEEXTRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteRetencionConstantesFunciones.CREDITOMONEEXTRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteRetencionConstantesFunciones.BENEFICIARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteRetencionConstantesFunciones.NOMBREBENEF;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteRetencionConstantesFunciones.DIRECCIONBENEF;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteRetencionConstantesFunciones.TELEFONOBENEF;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteRetencionConstantesFunciones.RUCBENEF;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteRetencionConstantesFunciones.IDESTADORETENCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarClienteRetencion() throws Exception  {
		return ClienteRetencionConstantesFunciones.getTiposSeleccionarClienteRetencion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarClienteRetencion(Boolean conFk) throws Exception  {
		return ClienteRetencionConstantesFunciones.getTiposSeleccionarClienteRetencion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarClienteRetencion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteRetencionConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ClienteRetencionConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteRetencionConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ClienteRetencionConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteRetencionConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(ClienteRetencionConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteRetencionConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(ClienteRetencionConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteRetencionConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(ClienteRetencionConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteRetencionConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(ClienteRetencionConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteRetencionConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(ClienteRetencionConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteRetencionConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(ClienteRetencionConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteRetencionConstantesFunciones.LABEL_IDFACTURA);
			reporte.setsDescripcion(ClienteRetencionConstantesFunciones.LABEL_IDFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteRetencionConstantesFunciones.LABEL_IDTRANSACCION);
			reporte.setsDescripcion(ClienteRetencionConstantesFunciones.LABEL_IDTRANSACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteRetencionConstantesFunciones.LABEL_IDTIPORETENCION);
			reporte.setsDescripcion(ClienteRetencionConstantesFunciones.LABEL_IDTIPORETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteRetencionConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(ClienteRetencionConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteRetencionConstantesFunciones.LABEL_BASEIMPONIBLE);
			reporte.setsDescripcion(ClienteRetencionConstantesFunciones.LABEL_BASEIMPONIBLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteRetencionConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(ClienteRetencionConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteRetencionConstantesFunciones.LABEL_NUMERORETENCION);
			reporte.setsDescripcion(ClienteRetencionConstantesFunciones.LABEL_NUMERORETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteRetencionConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ClienteRetencionConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteRetencionConstantesFunciones.LABEL_IDASIENTOCONTABLE);
			reporte.setsDescripcion(ClienteRetencionConstantesFunciones.LABEL_IDASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteRetencionConstantesFunciones.LABEL_IDCUENTACONTABLECLIENTERETENCION);
			reporte.setsDescripcion(ClienteRetencionConstantesFunciones.LABEL_IDCUENTACONTABLECLIENTERETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteRetencionConstantesFunciones.LABEL_VALORTIPOCAMBIO);
			reporte.setsDescripcion(ClienteRetencionConstantesFunciones.LABEL_VALORTIPOCAMBIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteRetencionConstantesFunciones.LABEL_DEBITOMONELOCAL);
			reporte.setsDescripcion(ClienteRetencionConstantesFunciones.LABEL_DEBITOMONELOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteRetencionConstantesFunciones.LABEL_CREDITOMONELOCAL);
			reporte.setsDescripcion(ClienteRetencionConstantesFunciones.LABEL_CREDITOMONELOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteRetencionConstantesFunciones.LABEL_DEBITOMONEEXTRA);
			reporte.setsDescripcion(ClienteRetencionConstantesFunciones.LABEL_DEBITOMONEEXTRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteRetencionConstantesFunciones.LABEL_CREDITOMONEEXTRA);
			reporte.setsDescripcion(ClienteRetencionConstantesFunciones.LABEL_CREDITOMONEEXTRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteRetencionConstantesFunciones.LABEL_BENEFICIARIO);
			reporte.setsDescripcion(ClienteRetencionConstantesFunciones.LABEL_BENEFICIARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteRetencionConstantesFunciones.LABEL_NOMBREBENEF);
			reporte.setsDescripcion(ClienteRetencionConstantesFunciones.LABEL_NOMBREBENEF);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteRetencionConstantesFunciones.LABEL_DIRECCIONBENEF);
			reporte.setsDescripcion(ClienteRetencionConstantesFunciones.LABEL_DIRECCIONBENEF);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteRetencionConstantesFunciones.LABEL_TELEFONOBENEF);
			reporte.setsDescripcion(ClienteRetencionConstantesFunciones.LABEL_TELEFONOBENEF);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteRetencionConstantesFunciones.LABEL_RUCBENEF);
			reporte.setsDescripcion(ClienteRetencionConstantesFunciones.LABEL_RUCBENEF);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteRetencionConstantesFunciones.LABEL_IDESTADORETENCION);
			reporte.setsDescripcion(ClienteRetencionConstantesFunciones.LABEL_IDESTADORETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesClienteRetencion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesClienteRetencion(ClienteRetencion clienteretencionAux) throws Exception {
		
			clienteretencionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(clienteretencionAux.getEmpresa()));
			clienteretencionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(clienteretencionAux.getSucursal()));
			clienteretencionAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(clienteretencionAux.getEjercicio()));
			clienteretencionAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(clienteretencionAux.getPeriodo()));
			clienteretencionAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(clienteretencionAux.getAnio()));
			clienteretencionAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(clienteretencionAux.getMes()));
			clienteretencionAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(clienteretencionAux.getCliente()));
			clienteretencionAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(clienteretencionAux.getFactura()));
			clienteretencionAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(clienteretencionAux.getTransaccion()));
			clienteretencionAux.settiporetencion_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(clienteretencionAux.getTipoRetencion()));
			clienteretencionAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(clienteretencionAux.getAsientoContable()));
			clienteretencionAux.setcuentacontableclienteretencion_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(clienteretencionAux.getCuentaContableClienteRetencion()));
			clienteretencionAux.setestadoretencion_descripcion(EstadoRetencionConstantesFunciones.getEstadoRetencionDescripcion(clienteretencionAux.getEstadoRetencion()));		
	}
	
	public static void refrescarForeignKeysDescripcionesClienteRetencion(List<ClienteRetencion> clienteretencionsTemp) throws Exception {
		for(ClienteRetencion clienteretencionAux:clienteretencionsTemp) {
			
			clienteretencionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(clienteretencionAux.getEmpresa()));
			clienteretencionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(clienteretencionAux.getSucursal()));
			clienteretencionAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(clienteretencionAux.getEjercicio()));
			clienteretencionAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(clienteretencionAux.getPeriodo()));
			clienteretencionAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(clienteretencionAux.getAnio()));
			clienteretencionAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(clienteretencionAux.getMes()));
			clienteretencionAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(clienteretencionAux.getCliente()));
			clienteretencionAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(clienteretencionAux.getFactura()));
			clienteretencionAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(clienteretencionAux.getTransaccion()));
			clienteretencionAux.settiporetencion_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(clienteretencionAux.getTipoRetencion()));
			clienteretencionAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(clienteretencionAux.getAsientoContable()));
			clienteretencionAux.setcuentacontableclienteretencion_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(clienteretencionAux.getCuentaContableClienteRetencion()));
			clienteretencionAux.setestadoretencion_descripcion(EstadoRetencionConstantesFunciones.getEstadoRetencionDescripcion(clienteretencionAux.getEstadoRetencion()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfClienteRetencion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Factura.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(TipoRetencion.class));
				classes.add(new Classe(AsientoContable.class));
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
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoRetencion.class)) {
						classes.add(new Classe(TipoRetencion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(AsientoContable.class)) {
						classes.add(new Classe(AsientoContable.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfClienteRetencion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
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

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfClienteRetencion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ClienteRetencionConstantesFunciones.getClassesRelationshipsOfClienteRetencion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfClienteRetencion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfClienteRetencion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ClienteRetencionConstantesFunciones.getClassesRelationshipsFromStringsOfClienteRetencion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfClienteRetencion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ClienteRetencion clienteretencion,List<ClienteRetencion> clienteretencions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ClienteRetencion clienteretencionEncontrado=null;
			
			for(ClienteRetencion clienteretencionLocal:clienteretencions) {
				if(clienteretencionLocal.getId().equals(clienteretencion.getId())) {
					clienteretencionEncontrado=clienteretencionLocal;
					
					clienteretencionLocal.setIsChanged(clienteretencion.getIsChanged());
					clienteretencionLocal.setIsNew(clienteretencion.getIsNew());
					clienteretencionLocal.setIsDeleted(clienteretencion.getIsDeleted());
					
					clienteretencionLocal.setGeneralEntityOriginal(clienteretencion.getGeneralEntityOriginal());
					
					clienteretencionLocal.setId(clienteretencion.getId());	
					clienteretencionLocal.setVersionRow(clienteretencion.getVersionRow());	
					clienteretencionLocal.setid_empresa(clienteretencion.getid_empresa());	
					clienteretencionLocal.setid_sucursal(clienteretencion.getid_sucursal());	
					clienteretencionLocal.setid_ejercicio(clienteretencion.getid_ejercicio());	
					clienteretencionLocal.setid_periodo(clienteretencion.getid_periodo());	
					clienteretencionLocal.setid_anio(clienteretencion.getid_anio());	
					clienteretencionLocal.setid_mes(clienteretencion.getid_mes());	
					clienteretencionLocal.setfecha(clienteretencion.getfecha());	
					clienteretencionLocal.setid_cliente(clienteretencion.getid_cliente());	
					clienteretencionLocal.setid_factura(clienteretencion.getid_factura());	
					clienteretencionLocal.setid_transaccion(clienteretencion.getid_transaccion());	
					clienteretencionLocal.setid_tipo_retencion(clienteretencion.getid_tipo_retencion());	
					clienteretencionLocal.setporcentaje(clienteretencion.getporcentaje());	
					clienteretencionLocal.setbase_imponible(clienteretencion.getbase_imponible());	
					clienteretencionLocal.setvalor(clienteretencion.getvalor());	
					clienteretencionLocal.setnumero_retencion(clienteretencion.getnumero_retencion());	
					clienteretencionLocal.setdescripcion(clienteretencion.getdescripcion());	
					clienteretencionLocal.setid_asiento_contable(clienteretencion.getid_asiento_contable());	
					clienteretencionLocal.setid_cuenta_contable_retencion(clienteretencion.getid_cuenta_contable_retencion());	
					clienteretencionLocal.setvalor_tipo_cambio(clienteretencion.getvalor_tipo_cambio());	
					clienteretencionLocal.setdebito_mone_local(clienteretencion.getdebito_mone_local());	
					clienteretencionLocal.setcredito_mone_local(clienteretencion.getcredito_mone_local());	
					clienteretencionLocal.setdebito_mone_extra(clienteretencion.getdebito_mone_extra());	
					clienteretencionLocal.setcredito_mone_extra(clienteretencion.getcredito_mone_extra());	
					clienteretencionLocal.setbeneficiario(clienteretencion.getbeneficiario());	
					clienteretencionLocal.setnombre_benef(clienteretencion.getnombre_benef());	
					clienteretencionLocal.setdireccion_benef(clienteretencion.getdireccion_benef());	
					clienteretencionLocal.settelefono_benef(clienteretencion.gettelefono_benef());	
					clienteretencionLocal.setruc_benef(clienteretencion.getruc_benef());	
					clienteretencionLocal.setid_estado_retencion(clienteretencion.getid_estado_retencion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!clienteretencion.getIsDeleted()) {
				if(!existe) {
					clienteretencions.add(clienteretencion);
				}
			} else {
				if(clienteretencionEncontrado!=null && permiteQuitar)  {
					clienteretencions.remove(clienteretencionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ClienteRetencion clienteretencion,List<ClienteRetencion> clienteretencions) throws Exception {
		try	{			
			for(ClienteRetencion clienteretencionLocal:clienteretencions) {
				if(clienteretencionLocal.getId().equals(clienteretencion.getId())) {
					clienteretencionLocal.setIsSelected(clienteretencion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesClienteRetencion(List<ClienteRetencion> clienteretencionsAux) throws Exception {
		//this.clienteretencionsAux=clienteretencionsAux;
		
		for(ClienteRetencion clienteretencionAux:clienteretencionsAux) {
			if(clienteretencionAux.getIsChanged()) {
				clienteretencionAux.setIsChanged(false);
			}		
			
			if(clienteretencionAux.getIsNew()) {
				clienteretencionAux.setIsNew(false);
			}	
			
			if(clienteretencionAux.getIsDeleted()) {
				clienteretencionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesClienteRetencion(ClienteRetencion clienteretencionAux) throws Exception {
		//this.clienteretencionAux=clienteretencionAux;
		
			if(clienteretencionAux.getIsChanged()) {
				clienteretencionAux.setIsChanged(false);
			}		
			
			if(clienteretencionAux.getIsNew()) {
				clienteretencionAux.setIsNew(false);
			}	
			
			if(clienteretencionAux.getIsDeleted()) {
				clienteretencionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ClienteRetencion clienteretencionAsignar,ClienteRetencion clienteretencion) throws Exception {
		clienteretencionAsignar.setId(clienteretencion.getId());	
		clienteretencionAsignar.setVersionRow(clienteretencion.getVersionRow());	
		clienteretencionAsignar.setid_empresa(clienteretencion.getid_empresa());
		clienteretencionAsignar.setempresa_descripcion(clienteretencion.getempresa_descripcion());	
		clienteretencionAsignar.setid_sucursal(clienteretencion.getid_sucursal());
		clienteretencionAsignar.setsucursal_descripcion(clienteretencion.getsucursal_descripcion());	
		clienteretencionAsignar.setid_ejercicio(clienteretencion.getid_ejercicio());
		clienteretencionAsignar.setejercicio_descripcion(clienteretencion.getejercicio_descripcion());	
		clienteretencionAsignar.setid_periodo(clienteretencion.getid_periodo());
		clienteretencionAsignar.setperiodo_descripcion(clienteretencion.getperiodo_descripcion());	
		clienteretencionAsignar.setid_anio(clienteretencion.getid_anio());
		clienteretencionAsignar.setanio_descripcion(clienteretencion.getanio_descripcion());	
		clienteretencionAsignar.setid_mes(clienteretencion.getid_mes());
		clienteretencionAsignar.setmes_descripcion(clienteretencion.getmes_descripcion());	
		clienteretencionAsignar.setfecha(clienteretencion.getfecha());	
		clienteretencionAsignar.setid_cliente(clienteretencion.getid_cliente());
		clienteretencionAsignar.setcliente_descripcion(clienteretencion.getcliente_descripcion());	
		clienteretencionAsignar.setid_factura(clienteretencion.getid_factura());
		clienteretencionAsignar.setfactura_descripcion(clienteretencion.getfactura_descripcion());	
		clienteretencionAsignar.setid_transaccion(clienteretencion.getid_transaccion());
		clienteretencionAsignar.settransaccion_descripcion(clienteretencion.gettransaccion_descripcion());	
		clienteretencionAsignar.setid_tipo_retencion(clienteretencion.getid_tipo_retencion());
		clienteretencionAsignar.settiporetencion_descripcion(clienteretencion.gettiporetencion_descripcion());	
		clienteretencionAsignar.setporcentaje(clienteretencion.getporcentaje());	
		clienteretencionAsignar.setbase_imponible(clienteretencion.getbase_imponible());	
		clienteretencionAsignar.setvalor(clienteretencion.getvalor());	
		clienteretencionAsignar.setnumero_retencion(clienteretencion.getnumero_retencion());	
		clienteretencionAsignar.setdescripcion(clienteretencion.getdescripcion());	
		clienteretencionAsignar.setid_asiento_contable(clienteretencion.getid_asiento_contable());
		clienteretencionAsignar.setasientocontable_descripcion(clienteretencion.getasientocontable_descripcion());	
		clienteretencionAsignar.setid_cuenta_contable_retencion(clienteretencion.getid_cuenta_contable_retencion());
		clienteretencionAsignar.setcuentacontableclienteretencion_descripcion(clienteretencion.getcuentacontableclienteretencion_descripcion());	
		clienteretencionAsignar.setvalor_tipo_cambio(clienteretencion.getvalor_tipo_cambio());	
		clienteretencionAsignar.setdebito_mone_local(clienteretencion.getdebito_mone_local());	
		clienteretencionAsignar.setcredito_mone_local(clienteretencion.getcredito_mone_local());	
		clienteretencionAsignar.setdebito_mone_extra(clienteretencion.getdebito_mone_extra());	
		clienteretencionAsignar.setcredito_mone_extra(clienteretencion.getcredito_mone_extra());	
		clienteretencionAsignar.setbeneficiario(clienteretencion.getbeneficiario());	
		clienteretencionAsignar.setnombre_benef(clienteretencion.getnombre_benef());	
		clienteretencionAsignar.setdireccion_benef(clienteretencion.getdireccion_benef());	
		clienteretencionAsignar.settelefono_benef(clienteretencion.gettelefono_benef());	
		clienteretencionAsignar.setruc_benef(clienteretencion.getruc_benef());	
		clienteretencionAsignar.setid_estado_retencion(clienteretencion.getid_estado_retencion());
		clienteretencionAsignar.setestadoretencion_descripcion(clienteretencion.getestadoretencion_descripcion());	
	}
	
	public static void inicializarClienteRetencion(ClienteRetencion clienteretencion) throws Exception {
		try {
				clienteretencion.setId(0L);	
					
				clienteretencion.setid_empresa(-1L);	
				clienteretencion.setid_sucursal(-1L);	
				clienteretencion.setid_ejercicio(-1L);	
				clienteretencion.setid_periodo(-1L);	
				clienteretencion.setid_anio(null);	
				clienteretencion.setid_mes(null);	
				clienteretencion.setfecha(new Date());	
				clienteretencion.setid_cliente(-1L);	
				clienteretencion.setid_factura(null);	
				clienteretencion.setid_transaccion(-1L);	
				clienteretencion.setid_tipo_retencion(-1L);	
				clienteretencion.setporcentaje(0.0);	
				clienteretencion.setbase_imponible(0.0);	
				clienteretencion.setvalor(0.0);	
				clienteretencion.setnumero_retencion("");	
				clienteretencion.setdescripcion("");	
				clienteretencion.setid_asiento_contable(-1L);	
				clienteretencion.setid_cuenta_contable_retencion(-1L);	
				clienteretencion.setvalor_tipo_cambio(0.0);	
				clienteretencion.setdebito_mone_local(0.0);	
				clienteretencion.setcredito_mone_local(0.0);	
				clienteretencion.setdebito_mone_extra(0.0);	
				clienteretencion.setcredito_mone_extra(0.0);	
				clienteretencion.setbeneficiario("");	
				clienteretencion.setnombre_benef("");	
				clienteretencion.setdireccion_benef("");	
				clienteretencion.settelefono_benef("");	
				clienteretencion.setruc_benef("");	
				clienteretencion.setid_estado_retencion(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderClienteRetencion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteRetencionConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteRetencionConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteRetencionConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteRetencionConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteRetencionConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteRetencionConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteRetencionConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteRetencionConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteRetencionConstantesFunciones.LABEL_IDFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteRetencionConstantesFunciones.LABEL_IDTRANSACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteRetencionConstantesFunciones.LABEL_IDTIPORETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteRetencionConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteRetencionConstantesFunciones.LABEL_BASEIMPONIBLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteRetencionConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteRetencionConstantesFunciones.LABEL_NUMERORETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteRetencionConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteRetencionConstantesFunciones.LABEL_IDASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteRetencionConstantesFunciones.LABEL_IDCUENTACONTABLECLIENTERETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteRetencionConstantesFunciones.LABEL_VALORTIPOCAMBIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteRetencionConstantesFunciones.LABEL_DEBITOMONELOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteRetencionConstantesFunciones.LABEL_CREDITOMONELOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteRetencionConstantesFunciones.LABEL_DEBITOMONEEXTRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteRetencionConstantesFunciones.LABEL_CREDITOMONEEXTRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteRetencionConstantesFunciones.LABEL_BENEFICIARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteRetencionConstantesFunciones.LABEL_NOMBREBENEF);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteRetencionConstantesFunciones.LABEL_DIRECCIONBENEF);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteRetencionConstantesFunciones.LABEL_TELEFONOBENEF);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteRetencionConstantesFunciones.LABEL_RUCBENEF);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteRetencionConstantesFunciones.LABEL_IDESTADORETENCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataClienteRetencion(String sTipo,Row row,Workbook workbook,ClienteRetencion clienteretencion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(clienteretencion.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clienteretencion.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clienteretencion.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clienteretencion.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clienteretencion.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clienteretencion.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clienteretencion.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clienteretencion.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clienteretencion.getfactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clienteretencion.gettransaccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clienteretencion.gettiporetencion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clienteretencion.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clienteretencion.getbase_imponible());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clienteretencion.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clienteretencion.getnumero_retencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clienteretencion.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clienteretencion.getasientocontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clienteretencion.getcuentacontableclienteretencion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clienteretencion.getvalor_tipo_cambio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clienteretencion.getdebito_mone_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clienteretencion.getcredito_mone_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clienteretencion.getdebito_mone_extra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clienteretencion.getcredito_mone_extra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clienteretencion.getbeneficiario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clienteretencion.getnombre_benef());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clienteretencion.getdireccion_benef());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clienteretencion.gettelefono_benef());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clienteretencion.getruc_benef());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clienteretencion.getestadoretencion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryClienteRetencion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryClienteRetencion() {
		return this.sFinalQueryClienteRetencion;
	}
	
	public void setsFinalQueryClienteRetencion(String sFinalQueryClienteRetencion) {
		this.sFinalQueryClienteRetencion= sFinalQueryClienteRetencion;
	}
	
	public Border resaltarSeleccionarClienteRetencion=null;
	
	public Border setResaltarSeleccionarClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//clienteretencionBeanSwingJInternalFrame.jTtoolBarClienteRetencion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarClienteRetencion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarClienteRetencion() {
		return this.resaltarSeleccionarClienteRetencion;
	}
	
	public void setResaltarSeleccionarClienteRetencion(Border borderResaltarSeleccionarClienteRetencion) {
		this.resaltarSeleccionarClienteRetencion= borderResaltarSeleccionarClienteRetencion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridClienteRetencion=null;
	public Boolean mostraridClienteRetencion=true;
	public Boolean activaridClienteRetencion=true;

	public Border resaltarid_empresaClienteRetencion=null;
	public Boolean mostrarid_empresaClienteRetencion=true;
	public Boolean activarid_empresaClienteRetencion=true;
	public Boolean cargarid_empresaClienteRetencion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaClienteRetencion=false;//ConEventDepend=true

	public Border resaltarid_sucursalClienteRetencion=null;
	public Boolean mostrarid_sucursalClienteRetencion=true;
	public Boolean activarid_sucursalClienteRetencion=true;
	public Boolean cargarid_sucursalClienteRetencion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalClienteRetencion=false;//ConEventDepend=true

	public Border resaltarid_ejercicioClienteRetencion=null;
	public Boolean mostrarid_ejercicioClienteRetencion=true;
	public Boolean activarid_ejercicioClienteRetencion=true;
	public Boolean cargarid_ejercicioClienteRetencion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioClienteRetencion=false;//ConEventDepend=true

	public Border resaltarid_periodoClienteRetencion=null;
	public Boolean mostrarid_periodoClienteRetencion=true;
	public Boolean activarid_periodoClienteRetencion=true;
	public Boolean cargarid_periodoClienteRetencion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoClienteRetencion=false;//ConEventDepend=true

	public Border resaltarid_anioClienteRetencion=null;
	public Boolean mostrarid_anioClienteRetencion=true;
	public Boolean activarid_anioClienteRetencion=false;
	public Boolean cargarid_anioClienteRetencion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioClienteRetencion=false;//ConEventDepend=true

	public Border resaltarid_mesClienteRetencion=null;
	public Boolean mostrarid_mesClienteRetencion=true;
	public Boolean activarid_mesClienteRetencion=false;
	public Boolean cargarid_mesClienteRetencion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesClienteRetencion=false;//ConEventDepend=true

	public Border resaltarfechaClienteRetencion=null;
	public Boolean mostrarfechaClienteRetencion=true;
	public Boolean activarfechaClienteRetencion=true;

	public Border resaltarid_clienteClienteRetencion=null;
	public Boolean mostrarid_clienteClienteRetencion=true;
	public Boolean activarid_clienteClienteRetencion=true;
	public Boolean cargarid_clienteClienteRetencion=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteClienteRetencion=false;//ConEventDepend=true

	public Border resaltarid_facturaClienteRetencion=null;
	public Boolean mostrarid_facturaClienteRetencion=true;
	public Boolean activarid_facturaClienteRetencion=true;
	public Boolean cargarid_facturaClienteRetencion=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_facturaClienteRetencion=false;//ConEventDepend=true

	public Border resaltarid_transaccionClienteRetencion=null;
	public Boolean mostrarid_transaccionClienteRetencion=true;
	public Boolean activarid_transaccionClienteRetencion=true;
	public Boolean cargarid_transaccionClienteRetencion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccionClienteRetencion=false;//ConEventDepend=true

	public Border resaltarid_tipo_retencionClienteRetencion=null;
	public Boolean mostrarid_tipo_retencionClienteRetencion=true;
	public Boolean activarid_tipo_retencionClienteRetencion=true;
	public Boolean cargarid_tipo_retencionClienteRetencion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_retencionClienteRetencion=false;//ConEventDepend=true

	public Border resaltarporcentajeClienteRetencion=null;
	public Boolean mostrarporcentajeClienteRetencion=true;
	public Boolean activarporcentajeClienteRetencion=true;

	public Border resaltarbase_imponibleClienteRetencion=null;
	public Boolean mostrarbase_imponibleClienteRetencion=true;
	public Boolean activarbase_imponibleClienteRetencion=true;

	public Border resaltarvalorClienteRetencion=null;
	public Boolean mostrarvalorClienteRetencion=true;
	public Boolean activarvalorClienteRetencion=true;

	public Border resaltarnumero_retencionClienteRetencion=null;
	public Boolean mostrarnumero_retencionClienteRetencion=true;
	public Boolean activarnumero_retencionClienteRetencion=true;

	public Border resaltardescripcionClienteRetencion=null;
	public Boolean mostrardescripcionClienteRetencion=true;
	public Boolean activardescripcionClienteRetencion=true;

	public Border resaltarid_asiento_contableClienteRetencion=null;
	public Boolean mostrarid_asiento_contableClienteRetencion=true;
	public Boolean activarid_asiento_contableClienteRetencion=false;
	public Boolean cargarid_asiento_contableClienteRetencion=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_asiento_contableClienteRetencion=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_retencionClienteRetencion=null;
	public Boolean mostrarid_cuenta_contable_retencionClienteRetencion=true;
	public Boolean activarid_cuenta_contable_retencionClienteRetencion=false;
	public Boolean cargarid_cuenta_contable_retencionClienteRetencion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_retencionClienteRetencion=false;//ConEventDepend=true

	public Border resaltarvalor_tipo_cambioClienteRetencion=null;
	public Boolean mostrarvalor_tipo_cambioClienteRetencion=true;
	public Boolean activarvalor_tipo_cambioClienteRetencion=false;

	public Border resaltardebito_mone_localClienteRetencion=null;
	public Boolean mostrardebito_mone_localClienteRetencion=true;
	public Boolean activardebito_mone_localClienteRetencion=false;

	public Border resaltarcredito_mone_localClienteRetencion=null;
	public Boolean mostrarcredito_mone_localClienteRetencion=true;
	public Boolean activarcredito_mone_localClienteRetencion=false;

	public Border resaltardebito_mone_extraClienteRetencion=null;
	public Boolean mostrardebito_mone_extraClienteRetencion=true;
	public Boolean activardebito_mone_extraClienteRetencion=false;

	public Border resaltarcredito_mone_extraClienteRetencion=null;
	public Boolean mostrarcredito_mone_extraClienteRetencion=true;
	public Boolean activarcredito_mone_extraClienteRetencion=false;

	public Border resaltarbeneficiarioClienteRetencion=null;
	public Boolean mostrarbeneficiarioClienteRetencion=true;
	public Boolean activarbeneficiarioClienteRetencion=false;

	public Border resaltarnombre_benefClienteRetencion=null;
	public Boolean mostrarnombre_benefClienteRetencion=true;
	public Boolean activarnombre_benefClienteRetencion=false;

	public Border resaltardireccion_benefClienteRetencion=null;
	public Boolean mostrardireccion_benefClienteRetencion=true;
	public Boolean activardireccion_benefClienteRetencion=false;

	public Border resaltartelefono_benefClienteRetencion=null;
	public Boolean mostrartelefono_benefClienteRetencion=true;
	public Boolean activartelefono_benefClienteRetencion=false;

	public Border resaltarruc_benefClienteRetencion=null;
	public Boolean mostrarruc_benefClienteRetencion=true;
	public Boolean activarruc_benefClienteRetencion=false;

	public Border resaltarid_estado_retencionClienteRetencion=null;
	public Boolean mostrarid_estado_retencionClienteRetencion=true;
	public Boolean activarid_estado_retencionClienteRetencion=false;
	public Boolean cargarid_estado_retencionClienteRetencion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_retencionClienteRetencion=false;//ConEventDepend=true

	
	

	public Border setResaltaridClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteretencionBeanSwingJInternalFrame.jTtoolBarClienteRetencion.setBorder(borderResaltar);
		
		this.resaltaridClienteRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridClienteRetencion() {
		return this.resaltaridClienteRetencion;
	}

	public void setResaltaridClienteRetencion(Border borderResaltar) {
		this.resaltaridClienteRetencion= borderResaltar;
	}

	public Boolean getMostraridClienteRetencion() {
		return this.mostraridClienteRetencion;
	}

	public void setMostraridClienteRetencion(Boolean mostraridClienteRetencion) {
		this.mostraridClienteRetencion= mostraridClienteRetencion;
	}

	public Boolean getActivaridClienteRetencion() {
		return this.activaridClienteRetencion;
	}

	public void setActivaridClienteRetencion(Boolean activaridClienteRetencion) {
		this.activaridClienteRetencion= activaridClienteRetencion;
	}

	public Border setResaltarid_empresaClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteretencionBeanSwingJInternalFrame.jTtoolBarClienteRetencion.setBorder(borderResaltar);
		
		this.resaltarid_empresaClienteRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaClienteRetencion() {
		return this.resaltarid_empresaClienteRetencion;
	}

	public void setResaltarid_empresaClienteRetencion(Border borderResaltar) {
		this.resaltarid_empresaClienteRetencion= borderResaltar;
	}

	public Boolean getMostrarid_empresaClienteRetencion() {
		return this.mostrarid_empresaClienteRetencion;
	}

	public void setMostrarid_empresaClienteRetencion(Boolean mostrarid_empresaClienteRetencion) {
		this.mostrarid_empresaClienteRetencion= mostrarid_empresaClienteRetencion;
	}

	public Boolean getActivarid_empresaClienteRetencion() {
		return this.activarid_empresaClienteRetencion;
	}

	public void setActivarid_empresaClienteRetencion(Boolean activarid_empresaClienteRetencion) {
		this.activarid_empresaClienteRetencion= activarid_empresaClienteRetencion;
	}

	public Boolean getCargarid_empresaClienteRetencion() {
		return this.cargarid_empresaClienteRetencion;
	}

	public void setCargarid_empresaClienteRetencion(Boolean cargarid_empresaClienteRetencion) {
		this.cargarid_empresaClienteRetencion= cargarid_empresaClienteRetencion;
	}

	public Border setResaltarid_sucursalClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteretencionBeanSwingJInternalFrame.jTtoolBarClienteRetencion.setBorder(borderResaltar);
		
		this.resaltarid_sucursalClienteRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalClienteRetencion() {
		return this.resaltarid_sucursalClienteRetencion;
	}

	public void setResaltarid_sucursalClienteRetencion(Border borderResaltar) {
		this.resaltarid_sucursalClienteRetencion= borderResaltar;
	}

	public Boolean getMostrarid_sucursalClienteRetencion() {
		return this.mostrarid_sucursalClienteRetencion;
	}

	public void setMostrarid_sucursalClienteRetencion(Boolean mostrarid_sucursalClienteRetencion) {
		this.mostrarid_sucursalClienteRetencion= mostrarid_sucursalClienteRetencion;
	}

	public Boolean getActivarid_sucursalClienteRetencion() {
		return this.activarid_sucursalClienteRetencion;
	}

	public void setActivarid_sucursalClienteRetencion(Boolean activarid_sucursalClienteRetencion) {
		this.activarid_sucursalClienteRetencion= activarid_sucursalClienteRetencion;
	}

	public Boolean getCargarid_sucursalClienteRetencion() {
		return this.cargarid_sucursalClienteRetencion;
	}

	public void setCargarid_sucursalClienteRetencion(Boolean cargarid_sucursalClienteRetencion) {
		this.cargarid_sucursalClienteRetencion= cargarid_sucursalClienteRetencion;
	}

	public Border setResaltarid_ejercicioClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteretencionBeanSwingJInternalFrame.jTtoolBarClienteRetencion.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioClienteRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioClienteRetencion() {
		return this.resaltarid_ejercicioClienteRetencion;
	}

	public void setResaltarid_ejercicioClienteRetencion(Border borderResaltar) {
		this.resaltarid_ejercicioClienteRetencion= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioClienteRetencion() {
		return this.mostrarid_ejercicioClienteRetencion;
	}

	public void setMostrarid_ejercicioClienteRetencion(Boolean mostrarid_ejercicioClienteRetencion) {
		this.mostrarid_ejercicioClienteRetencion= mostrarid_ejercicioClienteRetencion;
	}

	public Boolean getActivarid_ejercicioClienteRetencion() {
		return this.activarid_ejercicioClienteRetencion;
	}

	public void setActivarid_ejercicioClienteRetencion(Boolean activarid_ejercicioClienteRetencion) {
		this.activarid_ejercicioClienteRetencion= activarid_ejercicioClienteRetencion;
	}

	public Boolean getCargarid_ejercicioClienteRetencion() {
		return this.cargarid_ejercicioClienteRetencion;
	}

	public void setCargarid_ejercicioClienteRetencion(Boolean cargarid_ejercicioClienteRetencion) {
		this.cargarid_ejercicioClienteRetencion= cargarid_ejercicioClienteRetencion;
	}

	public Border setResaltarid_periodoClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteretencionBeanSwingJInternalFrame.jTtoolBarClienteRetencion.setBorder(borderResaltar);
		
		this.resaltarid_periodoClienteRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoClienteRetencion() {
		return this.resaltarid_periodoClienteRetencion;
	}

	public void setResaltarid_periodoClienteRetencion(Border borderResaltar) {
		this.resaltarid_periodoClienteRetencion= borderResaltar;
	}

	public Boolean getMostrarid_periodoClienteRetencion() {
		return this.mostrarid_periodoClienteRetencion;
	}

	public void setMostrarid_periodoClienteRetencion(Boolean mostrarid_periodoClienteRetencion) {
		this.mostrarid_periodoClienteRetencion= mostrarid_periodoClienteRetencion;
	}

	public Boolean getActivarid_periodoClienteRetencion() {
		return this.activarid_periodoClienteRetencion;
	}

	public void setActivarid_periodoClienteRetencion(Boolean activarid_periodoClienteRetencion) {
		this.activarid_periodoClienteRetencion= activarid_periodoClienteRetencion;
	}

	public Boolean getCargarid_periodoClienteRetencion() {
		return this.cargarid_periodoClienteRetencion;
	}

	public void setCargarid_periodoClienteRetencion(Boolean cargarid_periodoClienteRetencion) {
		this.cargarid_periodoClienteRetencion= cargarid_periodoClienteRetencion;
	}

	public Border setResaltarid_anioClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteretencionBeanSwingJInternalFrame.jTtoolBarClienteRetencion.setBorder(borderResaltar);
		
		this.resaltarid_anioClienteRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioClienteRetencion() {
		return this.resaltarid_anioClienteRetencion;
	}

	public void setResaltarid_anioClienteRetencion(Border borderResaltar) {
		this.resaltarid_anioClienteRetencion= borderResaltar;
	}

	public Boolean getMostrarid_anioClienteRetencion() {
		return this.mostrarid_anioClienteRetencion;
	}

	public void setMostrarid_anioClienteRetencion(Boolean mostrarid_anioClienteRetencion) {
		this.mostrarid_anioClienteRetencion= mostrarid_anioClienteRetencion;
	}

	public Boolean getActivarid_anioClienteRetencion() {
		return this.activarid_anioClienteRetencion;
	}

	public void setActivarid_anioClienteRetencion(Boolean activarid_anioClienteRetencion) {
		this.activarid_anioClienteRetencion= activarid_anioClienteRetencion;
	}

	public Boolean getCargarid_anioClienteRetencion() {
		return this.cargarid_anioClienteRetencion;
	}

	public void setCargarid_anioClienteRetencion(Boolean cargarid_anioClienteRetencion) {
		this.cargarid_anioClienteRetencion= cargarid_anioClienteRetencion;
	}

	public Border setResaltarid_mesClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteretencionBeanSwingJInternalFrame.jTtoolBarClienteRetencion.setBorder(borderResaltar);
		
		this.resaltarid_mesClienteRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesClienteRetencion() {
		return this.resaltarid_mesClienteRetencion;
	}

	public void setResaltarid_mesClienteRetencion(Border borderResaltar) {
		this.resaltarid_mesClienteRetencion= borderResaltar;
	}

	public Boolean getMostrarid_mesClienteRetencion() {
		return this.mostrarid_mesClienteRetencion;
	}

	public void setMostrarid_mesClienteRetencion(Boolean mostrarid_mesClienteRetencion) {
		this.mostrarid_mesClienteRetencion= mostrarid_mesClienteRetencion;
	}

	public Boolean getActivarid_mesClienteRetencion() {
		return this.activarid_mesClienteRetencion;
	}

	public void setActivarid_mesClienteRetencion(Boolean activarid_mesClienteRetencion) {
		this.activarid_mesClienteRetencion= activarid_mesClienteRetencion;
	}

	public Boolean getCargarid_mesClienteRetencion() {
		return this.cargarid_mesClienteRetencion;
	}

	public void setCargarid_mesClienteRetencion(Boolean cargarid_mesClienteRetencion) {
		this.cargarid_mesClienteRetencion= cargarid_mesClienteRetencion;
	}

	public Border setResaltarfechaClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteretencionBeanSwingJInternalFrame.jTtoolBarClienteRetencion.setBorder(borderResaltar);
		
		this.resaltarfechaClienteRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaClienteRetencion() {
		return this.resaltarfechaClienteRetencion;
	}

	public void setResaltarfechaClienteRetencion(Border borderResaltar) {
		this.resaltarfechaClienteRetencion= borderResaltar;
	}

	public Boolean getMostrarfechaClienteRetencion() {
		return this.mostrarfechaClienteRetencion;
	}

	public void setMostrarfechaClienteRetencion(Boolean mostrarfechaClienteRetencion) {
		this.mostrarfechaClienteRetencion= mostrarfechaClienteRetencion;
	}

	public Boolean getActivarfechaClienteRetencion() {
		return this.activarfechaClienteRetencion;
	}

	public void setActivarfechaClienteRetencion(Boolean activarfechaClienteRetencion) {
		this.activarfechaClienteRetencion= activarfechaClienteRetencion;
	}

	public Border setResaltarid_clienteClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteretencionBeanSwingJInternalFrame.jTtoolBarClienteRetencion.setBorder(borderResaltar);
		
		this.resaltarid_clienteClienteRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteClienteRetencion() {
		return this.resaltarid_clienteClienteRetencion;
	}

	public void setResaltarid_clienteClienteRetencion(Border borderResaltar) {
		this.resaltarid_clienteClienteRetencion= borderResaltar;
	}

	public Boolean getMostrarid_clienteClienteRetencion() {
		return this.mostrarid_clienteClienteRetencion;
	}

	public void setMostrarid_clienteClienteRetencion(Boolean mostrarid_clienteClienteRetencion) {
		this.mostrarid_clienteClienteRetencion= mostrarid_clienteClienteRetencion;
	}

	public Boolean getActivarid_clienteClienteRetencion() {
		return this.activarid_clienteClienteRetencion;
	}

	public void setActivarid_clienteClienteRetencion(Boolean activarid_clienteClienteRetencion) {
		this.activarid_clienteClienteRetencion= activarid_clienteClienteRetencion;
	}

	public Boolean getCargarid_clienteClienteRetencion() {
		return this.cargarid_clienteClienteRetencion;
	}

	public void setCargarid_clienteClienteRetencion(Boolean cargarid_clienteClienteRetencion) {
		this.cargarid_clienteClienteRetencion= cargarid_clienteClienteRetencion;
	}

	public Border setResaltarid_facturaClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteretencionBeanSwingJInternalFrame.jTtoolBarClienteRetencion.setBorder(borderResaltar);
		
		this.resaltarid_facturaClienteRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_facturaClienteRetencion() {
		return this.resaltarid_facturaClienteRetencion;
	}

	public void setResaltarid_facturaClienteRetencion(Border borderResaltar) {
		this.resaltarid_facturaClienteRetencion= borderResaltar;
	}

	public Boolean getMostrarid_facturaClienteRetencion() {
		return this.mostrarid_facturaClienteRetencion;
	}

	public void setMostrarid_facturaClienteRetencion(Boolean mostrarid_facturaClienteRetencion) {
		this.mostrarid_facturaClienteRetencion= mostrarid_facturaClienteRetencion;
	}

	public Boolean getActivarid_facturaClienteRetencion() {
		return this.activarid_facturaClienteRetencion;
	}

	public void setActivarid_facturaClienteRetencion(Boolean activarid_facturaClienteRetencion) {
		this.activarid_facturaClienteRetencion= activarid_facturaClienteRetencion;
	}

	public Boolean getCargarid_facturaClienteRetencion() {
		return this.cargarid_facturaClienteRetencion;
	}

	public void setCargarid_facturaClienteRetencion(Boolean cargarid_facturaClienteRetencion) {
		this.cargarid_facturaClienteRetencion= cargarid_facturaClienteRetencion;
	}

	public Border setResaltarid_transaccionClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteretencionBeanSwingJInternalFrame.jTtoolBarClienteRetencion.setBorder(borderResaltar);
		
		this.resaltarid_transaccionClienteRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccionClienteRetencion() {
		return this.resaltarid_transaccionClienteRetencion;
	}

	public void setResaltarid_transaccionClienteRetencion(Border borderResaltar) {
		this.resaltarid_transaccionClienteRetencion= borderResaltar;
	}

	public Boolean getMostrarid_transaccionClienteRetencion() {
		return this.mostrarid_transaccionClienteRetencion;
	}

	public void setMostrarid_transaccionClienteRetencion(Boolean mostrarid_transaccionClienteRetencion) {
		this.mostrarid_transaccionClienteRetencion= mostrarid_transaccionClienteRetencion;
	}

	public Boolean getActivarid_transaccionClienteRetencion() {
		return this.activarid_transaccionClienteRetencion;
	}

	public void setActivarid_transaccionClienteRetencion(Boolean activarid_transaccionClienteRetencion) {
		this.activarid_transaccionClienteRetencion= activarid_transaccionClienteRetencion;
	}

	public Boolean getCargarid_transaccionClienteRetencion() {
		return this.cargarid_transaccionClienteRetencion;
	}

	public void setCargarid_transaccionClienteRetencion(Boolean cargarid_transaccionClienteRetencion) {
		this.cargarid_transaccionClienteRetencion= cargarid_transaccionClienteRetencion;
	}

	public Border setResaltarid_tipo_retencionClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteretencionBeanSwingJInternalFrame.jTtoolBarClienteRetencion.setBorder(borderResaltar);
		
		this.resaltarid_tipo_retencionClienteRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_retencionClienteRetencion() {
		return this.resaltarid_tipo_retencionClienteRetencion;
	}

	public void setResaltarid_tipo_retencionClienteRetencion(Border borderResaltar) {
		this.resaltarid_tipo_retencionClienteRetencion= borderResaltar;
	}

	public Boolean getMostrarid_tipo_retencionClienteRetencion() {
		return this.mostrarid_tipo_retencionClienteRetencion;
	}

	public void setMostrarid_tipo_retencionClienteRetencion(Boolean mostrarid_tipo_retencionClienteRetencion) {
		this.mostrarid_tipo_retencionClienteRetencion= mostrarid_tipo_retencionClienteRetencion;
	}

	public Boolean getActivarid_tipo_retencionClienteRetencion() {
		return this.activarid_tipo_retencionClienteRetencion;
	}

	public void setActivarid_tipo_retencionClienteRetencion(Boolean activarid_tipo_retencionClienteRetencion) {
		this.activarid_tipo_retencionClienteRetencion= activarid_tipo_retencionClienteRetencion;
	}

	public Boolean getCargarid_tipo_retencionClienteRetencion() {
		return this.cargarid_tipo_retencionClienteRetencion;
	}

	public void setCargarid_tipo_retencionClienteRetencion(Boolean cargarid_tipo_retencionClienteRetencion) {
		this.cargarid_tipo_retencionClienteRetencion= cargarid_tipo_retencionClienteRetencion;
	}

	public Border setResaltarporcentajeClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteretencionBeanSwingJInternalFrame.jTtoolBarClienteRetencion.setBorder(borderResaltar);
		
		this.resaltarporcentajeClienteRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeClienteRetencion() {
		return this.resaltarporcentajeClienteRetencion;
	}

	public void setResaltarporcentajeClienteRetencion(Border borderResaltar) {
		this.resaltarporcentajeClienteRetencion= borderResaltar;
	}

	public Boolean getMostrarporcentajeClienteRetencion() {
		return this.mostrarporcentajeClienteRetencion;
	}

	public void setMostrarporcentajeClienteRetencion(Boolean mostrarporcentajeClienteRetencion) {
		this.mostrarporcentajeClienteRetencion= mostrarporcentajeClienteRetencion;
	}

	public Boolean getActivarporcentajeClienteRetencion() {
		return this.activarporcentajeClienteRetencion;
	}

	public void setActivarporcentajeClienteRetencion(Boolean activarporcentajeClienteRetencion) {
		this.activarporcentajeClienteRetencion= activarporcentajeClienteRetencion;
	}

	public Border setResaltarbase_imponibleClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteretencionBeanSwingJInternalFrame.jTtoolBarClienteRetencion.setBorder(borderResaltar);
		
		this.resaltarbase_imponibleClienteRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbase_imponibleClienteRetencion() {
		return this.resaltarbase_imponibleClienteRetencion;
	}

	public void setResaltarbase_imponibleClienteRetencion(Border borderResaltar) {
		this.resaltarbase_imponibleClienteRetencion= borderResaltar;
	}

	public Boolean getMostrarbase_imponibleClienteRetencion() {
		return this.mostrarbase_imponibleClienteRetencion;
	}

	public void setMostrarbase_imponibleClienteRetencion(Boolean mostrarbase_imponibleClienteRetencion) {
		this.mostrarbase_imponibleClienteRetencion= mostrarbase_imponibleClienteRetencion;
	}

	public Boolean getActivarbase_imponibleClienteRetencion() {
		return this.activarbase_imponibleClienteRetencion;
	}

	public void setActivarbase_imponibleClienteRetencion(Boolean activarbase_imponibleClienteRetencion) {
		this.activarbase_imponibleClienteRetencion= activarbase_imponibleClienteRetencion;
	}

	public Border setResaltarvalorClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteretencionBeanSwingJInternalFrame.jTtoolBarClienteRetencion.setBorder(borderResaltar);
		
		this.resaltarvalorClienteRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorClienteRetencion() {
		return this.resaltarvalorClienteRetencion;
	}

	public void setResaltarvalorClienteRetencion(Border borderResaltar) {
		this.resaltarvalorClienteRetencion= borderResaltar;
	}

	public Boolean getMostrarvalorClienteRetencion() {
		return this.mostrarvalorClienteRetencion;
	}

	public void setMostrarvalorClienteRetencion(Boolean mostrarvalorClienteRetencion) {
		this.mostrarvalorClienteRetencion= mostrarvalorClienteRetencion;
	}

	public Boolean getActivarvalorClienteRetencion() {
		return this.activarvalorClienteRetencion;
	}

	public void setActivarvalorClienteRetencion(Boolean activarvalorClienteRetencion) {
		this.activarvalorClienteRetencion= activarvalorClienteRetencion;
	}

	public Border setResaltarnumero_retencionClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteretencionBeanSwingJInternalFrame.jTtoolBarClienteRetencion.setBorder(borderResaltar);
		
		this.resaltarnumero_retencionClienteRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_retencionClienteRetencion() {
		return this.resaltarnumero_retencionClienteRetencion;
	}

	public void setResaltarnumero_retencionClienteRetencion(Border borderResaltar) {
		this.resaltarnumero_retencionClienteRetencion= borderResaltar;
	}

	public Boolean getMostrarnumero_retencionClienteRetencion() {
		return this.mostrarnumero_retencionClienteRetencion;
	}

	public void setMostrarnumero_retencionClienteRetencion(Boolean mostrarnumero_retencionClienteRetencion) {
		this.mostrarnumero_retencionClienteRetencion= mostrarnumero_retencionClienteRetencion;
	}

	public Boolean getActivarnumero_retencionClienteRetencion() {
		return this.activarnumero_retencionClienteRetencion;
	}

	public void setActivarnumero_retencionClienteRetencion(Boolean activarnumero_retencionClienteRetencion) {
		this.activarnumero_retencionClienteRetencion= activarnumero_retencionClienteRetencion;
	}

	public Border setResaltardescripcionClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteretencionBeanSwingJInternalFrame.jTtoolBarClienteRetencion.setBorder(borderResaltar);
		
		this.resaltardescripcionClienteRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionClienteRetencion() {
		return this.resaltardescripcionClienteRetencion;
	}

	public void setResaltardescripcionClienteRetencion(Border borderResaltar) {
		this.resaltardescripcionClienteRetencion= borderResaltar;
	}

	public Boolean getMostrardescripcionClienteRetencion() {
		return this.mostrardescripcionClienteRetencion;
	}

	public void setMostrardescripcionClienteRetencion(Boolean mostrardescripcionClienteRetencion) {
		this.mostrardescripcionClienteRetencion= mostrardescripcionClienteRetencion;
	}

	public Boolean getActivardescripcionClienteRetencion() {
		return this.activardescripcionClienteRetencion;
	}

	public void setActivardescripcionClienteRetencion(Boolean activardescripcionClienteRetencion) {
		this.activardescripcionClienteRetencion= activardescripcionClienteRetencion;
	}

	public Border setResaltarid_asiento_contableClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteretencionBeanSwingJInternalFrame.jTtoolBarClienteRetencion.setBorder(borderResaltar);
		
		this.resaltarid_asiento_contableClienteRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_asiento_contableClienteRetencion() {
		return this.resaltarid_asiento_contableClienteRetencion;
	}

	public void setResaltarid_asiento_contableClienteRetencion(Border borderResaltar) {
		this.resaltarid_asiento_contableClienteRetencion= borderResaltar;
	}

	public Boolean getMostrarid_asiento_contableClienteRetencion() {
		return this.mostrarid_asiento_contableClienteRetencion;
	}

	public void setMostrarid_asiento_contableClienteRetencion(Boolean mostrarid_asiento_contableClienteRetencion) {
		this.mostrarid_asiento_contableClienteRetencion= mostrarid_asiento_contableClienteRetencion;
	}

	public Boolean getActivarid_asiento_contableClienteRetencion() {
		return this.activarid_asiento_contableClienteRetencion;
	}

	public void setActivarid_asiento_contableClienteRetencion(Boolean activarid_asiento_contableClienteRetencion) {
		this.activarid_asiento_contableClienteRetencion= activarid_asiento_contableClienteRetencion;
	}

	public Boolean getCargarid_asiento_contableClienteRetencion() {
		return this.cargarid_asiento_contableClienteRetencion;
	}

	public void setCargarid_asiento_contableClienteRetencion(Boolean cargarid_asiento_contableClienteRetencion) {
		this.cargarid_asiento_contableClienteRetencion= cargarid_asiento_contableClienteRetencion;
	}

	public Border setResaltarid_cuenta_contable_retencionClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteretencionBeanSwingJInternalFrame.jTtoolBarClienteRetencion.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_retencionClienteRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_retencionClienteRetencion() {
		return this.resaltarid_cuenta_contable_retencionClienteRetencion;
	}

	public void setResaltarid_cuenta_contable_retencionClienteRetencion(Border borderResaltar) {
		this.resaltarid_cuenta_contable_retencionClienteRetencion= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_retencionClienteRetencion() {
		return this.mostrarid_cuenta_contable_retencionClienteRetencion;
	}

	public void setMostrarid_cuenta_contable_retencionClienteRetencion(Boolean mostrarid_cuenta_contable_retencionClienteRetencion) {
		this.mostrarid_cuenta_contable_retencionClienteRetencion= mostrarid_cuenta_contable_retencionClienteRetencion;
	}

	public Boolean getActivarid_cuenta_contable_retencionClienteRetencion() {
		return this.activarid_cuenta_contable_retencionClienteRetencion;
	}

	public void setActivarid_cuenta_contable_retencionClienteRetencion(Boolean activarid_cuenta_contable_retencionClienteRetencion) {
		this.activarid_cuenta_contable_retencionClienteRetencion= activarid_cuenta_contable_retencionClienteRetencion;
	}

	public Boolean getCargarid_cuenta_contable_retencionClienteRetencion() {
		return this.cargarid_cuenta_contable_retencionClienteRetencion;
	}

	public void setCargarid_cuenta_contable_retencionClienteRetencion(Boolean cargarid_cuenta_contable_retencionClienteRetencion) {
		this.cargarid_cuenta_contable_retencionClienteRetencion= cargarid_cuenta_contable_retencionClienteRetencion;
	}

	public Border setResaltarvalor_tipo_cambioClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteretencionBeanSwingJInternalFrame.jTtoolBarClienteRetencion.setBorder(borderResaltar);
		
		this.resaltarvalor_tipo_cambioClienteRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_tipo_cambioClienteRetencion() {
		return this.resaltarvalor_tipo_cambioClienteRetencion;
	}

	public void setResaltarvalor_tipo_cambioClienteRetencion(Border borderResaltar) {
		this.resaltarvalor_tipo_cambioClienteRetencion= borderResaltar;
	}

	public Boolean getMostrarvalor_tipo_cambioClienteRetencion() {
		return this.mostrarvalor_tipo_cambioClienteRetencion;
	}

	public void setMostrarvalor_tipo_cambioClienteRetencion(Boolean mostrarvalor_tipo_cambioClienteRetencion) {
		this.mostrarvalor_tipo_cambioClienteRetencion= mostrarvalor_tipo_cambioClienteRetencion;
	}

	public Boolean getActivarvalor_tipo_cambioClienteRetencion() {
		return this.activarvalor_tipo_cambioClienteRetencion;
	}

	public void setActivarvalor_tipo_cambioClienteRetencion(Boolean activarvalor_tipo_cambioClienteRetencion) {
		this.activarvalor_tipo_cambioClienteRetencion= activarvalor_tipo_cambioClienteRetencion;
	}

	public Border setResaltardebito_mone_localClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteretencionBeanSwingJInternalFrame.jTtoolBarClienteRetencion.setBorder(borderResaltar);
		
		this.resaltardebito_mone_localClienteRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebito_mone_localClienteRetencion() {
		return this.resaltardebito_mone_localClienteRetencion;
	}

	public void setResaltardebito_mone_localClienteRetencion(Border borderResaltar) {
		this.resaltardebito_mone_localClienteRetencion= borderResaltar;
	}

	public Boolean getMostrardebito_mone_localClienteRetencion() {
		return this.mostrardebito_mone_localClienteRetencion;
	}

	public void setMostrardebito_mone_localClienteRetencion(Boolean mostrardebito_mone_localClienteRetencion) {
		this.mostrardebito_mone_localClienteRetencion= mostrardebito_mone_localClienteRetencion;
	}

	public Boolean getActivardebito_mone_localClienteRetencion() {
		return this.activardebito_mone_localClienteRetencion;
	}

	public void setActivardebito_mone_localClienteRetencion(Boolean activardebito_mone_localClienteRetencion) {
		this.activardebito_mone_localClienteRetencion= activardebito_mone_localClienteRetencion;
	}

	public Border setResaltarcredito_mone_localClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteretencionBeanSwingJInternalFrame.jTtoolBarClienteRetencion.setBorder(borderResaltar);
		
		this.resaltarcredito_mone_localClienteRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_mone_localClienteRetencion() {
		return this.resaltarcredito_mone_localClienteRetencion;
	}

	public void setResaltarcredito_mone_localClienteRetencion(Border borderResaltar) {
		this.resaltarcredito_mone_localClienteRetencion= borderResaltar;
	}

	public Boolean getMostrarcredito_mone_localClienteRetencion() {
		return this.mostrarcredito_mone_localClienteRetencion;
	}

	public void setMostrarcredito_mone_localClienteRetencion(Boolean mostrarcredito_mone_localClienteRetencion) {
		this.mostrarcredito_mone_localClienteRetencion= mostrarcredito_mone_localClienteRetencion;
	}

	public Boolean getActivarcredito_mone_localClienteRetencion() {
		return this.activarcredito_mone_localClienteRetencion;
	}

	public void setActivarcredito_mone_localClienteRetencion(Boolean activarcredito_mone_localClienteRetencion) {
		this.activarcredito_mone_localClienteRetencion= activarcredito_mone_localClienteRetencion;
	}

	public Border setResaltardebito_mone_extraClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteretencionBeanSwingJInternalFrame.jTtoolBarClienteRetencion.setBorder(borderResaltar);
		
		this.resaltardebito_mone_extraClienteRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebito_mone_extraClienteRetencion() {
		return this.resaltardebito_mone_extraClienteRetencion;
	}

	public void setResaltardebito_mone_extraClienteRetencion(Border borderResaltar) {
		this.resaltardebito_mone_extraClienteRetencion= borderResaltar;
	}

	public Boolean getMostrardebito_mone_extraClienteRetencion() {
		return this.mostrardebito_mone_extraClienteRetencion;
	}

	public void setMostrardebito_mone_extraClienteRetencion(Boolean mostrardebito_mone_extraClienteRetencion) {
		this.mostrardebito_mone_extraClienteRetencion= mostrardebito_mone_extraClienteRetencion;
	}

	public Boolean getActivardebito_mone_extraClienteRetencion() {
		return this.activardebito_mone_extraClienteRetencion;
	}

	public void setActivardebito_mone_extraClienteRetencion(Boolean activardebito_mone_extraClienteRetencion) {
		this.activardebito_mone_extraClienteRetencion= activardebito_mone_extraClienteRetencion;
	}

	public Border setResaltarcredito_mone_extraClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteretencionBeanSwingJInternalFrame.jTtoolBarClienteRetencion.setBorder(borderResaltar);
		
		this.resaltarcredito_mone_extraClienteRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_mone_extraClienteRetencion() {
		return this.resaltarcredito_mone_extraClienteRetencion;
	}

	public void setResaltarcredito_mone_extraClienteRetencion(Border borderResaltar) {
		this.resaltarcredito_mone_extraClienteRetencion= borderResaltar;
	}

	public Boolean getMostrarcredito_mone_extraClienteRetencion() {
		return this.mostrarcredito_mone_extraClienteRetencion;
	}

	public void setMostrarcredito_mone_extraClienteRetencion(Boolean mostrarcredito_mone_extraClienteRetencion) {
		this.mostrarcredito_mone_extraClienteRetencion= mostrarcredito_mone_extraClienteRetencion;
	}

	public Boolean getActivarcredito_mone_extraClienteRetencion() {
		return this.activarcredito_mone_extraClienteRetencion;
	}

	public void setActivarcredito_mone_extraClienteRetencion(Boolean activarcredito_mone_extraClienteRetencion) {
		this.activarcredito_mone_extraClienteRetencion= activarcredito_mone_extraClienteRetencion;
	}

	public Border setResaltarbeneficiarioClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteretencionBeanSwingJInternalFrame.jTtoolBarClienteRetencion.setBorder(borderResaltar);
		
		this.resaltarbeneficiarioClienteRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbeneficiarioClienteRetencion() {
		return this.resaltarbeneficiarioClienteRetencion;
	}

	public void setResaltarbeneficiarioClienteRetencion(Border borderResaltar) {
		this.resaltarbeneficiarioClienteRetencion= borderResaltar;
	}

	public Boolean getMostrarbeneficiarioClienteRetencion() {
		return this.mostrarbeneficiarioClienteRetencion;
	}

	public void setMostrarbeneficiarioClienteRetencion(Boolean mostrarbeneficiarioClienteRetencion) {
		this.mostrarbeneficiarioClienteRetencion= mostrarbeneficiarioClienteRetencion;
	}

	public Boolean getActivarbeneficiarioClienteRetencion() {
		return this.activarbeneficiarioClienteRetencion;
	}

	public void setActivarbeneficiarioClienteRetencion(Boolean activarbeneficiarioClienteRetencion) {
		this.activarbeneficiarioClienteRetencion= activarbeneficiarioClienteRetencion;
	}

	public Border setResaltarnombre_benefClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteretencionBeanSwingJInternalFrame.jTtoolBarClienteRetencion.setBorder(borderResaltar);
		
		this.resaltarnombre_benefClienteRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_benefClienteRetencion() {
		return this.resaltarnombre_benefClienteRetencion;
	}

	public void setResaltarnombre_benefClienteRetencion(Border borderResaltar) {
		this.resaltarnombre_benefClienteRetencion= borderResaltar;
	}

	public Boolean getMostrarnombre_benefClienteRetencion() {
		return this.mostrarnombre_benefClienteRetencion;
	}

	public void setMostrarnombre_benefClienteRetencion(Boolean mostrarnombre_benefClienteRetencion) {
		this.mostrarnombre_benefClienteRetencion= mostrarnombre_benefClienteRetencion;
	}

	public Boolean getActivarnombre_benefClienteRetencion() {
		return this.activarnombre_benefClienteRetencion;
	}

	public void setActivarnombre_benefClienteRetencion(Boolean activarnombre_benefClienteRetencion) {
		this.activarnombre_benefClienteRetencion= activarnombre_benefClienteRetencion;
	}

	public Border setResaltardireccion_benefClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteretencionBeanSwingJInternalFrame.jTtoolBarClienteRetencion.setBorder(borderResaltar);
		
		this.resaltardireccion_benefClienteRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccion_benefClienteRetencion() {
		return this.resaltardireccion_benefClienteRetencion;
	}

	public void setResaltardireccion_benefClienteRetencion(Border borderResaltar) {
		this.resaltardireccion_benefClienteRetencion= borderResaltar;
	}

	public Boolean getMostrardireccion_benefClienteRetencion() {
		return this.mostrardireccion_benefClienteRetencion;
	}

	public void setMostrardireccion_benefClienteRetencion(Boolean mostrardireccion_benefClienteRetencion) {
		this.mostrardireccion_benefClienteRetencion= mostrardireccion_benefClienteRetencion;
	}

	public Boolean getActivardireccion_benefClienteRetencion() {
		return this.activardireccion_benefClienteRetencion;
	}

	public void setActivardireccion_benefClienteRetencion(Boolean activardireccion_benefClienteRetencion) {
		this.activardireccion_benefClienteRetencion= activardireccion_benefClienteRetencion;
	}

	public Border setResaltartelefono_benefClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteretencionBeanSwingJInternalFrame.jTtoolBarClienteRetencion.setBorder(borderResaltar);
		
		this.resaltartelefono_benefClienteRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefono_benefClienteRetencion() {
		return this.resaltartelefono_benefClienteRetencion;
	}

	public void setResaltartelefono_benefClienteRetencion(Border borderResaltar) {
		this.resaltartelefono_benefClienteRetencion= borderResaltar;
	}

	public Boolean getMostrartelefono_benefClienteRetencion() {
		return this.mostrartelefono_benefClienteRetencion;
	}

	public void setMostrartelefono_benefClienteRetencion(Boolean mostrartelefono_benefClienteRetencion) {
		this.mostrartelefono_benefClienteRetencion= mostrartelefono_benefClienteRetencion;
	}

	public Boolean getActivartelefono_benefClienteRetencion() {
		return this.activartelefono_benefClienteRetencion;
	}

	public void setActivartelefono_benefClienteRetencion(Boolean activartelefono_benefClienteRetencion) {
		this.activartelefono_benefClienteRetencion= activartelefono_benefClienteRetencion;
	}

	public Border setResaltarruc_benefClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteretencionBeanSwingJInternalFrame.jTtoolBarClienteRetencion.setBorder(borderResaltar);
		
		this.resaltarruc_benefClienteRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarruc_benefClienteRetencion() {
		return this.resaltarruc_benefClienteRetencion;
	}

	public void setResaltarruc_benefClienteRetencion(Border borderResaltar) {
		this.resaltarruc_benefClienteRetencion= borderResaltar;
	}

	public Boolean getMostrarruc_benefClienteRetencion() {
		return this.mostrarruc_benefClienteRetencion;
	}

	public void setMostrarruc_benefClienteRetencion(Boolean mostrarruc_benefClienteRetencion) {
		this.mostrarruc_benefClienteRetencion= mostrarruc_benefClienteRetencion;
	}

	public Boolean getActivarruc_benefClienteRetencion() {
		return this.activarruc_benefClienteRetencion;
	}

	public void setActivarruc_benefClienteRetencion(Boolean activarruc_benefClienteRetencion) {
		this.activarruc_benefClienteRetencion= activarruc_benefClienteRetencion;
	}

	public Border setResaltarid_estado_retencionClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteretencionBeanSwingJInternalFrame.jTtoolBarClienteRetencion.setBorder(borderResaltar);
		
		this.resaltarid_estado_retencionClienteRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_retencionClienteRetencion() {
		return this.resaltarid_estado_retencionClienteRetencion;
	}

	public void setResaltarid_estado_retencionClienteRetencion(Border borderResaltar) {
		this.resaltarid_estado_retencionClienteRetencion= borderResaltar;
	}

	public Boolean getMostrarid_estado_retencionClienteRetencion() {
		return this.mostrarid_estado_retencionClienteRetencion;
	}

	public void setMostrarid_estado_retencionClienteRetencion(Boolean mostrarid_estado_retencionClienteRetencion) {
		this.mostrarid_estado_retencionClienteRetencion= mostrarid_estado_retencionClienteRetencion;
	}

	public Boolean getActivarid_estado_retencionClienteRetencion() {
		return this.activarid_estado_retencionClienteRetencion;
	}

	public void setActivarid_estado_retencionClienteRetencion(Boolean activarid_estado_retencionClienteRetencion) {
		this.activarid_estado_retencionClienteRetencion= activarid_estado_retencionClienteRetencion;
	}

	public Boolean getCargarid_estado_retencionClienteRetencion() {
		return this.cargarid_estado_retencionClienteRetencion;
	}

	public void setCargarid_estado_retencionClienteRetencion(Boolean cargarid_estado_retencionClienteRetencion) {
		this.cargarid_estado_retencionClienteRetencion= cargarid_estado_retencionClienteRetencion;
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
		
		
		this.setMostraridClienteRetencion(esInicial);
		this.setMostrarid_empresaClienteRetencion(esInicial);
		this.setMostrarid_sucursalClienteRetencion(esInicial);
		this.setMostrarid_ejercicioClienteRetencion(esInicial);
		this.setMostrarid_periodoClienteRetencion(esInicial);
		this.setMostrarid_anioClienteRetencion(esInicial);
		this.setMostrarid_mesClienteRetencion(esInicial);
		this.setMostrarfechaClienteRetencion(esInicial);
		this.setMostrarid_clienteClienteRetencion(esInicial);
		this.setMostrarid_facturaClienteRetencion(esInicial);
		this.setMostrarid_transaccionClienteRetencion(esInicial);
		this.setMostrarid_tipo_retencionClienteRetencion(esInicial);
		this.setMostrarporcentajeClienteRetencion(esInicial);
		this.setMostrarbase_imponibleClienteRetencion(esInicial);
		this.setMostrarvalorClienteRetencion(esInicial);
		this.setMostrarnumero_retencionClienteRetencion(esInicial);
		this.setMostrardescripcionClienteRetencion(esInicial);
		this.setMostrarid_asiento_contableClienteRetencion(esInicial);
		this.setMostrarid_cuenta_contable_retencionClienteRetencion(esInicial);
		this.setMostrarvalor_tipo_cambioClienteRetencion(esInicial);
		this.setMostrardebito_mone_localClienteRetencion(esInicial);
		this.setMostrarcredito_mone_localClienteRetencion(esInicial);
		this.setMostrardebito_mone_extraClienteRetencion(esInicial);
		this.setMostrarcredito_mone_extraClienteRetencion(esInicial);
		this.setMostrarbeneficiarioClienteRetencion(esInicial);
		this.setMostrarnombre_benefClienteRetencion(esInicial);
		this.setMostrardireccion_benefClienteRetencion(esInicial);
		this.setMostrartelefono_benefClienteRetencion(esInicial);
		this.setMostrarruc_benefClienteRetencion(esInicial);
		this.setMostrarid_estado_retencionClienteRetencion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.ID)) {
				this.setMostraridClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDMES)) {
				this.setMostrarid_mesClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.FECHA)) {
				this.setMostrarfechaClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDFACTURA)) {
				this.setMostrarid_facturaClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDTRANSACCION)) {
				this.setMostrarid_transaccionClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDTIPORETENCION)) {
				this.setMostrarid_tipo_retencionClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.BASEIMPONIBLE)) {
				this.setMostrarbase_imponibleClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.VALOR)) {
				this.setMostrarvalorClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.NUMERORETENCION)) {
				this.setMostrarnumero_retencionClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setMostrarid_asiento_contableClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDCUENTACONTABLECLIENTERETENCION)) {
				this.setMostrarid_cuenta_contable_retencionClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.VALORTIPOCAMBIO)) {
				this.setMostrarvalor_tipo_cambioClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.DEBITOMONELOCAL)) {
				this.setMostrardebito_mone_localClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.CREDITOMONELOCAL)) {
				this.setMostrarcredito_mone_localClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.DEBITOMONEEXTRA)) {
				this.setMostrardebito_mone_extraClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.CREDITOMONEEXTRA)) {
				this.setMostrarcredito_mone_extraClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.BENEFICIARIO)) {
				this.setMostrarbeneficiarioClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.NOMBREBENEF)) {
				this.setMostrarnombre_benefClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.DIRECCIONBENEF)) {
				this.setMostrardireccion_benefClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.TELEFONOBENEF)) {
				this.setMostrartelefono_benefClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.RUCBENEF)) {
				this.setMostrarruc_benefClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDESTADORETENCION)) {
				this.setMostrarid_estado_retencionClienteRetencion(esAsigna);
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
		
		
		this.setActivaridClienteRetencion(esInicial);
		this.setActivarid_empresaClienteRetencion(esInicial);
		this.setActivarid_sucursalClienteRetencion(esInicial);
		this.setActivarid_ejercicioClienteRetencion(esInicial);
		this.setActivarid_periodoClienteRetencion(esInicial);
		this.setActivarid_anioClienteRetencion(esInicial);
		this.setActivarid_mesClienteRetencion(esInicial);
		this.setActivarfechaClienteRetencion(esInicial);
		this.setActivarid_clienteClienteRetencion(esInicial);
		this.setActivarid_facturaClienteRetencion(esInicial);
		this.setActivarid_transaccionClienteRetencion(esInicial);
		this.setActivarid_tipo_retencionClienteRetencion(esInicial);
		this.setActivarporcentajeClienteRetencion(esInicial);
		this.setActivarbase_imponibleClienteRetencion(esInicial);
		this.setActivarvalorClienteRetencion(esInicial);
		this.setActivarnumero_retencionClienteRetencion(esInicial);
		this.setActivardescripcionClienteRetencion(esInicial);
		this.setActivarid_asiento_contableClienteRetencion(esInicial);
		this.setActivarid_cuenta_contable_retencionClienteRetencion(esInicial);
		this.setActivarvalor_tipo_cambioClienteRetencion(esInicial);
		this.setActivardebito_mone_localClienteRetencion(esInicial);
		this.setActivarcredito_mone_localClienteRetencion(esInicial);
		this.setActivardebito_mone_extraClienteRetencion(esInicial);
		this.setActivarcredito_mone_extraClienteRetencion(esInicial);
		this.setActivarbeneficiarioClienteRetencion(esInicial);
		this.setActivarnombre_benefClienteRetencion(esInicial);
		this.setActivardireccion_benefClienteRetencion(esInicial);
		this.setActivartelefono_benefClienteRetencion(esInicial);
		this.setActivarruc_benefClienteRetencion(esInicial);
		this.setActivarid_estado_retencionClienteRetencion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.ID)) {
				this.setActivaridClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDANIO)) {
				this.setActivarid_anioClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDMES)) {
				this.setActivarid_mesClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.FECHA)) {
				this.setActivarfechaClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDFACTURA)) {
				this.setActivarid_facturaClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDTRANSACCION)) {
				this.setActivarid_transaccionClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDTIPORETENCION)) {
				this.setActivarid_tipo_retencionClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.BASEIMPONIBLE)) {
				this.setActivarbase_imponibleClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.VALOR)) {
				this.setActivarvalorClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.NUMERORETENCION)) {
				this.setActivarnumero_retencionClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setActivarid_asiento_contableClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDCUENTACONTABLECLIENTERETENCION)) {
				this.setActivarid_cuenta_contable_retencionClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.VALORTIPOCAMBIO)) {
				this.setActivarvalor_tipo_cambioClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.DEBITOMONELOCAL)) {
				this.setActivardebito_mone_localClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.CREDITOMONELOCAL)) {
				this.setActivarcredito_mone_localClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.DEBITOMONEEXTRA)) {
				this.setActivardebito_mone_extraClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.CREDITOMONEEXTRA)) {
				this.setActivarcredito_mone_extraClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.BENEFICIARIO)) {
				this.setActivarbeneficiarioClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.NOMBREBENEF)) {
				this.setActivarnombre_benefClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.DIRECCIONBENEF)) {
				this.setActivardireccion_benefClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.TELEFONOBENEF)) {
				this.setActivartelefono_benefClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.RUCBENEF)) {
				this.setActivarruc_benefClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDESTADORETENCION)) {
				this.setActivarid_estado_retencionClienteRetencion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridClienteRetencion(esInicial);
		this.setResaltarid_empresaClienteRetencion(esInicial);
		this.setResaltarid_sucursalClienteRetencion(esInicial);
		this.setResaltarid_ejercicioClienteRetencion(esInicial);
		this.setResaltarid_periodoClienteRetencion(esInicial);
		this.setResaltarid_anioClienteRetencion(esInicial);
		this.setResaltarid_mesClienteRetencion(esInicial);
		this.setResaltarfechaClienteRetencion(esInicial);
		this.setResaltarid_clienteClienteRetencion(esInicial);
		this.setResaltarid_facturaClienteRetencion(esInicial);
		this.setResaltarid_transaccionClienteRetencion(esInicial);
		this.setResaltarid_tipo_retencionClienteRetencion(esInicial);
		this.setResaltarporcentajeClienteRetencion(esInicial);
		this.setResaltarbase_imponibleClienteRetencion(esInicial);
		this.setResaltarvalorClienteRetencion(esInicial);
		this.setResaltarnumero_retencionClienteRetencion(esInicial);
		this.setResaltardescripcionClienteRetencion(esInicial);
		this.setResaltarid_asiento_contableClienteRetencion(esInicial);
		this.setResaltarid_cuenta_contable_retencionClienteRetencion(esInicial);
		this.setResaltarvalor_tipo_cambioClienteRetencion(esInicial);
		this.setResaltardebito_mone_localClienteRetencion(esInicial);
		this.setResaltarcredito_mone_localClienteRetencion(esInicial);
		this.setResaltardebito_mone_extraClienteRetencion(esInicial);
		this.setResaltarcredito_mone_extraClienteRetencion(esInicial);
		this.setResaltarbeneficiarioClienteRetencion(esInicial);
		this.setResaltarnombre_benefClienteRetencion(esInicial);
		this.setResaltardireccion_benefClienteRetencion(esInicial);
		this.setResaltartelefono_benefClienteRetencion(esInicial);
		this.setResaltarruc_benefClienteRetencion(esInicial);
		this.setResaltarid_estado_retencionClienteRetencion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.ID)) {
				this.setResaltaridClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDMES)) {
				this.setResaltarid_mesClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.FECHA)) {
				this.setResaltarfechaClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDFACTURA)) {
				this.setResaltarid_facturaClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDTRANSACCION)) {
				this.setResaltarid_transaccionClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDTIPORETENCION)) {
				this.setResaltarid_tipo_retencionClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.BASEIMPONIBLE)) {
				this.setResaltarbase_imponibleClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.VALOR)) {
				this.setResaltarvalorClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.NUMERORETENCION)) {
				this.setResaltarnumero_retencionClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setResaltarid_asiento_contableClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDCUENTACONTABLECLIENTERETENCION)) {
				this.setResaltarid_cuenta_contable_retencionClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.VALORTIPOCAMBIO)) {
				this.setResaltarvalor_tipo_cambioClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.DEBITOMONELOCAL)) {
				this.setResaltardebito_mone_localClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.CREDITOMONELOCAL)) {
				this.setResaltarcredito_mone_localClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.DEBITOMONEEXTRA)) {
				this.setResaltardebito_mone_extraClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.CREDITOMONEEXTRA)) {
				this.setResaltarcredito_mone_extraClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.BENEFICIARIO)) {
				this.setResaltarbeneficiarioClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.NOMBREBENEF)) {
				this.setResaltarnombre_benefClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.DIRECCIONBENEF)) {
				this.setResaltardireccion_benefClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.TELEFONOBENEF)) {
				this.setResaltartelefono_benefClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.RUCBENEF)) {
				this.setResaltarruc_benefClienteRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteRetencionConstantesFunciones.IDESTADORETENCION)) {
				this.setResaltarid_estado_retencionClienteRetencion(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdAsientoContableClienteRetencion=true;

	public Boolean getMostrarFK_IdAsientoContableClienteRetencion() {
		return this.mostrarFK_IdAsientoContableClienteRetencion;
	}

	public void setMostrarFK_IdAsientoContableClienteRetencion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAsientoContableClienteRetencion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteClienteRetencion=true;

	public Boolean getMostrarFK_IdClienteClienteRetencion() {
		return this.mostrarFK_IdClienteClienteRetencion;
	}

	public void setMostrarFK_IdClienteClienteRetencion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteClienteRetencion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableClienteRetencionClienteRetencion=true;

	public Boolean getMostrarFK_IdCuentaContableClienteRetencionClienteRetencion() {
		return this.mostrarFK_IdCuentaContableClienteRetencionClienteRetencion;
	}

	public void setMostrarFK_IdCuentaContableClienteRetencionClienteRetencion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableClienteRetencionClienteRetencion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioClienteRetencion=true;

	public Boolean getMostrarFK_IdEjercicioClienteRetencion() {
		return this.mostrarFK_IdEjercicioClienteRetencion;
	}

	public void setMostrarFK_IdEjercicioClienteRetencion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioClienteRetencion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaClienteRetencion=true;

	public Boolean getMostrarFK_IdEmpresaClienteRetencion() {
		return this.mostrarFK_IdEmpresaClienteRetencion;
	}

	public void setMostrarFK_IdEmpresaClienteRetencion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaClienteRetencion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoRetencionClienteRetencion=true;

	public Boolean getMostrarFK_IdEstadoRetencionClienteRetencion() {
		return this.mostrarFK_IdEstadoRetencionClienteRetencion;
	}

	public void setMostrarFK_IdEstadoRetencionClienteRetencion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoRetencionClienteRetencion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFacturaClienteRetencion=true;

	public Boolean getMostrarFK_IdFacturaClienteRetencion() {
		return this.mostrarFK_IdFacturaClienteRetencion;
	}

	public void setMostrarFK_IdFacturaClienteRetencion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFacturaClienteRetencion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoClienteRetencion=true;

	public Boolean getMostrarFK_IdPeriodoClienteRetencion() {
		return this.mostrarFK_IdPeriodoClienteRetencion;
	}

	public void setMostrarFK_IdPeriodoClienteRetencion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoClienteRetencion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalClienteRetencion=true;

	public Boolean getMostrarFK_IdSucursalClienteRetencion() {
		return this.mostrarFK_IdSucursalClienteRetencion;
	}

	public void setMostrarFK_IdSucursalClienteRetencion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalClienteRetencion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoRetencionClienteRetencion=true;

	public Boolean getMostrarFK_IdTipoRetencionClienteRetencion() {
		return this.mostrarFK_IdTipoRetencionClienteRetencion;
	}

	public void setMostrarFK_IdTipoRetencionClienteRetencion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoRetencionClienteRetencion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionClienteRetencion=true;

	public Boolean getMostrarFK_IdTransaccionClienteRetencion() {
		return this.mostrarFK_IdTransaccionClienteRetencion;
	}

	public void setMostrarFK_IdTransaccionClienteRetencion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionClienteRetencion= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAsientoContableClienteRetencion=true;

	public Boolean getActivarFK_IdAsientoContableClienteRetencion() {
		return this.activarFK_IdAsientoContableClienteRetencion;
	}

	public void setActivarFK_IdAsientoContableClienteRetencion(Boolean habilitarResaltar) {
		this.activarFK_IdAsientoContableClienteRetencion= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteClienteRetencion=true;

	public Boolean getActivarFK_IdClienteClienteRetencion() {
		return this.activarFK_IdClienteClienteRetencion;
	}

	public void setActivarFK_IdClienteClienteRetencion(Boolean habilitarResaltar) {
		this.activarFK_IdClienteClienteRetencion= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableClienteRetencionClienteRetencion=true;

	public Boolean getActivarFK_IdCuentaContableClienteRetencionClienteRetencion() {
		return this.activarFK_IdCuentaContableClienteRetencionClienteRetencion;
	}

	public void setActivarFK_IdCuentaContableClienteRetencionClienteRetencion(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableClienteRetencionClienteRetencion= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioClienteRetencion=true;

	public Boolean getActivarFK_IdEjercicioClienteRetencion() {
		return this.activarFK_IdEjercicioClienteRetencion;
	}

	public void setActivarFK_IdEjercicioClienteRetencion(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioClienteRetencion= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaClienteRetencion=true;

	public Boolean getActivarFK_IdEmpresaClienteRetencion() {
		return this.activarFK_IdEmpresaClienteRetencion;
	}

	public void setActivarFK_IdEmpresaClienteRetencion(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaClienteRetencion= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoRetencionClienteRetencion=true;

	public Boolean getActivarFK_IdEstadoRetencionClienteRetencion() {
		return this.activarFK_IdEstadoRetencionClienteRetencion;
	}

	public void setActivarFK_IdEstadoRetencionClienteRetencion(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoRetencionClienteRetencion= habilitarResaltar;
	}

	public Boolean activarFK_IdFacturaClienteRetencion=true;

	public Boolean getActivarFK_IdFacturaClienteRetencion() {
		return this.activarFK_IdFacturaClienteRetencion;
	}

	public void setActivarFK_IdFacturaClienteRetencion(Boolean habilitarResaltar) {
		this.activarFK_IdFacturaClienteRetencion= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoClienteRetencion=true;

	public Boolean getActivarFK_IdPeriodoClienteRetencion() {
		return this.activarFK_IdPeriodoClienteRetencion;
	}

	public void setActivarFK_IdPeriodoClienteRetencion(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoClienteRetencion= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalClienteRetencion=true;

	public Boolean getActivarFK_IdSucursalClienteRetencion() {
		return this.activarFK_IdSucursalClienteRetencion;
	}

	public void setActivarFK_IdSucursalClienteRetencion(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalClienteRetencion= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoRetencionClienteRetencion=true;

	public Boolean getActivarFK_IdTipoRetencionClienteRetencion() {
		return this.activarFK_IdTipoRetencionClienteRetencion;
	}

	public void setActivarFK_IdTipoRetencionClienteRetencion(Boolean habilitarResaltar) {
		this.activarFK_IdTipoRetencionClienteRetencion= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionClienteRetencion=true;

	public Boolean getActivarFK_IdTransaccionClienteRetencion() {
		return this.activarFK_IdTransaccionClienteRetencion;
	}

	public void setActivarFK_IdTransaccionClienteRetencion(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionClienteRetencion= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAsientoContableClienteRetencion=null;

	public Border getResaltarFK_IdAsientoContableClienteRetencion() {
		return this.resaltarFK_IdAsientoContableClienteRetencion;
	}

	public void setResaltarFK_IdAsientoContableClienteRetencion(Border borderResaltar) {
		this.resaltarFK_IdAsientoContableClienteRetencion= borderResaltar;
	}

	public void setResaltarFK_IdAsientoContableClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAsientoContableClienteRetencion= borderResaltar;
	}

	public Border resaltarFK_IdClienteClienteRetencion=null;

	public Border getResaltarFK_IdClienteClienteRetencion() {
		return this.resaltarFK_IdClienteClienteRetencion;
	}

	public void setResaltarFK_IdClienteClienteRetencion(Border borderResaltar) {
		this.resaltarFK_IdClienteClienteRetencion= borderResaltar;
	}

	public void setResaltarFK_IdClienteClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteClienteRetencion= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableClienteRetencionClienteRetencion=null;

	public Border getResaltarFK_IdCuentaContableClienteRetencionClienteRetencion() {
		return this.resaltarFK_IdCuentaContableClienteRetencionClienteRetencion;
	}

	public void setResaltarFK_IdCuentaContableClienteRetencionClienteRetencion(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableClienteRetencionClienteRetencion= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableClienteRetencionClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableClienteRetencionClienteRetencion= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioClienteRetencion=null;

	public Border getResaltarFK_IdEjercicioClienteRetencion() {
		return this.resaltarFK_IdEjercicioClienteRetencion;
	}

	public void setResaltarFK_IdEjercicioClienteRetencion(Border borderResaltar) {
		this.resaltarFK_IdEjercicioClienteRetencion= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioClienteRetencion= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaClienteRetencion=null;

	public Border getResaltarFK_IdEmpresaClienteRetencion() {
		return this.resaltarFK_IdEmpresaClienteRetencion;
	}

	public void setResaltarFK_IdEmpresaClienteRetencion(Border borderResaltar) {
		this.resaltarFK_IdEmpresaClienteRetencion= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaClienteRetencion= borderResaltar;
	}

	public Border resaltarFK_IdEstadoRetencionClienteRetencion=null;

	public Border getResaltarFK_IdEstadoRetencionClienteRetencion() {
		return this.resaltarFK_IdEstadoRetencionClienteRetencion;
	}

	public void setResaltarFK_IdEstadoRetencionClienteRetencion(Border borderResaltar) {
		this.resaltarFK_IdEstadoRetencionClienteRetencion= borderResaltar;
	}

	public void setResaltarFK_IdEstadoRetencionClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoRetencionClienteRetencion= borderResaltar;
	}

	public Border resaltarFK_IdFacturaClienteRetencion=null;

	public Border getResaltarFK_IdFacturaClienteRetencion() {
		return this.resaltarFK_IdFacturaClienteRetencion;
	}

	public void setResaltarFK_IdFacturaClienteRetencion(Border borderResaltar) {
		this.resaltarFK_IdFacturaClienteRetencion= borderResaltar;
	}

	public void setResaltarFK_IdFacturaClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFacturaClienteRetencion= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoClienteRetencion=null;

	public Border getResaltarFK_IdPeriodoClienteRetencion() {
		return this.resaltarFK_IdPeriodoClienteRetencion;
	}

	public void setResaltarFK_IdPeriodoClienteRetencion(Border borderResaltar) {
		this.resaltarFK_IdPeriodoClienteRetencion= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoClienteRetencion= borderResaltar;
	}

	public Border resaltarFK_IdSucursalClienteRetencion=null;

	public Border getResaltarFK_IdSucursalClienteRetencion() {
		return this.resaltarFK_IdSucursalClienteRetencion;
	}

	public void setResaltarFK_IdSucursalClienteRetencion(Border borderResaltar) {
		this.resaltarFK_IdSucursalClienteRetencion= borderResaltar;
	}

	public void setResaltarFK_IdSucursalClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalClienteRetencion= borderResaltar;
	}

	public Border resaltarFK_IdTipoRetencionClienteRetencion=null;

	public Border getResaltarFK_IdTipoRetencionClienteRetencion() {
		return this.resaltarFK_IdTipoRetencionClienteRetencion;
	}

	public void setResaltarFK_IdTipoRetencionClienteRetencion(Border borderResaltar) {
		this.resaltarFK_IdTipoRetencionClienteRetencion= borderResaltar;
	}

	public void setResaltarFK_IdTipoRetencionClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoRetencionClienteRetencion= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionClienteRetencion=null;

	public Border getResaltarFK_IdTransaccionClienteRetencion() {
		return this.resaltarFK_IdTransaccionClienteRetencion;
	}

	public void setResaltarFK_IdTransaccionClienteRetencion(Border borderResaltar) {
		this.resaltarFK_IdTransaccionClienteRetencion= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionClienteRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteRetencionBeanSwingJInternalFrame clienteretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionClienteRetencion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}