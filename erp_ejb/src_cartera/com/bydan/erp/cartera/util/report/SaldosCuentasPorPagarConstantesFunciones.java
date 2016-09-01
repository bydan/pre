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
package com.bydan.erp.cartera.util.report;

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

import com.bydan.erp.cartera.resources.general.AuxiliarGeneral;

import com.bydan.erp.cartera.util.report.SaldosCuentasPorPagarConstantesFunciones;
import com.bydan.erp.cartera.util.report.SaldosCuentasPorPagarParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.SaldosCuentasPorPagarParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class SaldosCuentasPorPagarConstantesFunciones{		
	
	
	
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
	
	
	public static final String SFINALQUERY="";	
	public static final String SNOMBREOPCION="SaldosCuentasPorPagar";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="SaldosCuentasPorPagar"+SaldosCuentasPorPagarConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="SaldosCuentasPorPagarHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="SaldosCuentasPorPagarHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=SaldosCuentasPorPagarConstantesFunciones.SCHEMA+"_"+SaldosCuentasPorPagarConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/SaldosCuentasPorPagarHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=SaldosCuentasPorPagarConstantesFunciones.SCHEMA+"_"+SaldosCuentasPorPagarConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=SaldosCuentasPorPagarConstantesFunciones.SCHEMA+"_"+SaldosCuentasPorPagarConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/SaldosCuentasPorPagarHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=SaldosCuentasPorPagarConstantesFunciones.SCHEMA+"_"+SaldosCuentasPorPagarConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SaldosCuentasPorPagarConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SaldosCuentasPorPagarHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SaldosCuentasPorPagarConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SaldosCuentasPorPagarConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SaldosCuentasPorPagarHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SaldosCuentasPorPagarConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=SaldosCuentasPorPagarConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+SaldosCuentasPorPagarConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=SaldosCuentasPorPagarConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+SaldosCuentasPorPagarConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Saldos Cuentas Por Pagares";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Saldos Cuentas Por Pagar";
	public static final String SCLASSWEBTITULO_LOWER="Saldos Cuentas Por Pagar";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="SaldosCuentasPorPagar";
	public static final String OBJECTNAME="saldoscuentasporpagar";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NINGUNO;	
	public static final String TABLENAME="saldos_cuentas_por_pagar";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select saldoscuentasporpagar from "+SaldosCuentasPorPagarConstantesFunciones.SPERSISTENCENAME+" saldoscuentasporpagar";
	public static String QUERYSELECTNATIVE="select "+SaldosCuentasPorPagarConstantesFunciones.SCHEMA+"."+SaldosCuentasPorPagarConstantesFunciones.TABLENAME+".id,"+SaldosCuentasPorPagarConstantesFunciones.SCHEMA+"."+SaldosCuentasPorPagarConstantesFunciones.TABLENAME+".version_row,"+SaldosCuentasPorPagarConstantesFunciones.SCHEMA+"."+SaldosCuentasPorPagarConstantesFunciones.TABLENAME+".id_zona,"+SaldosCuentasPorPagarConstantesFunciones.SCHEMA+"."+SaldosCuentasPorPagarConstantesFunciones.TABLENAME+".id_grupo_cliente,"+SaldosCuentasPorPagarConstantesFunciones.SCHEMA+"."+SaldosCuentasPorPagarConstantesFunciones.TABLENAME+".id_empresa,"+SaldosCuentasPorPagarConstantesFunciones.SCHEMA+"."+SaldosCuentasPorPagarConstantesFunciones.TABLENAME+".id_sucursal,"+SaldosCuentasPorPagarConstantesFunciones.SCHEMA+"."+SaldosCuentasPorPagarConstantesFunciones.TABLENAME+".id_cliente,"+SaldosCuentasPorPagarConstantesFunciones.SCHEMA+"."+SaldosCuentasPorPagarConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+SaldosCuentasPorPagarConstantesFunciones.SCHEMA+"."+SaldosCuentasPorPagarConstantesFunciones.TABLENAME+".codigo,"+SaldosCuentasPorPagarConstantesFunciones.SCHEMA+"."+SaldosCuentasPorPagarConstantesFunciones.TABLENAME+".nombre_completo,"+SaldosCuentasPorPagarConstantesFunciones.SCHEMA+"."+SaldosCuentasPorPagarConstantesFunciones.TABLENAME+".debito_mone_local,"+SaldosCuentasPorPagarConstantesFunciones.SCHEMA+"."+SaldosCuentasPorPagarConstantesFunciones.TABLENAME+".credito_mone_local,"+SaldosCuentasPorPagarConstantesFunciones.SCHEMA+"."+SaldosCuentasPorPagarConstantesFunciones.TABLENAME+".saldo_anterior,"+SaldosCuentasPorPagarConstantesFunciones.SCHEMA+"."+SaldosCuentasPorPagarConstantesFunciones.TABLENAME+".saldo_debito,"+SaldosCuentasPorPagarConstantesFunciones.SCHEMA+"."+SaldosCuentasPorPagarConstantesFunciones.TABLENAME+".saldo_credito from "+SaldosCuentasPorPagarConstantesFunciones.SCHEMA+"."+SaldosCuentasPorPagarConstantesFunciones.TABLENAME;//+" as "+SaldosCuentasPorPagarConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDZONA= "id_zona";
    public static final String IDGRUPOCLIENTE= "id_grupo_cliente";
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDCLIENTE= "id_cliente";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String CODIGO= "codigo";
    public static final String NOMBRECOMPLETO= "nombre_completo";
    public static final String DEBITOMONELOCAL= "debito_mone_local";
    public static final String CREDITOMONELOCAL= "credito_mone_local";
    public static final String SALDOANTERIOR= "saldo_anterior";
    public static final String SALDODEBITO= "saldo_debito";
    public static final String SALDOCREDITO= "saldo_credito";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDZONA= "Zona";
		public static final String LABEL_IDZONA_LOWER= "Zona";
    	public static final String LABEL_IDGRUPOCLIENTE= "Grupo Cliente";
		public static final String LABEL_IDGRUPOCLIENTE_LOWER= "Grupo Cliente";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRECOMPLETO= "Nombre Completo";
		public static final String LABEL_NOMBRECOMPLETO_LOWER= "Nombre Completo";
    	public static final String LABEL_DEBITOMONELOCAL= "Debito Mone Local";
		public static final String LABEL_DEBITOMONELOCAL_LOWER= "Debito Mone Local";
    	public static final String LABEL_CREDITOMONELOCAL= "Credito Mone Local";
		public static final String LABEL_CREDITOMONELOCAL_LOWER= "Credito Mone Local";
    	public static final String LABEL_SALDOANTERIOR= "Saldo Anterior";
		public static final String LABEL_SALDOANTERIOR_LOWER= "Saldo Anterior";
    	public static final String LABEL_SALDODEBITO= "Saldo Debito";
		public static final String LABEL_SALDODEBITO_LOWER= "Saldo Debito";
    	public static final String LABEL_SALDOCREDITO= "Saldo Credito";
		public static final String LABEL_SALDOCREDITO_LOWER= "Saldo Credito";
	
		
		
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_COMPLETO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	
	public static String getSaldosCuentasPorPagarLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(SaldosCuentasPorPagarConstantesFunciones.IDZONA)) {sLabelColumna=SaldosCuentasPorPagarConstantesFunciones.LABEL_IDZONA;}
		if(sNombreColumna.equals(SaldosCuentasPorPagarConstantesFunciones.IDGRUPOCLIENTE)) {sLabelColumna=SaldosCuentasPorPagarConstantesFunciones.LABEL_IDGRUPOCLIENTE;}
		if(sNombreColumna.equals(SaldosCuentasPorPagarConstantesFunciones.IDEMPRESA)) {sLabelColumna=SaldosCuentasPorPagarConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(SaldosCuentasPorPagarConstantesFunciones.IDSUCURSAL)) {sLabelColumna=SaldosCuentasPorPagarConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(SaldosCuentasPorPagarConstantesFunciones.IDCLIENTE)) {sLabelColumna=SaldosCuentasPorPagarConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(SaldosCuentasPorPagarConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=SaldosCuentasPorPagarConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(SaldosCuentasPorPagarConstantesFunciones.CODIGO)) {sLabelColumna=SaldosCuentasPorPagarConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(SaldosCuentasPorPagarConstantesFunciones.NOMBRECOMPLETO)) {sLabelColumna=SaldosCuentasPorPagarConstantesFunciones.LABEL_NOMBRECOMPLETO;}
		if(sNombreColumna.equals(SaldosCuentasPorPagarConstantesFunciones.DEBITOMONELOCAL)) {sLabelColumna=SaldosCuentasPorPagarConstantesFunciones.LABEL_DEBITOMONELOCAL;}
		if(sNombreColumna.equals(SaldosCuentasPorPagarConstantesFunciones.CREDITOMONELOCAL)) {sLabelColumna=SaldosCuentasPorPagarConstantesFunciones.LABEL_CREDITOMONELOCAL;}
		if(sNombreColumna.equals(SaldosCuentasPorPagarConstantesFunciones.SALDOANTERIOR)) {sLabelColumna=SaldosCuentasPorPagarConstantesFunciones.LABEL_SALDOANTERIOR;}
		if(sNombreColumna.equals(SaldosCuentasPorPagarConstantesFunciones.SALDODEBITO)) {sLabelColumna=SaldosCuentasPorPagarConstantesFunciones.LABEL_SALDODEBITO;}
		if(sNombreColumna.equals(SaldosCuentasPorPagarConstantesFunciones.SALDOCREDITO)) {sLabelColumna=SaldosCuentasPorPagarConstantesFunciones.LABEL_SALDOCREDITO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getSaldosCuentasPorPagarDescripcion(SaldosCuentasPorPagar saldoscuentasporpagar) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(saldoscuentasporpagar !=null/* && saldoscuentasporpagar.getId()!=0*/) {
			sDescripcion=saldoscuentasporpagar.getcodigo();//saldoscuentasporpagarsaldoscuentasporpagar.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getSaldosCuentasPorPagarDescripcionDetallado(SaldosCuentasPorPagar saldoscuentasporpagar) {
		String sDescripcion="";
			
		sDescripcion+=SaldosCuentasPorPagarConstantesFunciones.ID+"=";
		sDescripcion+=saldoscuentasporpagar.getId().toString()+",";
		sDescripcion+=SaldosCuentasPorPagarConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=saldoscuentasporpagar.getVersionRow().toString()+",";
		sDescripcion+=SaldosCuentasPorPagarConstantesFunciones.IDZONA+"=";
		sDescripcion+=saldoscuentasporpagar.getid_zona().toString()+",";
		sDescripcion+=SaldosCuentasPorPagarConstantesFunciones.IDGRUPOCLIENTE+"=";
		sDescripcion+=saldoscuentasporpagar.getid_grupo_cliente().toString()+",";
		sDescripcion+=SaldosCuentasPorPagarConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=saldoscuentasporpagar.getid_empresa().toString()+",";
		sDescripcion+=SaldosCuentasPorPagarConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=saldoscuentasporpagar.getid_sucursal().toString()+",";
		sDescripcion+=SaldosCuentasPorPagarConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=saldoscuentasporpagar.getid_cliente().toString()+",";
		sDescripcion+=SaldosCuentasPorPagarConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=saldoscuentasporpagar.getfecha_emision_hasta().toString()+",";
		sDescripcion+=SaldosCuentasPorPagarConstantesFunciones.CODIGO+"=";
		sDescripcion+=saldoscuentasporpagar.getcodigo()+",";
		sDescripcion+=SaldosCuentasPorPagarConstantesFunciones.NOMBRECOMPLETO+"=";
		sDescripcion+=saldoscuentasporpagar.getnombre_completo()+",";
		sDescripcion+=SaldosCuentasPorPagarConstantesFunciones.DEBITOMONELOCAL+"=";
		sDescripcion+=saldoscuentasporpagar.getdebito_mone_local().toString()+",";
		sDescripcion+=SaldosCuentasPorPagarConstantesFunciones.CREDITOMONELOCAL+"=";
		sDescripcion+=saldoscuentasporpagar.getcredito_mone_local().toString()+",";
		sDescripcion+=SaldosCuentasPorPagarConstantesFunciones.SALDOANTERIOR+"=";
		sDescripcion+=saldoscuentasporpagar.getsaldo_anterior().toString()+",";
		sDescripcion+=SaldosCuentasPorPagarConstantesFunciones.SALDODEBITO+"=";
		sDescripcion+=saldoscuentasporpagar.getsaldo_debito().toString()+",";
		sDescripcion+=SaldosCuentasPorPagarConstantesFunciones.SALDOCREDITO+"=";
		sDescripcion+=saldoscuentasporpagar.getsaldo_credito().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setSaldosCuentasPorPagarDescripcion(SaldosCuentasPorPagar saldoscuentasporpagar,String sValor) throws Exception {			
		if(saldoscuentasporpagar !=null) {
			saldoscuentasporpagar.setcodigo(sValor);;//saldoscuentasporpagarsaldoscuentasporpagar.getcodigo().trim();
		}		
	}
	
		

	public static String getZonaDescripcion(Zona zona) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(zona!=null/*&&zona.getId()>0*/) {
			sDescripcion=ZonaConstantesFunciones.getZonaDescripcion(zona);
		}

		return sDescripcion;
	}

	public static String getGrupoClienteDescripcion(GrupoCliente grupocliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(grupocliente!=null/*&&grupocliente.getId()>0*/) {
			sDescripcion=GrupoClienteConstantesFunciones.getGrupoClienteDescripcion(grupocliente);
		}

		return sDescripcion;
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaSaldosCuentasPorPagar")) {
			sNombreIndice="Tipo=  Por Zona Por Grupo Cliente Por Cliente Por Fecha Emision Hasta";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdGrupoCliente")) {
			sNombreIndice="Tipo=  Por Grupo Cliente";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdZona")) {
			sNombreIndice="Tipo=  Por Zona";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaSaldosCuentasPorPagar(Long id_zona,Long id_grupo_cliente,Long id_cliente,Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_zona!=null) {sDetalleIndice+=" Codigo Unico De Zona="+id_zona.toString();}
		if(id_grupo_cliente!=null) {sDetalleIndice+=" Codigo Unico De Grupo Cliente="+id_grupo_cliente.toString();}
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();}
		if(fecha_emision_hasta!=null) {sDetalleIndice+=" Fecha Emision Hasta="+fecha_emision_hasta.toString();} 

		return sDetalleIndice;
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

	public static String getDetalleIndiceFK_IdGrupoCliente(Long id_grupo_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_grupo_cliente!=null) {sDetalleIndice+=" Codigo Unico De Grupo Cliente="+id_grupo_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdZona(Long id_zona) {
		String sDetalleIndice=" Parametros->";
		if(id_zona!=null) {sDetalleIndice+=" Codigo Unico De Zona="+id_zona.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosSaldosCuentasPorPagar(SaldosCuentasPorPagar saldoscuentasporpagar,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		saldoscuentasporpagar.setcodigo(saldoscuentasporpagar.getcodigo().trim());
		saldoscuentasporpagar.setnombre_completo(saldoscuentasporpagar.getnombre_completo().trim());
	}
	
	public static void quitarEspaciosSaldosCuentasPorPagars(List<SaldosCuentasPorPagar> saldoscuentasporpagars,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(SaldosCuentasPorPagar saldoscuentasporpagar: saldoscuentasporpagars) {
			saldoscuentasporpagar.setcodigo(saldoscuentasporpagar.getcodigo().trim());
			saldoscuentasporpagar.setnombre_completo(saldoscuentasporpagar.getnombre_completo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSaldosCuentasPorPagar(SaldosCuentasPorPagar saldoscuentasporpagar,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && saldoscuentasporpagar.getConCambioAuxiliar()) {
			saldoscuentasporpagar.setIsDeleted(saldoscuentasporpagar.getIsDeletedAuxiliar());	
			saldoscuentasporpagar.setIsNew(saldoscuentasporpagar.getIsNewAuxiliar());	
			saldoscuentasporpagar.setIsChanged(saldoscuentasporpagar.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			saldoscuentasporpagar.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			saldoscuentasporpagar.setIsDeletedAuxiliar(false);	
			saldoscuentasporpagar.setIsNewAuxiliar(false);	
			saldoscuentasporpagar.setIsChangedAuxiliar(false);
			
			saldoscuentasporpagar.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSaldosCuentasPorPagars(List<SaldosCuentasPorPagar> saldoscuentasporpagars,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(SaldosCuentasPorPagar saldoscuentasporpagar : saldoscuentasporpagars) {
			if(conAsignarBase && saldoscuentasporpagar.getConCambioAuxiliar()) {
				saldoscuentasporpagar.setIsDeleted(saldoscuentasporpagar.getIsDeletedAuxiliar());	
				saldoscuentasporpagar.setIsNew(saldoscuentasporpagar.getIsNewAuxiliar());	
				saldoscuentasporpagar.setIsChanged(saldoscuentasporpagar.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				saldoscuentasporpagar.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				saldoscuentasporpagar.setIsDeletedAuxiliar(false);	
				saldoscuentasporpagar.setIsNewAuxiliar(false);	
				saldoscuentasporpagar.setIsChangedAuxiliar(false);
				
				saldoscuentasporpagar.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresSaldosCuentasPorPagar(SaldosCuentasPorPagar saldoscuentasporpagar,Boolean conEnteros) throws Exception  {
		saldoscuentasporpagar.setdebito_mone_local(0.0);
		saldoscuentasporpagar.setcredito_mone_local(0.0);
		saldoscuentasporpagar.setsaldo_anterior(0.0);
		saldoscuentasporpagar.setsaldo_debito(0.0);
		saldoscuentasporpagar.setsaldo_credito(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresSaldosCuentasPorPagars(List<SaldosCuentasPorPagar> saldoscuentasporpagars,Boolean conEnteros) throws Exception  {
		
		for(SaldosCuentasPorPagar saldoscuentasporpagar: saldoscuentasporpagars) {
			saldoscuentasporpagar.setdebito_mone_local(0.0);
			saldoscuentasporpagar.setcredito_mone_local(0.0);
			saldoscuentasporpagar.setsaldo_anterior(0.0);
			saldoscuentasporpagar.setsaldo_debito(0.0);
			saldoscuentasporpagar.setsaldo_credito(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaSaldosCuentasPorPagar(List<SaldosCuentasPorPagar> saldoscuentasporpagars,SaldosCuentasPorPagar saldoscuentasporpagarAux) throws Exception  {
		SaldosCuentasPorPagarConstantesFunciones.InicializarValoresSaldosCuentasPorPagar(saldoscuentasporpagarAux,true);
		
		for(SaldosCuentasPorPagar saldoscuentasporpagar: saldoscuentasporpagars) {
			if(saldoscuentasporpagar.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			saldoscuentasporpagarAux.setdebito_mone_local(saldoscuentasporpagarAux.getdebito_mone_local()+saldoscuentasporpagar.getdebito_mone_local());			
			saldoscuentasporpagarAux.setcredito_mone_local(saldoscuentasporpagarAux.getcredito_mone_local()+saldoscuentasporpagar.getcredito_mone_local());			
			saldoscuentasporpagarAux.setsaldo_anterior(saldoscuentasporpagarAux.getsaldo_anterior()+saldoscuentasporpagar.getsaldo_anterior());			
			saldoscuentasporpagarAux.setsaldo_debito(saldoscuentasporpagarAux.getsaldo_debito()+saldoscuentasporpagar.getsaldo_debito());			
			saldoscuentasporpagarAux.setsaldo_credito(saldoscuentasporpagarAux.getsaldo_credito()+saldoscuentasporpagar.getsaldo_credito());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesSaldosCuentasPorPagar(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=SaldosCuentasPorPagarConstantesFunciones.getArrayColumnasGlobalesSaldosCuentasPorPagar(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesSaldosCuentasPorPagar(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SaldosCuentasPorPagarConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SaldosCuentasPorPagarConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SaldosCuentasPorPagarConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SaldosCuentasPorPagarConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoSaldosCuentasPorPagar(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<SaldosCuentasPorPagar> saldoscuentasporpagars,SaldosCuentasPorPagar saldoscuentasporpagar,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(SaldosCuentasPorPagar saldoscuentasporpagarAux: saldoscuentasporpagars) {
			if(saldoscuentasporpagarAux!=null && saldoscuentasporpagar!=null) {
				if((saldoscuentasporpagarAux.getId()==null && saldoscuentasporpagar.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(saldoscuentasporpagarAux.getId()!=null && saldoscuentasporpagar.getId()!=null){
					if(saldoscuentasporpagarAux.getId().equals(saldoscuentasporpagar.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaSaldosCuentasPorPagar(List<SaldosCuentasPorPagar> saldoscuentasporpagars) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double debito_mone_localTotal=0.0;
		Double credito_mone_localTotal=0.0;
		Double saldo_anteriorTotal=0.0;
		Double saldo_debitoTotal=0.0;
		Double saldo_creditoTotal=0.0;
	
		for(SaldosCuentasPorPagar saldoscuentasporpagar: saldoscuentasporpagars) {			
			if(saldoscuentasporpagar.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			debito_mone_localTotal+=saldoscuentasporpagar.getdebito_mone_local();
			credito_mone_localTotal+=saldoscuentasporpagar.getcredito_mone_local();
			saldo_anteriorTotal+=saldoscuentasporpagar.getsaldo_anterior();
			saldo_debitoTotal+=saldoscuentasporpagar.getsaldo_debito();
			saldo_creditoTotal+=saldoscuentasporpagar.getsaldo_credito();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SaldosCuentasPorPagarConstantesFunciones.DEBITOMONELOCAL);
		datoGeneral.setsDescripcion(SaldosCuentasPorPagarConstantesFunciones.LABEL_DEBITOMONELOCAL);
		datoGeneral.setdValorDouble(debito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SaldosCuentasPorPagarConstantesFunciones.CREDITOMONELOCAL);
		datoGeneral.setsDescripcion(SaldosCuentasPorPagarConstantesFunciones.LABEL_CREDITOMONELOCAL);
		datoGeneral.setdValorDouble(credito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SaldosCuentasPorPagarConstantesFunciones.SALDOANTERIOR);
		datoGeneral.setsDescripcion(SaldosCuentasPorPagarConstantesFunciones.LABEL_SALDOANTERIOR);
		datoGeneral.setdValorDouble(saldo_anteriorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SaldosCuentasPorPagarConstantesFunciones.SALDODEBITO);
		datoGeneral.setsDescripcion(SaldosCuentasPorPagarConstantesFunciones.LABEL_SALDODEBITO);
		datoGeneral.setdValorDouble(saldo_debitoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SaldosCuentasPorPagarConstantesFunciones.SALDOCREDITO);
		datoGeneral.setsDescripcion(SaldosCuentasPorPagarConstantesFunciones.LABEL_SALDOCREDITO);
		datoGeneral.setdValorDouble(saldo_creditoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaSaldosCuentasPorPagar() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,SaldosCuentasPorPagarConstantesFunciones.LABEL_ID, SaldosCuentasPorPagarConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldosCuentasPorPagarConstantesFunciones.LABEL_VERSIONROW, SaldosCuentasPorPagarConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldosCuentasPorPagarConstantesFunciones.LABEL_CODIGO, SaldosCuentasPorPagarConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldosCuentasPorPagarConstantesFunciones.LABEL_NOMBRECOMPLETO, SaldosCuentasPorPagarConstantesFunciones.NOMBRECOMPLETO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldosCuentasPorPagarConstantesFunciones.LABEL_DEBITOMONELOCAL, SaldosCuentasPorPagarConstantesFunciones.DEBITOMONELOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldosCuentasPorPagarConstantesFunciones.LABEL_CREDITOMONELOCAL, SaldosCuentasPorPagarConstantesFunciones.CREDITOMONELOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldosCuentasPorPagarConstantesFunciones.LABEL_SALDOANTERIOR, SaldosCuentasPorPagarConstantesFunciones.SALDOANTERIOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldosCuentasPorPagarConstantesFunciones.LABEL_SALDODEBITO, SaldosCuentasPorPagarConstantesFunciones.SALDODEBITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldosCuentasPorPagarConstantesFunciones.LABEL_SALDOCREDITO, SaldosCuentasPorPagarConstantesFunciones.SALDOCREDITO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasSaldosCuentasPorPagar() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=SaldosCuentasPorPagarConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldosCuentasPorPagarConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldosCuentasPorPagarConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldosCuentasPorPagarConstantesFunciones.NOMBRECOMPLETO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldosCuentasPorPagarConstantesFunciones.DEBITOMONELOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldosCuentasPorPagarConstantesFunciones.CREDITOMONELOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldosCuentasPorPagarConstantesFunciones.SALDOANTERIOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldosCuentasPorPagarConstantesFunciones.SALDODEBITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldosCuentasPorPagarConstantesFunciones.SALDOCREDITO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSaldosCuentasPorPagar() throws Exception  {
		return SaldosCuentasPorPagarConstantesFunciones.getTiposSeleccionarSaldosCuentasPorPagar(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSaldosCuentasPorPagar(Boolean conFk) throws Exception  {
		return SaldosCuentasPorPagarConstantesFunciones.getTiposSeleccionarSaldosCuentasPorPagar(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSaldosCuentasPorPagar(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosCuentasPorPagarConstantesFunciones.LABEL_IDZONA);
			reporte.setsDescripcion(SaldosCuentasPorPagarConstantesFunciones.LABEL_IDZONA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosCuentasPorPagarConstantesFunciones.LABEL_IDGRUPOCLIENTE);
			reporte.setsDescripcion(SaldosCuentasPorPagarConstantesFunciones.LABEL_IDGRUPOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosCuentasPorPagarConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(SaldosCuentasPorPagarConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosCuentasPorPagarConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(SaldosCuentasPorPagarConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosCuentasPorPagarConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(SaldosCuentasPorPagarConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosCuentasPorPagarConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(SaldosCuentasPorPagarConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosCuentasPorPagarConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(SaldosCuentasPorPagarConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosCuentasPorPagarConstantesFunciones.LABEL_NOMBRECOMPLETO);
			reporte.setsDescripcion(SaldosCuentasPorPagarConstantesFunciones.LABEL_NOMBRECOMPLETO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosCuentasPorPagarConstantesFunciones.LABEL_DEBITOMONELOCAL);
			reporte.setsDescripcion(SaldosCuentasPorPagarConstantesFunciones.LABEL_DEBITOMONELOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosCuentasPorPagarConstantesFunciones.LABEL_CREDITOMONELOCAL);
			reporte.setsDescripcion(SaldosCuentasPorPagarConstantesFunciones.LABEL_CREDITOMONELOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosCuentasPorPagarConstantesFunciones.LABEL_SALDOANTERIOR);
			reporte.setsDescripcion(SaldosCuentasPorPagarConstantesFunciones.LABEL_SALDOANTERIOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosCuentasPorPagarConstantesFunciones.LABEL_SALDODEBITO);
			reporte.setsDescripcion(SaldosCuentasPorPagarConstantesFunciones.LABEL_SALDODEBITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosCuentasPorPagarConstantesFunciones.LABEL_SALDOCREDITO);
			reporte.setsDescripcion(SaldosCuentasPorPagarConstantesFunciones.LABEL_SALDOCREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesSaldosCuentasPorPagar(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesSaldosCuentasPorPagar(SaldosCuentasPorPagar saldoscuentasporpagarAux) throws Exception {
		
			saldoscuentasporpagarAux.setzona_descripcion(ZonaConstantesFunciones.getZonaDescripcion(saldoscuentasporpagarAux.getZona()));
			saldoscuentasporpagarAux.setgrupocliente_descripcion(GrupoClienteConstantesFunciones.getGrupoClienteDescripcion(saldoscuentasporpagarAux.getGrupoCliente()));
			saldoscuentasporpagarAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(saldoscuentasporpagarAux.getEmpresa()));
			saldoscuentasporpagarAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(saldoscuentasporpagarAux.getSucursal()));
			saldoscuentasporpagarAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(saldoscuentasporpagarAux.getCliente()));		
	}
	
	public static void refrescarForeignKeysDescripcionesSaldosCuentasPorPagar(List<SaldosCuentasPorPagar> saldoscuentasporpagarsTemp) throws Exception {
		for(SaldosCuentasPorPagar saldoscuentasporpagarAux:saldoscuentasporpagarsTemp) {
			
			saldoscuentasporpagarAux.setzona_descripcion(ZonaConstantesFunciones.getZonaDescripcion(saldoscuentasporpagarAux.getZona()));
			saldoscuentasporpagarAux.setgrupocliente_descripcion(GrupoClienteConstantesFunciones.getGrupoClienteDescripcion(saldoscuentasporpagarAux.getGrupoCliente()));
			saldoscuentasporpagarAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(saldoscuentasporpagarAux.getEmpresa()));
			saldoscuentasporpagarAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(saldoscuentasporpagarAux.getSucursal()));
			saldoscuentasporpagarAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(saldoscuentasporpagarAux.getCliente()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfSaldosCuentasPorPagar(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Zona.class));
				classes.add(new Classe(GrupoCliente.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Cliente.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Zona.class)) {
						classes.add(new Classe(Zona.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(GrupoCliente.class)) {
						classes.add(new Classe(GrupoCliente.class));
					}
				}

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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfSaldosCuentasPorPagar(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Zona.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Zona.class)); continue;
					}

					if(GrupoCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoCliente.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Zona.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Zona.class)); continue;
					}

					if(GrupoCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoCliente.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfSaldosCuentasPorPagar(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return SaldosCuentasPorPagarConstantesFunciones.getClassesRelationshipsOfSaldosCuentasPorPagar(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSaldosCuentasPorPagar(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSaldosCuentasPorPagar(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return SaldosCuentasPorPagarConstantesFunciones.getClassesRelationshipsFromStringsOfSaldosCuentasPorPagar(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSaldosCuentasPorPagar(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(SaldosCuentasPorPagar saldoscuentasporpagar,List<SaldosCuentasPorPagar> saldoscuentasporpagars,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(SaldosCuentasPorPagar saldoscuentasporpagar,List<SaldosCuentasPorPagar> saldoscuentasporpagars) throws Exception {
		try	{			
			for(SaldosCuentasPorPagar saldoscuentasporpagarLocal:saldoscuentasporpagars) {
				if(saldoscuentasporpagarLocal.getId().equals(saldoscuentasporpagar.getId())) {
					saldoscuentasporpagarLocal.setIsSelected(saldoscuentasporpagar.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesSaldosCuentasPorPagar(List<SaldosCuentasPorPagar> saldoscuentasporpagarsAux) throws Exception {
		//this.saldoscuentasporpagarsAux=saldoscuentasporpagarsAux;
		
		for(SaldosCuentasPorPagar saldoscuentasporpagarAux:saldoscuentasporpagarsAux) {
			if(saldoscuentasporpagarAux.getIsChanged()) {
				saldoscuentasporpagarAux.setIsChanged(false);
			}		
			
			if(saldoscuentasporpagarAux.getIsNew()) {
				saldoscuentasporpagarAux.setIsNew(false);
			}	
			
			if(saldoscuentasporpagarAux.getIsDeleted()) {
				saldoscuentasporpagarAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesSaldosCuentasPorPagar(SaldosCuentasPorPagar saldoscuentasporpagarAux) throws Exception {
		//this.saldoscuentasporpagarAux=saldoscuentasporpagarAux;
		
			if(saldoscuentasporpagarAux.getIsChanged()) {
				saldoscuentasporpagarAux.setIsChanged(false);
			}		
			
			if(saldoscuentasporpagarAux.getIsNew()) {
				saldoscuentasporpagarAux.setIsNew(false);
			}	
			
			if(saldoscuentasporpagarAux.getIsDeleted()) {
				saldoscuentasporpagarAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(SaldosCuentasPorPagar saldoscuentasporpagarAsignar,SaldosCuentasPorPagar saldoscuentasporpagar) throws Exception {
		saldoscuentasporpagarAsignar.setId(saldoscuentasporpagar.getId());	
		saldoscuentasporpagarAsignar.setVersionRow(saldoscuentasporpagar.getVersionRow());	
		saldoscuentasporpagarAsignar.setcodigo(saldoscuentasporpagar.getcodigo());	
		saldoscuentasporpagarAsignar.setnombre_completo(saldoscuentasporpagar.getnombre_completo());	
		saldoscuentasporpagarAsignar.setdebito_mone_local(saldoscuentasporpagar.getdebito_mone_local());	
		saldoscuentasporpagarAsignar.setcredito_mone_local(saldoscuentasporpagar.getcredito_mone_local());	
		saldoscuentasporpagarAsignar.setsaldo_anterior(saldoscuentasporpagar.getsaldo_anterior());	
		saldoscuentasporpagarAsignar.setsaldo_debito(saldoscuentasporpagar.getsaldo_debito());	
		saldoscuentasporpagarAsignar.setsaldo_credito(saldoscuentasporpagar.getsaldo_credito());	
	}
	
	public static void inicializarSaldosCuentasPorPagar(SaldosCuentasPorPagar saldoscuentasporpagar) throws Exception {
		try {
				saldoscuentasporpagar.setId(0L);	
					
				saldoscuentasporpagar.setcodigo("");	
				saldoscuentasporpagar.setnombre_completo("");	
				saldoscuentasporpagar.setdebito_mone_local(0.0);	
				saldoscuentasporpagar.setcredito_mone_local(0.0);	
				saldoscuentasporpagar.setsaldo_anterior(0.0);	
				saldoscuentasporpagar.setsaldo_debito(0.0);	
				saldoscuentasporpagar.setsaldo_credito(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderSaldosCuentasPorPagar(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosCuentasPorPagarConstantesFunciones.LABEL_IDZONA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosCuentasPorPagarConstantesFunciones.LABEL_IDGRUPOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosCuentasPorPagarConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosCuentasPorPagarConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosCuentasPorPagarConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosCuentasPorPagarConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosCuentasPorPagarConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosCuentasPorPagarConstantesFunciones.LABEL_NOMBRECOMPLETO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosCuentasPorPagarConstantesFunciones.LABEL_DEBITOMONELOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosCuentasPorPagarConstantesFunciones.LABEL_CREDITOMONELOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosCuentasPorPagarConstantesFunciones.LABEL_SALDOANTERIOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosCuentasPorPagarConstantesFunciones.LABEL_SALDODEBITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosCuentasPorPagarConstantesFunciones.LABEL_SALDOCREDITO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataSaldosCuentasPorPagar(String sTipo,Row row,Workbook workbook,SaldosCuentasPorPagar saldoscuentasporpagar,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(saldoscuentasporpagar.getzona_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldoscuentasporpagar.getgrupocliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldoscuentasporpagar.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldoscuentasporpagar.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldoscuentasporpagar.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldoscuentasporpagar.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldoscuentasporpagar.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldoscuentasporpagar.getnombre_completo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldoscuentasporpagar.getdebito_mone_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldoscuentasporpagar.getcredito_mone_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldoscuentasporpagar.getsaldo_anterior());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldoscuentasporpagar.getsaldo_debito());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldoscuentasporpagar.getsaldo_credito());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQuerySaldosCuentasPorPagar="";
	
	public String getsFinalQuerySaldosCuentasPorPagar() {
		return this.sFinalQuerySaldosCuentasPorPagar;
	}
	
	public void setsFinalQuerySaldosCuentasPorPagar(String sFinalQuerySaldosCuentasPorPagar) {
		this.sFinalQuerySaldosCuentasPorPagar= sFinalQuerySaldosCuentasPorPagar;
	}
	
	public Border resaltarSeleccionarSaldosCuentasPorPagar=null;
	
	public Border setResaltarSeleccionarSaldosCuentasPorPagar(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosCuentasPorPagarBeanSwingJInternalFrame saldoscuentasporpagarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//saldoscuentasporpagarBeanSwingJInternalFrame.jTtoolBarSaldosCuentasPorPagar.setBorder(borderResaltar);
		
		this.resaltarSeleccionarSaldosCuentasPorPagar= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarSaldosCuentasPorPagar() {
		return this.resaltarSeleccionarSaldosCuentasPorPagar;
	}
	
	public void setResaltarSeleccionarSaldosCuentasPorPagar(Border borderResaltarSeleccionarSaldosCuentasPorPagar) {
		this.resaltarSeleccionarSaldosCuentasPorPagar= borderResaltarSeleccionarSaldosCuentasPorPagar;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridSaldosCuentasPorPagar=null;
	public Boolean mostraridSaldosCuentasPorPagar=true;
	public Boolean activaridSaldosCuentasPorPagar=true;

	public Border resaltarid_zonaSaldosCuentasPorPagar=null;
	public Boolean mostrarid_zonaSaldosCuentasPorPagar=true;
	public Boolean activarid_zonaSaldosCuentasPorPagar=true;
	public Boolean cargarid_zonaSaldosCuentasPorPagar=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_zonaSaldosCuentasPorPagar=false;//ConEventDepend=true

	public Border resaltarid_grupo_clienteSaldosCuentasPorPagar=null;
	public Boolean mostrarid_grupo_clienteSaldosCuentasPorPagar=true;
	public Boolean activarid_grupo_clienteSaldosCuentasPorPagar=true;
	public Boolean cargarid_grupo_clienteSaldosCuentasPorPagar=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_grupo_clienteSaldosCuentasPorPagar=false;//ConEventDepend=true

	public Border resaltarid_empresaSaldosCuentasPorPagar=null;
	public Boolean mostrarid_empresaSaldosCuentasPorPagar=true;
	public Boolean activarid_empresaSaldosCuentasPorPagar=true;
	public Boolean cargarid_empresaSaldosCuentasPorPagar=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaSaldosCuentasPorPagar=false;//ConEventDepend=true

	public Border resaltarid_sucursalSaldosCuentasPorPagar=null;
	public Boolean mostrarid_sucursalSaldosCuentasPorPagar=true;
	public Boolean activarid_sucursalSaldosCuentasPorPagar=true;
	public Boolean cargarid_sucursalSaldosCuentasPorPagar=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalSaldosCuentasPorPagar=false;//ConEventDepend=true

	public Border resaltarid_clienteSaldosCuentasPorPagar=null;
	public Boolean mostrarid_clienteSaldosCuentasPorPagar=true;
	public Boolean activarid_clienteSaldosCuentasPorPagar=true;
	public Boolean cargarid_clienteSaldosCuentasPorPagar=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteSaldosCuentasPorPagar=false;//ConEventDepend=true

	public Border resaltarfecha_emision_hastaSaldosCuentasPorPagar=null;
	public Boolean mostrarfecha_emision_hastaSaldosCuentasPorPagar=true;
	public Boolean activarfecha_emision_hastaSaldosCuentasPorPagar=true;

	public Border resaltarcodigoSaldosCuentasPorPagar=null;
	public Boolean mostrarcodigoSaldosCuentasPorPagar=true;
	public Boolean activarcodigoSaldosCuentasPorPagar=true;

	public Border resaltarnombre_completoSaldosCuentasPorPagar=null;
	public Boolean mostrarnombre_completoSaldosCuentasPorPagar=true;
	public Boolean activarnombre_completoSaldosCuentasPorPagar=true;

	public Border resaltardebito_mone_localSaldosCuentasPorPagar=null;
	public Boolean mostrardebito_mone_localSaldosCuentasPorPagar=true;
	public Boolean activardebito_mone_localSaldosCuentasPorPagar=true;

	public Border resaltarcredito_mone_localSaldosCuentasPorPagar=null;
	public Boolean mostrarcredito_mone_localSaldosCuentasPorPagar=true;
	public Boolean activarcredito_mone_localSaldosCuentasPorPagar=true;

	public Border resaltarsaldo_anteriorSaldosCuentasPorPagar=null;
	public Boolean mostrarsaldo_anteriorSaldosCuentasPorPagar=true;
	public Boolean activarsaldo_anteriorSaldosCuentasPorPagar=false;

	public Border resaltarsaldo_debitoSaldosCuentasPorPagar=null;
	public Boolean mostrarsaldo_debitoSaldosCuentasPorPagar=true;
	public Boolean activarsaldo_debitoSaldosCuentasPorPagar=true;

	public Border resaltarsaldo_creditoSaldosCuentasPorPagar=null;
	public Boolean mostrarsaldo_creditoSaldosCuentasPorPagar=true;
	public Boolean activarsaldo_creditoSaldosCuentasPorPagar=true;

	
	

	public Border setResaltaridSaldosCuentasPorPagar(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosCuentasPorPagarBeanSwingJInternalFrame saldoscuentasporpagarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldoscuentasporpagarBeanSwingJInternalFrame.jTtoolBarSaldosCuentasPorPagar.setBorder(borderResaltar);
		
		this.resaltaridSaldosCuentasPorPagar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridSaldosCuentasPorPagar() {
		return this.resaltaridSaldosCuentasPorPagar;
	}

	public void setResaltaridSaldosCuentasPorPagar(Border borderResaltar) {
		this.resaltaridSaldosCuentasPorPagar= borderResaltar;
	}

	public Boolean getMostraridSaldosCuentasPorPagar() {
		return this.mostraridSaldosCuentasPorPagar;
	}

	public void setMostraridSaldosCuentasPorPagar(Boolean mostraridSaldosCuentasPorPagar) {
		this.mostraridSaldosCuentasPorPagar= mostraridSaldosCuentasPorPagar;
	}

	public Boolean getActivaridSaldosCuentasPorPagar() {
		return this.activaridSaldosCuentasPorPagar;
	}

	public void setActivaridSaldosCuentasPorPagar(Boolean activaridSaldosCuentasPorPagar) {
		this.activaridSaldosCuentasPorPagar= activaridSaldosCuentasPorPagar;
	}

	public Border setResaltarid_zonaSaldosCuentasPorPagar(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosCuentasPorPagarBeanSwingJInternalFrame saldoscuentasporpagarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldoscuentasporpagarBeanSwingJInternalFrame.jTtoolBarSaldosCuentasPorPagar.setBorder(borderResaltar);
		
		this.resaltarid_zonaSaldosCuentasPorPagar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_zonaSaldosCuentasPorPagar() {
		return this.resaltarid_zonaSaldosCuentasPorPagar;
	}

	public void setResaltarid_zonaSaldosCuentasPorPagar(Border borderResaltar) {
		this.resaltarid_zonaSaldosCuentasPorPagar= borderResaltar;
	}

	public Boolean getMostrarid_zonaSaldosCuentasPorPagar() {
		return this.mostrarid_zonaSaldosCuentasPorPagar;
	}

	public void setMostrarid_zonaSaldosCuentasPorPagar(Boolean mostrarid_zonaSaldosCuentasPorPagar) {
		this.mostrarid_zonaSaldosCuentasPorPagar= mostrarid_zonaSaldosCuentasPorPagar;
	}

	public Boolean getActivarid_zonaSaldosCuentasPorPagar() {
		return this.activarid_zonaSaldosCuentasPorPagar;
	}

	public void setActivarid_zonaSaldosCuentasPorPagar(Boolean activarid_zonaSaldosCuentasPorPagar) {
		this.activarid_zonaSaldosCuentasPorPagar= activarid_zonaSaldosCuentasPorPagar;
	}

	public Boolean getCargarid_zonaSaldosCuentasPorPagar() {
		return this.cargarid_zonaSaldosCuentasPorPagar;
	}

	public void setCargarid_zonaSaldosCuentasPorPagar(Boolean cargarid_zonaSaldosCuentasPorPagar) {
		this.cargarid_zonaSaldosCuentasPorPagar= cargarid_zonaSaldosCuentasPorPagar;
	}

	public Border setResaltarid_grupo_clienteSaldosCuentasPorPagar(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosCuentasPorPagarBeanSwingJInternalFrame saldoscuentasporpagarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldoscuentasporpagarBeanSwingJInternalFrame.jTtoolBarSaldosCuentasPorPagar.setBorder(borderResaltar);
		
		this.resaltarid_grupo_clienteSaldosCuentasPorPagar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_grupo_clienteSaldosCuentasPorPagar() {
		return this.resaltarid_grupo_clienteSaldosCuentasPorPagar;
	}

	public void setResaltarid_grupo_clienteSaldosCuentasPorPagar(Border borderResaltar) {
		this.resaltarid_grupo_clienteSaldosCuentasPorPagar= borderResaltar;
	}

	public Boolean getMostrarid_grupo_clienteSaldosCuentasPorPagar() {
		return this.mostrarid_grupo_clienteSaldosCuentasPorPagar;
	}

	public void setMostrarid_grupo_clienteSaldosCuentasPorPagar(Boolean mostrarid_grupo_clienteSaldosCuentasPorPagar) {
		this.mostrarid_grupo_clienteSaldosCuentasPorPagar= mostrarid_grupo_clienteSaldosCuentasPorPagar;
	}

	public Boolean getActivarid_grupo_clienteSaldosCuentasPorPagar() {
		return this.activarid_grupo_clienteSaldosCuentasPorPagar;
	}

	public void setActivarid_grupo_clienteSaldosCuentasPorPagar(Boolean activarid_grupo_clienteSaldosCuentasPorPagar) {
		this.activarid_grupo_clienteSaldosCuentasPorPagar= activarid_grupo_clienteSaldosCuentasPorPagar;
	}

	public Boolean getCargarid_grupo_clienteSaldosCuentasPorPagar() {
		return this.cargarid_grupo_clienteSaldosCuentasPorPagar;
	}

	public void setCargarid_grupo_clienteSaldosCuentasPorPagar(Boolean cargarid_grupo_clienteSaldosCuentasPorPagar) {
		this.cargarid_grupo_clienteSaldosCuentasPorPagar= cargarid_grupo_clienteSaldosCuentasPorPagar;
	}

	public Border setResaltarid_empresaSaldosCuentasPorPagar(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosCuentasPorPagarBeanSwingJInternalFrame saldoscuentasporpagarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldoscuentasporpagarBeanSwingJInternalFrame.jTtoolBarSaldosCuentasPorPagar.setBorder(borderResaltar);
		
		this.resaltarid_empresaSaldosCuentasPorPagar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaSaldosCuentasPorPagar() {
		return this.resaltarid_empresaSaldosCuentasPorPagar;
	}

	public void setResaltarid_empresaSaldosCuentasPorPagar(Border borderResaltar) {
		this.resaltarid_empresaSaldosCuentasPorPagar= borderResaltar;
	}

	public Boolean getMostrarid_empresaSaldosCuentasPorPagar() {
		return this.mostrarid_empresaSaldosCuentasPorPagar;
	}

	public void setMostrarid_empresaSaldosCuentasPorPagar(Boolean mostrarid_empresaSaldosCuentasPorPagar) {
		this.mostrarid_empresaSaldosCuentasPorPagar= mostrarid_empresaSaldosCuentasPorPagar;
	}

	public Boolean getActivarid_empresaSaldosCuentasPorPagar() {
		return this.activarid_empresaSaldosCuentasPorPagar;
	}

	public void setActivarid_empresaSaldosCuentasPorPagar(Boolean activarid_empresaSaldosCuentasPorPagar) {
		this.activarid_empresaSaldosCuentasPorPagar= activarid_empresaSaldosCuentasPorPagar;
	}

	public Boolean getCargarid_empresaSaldosCuentasPorPagar() {
		return this.cargarid_empresaSaldosCuentasPorPagar;
	}

	public void setCargarid_empresaSaldosCuentasPorPagar(Boolean cargarid_empresaSaldosCuentasPorPagar) {
		this.cargarid_empresaSaldosCuentasPorPagar= cargarid_empresaSaldosCuentasPorPagar;
	}

	public Border setResaltarid_sucursalSaldosCuentasPorPagar(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosCuentasPorPagarBeanSwingJInternalFrame saldoscuentasporpagarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldoscuentasporpagarBeanSwingJInternalFrame.jTtoolBarSaldosCuentasPorPagar.setBorder(borderResaltar);
		
		this.resaltarid_sucursalSaldosCuentasPorPagar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalSaldosCuentasPorPagar() {
		return this.resaltarid_sucursalSaldosCuentasPorPagar;
	}

	public void setResaltarid_sucursalSaldosCuentasPorPagar(Border borderResaltar) {
		this.resaltarid_sucursalSaldosCuentasPorPagar= borderResaltar;
	}

	public Boolean getMostrarid_sucursalSaldosCuentasPorPagar() {
		return this.mostrarid_sucursalSaldosCuentasPorPagar;
	}

	public void setMostrarid_sucursalSaldosCuentasPorPagar(Boolean mostrarid_sucursalSaldosCuentasPorPagar) {
		this.mostrarid_sucursalSaldosCuentasPorPagar= mostrarid_sucursalSaldosCuentasPorPagar;
	}

	public Boolean getActivarid_sucursalSaldosCuentasPorPagar() {
		return this.activarid_sucursalSaldosCuentasPorPagar;
	}

	public void setActivarid_sucursalSaldosCuentasPorPagar(Boolean activarid_sucursalSaldosCuentasPorPagar) {
		this.activarid_sucursalSaldosCuentasPorPagar= activarid_sucursalSaldosCuentasPorPagar;
	}

	public Boolean getCargarid_sucursalSaldosCuentasPorPagar() {
		return this.cargarid_sucursalSaldosCuentasPorPagar;
	}

	public void setCargarid_sucursalSaldosCuentasPorPagar(Boolean cargarid_sucursalSaldosCuentasPorPagar) {
		this.cargarid_sucursalSaldosCuentasPorPagar= cargarid_sucursalSaldosCuentasPorPagar;
	}

	public Border setResaltarid_clienteSaldosCuentasPorPagar(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosCuentasPorPagarBeanSwingJInternalFrame saldoscuentasporpagarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldoscuentasporpagarBeanSwingJInternalFrame.jTtoolBarSaldosCuentasPorPagar.setBorder(borderResaltar);
		
		this.resaltarid_clienteSaldosCuentasPorPagar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteSaldosCuentasPorPagar() {
		return this.resaltarid_clienteSaldosCuentasPorPagar;
	}

	public void setResaltarid_clienteSaldosCuentasPorPagar(Border borderResaltar) {
		this.resaltarid_clienteSaldosCuentasPorPagar= borderResaltar;
	}

	public Boolean getMostrarid_clienteSaldosCuentasPorPagar() {
		return this.mostrarid_clienteSaldosCuentasPorPagar;
	}

	public void setMostrarid_clienteSaldosCuentasPorPagar(Boolean mostrarid_clienteSaldosCuentasPorPagar) {
		this.mostrarid_clienteSaldosCuentasPorPagar= mostrarid_clienteSaldosCuentasPorPagar;
	}

	public Boolean getActivarid_clienteSaldosCuentasPorPagar() {
		return this.activarid_clienteSaldosCuentasPorPagar;
	}

	public void setActivarid_clienteSaldosCuentasPorPagar(Boolean activarid_clienteSaldosCuentasPorPagar) {
		this.activarid_clienteSaldosCuentasPorPagar= activarid_clienteSaldosCuentasPorPagar;
	}

	public Boolean getCargarid_clienteSaldosCuentasPorPagar() {
		return this.cargarid_clienteSaldosCuentasPorPagar;
	}

	public void setCargarid_clienteSaldosCuentasPorPagar(Boolean cargarid_clienteSaldosCuentasPorPagar) {
		this.cargarid_clienteSaldosCuentasPorPagar= cargarid_clienteSaldosCuentasPorPagar;
	}

	public Border setResaltarfecha_emision_hastaSaldosCuentasPorPagar(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosCuentasPorPagarBeanSwingJInternalFrame saldoscuentasporpagarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldoscuentasporpagarBeanSwingJInternalFrame.jTtoolBarSaldosCuentasPorPagar.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaSaldosCuentasPorPagar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaSaldosCuentasPorPagar() {
		return this.resaltarfecha_emision_hastaSaldosCuentasPorPagar;
	}

	public void setResaltarfecha_emision_hastaSaldosCuentasPorPagar(Border borderResaltar) {
		this.resaltarfecha_emision_hastaSaldosCuentasPorPagar= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaSaldosCuentasPorPagar() {
		return this.mostrarfecha_emision_hastaSaldosCuentasPorPagar;
	}

	public void setMostrarfecha_emision_hastaSaldosCuentasPorPagar(Boolean mostrarfecha_emision_hastaSaldosCuentasPorPagar) {
		this.mostrarfecha_emision_hastaSaldosCuentasPorPagar= mostrarfecha_emision_hastaSaldosCuentasPorPagar;
	}

	public Boolean getActivarfecha_emision_hastaSaldosCuentasPorPagar() {
		return this.activarfecha_emision_hastaSaldosCuentasPorPagar;
	}

	public void setActivarfecha_emision_hastaSaldosCuentasPorPagar(Boolean activarfecha_emision_hastaSaldosCuentasPorPagar) {
		this.activarfecha_emision_hastaSaldosCuentasPorPagar= activarfecha_emision_hastaSaldosCuentasPorPagar;
	}

	public Border setResaltarcodigoSaldosCuentasPorPagar(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosCuentasPorPagarBeanSwingJInternalFrame saldoscuentasporpagarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldoscuentasporpagarBeanSwingJInternalFrame.jTtoolBarSaldosCuentasPorPagar.setBorder(borderResaltar);
		
		this.resaltarcodigoSaldosCuentasPorPagar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoSaldosCuentasPorPagar() {
		return this.resaltarcodigoSaldosCuentasPorPagar;
	}

	public void setResaltarcodigoSaldosCuentasPorPagar(Border borderResaltar) {
		this.resaltarcodigoSaldosCuentasPorPagar= borderResaltar;
	}

	public Boolean getMostrarcodigoSaldosCuentasPorPagar() {
		return this.mostrarcodigoSaldosCuentasPorPagar;
	}

	public void setMostrarcodigoSaldosCuentasPorPagar(Boolean mostrarcodigoSaldosCuentasPorPagar) {
		this.mostrarcodigoSaldosCuentasPorPagar= mostrarcodigoSaldosCuentasPorPagar;
	}

	public Boolean getActivarcodigoSaldosCuentasPorPagar() {
		return this.activarcodigoSaldosCuentasPorPagar;
	}

	public void setActivarcodigoSaldosCuentasPorPagar(Boolean activarcodigoSaldosCuentasPorPagar) {
		this.activarcodigoSaldosCuentasPorPagar= activarcodigoSaldosCuentasPorPagar;
	}

	public Border setResaltarnombre_completoSaldosCuentasPorPagar(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosCuentasPorPagarBeanSwingJInternalFrame saldoscuentasporpagarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldoscuentasporpagarBeanSwingJInternalFrame.jTtoolBarSaldosCuentasPorPagar.setBorder(borderResaltar);
		
		this.resaltarnombre_completoSaldosCuentasPorPagar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completoSaldosCuentasPorPagar() {
		return this.resaltarnombre_completoSaldosCuentasPorPagar;
	}

	public void setResaltarnombre_completoSaldosCuentasPorPagar(Border borderResaltar) {
		this.resaltarnombre_completoSaldosCuentasPorPagar= borderResaltar;
	}

	public Boolean getMostrarnombre_completoSaldosCuentasPorPagar() {
		return this.mostrarnombre_completoSaldosCuentasPorPagar;
	}

	public void setMostrarnombre_completoSaldosCuentasPorPagar(Boolean mostrarnombre_completoSaldosCuentasPorPagar) {
		this.mostrarnombre_completoSaldosCuentasPorPagar= mostrarnombre_completoSaldosCuentasPorPagar;
	}

	public Boolean getActivarnombre_completoSaldosCuentasPorPagar() {
		return this.activarnombre_completoSaldosCuentasPorPagar;
	}

	public void setActivarnombre_completoSaldosCuentasPorPagar(Boolean activarnombre_completoSaldosCuentasPorPagar) {
		this.activarnombre_completoSaldosCuentasPorPagar= activarnombre_completoSaldosCuentasPorPagar;
	}

	public Border setResaltardebito_mone_localSaldosCuentasPorPagar(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosCuentasPorPagarBeanSwingJInternalFrame saldoscuentasporpagarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldoscuentasporpagarBeanSwingJInternalFrame.jTtoolBarSaldosCuentasPorPagar.setBorder(borderResaltar);
		
		this.resaltardebito_mone_localSaldosCuentasPorPagar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebito_mone_localSaldosCuentasPorPagar() {
		return this.resaltardebito_mone_localSaldosCuentasPorPagar;
	}

	public void setResaltardebito_mone_localSaldosCuentasPorPagar(Border borderResaltar) {
		this.resaltardebito_mone_localSaldosCuentasPorPagar= borderResaltar;
	}

	public Boolean getMostrardebito_mone_localSaldosCuentasPorPagar() {
		return this.mostrardebito_mone_localSaldosCuentasPorPagar;
	}

	public void setMostrardebito_mone_localSaldosCuentasPorPagar(Boolean mostrardebito_mone_localSaldosCuentasPorPagar) {
		this.mostrardebito_mone_localSaldosCuentasPorPagar= mostrardebito_mone_localSaldosCuentasPorPagar;
	}

	public Boolean getActivardebito_mone_localSaldosCuentasPorPagar() {
		return this.activardebito_mone_localSaldosCuentasPorPagar;
	}

	public void setActivardebito_mone_localSaldosCuentasPorPagar(Boolean activardebito_mone_localSaldosCuentasPorPagar) {
		this.activardebito_mone_localSaldosCuentasPorPagar= activardebito_mone_localSaldosCuentasPorPagar;
	}

	public Border setResaltarcredito_mone_localSaldosCuentasPorPagar(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosCuentasPorPagarBeanSwingJInternalFrame saldoscuentasporpagarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldoscuentasporpagarBeanSwingJInternalFrame.jTtoolBarSaldosCuentasPorPagar.setBorder(borderResaltar);
		
		this.resaltarcredito_mone_localSaldosCuentasPorPagar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_mone_localSaldosCuentasPorPagar() {
		return this.resaltarcredito_mone_localSaldosCuentasPorPagar;
	}

	public void setResaltarcredito_mone_localSaldosCuentasPorPagar(Border borderResaltar) {
		this.resaltarcredito_mone_localSaldosCuentasPorPagar= borderResaltar;
	}

	public Boolean getMostrarcredito_mone_localSaldosCuentasPorPagar() {
		return this.mostrarcredito_mone_localSaldosCuentasPorPagar;
	}

	public void setMostrarcredito_mone_localSaldosCuentasPorPagar(Boolean mostrarcredito_mone_localSaldosCuentasPorPagar) {
		this.mostrarcredito_mone_localSaldosCuentasPorPagar= mostrarcredito_mone_localSaldosCuentasPorPagar;
	}

	public Boolean getActivarcredito_mone_localSaldosCuentasPorPagar() {
		return this.activarcredito_mone_localSaldosCuentasPorPagar;
	}

	public void setActivarcredito_mone_localSaldosCuentasPorPagar(Boolean activarcredito_mone_localSaldosCuentasPorPagar) {
		this.activarcredito_mone_localSaldosCuentasPorPagar= activarcredito_mone_localSaldosCuentasPorPagar;
	}

	public Border setResaltarsaldo_anteriorSaldosCuentasPorPagar(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosCuentasPorPagarBeanSwingJInternalFrame saldoscuentasporpagarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldoscuentasporpagarBeanSwingJInternalFrame.jTtoolBarSaldosCuentasPorPagar.setBorder(borderResaltar);
		
		this.resaltarsaldo_anteriorSaldosCuentasPorPagar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsaldo_anteriorSaldosCuentasPorPagar() {
		return this.resaltarsaldo_anteriorSaldosCuentasPorPagar;
	}

	public void setResaltarsaldo_anteriorSaldosCuentasPorPagar(Border borderResaltar) {
		this.resaltarsaldo_anteriorSaldosCuentasPorPagar= borderResaltar;
	}

	public Boolean getMostrarsaldo_anteriorSaldosCuentasPorPagar() {
		return this.mostrarsaldo_anteriorSaldosCuentasPorPagar;
	}

	public void setMostrarsaldo_anteriorSaldosCuentasPorPagar(Boolean mostrarsaldo_anteriorSaldosCuentasPorPagar) {
		this.mostrarsaldo_anteriorSaldosCuentasPorPagar= mostrarsaldo_anteriorSaldosCuentasPorPagar;
	}

	public Boolean getActivarsaldo_anteriorSaldosCuentasPorPagar() {
		return this.activarsaldo_anteriorSaldosCuentasPorPagar;
	}

	public void setActivarsaldo_anteriorSaldosCuentasPorPagar(Boolean activarsaldo_anteriorSaldosCuentasPorPagar) {
		this.activarsaldo_anteriorSaldosCuentasPorPagar= activarsaldo_anteriorSaldosCuentasPorPagar;
	}

	public Border setResaltarsaldo_debitoSaldosCuentasPorPagar(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosCuentasPorPagarBeanSwingJInternalFrame saldoscuentasporpagarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldoscuentasporpagarBeanSwingJInternalFrame.jTtoolBarSaldosCuentasPorPagar.setBorder(borderResaltar);
		
		this.resaltarsaldo_debitoSaldosCuentasPorPagar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsaldo_debitoSaldosCuentasPorPagar() {
		return this.resaltarsaldo_debitoSaldosCuentasPorPagar;
	}

	public void setResaltarsaldo_debitoSaldosCuentasPorPagar(Border borderResaltar) {
		this.resaltarsaldo_debitoSaldosCuentasPorPagar= borderResaltar;
	}

	public Boolean getMostrarsaldo_debitoSaldosCuentasPorPagar() {
		return this.mostrarsaldo_debitoSaldosCuentasPorPagar;
	}

	public void setMostrarsaldo_debitoSaldosCuentasPorPagar(Boolean mostrarsaldo_debitoSaldosCuentasPorPagar) {
		this.mostrarsaldo_debitoSaldosCuentasPorPagar= mostrarsaldo_debitoSaldosCuentasPorPagar;
	}

	public Boolean getActivarsaldo_debitoSaldosCuentasPorPagar() {
		return this.activarsaldo_debitoSaldosCuentasPorPagar;
	}

	public void setActivarsaldo_debitoSaldosCuentasPorPagar(Boolean activarsaldo_debitoSaldosCuentasPorPagar) {
		this.activarsaldo_debitoSaldosCuentasPorPagar= activarsaldo_debitoSaldosCuentasPorPagar;
	}

	public Border setResaltarsaldo_creditoSaldosCuentasPorPagar(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosCuentasPorPagarBeanSwingJInternalFrame saldoscuentasporpagarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldoscuentasporpagarBeanSwingJInternalFrame.jTtoolBarSaldosCuentasPorPagar.setBorder(borderResaltar);
		
		this.resaltarsaldo_creditoSaldosCuentasPorPagar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsaldo_creditoSaldosCuentasPorPagar() {
		return this.resaltarsaldo_creditoSaldosCuentasPorPagar;
	}

	public void setResaltarsaldo_creditoSaldosCuentasPorPagar(Border borderResaltar) {
		this.resaltarsaldo_creditoSaldosCuentasPorPagar= borderResaltar;
	}

	public Boolean getMostrarsaldo_creditoSaldosCuentasPorPagar() {
		return this.mostrarsaldo_creditoSaldosCuentasPorPagar;
	}

	public void setMostrarsaldo_creditoSaldosCuentasPorPagar(Boolean mostrarsaldo_creditoSaldosCuentasPorPagar) {
		this.mostrarsaldo_creditoSaldosCuentasPorPagar= mostrarsaldo_creditoSaldosCuentasPorPagar;
	}

	public Boolean getActivarsaldo_creditoSaldosCuentasPorPagar() {
		return this.activarsaldo_creditoSaldosCuentasPorPagar;
	}

	public void setActivarsaldo_creditoSaldosCuentasPorPagar(Boolean activarsaldo_creditoSaldosCuentasPorPagar) {
		this.activarsaldo_creditoSaldosCuentasPorPagar= activarsaldo_creditoSaldosCuentasPorPagar;
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
		
		
		this.setMostraridSaldosCuentasPorPagar(esInicial);
		this.setMostrarid_zonaSaldosCuentasPorPagar(esInicial);
		this.setMostrarid_grupo_clienteSaldosCuentasPorPagar(esInicial);
		this.setMostrarid_empresaSaldosCuentasPorPagar(esInicial);
		this.setMostrarid_sucursalSaldosCuentasPorPagar(esInicial);
		this.setMostrarid_clienteSaldosCuentasPorPagar(esInicial);
		this.setMostrarfecha_emision_hastaSaldosCuentasPorPagar(esInicial);
		this.setMostrarcodigoSaldosCuentasPorPagar(esInicial);
		this.setMostrarnombre_completoSaldosCuentasPorPagar(esInicial);
		this.setMostrardebito_mone_localSaldosCuentasPorPagar(esInicial);
		this.setMostrarcredito_mone_localSaldosCuentasPorPagar(esInicial);
		this.setMostrarsaldo_anteriorSaldosCuentasPorPagar(esInicial);
		this.setMostrarsaldo_debitoSaldosCuentasPorPagar(esInicial);
		this.setMostrarsaldo_creditoSaldosCuentasPorPagar(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.ID)) {
				this.setMostraridSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.IDZONA)) {
				this.setMostrarid_zonaSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.IDGRUPOCLIENTE)) {
				this.setMostrarid_grupo_clienteSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.NOMBRECOMPLETO)) {
				this.setMostrarnombre_completoSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.DEBITOMONELOCAL)) {
				this.setMostrardebito_mone_localSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.CREDITOMONELOCAL)) {
				this.setMostrarcredito_mone_localSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.SALDOANTERIOR)) {
				this.setMostrarsaldo_anteriorSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.SALDODEBITO)) {
				this.setMostrarsaldo_debitoSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.SALDOCREDITO)) {
				this.setMostrarsaldo_creditoSaldosCuentasPorPagar(esAsigna);
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
		
		
		this.setActivaridSaldosCuentasPorPagar(esInicial);
		this.setActivarid_zonaSaldosCuentasPorPagar(esInicial);
		this.setActivarid_grupo_clienteSaldosCuentasPorPagar(esInicial);
		this.setActivarid_empresaSaldosCuentasPorPagar(esInicial);
		this.setActivarid_sucursalSaldosCuentasPorPagar(esInicial);
		this.setActivarid_clienteSaldosCuentasPorPagar(esInicial);
		this.setActivarfecha_emision_hastaSaldosCuentasPorPagar(esInicial);
		this.setActivarcodigoSaldosCuentasPorPagar(esInicial);
		this.setActivarnombre_completoSaldosCuentasPorPagar(esInicial);
		this.setActivardebito_mone_localSaldosCuentasPorPagar(esInicial);
		this.setActivarcredito_mone_localSaldosCuentasPorPagar(esInicial);
		this.setActivarsaldo_anteriorSaldosCuentasPorPagar(esInicial);
		this.setActivarsaldo_debitoSaldosCuentasPorPagar(esInicial);
		this.setActivarsaldo_creditoSaldosCuentasPorPagar(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.ID)) {
				this.setActivaridSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.IDZONA)) {
				this.setActivarid_zonaSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.IDGRUPOCLIENTE)) {
				this.setActivarid_grupo_clienteSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.CODIGO)) {
				this.setActivarcodigoSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.NOMBRECOMPLETO)) {
				this.setActivarnombre_completoSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.DEBITOMONELOCAL)) {
				this.setActivardebito_mone_localSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.CREDITOMONELOCAL)) {
				this.setActivarcredito_mone_localSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.SALDOANTERIOR)) {
				this.setActivarsaldo_anteriorSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.SALDODEBITO)) {
				this.setActivarsaldo_debitoSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.SALDOCREDITO)) {
				this.setActivarsaldo_creditoSaldosCuentasPorPagar(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,SaldosCuentasPorPagarBeanSwingJInternalFrame saldoscuentasporpagarBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridSaldosCuentasPorPagar(esInicial);
		this.setResaltarid_zonaSaldosCuentasPorPagar(esInicial);
		this.setResaltarid_grupo_clienteSaldosCuentasPorPagar(esInicial);
		this.setResaltarid_empresaSaldosCuentasPorPagar(esInicial);
		this.setResaltarid_sucursalSaldosCuentasPorPagar(esInicial);
		this.setResaltarid_clienteSaldosCuentasPorPagar(esInicial);
		this.setResaltarfecha_emision_hastaSaldosCuentasPorPagar(esInicial);
		this.setResaltarcodigoSaldosCuentasPorPagar(esInicial);
		this.setResaltarnombre_completoSaldosCuentasPorPagar(esInicial);
		this.setResaltardebito_mone_localSaldosCuentasPorPagar(esInicial);
		this.setResaltarcredito_mone_localSaldosCuentasPorPagar(esInicial);
		this.setResaltarsaldo_anteriorSaldosCuentasPorPagar(esInicial);
		this.setResaltarsaldo_debitoSaldosCuentasPorPagar(esInicial);
		this.setResaltarsaldo_creditoSaldosCuentasPorPagar(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.ID)) {
				this.setResaltaridSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.IDZONA)) {
				this.setResaltarid_zonaSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.IDGRUPOCLIENTE)) {
				this.setResaltarid_grupo_clienteSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.NOMBRECOMPLETO)) {
				this.setResaltarnombre_completoSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.DEBITOMONELOCAL)) {
				this.setResaltardebito_mone_localSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.CREDITOMONELOCAL)) {
				this.setResaltarcredito_mone_localSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.SALDOANTERIOR)) {
				this.setResaltarsaldo_anteriorSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.SALDODEBITO)) {
				this.setResaltarsaldo_debitoSaldosCuentasPorPagar(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosCuentasPorPagarConstantesFunciones.SALDOCREDITO)) {
				this.setResaltarsaldo_creditoSaldosCuentasPorPagar(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,SaldosCuentasPorPagarBeanSwingJInternalFrame saldoscuentasporpagarBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaSaldosCuentasPorPagarSaldosCuentasPorPagar=true;

	public Boolean getMostrarBusquedaSaldosCuentasPorPagarSaldosCuentasPorPagar() {
		return this.mostrarBusquedaSaldosCuentasPorPagarSaldosCuentasPorPagar;
	}

	public void setMostrarBusquedaSaldosCuentasPorPagarSaldosCuentasPorPagar(Boolean visibilidadResaltar) {
		this.mostrarBusquedaSaldosCuentasPorPagarSaldosCuentasPorPagar= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaSaldosCuentasPorPagarSaldosCuentasPorPagar=true;

	public Boolean getActivarBusquedaSaldosCuentasPorPagarSaldosCuentasPorPagar() {
		return this.activarBusquedaSaldosCuentasPorPagarSaldosCuentasPorPagar;
	}

	public void setActivarBusquedaSaldosCuentasPorPagarSaldosCuentasPorPagar(Boolean habilitarResaltar) {
		this.activarBusquedaSaldosCuentasPorPagarSaldosCuentasPorPagar= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaSaldosCuentasPorPagarSaldosCuentasPorPagar=null;

	public Border getResaltarBusquedaSaldosCuentasPorPagarSaldosCuentasPorPagar() {
		return this.resaltarBusquedaSaldosCuentasPorPagarSaldosCuentasPorPagar;
	}

	public void setResaltarBusquedaSaldosCuentasPorPagarSaldosCuentasPorPagar(Border borderResaltar) {
		this.resaltarBusquedaSaldosCuentasPorPagarSaldosCuentasPorPagar= borderResaltar;
	}

	public void setResaltarBusquedaSaldosCuentasPorPagarSaldosCuentasPorPagar(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosCuentasPorPagarBeanSwingJInternalFrame saldoscuentasporpagarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaSaldosCuentasPorPagarSaldosCuentasPorPagar= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}