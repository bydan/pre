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


import com.bydan.erp.tesoreria.util.TipoCuentaBancoGeneralConstantesFunciones;
import com.bydan.erp.tesoreria.util.TipoCuentaBancoGeneralParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.TipoCuentaBancoGeneralParameterGeneral;

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
final public class TipoCuentaBancoGeneralConstantesFunciones extends TipoCuentaBancoGeneralConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoCuentaBancoGeneral";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoCuentaBancoGeneral"+TipoCuentaBancoGeneralConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoCuentaBancoGeneralHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoCuentaBancoGeneralHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoCuentaBancoGeneralConstantesFunciones.SCHEMA+"_"+TipoCuentaBancoGeneralConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoCuentaBancoGeneralHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoCuentaBancoGeneralConstantesFunciones.SCHEMA+"_"+TipoCuentaBancoGeneralConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoCuentaBancoGeneralConstantesFunciones.SCHEMA+"_"+TipoCuentaBancoGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoCuentaBancoGeneralHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoCuentaBancoGeneralConstantesFunciones.SCHEMA+"_"+TipoCuentaBancoGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCuentaBancoGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCuentaBancoGeneralHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCuentaBancoGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCuentaBancoGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCuentaBancoGeneralHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCuentaBancoGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoCuentaBancoGeneralConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoCuentaBancoGeneralConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoCuentaBancoGeneralConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoCuentaBancoGeneralConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Cuenta Banco Generales";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Tipo Cuenta Banco General";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Cuenta Banco General";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoCuentaBancoGeneral";
	public static final String OBJECTNAME="tipocuentabancogeneral";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="tipo_cuenta_banco_general";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipocuentabancogeneral from "+TipoCuentaBancoGeneralConstantesFunciones.SPERSISTENCENAME+" tipocuentabancogeneral";
	public static String QUERYSELECTNATIVE="select "+TipoCuentaBancoGeneralConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGeneralConstantesFunciones.TABLENAME+".id,"+TipoCuentaBancoGeneralConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGeneralConstantesFunciones.TABLENAME+".version_row,"+TipoCuentaBancoGeneralConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGeneralConstantesFunciones.TABLENAME+".id_empresa,"+TipoCuentaBancoGeneralConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGeneralConstantesFunciones.TABLENAME+".id_banco,"+TipoCuentaBancoGeneralConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGeneralConstantesFunciones.TABLENAME+".id_tipo_cuenta_banco,"+TipoCuentaBancoGeneralConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGeneralConstantesFunciones.TABLENAME+".codigo from "+TipoCuentaBancoGeneralConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGeneralConstantesFunciones.TABLENAME;//+" as "+TipoCuentaBancoGeneralConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoCuentaBancoGeneralConstantesFuncionesAdditional tipocuentabancogeneralConstantesFuncionesAdditional=null;
	
	public TipoCuentaBancoGeneralConstantesFuncionesAdditional getTipoCuentaBancoGeneralConstantesFuncionesAdditional() {
		return this.tipocuentabancogeneralConstantesFuncionesAdditional;
	}
	
	public void setTipoCuentaBancoGeneralConstantesFuncionesAdditional(TipoCuentaBancoGeneralConstantesFuncionesAdditional tipocuentabancogeneralConstantesFuncionesAdditional) {
		try {
			this.tipocuentabancogeneralConstantesFuncionesAdditional=tipocuentabancogeneralConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDBANCO= "id_banco";
    public static final String IDTIPOCUENTABANCO= "id_tipo_cuenta_banco";
    public static final String CODIGO= "codigo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDBANCO= "Banco";
		public static final String LABEL_IDBANCO_LOWER= "Banco";
    	public static final String LABEL_IDTIPOCUENTABANCO= "Tipo Cuenta Banco";
		public static final String LABEL_IDTIPOCUENTABANCO_LOWER= "Tipo Cuenta Banco";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
	
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoCuentaBancoGeneralLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoCuentaBancoGeneralConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoCuentaBancoGeneralConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoCuentaBancoGeneralConstantesFunciones.IDBANCO)) {sLabelColumna=TipoCuentaBancoGeneralConstantesFunciones.LABEL_IDBANCO;}
		if(sNombreColumna.equals(TipoCuentaBancoGeneralConstantesFunciones.IDTIPOCUENTABANCO)) {sLabelColumna=TipoCuentaBancoGeneralConstantesFunciones.LABEL_IDTIPOCUENTABANCO;}
		if(sNombreColumna.equals(TipoCuentaBancoGeneralConstantesFunciones.CODIGO)) {sLabelColumna=TipoCuentaBancoGeneralConstantesFunciones.LABEL_CODIGO;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getTipoCuentaBancoGeneralDescripcion(TipoCuentaBancoGeneral tipocuentabancogeneral) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipocuentabancogeneral !=null/* && tipocuentabancogeneral.getId()!=0*/) {
			sDescripcion=tipocuentabancogeneral.getcodigo();//tipocuentabancogeneraltipocuentabancogeneral.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoCuentaBancoGeneralDescripcionDetallado(TipoCuentaBancoGeneral tipocuentabancogeneral) {
		String sDescripcion="";
			
		sDescripcion+=TipoCuentaBancoGeneralConstantesFunciones.ID+"=";
		sDescripcion+=tipocuentabancogeneral.getId().toString()+",";
		sDescripcion+=TipoCuentaBancoGeneralConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipocuentabancogeneral.getVersionRow().toString()+",";
		sDescripcion+=TipoCuentaBancoGeneralConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipocuentabancogeneral.getid_empresa().toString()+",";
		sDescripcion+=TipoCuentaBancoGeneralConstantesFunciones.IDBANCO+"=";
		sDescripcion+=tipocuentabancogeneral.getid_banco().toString()+",";
		sDescripcion+=TipoCuentaBancoGeneralConstantesFunciones.IDTIPOCUENTABANCO+"=";
		sDescripcion+=tipocuentabancogeneral.getid_tipo_cuenta_banco().toString()+",";
		sDescripcion+=TipoCuentaBancoGeneralConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipocuentabancogeneral.getcodigo()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoCuentaBancoGeneralDescripcion(TipoCuentaBancoGeneral tipocuentabancogeneral,String sValor) throws Exception {			
		if(tipocuentabancogeneral !=null) {
			tipocuentabancogeneral.setcodigo(sValor);;//tipocuentabancogeneraltipocuentabancogeneral.getcodigo().trim();
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

	public static String getTipoCuentaBancoDescripcion(TipoCuentaBanco tipocuentabanco) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocuentabanco!=null/*&&tipocuentabanco.getId()>0*/) {
			sDescripcion=TipoCuentaBancoConstantesFunciones.getTipoCuentaBancoDescripcion(tipocuentabanco);
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
		} else if(sNombreIndice.equals("FK_IdTipoCuentaBanco")) {
			sNombreIndice="Tipo=  Por Tipo Cuenta Banco";
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

	public static String getDetalleIndiceFK_IdTipoCuentaBanco(Long id_tipo_cuenta_banco) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_cuenta_banco!=null) {sDetalleIndice+=" Codigo Unico De Tipo Cuenta Banco="+id_tipo_cuenta_banco.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoCuentaBancoGeneral(TipoCuentaBancoGeneral tipocuentabancogeneral,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipocuentabancogeneral.setcodigo(tipocuentabancogeneral.getcodigo().trim());
	}
	
	public static void quitarEspaciosTipoCuentaBancoGenerals(List<TipoCuentaBancoGeneral> tipocuentabancogenerals,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoCuentaBancoGeneral tipocuentabancogeneral: tipocuentabancogenerals) {
			tipocuentabancogeneral.setcodigo(tipocuentabancogeneral.getcodigo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCuentaBancoGeneral(TipoCuentaBancoGeneral tipocuentabancogeneral,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipocuentabancogeneral.getConCambioAuxiliar()) {
			tipocuentabancogeneral.setIsDeleted(tipocuentabancogeneral.getIsDeletedAuxiliar());	
			tipocuentabancogeneral.setIsNew(tipocuentabancogeneral.getIsNewAuxiliar());	
			tipocuentabancogeneral.setIsChanged(tipocuentabancogeneral.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipocuentabancogeneral.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipocuentabancogeneral.setIsDeletedAuxiliar(false);	
			tipocuentabancogeneral.setIsNewAuxiliar(false);	
			tipocuentabancogeneral.setIsChangedAuxiliar(false);
			
			tipocuentabancogeneral.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCuentaBancoGenerals(List<TipoCuentaBancoGeneral> tipocuentabancogenerals,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoCuentaBancoGeneral tipocuentabancogeneral : tipocuentabancogenerals) {
			if(conAsignarBase && tipocuentabancogeneral.getConCambioAuxiliar()) {
				tipocuentabancogeneral.setIsDeleted(tipocuentabancogeneral.getIsDeletedAuxiliar());	
				tipocuentabancogeneral.setIsNew(tipocuentabancogeneral.getIsNewAuxiliar());	
				tipocuentabancogeneral.setIsChanged(tipocuentabancogeneral.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipocuentabancogeneral.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipocuentabancogeneral.setIsDeletedAuxiliar(false);	
				tipocuentabancogeneral.setIsNewAuxiliar(false);	
				tipocuentabancogeneral.setIsChangedAuxiliar(false);
				
				tipocuentabancogeneral.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoCuentaBancoGeneral(TipoCuentaBancoGeneral tipocuentabancogeneral,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoCuentaBancoGenerals(List<TipoCuentaBancoGeneral> tipocuentabancogenerals,Boolean conEnteros) throws Exception  {
		
		for(TipoCuentaBancoGeneral tipocuentabancogeneral: tipocuentabancogenerals) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoCuentaBancoGeneral(List<TipoCuentaBancoGeneral> tipocuentabancogenerals,TipoCuentaBancoGeneral tipocuentabancogeneralAux) throws Exception  {
		TipoCuentaBancoGeneralConstantesFunciones.InicializarValoresTipoCuentaBancoGeneral(tipocuentabancogeneralAux,true);
		
		for(TipoCuentaBancoGeneral tipocuentabancogeneral: tipocuentabancogenerals) {
			if(tipocuentabancogeneral.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCuentaBancoGeneral(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoCuentaBancoGeneralConstantesFunciones.getArrayColumnasGlobalesTipoCuentaBancoGeneral(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCuentaBancoGeneral(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoCuentaBancoGeneralConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoCuentaBancoGeneralConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoCuentaBancoGeneral(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoCuentaBancoGeneral> tipocuentabancogenerals,TipoCuentaBancoGeneral tipocuentabancogeneral,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoCuentaBancoGeneral tipocuentabancogeneralAux: tipocuentabancogenerals) {
			if(tipocuentabancogeneralAux!=null && tipocuentabancogeneral!=null) {
				if((tipocuentabancogeneralAux.getId()==null && tipocuentabancogeneral.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipocuentabancogeneralAux.getId()!=null && tipocuentabancogeneral.getId()!=null){
					if(tipocuentabancogeneralAux.getId().equals(tipocuentabancogeneral.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoCuentaBancoGeneral(List<TipoCuentaBancoGeneral> tipocuentabancogenerals) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoCuentaBancoGeneral tipocuentabancogeneral: tipocuentabancogenerals) {			
			if(tipocuentabancogeneral.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoCuentaBancoGeneral() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoCuentaBancoGeneralConstantesFunciones.LABEL_ID, TipoCuentaBancoGeneralConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCuentaBancoGeneralConstantesFunciones.LABEL_VERSIONROW, TipoCuentaBancoGeneralConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCuentaBancoGeneralConstantesFunciones.LABEL_IDEMPRESA, TipoCuentaBancoGeneralConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCuentaBancoGeneralConstantesFunciones.LABEL_IDBANCO, TipoCuentaBancoGeneralConstantesFunciones.IDBANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCuentaBancoGeneralConstantesFunciones.LABEL_IDTIPOCUENTABANCO, TipoCuentaBancoGeneralConstantesFunciones.IDTIPOCUENTABANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCuentaBancoGeneralConstantesFunciones.LABEL_CODIGO, TipoCuentaBancoGeneralConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoCuentaBancoGeneral() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoCuentaBancoGeneralConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCuentaBancoGeneralConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCuentaBancoGeneralConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCuentaBancoGeneralConstantesFunciones.IDBANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCuentaBancoGeneralConstantesFunciones.IDTIPOCUENTABANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCuentaBancoGeneralConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCuentaBancoGeneral() throws Exception  {
		return TipoCuentaBancoGeneralConstantesFunciones.getTiposSeleccionarTipoCuentaBancoGeneral(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCuentaBancoGeneral(Boolean conFk) throws Exception  {
		return TipoCuentaBancoGeneralConstantesFunciones.getTiposSeleccionarTipoCuentaBancoGeneral(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCuentaBancoGeneral(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCuentaBancoGeneralConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoCuentaBancoGeneralConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCuentaBancoGeneralConstantesFunciones.LABEL_IDBANCO);
			reporte.setsDescripcion(TipoCuentaBancoGeneralConstantesFunciones.LABEL_IDBANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCuentaBancoGeneralConstantesFunciones.LABEL_IDTIPOCUENTABANCO);
			reporte.setsDescripcion(TipoCuentaBancoGeneralConstantesFunciones.LABEL_IDTIPOCUENTABANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCuentaBancoGeneralConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoCuentaBancoGeneralConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoCuentaBancoGeneral(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCuentaBancoGeneral(TipoCuentaBancoGeneral tipocuentabancogeneralAux) throws Exception {
		
			tipocuentabancogeneralAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipocuentabancogeneralAux.getEmpresa()));
			tipocuentabancogeneralAux.setbanco_descripcion(BancoConstantesFunciones.getBancoDescripcion(tipocuentabancogeneralAux.getBanco()));
			tipocuentabancogeneralAux.settipocuentabanco_descripcion(TipoCuentaBancoConstantesFunciones.getTipoCuentaBancoDescripcion(tipocuentabancogeneralAux.getTipoCuentaBanco()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCuentaBancoGeneral(List<TipoCuentaBancoGeneral> tipocuentabancogeneralsTemp) throws Exception {
		for(TipoCuentaBancoGeneral tipocuentabancogeneralAux:tipocuentabancogeneralsTemp) {
			
			tipocuentabancogeneralAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipocuentabancogeneralAux.getEmpresa()));
			tipocuentabancogeneralAux.setbanco_descripcion(BancoConstantesFunciones.getBancoDescripcion(tipocuentabancogeneralAux.getBanco()));
			tipocuentabancogeneralAux.settipocuentabanco_descripcion(TipoCuentaBancoConstantesFunciones.getTipoCuentaBancoDescripcion(tipocuentabancogeneralAux.getTipoCuentaBanco()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoCuentaBancoGeneral(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Banco.class));
				classes.add(new Classe(TipoCuentaBanco.class));
				
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
					if(clas.clas.equals(TipoCuentaBanco.class)) {
						classes.add(new Classe(TipoCuentaBanco.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoCuentaBancoGeneral(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(TipoCuentaBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCuentaBanco.class)); continue;
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

					if(TipoCuentaBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCuentaBanco.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCuentaBancoGeneral(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCuentaBancoGeneralConstantesFunciones.getClassesRelationshipsOfTipoCuentaBancoGeneral(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCuentaBancoGeneral(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCuentaBancoGeneral(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCuentaBancoGeneralConstantesFunciones.getClassesRelationshipsFromStringsOfTipoCuentaBancoGeneral(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCuentaBancoGeneral(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoCuentaBancoGeneral tipocuentabancogeneral,List<TipoCuentaBancoGeneral> tipocuentabancogenerals,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoCuentaBancoGeneral tipocuentabancogeneralEncontrado=null;
			
			for(TipoCuentaBancoGeneral tipocuentabancogeneralLocal:tipocuentabancogenerals) {
				if(tipocuentabancogeneralLocal.getId().equals(tipocuentabancogeneral.getId())) {
					tipocuentabancogeneralEncontrado=tipocuentabancogeneralLocal;
					
					tipocuentabancogeneralLocal.setIsChanged(tipocuentabancogeneral.getIsChanged());
					tipocuentabancogeneralLocal.setIsNew(tipocuentabancogeneral.getIsNew());
					tipocuentabancogeneralLocal.setIsDeleted(tipocuentabancogeneral.getIsDeleted());
					
					tipocuentabancogeneralLocal.setGeneralEntityOriginal(tipocuentabancogeneral.getGeneralEntityOriginal());
					
					tipocuentabancogeneralLocal.setId(tipocuentabancogeneral.getId());	
					tipocuentabancogeneralLocal.setVersionRow(tipocuentabancogeneral.getVersionRow());	
					tipocuentabancogeneralLocal.setid_empresa(tipocuentabancogeneral.getid_empresa());	
					tipocuentabancogeneralLocal.setid_banco(tipocuentabancogeneral.getid_banco());	
					tipocuentabancogeneralLocal.setid_tipo_cuenta_banco(tipocuentabancogeneral.getid_tipo_cuenta_banco());	
					tipocuentabancogeneralLocal.setcodigo(tipocuentabancogeneral.getcodigo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipocuentabancogeneral.getIsDeleted()) {
				if(!existe) {
					tipocuentabancogenerals.add(tipocuentabancogeneral);
				}
			} else {
				if(tipocuentabancogeneralEncontrado!=null && permiteQuitar)  {
					tipocuentabancogenerals.remove(tipocuentabancogeneralEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoCuentaBancoGeneral tipocuentabancogeneral,List<TipoCuentaBancoGeneral> tipocuentabancogenerals) throws Exception {
		try	{			
			for(TipoCuentaBancoGeneral tipocuentabancogeneralLocal:tipocuentabancogenerals) {
				if(tipocuentabancogeneralLocal.getId().equals(tipocuentabancogeneral.getId())) {
					tipocuentabancogeneralLocal.setIsSelected(tipocuentabancogeneral.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoCuentaBancoGeneral(List<TipoCuentaBancoGeneral> tipocuentabancogeneralsAux) throws Exception {
		//this.tipocuentabancogeneralsAux=tipocuentabancogeneralsAux;
		
		for(TipoCuentaBancoGeneral tipocuentabancogeneralAux:tipocuentabancogeneralsAux) {
			if(tipocuentabancogeneralAux.getIsChanged()) {
				tipocuentabancogeneralAux.setIsChanged(false);
			}		
			
			if(tipocuentabancogeneralAux.getIsNew()) {
				tipocuentabancogeneralAux.setIsNew(false);
			}	
			
			if(tipocuentabancogeneralAux.getIsDeleted()) {
				tipocuentabancogeneralAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoCuentaBancoGeneral(TipoCuentaBancoGeneral tipocuentabancogeneralAux) throws Exception {
		//this.tipocuentabancogeneralAux=tipocuentabancogeneralAux;
		
			if(tipocuentabancogeneralAux.getIsChanged()) {
				tipocuentabancogeneralAux.setIsChanged(false);
			}		
			
			if(tipocuentabancogeneralAux.getIsNew()) {
				tipocuentabancogeneralAux.setIsNew(false);
			}	
			
			if(tipocuentabancogeneralAux.getIsDeleted()) {
				tipocuentabancogeneralAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoCuentaBancoGeneral tipocuentabancogeneralAsignar,TipoCuentaBancoGeneral tipocuentabancogeneral) throws Exception {
		tipocuentabancogeneralAsignar.setId(tipocuentabancogeneral.getId());	
		tipocuentabancogeneralAsignar.setVersionRow(tipocuentabancogeneral.getVersionRow());	
		tipocuentabancogeneralAsignar.setid_empresa(tipocuentabancogeneral.getid_empresa());
		tipocuentabancogeneralAsignar.setempresa_descripcion(tipocuentabancogeneral.getempresa_descripcion());	
		tipocuentabancogeneralAsignar.setid_banco(tipocuentabancogeneral.getid_banco());
		tipocuentabancogeneralAsignar.setbanco_descripcion(tipocuentabancogeneral.getbanco_descripcion());	
		tipocuentabancogeneralAsignar.setid_tipo_cuenta_banco(tipocuentabancogeneral.getid_tipo_cuenta_banco());
		tipocuentabancogeneralAsignar.settipocuentabanco_descripcion(tipocuentabancogeneral.gettipocuentabanco_descripcion());	
		tipocuentabancogeneralAsignar.setcodigo(tipocuentabancogeneral.getcodigo());	
	}
	
	public static void inicializarTipoCuentaBancoGeneral(TipoCuentaBancoGeneral tipocuentabancogeneral) throws Exception {
		try {
				tipocuentabancogeneral.setId(0L);	
					
				tipocuentabancogeneral.setid_empresa(-1L);	
				tipocuentabancogeneral.setid_banco(-1L);	
				tipocuentabancogeneral.setid_tipo_cuenta_banco(-1L);	
				tipocuentabancogeneral.setcodigo("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoCuentaBancoGeneral(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCuentaBancoGeneralConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCuentaBancoGeneralConstantesFunciones.LABEL_IDBANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCuentaBancoGeneralConstantesFunciones.LABEL_IDTIPOCUENTABANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCuentaBancoGeneralConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoCuentaBancoGeneral(String sTipo,Row row,Workbook workbook,TipoCuentaBancoGeneral tipocuentabancogeneral,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocuentabancogeneral.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocuentabancogeneral.getbanco_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocuentabancogeneral.gettipocuentabanco_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocuentabancogeneral.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoCuentaBancoGeneral=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoCuentaBancoGeneral() {
		return this.sFinalQueryTipoCuentaBancoGeneral;
	}
	
	public void setsFinalQueryTipoCuentaBancoGeneral(String sFinalQueryTipoCuentaBancoGeneral) {
		this.sFinalQueryTipoCuentaBancoGeneral= sFinalQueryTipoCuentaBancoGeneral;
	}
	
	public Border resaltarSeleccionarTipoCuentaBancoGeneral=null;
	
	public Border setResaltarSeleccionarTipoCuentaBancoGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuentaBancoGeneralBeanSwingJInternalFrame tipocuentabancogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipocuentabancogeneralBeanSwingJInternalFrame.jTtoolBarTipoCuentaBancoGeneral.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoCuentaBancoGeneral= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoCuentaBancoGeneral() {
		return this.resaltarSeleccionarTipoCuentaBancoGeneral;
	}
	
	public void setResaltarSeleccionarTipoCuentaBancoGeneral(Border borderResaltarSeleccionarTipoCuentaBancoGeneral) {
		this.resaltarSeleccionarTipoCuentaBancoGeneral= borderResaltarSeleccionarTipoCuentaBancoGeneral;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoCuentaBancoGeneral=null;
	public Boolean mostraridTipoCuentaBancoGeneral=true;
	public Boolean activaridTipoCuentaBancoGeneral=true;

	public Border resaltarid_empresaTipoCuentaBancoGeneral=null;
	public Boolean mostrarid_empresaTipoCuentaBancoGeneral=true;
	public Boolean activarid_empresaTipoCuentaBancoGeneral=true;
	public Boolean cargarid_empresaTipoCuentaBancoGeneral=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoCuentaBancoGeneral=false;//ConEventDepend=true

	public Border resaltarid_bancoTipoCuentaBancoGeneral=null;
	public Boolean mostrarid_bancoTipoCuentaBancoGeneral=true;
	public Boolean activarid_bancoTipoCuentaBancoGeneral=true;
	public Boolean cargarid_bancoTipoCuentaBancoGeneral=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bancoTipoCuentaBancoGeneral=false;//ConEventDepend=true

	public Border resaltarid_tipo_cuenta_bancoTipoCuentaBancoGeneral=null;
	public Boolean mostrarid_tipo_cuenta_bancoTipoCuentaBancoGeneral=true;
	public Boolean activarid_tipo_cuenta_bancoTipoCuentaBancoGeneral=true;
	public Boolean cargarid_tipo_cuenta_bancoTipoCuentaBancoGeneral=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_cuenta_bancoTipoCuentaBancoGeneral=false;//ConEventDepend=true

	public Border resaltarcodigoTipoCuentaBancoGeneral=null;
	public Boolean mostrarcodigoTipoCuentaBancoGeneral=true;
	public Boolean activarcodigoTipoCuentaBancoGeneral=true;

	
	

	public Border setResaltaridTipoCuentaBancoGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuentaBancoGeneralBeanSwingJInternalFrame tipocuentabancogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocuentabancogeneralBeanSwingJInternalFrame.jTtoolBarTipoCuentaBancoGeneral.setBorder(borderResaltar);
		
		this.resaltaridTipoCuentaBancoGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoCuentaBancoGeneral() {
		return this.resaltaridTipoCuentaBancoGeneral;
	}

	public void setResaltaridTipoCuentaBancoGeneral(Border borderResaltar) {
		this.resaltaridTipoCuentaBancoGeneral= borderResaltar;
	}

	public Boolean getMostraridTipoCuentaBancoGeneral() {
		return this.mostraridTipoCuentaBancoGeneral;
	}

	public void setMostraridTipoCuentaBancoGeneral(Boolean mostraridTipoCuentaBancoGeneral) {
		this.mostraridTipoCuentaBancoGeneral= mostraridTipoCuentaBancoGeneral;
	}

	public Boolean getActivaridTipoCuentaBancoGeneral() {
		return this.activaridTipoCuentaBancoGeneral;
	}

	public void setActivaridTipoCuentaBancoGeneral(Boolean activaridTipoCuentaBancoGeneral) {
		this.activaridTipoCuentaBancoGeneral= activaridTipoCuentaBancoGeneral;
	}

	public Border setResaltarid_empresaTipoCuentaBancoGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuentaBancoGeneralBeanSwingJInternalFrame tipocuentabancogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocuentabancogeneralBeanSwingJInternalFrame.jTtoolBarTipoCuentaBancoGeneral.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoCuentaBancoGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoCuentaBancoGeneral() {
		return this.resaltarid_empresaTipoCuentaBancoGeneral;
	}

	public void setResaltarid_empresaTipoCuentaBancoGeneral(Border borderResaltar) {
		this.resaltarid_empresaTipoCuentaBancoGeneral= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoCuentaBancoGeneral() {
		return this.mostrarid_empresaTipoCuentaBancoGeneral;
	}

	public void setMostrarid_empresaTipoCuentaBancoGeneral(Boolean mostrarid_empresaTipoCuentaBancoGeneral) {
		this.mostrarid_empresaTipoCuentaBancoGeneral= mostrarid_empresaTipoCuentaBancoGeneral;
	}

	public Boolean getActivarid_empresaTipoCuentaBancoGeneral() {
		return this.activarid_empresaTipoCuentaBancoGeneral;
	}

	public void setActivarid_empresaTipoCuentaBancoGeneral(Boolean activarid_empresaTipoCuentaBancoGeneral) {
		this.activarid_empresaTipoCuentaBancoGeneral= activarid_empresaTipoCuentaBancoGeneral;
	}

	public Boolean getCargarid_empresaTipoCuentaBancoGeneral() {
		return this.cargarid_empresaTipoCuentaBancoGeneral;
	}

	public void setCargarid_empresaTipoCuentaBancoGeneral(Boolean cargarid_empresaTipoCuentaBancoGeneral) {
		this.cargarid_empresaTipoCuentaBancoGeneral= cargarid_empresaTipoCuentaBancoGeneral;
	}

	public Border setResaltarid_bancoTipoCuentaBancoGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuentaBancoGeneralBeanSwingJInternalFrame tipocuentabancogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocuentabancogeneralBeanSwingJInternalFrame.jTtoolBarTipoCuentaBancoGeneral.setBorder(borderResaltar);
		
		this.resaltarid_bancoTipoCuentaBancoGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bancoTipoCuentaBancoGeneral() {
		return this.resaltarid_bancoTipoCuentaBancoGeneral;
	}

	public void setResaltarid_bancoTipoCuentaBancoGeneral(Border borderResaltar) {
		this.resaltarid_bancoTipoCuentaBancoGeneral= borderResaltar;
	}

	public Boolean getMostrarid_bancoTipoCuentaBancoGeneral() {
		return this.mostrarid_bancoTipoCuentaBancoGeneral;
	}

	public void setMostrarid_bancoTipoCuentaBancoGeneral(Boolean mostrarid_bancoTipoCuentaBancoGeneral) {
		this.mostrarid_bancoTipoCuentaBancoGeneral= mostrarid_bancoTipoCuentaBancoGeneral;
	}

	public Boolean getActivarid_bancoTipoCuentaBancoGeneral() {
		return this.activarid_bancoTipoCuentaBancoGeneral;
	}

	public void setActivarid_bancoTipoCuentaBancoGeneral(Boolean activarid_bancoTipoCuentaBancoGeneral) {
		this.activarid_bancoTipoCuentaBancoGeneral= activarid_bancoTipoCuentaBancoGeneral;
	}

	public Boolean getCargarid_bancoTipoCuentaBancoGeneral() {
		return this.cargarid_bancoTipoCuentaBancoGeneral;
	}

	public void setCargarid_bancoTipoCuentaBancoGeneral(Boolean cargarid_bancoTipoCuentaBancoGeneral) {
		this.cargarid_bancoTipoCuentaBancoGeneral= cargarid_bancoTipoCuentaBancoGeneral;
	}

	public Border setResaltarid_tipo_cuenta_bancoTipoCuentaBancoGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuentaBancoGeneralBeanSwingJInternalFrame tipocuentabancogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocuentabancogeneralBeanSwingJInternalFrame.jTtoolBarTipoCuentaBancoGeneral.setBorder(borderResaltar);
		
		this.resaltarid_tipo_cuenta_bancoTipoCuentaBancoGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_cuenta_bancoTipoCuentaBancoGeneral() {
		return this.resaltarid_tipo_cuenta_bancoTipoCuentaBancoGeneral;
	}

	public void setResaltarid_tipo_cuenta_bancoTipoCuentaBancoGeneral(Border borderResaltar) {
		this.resaltarid_tipo_cuenta_bancoTipoCuentaBancoGeneral= borderResaltar;
	}

	public Boolean getMostrarid_tipo_cuenta_bancoTipoCuentaBancoGeneral() {
		return this.mostrarid_tipo_cuenta_bancoTipoCuentaBancoGeneral;
	}

	public void setMostrarid_tipo_cuenta_bancoTipoCuentaBancoGeneral(Boolean mostrarid_tipo_cuenta_bancoTipoCuentaBancoGeneral) {
		this.mostrarid_tipo_cuenta_bancoTipoCuentaBancoGeneral= mostrarid_tipo_cuenta_bancoTipoCuentaBancoGeneral;
	}

	public Boolean getActivarid_tipo_cuenta_bancoTipoCuentaBancoGeneral() {
		return this.activarid_tipo_cuenta_bancoTipoCuentaBancoGeneral;
	}

	public void setActivarid_tipo_cuenta_bancoTipoCuentaBancoGeneral(Boolean activarid_tipo_cuenta_bancoTipoCuentaBancoGeneral) {
		this.activarid_tipo_cuenta_bancoTipoCuentaBancoGeneral= activarid_tipo_cuenta_bancoTipoCuentaBancoGeneral;
	}

	public Boolean getCargarid_tipo_cuenta_bancoTipoCuentaBancoGeneral() {
		return this.cargarid_tipo_cuenta_bancoTipoCuentaBancoGeneral;
	}

	public void setCargarid_tipo_cuenta_bancoTipoCuentaBancoGeneral(Boolean cargarid_tipo_cuenta_bancoTipoCuentaBancoGeneral) {
		this.cargarid_tipo_cuenta_bancoTipoCuentaBancoGeneral= cargarid_tipo_cuenta_bancoTipoCuentaBancoGeneral;
	}

	public Border setResaltarcodigoTipoCuentaBancoGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuentaBancoGeneralBeanSwingJInternalFrame tipocuentabancogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocuentabancogeneralBeanSwingJInternalFrame.jTtoolBarTipoCuentaBancoGeneral.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoCuentaBancoGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoCuentaBancoGeneral() {
		return this.resaltarcodigoTipoCuentaBancoGeneral;
	}

	public void setResaltarcodigoTipoCuentaBancoGeneral(Border borderResaltar) {
		this.resaltarcodigoTipoCuentaBancoGeneral= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoCuentaBancoGeneral() {
		return this.mostrarcodigoTipoCuentaBancoGeneral;
	}

	public void setMostrarcodigoTipoCuentaBancoGeneral(Boolean mostrarcodigoTipoCuentaBancoGeneral) {
		this.mostrarcodigoTipoCuentaBancoGeneral= mostrarcodigoTipoCuentaBancoGeneral;
	}

	public Boolean getActivarcodigoTipoCuentaBancoGeneral() {
		return this.activarcodigoTipoCuentaBancoGeneral;
	}

	public void setActivarcodigoTipoCuentaBancoGeneral(Boolean activarcodigoTipoCuentaBancoGeneral) {
		this.activarcodigoTipoCuentaBancoGeneral= activarcodigoTipoCuentaBancoGeneral;
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
		
		
		this.setMostraridTipoCuentaBancoGeneral(esInicial);
		this.setMostrarid_empresaTipoCuentaBancoGeneral(esInicial);
		this.setMostrarid_bancoTipoCuentaBancoGeneral(esInicial);
		this.setMostrarid_tipo_cuenta_bancoTipoCuentaBancoGeneral(esInicial);
		this.setMostrarcodigoTipoCuentaBancoGeneral(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCuentaBancoGeneralConstantesFunciones.ID)) {
				this.setMostraridTipoCuentaBancoGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuentaBancoGeneralConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoCuentaBancoGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuentaBancoGeneralConstantesFunciones.IDBANCO)) {
				this.setMostrarid_bancoTipoCuentaBancoGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuentaBancoGeneralConstantesFunciones.IDTIPOCUENTABANCO)) {
				this.setMostrarid_tipo_cuenta_bancoTipoCuentaBancoGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuentaBancoGeneralConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoCuentaBancoGeneral(esAsigna);
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
		
		
		this.setActivaridTipoCuentaBancoGeneral(esInicial);
		this.setActivarid_empresaTipoCuentaBancoGeneral(esInicial);
		this.setActivarid_bancoTipoCuentaBancoGeneral(esInicial);
		this.setActivarid_tipo_cuenta_bancoTipoCuentaBancoGeneral(esInicial);
		this.setActivarcodigoTipoCuentaBancoGeneral(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCuentaBancoGeneralConstantesFunciones.ID)) {
				this.setActivaridTipoCuentaBancoGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuentaBancoGeneralConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoCuentaBancoGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuentaBancoGeneralConstantesFunciones.IDBANCO)) {
				this.setActivarid_bancoTipoCuentaBancoGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuentaBancoGeneralConstantesFunciones.IDTIPOCUENTABANCO)) {
				this.setActivarid_tipo_cuenta_bancoTipoCuentaBancoGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuentaBancoGeneralConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoCuentaBancoGeneral(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCuentaBancoGeneralBeanSwingJInternalFrame tipocuentabancogeneralBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoCuentaBancoGeneral(esInicial);
		this.setResaltarid_empresaTipoCuentaBancoGeneral(esInicial);
		this.setResaltarid_bancoTipoCuentaBancoGeneral(esInicial);
		this.setResaltarid_tipo_cuenta_bancoTipoCuentaBancoGeneral(esInicial);
		this.setResaltarcodigoTipoCuentaBancoGeneral(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCuentaBancoGeneralConstantesFunciones.ID)) {
				this.setResaltaridTipoCuentaBancoGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuentaBancoGeneralConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoCuentaBancoGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuentaBancoGeneralConstantesFunciones.IDBANCO)) {
				this.setResaltarid_bancoTipoCuentaBancoGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuentaBancoGeneralConstantesFunciones.IDTIPOCUENTABANCO)) {
				this.setResaltarid_tipo_cuenta_bancoTipoCuentaBancoGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuentaBancoGeneralConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoCuentaBancoGeneral(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCuentaBancoGeneralBeanSwingJInternalFrame tipocuentabancogeneralBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBancoTipoCuentaBancoGeneral=true;

	public Boolean getMostrarFK_IdBancoTipoCuentaBancoGeneral() {
		return this.mostrarFK_IdBancoTipoCuentaBancoGeneral;
	}

	public void setMostrarFK_IdBancoTipoCuentaBancoGeneral(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBancoTipoCuentaBancoGeneral= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTipoCuentaBancoGeneral=true;

	public Boolean getMostrarFK_IdEmpresaTipoCuentaBancoGeneral() {
		return this.mostrarFK_IdEmpresaTipoCuentaBancoGeneral;
	}

	public void setMostrarFK_IdEmpresaTipoCuentaBancoGeneral(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoCuentaBancoGeneral= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoCuentaBancoTipoCuentaBancoGeneral=true;

	public Boolean getMostrarFK_IdTipoCuentaBancoTipoCuentaBancoGeneral() {
		return this.mostrarFK_IdTipoCuentaBancoTipoCuentaBancoGeneral;
	}

	public void setMostrarFK_IdTipoCuentaBancoTipoCuentaBancoGeneral(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoCuentaBancoTipoCuentaBancoGeneral= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBancoTipoCuentaBancoGeneral=true;

	public Boolean getActivarFK_IdBancoTipoCuentaBancoGeneral() {
		return this.activarFK_IdBancoTipoCuentaBancoGeneral;
	}

	public void setActivarFK_IdBancoTipoCuentaBancoGeneral(Boolean habilitarResaltar) {
		this.activarFK_IdBancoTipoCuentaBancoGeneral= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTipoCuentaBancoGeneral=true;

	public Boolean getActivarFK_IdEmpresaTipoCuentaBancoGeneral() {
		return this.activarFK_IdEmpresaTipoCuentaBancoGeneral;
	}

	public void setActivarFK_IdEmpresaTipoCuentaBancoGeneral(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoCuentaBancoGeneral= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoCuentaBancoTipoCuentaBancoGeneral=true;

	public Boolean getActivarFK_IdTipoCuentaBancoTipoCuentaBancoGeneral() {
		return this.activarFK_IdTipoCuentaBancoTipoCuentaBancoGeneral;
	}

	public void setActivarFK_IdTipoCuentaBancoTipoCuentaBancoGeneral(Boolean habilitarResaltar) {
		this.activarFK_IdTipoCuentaBancoTipoCuentaBancoGeneral= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBancoTipoCuentaBancoGeneral=null;

	public Border getResaltarFK_IdBancoTipoCuentaBancoGeneral() {
		return this.resaltarFK_IdBancoTipoCuentaBancoGeneral;
	}

	public void setResaltarFK_IdBancoTipoCuentaBancoGeneral(Border borderResaltar) {
		this.resaltarFK_IdBancoTipoCuentaBancoGeneral= borderResaltar;
	}

	public void setResaltarFK_IdBancoTipoCuentaBancoGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuentaBancoGeneralBeanSwingJInternalFrame tipocuentabancogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBancoTipoCuentaBancoGeneral= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTipoCuentaBancoGeneral=null;

	public Border getResaltarFK_IdEmpresaTipoCuentaBancoGeneral() {
		return this.resaltarFK_IdEmpresaTipoCuentaBancoGeneral;
	}

	public void setResaltarFK_IdEmpresaTipoCuentaBancoGeneral(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoCuentaBancoGeneral= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoCuentaBancoGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuentaBancoGeneralBeanSwingJInternalFrame tipocuentabancogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoCuentaBancoGeneral= borderResaltar;
	}

	public Border resaltarFK_IdTipoCuentaBancoTipoCuentaBancoGeneral=null;

	public Border getResaltarFK_IdTipoCuentaBancoTipoCuentaBancoGeneral() {
		return this.resaltarFK_IdTipoCuentaBancoTipoCuentaBancoGeneral;
	}

	public void setResaltarFK_IdTipoCuentaBancoTipoCuentaBancoGeneral(Border borderResaltar) {
		this.resaltarFK_IdTipoCuentaBancoTipoCuentaBancoGeneral= borderResaltar;
	}

	public void setResaltarFK_IdTipoCuentaBancoTipoCuentaBancoGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuentaBancoGeneralBeanSwingJInternalFrame tipocuentabancogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoCuentaBancoTipoCuentaBancoGeneral= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}