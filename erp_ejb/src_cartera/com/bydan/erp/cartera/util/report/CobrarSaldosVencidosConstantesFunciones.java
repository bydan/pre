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


import com.bydan.erp.cartera.util.report.CobrarSaldosVencidosConstantesFunciones;
import com.bydan.erp.cartera.util.report.CobrarSaldosVencidosParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.CobrarSaldosVencidosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;



import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.cartera.util.*;
import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CobrarSaldosVencidosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="CobrarSaldosVencidos";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CobrarSaldosVencidos"+CobrarSaldosVencidosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CobrarSaldosVencidosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CobrarSaldosVencidosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CobrarSaldosVencidosConstantesFunciones.SCHEMA+"_"+CobrarSaldosVencidosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CobrarSaldosVencidosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CobrarSaldosVencidosConstantesFunciones.SCHEMA+"_"+CobrarSaldosVencidosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CobrarSaldosVencidosConstantesFunciones.SCHEMA+"_"+CobrarSaldosVencidosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CobrarSaldosVencidosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CobrarSaldosVencidosConstantesFunciones.SCHEMA+"_"+CobrarSaldosVencidosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarSaldosVencidosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CobrarSaldosVencidosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarSaldosVencidosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarSaldosVencidosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CobrarSaldosVencidosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarSaldosVencidosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CobrarSaldosVencidosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CobrarSaldosVencidosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CobrarSaldosVencidosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CobrarSaldosVencidosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cobrar Saldos Vencidoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Cobrar Saldos Vencidos";
	public static final String SCLASSWEBTITULO_LOWER="Cobrar Saldos Vencidos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CobrarSaldosVencidos";
	public static final String OBJECTNAME="cobrarsaldosvencidos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="cobrar_saldos_vencidos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cobrarsaldosvencidos from "+CobrarSaldosVencidosConstantesFunciones.SPERSISTENCENAME+" cobrarsaldosvencidos";
	public static String QUERYSELECTNATIVE="select "+CobrarSaldosVencidosConstantesFunciones.SCHEMA+"."+CobrarSaldosVencidosConstantesFunciones.TABLENAME+".id,"+CobrarSaldosVencidosConstantesFunciones.SCHEMA+"."+CobrarSaldosVencidosConstantesFunciones.TABLENAME+".version_row,"+CobrarSaldosVencidosConstantesFunciones.SCHEMA+"."+CobrarSaldosVencidosConstantesFunciones.TABLENAME+".id_grupo_cliente,"+CobrarSaldosVencidosConstantesFunciones.SCHEMA+"."+CobrarSaldosVencidosConstantesFunciones.TABLENAME+".id_empresa,"+CobrarSaldosVencidosConstantesFunciones.SCHEMA+"."+CobrarSaldosVencidosConstantesFunciones.TABLENAME+".numero_factura,"+CobrarSaldosVencidosConstantesFunciones.SCHEMA+"."+CobrarSaldosVencidosConstantesFunciones.TABLENAME+".nombre_grupo_cliente,"+CobrarSaldosVencidosConstantesFunciones.SCHEMA+"."+CobrarSaldosVencidosConstantesFunciones.TABLENAME+".codigo,"+CobrarSaldosVencidosConstantesFunciones.SCHEMA+"."+CobrarSaldosVencidosConstantesFunciones.TABLENAME+".nombre,"+CobrarSaldosVencidosConstantesFunciones.SCHEMA+"."+CobrarSaldosVencidosConstantesFunciones.TABLENAME+".fecha,"+CobrarSaldosVencidosConstantesFunciones.SCHEMA+"."+CobrarSaldosVencidosConstantesFunciones.TABLENAME+".fecha_vence,"+CobrarSaldosVencidosConstantesFunciones.SCHEMA+"."+CobrarSaldosVencidosConstantesFunciones.TABLENAME+".fecha_emision,"+CobrarSaldosVencidosConstantesFunciones.SCHEMA+"."+CobrarSaldosVencidosConstantesFunciones.TABLENAME+".saldo,"+CobrarSaldosVencidosConstantesFunciones.SCHEMA+"."+CobrarSaldosVencidosConstantesFunciones.TABLENAME+".telefono_telefono,"+CobrarSaldosVencidosConstantesFunciones.SCHEMA+"."+CobrarSaldosVencidosConstantesFunciones.TABLENAME+".descripcion from "+CobrarSaldosVencidosConstantesFunciones.SCHEMA+"."+CobrarSaldosVencidosConstantesFunciones.TABLENAME;//+" as "+CobrarSaldosVencidosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDGRUPOCLIENTE= "id_grupo_cliente";
    public static final String IDEMPRESA= "id_empresa";
    public static final String NUMEROFACTURA= "numero_factura";
    public static final String NOMBREGRUPOCLIENTE= "nombre_grupo_cliente";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String FECHA= "fecha";
    public static final String FECHAVENCE= "fecha_vence";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String SALDO= "saldo";
    public static final String TELEFONOTELEFONO= "telefono_telefono";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDGRUPOCLIENTE= "Grupo Cliente";
		public static final String LABEL_IDGRUPOCLIENTE_LOWER= "Grupo Cliente";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NUMEROFACTURA= "Numero Factura";
		public static final String LABEL_NUMEROFACTURA_LOWER= "Numero Factura";
    	public static final String LABEL_NOMBREGRUPOCLIENTE= "Nombre Grupo Cliente";
		public static final String LABEL_NOMBREGRUPOCLIENTE_LOWER= "Nombre Grupo Cliente";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_FECHAVENCE= "Fecha Vence";
		public static final String LABEL_FECHAVENCE_LOWER= "Fecha Vence";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_SALDO= "Saldo";
		public static final String LABEL_SALDO_LOWER= "Saldo";
    	public static final String LABEL_TELEFONOTELEFONO= "Telefono Telefono";
		public static final String LABEL_TELEFONOTELEFONO_LOWER= "Telefono Telefono";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
	public static final String SREGEXNUMERO_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_GRUPO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_GRUPO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	public static final String SREGEXTELEFONO_TELEFONO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTELEFONO_TELEFONO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getCobrarSaldosVencidosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CobrarSaldosVencidosConstantesFunciones.IDGRUPOCLIENTE)) {sLabelColumna=CobrarSaldosVencidosConstantesFunciones.LABEL_IDGRUPOCLIENTE;}
		if(sNombreColumna.equals(CobrarSaldosVencidosConstantesFunciones.IDEMPRESA)) {sLabelColumna=CobrarSaldosVencidosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CobrarSaldosVencidosConstantesFunciones.NUMEROFACTURA)) {sLabelColumna=CobrarSaldosVencidosConstantesFunciones.LABEL_NUMEROFACTURA;}
		if(sNombreColumna.equals(CobrarSaldosVencidosConstantesFunciones.NOMBREGRUPOCLIENTE)) {sLabelColumna=CobrarSaldosVencidosConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE;}
		if(sNombreColumna.equals(CobrarSaldosVencidosConstantesFunciones.CODIGO)) {sLabelColumna=CobrarSaldosVencidosConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(CobrarSaldosVencidosConstantesFunciones.NOMBRE)) {sLabelColumna=CobrarSaldosVencidosConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(CobrarSaldosVencidosConstantesFunciones.FECHA)) {sLabelColumna=CobrarSaldosVencidosConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(CobrarSaldosVencidosConstantesFunciones.FECHAVENCE)) {sLabelColumna=CobrarSaldosVencidosConstantesFunciones.LABEL_FECHAVENCE;}
		if(sNombreColumna.equals(CobrarSaldosVencidosConstantesFunciones.FECHAEMISION)) {sLabelColumna=CobrarSaldosVencidosConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(CobrarSaldosVencidosConstantesFunciones.SALDO)) {sLabelColumna=CobrarSaldosVencidosConstantesFunciones.LABEL_SALDO;}
		if(sNombreColumna.equals(CobrarSaldosVencidosConstantesFunciones.TELEFONOTELEFONO)) {sLabelColumna=CobrarSaldosVencidosConstantesFunciones.LABEL_TELEFONOTELEFONO;}
		if(sNombreColumna.equals(CobrarSaldosVencidosConstantesFunciones.DESCRIPCION)) {sLabelColumna=CobrarSaldosVencidosConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getCobrarSaldosVencidosDescripcion(CobrarSaldosVencidos cobrarsaldosvencidos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cobrarsaldosvencidos !=null/* && cobrarsaldosvencidos.getId()!=0*/) {
			sDescripcion=cobrarsaldosvencidos.getcodigo();//cobrarsaldosvencidoscobrarsaldosvencidos.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCobrarSaldosVencidosDescripcionDetallado(CobrarSaldosVencidos cobrarsaldosvencidos) {
		String sDescripcion="";
			
		sDescripcion+=CobrarSaldosVencidosConstantesFunciones.ID+"=";
		sDescripcion+=cobrarsaldosvencidos.getId().toString()+",";
		sDescripcion+=CobrarSaldosVencidosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cobrarsaldosvencidos.getVersionRow().toString()+",";
		sDescripcion+=CobrarSaldosVencidosConstantesFunciones.IDGRUPOCLIENTE+"=";
		sDescripcion+=cobrarsaldosvencidos.getid_grupo_cliente().toString()+",";
		sDescripcion+=CobrarSaldosVencidosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cobrarsaldosvencidos.getid_empresa().toString()+",";
		sDescripcion+=CobrarSaldosVencidosConstantesFunciones.NUMEROFACTURA+"=";
		sDescripcion+=cobrarsaldosvencidos.getnumero_factura()+",";
		sDescripcion+=CobrarSaldosVencidosConstantesFunciones.NOMBREGRUPOCLIENTE+"=";
		sDescripcion+=cobrarsaldosvencidos.getnombre_grupo_cliente()+",";
		sDescripcion+=CobrarSaldosVencidosConstantesFunciones.CODIGO+"=";
		sDescripcion+=cobrarsaldosvencidos.getcodigo()+",";
		sDescripcion+=CobrarSaldosVencidosConstantesFunciones.NOMBRE+"=";
		sDescripcion+=cobrarsaldosvencidos.getnombre()+",";
		sDescripcion+=CobrarSaldosVencidosConstantesFunciones.FECHA+"=";
		sDescripcion+=cobrarsaldosvencidos.getfecha().toString()+",";
		sDescripcion+=CobrarSaldosVencidosConstantesFunciones.FECHAVENCE+"=";
		sDescripcion+=cobrarsaldosvencidos.getfecha_vence().toString()+",";
		sDescripcion+=CobrarSaldosVencidosConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=cobrarsaldosvencidos.getfecha_emision().toString()+",";
		sDescripcion+=CobrarSaldosVencidosConstantesFunciones.SALDO+"=";
		sDescripcion+=cobrarsaldosvencidos.getsaldo().toString()+",";
		sDescripcion+=CobrarSaldosVencidosConstantesFunciones.TELEFONOTELEFONO+"=";
		sDescripcion+=cobrarsaldosvencidos.gettelefono_telefono()+",";
		sDescripcion+=CobrarSaldosVencidosConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=cobrarsaldosvencidos.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setCobrarSaldosVencidosDescripcion(CobrarSaldosVencidos cobrarsaldosvencidos,String sValor) throws Exception {			
		if(cobrarsaldosvencidos !=null) {
			cobrarsaldosvencidos.setcodigo(sValor);;//cobrarsaldosvencidoscobrarsaldosvencidos.getcodigo().trim();
		}		
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaCobrarSaldosVencidos")) {
			sNombreIndice="Tipo=  Por Grupo Cliente";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdGrupoCliente")) {
			sNombreIndice="Tipo=  Por Grupo Cliente";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaCobrarSaldosVencidos(Long id_grupo_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_grupo_cliente!=null) {sDetalleIndice+=" Codigo Unico De Grupo Cliente="+id_grupo_cliente.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosCobrarSaldosVencidos(CobrarSaldosVencidos cobrarsaldosvencidos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cobrarsaldosvencidos.setnumero_factura(cobrarsaldosvencidos.getnumero_factura().trim());
		cobrarsaldosvencidos.setnombre_grupo_cliente(cobrarsaldosvencidos.getnombre_grupo_cliente().trim());
		cobrarsaldosvencidos.setcodigo(cobrarsaldosvencidos.getcodigo().trim());
		cobrarsaldosvencidos.setnombre(cobrarsaldosvencidos.getnombre().trim());
		cobrarsaldosvencidos.settelefono_telefono(cobrarsaldosvencidos.gettelefono_telefono().trim());
		cobrarsaldosvencidos.setdescripcion(cobrarsaldosvencidos.getdescripcion().trim());
	}
	
	public static void quitarEspaciosCobrarSaldosVencidoss(List<CobrarSaldosVencidos> cobrarsaldosvencidoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CobrarSaldosVencidos cobrarsaldosvencidos: cobrarsaldosvencidoss) {
			cobrarsaldosvencidos.setnumero_factura(cobrarsaldosvencidos.getnumero_factura().trim());
			cobrarsaldosvencidos.setnombre_grupo_cliente(cobrarsaldosvencidos.getnombre_grupo_cliente().trim());
			cobrarsaldosvencidos.setcodigo(cobrarsaldosvencidos.getcodigo().trim());
			cobrarsaldosvencidos.setnombre(cobrarsaldosvencidos.getnombre().trim());
			cobrarsaldosvencidos.settelefono_telefono(cobrarsaldosvencidos.gettelefono_telefono().trim());
			cobrarsaldosvencidos.setdescripcion(cobrarsaldosvencidos.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCobrarSaldosVencidos(CobrarSaldosVencidos cobrarsaldosvencidos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cobrarsaldosvencidos.getConCambioAuxiliar()) {
			cobrarsaldosvencidos.setIsDeleted(cobrarsaldosvencidos.getIsDeletedAuxiliar());	
			cobrarsaldosvencidos.setIsNew(cobrarsaldosvencidos.getIsNewAuxiliar());	
			cobrarsaldosvencidos.setIsChanged(cobrarsaldosvencidos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cobrarsaldosvencidos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cobrarsaldosvencidos.setIsDeletedAuxiliar(false);	
			cobrarsaldosvencidos.setIsNewAuxiliar(false);	
			cobrarsaldosvencidos.setIsChangedAuxiliar(false);
			
			cobrarsaldosvencidos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCobrarSaldosVencidoss(List<CobrarSaldosVencidos> cobrarsaldosvencidoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CobrarSaldosVencidos cobrarsaldosvencidos : cobrarsaldosvencidoss) {
			if(conAsignarBase && cobrarsaldosvencidos.getConCambioAuxiliar()) {
				cobrarsaldosvencidos.setIsDeleted(cobrarsaldosvencidos.getIsDeletedAuxiliar());	
				cobrarsaldosvencidos.setIsNew(cobrarsaldosvencidos.getIsNewAuxiliar());	
				cobrarsaldosvencidos.setIsChanged(cobrarsaldosvencidos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cobrarsaldosvencidos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cobrarsaldosvencidos.setIsDeletedAuxiliar(false);	
				cobrarsaldosvencidos.setIsNewAuxiliar(false);	
				cobrarsaldosvencidos.setIsChangedAuxiliar(false);
				
				cobrarsaldosvencidos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCobrarSaldosVencidos(CobrarSaldosVencidos cobrarsaldosvencidos,Boolean conEnteros) throws Exception  {
		cobrarsaldosvencidos.setsaldo(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCobrarSaldosVencidoss(List<CobrarSaldosVencidos> cobrarsaldosvencidoss,Boolean conEnteros) throws Exception  {
		
		for(CobrarSaldosVencidos cobrarsaldosvencidos: cobrarsaldosvencidoss) {
			cobrarsaldosvencidos.setsaldo(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCobrarSaldosVencidos(List<CobrarSaldosVencidos> cobrarsaldosvencidoss,CobrarSaldosVencidos cobrarsaldosvencidosAux) throws Exception  {
		CobrarSaldosVencidosConstantesFunciones.InicializarValoresCobrarSaldosVencidos(cobrarsaldosvencidosAux,true);
		
		for(CobrarSaldosVencidos cobrarsaldosvencidos: cobrarsaldosvencidoss) {
			if(cobrarsaldosvencidos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cobrarsaldosvencidosAux.setsaldo(cobrarsaldosvencidosAux.getsaldo()+cobrarsaldosvencidos.getsaldo());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarSaldosVencidos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CobrarSaldosVencidosConstantesFunciones.getArrayColumnasGlobalesCobrarSaldosVencidos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarSaldosVencidos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CobrarSaldosVencidosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CobrarSaldosVencidosConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCobrarSaldosVencidos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CobrarSaldosVencidos> cobrarsaldosvencidoss,CobrarSaldosVencidos cobrarsaldosvencidos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CobrarSaldosVencidos cobrarsaldosvencidosAux: cobrarsaldosvencidoss) {
			if(cobrarsaldosvencidosAux!=null && cobrarsaldosvencidos!=null) {
				if((cobrarsaldosvencidosAux.getId()==null && cobrarsaldosvencidos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cobrarsaldosvencidosAux.getId()!=null && cobrarsaldosvencidos.getId()!=null){
					if(cobrarsaldosvencidosAux.getId().equals(cobrarsaldosvencidos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCobrarSaldosVencidos(List<CobrarSaldosVencidos> cobrarsaldosvencidoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double saldoTotal=0.0;
	
		for(CobrarSaldosVencidos cobrarsaldosvencidos: cobrarsaldosvencidoss) {			
			if(cobrarsaldosvencidos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			saldoTotal+=cobrarsaldosvencidos.getsaldo();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarSaldosVencidosConstantesFunciones.SALDO);
		datoGeneral.setsDescripcion(CobrarSaldosVencidosConstantesFunciones.LABEL_SALDO);
		datoGeneral.setdValorDouble(saldoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCobrarSaldosVencidos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CobrarSaldosVencidosConstantesFunciones.LABEL_ID, CobrarSaldosVencidosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarSaldosVencidosConstantesFunciones.LABEL_VERSIONROW, CobrarSaldosVencidosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarSaldosVencidosConstantesFunciones.LABEL_NUMEROFACTURA, CobrarSaldosVencidosConstantesFunciones.NUMEROFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarSaldosVencidosConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE, CobrarSaldosVencidosConstantesFunciones.NOMBREGRUPOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarSaldosVencidosConstantesFunciones.LABEL_CODIGO, CobrarSaldosVencidosConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarSaldosVencidosConstantesFunciones.LABEL_NOMBRE, CobrarSaldosVencidosConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarSaldosVencidosConstantesFunciones.LABEL_FECHA, CobrarSaldosVencidosConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarSaldosVencidosConstantesFunciones.LABEL_FECHAVENCE, CobrarSaldosVencidosConstantesFunciones.FECHAVENCE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarSaldosVencidosConstantesFunciones.LABEL_FECHAEMISION, CobrarSaldosVencidosConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarSaldosVencidosConstantesFunciones.LABEL_SALDO, CobrarSaldosVencidosConstantesFunciones.SALDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarSaldosVencidosConstantesFunciones.LABEL_TELEFONOTELEFONO, CobrarSaldosVencidosConstantesFunciones.TELEFONOTELEFONO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarSaldosVencidosConstantesFunciones.LABEL_DESCRIPCION, CobrarSaldosVencidosConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCobrarSaldosVencidos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CobrarSaldosVencidosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarSaldosVencidosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarSaldosVencidosConstantesFunciones.NUMEROFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarSaldosVencidosConstantesFunciones.NOMBREGRUPOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarSaldosVencidosConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarSaldosVencidosConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarSaldosVencidosConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarSaldosVencidosConstantesFunciones.FECHAVENCE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarSaldosVencidosConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarSaldosVencidosConstantesFunciones.SALDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarSaldosVencidosConstantesFunciones.TELEFONOTELEFONO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarSaldosVencidosConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarSaldosVencidos() throws Exception  {
		return CobrarSaldosVencidosConstantesFunciones.getTiposSeleccionarCobrarSaldosVencidos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarSaldosVencidos(Boolean conFk) throws Exception  {
		return CobrarSaldosVencidosConstantesFunciones.getTiposSeleccionarCobrarSaldosVencidos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarSaldosVencidos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarSaldosVencidosConstantesFunciones.LABEL_IDGRUPOCLIENTE);
			reporte.setsDescripcion(CobrarSaldosVencidosConstantesFunciones.LABEL_IDGRUPOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarSaldosVencidosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CobrarSaldosVencidosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarSaldosVencidosConstantesFunciones.LABEL_NUMEROFACTURA);
			reporte.setsDescripcion(CobrarSaldosVencidosConstantesFunciones.LABEL_NUMEROFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarSaldosVencidosConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE);
			reporte.setsDescripcion(CobrarSaldosVencidosConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarSaldosVencidosConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(CobrarSaldosVencidosConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarSaldosVencidosConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(CobrarSaldosVencidosConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarSaldosVencidosConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(CobrarSaldosVencidosConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarSaldosVencidosConstantesFunciones.LABEL_FECHAVENCE);
			reporte.setsDescripcion(CobrarSaldosVencidosConstantesFunciones.LABEL_FECHAVENCE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarSaldosVencidosConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(CobrarSaldosVencidosConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarSaldosVencidosConstantesFunciones.LABEL_SALDO);
			reporte.setsDescripcion(CobrarSaldosVencidosConstantesFunciones.LABEL_SALDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarSaldosVencidosConstantesFunciones.LABEL_TELEFONOTELEFONO);
			reporte.setsDescripcion(CobrarSaldosVencidosConstantesFunciones.LABEL_TELEFONOTELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarSaldosVencidosConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(CobrarSaldosVencidosConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCobrarSaldosVencidos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCobrarSaldosVencidos(CobrarSaldosVencidos cobrarsaldosvencidosAux) throws Exception {
		
			cobrarsaldosvencidosAux.setgrupocliente_descripcion(GrupoClienteConstantesFunciones.getGrupoClienteDescripcion(cobrarsaldosvencidosAux.getGrupoCliente()));
			cobrarsaldosvencidosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cobrarsaldosvencidosAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCobrarSaldosVencidos(List<CobrarSaldosVencidos> cobrarsaldosvencidossTemp) throws Exception {
		for(CobrarSaldosVencidos cobrarsaldosvencidosAux:cobrarsaldosvencidossTemp) {
			
			cobrarsaldosvencidosAux.setgrupocliente_descripcion(GrupoClienteConstantesFunciones.getGrupoClienteDescripcion(cobrarsaldosvencidosAux.getGrupoCliente()));
			cobrarsaldosvencidosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cobrarsaldosvencidosAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCobrarSaldosVencidos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(GrupoCliente.class));
				classes.add(new Classe(Empresa.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCobrarSaldosVencidos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(GrupoCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoCliente.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(GrupoCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoCliente.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCobrarSaldosVencidos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CobrarSaldosVencidosConstantesFunciones.getClassesRelationshipsOfCobrarSaldosVencidos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCobrarSaldosVencidos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCobrarSaldosVencidos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CobrarSaldosVencidosConstantesFunciones.getClassesRelationshipsFromStringsOfCobrarSaldosVencidos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCobrarSaldosVencidos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(CobrarSaldosVencidos cobrarsaldosvencidos,List<CobrarSaldosVencidos> cobrarsaldosvencidoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(CobrarSaldosVencidos cobrarsaldosvencidos,List<CobrarSaldosVencidos> cobrarsaldosvencidoss) throws Exception {
		try	{			
			for(CobrarSaldosVencidos cobrarsaldosvencidosLocal:cobrarsaldosvencidoss) {
				if(cobrarsaldosvencidosLocal.getId().equals(cobrarsaldosvencidos.getId())) {
					cobrarsaldosvencidosLocal.setIsSelected(cobrarsaldosvencidos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCobrarSaldosVencidos(List<CobrarSaldosVencidos> cobrarsaldosvencidossAux) throws Exception {
		//this.cobrarsaldosvencidossAux=cobrarsaldosvencidossAux;
		
		for(CobrarSaldosVencidos cobrarsaldosvencidosAux:cobrarsaldosvencidossAux) {
			if(cobrarsaldosvencidosAux.getIsChanged()) {
				cobrarsaldosvencidosAux.setIsChanged(false);
			}		
			
			if(cobrarsaldosvencidosAux.getIsNew()) {
				cobrarsaldosvencidosAux.setIsNew(false);
			}	
			
			if(cobrarsaldosvencidosAux.getIsDeleted()) {
				cobrarsaldosvencidosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCobrarSaldosVencidos(CobrarSaldosVencidos cobrarsaldosvencidosAux) throws Exception {
		//this.cobrarsaldosvencidosAux=cobrarsaldosvencidosAux;
		
			if(cobrarsaldosvencidosAux.getIsChanged()) {
				cobrarsaldosvencidosAux.setIsChanged(false);
			}		
			
			if(cobrarsaldosvencidosAux.getIsNew()) {
				cobrarsaldosvencidosAux.setIsNew(false);
			}	
			
			if(cobrarsaldosvencidosAux.getIsDeleted()) {
				cobrarsaldosvencidosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CobrarSaldosVencidos cobrarsaldosvencidosAsignar,CobrarSaldosVencidos cobrarsaldosvencidos) throws Exception {
		cobrarsaldosvencidosAsignar.setId(cobrarsaldosvencidos.getId());	
		cobrarsaldosvencidosAsignar.setVersionRow(cobrarsaldosvencidos.getVersionRow());	
		cobrarsaldosvencidosAsignar.setnumero_factura(cobrarsaldosvencidos.getnumero_factura());	
		cobrarsaldosvencidosAsignar.setnombre_grupo_cliente(cobrarsaldosvencidos.getnombre_grupo_cliente());	
		cobrarsaldosvencidosAsignar.setcodigo(cobrarsaldosvencidos.getcodigo());	
		cobrarsaldosvencidosAsignar.setnombre(cobrarsaldosvencidos.getnombre());	
		cobrarsaldosvencidosAsignar.setfecha(cobrarsaldosvencidos.getfecha());	
		cobrarsaldosvencidosAsignar.setfecha_vence(cobrarsaldosvencidos.getfecha_vence());	
		cobrarsaldosvencidosAsignar.setfecha_emision(cobrarsaldosvencidos.getfecha_emision());	
		cobrarsaldosvencidosAsignar.setsaldo(cobrarsaldosvencidos.getsaldo());	
		cobrarsaldosvencidosAsignar.settelefono_telefono(cobrarsaldosvencidos.gettelefono_telefono());	
		cobrarsaldosvencidosAsignar.setdescripcion(cobrarsaldosvencidos.getdescripcion());	
	}
	
	public static void inicializarCobrarSaldosVencidos(CobrarSaldosVencidos cobrarsaldosvencidos) throws Exception {
		try {
				cobrarsaldosvencidos.setId(0L);	
					
				cobrarsaldosvencidos.setnumero_factura("");	
				cobrarsaldosvencidos.setnombre_grupo_cliente("");	
				cobrarsaldosvencidos.setcodigo("");	
				cobrarsaldosvencidos.setnombre("");	
				cobrarsaldosvencidos.setfecha(new Date());	
				cobrarsaldosvencidos.setfecha_vence(new Date());	
				cobrarsaldosvencidos.setfecha_emision(new Date());	
				cobrarsaldosvencidos.setsaldo(0.0);	
				cobrarsaldosvencidos.settelefono_telefono("");	
				cobrarsaldosvencidos.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCobrarSaldosVencidos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarSaldosVencidosConstantesFunciones.LABEL_IDGRUPOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarSaldosVencidosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarSaldosVencidosConstantesFunciones.LABEL_NUMEROFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarSaldosVencidosConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarSaldosVencidosConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarSaldosVencidosConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarSaldosVencidosConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarSaldosVencidosConstantesFunciones.LABEL_FECHAVENCE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarSaldosVencidosConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarSaldosVencidosConstantesFunciones.LABEL_SALDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarSaldosVencidosConstantesFunciones.LABEL_TELEFONOTELEFONO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarSaldosVencidosConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCobrarSaldosVencidos(String sTipo,Row row,Workbook workbook,CobrarSaldosVencidos cobrarsaldosvencidos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarsaldosvencidos.getgrupocliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarsaldosvencidos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarsaldosvencidos.getnumero_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarsaldosvencidos.getnombre_grupo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarsaldosvencidos.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarsaldosvencidos.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarsaldosvencidos.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarsaldosvencidos.getfecha_vence());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarsaldosvencidos.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarsaldosvencidos.getsaldo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarsaldosvencidos.gettelefono_telefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarsaldosvencidos.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCobrarSaldosVencidos="";
	
	public String getsFinalQueryCobrarSaldosVencidos() {
		return this.sFinalQueryCobrarSaldosVencidos;
	}
	
	public void setsFinalQueryCobrarSaldosVencidos(String sFinalQueryCobrarSaldosVencidos) {
		this.sFinalQueryCobrarSaldosVencidos= sFinalQueryCobrarSaldosVencidos;
	}
	
	public Border resaltarSeleccionarCobrarSaldosVencidos=null;
	
	public Border setResaltarSeleccionarCobrarSaldosVencidos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarSaldosVencidosBeanSwingJInternalFrame cobrarsaldosvencidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cobrarsaldosvencidosBeanSwingJInternalFrame.jTtoolBarCobrarSaldosVencidos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCobrarSaldosVencidos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCobrarSaldosVencidos() {
		return this.resaltarSeleccionarCobrarSaldosVencidos;
	}
	
	public void setResaltarSeleccionarCobrarSaldosVencidos(Border borderResaltarSeleccionarCobrarSaldosVencidos) {
		this.resaltarSeleccionarCobrarSaldosVencidos= borderResaltarSeleccionarCobrarSaldosVencidos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCobrarSaldosVencidos=null;
	public Boolean mostraridCobrarSaldosVencidos=true;
	public Boolean activaridCobrarSaldosVencidos=true;

	public Border resaltarid_grupo_clienteCobrarSaldosVencidos=null;
	public Boolean mostrarid_grupo_clienteCobrarSaldosVencidos=true;
	public Boolean activarid_grupo_clienteCobrarSaldosVencidos=true;
	public Boolean cargarid_grupo_clienteCobrarSaldosVencidos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_grupo_clienteCobrarSaldosVencidos=false;//ConEventDepend=true

	public Border resaltarid_empresaCobrarSaldosVencidos=null;
	public Boolean mostrarid_empresaCobrarSaldosVencidos=true;
	public Boolean activarid_empresaCobrarSaldosVencidos=true;
	public Boolean cargarid_empresaCobrarSaldosVencidos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCobrarSaldosVencidos=false;//ConEventDepend=true

	public Border resaltarnumero_facturaCobrarSaldosVencidos=null;
	public Boolean mostrarnumero_facturaCobrarSaldosVencidos=true;
	public Boolean activarnumero_facturaCobrarSaldosVencidos=true;

	public Border resaltarnombre_grupo_clienteCobrarSaldosVencidos=null;
	public Boolean mostrarnombre_grupo_clienteCobrarSaldosVencidos=true;
	public Boolean activarnombre_grupo_clienteCobrarSaldosVencidos=true;

	public Border resaltarcodigoCobrarSaldosVencidos=null;
	public Boolean mostrarcodigoCobrarSaldosVencidos=true;
	public Boolean activarcodigoCobrarSaldosVencidos=true;

	public Border resaltarnombreCobrarSaldosVencidos=null;
	public Boolean mostrarnombreCobrarSaldosVencidos=true;
	public Boolean activarnombreCobrarSaldosVencidos=true;

	public Border resaltarfechaCobrarSaldosVencidos=null;
	public Boolean mostrarfechaCobrarSaldosVencidos=true;
	public Boolean activarfechaCobrarSaldosVencidos=true;

	public Border resaltarfecha_venceCobrarSaldosVencidos=null;
	public Boolean mostrarfecha_venceCobrarSaldosVencidos=true;
	public Boolean activarfecha_venceCobrarSaldosVencidos=true;

	public Border resaltarfecha_emisionCobrarSaldosVencidos=null;
	public Boolean mostrarfecha_emisionCobrarSaldosVencidos=true;
	public Boolean activarfecha_emisionCobrarSaldosVencidos=true;

	public Border resaltarsaldoCobrarSaldosVencidos=null;
	public Boolean mostrarsaldoCobrarSaldosVencidos=true;
	public Boolean activarsaldoCobrarSaldosVencidos=true;

	public Border resaltartelefono_telefonoCobrarSaldosVencidos=null;
	public Boolean mostrartelefono_telefonoCobrarSaldosVencidos=true;
	public Boolean activartelefono_telefonoCobrarSaldosVencidos=true;

	public Border resaltardescripcionCobrarSaldosVencidos=null;
	public Boolean mostrardescripcionCobrarSaldosVencidos=true;
	public Boolean activardescripcionCobrarSaldosVencidos=true;

	
	

	public Border setResaltaridCobrarSaldosVencidos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarSaldosVencidosBeanSwingJInternalFrame cobrarsaldosvencidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarsaldosvencidosBeanSwingJInternalFrame.jTtoolBarCobrarSaldosVencidos.setBorder(borderResaltar);
		
		this.resaltaridCobrarSaldosVencidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCobrarSaldosVencidos() {
		return this.resaltaridCobrarSaldosVencidos;
	}

	public void setResaltaridCobrarSaldosVencidos(Border borderResaltar) {
		this.resaltaridCobrarSaldosVencidos= borderResaltar;
	}

	public Boolean getMostraridCobrarSaldosVencidos() {
		return this.mostraridCobrarSaldosVencidos;
	}

	public void setMostraridCobrarSaldosVencidos(Boolean mostraridCobrarSaldosVencidos) {
		this.mostraridCobrarSaldosVencidos= mostraridCobrarSaldosVencidos;
	}

	public Boolean getActivaridCobrarSaldosVencidos() {
		return this.activaridCobrarSaldosVencidos;
	}

	public void setActivaridCobrarSaldosVencidos(Boolean activaridCobrarSaldosVencidos) {
		this.activaridCobrarSaldosVencidos= activaridCobrarSaldosVencidos;
	}

	public Border setResaltarid_grupo_clienteCobrarSaldosVencidos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarSaldosVencidosBeanSwingJInternalFrame cobrarsaldosvencidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarsaldosvencidosBeanSwingJInternalFrame.jTtoolBarCobrarSaldosVencidos.setBorder(borderResaltar);
		
		this.resaltarid_grupo_clienteCobrarSaldosVencidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_grupo_clienteCobrarSaldosVencidos() {
		return this.resaltarid_grupo_clienteCobrarSaldosVencidos;
	}

	public void setResaltarid_grupo_clienteCobrarSaldosVencidos(Border borderResaltar) {
		this.resaltarid_grupo_clienteCobrarSaldosVencidos= borderResaltar;
	}

	public Boolean getMostrarid_grupo_clienteCobrarSaldosVencidos() {
		return this.mostrarid_grupo_clienteCobrarSaldosVencidos;
	}

	public void setMostrarid_grupo_clienteCobrarSaldosVencidos(Boolean mostrarid_grupo_clienteCobrarSaldosVencidos) {
		this.mostrarid_grupo_clienteCobrarSaldosVencidos= mostrarid_grupo_clienteCobrarSaldosVencidos;
	}

	public Boolean getActivarid_grupo_clienteCobrarSaldosVencidos() {
		return this.activarid_grupo_clienteCobrarSaldosVencidos;
	}

	public void setActivarid_grupo_clienteCobrarSaldosVencidos(Boolean activarid_grupo_clienteCobrarSaldosVencidos) {
		this.activarid_grupo_clienteCobrarSaldosVencidos= activarid_grupo_clienteCobrarSaldosVencidos;
	}

	public Boolean getCargarid_grupo_clienteCobrarSaldosVencidos() {
		return this.cargarid_grupo_clienteCobrarSaldosVencidos;
	}

	public void setCargarid_grupo_clienteCobrarSaldosVencidos(Boolean cargarid_grupo_clienteCobrarSaldosVencidos) {
		this.cargarid_grupo_clienteCobrarSaldosVencidos= cargarid_grupo_clienteCobrarSaldosVencidos;
	}

	public Border setResaltarid_empresaCobrarSaldosVencidos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarSaldosVencidosBeanSwingJInternalFrame cobrarsaldosvencidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarsaldosvencidosBeanSwingJInternalFrame.jTtoolBarCobrarSaldosVencidos.setBorder(borderResaltar);
		
		this.resaltarid_empresaCobrarSaldosVencidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCobrarSaldosVencidos() {
		return this.resaltarid_empresaCobrarSaldosVencidos;
	}

	public void setResaltarid_empresaCobrarSaldosVencidos(Border borderResaltar) {
		this.resaltarid_empresaCobrarSaldosVencidos= borderResaltar;
	}

	public Boolean getMostrarid_empresaCobrarSaldosVencidos() {
		return this.mostrarid_empresaCobrarSaldosVencidos;
	}

	public void setMostrarid_empresaCobrarSaldosVencidos(Boolean mostrarid_empresaCobrarSaldosVencidos) {
		this.mostrarid_empresaCobrarSaldosVencidos= mostrarid_empresaCobrarSaldosVencidos;
	}

	public Boolean getActivarid_empresaCobrarSaldosVencidos() {
		return this.activarid_empresaCobrarSaldosVencidos;
	}

	public void setActivarid_empresaCobrarSaldosVencidos(Boolean activarid_empresaCobrarSaldosVencidos) {
		this.activarid_empresaCobrarSaldosVencidos= activarid_empresaCobrarSaldosVencidos;
	}

	public Boolean getCargarid_empresaCobrarSaldosVencidos() {
		return this.cargarid_empresaCobrarSaldosVencidos;
	}

	public void setCargarid_empresaCobrarSaldosVencidos(Boolean cargarid_empresaCobrarSaldosVencidos) {
		this.cargarid_empresaCobrarSaldosVencidos= cargarid_empresaCobrarSaldosVencidos;
	}

	public Border setResaltarnumero_facturaCobrarSaldosVencidos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarSaldosVencidosBeanSwingJInternalFrame cobrarsaldosvencidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarsaldosvencidosBeanSwingJInternalFrame.jTtoolBarCobrarSaldosVencidos.setBorder(borderResaltar);
		
		this.resaltarnumero_facturaCobrarSaldosVencidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_facturaCobrarSaldosVencidos() {
		return this.resaltarnumero_facturaCobrarSaldosVencidos;
	}

	public void setResaltarnumero_facturaCobrarSaldosVencidos(Border borderResaltar) {
		this.resaltarnumero_facturaCobrarSaldosVencidos= borderResaltar;
	}

	public Boolean getMostrarnumero_facturaCobrarSaldosVencidos() {
		return this.mostrarnumero_facturaCobrarSaldosVencidos;
	}

	public void setMostrarnumero_facturaCobrarSaldosVencidos(Boolean mostrarnumero_facturaCobrarSaldosVencidos) {
		this.mostrarnumero_facturaCobrarSaldosVencidos= mostrarnumero_facturaCobrarSaldosVencidos;
	}

	public Boolean getActivarnumero_facturaCobrarSaldosVencidos() {
		return this.activarnumero_facturaCobrarSaldosVencidos;
	}

	public void setActivarnumero_facturaCobrarSaldosVencidos(Boolean activarnumero_facturaCobrarSaldosVencidos) {
		this.activarnumero_facturaCobrarSaldosVencidos= activarnumero_facturaCobrarSaldosVencidos;
	}

	public Border setResaltarnombre_grupo_clienteCobrarSaldosVencidos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarSaldosVencidosBeanSwingJInternalFrame cobrarsaldosvencidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarsaldosvencidosBeanSwingJInternalFrame.jTtoolBarCobrarSaldosVencidos.setBorder(borderResaltar);
		
		this.resaltarnombre_grupo_clienteCobrarSaldosVencidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_grupo_clienteCobrarSaldosVencidos() {
		return this.resaltarnombre_grupo_clienteCobrarSaldosVencidos;
	}

	public void setResaltarnombre_grupo_clienteCobrarSaldosVencidos(Border borderResaltar) {
		this.resaltarnombre_grupo_clienteCobrarSaldosVencidos= borderResaltar;
	}

	public Boolean getMostrarnombre_grupo_clienteCobrarSaldosVencidos() {
		return this.mostrarnombre_grupo_clienteCobrarSaldosVencidos;
	}

	public void setMostrarnombre_grupo_clienteCobrarSaldosVencidos(Boolean mostrarnombre_grupo_clienteCobrarSaldosVencidos) {
		this.mostrarnombre_grupo_clienteCobrarSaldosVencidos= mostrarnombre_grupo_clienteCobrarSaldosVencidos;
	}

	public Boolean getActivarnombre_grupo_clienteCobrarSaldosVencidos() {
		return this.activarnombre_grupo_clienteCobrarSaldosVencidos;
	}

	public void setActivarnombre_grupo_clienteCobrarSaldosVencidos(Boolean activarnombre_grupo_clienteCobrarSaldosVencidos) {
		this.activarnombre_grupo_clienteCobrarSaldosVencidos= activarnombre_grupo_clienteCobrarSaldosVencidos;
	}

	public Border setResaltarcodigoCobrarSaldosVencidos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarSaldosVencidosBeanSwingJInternalFrame cobrarsaldosvencidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarsaldosvencidosBeanSwingJInternalFrame.jTtoolBarCobrarSaldosVencidos.setBorder(borderResaltar);
		
		this.resaltarcodigoCobrarSaldosVencidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoCobrarSaldosVencidos() {
		return this.resaltarcodigoCobrarSaldosVencidos;
	}

	public void setResaltarcodigoCobrarSaldosVencidos(Border borderResaltar) {
		this.resaltarcodigoCobrarSaldosVencidos= borderResaltar;
	}

	public Boolean getMostrarcodigoCobrarSaldosVencidos() {
		return this.mostrarcodigoCobrarSaldosVencidos;
	}

	public void setMostrarcodigoCobrarSaldosVencidos(Boolean mostrarcodigoCobrarSaldosVencidos) {
		this.mostrarcodigoCobrarSaldosVencidos= mostrarcodigoCobrarSaldosVencidos;
	}

	public Boolean getActivarcodigoCobrarSaldosVencidos() {
		return this.activarcodigoCobrarSaldosVencidos;
	}

	public void setActivarcodigoCobrarSaldosVencidos(Boolean activarcodigoCobrarSaldosVencidos) {
		this.activarcodigoCobrarSaldosVencidos= activarcodigoCobrarSaldosVencidos;
	}

	public Border setResaltarnombreCobrarSaldosVencidos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarSaldosVencidosBeanSwingJInternalFrame cobrarsaldosvencidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarsaldosvencidosBeanSwingJInternalFrame.jTtoolBarCobrarSaldosVencidos.setBorder(borderResaltar);
		
		this.resaltarnombreCobrarSaldosVencidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreCobrarSaldosVencidos() {
		return this.resaltarnombreCobrarSaldosVencidos;
	}

	public void setResaltarnombreCobrarSaldosVencidos(Border borderResaltar) {
		this.resaltarnombreCobrarSaldosVencidos= borderResaltar;
	}

	public Boolean getMostrarnombreCobrarSaldosVencidos() {
		return this.mostrarnombreCobrarSaldosVencidos;
	}

	public void setMostrarnombreCobrarSaldosVencidos(Boolean mostrarnombreCobrarSaldosVencidos) {
		this.mostrarnombreCobrarSaldosVencidos= mostrarnombreCobrarSaldosVencidos;
	}

	public Boolean getActivarnombreCobrarSaldosVencidos() {
		return this.activarnombreCobrarSaldosVencidos;
	}

	public void setActivarnombreCobrarSaldosVencidos(Boolean activarnombreCobrarSaldosVencidos) {
		this.activarnombreCobrarSaldosVencidos= activarnombreCobrarSaldosVencidos;
	}

	public Border setResaltarfechaCobrarSaldosVencidos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarSaldosVencidosBeanSwingJInternalFrame cobrarsaldosvencidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarsaldosvencidosBeanSwingJInternalFrame.jTtoolBarCobrarSaldosVencidos.setBorder(borderResaltar);
		
		this.resaltarfechaCobrarSaldosVencidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaCobrarSaldosVencidos() {
		return this.resaltarfechaCobrarSaldosVencidos;
	}

	public void setResaltarfechaCobrarSaldosVencidos(Border borderResaltar) {
		this.resaltarfechaCobrarSaldosVencidos= borderResaltar;
	}

	public Boolean getMostrarfechaCobrarSaldosVencidos() {
		return this.mostrarfechaCobrarSaldosVencidos;
	}

	public void setMostrarfechaCobrarSaldosVencidos(Boolean mostrarfechaCobrarSaldosVencidos) {
		this.mostrarfechaCobrarSaldosVencidos= mostrarfechaCobrarSaldosVencidos;
	}

	public Boolean getActivarfechaCobrarSaldosVencidos() {
		return this.activarfechaCobrarSaldosVencidos;
	}

	public void setActivarfechaCobrarSaldosVencidos(Boolean activarfechaCobrarSaldosVencidos) {
		this.activarfechaCobrarSaldosVencidos= activarfechaCobrarSaldosVencidos;
	}

	public Border setResaltarfecha_venceCobrarSaldosVencidos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarSaldosVencidosBeanSwingJInternalFrame cobrarsaldosvencidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarsaldosvencidosBeanSwingJInternalFrame.jTtoolBarCobrarSaldosVencidos.setBorder(borderResaltar);
		
		this.resaltarfecha_venceCobrarSaldosVencidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_venceCobrarSaldosVencidos() {
		return this.resaltarfecha_venceCobrarSaldosVencidos;
	}

	public void setResaltarfecha_venceCobrarSaldosVencidos(Border borderResaltar) {
		this.resaltarfecha_venceCobrarSaldosVencidos= borderResaltar;
	}

	public Boolean getMostrarfecha_venceCobrarSaldosVencidos() {
		return this.mostrarfecha_venceCobrarSaldosVencidos;
	}

	public void setMostrarfecha_venceCobrarSaldosVencidos(Boolean mostrarfecha_venceCobrarSaldosVencidos) {
		this.mostrarfecha_venceCobrarSaldosVencidos= mostrarfecha_venceCobrarSaldosVencidos;
	}

	public Boolean getActivarfecha_venceCobrarSaldosVencidos() {
		return this.activarfecha_venceCobrarSaldosVencidos;
	}

	public void setActivarfecha_venceCobrarSaldosVencidos(Boolean activarfecha_venceCobrarSaldosVencidos) {
		this.activarfecha_venceCobrarSaldosVencidos= activarfecha_venceCobrarSaldosVencidos;
	}

	public Border setResaltarfecha_emisionCobrarSaldosVencidos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarSaldosVencidosBeanSwingJInternalFrame cobrarsaldosvencidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarsaldosvencidosBeanSwingJInternalFrame.jTtoolBarCobrarSaldosVencidos.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionCobrarSaldosVencidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionCobrarSaldosVencidos() {
		return this.resaltarfecha_emisionCobrarSaldosVencidos;
	}

	public void setResaltarfecha_emisionCobrarSaldosVencidos(Border borderResaltar) {
		this.resaltarfecha_emisionCobrarSaldosVencidos= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionCobrarSaldosVencidos() {
		return this.mostrarfecha_emisionCobrarSaldosVencidos;
	}

	public void setMostrarfecha_emisionCobrarSaldosVencidos(Boolean mostrarfecha_emisionCobrarSaldosVencidos) {
		this.mostrarfecha_emisionCobrarSaldosVencidos= mostrarfecha_emisionCobrarSaldosVencidos;
	}

	public Boolean getActivarfecha_emisionCobrarSaldosVencidos() {
		return this.activarfecha_emisionCobrarSaldosVencidos;
	}

	public void setActivarfecha_emisionCobrarSaldosVencidos(Boolean activarfecha_emisionCobrarSaldosVencidos) {
		this.activarfecha_emisionCobrarSaldosVencidos= activarfecha_emisionCobrarSaldosVencidos;
	}

	public Border setResaltarsaldoCobrarSaldosVencidos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarSaldosVencidosBeanSwingJInternalFrame cobrarsaldosvencidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarsaldosvencidosBeanSwingJInternalFrame.jTtoolBarCobrarSaldosVencidos.setBorder(borderResaltar);
		
		this.resaltarsaldoCobrarSaldosVencidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsaldoCobrarSaldosVencidos() {
		return this.resaltarsaldoCobrarSaldosVencidos;
	}

	public void setResaltarsaldoCobrarSaldosVencidos(Border borderResaltar) {
		this.resaltarsaldoCobrarSaldosVencidos= borderResaltar;
	}

	public Boolean getMostrarsaldoCobrarSaldosVencidos() {
		return this.mostrarsaldoCobrarSaldosVencidos;
	}

	public void setMostrarsaldoCobrarSaldosVencidos(Boolean mostrarsaldoCobrarSaldosVencidos) {
		this.mostrarsaldoCobrarSaldosVencidos= mostrarsaldoCobrarSaldosVencidos;
	}

	public Boolean getActivarsaldoCobrarSaldosVencidos() {
		return this.activarsaldoCobrarSaldosVencidos;
	}

	public void setActivarsaldoCobrarSaldosVencidos(Boolean activarsaldoCobrarSaldosVencidos) {
		this.activarsaldoCobrarSaldosVencidos= activarsaldoCobrarSaldosVencidos;
	}

	public Border setResaltartelefono_telefonoCobrarSaldosVencidos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarSaldosVencidosBeanSwingJInternalFrame cobrarsaldosvencidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarsaldosvencidosBeanSwingJInternalFrame.jTtoolBarCobrarSaldosVencidos.setBorder(borderResaltar);
		
		this.resaltartelefono_telefonoCobrarSaldosVencidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefono_telefonoCobrarSaldosVencidos() {
		return this.resaltartelefono_telefonoCobrarSaldosVencidos;
	}

	public void setResaltartelefono_telefonoCobrarSaldosVencidos(Border borderResaltar) {
		this.resaltartelefono_telefonoCobrarSaldosVencidos= borderResaltar;
	}

	public Boolean getMostrartelefono_telefonoCobrarSaldosVencidos() {
		return this.mostrartelefono_telefonoCobrarSaldosVencidos;
	}

	public void setMostrartelefono_telefonoCobrarSaldosVencidos(Boolean mostrartelefono_telefonoCobrarSaldosVencidos) {
		this.mostrartelefono_telefonoCobrarSaldosVencidos= mostrartelefono_telefonoCobrarSaldosVencidos;
	}

	public Boolean getActivartelefono_telefonoCobrarSaldosVencidos() {
		return this.activartelefono_telefonoCobrarSaldosVencidos;
	}

	public void setActivartelefono_telefonoCobrarSaldosVencidos(Boolean activartelefono_telefonoCobrarSaldosVencidos) {
		this.activartelefono_telefonoCobrarSaldosVencidos= activartelefono_telefonoCobrarSaldosVencidos;
	}

	public Border setResaltardescripcionCobrarSaldosVencidos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarSaldosVencidosBeanSwingJInternalFrame cobrarsaldosvencidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarsaldosvencidosBeanSwingJInternalFrame.jTtoolBarCobrarSaldosVencidos.setBorder(borderResaltar);
		
		this.resaltardescripcionCobrarSaldosVencidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionCobrarSaldosVencidos() {
		return this.resaltardescripcionCobrarSaldosVencidos;
	}

	public void setResaltardescripcionCobrarSaldosVencidos(Border borderResaltar) {
		this.resaltardescripcionCobrarSaldosVencidos= borderResaltar;
	}

	public Boolean getMostrardescripcionCobrarSaldosVencidos() {
		return this.mostrardescripcionCobrarSaldosVencidos;
	}

	public void setMostrardescripcionCobrarSaldosVencidos(Boolean mostrardescripcionCobrarSaldosVencidos) {
		this.mostrardescripcionCobrarSaldosVencidos= mostrardescripcionCobrarSaldosVencidos;
	}

	public Boolean getActivardescripcionCobrarSaldosVencidos() {
		return this.activardescripcionCobrarSaldosVencidos;
	}

	public void setActivardescripcionCobrarSaldosVencidos(Boolean activardescripcionCobrarSaldosVencidos) {
		this.activardescripcionCobrarSaldosVencidos= activardescripcionCobrarSaldosVencidos;
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
		
		
		this.setMostraridCobrarSaldosVencidos(esInicial);
		this.setMostrarid_grupo_clienteCobrarSaldosVencidos(esInicial);
		this.setMostrarid_empresaCobrarSaldosVencidos(esInicial);
		this.setMostrarnumero_facturaCobrarSaldosVencidos(esInicial);
		this.setMostrarnombre_grupo_clienteCobrarSaldosVencidos(esInicial);
		this.setMostrarcodigoCobrarSaldosVencidos(esInicial);
		this.setMostrarnombreCobrarSaldosVencidos(esInicial);
		this.setMostrarfechaCobrarSaldosVencidos(esInicial);
		this.setMostrarfecha_venceCobrarSaldosVencidos(esInicial);
		this.setMostrarfecha_emisionCobrarSaldosVencidos(esInicial);
		this.setMostrarsaldoCobrarSaldosVencidos(esInicial);
		this.setMostrartelefono_telefonoCobrarSaldosVencidos(esInicial);
		this.setMostrardescripcionCobrarSaldosVencidos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.ID)) {
				this.setMostraridCobrarSaldosVencidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.IDGRUPOCLIENTE)) {
				this.setMostrarid_grupo_clienteCobrarSaldosVencidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCobrarSaldosVencidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.NUMEROFACTURA)) {
				this.setMostrarnumero_facturaCobrarSaldosVencidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.NOMBREGRUPOCLIENTE)) {
				this.setMostrarnombre_grupo_clienteCobrarSaldosVencidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoCobrarSaldosVencidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreCobrarSaldosVencidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.FECHA)) {
				this.setMostrarfechaCobrarSaldosVencidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.FECHAVENCE)) {
				this.setMostrarfecha_venceCobrarSaldosVencidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionCobrarSaldosVencidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.SALDO)) {
				this.setMostrarsaldoCobrarSaldosVencidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.TELEFONOTELEFONO)) {
				this.setMostrartelefono_telefonoCobrarSaldosVencidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionCobrarSaldosVencidos(esAsigna);
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
		
		
		this.setActivaridCobrarSaldosVencidos(esInicial);
		this.setActivarid_grupo_clienteCobrarSaldosVencidos(esInicial);
		this.setActivarid_empresaCobrarSaldosVencidos(esInicial);
		this.setActivarnumero_facturaCobrarSaldosVencidos(esInicial);
		this.setActivarnombre_grupo_clienteCobrarSaldosVencidos(esInicial);
		this.setActivarcodigoCobrarSaldosVencidos(esInicial);
		this.setActivarnombreCobrarSaldosVencidos(esInicial);
		this.setActivarfechaCobrarSaldosVencidos(esInicial);
		this.setActivarfecha_venceCobrarSaldosVencidos(esInicial);
		this.setActivarfecha_emisionCobrarSaldosVencidos(esInicial);
		this.setActivarsaldoCobrarSaldosVencidos(esInicial);
		this.setActivartelefono_telefonoCobrarSaldosVencidos(esInicial);
		this.setActivardescripcionCobrarSaldosVencidos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.ID)) {
				this.setActivaridCobrarSaldosVencidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.IDGRUPOCLIENTE)) {
				this.setActivarid_grupo_clienteCobrarSaldosVencidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCobrarSaldosVencidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.NUMEROFACTURA)) {
				this.setActivarnumero_facturaCobrarSaldosVencidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.NOMBREGRUPOCLIENTE)) {
				this.setActivarnombre_grupo_clienteCobrarSaldosVencidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.CODIGO)) {
				this.setActivarcodigoCobrarSaldosVencidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.NOMBRE)) {
				this.setActivarnombreCobrarSaldosVencidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.FECHA)) {
				this.setActivarfechaCobrarSaldosVencidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.FECHAVENCE)) {
				this.setActivarfecha_venceCobrarSaldosVencidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionCobrarSaldosVencidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.SALDO)) {
				this.setActivarsaldoCobrarSaldosVencidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.TELEFONOTELEFONO)) {
				this.setActivartelefono_telefonoCobrarSaldosVencidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionCobrarSaldosVencidos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CobrarSaldosVencidosBeanSwingJInternalFrame cobrarsaldosvencidosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCobrarSaldosVencidos(esInicial);
		this.setResaltarid_grupo_clienteCobrarSaldosVencidos(esInicial);
		this.setResaltarid_empresaCobrarSaldosVencidos(esInicial);
		this.setResaltarnumero_facturaCobrarSaldosVencidos(esInicial);
		this.setResaltarnombre_grupo_clienteCobrarSaldosVencidos(esInicial);
		this.setResaltarcodigoCobrarSaldosVencidos(esInicial);
		this.setResaltarnombreCobrarSaldosVencidos(esInicial);
		this.setResaltarfechaCobrarSaldosVencidos(esInicial);
		this.setResaltarfecha_venceCobrarSaldosVencidos(esInicial);
		this.setResaltarfecha_emisionCobrarSaldosVencidos(esInicial);
		this.setResaltarsaldoCobrarSaldosVencidos(esInicial);
		this.setResaltartelefono_telefonoCobrarSaldosVencidos(esInicial);
		this.setResaltardescripcionCobrarSaldosVencidos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.ID)) {
				this.setResaltaridCobrarSaldosVencidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.IDGRUPOCLIENTE)) {
				this.setResaltarid_grupo_clienteCobrarSaldosVencidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCobrarSaldosVencidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.NUMEROFACTURA)) {
				this.setResaltarnumero_facturaCobrarSaldosVencidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.NOMBREGRUPOCLIENTE)) {
				this.setResaltarnombre_grupo_clienteCobrarSaldosVencidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoCobrarSaldosVencidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreCobrarSaldosVencidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.FECHA)) {
				this.setResaltarfechaCobrarSaldosVencidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.FECHAVENCE)) {
				this.setResaltarfecha_venceCobrarSaldosVencidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionCobrarSaldosVencidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.SALDO)) {
				this.setResaltarsaldoCobrarSaldosVencidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.TELEFONOTELEFONO)) {
				this.setResaltartelefono_telefonoCobrarSaldosVencidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarSaldosVencidosConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionCobrarSaldosVencidos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CobrarSaldosVencidosBeanSwingJInternalFrame cobrarsaldosvencidosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaCobrarSaldosVencidosCobrarSaldosVencidos=true;

	public Boolean getMostrarBusquedaCobrarSaldosVencidosCobrarSaldosVencidos() {
		return this.mostrarBusquedaCobrarSaldosVencidosCobrarSaldosVencidos;
	}

	public void setMostrarBusquedaCobrarSaldosVencidosCobrarSaldosVencidos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaCobrarSaldosVencidosCobrarSaldosVencidos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaCobrarSaldosVencidosCobrarSaldosVencidos=true;

	public Boolean getActivarBusquedaCobrarSaldosVencidosCobrarSaldosVencidos() {
		return this.activarBusquedaCobrarSaldosVencidosCobrarSaldosVencidos;
	}

	public void setActivarBusquedaCobrarSaldosVencidosCobrarSaldosVencidos(Boolean habilitarResaltar) {
		this.activarBusquedaCobrarSaldosVencidosCobrarSaldosVencidos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaCobrarSaldosVencidosCobrarSaldosVencidos=null;

	public Border getResaltarBusquedaCobrarSaldosVencidosCobrarSaldosVencidos() {
		return this.resaltarBusquedaCobrarSaldosVencidosCobrarSaldosVencidos;
	}

	public void setResaltarBusquedaCobrarSaldosVencidosCobrarSaldosVencidos(Border borderResaltar) {
		this.resaltarBusquedaCobrarSaldosVencidosCobrarSaldosVencidos= borderResaltar;
	}

	public void setResaltarBusquedaCobrarSaldosVencidosCobrarSaldosVencidos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarSaldosVencidosBeanSwingJInternalFrame cobrarsaldosvencidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaCobrarSaldosVencidosCobrarSaldosVencidos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}