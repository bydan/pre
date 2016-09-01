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
package com.bydan.erp.nomina.util.report;

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


import com.bydan.erp.nomina.util.report.ListadosFormasPagosConstantesFunciones;
import com.bydan.erp.nomina.util.report.ListadosFormasPagosParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.ListadosFormasPagosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.business.entity.report.*;



import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ListadosFormasPagosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ListadosFormasPagos";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ListadosFormasPagos"+ListadosFormasPagosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ListadosFormasPagosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ListadosFormasPagosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ListadosFormasPagosConstantesFunciones.SCHEMA+"_"+ListadosFormasPagosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ListadosFormasPagosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ListadosFormasPagosConstantesFunciones.SCHEMA+"_"+ListadosFormasPagosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ListadosFormasPagosConstantesFunciones.SCHEMA+"_"+ListadosFormasPagosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ListadosFormasPagosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ListadosFormasPagosConstantesFunciones.SCHEMA+"_"+ListadosFormasPagosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ListadosFormasPagosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ListadosFormasPagosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ListadosFormasPagosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ListadosFormasPagosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ListadosFormasPagosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ListadosFormasPagosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ListadosFormasPagosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ListadosFormasPagosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ListadosFormasPagosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ListadosFormasPagosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Listados Formas Pagoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Listados Formas Pagos";
	public static final String SCLASSWEBTITULO_LOWER="Listados Formas Pagos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ListadosFormasPagos";
	public static final String OBJECTNAME="listadosformaspagos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="listados_formas_pagos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select listadosformaspagos from "+ListadosFormasPagosConstantesFunciones.SPERSISTENCENAME+" listadosformaspagos";
	public static String QUERYSELECTNATIVE="select "+ListadosFormasPagosConstantesFunciones.SCHEMA+"."+ListadosFormasPagosConstantesFunciones.TABLENAME+".id,"+ListadosFormasPagosConstantesFunciones.SCHEMA+"."+ListadosFormasPagosConstantesFunciones.TABLENAME+".version_row,"+ListadosFormasPagosConstantesFunciones.SCHEMA+"."+ListadosFormasPagosConstantesFunciones.TABLENAME+".id_tipo_grupo_forma_pago,"+ListadosFormasPagosConstantesFunciones.SCHEMA+"."+ListadosFormasPagosConstantesFunciones.TABLENAME+".id_empresa,"+ListadosFormasPagosConstantesFunciones.SCHEMA+"."+ListadosFormasPagosConstantesFunciones.TABLENAME+".id_sucursal,"+ListadosFormasPagosConstantesFunciones.SCHEMA+"."+ListadosFormasPagosConstantesFunciones.TABLENAME+".fecha_desde,"+ListadosFormasPagosConstantesFunciones.SCHEMA+"."+ListadosFormasPagosConstantesFunciones.TABLENAME+".fecha_hasta,"+ListadosFormasPagosConstantesFunciones.SCHEMA+"."+ListadosFormasPagosConstantesFunciones.TABLENAME+".codigo,"+ListadosFormasPagosConstantesFunciones.SCHEMA+"."+ListadosFormasPagosConstantesFunciones.TABLENAME+".nombre_completo,"+ListadosFormasPagosConstantesFunciones.SCHEMA+"."+ListadosFormasPagosConstantesFunciones.TABLENAME+".codigo_tipo_cuenta_banco_global,"+ListadosFormasPagosConstantesFunciones.SCHEMA+"."+ListadosFormasPagosConstantesFunciones.TABLENAME+".numero_cuenta,"+ListadosFormasPagosConstantesFunciones.SCHEMA+"."+ListadosFormasPagosConstantesFunciones.TABLENAME+".codigo_estado_anti_cliente,"+ListadosFormasPagosConstantesFunciones.SCHEMA+"."+ListadosFormasPagosConstantesFunciones.TABLENAME+".fecha,"+ListadosFormasPagosConstantesFunciones.SCHEMA+"."+ListadosFormasPagosConstantesFunciones.TABLENAME+".valor,"+ListadosFormasPagosConstantesFunciones.SCHEMA+"."+ListadosFormasPagosConstantesFunciones.TABLENAME+".valor_adicional,"+ListadosFormasPagosConstantesFunciones.SCHEMA+"."+ListadosFormasPagosConstantesFunciones.TABLENAME+".nombre_tipo_grupo_forma_pago,"+ListadosFormasPagosConstantesFunciones.SCHEMA+"."+ListadosFormasPagosConstantesFunciones.TABLENAME+".total from "+ListadosFormasPagosConstantesFunciones.SCHEMA+"."+ListadosFormasPagosConstantesFunciones.TABLENAME;//+" as "+ListadosFormasPagosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDTIPOGRUPOFORMAPAGO= "id_tipo_grupo_forma_pago";
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String FECHADESDE= "fecha_desde";
    public static final String FECHAHASTA= "fecha_hasta";
    public static final String CODIGO= "codigo";
    public static final String NOMBRECOMPLETO= "nombre_completo";
    public static final String CODIGOTIPOCUENTABANCOGLOBAL= "codigo_tipo_cuenta_banco_global";
    public static final String NUMEROCUENTA= "numero_cuenta";
    public static final String CODIGOESTADOANTICLIENTE= "codigo_estado_anti_cliente";
    public static final String FECHA= "fecha";
    public static final String VALOR= "valor";
    public static final String VALORADICIONAL= "valor_adicional";
    public static final String NOMBRETIPOGRUPOFORMAPAGO= "nombre_tipo_grupo_forma_pago";
    public static final String TOTAL= "total";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDTIPOGRUPOFORMAPAGO= "Tipo Grupo Forma Pago";
		public static final String LABEL_IDTIPOGRUPOFORMAPAGO_LOWER= "Tipo Grupo Forma Pago";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_FECHADESDE= "Fecha Desde";
		public static final String LABEL_FECHADESDE_LOWER= "Fecha Desde";
    	public static final String LABEL_FECHAHASTA= "Fecha Hasta";
		public static final String LABEL_FECHAHASTA_LOWER= "Fecha Hasta";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRECOMPLETO= "Nombre Completo";
		public static final String LABEL_NOMBRECOMPLETO_LOWER= "Nombre Completo";
    	public static final String LABEL_CODIGOTIPOCUENTABANCOGLOBAL= "Codigo Tipo Cuenta Banco Global";
		public static final String LABEL_CODIGOTIPOCUENTABANCOGLOBAL_LOWER= "Codigo Tipo Cuenta Banco Global";
    	public static final String LABEL_NUMEROCUENTA= "Numero Cuenta";
		public static final String LABEL_NUMEROCUENTA_LOWER= "Numero Cuenta";
    	public static final String LABEL_CODIGOESTADOANTICLIENTE= "Codigo Estado Anti Cliente";
		public static final String LABEL_CODIGOESTADOANTICLIENTE_LOWER= "Codigo Estado Anti Cliente";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_VALORADICIONAL= "Valor Adicional";
		public static final String LABEL_VALORADICIONAL_LOWER= "Valor Adicional";
    	public static final String LABEL_NOMBRETIPOGRUPOFORMAPAGO= "Nombre Tipo Grupo Forma Pago";
		public static final String LABEL_NOMBRETIPOGRUPOFORMAPAGO_LOWER= "Nombre Tipo Grupo Forma Pago";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
	
		
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_COMPLETO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_TIPO_CUENTA_BANCO_GLOBAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_TIPO_CUENTA_BANCO_GLOBAL=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_CUENTA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CUENTA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_ESTADO_ANTI_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_ESTADO_ANTI_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	public static final String SREGEXNOMBRE_TIPO_GRUPO_FORMA_PAGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_TIPO_GRUPO_FORMA_PAGO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getListadosFormasPagosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ListadosFormasPagosConstantesFunciones.IDTIPOGRUPOFORMAPAGO)) {sLabelColumna=ListadosFormasPagosConstantesFunciones.LABEL_IDTIPOGRUPOFORMAPAGO;}
		if(sNombreColumna.equals(ListadosFormasPagosConstantesFunciones.IDEMPRESA)) {sLabelColumna=ListadosFormasPagosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ListadosFormasPagosConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ListadosFormasPagosConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ListadosFormasPagosConstantesFunciones.FECHADESDE)) {sLabelColumna=ListadosFormasPagosConstantesFunciones.LABEL_FECHADESDE;}
		if(sNombreColumna.equals(ListadosFormasPagosConstantesFunciones.FECHAHASTA)) {sLabelColumna=ListadosFormasPagosConstantesFunciones.LABEL_FECHAHASTA;}
		if(sNombreColumna.equals(ListadosFormasPagosConstantesFunciones.CODIGO)) {sLabelColumna=ListadosFormasPagosConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ListadosFormasPagosConstantesFunciones.NOMBRECOMPLETO)) {sLabelColumna=ListadosFormasPagosConstantesFunciones.LABEL_NOMBRECOMPLETO;}
		if(sNombreColumna.equals(ListadosFormasPagosConstantesFunciones.CODIGOTIPOCUENTABANCOGLOBAL)) {sLabelColumna=ListadosFormasPagosConstantesFunciones.LABEL_CODIGOTIPOCUENTABANCOGLOBAL;}
		if(sNombreColumna.equals(ListadosFormasPagosConstantesFunciones.NUMEROCUENTA)) {sLabelColumna=ListadosFormasPagosConstantesFunciones.LABEL_NUMEROCUENTA;}
		if(sNombreColumna.equals(ListadosFormasPagosConstantesFunciones.CODIGOESTADOANTICLIENTE)) {sLabelColumna=ListadosFormasPagosConstantesFunciones.LABEL_CODIGOESTADOANTICLIENTE;}
		if(sNombreColumna.equals(ListadosFormasPagosConstantesFunciones.FECHA)) {sLabelColumna=ListadosFormasPagosConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(ListadosFormasPagosConstantesFunciones.VALOR)) {sLabelColumna=ListadosFormasPagosConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(ListadosFormasPagosConstantesFunciones.VALORADICIONAL)) {sLabelColumna=ListadosFormasPagosConstantesFunciones.LABEL_VALORADICIONAL;}
		if(sNombreColumna.equals(ListadosFormasPagosConstantesFunciones.NOMBRETIPOGRUPOFORMAPAGO)) {sLabelColumna=ListadosFormasPagosConstantesFunciones.LABEL_NOMBRETIPOGRUPOFORMAPAGO;}
		if(sNombreColumna.equals(ListadosFormasPagosConstantesFunciones.TOTAL)) {sLabelColumna=ListadosFormasPagosConstantesFunciones.LABEL_TOTAL;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getListadosFormasPagosDescripcion(ListadosFormasPagos listadosformaspagos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(listadosformaspagos !=null/* && listadosformaspagos.getId()!=0*/) {
			sDescripcion=listadosformaspagos.getcodigo();//listadosformaspagoslistadosformaspagos.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getListadosFormasPagosDescripcionDetallado(ListadosFormasPagos listadosformaspagos) {
		String sDescripcion="";
			
		sDescripcion+=ListadosFormasPagosConstantesFunciones.ID+"=";
		sDescripcion+=listadosformaspagos.getId().toString()+",";
		sDescripcion+=ListadosFormasPagosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=listadosformaspagos.getVersionRow().toString()+",";
		sDescripcion+=ListadosFormasPagosConstantesFunciones.IDTIPOGRUPOFORMAPAGO+"=";
		sDescripcion+=listadosformaspagos.getid_tipo_grupo_forma_pago().toString()+",";
		sDescripcion+=ListadosFormasPagosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=listadosformaspagos.getid_empresa().toString()+",";
		sDescripcion+=ListadosFormasPagosConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=listadosformaspagos.getid_sucursal().toString()+",";
		sDescripcion+=ListadosFormasPagosConstantesFunciones.FECHADESDE+"=";
		sDescripcion+=listadosformaspagos.getfecha_desde().toString()+",";
		sDescripcion+=ListadosFormasPagosConstantesFunciones.FECHAHASTA+"=";
		sDescripcion+=listadosformaspagos.getfecha_hasta().toString()+",";
		sDescripcion+=ListadosFormasPagosConstantesFunciones.CODIGO+"=";
		sDescripcion+=listadosformaspagos.getcodigo()+",";
		sDescripcion+=ListadosFormasPagosConstantesFunciones.NOMBRECOMPLETO+"=";
		sDescripcion+=listadosformaspagos.getnombre_completo()+",";
		sDescripcion+=ListadosFormasPagosConstantesFunciones.CODIGOTIPOCUENTABANCOGLOBAL+"=";
		sDescripcion+=listadosformaspagos.getcodigo_tipo_cuenta_banco_global()+",";
		sDescripcion+=ListadosFormasPagosConstantesFunciones.NUMEROCUENTA+"=";
		sDescripcion+=listadosformaspagos.getnumero_cuenta()+",";
		sDescripcion+=ListadosFormasPagosConstantesFunciones.CODIGOESTADOANTICLIENTE+"=";
		sDescripcion+=listadosformaspagos.getcodigo_estado_anti_cliente()+",";
		sDescripcion+=ListadosFormasPagosConstantesFunciones.FECHA+"=";
		sDescripcion+=listadosformaspagos.getfecha().toString()+",";
		sDescripcion+=ListadosFormasPagosConstantesFunciones.VALOR+"=";
		sDescripcion+=listadosformaspagos.getvalor().toString()+",";
		sDescripcion+=ListadosFormasPagosConstantesFunciones.VALORADICIONAL+"=";
		sDescripcion+=listadosformaspagos.getvalor_adicional().toString()+",";
		sDescripcion+=ListadosFormasPagosConstantesFunciones.NOMBRETIPOGRUPOFORMAPAGO+"=";
		sDescripcion+=listadosformaspagos.getnombre_tipo_grupo_forma_pago()+",";
		sDescripcion+=ListadosFormasPagosConstantesFunciones.TOTAL+"=";
		sDescripcion+=listadosformaspagos.gettotal().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setListadosFormasPagosDescripcion(ListadosFormasPagos listadosformaspagos,String sValor) throws Exception {			
		if(listadosformaspagos !=null) {
			listadosformaspagos.setcodigo(sValor);;//listadosformaspagoslistadosformaspagos.getcodigo().trim();
		}		
	}
	
		

	public static String getTipoGrupoFormaPagoDescripcion(TipoGrupoFormaPago tipogrupoformapago) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipogrupoformapago!=null/*&&tipogrupoformapago.getId()>0*/) {
			sDescripcion=TipoGrupoFormaPagoConstantesFunciones.getTipoGrupoFormaPagoDescripcion(tipogrupoformapago);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaListadosFormasPagos")) {
			sNombreIndice="Tipo=  Por Tipo Grupo Forma Pago Por Fecha Desde Por Fecha Hasta";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoGrupoFormaPago")) {
			sNombreIndice="Tipo=  Por Tipo Grupo Forma Pago";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaListadosFormasPagos(Long id_tipo_grupo_forma_pago,Date fecha_desde,Date fecha_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_grupo_forma_pago!=null) {sDetalleIndice+=" Codigo Unico De Tipo Grupo Forma Pago="+id_tipo_grupo_forma_pago.toString();}
		if(fecha_desde!=null) {sDetalleIndice+=" Fecha Desde="+fecha_desde.toString();}
		if(fecha_hasta!=null) {sDetalleIndice+=" Fecha Hasta="+fecha_hasta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoGrupoFormaPago(Long id_tipo_grupo_forma_pago) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_grupo_forma_pago!=null) {sDetalleIndice+=" Codigo Unico De Tipo Grupo Forma Pago="+id_tipo_grupo_forma_pago.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosListadosFormasPagos(ListadosFormasPagos listadosformaspagos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		listadosformaspagos.setcodigo(listadosformaspagos.getcodigo().trim());
		listadosformaspagos.setnombre_completo(listadosformaspagos.getnombre_completo().trim());
		listadosformaspagos.setcodigo_tipo_cuenta_banco_global(listadosformaspagos.getcodigo_tipo_cuenta_banco_global().trim());
		listadosformaspagos.setnumero_cuenta(listadosformaspagos.getnumero_cuenta().trim());
		listadosformaspagos.setcodigo_estado_anti_cliente(listadosformaspagos.getcodigo_estado_anti_cliente().trim());
		listadosformaspagos.setnombre_tipo_grupo_forma_pago(listadosformaspagos.getnombre_tipo_grupo_forma_pago().trim());
	}
	
	public static void quitarEspaciosListadosFormasPagoss(List<ListadosFormasPagos> listadosformaspagoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ListadosFormasPagos listadosformaspagos: listadosformaspagoss) {
			listadosformaspagos.setcodigo(listadosformaspagos.getcodigo().trim());
			listadosformaspagos.setnombre_completo(listadosformaspagos.getnombre_completo().trim());
			listadosformaspagos.setcodigo_tipo_cuenta_banco_global(listadosformaspagos.getcodigo_tipo_cuenta_banco_global().trim());
			listadosformaspagos.setnumero_cuenta(listadosformaspagos.getnumero_cuenta().trim());
			listadosformaspagos.setcodigo_estado_anti_cliente(listadosformaspagos.getcodigo_estado_anti_cliente().trim());
			listadosformaspagos.setnombre_tipo_grupo_forma_pago(listadosformaspagos.getnombre_tipo_grupo_forma_pago().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresListadosFormasPagos(ListadosFormasPagos listadosformaspagos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && listadosformaspagos.getConCambioAuxiliar()) {
			listadosformaspagos.setIsDeleted(listadosformaspagos.getIsDeletedAuxiliar());	
			listadosformaspagos.setIsNew(listadosformaspagos.getIsNewAuxiliar());	
			listadosformaspagos.setIsChanged(listadosformaspagos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			listadosformaspagos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			listadosformaspagos.setIsDeletedAuxiliar(false);	
			listadosformaspagos.setIsNewAuxiliar(false);	
			listadosformaspagos.setIsChangedAuxiliar(false);
			
			listadosformaspagos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresListadosFormasPagoss(List<ListadosFormasPagos> listadosformaspagoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ListadosFormasPagos listadosformaspagos : listadosformaspagoss) {
			if(conAsignarBase && listadosformaspagos.getConCambioAuxiliar()) {
				listadosformaspagos.setIsDeleted(listadosformaspagos.getIsDeletedAuxiliar());	
				listadosformaspagos.setIsNew(listadosformaspagos.getIsNewAuxiliar());	
				listadosformaspagos.setIsChanged(listadosformaspagos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				listadosformaspagos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				listadosformaspagos.setIsDeletedAuxiliar(false);	
				listadosformaspagos.setIsNewAuxiliar(false);	
				listadosformaspagos.setIsChangedAuxiliar(false);
				
				listadosformaspagos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresListadosFormasPagos(ListadosFormasPagos listadosformaspagos,Boolean conEnteros) throws Exception  {
		listadosformaspagos.setvalor(0.0);
		listadosformaspagos.setvalor_adicional(0.0);
		listadosformaspagos.settotal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresListadosFormasPagoss(List<ListadosFormasPagos> listadosformaspagoss,Boolean conEnteros) throws Exception  {
		
		for(ListadosFormasPagos listadosformaspagos: listadosformaspagoss) {
			listadosformaspagos.setvalor(0.0);
			listadosformaspagos.setvalor_adicional(0.0);
			listadosformaspagos.settotal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaListadosFormasPagos(List<ListadosFormasPagos> listadosformaspagoss,ListadosFormasPagos listadosformaspagosAux) throws Exception  {
		ListadosFormasPagosConstantesFunciones.InicializarValoresListadosFormasPagos(listadosformaspagosAux,true);
		
		for(ListadosFormasPagos listadosformaspagos: listadosformaspagoss) {
			if(listadosformaspagos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			listadosformaspagosAux.setvalor(listadosformaspagosAux.getvalor()+listadosformaspagos.getvalor());			
			listadosformaspagosAux.setvalor_adicional(listadosformaspagosAux.getvalor_adicional()+listadosformaspagos.getvalor_adicional());			
			listadosformaspagosAux.settotal(listadosformaspagosAux.gettotal()+listadosformaspagos.gettotal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesListadosFormasPagos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ListadosFormasPagosConstantesFunciones.getArrayColumnasGlobalesListadosFormasPagos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesListadosFormasPagos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ListadosFormasPagosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ListadosFormasPagosConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ListadosFormasPagosConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ListadosFormasPagosConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoListadosFormasPagos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ListadosFormasPagos> listadosformaspagoss,ListadosFormasPagos listadosformaspagos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ListadosFormasPagos listadosformaspagosAux: listadosformaspagoss) {
			if(listadosformaspagosAux!=null && listadosformaspagos!=null) {
				if((listadosformaspagosAux.getId()==null && listadosformaspagos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(listadosformaspagosAux.getId()!=null && listadosformaspagos.getId()!=null){
					if(listadosformaspagosAux.getId().equals(listadosformaspagos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaListadosFormasPagos(List<ListadosFormasPagos> listadosformaspagoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
		Double valor_adicionalTotal=0.0;
		Double totalTotal=0.0;
	
		for(ListadosFormasPagos listadosformaspagos: listadosformaspagoss) {			
			if(listadosformaspagos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=listadosformaspagos.getvalor();
			valor_adicionalTotal+=listadosformaspagos.getvalor_adicional();
			totalTotal+=listadosformaspagos.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ListadosFormasPagosConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(ListadosFormasPagosConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ListadosFormasPagosConstantesFunciones.VALORADICIONAL);
		datoGeneral.setsDescripcion(ListadosFormasPagosConstantesFunciones.LABEL_VALORADICIONAL);
		datoGeneral.setdValorDouble(valor_adicionalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ListadosFormasPagosConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(ListadosFormasPagosConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaListadosFormasPagos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ListadosFormasPagosConstantesFunciones.LABEL_ID, ListadosFormasPagosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosFormasPagosConstantesFunciones.LABEL_VERSIONROW, ListadosFormasPagosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosFormasPagosConstantesFunciones.LABEL_CODIGO, ListadosFormasPagosConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosFormasPagosConstantesFunciones.LABEL_NOMBRECOMPLETO, ListadosFormasPagosConstantesFunciones.NOMBRECOMPLETO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosFormasPagosConstantesFunciones.LABEL_CODIGOTIPOCUENTABANCOGLOBAL, ListadosFormasPagosConstantesFunciones.CODIGOTIPOCUENTABANCOGLOBAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosFormasPagosConstantesFunciones.LABEL_NUMEROCUENTA, ListadosFormasPagosConstantesFunciones.NUMEROCUENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosFormasPagosConstantesFunciones.LABEL_CODIGOESTADOANTICLIENTE, ListadosFormasPagosConstantesFunciones.CODIGOESTADOANTICLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosFormasPagosConstantesFunciones.LABEL_FECHA, ListadosFormasPagosConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosFormasPagosConstantesFunciones.LABEL_VALOR, ListadosFormasPagosConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosFormasPagosConstantesFunciones.LABEL_VALORADICIONAL, ListadosFormasPagosConstantesFunciones.VALORADICIONAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosFormasPagosConstantesFunciones.LABEL_NOMBRETIPOGRUPOFORMAPAGO, ListadosFormasPagosConstantesFunciones.NOMBRETIPOGRUPOFORMAPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosFormasPagosConstantesFunciones.LABEL_TOTAL, ListadosFormasPagosConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasListadosFormasPagos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ListadosFormasPagosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosFormasPagosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosFormasPagosConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosFormasPagosConstantesFunciones.NOMBRECOMPLETO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosFormasPagosConstantesFunciones.CODIGOTIPOCUENTABANCOGLOBAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosFormasPagosConstantesFunciones.NUMEROCUENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosFormasPagosConstantesFunciones.CODIGOESTADOANTICLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosFormasPagosConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosFormasPagosConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosFormasPagosConstantesFunciones.VALORADICIONAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosFormasPagosConstantesFunciones.NOMBRETIPOGRUPOFORMAPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosFormasPagosConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarListadosFormasPagos() throws Exception  {
		return ListadosFormasPagosConstantesFunciones.getTiposSeleccionarListadosFormasPagos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarListadosFormasPagos(Boolean conFk) throws Exception  {
		return ListadosFormasPagosConstantesFunciones.getTiposSeleccionarListadosFormasPagos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarListadosFormasPagos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosFormasPagosConstantesFunciones.LABEL_IDTIPOGRUPOFORMAPAGO);
			reporte.setsDescripcion(ListadosFormasPagosConstantesFunciones.LABEL_IDTIPOGRUPOFORMAPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosFormasPagosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ListadosFormasPagosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosFormasPagosConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ListadosFormasPagosConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosFormasPagosConstantesFunciones.LABEL_FECHADESDE);
			reporte.setsDescripcion(ListadosFormasPagosConstantesFunciones.LABEL_FECHADESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosFormasPagosConstantesFunciones.LABEL_FECHAHASTA);
			reporte.setsDescripcion(ListadosFormasPagosConstantesFunciones.LABEL_FECHAHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosFormasPagosConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ListadosFormasPagosConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosFormasPagosConstantesFunciones.LABEL_NOMBRECOMPLETO);
			reporte.setsDescripcion(ListadosFormasPagosConstantesFunciones.LABEL_NOMBRECOMPLETO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosFormasPagosConstantesFunciones.LABEL_CODIGOTIPOCUENTABANCOGLOBAL);
			reporte.setsDescripcion(ListadosFormasPagosConstantesFunciones.LABEL_CODIGOTIPOCUENTABANCOGLOBAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosFormasPagosConstantesFunciones.LABEL_NUMEROCUENTA);
			reporte.setsDescripcion(ListadosFormasPagosConstantesFunciones.LABEL_NUMEROCUENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosFormasPagosConstantesFunciones.LABEL_CODIGOESTADOANTICLIENTE);
			reporte.setsDescripcion(ListadosFormasPagosConstantesFunciones.LABEL_CODIGOESTADOANTICLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosFormasPagosConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(ListadosFormasPagosConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosFormasPagosConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(ListadosFormasPagosConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosFormasPagosConstantesFunciones.LABEL_VALORADICIONAL);
			reporte.setsDescripcion(ListadosFormasPagosConstantesFunciones.LABEL_VALORADICIONAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosFormasPagosConstantesFunciones.LABEL_NOMBRETIPOGRUPOFORMAPAGO);
			reporte.setsDescripcion(ListadosFormasPagosConstantesFunciones.LABEL_NOMBRETIPOGRUPOFORMAPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosFormasPagosConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(ListadosFormasPagosConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesListadosFormasPagos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesListadosFormasPagos(ListadosFormasPagos listadosformaspagosAux) throws Exception {
		
			listadosformaspagosAux.settipogrupoformapago_descripcion(TipoGrupoFormaPagoConstantesFunciones.getTipoGrupoFormaPagoDescripcion(listadosformaspagosAux.getTipoGrupoFormaPago()));
			listadosformaspagosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(listadosformaspagosAux.getEmpresa()));
			listadosformaspagosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(listadosformaspagosAux.getSucursal()));		
	}
	
	public static void refrescarForeignKeysDescripcionesListadosFormasPagos(List<ListadosFormasPagos> listadosformaspagossTemp) throws Exception {
		for(ListadosFormasPagos listadosformaspagosAux:listadosformaspagossTemp) {
			
			listadosformaspagosAux.settipogrupoformapago_descripcion(TipoGrupoFormaPagoConstantesFunciones.getTipoGrupoFormaPagoDescripcion(listadosformaspagosAux.getTipoGrupoFormaPago()));
			listadosformaspagosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(listadosformaspagosAux.getEmpresa()));
			listadosformaspagosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(listadosformaspagosAux.getSucursal()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfListadosFormasPagos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(TipoGrupoFormaPago.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoGrupoFormaPago.class)) {
						classes.add(new Classe(TipoGrupoFormaPago.class));
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfListadosFormasPagos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(TipoGrupoFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoGrupoFormaPago.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(TipoGrupoFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoGrupoFormaPago.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfListadosFormasPagos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ListadosFormasPagosConstantesFunciones.getClassesRelationshipsOfListadosFormasPagos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfListadosFormasPagos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfListadosFormasPagos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ListadosFormasPagosConstantesFunciones.getClassesRelationshipsFromStringsOfListadosFormasPagos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfListadosFormasPagos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ListadosFormasPagos listadosformaspagos,List<ListadosFormasPagos> listadosformaspagoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ListadosFormasPagos listadosformaspagos,List<ListadosFormasPagos> listadosformaspagoss) throws Exception {
		try	{			
			for(ListadosFormasPagos listadosformaspagosLocal:listadosformaspagoss) {
				if(listadosformaspagosLocal.getId().equals(listadosformaspagos.getId())) {
					listadosformaspagosLocal.setIsSelected(listadosformaspagos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesListadosFormasPagos(List<ListadosFormasPagos> listadosformaspagossAux) throws Exception {
		//this.listadosformaspagossAux=listadosformaspagossAux;
		
		for(ListadosFormasPagos listadosformaspagosAux:listadosformaspagossAux) {
			if(listadosformaspagosAux.getIsChanged()) {
				listadosformaspagosAux.setIsChanged(false);
			}		
			
			if(listadosformaspagosAux.getIsNew()) {
				listadosformaspagosAux.setIsNew(false);
			}	
			
			if(listadosformaspagosAux.getIsDeleted()) {
				listadosformaspagosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesListadosFormasPagos(ListadosFormasPagos listadosformaspagosAux) throws Exception {
		//this.listadosformaspagosAux=listadosformaspagosAux;
		
			if(listadosformaspagosAux.getIsChanged()) {
				listadosformaspagosAux.setIsChanged(false);
			}		
			
			if(listadosformaspagosAux.getIsNew()) {
				listadosformaspagosAux.setIsNew(false);
			}	
			
			if(listadosformaspagosAux.getIsDeleted()) {
				listadosformaspagosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ListadosFormasPagos listadosformaspagosAsignar,ListadosFormasPagos listadosformaspagos) throws Exception {
		listadosformaspagosAsignar.setId(listadosformaspagos.getId());	
		listadosformaspagosAsignar.setVersionRow(listadosformaspagos.getVersionRow());	
		listadosformaspagosAsignar.setcodigo(listadosformaspagos.getcodigo());	
		listadosformaspagosAsignar.setnombre_completo(listadosformaspagos.getnombre_completo());	
		listadosformaspagosAsignar.setcodigo_tipo_cuenta_banco_global(listadosformaspagos.getcodigo_tipo_cuenta_banco_global());	
		listadosformaspagosAsignar.setnumero_cuenta(listadosformaspagos.getnumero_cuenta());	
		listadosformaspagosAsignar.setcodigo_estado_anti_cliente(listadosformaspagos.getcodigo_estado_anti_cliente());	
		listadosformaspagosAsignar.setfecha(listadosformaspagos.getfecha());	
		listadosformaspagosAsignar.setvalor(listadosformaspagos.getvalor());	
		listadosformaspagosAsignar.setvalor_adicional(listadosformaspagos.getvalor_adicional());	
		listadosformaspagosAsignar.setnombre_tipo_grupo_forma_pago(listadosformaspagos.getnombre_tipo_grupo_forma_pago());	
		listadosformaspagosAsignar.settotal(listadosformaspagos.gettotal());	
	}
	
	public static void inicializarListadosFormasPagos(ListadosFormasPagos listadosformaspagos) throws Exception {
		try {
				listadosformaspagos.setId(0L);	
					
				listadosformaspagos.setcodigo("");	
				listadosformaspagos.setnombre_completo("");	
				listadosformaspagos.setcodigo_tipo_cuenta_banco_global("");	
				listadosformaspagos.setnumero_cuenta("");	
				listadosformaspagos.setcodigo_estado_anti_cliente("");	
				listadosformaspagos.setfecha(new Date());	
				listadosformaspagos.setvalor(0.0);	
				listadosformaspagos.setvalor_adicional(0.0);	
				listadosformaspagos.setnombre_tipo_grupo_forma_pago("");	
				listadosformaspagos.settotal(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderListadosFormasPagos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosFormasPagosConstantesFunciones.LABEL_IDTIPOGRUPOFORMAPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosFormasPagosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosFormasPagosConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosFormasPagosConstantesFunciones.LABEL_FECHADESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosFormasPagosConstantesFunciones.LABEL_FECHAHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosFormasPagosConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosFormasPagosConstantesFunciones.LABEL_NOMBRECOMPLETO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosFormasPagosConstantesFunciones.LABEL_CODIGOTIPOCUENTABANCOGLOBAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosFormasPagosConstantesFunciones.LABEL_NUMEROCUENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosFormasPagosConstantesFunciones.LABEL_CODIGOESTADOANTICLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosFormasPagosConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosFormasPagosConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosFormasPagosConstantesFunciones.LABEL_VALORADICIONAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosFormasPagosConstantesFunciones.LABEL_NOMBRETIPOGRUPOFORMAPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosFormasPagosConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataListadosFormasPagos(String sTipo,Row row,Workbook workbook,ListadosFormasPagos listadosformaspagos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosformaspagos.gettipogrupoformapago_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosformaspagos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosformaspagos.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosformaspagos.getfecha_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosformaspagos.getfecha_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosformaspagos.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosformaspagos.getnombre_completo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosformaspagos.getcodigo_tipo_cuenta_banco_global());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosformaspagos.getnumero_cuenta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosformaspagos.getcodigo_estado_anti_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosformaspagos.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosformaspagos.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosformaspagos.getvalor_adicional());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosformaspagos.getnombre_tipo_grupo_forma_pago());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosformaspagos.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryListadosFormasPagos="";
	
	public String getsFinalQueryListadosFormasPagos() {
		return this.sFinalQueryListadosFormasPagos;
	}
	
	public void setsFinalQueryListadosFormasPagos(String sFinalQueryListadosFormasPagos) {
		this.sFinalQueryListadosFormasPagos= sFinalQueryListadosFormasPagos;
	}
	
	public Border resaltarSeleccionarListadosFormasPagos=null;
	
	public Border setResaltarSeleccionarListadosFormasPagos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosFormasPagosBeanSwingJInternalFrame listadosformaspagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//listadosformaspagosBeanSwingJInternalFrame.jTtoolBarListadosFormasPagos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarListadosFormasPagos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarListadosFormasPagos() {
		return this.resaltarSeleccionarListadosFormasPagos;
	}
	
	public void setResaltarSeleccionarListadosFormasPagos(Border borderResaltarSeleccionarListadosFormasPagos) {
		this.resaltarSeleccionarListadosFormasPagos= borderResaltarSeleccionarListadosFormasPagos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridListadosFormasPagos=null;
	public Boolean mostraridListadosFormasPagos=true;
	public Boolean activaridListadosFormasPagos=true;

	public Border resaltarid_tipo_grupo_forma_pagoListadosFormasPagos=null;
	public Boolean mostrarid_tipo_grupo_forma_pagoListadosFormasPagos=true;
	public Boolean activarid_tipo_grupo_forma_pagoListadosFormasPagos=true;
	public Boolean cargarid_tipo_grupo_forma_pagoListadosFormasPagos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_grupo_forma_pagoListadosFormasPagos=false;//ConEventDepend=true

	public Border resaltarid_empresaListadosFormasPagos=null;
	public Boolean mostrarid_empresaListadosFormasPagos=true;
	public Boolean activarid_empresaListadosFormasPagos=true;
	public Boolean cargarid_empresaListadosFormasPagos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaListadosFormasPagos=false;//ConEventDepend=true

	public Border resaltarid_sucursalListadosFormasPagos=null;
	public Boolean mostrarid_sucursalListadosFormasPagos=true;
	public Boolean activarid_sucursalListadosFormasPagos=true;
	public Boolean cargarid_sucursalListadosFormasPagos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalListadosFormasPagos=false;//ConEventDepend=true

	public Border resaltarfecha_desdeListadosFormasPagos=null;
	public Boolean mostrarfecha_desdeListadosFormasPagos=true;
	public Boolean activarfecha_desdeListadosFormasPagos=true;

	public Border resaltarfecha_hastaListadosFormasPagos=null;
	public Boolean mostrarfecha_hastaListadosFormasPagos=true;
	public Boolean activarfecha_hastaListadosFormasPagos=true;

	public Border resaltarcodigoListadosFormasPagos=null;
	public Boolean mostrarcodigoListadosFormasPagos=true;
	public Boolean activarcodigoListadosFormasPagos=true;

	public Border resaltarnombre_completoListadosFormasPagos=null;
	public Boolean mostrarnombre_completoListadosFormasPagos=true;
	public Boolean activarnombre_completoListadosFormasPagos=true;

	public Border resaltarcodigo_tipo_cuenta_banco_globalListadosFormasPagos=null;
	public Boolean mostrarcodigo_tipo_cuenta_banco_globalListadosFormasPagos=true;
	public Boolean activarcodigo_tipo_cuenta_banco_globalListadosFormasPagos=true;

	public Border resaltarnumero_cuentaListadosFormasPagos=null;
	public Boolean mostrarnumero_cuentaListadosFormasPagos=true;
	public Boolean activarnumero_cuentaListadosFormasPagos=true;

	public Border resaltarcodigo_estado_anti_clienteListadosFormasPagos=null;
	public Boolean mostrarcodigo_estado_anti_clienteListadosFormasPagos=true;
	public Boolean activarcodigo_estado_anti_clienteListadosFormasPagos=true;

	public Border resaltarfechaListadosFormasPagos=null;
	public Boolean mostrarfechaListadosFormasPagos=true;
	public Boolean activarfechaListadosFormasPagos=true;

	public Border resaltarvalorListadosFormasPagos=null;
	public Boolean mostrarvalorListadosFormasPagos=true;
	public Boolean activarvalorListadosFormasPagos=true;

	public Border resaltarvalor_adicionalListadosFormasPagos=null;
	public Boolean mostrarvalor_adicionalListadosFormasPagos=true;
	public Boolean activarvalor_adicionalListadosFormasPagos=true;

	public Border resaltarnombre_tipo_grupo_forma_pagoListadosFormasPagos=null;
	public Boolean mostrarnombre_tipo_grupo_forma_pagoListadosFormasPagos=true;
	public Boolean activarnombre_tipo_grupo_forma_pagoListadosFormasPagos=true;

	public Border resaltartotalListadosFormasPagos=null;
	public Boolean mostrartotalListadosFormasPagos=true;
	public Boolean activartotalListadosFormasPagos=true;

	
	

	public Border setResaltaridListadosFormasPagos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosFormasPagosBeanSwingJInternalFrame listadosformaspagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosformaspagosBeanSwingJInternalFrame.jTtoolBarListadosFormasPagos.setBorder(borderResaltar);
		
		this.resaltaridListadosFormasPagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridListadosFormasPagos() {
		return this.resaltaridListadosFormasPagos;
	}

	public void setResaltaridListadosFormasPagos(Border borderResaltar) {
		this.resaltaridListadosFormasPagos= borderResaltar;
	}

	public Boolean getMostraridListadosFormasPagos() {
		return this.mostraridListadosFormasPagos;
	}

	public void setMostraridListadosFormasPagos(Boolean mostraridListadosFormasPagos) {
		this.mostraridListadosFormasPagos= mostraridListadosFormasPagos;
	}

	public Boolean getActivaridListadosFormasPagos() {
		return this.activaridListadosFormasPagos;
	}

	public void setActivaridListadosFormasPagos(Boolean activaridListadosFormasPagos) {
		this.activaridListadosFormasPagos= activaridListadosFormasPagos;
	}

	public Border setResaltarid_tipo_grupo_forma_pagoListadosFormasPagos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosFormasPagosBeanSwingJInternalFrame listadosformaspagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosformaspagosBeanSwingJInternalFrame.jTtoolBarListadosFormasPagos.setBorder(borderResaltar);
		
		this.resaltarid_tipo_grupo_forma_pagoListadosFormasPagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_grupo_forma_pagoListadosFormasPagos() {
		return this.resaltarid_tipo_grupo_forma_pagoListadosFormasPagos;
	}

	public void setResaltarid_tipo_grupo_forma_pagoListadosFormasPagos(Border borderResaltar) {
		this.resaltarid_tipo_grupo_forma_pagoListadosFormasPagos= borderResaltar;
	}

	public Boolean getMostrarid_tipo_grupo_forma_pagoListadosFormasPagos() {
		return this.mostrarid_tipo_grupo_forma_pagoListadosFormasPagos;
	}

	public void setMostrarid_tipo_grupo_forma_pagoListadosFormasPagos(Boolean mostrarid_tipo_grupo_forma_pagoListadosFormasPagos) {
		this.mostrarid_tipo_grupo_forma_pagoListadosFormasPagos= mostrarid_tipo_grupo_forma_pagoListadosFormasPagos;
	}

	public Boolean getActivarid_tipo_grupo_forma_pagoListadosFormasPagos() {
		return this.activarid_tipo_grupo_forma_pagoListadosFormasPagos;
	}

	public void setActivarid_tipo_grupo_forma_pagoListadosFormasPagos(Boolean activarid_tipo_grupo_forma_pagoListadosFormasPagos) {
		this.activarid_tipo_grupo_forma_pagoListadosFormasPagos= activarid_tipo_grupo_forma_pagoListadosFormasPagos;
	}

	public Boolean getCargarid_tipo_grupo_forma_pagoListadosFormasPagos() {
		return this.cargarid_tipo_grupo_forma_pagoListadosFormasPagos;
	}

	public void setCargarid_tipo_grupo_forma_pagoListadosFormasPagos(Boolean cargarid_tipo_grupo_forma_pagoListadosFormasPagos) {
		this.cargarid_tipo_grupo_forma_pagoListadosFormasPagos= cargarid_tipo_grupo_forma_pagoListadosFormasPagos;
	}

	public Border setResaltarid_empresaListadosFormasPagos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosFormasPagosBeanSwingJInternalFrame listadosformaspagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosformaspagosBeanSwingJInternalFrame.jTtoolBarListadosFormasPagos.setBorder(borderResaltar);
		
		this.resaltarid_empresaListadosFormasPagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaListadosFormasPagos() {
		return this.resaltarid_empresaListadosFormasPagos;
	}

	public void setResaltarid_empresaListadosFormasPagos(Border borderResaltar) {
		this.resaltarid_empresaListadosFormasPagos= borderResaltar;
	}

	public Boolean getMostrarid_empresaListadosFormasPagos() {
		return this.mostrarid_empresaListadosFormasPagos;
	}

	public void setMostrarid_empresaListadosFormasPagos(Boolean mostrarid_empresaListadosFormasPagos) {
		this.mostrarid_empresaListadosFormasPagos= mostrarid_empresaListadosFormasPagos;
	}

	public Boolean getActivarid_empresaListadosFormasPagos() {
		return this.activarid_empresaListadosFormasPagos;
	}

	public void setActivarid_empresaListadosFormasPagos(Boolean activarid_empresaListadosFormasPagos) {
		this.activarid_empresaListadosFormasPagos= activarid_empresaListadosFormasPagos;
	}

	public Boolean getCargarid_empresaListadosFormasPagos() {
		return this.cargarid_empresaListadosFormasPagos;
	}

	public void setCargarid_empresaListadosFormasPagos(Boolean cargarid_empresaListadosFormasPagos) {
		this.cargarid_empresaListadosFormasPagos= cargarid_empresaListadosFormasPagos;
	}

	public Border setResaltarid_sucursalListadosFormasPagos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosFormasPagosBeanSwingJInternalFrame listadosformaspagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosformaspagosBeanSwingJInternalFrame.jTtoolBarListadosFormasPagos.setBorder(borderResaltar);
		
		this.resaltarid_sucursalListadosFormasPagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalListadosFormasPagos() {
		return this.resaltarid_sucursalListadosFormasPagos;
	}

	public void setResaltarid_sucursalListadosFormasPagos(Border borderResaltar) {
		this.resaltarid_sucursalListadosFormasPagos= borderResaltar;
	}

	public Boolean getMostrarid_sucursalListadosFormasPagos() {
		return this.mostrarid_sucursalListadosFormasPagos;
	}

	public void setMostrarid_sucursalListadosFormasPagos(Boolean mostrarid_sucursalListadosFormasPagos) {
		this.mostrarid_sucursalListadosFormasPagos= mostrarid_sucursalListadosFormasPagos;
	}

	public Boolean getActivarid_sucursalListadosFormasPagos() {
		return this.activarid_sucursalListadosFormasPagos;
	}

	public void setActivarid_sucursalListadosFormasPagos(Boolean activarid_sucursalListadosFormasPagos) {
		this.activarid_sucursalListadosFormasPagos= activarid_sucursalListadosFormasPagos;
	}

	public Boolean getCargarid_sucursalListadosFormasPagos() {
		return this.cargarid_sucursalListadosFormasPagos;
	}

	public void setCargarid_sucursalListadosFormasPagos(Boolean cargarid_sucursalListadosFormasPagos) {
		this.cargarid_sucursalListadosFormasPagos= cargarid_sucursalListadosFormasPagos;
	}

	public Border setResaltarfecha_desdeListadosFormasPagos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosFormasPagosBeanSwingJInternalFrame listadosformaspagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosformaspagosBeanSwingJInternalFrame.jTtoolBarListadosFormasPagos.setBorder(borderResaltar);
		
		this.resaltarfecha_desdeListadosFormasPagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_desdeListadosFormasPagos() {
		return this.resaltarfecha_desdeListadosFormasPagos;
	}

	public void setResaltarfecha_desdeListadosFormasPagos(Border borderResaltar) {
		this.resaltarfecha_desdeListadosFormasPagos= borderResaltar;
	}

	public Boolean getMostrarfecha_desdeListadosFormasPagos() {
		return this.mostrarfecha_desdeListadosFormasPagos;
	}

	public void setMostrarfecha_desdeListadosFormasPagos(Boolean mostrarfecha_desdeListadosFormasPagos) {
		this.mostrarfecha_desdeListadosFormasPagos= mostrarfecha_desdeListadosFormasPagos;
	}

	public Boolean getActivarfecha_desdeListadosFormasPagos() {
		return this.activarfecha_desdeListadosFormasPagos;
	}

	public void setActivarfecha_desdeListadosFormasPagos(Boolean activarfecha_desdeListadosFormasPagos) {
		this.activarfecha_desdeListadosFormasPagos= activarfecha_desdeListadosFormasPagos;
	}

	public Border setResaltarfecha_hastaListadosFormasPagos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosFormasPagosBeanSwingJInternalFrame listadosformaspagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosformaspagosBeanSwingJInternalFrame.jTtoolBarListadosFormasPagos.setBorder(borderResaltar);
		
		this.resaltarfecha_hastaListadosFormasPagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_hastaListadosFormasPagos() {
		return this.resaltarfecha_hastaListadosFormasPagos;
	}

	public void setResaltarfecha_hastaListadosFormasPagos(Border borderResaltar) {
		this.resaltarfecha_hastaListadosFormasPagos= borderResaltar;
	}

	public Boolean getMostrarfecha_hastaListadosFormasPagos() {
		return this.mostrarfecha_hastaListadosFormasPagos;
	}

	public void setMostrarfecha_hastaListadosFormasPagos(Boolean mostrarfecha_hastaListadosFormasPagos) {
		this.mostrarfecha_hastaListadosFormasPagos= mostrarfecha_hastaListadosFormasPagos;
	}

	public Boolean getActivarfecha_hastaListadosFormasPagos() {
		return this.activarfecha_hastaListadosFormasPagos;
	}

	public void setActivarfecha_hastaListadosFormasPagos(Boolean activarfecha_hastaListadosFormasPagos) {
		this.activarfecha_hastaListadosFormasPagos= activarfecha_hastaListadosFormasPagos;
	}

	public Border setResaltarcodigoListadosFormasPagos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosFormasPagosBeanSwingJInternalFrame listadosformaspagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosformaspagosBeanSwingJInternalFrame.jTtoolBarListadosFormasPagos.setBorder(borderResaltar);
		
		this.resaltarcodigoListadosFormasPagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoListadosFormasPagos() {
		return this.resaltarcodigoListadosFormasPagos;
	}

	public void setResaltarcodigoListadosFormasPagos(Border borderResaltar) {
		this.resaltarcodigoListadosFormasPagos= borderResaltar;
	}

	public Boolean getMostrarcodigoListadosFormasPagos() {
		return this.mostrarcodigoListadosFormasPagos;
	}

	public void setMostrarcodigoListadosFormasPagos(Boolean mostrarcodigoListadosFormasPagos) {
		this.mostrarcodigoListadosFormasPagos= mostrarcodigoListadosFormasPagos;
	}

	public Boolean getActivarcodigoListadosFormasPagos() {
		return this.activarcodigoListadosFormasPagos;
	}

	public void setActivarcodigoListadosFormasPagos(Boolean activarcodigoListadosFormasPagos) {
		this.activarcodigoListadosFormasPagos= activarcodigoListadosFormasPagos;
	}

	public Border setResaltarnombre_completoListadosFormasPagos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosFormasPagosBeanSwingJInternalFrame listadosformaspagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosformaspagosBeanSwingJInternalFrame.jTtoolBarListadosFormasPagos.setBorder(borderResaltar);
		
		this.resaltarnombre_completoListadosFormasPagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completoListadosFormasPagos() {
		return this.resaltarnombre_completoListadosFormasPagos;
	}

	public void setResaltarnombre_completoListadosFormasPagos(Border borderResaltar) {
		this.resaltarnombre_completoListadosFormasPagos= borderResaltar;
	}

	public Boolean getMostrarnombre_completoListadosFormasPagos() {
		return this.mostrarnombre_completoListadosFormasPagos;
	}

	public void setMostrarnombre_completoListadosFormasPagos(Boolean mostrarnombre_completoListadosFormasPagos) {
		this.mostrarnombre_completoListadosFormasPagos= mostrarnombre_completoListadosFormasPagos;
	}

	public Boolean getActivarnombre_completoListadosFormasPagos() {
		return this.activarnombre_completoListadosFormasPagos;
	}

	public void setActivarnombre_completoListadosFormasPagos(Boolean activarnombre_completoListadosFormasPagos) {
		this.activarnombre_completoListadosFormasPagos= activarnombre_completoListadosFormasPagos;
	}

	public Border setResaltarcodigo_tipo_cuenta_banco_globalListadosFormasPagos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosFormasPagosBeanSwingJInternalFrame listadosformaspagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosformaspagosBeanSwingJInternalFrame.jTtoolBarListadosFormasPagos.setBorder(borderResaltar);
		
		this.resaltarcodigo_tipo_cuenta_banco_globalListadosFormasPagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_tipo_cuenta_banco_globalListadosFormasPagos() {
		return this.resaltarcodigo_tipo_cuenta_banco_globalListadosFormasPagos;
	}

	public void setResaltarcodigo_tipo_cuenta_banco_globalListadosFormasPagos(Border borderResaltar) {
		this.resaltarcodigo_tipo_cuenta_banco_globalListadosFormasPagos= borderResaltar;
	}

	public Boolean getMostrarcodigo_tipo_cuenta_banco_globalListadosFormasPagos() {
		return this.mostrarcodigo_tipo_cuenta_banco_globalListadosFormasPagos;
	}

	public void setMostrarcodigo_tipo_cuenta_banco_globalListadosFormasPagos(Boolean mostrarcodigo_tipo_cuenta_banco_globalListadosFormasPagos) {
		this.mostrarcodigo_tipo_cuenta_banco_globalListadosFormasPagos= mostrarcodigo_tipo_cuenta_banco_globalListadosFormasPagos;
	}

	public Boolean getActivarcodigo_tipo_cuenta_banco_globalListadosFormasPagos() {
		return this.activarcodigo_tipo_cuenta_banco_globalListadosFormasPagos;
	}

	public void setActivarcodigo_tipo_cuenta_banco_globalListadosFormasPagos(Boolean activarcodigo_tipo_cuenta_banco_globalListadosFormasPagos) {
		this.activarcodigo_tipo_cuenta_banco_globalListadosFormasPagos= activarcodigo_tipo_cuenta_banco_globalListadosFormasPagos;
	}

	public Border setResaltarnumero_cuentaListadosFormasPagos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosFormasPagosBeanSwingJInternalFrame listadosformaspagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosformaspagosBeanSwingJInternalFrame.jTtoolBarListadosFormasPagos.setBorder(borderResaltar);
		
		this.resaltarnumero_cuentaListadosFormasPagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_cuentaListadosFormasPagos() {
		return this.resaltarnumero_cuentaListadosFormasPagos;
	}

	public void setResaltarnumero_cuentaListadosFormasPagos(Border borderResaltar) {
		this.resaltarnumero_cuentaListadosFormasPagos= borderResaltar;
	}

	public Boolean getMostrarnumero_cuentaListadosFormasPagos() {
		return this.mostrarnumero_cuentaListadosFormasPagos;
	}

	public void setMostrarnumero_cuentaListadosFormasPagos(Boolean mostrarnumero_cuentaListadosFormasPagos) {
		this.mostrarnumero_cuentaListadosFormasPagos= mostrarnumero_cuentaListadosFormasPagos;
	}

	public Boolean getActivarnumero_cuentaListadosFormasPagos() {
		return this.activarnumero_cuentaListadosFormasPagos;
	}

	public void setActivarnumero_cuentaListadosFormasPagos(Boolean activarnumero_cuentaListadosFormasPagos) {
		this.activarnumero_cuentaListadosFormasPagos= activarnumero_cuentaListadosFormasPagos;
	}

	public Border setResaltarcodigo_estado_anti_clienteListadosFormasPagos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosFormasPagosBeanSwingJInternalFrame listadosformaspagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosformaspagosBeanSwingJInternalFrame.jTtoolBarListadosFormasPagos.setBorder(borderResaltar);
		
		this.resaltarcodigo_estado_anti_clienteListadosFormasPagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_estado_anti_clienteListadosFormasPagos() {
		return this.resaltarcodigo_estado_anti_clienteListadosFormasPagos;
	}

	public void setResaltarcodigo_estado_anti_clienteListadosFormasPagos(Border borderResaltar) {
		this.resaltarcodigo_estado_anti_clienteListadosFormasPagos= borderResaltar;
	}

	public Boolean getMostrarcodigo_estado_anti_clienteListadosFormasPagos() {
		return this.mostrarcodigo_estado_anti_clienteListadosFormasPagos;
	}

	public void setMostrarcodigo_estado_anti_clienteListadosFormasPagos(Boolean mostrarcodigo_estado_anti_clienteListadosFormasPagos) {
		this.mostrarcodigo_estado_anti_clienteListadosFormasPagos= mostrarcodigo_estado_anti_clienteListadosFormasPagos;
	}

	public Boolean getActivarcodigo_estado_anti_clienteListadosFormasPagos() {
		return this.activarcodigo_estado_anti_clienteListadosFormasPagos;
	}

	public void setActivarcodigo_estado_anti_clienteListadosFormasPagos(Boolean activarcodigo_estado_anti_clienteListadosFormasPagos) {
		this.activarcodigo_estado_anti_clienteListadosFormasPagos= activarcodigo_estado_anti_clienteListadosFormasPagos;
	}

	public Border setResaltarfechaListadosFormasPagos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosFormasPagosBeanSwingJInternalFrame listadosformaspagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosformaspagosBeanSwingJInternalFrame.jTtoolBarListadosFormasPagos.setBorder(borderResaltar);
		
		this.resaltarfechaListadosFormasPagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaListadosFormasPagos() {
		return this.resaltarfechaListadosFormasPagos;
	}

	public void setResaltarfechaListadosFormasPagos(Border borderResaltar) {
		this.resaltarfechaListadosFormasPagos= borderResaltar;
	}

	public Boolean getMostrarfechaListadosFormasPagos() {
		return this.mostrarfechaListadosFormasPagos;
	}

	public void setMostrarfechaListadosFormasPagos(Boolean mostrarfechaListadosFormasPagos) {
		this.mostrarfechaListadosFormasPagos= mostrarfechaListadosFormasPagos;
	}

	public Boolean getActivarfechaListadosFormasPagos() {
		return this.activarfechaListadosFormasPagos;
	}

	public void setActivarfechaListadosFormasPagos(Boolean activarfechaListadosFormasPagos) {
		this.activarfechaListadosFormasPagos= activarfechaListadosFormasPagos;
	}

	public Border setResaltarvalorListadosFormasPagos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosFormasPagosBeanSwingJInternalFrame listadosformaspagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosformaspagosBeanSwingJInternalFrame.jTtoolBarListadosFormasPagos.setBorder(borderResaltar);
		
		this.resaltarvalorListadosFormasPagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorListadosFormasPagos() {
		return this.resaltarvalorListadosFormasPagos;
	}

	public void setResaltarvalorListadosFormasPagos(Border borderResaltar) {
		this.resaltarvalorListadosFormasPagos= borderResaltar;
	}

	public Boolean getMostrarvalorListadosFormasPagos() {
		return this.mostrarvalorListadosFormasPagos;
	}

	public void setMostrarvalorListadosFormasPagos(Boolean mostrarvalorListadosFormasPagos) {
		this.mostrarvalorListadosFormasPagos= mostrarvalorListadosFormasPagos;
	}

	public Boolean getActivarvalorListadosFormasPagos() {
		return this.activarvalorListadosFormasPagos;
	}

	public void setActivarvalorListadosFormasPagos(Boolean activarvalorListadosFormasPagos) {
		this.activarvalorListadosFormasPagos= activarvalorListadosFormasPagos;
	}

	public Border setResaltarvalor_adicionalListadosFormasPagos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosFormasPagosBeanSwingJInternalFrame listadosformaspagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosformaspagosBeanSwingJInternalFrame.jTtoolBarListadosFormasPagos.setBorder(borderResaltar);
		
		this.resaltarvalor_adicionalListadosFormasPagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_adicionalListadosFormasPagos() {
		return this.resaltarvalor_adicionalListadosFormasPagos;
	}

	public void setResaltarvalor_adicionalListadosFormasPagos(Border borderResaltar) {
		this.resaltarvalor_adicionalListadosFormasPagos= borderResaltar;
	}

	public Boolean getMostrarvalor_adicionalListadosFormasPagos() {
		return this.mostrarvalor_adicionalListadosFormasPagos;
	}

	public void setMostrarvalor_adicionalListadosFormasPagos(Boolean mostrarvalor_adicionalListadosFormasPagos) {
		this.mostrarvalor_adicionalListadosFormasPagos= mostrarvalor_adicionalListadosFormasPagos;
	}

	public Boolean getActivarvalor_adicionalListadosFormasPagos() {
		return this.activarvalor_adicionalListadosFormasPagos;
	}

	public void setActivarvalor_adicionalListadosFormasPagos(Boolean activarvalor_adicionalListadosFormasPagos) {
		this.activarvalor_adicionalListadosFormasPagos= activarvalor_adicionalListadosFormasPagos;
	}

	public Border setResaltarnombre_tipo_grupo_forma_pagoListadosFormasPagos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosFormasPagosBeanSwingJInternalFrame listadosformaspagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosformaspagosBeanSwingJInternalFrame.jTtoolBarListadosFormasPagos.setBorder(borderResaltar);
		
		this.resaltarnombre_tipo_grupo_forma_pagoListadosFormasPagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_tipo_grupo_forma_pagoListadosFormasPagos() {
		return this.resaltarnombre_tipo_grupo_forma_pagoListadosFormasPagos;
	}

	public void setResaltarnombre_tipo_grupo_forma_pagoListadosFormasPagos(Border borderResaltar) {
		this.resaltarnombre_tipo_grupo_forma_pagoListadosFormasPagos= borderResaltar;
	}

	public Boolean getMostrarnombre_tipo_grupo_forma_pagoListadosFormasPagos() {
		return this.mostrarnombre_tipo_grupo_forma_pagoListadosFormasPagos;
	}

	public void setMostrarnombre_tipo_grupo_forma_pagoListadosFormasPagos(Boolean mostrarnombre_tipo_grupo_forma_pagoListadosFormasPagos) {
		this.mostrarnombre_tipo_grupo_forma_pagoListadosFormasPagos= mostrarnombre_tipo_grupo_forma_pagoListadosFormasPagos;
	}

	public Boolean getActivarnombre_tipo_grupo_forma_pagoListadosFormasPagos() {
		return this.activarnombre_tipo_grupo_forma_pagoListadosFormasPagos;
	}

	public void setActivarnombre_tipo_grupo_forma_pagoListadosFormasPagos(Boolean activarnombre_tipo_grupo_forma_pagoListadosFormasPagos) {
		this.activarnombre_tipo_grupo_forma_pagoListadosFormasPagos= activarnombre_tipo_grupo_forma_pagoListadosFormasPagos;
	}

	public Border setResaltartotalListadosFormasPagos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosFormasPagosBeanSwingJInternalFrame listadosformaspagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosformaspagosBeanSwingJInternalFrame.jTtoolBarListadosFormasPagos.setBorder(borderResaltar);
		
		this.resaltartotalListadosFormasPagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalListadosFormasPagos() {
		return this.resaltartotalListadosFormasPagos;
	}

	public void setResaltartotalListadosFormasPagos(Border borderResaltar) {
		this.resaltartotalListadosFormasPagos= borderResaltar;
	}

	public Boolean getMostrartotalListadosFormasPagos() {
		return this.mostrartotalListadosFormasPagos;
	}

	public void setMostrartotalListadosFormasPagos(Boolean mostrartotalListadosFormasPagos) {
		this.mostrartotalListadosFormasPagos= mostrartotalListadosFormasPagos;
	}

	public Boolean getActivartotalListadosFormasPagos() {
		return this.activartotalListadosFormasPagos;
	}

	public void setActivartotalListadosFormasPagos(Boolean activartotalListadosFormasPagos) {
		this.activartotalListadosFormasPagos= activartotalListadosFormasPagos;
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
		
		
		this.setMostraridListadosFormasPagos(esInicial);
		this.setMostrarid_tipo_grupo_forma_pagoListadosFormasPagos(esInicial);
		this.setMostrarid_empresaListadosFormasPagos(esInicial);
		this.setMostrarid_sucursalListadosFormasPagos(esInicial);
		this.setMostrarfecha_desdeListadosFormasPagos(esInicial);
		this.setMostrarfecha_hastaListadosFormasPagos(esInicial);
		this.setMostrarcodigoListadosFormasPagos(esInicial);
		this.setMostrarnombre_completoListadosFormasPagos(esInicial);
		this.setMostrarcodigo_tipo_cuenta_banco_globalListadosFormasPagos(esInicial);
		this.setMostrarnumero_cuentaListadosFormasPagos(esInicial);
		this.setMostrarcodigo_estado_anti_clienteListadosFormasPagos(esInicial);
		this.setMostrarfechaListadosFormasPagos(esInicial);
		this.setMostrarvalorListadosFormasPagos(esInicial);
		this.setMostrarvalor_adicionalListadosFormasPagos(esInicial);
		this.setMostrarnombre_tipo_grupo_forma_pagoListadosFormasPagos(esInicial);
		this.setMostrartotalListadosFormasPagos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.ID)) {
				this.setMostraridListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.IDTIPOGRUPOFORMAPAGO)) {
				this.setMostrarid_tipo_grupo_forma_pagoListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.FECHADESDE)) {
				this.setMostrarfecha_desdeListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.FECHAHASTA)) {
				this.setMostrarfecha_hastaListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setMostrarnombre_completoListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.CODIGOTIPOCUENTABANCOGLOBAL)) {
				this.setMostrarcodigo_tipo_cuenta_banco_globalListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.NUMEROCUENTA)) {
				this.setMostrarnumero_cuentaListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.CODIGOESTADOANTICLIENTE)) {
				this.setMostrarcodigo_estado_anti_clienteListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.FECHA)) {
				this.setMostrarfechaListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.VALOR)) {
				this.setMostrarvalorListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.VALORADICIONAL)) {
				this.setMostrarvalor_adicionalListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.NOMBRETIPOGRUPOFORMAPAGO)) {
				this.setMostrarnombre_tipo_grupo_forma_pagoListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.TOTAL)) {
				this.setMostrartotalListadosFormasPagos(esAsigna);
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
		
		
		this.setActivaridListadosFormasPagos(esInicial);
		this.setActivarid_tipo_grupo_forma_pagoListadosFormasPagos(esInicial);
		this.setActivarid_empresaListadosFormasPagos(esInicial);
		this.setActivarid_sucursalListadosFormasPagos(esInicial);
		this.setActivarfecha_desdeListadosFormasPagos(esInicial);
		this.setActivarfecha_hastaListadosFormasPagos(esInicial);
		this.setActivarcodigoListadosFormasPagos(esInicial);
		this.setActivarnombre_completoListadosFormasPagos(esInicial);
		this.setActivarcodigo_tipo_cuenta_banco_globalListadosFormasPagos(esInicial);
		this.setActivarnumero_cuentaListadosFormasPagos(esInicial);
		this.setActivarcodigo_estado_anti_clienteListadosFormasPagos(esInicial);
		this.setActivarfechaListadosFormasPagos(esInicial);
		this.setActivarvalorListadosFormasPagos(esInicial);
		this.setActivarvalor_adicionalListadosFormasPagos(esInicial);
		this.setActivarnombre_tipo_grupo_forma_pagoListadosFormasPagos(esInicial);
		this.setActivartotalListadosFormasPagos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.ID)) {
				this.setActivaridListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.IDTIPOGRUPOFORMAPAGO)) {
				this.setActivarid_tipo_grupo_forma_pagoListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.FECHADESDE)) {
				this.setActivarfecha_desdeListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.FECHAHASTA)) {
				this.setActivarfecha_hastaListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.CODIGO)) {
				this.setActivarcodigoListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setActivarnombre_completoListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.CODIGOTIPOCUENTABANCOGLOBAL)) {
				this.setActivarcodigo_tipo_cuenta_banco_globalListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.NUMEROCUENTA)) {
				this.setActivarnumero_cuentaListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.CODIGOESTADOANTICLIENTE)) {
				this.setActivarcodigo_estado_anti_clienteListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.FECHA)) {
				this.setActivarfechaListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.VALOR)) {
				this.setActivarvalorListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.VALORADICIONAL)) {
				this.setActivarvalor_adicionalListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.NOMBRETIPOGRUPOFORMAPAGO)) {
				this.setActivarnombre_tipo_grupo_forma_pagoListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.TOTAL)) {
				this.setActivartotalListadosFormasPagos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ListadosFormasPagosBeanSwingJInternalFrame listadosformaspagosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridListadosFormasPagos(esInicial);
		this.setResaltarid_tipo_grupo_forma_pagoListadosFormasPagos(esInicial);
		this.setResaltarid_empresaListadosFormasPagos(esInicial);
		this.setResaltarid_sucursalListadosFormasPagos(esInicial);
		this.setResaltarfecha_desdeListadosFormasPagos(esInicial);
		this.setResaltarfecha_hastaListadosFormasPagos(esInicial);
		this.setResaltarcodigoListadosFormasPagos(esInicial);
		this.setResaltarnombre_completoListadosFormasPagos(esInicial);
		this.setResaltarcodigo_tipo_cuenta_banco_globalListadosFormasPagos(esInicial);
		this.setResaltarnumero_cuentaListadosFormasPagos(esInicial);
		this.setResaltarcodigo_estado_anti_clienteListadosFormasPagos(esInicial);
		this.setResaltarfechaListadosFormasPagos(esInicial);
		this.setResaltarvalorListadosFormasPagos(esInicial);
		this.setResaltarvalor_adicionalListadosFormasPagos(esInicial);
		this.setResaltarnombre_tipo_grupo_forma_pagoListadosFormasPagos(esInicial);
		this.setResaltartotalListadosFormasPagos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.ID)) {
				this.setResaltaridListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.IDTIPOGRUPOFORMAPAGO)) {
				this.setResaltarid_tipo_grupo_forma_pagoListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.FECHADESDE)) {
				this.setResaltarfecha_desdeListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.FECHAHASTA)) {
				this.setResaltarfecha_hastaListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setResaltarnombre_completoListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.CODIGOTIPOCUENTABANCOGLOBAL)) {
				this.setResaltarcodigo_tipo_cuenta_banco_globalListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.NUMEROCUENTA)) {
				this.setResaltarnumero_cuentaListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.CODIGOESTADOANTICLIENTE)) {
				this.setResaltarcodigo_estado_anti_clienteListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.FECHA)) {
				this.setResaltarfechaListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.VALOR)) {
				this.setResaltarvalorListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.VALORADICIONAL)) {
				this.setResaltarvalor_adicionalListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.NOMBRETIPOGRUPOFORMAPAGO)) {
				this.setResaltarnombre_tipo_grupo_forma_pagoListadosFormasPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosFormasPagosConstantesFunciones.TOTAL)) {
				this.setResaltartotalListadosFormasPagos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ListadosFormasPagosBeanSwingJInternalFrame listadosformaspagosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaListadosFormasPagosListadosFormasPagos=true;

	public Boolean getMostrarBusquedaListadosFormasPagosListadosFormasPagos() {
		return this.mostrarBusquedaListadosFormasPagosListadosFormasPagos;
	}

	public void setMostrarBusquedaListadosFormasPagosListadosFormasPagos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaListadosFormasPagosListadosFormasPagos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaListadosFormasPagosListadosFormasPagos=true;

	public Boolean getActivarBusquedaListadosFormasPagosListadosFormasPagos() {
		return this.activarBusquedaListadosFormasPagosListadosFormasPagos;
	}

	public void setActivarBusquedaListadosFormasPagosListadosFormasPagos(Boolean habilitarResaltar) {
		this.activarBusquedaListadosFormasPagosListadosFormasPagos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaListadosFormasPagosListadosFormasPagos=null;

	public Border getResaltarBusquedaListadosFormasPagosListadosFormasPagos() {
		return this.resaltarBusquedaListadosFormasPagosListadosFormasPagos;
	}

	public void setResaltarBusquedaListadosFormasPagosListadosFormasPagos(Border borderResaltar) {
		this.resaltarBusquedaListadosFormasPagosListadosFormasPagos= borderResaltar;
	}

	public void setResaltarBusquedaListadosFormasPagosListadosFormasPagos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosFormasPagosBeanSwingJInternalFrame listadosformaspagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaListadosFormasPagosListadosFormasPagos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}