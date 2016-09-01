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
package com.bydan.erp.tesoreria.util;

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


import com.bydan.erp.tesoreria.util.BancoTipoCuentaBancoGlobalConstantesFunciones;
import com.bydan.erp.tesoreria.util.BancoTipoCuentaBancoGlobalParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.BancoTipoCuentaBancoGlobalParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class BancoTipoCuentaBancoGlobalConstantesFunciones extends BancoTipoCuentaBancoGlobalConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="BancoTipoCuentaBancoGlobal";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="BancoTipoCuentaBancoGlobal"+BancoTipoCuentaBancoGlobalConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="BancoTipoCuentaBancoGlobalHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="BancoTipoCuentaBancoGlobalHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=BancoTipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"_"+BancoTipoCuentaBancoGlobalConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/BancoTipoCuentaBancoGlobalHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=BancoTipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"_"+BancoTipoCuentaBancoGlobalConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=BancoTipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"_"+BancoTipoCuentaBancoGlobalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/BancoTipoCuentaBancoGlobalHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=BancoTipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"_"+BancoTipoCuentaBancoGlobalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BancoTipoCuentaBancoGlobalConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/BancoTipoCuentaBancoGlobalHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BancoTipoCuentaBancoGlobalConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BancoTipoCuentaBancoGlobalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/BancoTipoCuentaBancoGlobalHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BancoTipoCuentaBancoGlobalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=BancoTipoCuentaBancoGlobalConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+BancoTipoCuentaBancoGlobalConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=BancoTipoCuentaBancoGlobalConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+BancoTipoCuentaBancoGlobalConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Banco Tipo Cuenta Banco Globales";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Banco Tipo Cuenta Banco Global";
	public static final String SCLASSWEBTITULO_LOWER="Banco Tipo Cuenta Banco Global";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="BancoTipoCuentaBancoGlobal";
	public static final String OBJECTNAME="bancotipocuentabancoglobal";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="banco_tipo_cuenta_banco_global";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select bancotipocuentabancoglobal from "+BancoTipoCuentaBancoGlobalConstantesFunciones.SPERSISTENCENAME+" bancotipocuentabancoglobal";
	public static String QUERYSELECTNATIVE="select "+BancoTipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"."+BancoTipoCuentaBancoGlobalConstantesFunciones.TABLENAME+".id,"+BancoTipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"."+BancoTipoCuentaBancoGlobalConstantesFunciones.TABLENAME+".version_row,"+BancoTipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"."+BancoTipoCuentaBancoGlobalConstantesFunciones.TABLENAME+".id_empresa,"+BancoTipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"."+BancoTipoCuentaBancoGlobalConstantesFunciones.TABLENAME+".id_banco,"+BancoTipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"."+BancoTipoCuentaBancoGlobalConstantesFunciones.TABLENAME+".id_tipo_cuenta_banco_global from "+BancoTipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"."+BancoTipoCuentaBancoGlobalConstantesFunciones.TABLENAME;//+" as "+BancoTipoCuentaBancoGlobalConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected BancoTipoCuentaBancoGlobalConstantesFuncionesAdditional bancotipocuentabancoglobalConstantesFuncionesAdditional=null;
	
	public BancoTipoCuentaBancoGlobalConstantesFuncionesAdditional getBancoTipoCuentaBancoGlobalConstantesFuncionesAdditional() {
		return this.bancotipocuentabancoglobalConstantesFuncionesAdditional;
	}
	
	public void setBancoTipoCuentaBancoGlobalConstantesFuncionesAdditional(BancoTipoCuentaBancoGlobalConstantesFuncionesAdditional bancotipocuentabancoglobalConstantesFuncionesAdditional) {
		try {
			this.bancotipocuentabancoglobalConstantesFuncionesAdditional=bancotipocuentabancoglobalConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDBANCO= "id_banco";
    public static final String IDTIPOCUENTABANCOGLOBAL= "id_tipo_cuenta_banco_global";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDBANCO= "Banco";
		public static final String LABEL_IDBANCO_LOWER= "Banco";
    	public static final String LABEL_IDTIPOCUENTABANCOGLOBAL= "Tipo Cuenta Banco Global";
		public static final String LABEL_IDTIPOCUENTABANCOGLOBAL_LOWER= "Tipo Cuenta Banco Global";
	
		
		
		
		
		
	
	public static String getBancoTipoCuentaBancoGlobalLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(BancoTipoCuentaBancoGlobalConstantesFunciones.IDEMPRESA)) {sLabelColumna=BancoTipoCuentaBancoGlobalConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(BancoTipoCuentaBancoGlobalConstantesFunciones.IDBANCO)) {sLabelColumna=BancoTipoCuentaBancoGlobalConstantesFunciones.LABEL_IDBANCO;}
		if(sNombreColumna.equals(BancoTipoCuentaBancoGlobalConstantesFunciones.IDTIPOCUENTABANCOGLOBAL)) {sLabelColumna=BancoTipoCuentaBancoGlobalConstantesFunciones.LABEL_IDTIPOCUENTABANCOGLOBAL;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getBancoTipoCuentaBancoGlobalDescripcion(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(bancotipocuentabancoglobal !=null/* && bancotipocuentabancoglobal.getId()!=0*/) {
			if(bancotipocuentabancoglobal.getId()!=null) {
				sDescripcion=bancotipocuentabancoglobal.getId().toString();
			}//bancotipocuentabancoglobalbancotipocuentabancoglobal.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getBancoTipoCuentaBancoGlobalDescripcionDetallado(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal) {
		String sDescripcion="";
			
		sDescripcion+=BancoTipoCuentaBancoGlobalConstantesFunciones.ID+"=";
		sDescripcion+=bancotipocuentabancoglobal.getId().toString()+",";
		sDescripcion+=BancoTipoCuentaBancoGlobalConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=bancotipocuentabancoglobal.getVersionRow().toString()+",";
		sDescripcion+=BancoTipoCuentaBancoGlobalConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=bancotipocuentabancoglobal.getid_empresa().toString()+",";
		sDescripcion+=BancoTipoCuentaBancoGlobalConstantesFunciones.IDBANCO+"=";
		sDescripcion+=bancotipocuentabancoglobal.getid_banco().toString()+",";
		sDescripcion+=BancoTipoCuentaBancoGlobalConstantesFunciones.IDTIPOCUENTABANCOGLOBAL+"=";
		sDescripcion+=bancotipocuentabancoglobal.getid_tipo_cuenta_banco_global().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setBancoTipoCuentaBancoGlobalDescripcion(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal,String sValor) throws Exception {			
		if(bancotipocuentabancoglobal !=null) {
			//bancotipocuentabancoglobalbancotipocuentabancoglobal.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getBancoDescripcion(Banco banco) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(banco!=null/*&&banco.getId()>0*/) {
			sDescripcion=BancoConstantesFunciones.getBancoDescripcion(banco);
		}

		return sDescripcion;
	}

	public static String getTipoCuentaBancoGlobalDescripcion(TipoCuentaBancoGlobal tipocuentabancoglobal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocuentabancoglobal!=null/*&&tipocuentabancoglobal.getId()>0*/) {
			sDescripcion=TipoCuentaBancoGlobalConstantesFunciones.getTipoCuentaBancoGlobalDescripcion(tipocuentabancoglobal);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdBanco")) {
			sNombreIndice="Tipo=  Por Banco";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdTipoCuentaBancoGlobal")) {
			sNombreIndice="Tipo=  Por Tipo Cuenta Banco Global";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdBanco(Long id_banco) {
		String sDetalleIndice=" Parametros->";
		if(id_banco!=null) {sDetalleIndice+=" Codigo Unico De Banco="+id_banco.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoCuentaBancoGlobal(Long id_tipo_cuenta_banco_global) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_cuenta_banco_global!=null) {sDetalleIndice+=" Codigo Unico De Tipo Cuenta Banco Global="+id_tipo_cuenta_banco_global.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosBancoTipoCuentaBancoGlobal(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosBancoTipoCuentaBancoGlobals(List<BancoTipoCuentaBancoGlobal> bancotipocuentabancoglobals,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal: bancotipocuentabancoglobals) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresBancoTipoCuentaBancoGlobal(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && bancotipocuentabancoglobal.getConCambioAuxiliar()) {
			bancotipocuentabancoglobal.setIsDeleted(bancotipocuentabancoglobal.getIsDeletedAuxiliar());	
			bancotipocuentabancoglobal.setIsNew(bancotipocuentabancoglobal.getIsNewAuxiliar());	
			bancotipocuentabancoglobal.setIsChanged(bancotipocuentabancoglobal.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			bancotipocuentabancoglobal.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			bancotipocuentabancoglobal.setIsDeletedAuxiliar(false);	
			bancotipocuentabancoglobal.setIsNewAuxiliar(false);	
			bancotipocuentabancoglobal.setIsChangedAuxiliar(false);
			
			bancotipocuentabancoglobal.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresBancoTipoCuentaBancoGlobals(List<BancoTipoCuentaBancoGlobal> bancotipocuentabancoglobals,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal : bancotipocuentabancoglobals) {
			if(conAsignarBase && bancotipocuentabancoglobal.getConCambioAuxiliar()) {
				bancotipocuentabancoglobal.setIsDeleted(bancotipocuentabancoglobal.getIsDeletedAuxiliar());	
				bancotipocuentabancoglobal.setIsNew(bancotipocuentabancoglobal.getIsNewAuxiliar());	
				bancotipocuentabancoglobal.setIsChanged(bancotipocuentabancoglobal.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				bancotipocuentabancoglobal.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				bancotipocuentabancoglobal.setIsDeletedAuxiliar(false);	
				bancotipocuentabancoglobal.setIsNewAuxiliar(false);	
				bancotipocuentabancoglobal.setIsChangedAuxiliar(false);
				
				bancotipocuentabancoglobal.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresBancoTipoCuentaBancoGlobal(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresBancoTipoCuentaBancoGlobals(List<BancoTipoCuentaBancoGlobal> bancotipocuentabancoglobals,Boolean conEnteros) throws Exception  {
		
		for(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal: bancotipocuentabancoglobals) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaBancoTipoCuentaBancoGlobal(List<BancoTipoCuentaBancoGlobal> bancotipocuentabancoglobals,BancoTipoCuentaBancoGlobal bancotipocuentabancoglobalAux) throws Exception  {
		BancoTipoCuentaBancoGlobalConstantesFunciones.InicializarValoresBancoTipoCuentaBancoGlobal(bancotipocuentabancoglobalAux,true);
		
		for(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal: bancotipocuentabancoglobals) {
			if(bancotipocuentabancoglobal.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesBancoTipoCuentaBancoGlobal(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=BancoTipoCuentaBancoGlobalConstantesFunciones.getArrayColumnasGlobalesBancoTipoCuentaBancoGlobal(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesBancoTipoCuentaBancoGlobal(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(BancoTipoCuentaBancoGlobalConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(BancoTipoCuentaBancoGlobalConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoBancoTipoCuentaBancoGlobal(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<BancoTipoCuentaBancoGlobal> bancotipocuentabancoglobals,BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobalAux: bancotipocuentabancoglobals) {
			if(bancotipocuentabancoglobalAux!=null && bancotipocuentabancoglobal!=null) {
				if((bancotipocuentabancoglobalAux.getId()==null && bancotipocuentabancoglobal.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(bancotipocuentabancoglobalAux.getId()!=null && bancotipocuentabancoglobal.getId()!=null){
					if(bancotipocuentabancoglobalAux.getId().equals(bancotipocuentabancoglobal.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaBancoTipoCuentaBancoGlobal(List<BancoTipoCuentaBancoGlobal> bancotipocuentabancoglobals) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal: bancotipocuentabancoglobals) {			
			if(bancotipocuentabancoglobal.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaBancoTipoCuentaBancoGlobal() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,BancoTipoCuentaBancoGlobalConstantesFunciones.LABEL_ID, BancoTipoCuentaBancoGlobalConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BancoTipoCuentaBancoGlobalConstantesFunciones.LABEL_VERSIONROW, BancoTipoCuentaBancoGlobalConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BancoTipoCuentaBancoGlobalConstantesFunciones.LABEL_IDEMPRESA, BancoTipoCuentaBancoGlobalConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BancoTipoCuentaBancoGlobalConstantesFunciones.LABEL_IDBANCO, BancoTipoCuentaBancoGlobalConstantesFunciones.IDBANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BancoTipoCuentaBancoGlobalConstantesFunciones.LABEL_IDTIPOCUENTABANCOGLOBAL, BancoTipoCuentaBancoGlobalConstantesFunciones.IDTIPOCUENTABANCOGLOBAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasBancoTipoCuentaBancoGlobal() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=BancoTipoCuentaBancoGlobalConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BancoTipoCuentaBancoGlobalConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BancoTipoCuentaBancoGlobalConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BancoTipoCuentaBancoGlobalConstantesFunciones.IDBANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BancoTipoCuentaBancoGlobalConstantesFunciones.IDTIPOCUENTABANCOGLOBAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBancoTipoCuentaBancoGlobal() throws Exception  {
		return BancoTipoCuentaBancoGlobalConstantesFunciones.getTiposSeleccionarBancoTipoCuentaBancoGlobal(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBancoTipoCuentaBancoGlobal(Boolean conFk) throws Exception  {
		return BancoTipoCuentaBancoGlobalConstantesFunciones.getTiposSeleccionarBancoTipoCuentaBancoGlobal(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBancoTipoCuentaBancoGlobal(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BancoTipoCuentaBancoGlobalConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(BancoTipoCuentaBancoGlobalConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BancoTipoCuentaBancoGlobalConstantesFunciones.LABEL_IDBANCO);
			reporte.setsDescripcion(BancoTipoCuentaBancoGlobalConstantesFunciones.LABEL_IDBANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BancoTipoCuentaBancoGlobalConstantesFunciones.LABEL_IDTIPOCUENTABANCOGLOBAL);
			reporte.setsDescripcion(BancoTipoCuentaBancoGlobalConstantesFunciones.LABEL_IDTIPOCUENTABANCOGLOBAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesBancoTipoCuentaBancoGlobal(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesBancoTipoCuentaBancoGlobal(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobalAux) throws Exception {
		
			bancotipocuentabancoglobalAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(bancotipocuentabancoglobalAux.getEmpresa()));
			bancotipocuentabancoglobalAux.setbanco_descripcion(BancoConstantesFunciones.getBancoDescripcion(bancotipocuentabancoglobalAux.getBanco()));
			bancotipocuentabancoglobalAux.settipocuentabancoglobal_descripcion(TipoCuentaBancoGlobalConstantesFunciones.getTipoCuentaBancoGlobalDescripcion(bancotipocuentabancoglobalAux.getTipoCuentaBancoGlobal()));		
	}
	
	public static void refrescarForeignKeysDescripcionesBancoTipoCuentaBancoGlobal(List<BancoTipoCuentaBancoGlobal> bancotipocuentabancoglobalsTemp) throws Exception {
		for(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobalAux:bancotipocuentabancoglobalsTemp) {
			
			bancotipocuentabancoglobalAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(bancotipocuentabancoglobalAux.getEmpresa()));
			bancotipocuentabancoglobalAux.setbanco_descripcion(BancoConstantesFunciones.getBancoDescripcion(bancotipocuentabancoglobalAux.getBanco()));
			bancotipocuentabancoglobalAux.settipocuentabancoglobal_descripcion(TipoCuentaBancoGlobalConstantesFunciones.getTipoCuentaBancoGlobalDescripcion(bancotipocuentabancoglobalAux.getTipoCuentaBancoGlobal()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfBancoTipoCuentaBancoGlobal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Banco.class));
				classes.add(new Classe(TipoCuentaBancoGlobal.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Banco.class)) {
						classes.add(new Classe(Banco.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoCuentaBancoGlobal.class)) {
						classes.add(new Classe(TipoCuentaBancoGlobal.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfBancoTipoCuentaBancoGlobal(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Banco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Banco.class)); continue;
					}

					if(TipoCuentaBancoGlobal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCuentaBancoGlobal.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Banco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Banco.class)); continue;
					}

					if(TipoCuentaBancoGlobal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCuentaBancoGlobal.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfBancoTipoCuentaBancoGlobal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return BancoTipoCuentaBancoGlobalConstantesFunciones.getClassesRelationshipsOfBancoTipoCuentaBancoGlobal(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfBancoTipoCuentaBancoGlobal(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfBancoTipoCuentaBancoGlobal(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return BancoTipoCuentaBancoGlobalConstantesFunciones.getClassesRelationshipsFromStringsOfBancoTipoCuentaBancoGlobal(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfBancoTipoCuentaBancoGlobal(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal,List<BancoTipoCuentaBancoGlobal> bancotipocuentabancoglobals,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			BancoTipoCuentaBancoGlobal bancotipocuentabancoglobalEncontrado=null;
			
			for(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobalLocal:bancotipocuentabancoglobals) {
				if(bancotipocuentabancoglobalLocal.getId().equals(bancotipocuentabancoglobal.getId())) {
					bancotipocuentabancoglobalEncontrado=bancotipocuentabancoglobalLocal;
					
					bancotipocuentabancoglobalLocal.setIsChanged(bancotipocuentabancoglobal.getIsChanged());
					bancotipocuentabancoglobalLocal.setIsNew(bancotipocuentabancoglobal.getIsNew());
					bancotipocuentabancoglobalLocal.setIsDeleted(bancotipocuentabancoglobal.getIsDeleted());
					
					bancotipocuentabancoglobalLocal.setGeneralEntityOriginal(bancotipocuentabancoglobal.getGeneralEntityOriginal());
					
					bancotipocuentabancoglobalLocal.setId(bancotipocuentabancoglobal.getId());	
					bancotipocuentabancoglobalLocal.setVersionRow(bancotipocuentabancoglobal.getVersionRow());	
					bancotipocuentabancoglobalLocal.setid_empresa(bancotipocuentabancoglobal.getid_empresa());	
					bancotipocuentabancoglobalLocal.setid_banco(bancotipocuentabancoglobal.getid_banco());	
					bancotipocuentabancoglobalLocal.setid_tipo_cuenta_banco_global(bancotipocuentabancoglobal.getid_tipo_cuenta_banco_global());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!bancotipocuentabancoglobal.getIsDeleted()) {
				if(!existe) {
					bancotipocuentabancoglobals.add(bancotipocuentabancoglobal);
				}
			} else {
				if(bancotipocuentabancoglobalEncontrado!=null && permiteQuitar)  {
					bancotipocuentabancoglobals.remove(bancotipocuentabancoglobalEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal,List<BancoTipoCuentaBancoGlobal> bancotipocuentabancoglobals) throws Exception {
		try	{			
			for(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobalLocal:bancotipocuentabancoglobals) {
				if(bancotipocuentabancoglobalLocal.getId().equals(bancotipocuentabancoglobal.getId())) {
					bancotipocuentabancoglobalLocal.setIsSelected(bancotipocuentabancoglobal.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesBancoTipoCuentaBancoGlobal(List<BancoTipoCuentaBancoGlobal> bancotipocuentabancoglobalsAux) throws Exception {
		//this.bancotipocuentabancoglobalsAux=bancotipocuentabancoglobalsAux;
		
		for(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobalAux:bancotipocuentabancoglobalsAux) {
			if(bancotipocuentabancoglobalAux.getIsChanged()) {
				bancotipocuentabancoglobalAux.setIsChanged(false);
			}		
			
			if(bancotipocuentabancoglobalAux.getIsNew()) {
				bancotipocuentabancoglobalAux.setIsNew(false);
			}	
			
			if(bancotipocuentabancoglobalAux.getIsDeleted()) {
				bancotipocuentabancoglobalAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesBancoTipoCuentaBancoGlobal(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobalAux) throws Exception {
		//this.bancotipocuentabancoglobalAux=bancotipocuentabancoglobalAux;
		
			if(bancotipocuentabancoglobalAux.getIsChanged()) {
				bancotipocuentabancoglobalAux.setIsChanged(false);
			}		
			
			if(bancotipocuentabancoglobalAux.getIsNew()) {
				bancotipocuentabancoglobalAux.setIsNew(false);
			}	
			
			if(bancotipocuentabancoglobalAux.getIsDeleted()) {
				bancotipocuentabancoglobalAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobalAsignar,BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal) throws Exception {
		bancotipocuentabancoglobalAsignar.setId(bancotipocuentabancoglobal.getId());	
		bancotipocuentabancoglobalAsignar.setVersionRow(bancotipocuentabancoglobal.getVersionRow());	
		bancotipocuentabancoglobalAsignar.setid_empresa(bancotipocuentabancoglobal.getid_empresa());
		bancotipocuentabancoglobalAsignar.setempresa_descripcion(bancotipocuentabancoglobal.getempresa_descripcion());	
		bancotipocuentabancoglobalAsignar.setid_banco(bancotipocuentabancoglobal.getid_banco());
		bancotipocuentabancoglobalAsignar.setbanco_descripcion(bancotipocuentabancoglobal.getbanco_descripcion());	
		bancotipocuentabancoglobalAsignar.setid_tipo_cuenta_banco_global(bancotipocuentabancoglobal.getid_tipo_cuenta_banco_global());
		bancotipocuentabancoglobalAsignar.settipocuentabancoglobal_descripcion(bancotipocuentabancoglobal.gettipocuentabancoglobal_descripcion());	
	}
	
	public static void inicializarBancoTipoCuentaBancoGlobal(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal) throws Exception {
		try {
				bancotipocuentabancoglobal.setId(0L);	
					
				bancotipocuentabancoglobal.setid_empresa(-1L);	
				bancotipocuentabancoglobal.setid_banco(-1L);	
				bancotipocuentabancoglobal.setid_tipo_cuenta_banco_global(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderBancoTipoCuentaBancoGlobal(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(BancoTipoCuentaBancoGlobalConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BancoTipoCuentaBancoGlobalConstantesFunciones.LABEL_IDBANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BancoTipoCuentaBancoGlobalConstantesFunciones.LABEL_IDTIPOCUENTABANCOGLOBAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataBancoTipoCuentaBancoGlobal(String sTipo,Row row,Workbook workbook,BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(bancotipocuentabancoglobal.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bancotipocuentabancoglobal.getbanco_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bancotipocuentabancoglobal.gettipocuentabancoglobal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryBancoTipoCuentaBancoGlobal=Constantes.SFINALQUERY;
	
	public String getsFinalQueryBancoTipoCuentaBancoGlobal() {
		return this.sFinalQueryBancoTipoCuentaBancoGlobal;
	}
	
	public void setsFinalQueryBancoTipoCuentaBancoGlobal(String sFinalQueryBancoTipoCuentaBancoGlobal) {
		this.sFinalQueryBancoTipoCuentaBancoGlobal= sFinalQueryBancoTipoCuentaBancoGlobal;
	}
	
	public Border resaltarSeleccionarBancoTipoCuentaBancoGlobal=null;
	
	public Border setResaltarSeleccionarBancoTipoCuentaBancoGlobal(ParametroGeneralUsuario parametroGeneralUsuario/*BancoTipoCuentaBancoGlobalBeanSwingJInternalFrame bancotipocuentabancoglobalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//bancotipocuentabancoglobalBeanSwingJInternalFrame.jTtoolBarBancoTipoCuentaBancoGlobal.setBorder(borderResaltar);
		
		this.resaltarSeleccionarBancoTipoCuentaBancoGlobal= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarBancoTipoCuentaBancoGlobal() {
		return this.resaltarSeleccionarBancoTipoCuentaBancoGlobal;
	}
	
	public void setResaltarSeleccionarBancoTipoCuentaBancoGlobal(Border borderResaltarSeleccionarBancoTipoCuentaBancoGlobal) {
		this.resaltarSeleccionarBancoTipoCuentaBancoGlobal= borderResaltarSeleccionarBancoTipoCuentaBancoGlobal;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridBancoTipoCuentaBancoGlobal=null;
	public Boolean mostraridBancoTipoCuentaBancoGlobal=true;
	public Boolean activaridBancoTipoCuentaBancoGlobal=true;

	public Border resaltarid_empresaBancoTipoCuentaBancoGlobal=null;
	public Boolean mostrarid_empresaBancoTipoCuentaBancoGlobal=true;
	public Boolean activarid_empresaBancoTipoCuentaBancoGlobal=true;
	public Boolean cargarid_empresaBancoTipoCuentaBancoGlobal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaBancoTipoCuentaBancoGlobal=false;//ConEventDepend=true

	public Border resaltarid_bancoBancoTipoCuentaBancoGlobal=null;
	public Boolean mostrarid_bancoBancoTipoCuentaBancoGlobal=true;
	public Boolean activarid_bancoBancoTipoCuentaBancoGlobal=true;
	public Boolean cargarid_bancoBancoTipoCuentaBancoGlobal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bancoBancoTipoCuentaBancoGlobal=false;//ConEventDepend=true

	public Border resaltarid_tipo_cuenta_banco_globalBancoTipoCuentaBancoGlobal=null;
	public Boolean mostrarid_tipo_cuenta_banco_globalBancoTipoCuentaBancoGlobal=true;
	public Boolean activarid_tipo_cuenta_banco_globalBancoTipoCuentaBancoGlobal=true;
	public Boolean cargarid_tipo_cuenta_banco_globalBancoTipoCuentaBancoGlobal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_cuenta_banco_globalBancoTipoCuentaBancoGlobal=false;//ConEventDepend=true

	
	

	public Border setResaltaridBancoTipoCuentaBancoGlobal(ParametroGeneralUsuario parametroGeneralUsuario/*BancoTipoCuentaBancoGlobalBeanSwingJInternalFrame bancotipocuentabancoglobalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bancotipocuentabancoglobalBeanSwingJInternalFrame.jTtoolBarBancoTipoCuentaBancoGlobal.setBorder(borderResaltar);
		
		this.resaltaridBancoTipoCuentaBancoGlobal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridBancoTipoCuentaBancoGlobal() {
		return this.resaltaridBancoTipoCuentaBancoGlobal;
	}

	public void setResaltaridBancoTipoCuentaBancoGlobal(Border borderResaltar) {
		this.resaltaridBancoTipoCuentaBancoGlobal= borderResaltar;
	}

	public Boolean getMostraridBancoTipoCuentaBancoGlobal() {
		return this.mostraridBancoTipoCuentaBancoGlobal;
	}

	public void setMostraridBancoTipoCuentaBancoGlobal(Boolean mostraridBancoTipoCuentaBancoGlobal) {
		this.mostraridBancoTipoCuentaBancoGlobal= mostraridBancoTipoCuentaBancoGlobal;
	}

	public Boolean getActivaridBancoTipoCuentaBancoGlobal() {
		return this.activaridBancoTipoCuentaBancoGlobal;
	}

	public void setActivaridBancoTipoCuentaBancoGlobal(Boolean activaridBancoTipoCuentaBancoGlobal) {
		this.activaridBancoTipoCuentaBancoGlobal= activaridBancoTipoCuentaBancoGlobal;
	}

	public Border setResaltarid_empresaBancoTipoCuentaBancoGlobal(ParametroGeneralUsuario parametroGeneralUsuario/*BancoTipoCuentaBancoGlobalBeanSwingJInternalFrame bancotipocuentabancoglobalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bancotipocuentabancoglobalBeanSwingJInternalFrame.jTtoolBarBancoTipoCuentaBancoGlobal.setBorder(borderResaltar);
		
		this.resaltarid_empresaBancoTipoCuentaBancoGlobal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaBancoTipoCuentaBancoGlobal() {
		return this.resaltarid_empresaBancoTipoCuentaBancoGlobal;
	}

	public void setResaltarid_empresaBancoTipoCuentaBancoGlobal(Border borderResaltar) {
		this.resaltarid_empresaBancoTipoCuentaBancoGlobal= borderResaltar;
	}

	public Boolean getMostrarid_empresaBancoTipoCuentaBancoGlobal() {
		return this.mostrarid_empresaBancoTipoCuentaBancoGlobal;
	}

	public void setMostrarid_empresaBancoTipoCuentaBancoGlobal(Boolean mostrarid_empresaBancoTipoCuentaBancoGlobal) {
		this.mostrarid_empresaBancoTipoCuentaBancoGlobal= mostrarid_empresaBancoTipoCuentaBancoGlobal;
	}

	public Boolean getActivarid_empresaBancoTipoCuentaBancoGlobal() {
		return this.activarid_empresaBancoTipoCuentaBancoGlobal;
	}

	public void setActivarid_empresaBancoTipoCuentaBancoGlobal(Boolean activarid_empresaBancoTipoCuentaBancoGlobal) {
		this.activarid_empresaBancoTipoCuentaBancoGlobal= activarid_empresaBancoTipoCuentaBancoGlobal;
	}

	public Boolean getCargarid_empresaBancoTipoCuentaBancoGlobal() {
		return this.cargarid_empresaBancoTipoCuentaBancoGlobal;
	}

	public void setCargarid_empresaBancoTipoCuentaBancoGlobal(Boolean cargarid_empresaBancoTipoCuentaBancoGlobal) {
		this.cargarid_empresaBancoTipoCuentaBancoGlobal= cargarid_empresaBancoTipoCuentaBancoGlobal;
	}

	public Border setResaltarid_bancoBancoTipoCuentaBancoGlobal(ParametroGeneralUsuario parametroGeneralUsuario/*BancoTipoCuentaBancoGlobalBeanSwingJInternalFrame bancotipocuentabancoglobalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bancotipocuentabancoglobalBeanSwingJInternalFrame.jTtoolBarBancoTipoCuentaBancoGlobal.setBorder(borderResaltar);
		
		this.resaltarid_bancoBancoTipoCuentaBancoGlobal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bancoBancoTipoCuentaBancoGlobal() {
		return this.resaltarid_bancoBancoTipoCuentaBancoGlobal;
	}

	public void setResaltarid_bancoBancoTipoCuentaBancoGlobal(Border borderResaltar) {
		this.resaltarid_bancoBancoTipoCuentaBancoGlobal= borderResaltar;
	}

	public Boolean getMostrarid_bancoBancoTipoCuentaBancoGlobal() {
		return this.mostrarid_bancoBancoTipoCuentaBancoGlobal;
	}

	public void setMostrarid_bancoBancoTipoCuentaBancoGlobal(Boolean mostrarid_bancoBancoTipoCuentaBancoGlobal) {
		this.mostrarid_bancoBancoTipoCuentaBancoGlobal= mostrarid_bancoBancoTipoCuentaBancoGlobal;
	}

	public Boolean getActivarid_bancoBancoTipoCuentaBancoGlobal() {
		return this.activarid_bancoBancoTipoCuentaBancoGlobal;
	}

	public void setActivarid_bancoBancoTipoCuentaBancoGlobal(Boolean activarid_bancoBancoTipoCuentaBancoGlobal) {
		this.activarid_bancoBancoTipoCuentaBancoGlobal= activarid_bancoBancoTipoCuentaBancoGlobal;
	}

	public Boolean getCargarid_bancoBancoTipoCuentaBancoGlobal() {
		return this.cargarid_bancoBancoTipoCuentaBancoGlobal;
	}

	public void setCargarid_bancoBancoTipoCuentaBancoGlobal(Boolean cargarid_bancoBancoTipoCuentaBancoGlobal) {
		this.cargarid_bancoBancoTipoCuentaBancoGlobal= cargarid_bancoBancoTipoCuentaBancoGlobal;
	}

	public Border setResaltarid_tipo_cuenta_banco_globalBancoTipoCuentaBancoGlobal(ParametroGeneralUsuario parametroGeneralUsuario/*BancoTipoCuentaBancoGlobalBeanSwingJInternalFrame bancotipocuentabancoglobalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bancotipocuentabancoglobalBeanSwingJInternalFrame.jTtoolBarBancoTipoCuentaBancoGlobal.setBorder(borderResaltar);
		
		this.resaltarid_tipo_cuenta_banco_globalBancoTipoCuentaBancoGlobal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_cuenta_banco_globalBancoTipoCuentaBancoGlobal() {
		return this.resaltarid_tipo_cuenta_banco_globalBancoTipoCuentaBancoGlobal;
	}

	public void setResaltarid_tipo_cuenta_banco_globalBancoTipoCuentaBancoGlobal(Border borderResaltar) {
		this.resaltarid_tipo_cuenta_banco_globalBancoTipoCuentaBancoGlobal= borderResaltar;
	}

	public Boolean getMostrarid_tipo_cuenta_banco_globalBancoTipoCuentaBancoGlobal() {
		return this.mostrarid_tipo_cuenta_banco_globalBancoTipoCuentaBancoGlobal;
	}

	public void setMostrarid_tipo_cuenta_banco_globalBancoTipoCuentaBancoGlobal(Boolean mostrarid_tipo_cuenta_banco_globalBancoTipoCuentaBancoGlobal) {
		this.mostrarid_tipo_cuenta_banco_globalBancoTipoCuentaBancoGlobal= mostrarid_tipo_cuenta_banco_globalBancoTipoCuentaBancoGlobal;
	}

	public Boolean getActivarid_tipo_cuenta_banco_globalBancoTipoCuentaBancoGlobal() {
		return this.activarid_tipo_cuenta_banco_globalBancoTipoCuentaBancoGlobal;
	}

	public void setActivarid_tipo_cuenta_banco_globalBancoTipoCuentaBancoGlobal(Boolean activarid_tipo_cuenta_banco_globalBancoTipoCuentaBancoGlobal) {
		this.activarid_tipo_cuenta_banco_globalBancoTipoCuentaBancoGlobal= activarid_tipo_cuenta_banco_globalBancoTipoCuentaBancoGlobal;
	}

	public Boolean getCargarid_tipo_cuenta_banco_globalBancoTipoCuentaBancoGlobal() {
		return this.cargarid_tipo_cuenta_banco_globalBancoTipoCuentaBancoGlobal;
	}

	public void setCargarid_tipo_cuenta_banco_globalBancoTipoCuentaBancoGlobal(Boolean cargarid_tipo_cuenta_banco_globalBancoTipoCuentaBancoGlobal) {
		this.cargarid_tipo_cuenta_banco_globalBancoTipoCuentaBancoGlobal= cargarid_tipo_cuenta_banco_globalBancoTipoCuentaBancoGlobal;
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
		
		
		this.setMostraridBancoTipoCuentaBancoGlobal(esInicial);
		this.setMostrarid_empresaBancoTipoCuentaBancoGlobal(esInicial);
		this.setMostrarid_bancoBancoTipoCuentaBancoGlobal(esInicial);
		this.setMostrarid_tipo_cuenta_banco_globalBancoTipoCuentaBancoGlobal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BancoTipoCuentaBancoGlobalConstantesFunciones.ID)) {
				this.setMostraridBancoTipoCuentaBancoGlobal(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoTipoCuentaBancoGlobalConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaBancoTipoCuentaBancoGlobal(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoTipoCuentaBancoGlobalConstantesFunciones.IDBANCO)) {
				this.setMostrarid_bancoBancoTipoCuentaBancoGlobal(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoTipoCuentaBancoGlobalConstantesFunciones.IDTIPOCUENTABANCOGLOBAL)) {
				this.setMostrarid_tipo_cuenta_banco_globalBancoTipoCuentaBancoGlobal(esAsigna);
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
		
		
		this.setActivaridBancoTipoCuentaBancoGlobal(esInicial);
		this.setActivarid_empresaBancoTipoCuentaBancoGlobal(esInicial);
		this.setActivarid_bancoBancoTipoCuentaBancoGlobal(esInicial);
		this.setActivarid_tipo_cuenta_banco_globalBancoTipoCuentaBancoGlobal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BancoTipoCuentaBancoGlobalConstantesFunciones.ID)) {
				this.setActivaridBancoTipoCuentaBancoGlobal(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoTipoCuentaBancoGlobalConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaBancoTipoCuentaBancoGlobal(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoTipoCuentaBancoGlobalConstantesFunciones.IDBANCO)) {
				this.setActivarid_bancoBancoTipoCuentaBancoGlobal(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoTipoCuentaBancoGlobalConstantesFunciones.IDTIPOCUENTABANCOGLOBAL)) {
				this.setActivarid_tipo_cuenta_banco_globalBancoTipoCuentaBancoGlobal(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,BancoTipoCuentaBancoGlobalBeanSwingJInternalFrame bancotipocuentabancoglobalBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridBancoTipoCuentaBancoGlobal(esInicial);
		this.setResaltarid_empresaBancoTipoCuentaBancoGlobal(esInicial);
		this.setResaltarid_bancoBancoTipoCuentaBancoGlobal(esInicial);
		this.setResaltarid_tipo_cuenta_banco_globalBancoTipoCuentaBancoGlobal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BancoTipoCuentaBancoGlobalConstantesFunciones.ID)) {
				this.setResaltaridBancoTipoCuentaBancoGlobal(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoTipoCuentaBancoGlobalConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaBancoTipoCuentaBancoGlobal(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoTipoCuentaBancoGlobalConstantesFunciones.IDBANCO)) {
				this.setResaltarid_bancoBancoTipoCuentaBancoGlobal(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoTipoCuentaBancoGlobalConstantesFunciones.IDTIPOCUENTABANCOGLOBAL)) {
				this.setResaltarid_tipo_cuenta_banco_globalBancoTipoCuentaBancoGlobal(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,BancoTipoCuentaBancoGlobalBeanSwingJInternalFrame bancotipocuentabancoglobalBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBancoBancoTipoCuentaBancoGlobal=true;

	public Boolean getMostrarFK_IdBancoBancoTipoCuentaBancoGlobal() {
		return this.mostrarFK_IdBancoBancoTipoCuentaBancoGlobal;
	}

	public void setMostrarFK_IdBancoBancoTipoCuentaBancoGlobal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBancoBancoTipoCuentaBancoGlobal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaBancoTipoCuentaBancoGlobal=true;

	public Boolean getMostrarFK_IdEmpresaBancoTipoCuentaBancoGlobal() {
		return this.mostrarFK_IdEmpresaBancoTipoCuentaBancoGlobal;
	}

	public void setMostrarFK_IdEmpresaBancoTipoCuentaBancoGlobal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaBancoTipoCuentaBancoGlobal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoCuentaBancoGlobalBancoTipoCuentaBancoGlobal=true;

	public Boolean getMostrarFK_IdTipoCuentaBancoGlobalBancoTipoCuentaBancoGlobal() {
		return this.mostrarFK_IdTipoCuentaBancoGlobalBancoTipoCuentaBancoGlobal;
	}

	public void setMostrarFK_IdTipoCuentaBancoGlobalBancoTipoCuentaBancoGlobal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoCuentaBancoGlobalBancoTipoCuentaBancoGlobal= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBancoBancoTipoCuentaBancoGlobal=true;

	public Boolean getActivarFK_IdBancoBancoTipoCuentaBancoGlobal() {
		return this.activarFK_IdBancoBancoTipoCuentaBancoGlobal;
	}

	public void setActivarFK_IdBancoBancoTipoCuentaBancoGlobal(Boolean habilitarResaltar) {
		this.activarFK_IdBancoBancoTipoCuentaBancoGlobal= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaBancoTipoCuentaBancoGlobal=true;

	public Boolean getActivarFK_IdEmpresaBancoTipoCuentaBancoGlobal() {
		return this.activarFK_IdEmpresaBancoTipoCuentaBancoGlobal;
	}

	public void setActivarFK_IdEmpresaBancoTipoCuentaBancoGlobal(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaBancoTipoCuentaBancoGlobal= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoCuentaBancoGlobalBancoTipoCuentaBancoGlobal=true;

	public Boolean getActivarFK_IdTipoCuentaBancoGlobalBancoTipoCuentaBancoGlobal() {
		return this.activarFK_IdTipoCuentaBancoGlobalBancoTipoCuentaBancoGlobal;
	}

	public void setActivarFK_IdTipoCuentaBancoGlobalBancoTipoCuentaBancoGlobal(Boolean habilitarResaltar) {
		this.activarFK_IdTipoCuentaBancoGlobalBancoTipoCuentaBancoGlobal= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBancoBancoTipoCuentaBancoGlobal=null;

	public Border getResaltarFK_IdBancoBancoTipoCuentaBancoGlobal() {
		return this.resaltarFK_IdBancoBancoTipoCuentaBancoGlobal;
	}

	public void setResaltarFK_IdBancoBancoTipoCuentaBancoGlobal(Border borderResaltar) {
		this.resaltarFK_IdBancoBancoTipoCuentaBancoGlobal= borderResaltar;
	}

	public void setResaltarFK_IdBancoBancoTipoCuentaBancoGlobal(ParametroGeneralUsuario parametroGeneralUsuario/*BancoTipoCuentaBancoGlobalBeanSwingJInternalFrame bancotipocuentabancoglobalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBancoBancoTipoCuentaBancoGlobal= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaBancoTipoCuentaBancoGlobal=null;

	public Border getResaltarFK_IdEmpresaBancoTipoCuentaBancoGlobal() {
		return this.resaltarFK_IdEmpresaBancoTipoCuentaBancoGlobal;
	}

	public void setResaltarFK_IdEmpresaBancoTipoCuentaBancoGlobal(Border borderResaltar) {
		this.resaltarFK_IdEmpresaBancoTipoCuentaBancoGlobal= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaBancoTipoCuentaBancoGlobal(ParametroGeneralUsuario parametroGeneralUsuario/*BancoTipoCuentaBancoGlobalBeanSwingJInternalFrame bancotipocuentabancoglobalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaBancoTipoCuentaBancoGlobal= borderResaltar;
	}

	public Border resaltarFK_IdTipoCuentaBancoGlobalBancoTipoCuentaBancoGlobal=null;

	public Border getResaltarFK_IdTipoCuentaBancoGlobalBancoTipoCuentaBancoGlobal() {
		return this.resaltarFK_IdTipoCuentaBancoGlobalBancoTipoCuentaBancoGlobal;
	}

	public void setResaltarFK_IdTipoCuentaBancoGlobalBancoTipoCuentaBancoGlobal(Border borderResaltar) {
		this.resaltarFK_IdTipoCuentaBancoGlobalBancoTipoCuentaBancoGlobal= borderResaltar;
	}

	public void setResaltarFK_IdTipoCuentaBancoGlobalBancoTipoCuentaBancoGlobal(ParametroGeneralUsuario parametroGeneralUsuario/*BancoTipoCuentaBancoGlobalBeanSwingJInternalFrame bancotipocuentabancoglobalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoCuentaBancoGlobalBancoTipoCuentaBancoGlobal= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}