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


import com.bydan.erp.cartera.util.RadioVenciClienteProveConstantesFunciones;
import com.bydan.erp.cartera.util.RadioVenciClienteProveParameterReturnGeneral;
//import com.bydan.erp.cartera.util.RadioVenciClienteProveParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class RadioVenciClienteProveConstantesFunciones extends RadioVenciClienteProveConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="RadioVenciClienteProve";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="RadioVenciClienteProve"+RadioVenciClienteProveConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="RadioVenciClienteProveHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="RadioVenciClienteProveHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=RadioVenciClienteProveConstantesFunciones.SCHEMA+"_"+RadioVenciClienteProveConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/RadioVenciClienteProveHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=RadioVenciClienteProveConstantesFunciones.SCHEMA+"_"+RadioVenciClienteProveConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=RadioVenciClienteProveConstantesFunciones.SCHEMA+"_"+RadioVenciClienteProveConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/RadioVenciClienteProveHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=RadioVenciClienteProveConstantesFunciones.SCHEMA+"_"+RadioVenciClienteProveConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RadioVenciClienteProveConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RadioVenciClienteProveHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RadioVenciClienteProveConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RadioVenciClienteProveConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RadioVenciClienteProveHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RadioVenciClienteProveConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=RadioVenciClienteProveConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+RadioVenciClienteProveConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=RadioVenciClienteProveConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+RadioVenciClienteProveConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Dias Por Vencers";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Dias Por Vencer";
	public static final String SCLASSWEBTITULO_LOWER="Radio Venci Cliente Prove";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="RadioVenciClienteProve";
	public static final String OBJECTNAME="radiovenciclienteprove";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="radio_venci_cliente_prove";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select radiovenciclienteprove from "+RadioVenciClienteProveConstantesFunciones.SPERSISTENCENAME+" radiovenciclienteprove";
	public static String QUERYSELECTNATIVE="select "+RadioVenciClienteProveConstantesFunciones.SCHEMA+"."+RadioVenciClienteProveConstantesFunciones.TABLENAME+".id,"+RadioVenciClienteProveConstantesFunciones.SCHEMA+"."+RadioVenciClienteProveConstantesFunciones.TABLENAME+".version_row,"+RadioVenciClienteProveConstantesFunciones.SCHEMA+"."+RadioVenciClienteProveConstantesFunciones.TABLENAME+".id_empresa,"+RadioVenciClienteProveConstantesFunciones.SCHEMA+"."+RadioVenciClienteProveConstantesFunciones.TABLENAME+".id_tipo_radio_venci,"+RadioVenciClienteProveConstantesFunciones.SCHEMA+"."+RadioVenciClienteProveConstantesFunciones.TABLENAME+".dia_desde,"+RadioVenciClienteProveConstantesFunciones.SCHEMA+"."+RadioVenciClienteProveConstantesFunciones.TABLENAME+".dia_hasta from "+RadioVenciClienteProveConstantesFunciones.SCHEMA+"."+RadioVenciClienteProveConstantesFunciones.TABLENAME;//+" as "+RadioVenciClienteProveConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected RadioVenciClienteProveConstantesFuncionesAdditional radiovenciclienteproveConstantesFuncionesAdditional=null;
	
	public RadioVenciClienteProveConstantesFuncionesAdditional getRadioVenciClienteProveConstantesFuncionesAdditional() {
		return this.radiovenciclienteproveConstantesFuncionesAdditional;
	}
	
	public void setRadioVenciClienteProveConstantesFuncionesAdditional(RadioVenciClienteProveConstantesFuncionesAdditional radiovenciclienteproveConstantesFuncionesAdditional) {
		try {
			this.radiovenciclienteproveConstantesFuncionesAdditional=radiovenciclienteproveConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDTIPORADIOVENCI= "id_tipo_radio_venci";
    public static final String DIADESDE= "dia_desde";
    public static final String DIAHASTA= "dia_hasta";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDTIPORADIOVENCI= "Tipo Radio Vencimiento";
		public static final String LABEL_IDTIPORADIOVENCI_LOWER= "Tipo Radio Venci";
    	public static final String LABEL_DIADESDE= "Dia Desde";
		public static final String LABEL_DIADESDE_LOWER= "Dia Desde";
    	public static final String LABEL_DIAHASTA= "Dia Hasta";
		public static final String LABEL_DIAHASTA_LOWER= "Dia Hasta";
	
		
		
		
		
		
		
	
	public static String getRadioVenciClienteProveLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(RadioVenciClienteProveConstantesFunciones.IDEMPRESA)) {sLabelColumna=RadioVenciClienteProveConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(RadioVenciClienteProveConstantesFunciones.IDTIPORADIOVENCI)) {sLabelColumna=RadioVenciClienteProveConstantesFunciones.LABEL_IDTIPORADIOVENCI;}
		if(sNombreColumna.equals(RadioVenciClienteProveConstantesFunciones.DIADESDE)) {sLabelColumna=RadioVenciClienteProveConstantesFunciones.LABEL_DIADESDE;}
		if(sNombreColumna.equals(RadioVenciClienteProveConstantesFunciones.DIAHASTA)) {sLabelColumna=RadioVenciClienteProveConstantesFunciones.LABEL_DIAHASTA;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getRadioVenciClienteProveDescripcion(RadioVenciClienteProve radiovenciclienteprove) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(radiovenciclienteprove !=null/* && radiovenciclienteprove.getId()!=0*/) {
			if(radiovenciclienteprove.getId()!=null) {
				sDescripcion=radiovenciclienteprove.getId().toString();
			}//radiovenciclienteproveradiovenciclienteprove.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getRadioVenciClienteProveDescripcionDetallado(RadioVenciClienteProve radiovenciclienteprove) {
		String sDescripcion="";
			
		sDescripcion+=RadioVenciClienteProveConstantesFunciones.ID+"=";
		sDescripcion+=radiovenciclienteprove.getId().toString()+",";
		sDescripcion+=RadioVenciClienteProveConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=radiovenciclienteprove.getVersionRow().toString()+",";
		sDescripcion+=RadioVenciClienteProveConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=radiovenciclienteprove.getid_empresa().toString()+",";
		sDescripcion+=RadioVenciClienteProveConstantesFunciones.IDTIPORADIOVENCI+"=";
		sDescripcion+=radiovenciclienteprove.getid_tipo_radio_venci().toString()+",";
		sDescripcion+=RadioVenciClienteProveConstantesFunciones.DIADESDE+"=";
		sDescripcion+=radiovenciclienteprove.getdia_desde().toString()+",";
		sDescripcion+=RadioVenciClienteProveConstantesFunciones.DIAHASTA+"=";
		sDescripcion+=radiovenciclienteprove.getdia_hasta().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setRadioVenciClienteProveDescripcion(RadioVenciClienteProve radiovenciclienteprove,String sValor) throws Exception {			
		if(radiovenciclienteprove !=null) {
			//radiovenciclienteproveradiovenciclienteprove.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getTipoRadioVenciDescripcion(TipoRadioVenci tiporadiovenci) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiporadiovenci!=null/*&&tiporadiovenci.getId()>0*/) {
			sDescripcion=TipoRadioVenciConstantesFunciones.getTipoRadioVenciDescripcion(tiporadiovenci);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdTipoRadioVenci")) {
			sNombreIndice="Tipo=  Por Tipo Radio Vencimiento";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoRadioVenci(Long id_tipo_radio_venci) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_radio_venci!=null) {sDetalleIndice+=" Codigo Unico De Tipo Radio Vencimiento="+id_tipo_radio_venci.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosRadioVenciClienteProve(RadioVenciClienteProve radiovenciclienteprove,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosRadioVenciClienteProves(List<RadioVenciClienteProve> radiovenciclienteproves,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(RadioVenciClienteProve radiovenciclienteprove: radiovenciclienteproves) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRadioVenciClienteProve(RadioVenciClienteProve radiovenciclienteprove,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && radiovenciclienteprove.getConCambioAuxiliar()) {
			radiovenciclienteprove.setIsDeleted(radiovenciclienteprove.getIsDeletedAuxiliar());	
			radiovenciclienteprove.setIsNew(radiovenciclienteprove.getIsNewAuxiliar());	
			radiovenciclienteprove.setIsChanged(radiovenciclienteprove.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			radiovenciclienteprove.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			radiovenciclienteprove.setIsDeletedAuxiliar(false);	
			radiovenciclienteprove.setIsNewAuxiliar(false);	
			radiovenciclienteprove.setIsChangedAuxiliar(false);
			
			radiovenciclienteprove.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRadioVenciClienteProves(List<RadioVenciClienteProve> radiovenciclienteproves,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(RadioVenciClienteProve radiovenciclienteprove : radiovenciclienteproves) {
			if(conAsignarBase && radiovenciclienteprove.getConCambioAuxiliar()) {
				radiovenciclienteprove.setIsDeleted(radiovenciclienteprove.getIsDeletedAuxiliar());	
				radiovenciclienteprove.setIsNew(radiovenciclienteprove.getIsNewAuxiliar());	
				radiovenciclienteprove.setIsChanged(radiovenciclienteprove.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				radiovenciclienteprove.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				radiovenciclienteprove.setIsDeletedAuxiliar(false);	
				radiovenciclienteprove.setIsNewAuxiliar(false);	
				radiovenciclienteprove.setIsChangedAuxiliar(false);
				
				radiovenciclienteprove.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresRadioVenciClienteProve(RadioVenciClienteProve radiovenciclienteprove,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			radiovenciclienteprove.setdia_desde(0);
			radiovenciclienteprove.setdia_hasta(0);
		}
	}		
	
	public static void InicializarValoresRadioVenciClienteProves(List<RadioVenciClienteProve> radiovenciclienteproves,Boolean conEnteros) throws Exception  {
		
		for(RadioVenciClienteProve radiovenciclienteprove: radiovenciclienteproves) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				radiovenciclienteprove.setdia_desde(0);
				radiovenciclienteprove.setdia_hasta(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaRadioVenciClienteProve(List<RadioVenciClienteProve> radiovenciclienteproves,RadioVenciClienteProve radiovenciclienteproveAux) throws Exception  {
		RadioVenciClienteProveConstantesFunciones.InicializarValoresRadioVenciClienteProve(radiovenciclienteproveAux,true);
		
		for(RadioVenciClienteProve radiovenciclienteprove: radiovenciclienteproves) {
			if(radiovenciclienteprove.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			radiovenciclienteproveAux.setdia_desde(radiovenciclienteproveAux.getdia_desde()+radiovenciclienteprove.getdia_desde());			
			radiovenciclienteproveAux.setdia_hasta(radiovenciclienteproveAux.getdia_hasta()+radiovenciclienteprove.getdia_hasta());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesRadioVenciClienteProve(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=RadioVenciClienteProveConstantesFunciones.getArrayColumnasGlobalesRadioVenciClienteProve(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesRadioVenciClienteProve(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RadioVenciClienteProveConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RadioVenciClienteProveConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoRadioVenciClienteProve(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<RadioVenciClienteProve> radiovenciclienteproves,RadioVenciClienteProve radiovenciclienteprove,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(RadioVenciClienteProve radiovenciclienteproveAux: radiovenciclienteproves) {
			if(radiovenciclienteproveAux!=null && radiovenciclienteprove!=null) {
				if((radiovenciclienteproveAux.getId()==null && radiovenciclienteprove.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(radiovenciclienteproveAux.getId()!=null && radiovenciclienteprove.getId()!=null){
					if(radiovenciclienteproveAux.getId().equals(radiovenciclienteprove.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaRadioVenciClienteProve(List<RadioVenciClienteProve> radiovenciclienteproves) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(RadioVenciClienteProve radiovenciclienteprove: radiovenciclienteproves) {			
			if(radiovenciclienteprove.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaRadioVenciClienteProve() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,RadioVenciClienteProveConstantesFunciones.LABEL_ID, RadioVenciClienteProveConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RadioVenciClienteProveConstantesFunciones.LABEL_VERSIONROW, RadioVenciClienteProveConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RadioVenciClienteProveConstantesFunciones.LABEL_IDEMPRESA, RadioVenciClienteProveConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RadioVenciClienteProveConstantesFunciones.LABEL_IDTIPORADIOVENCI, RadioVenciClienteProveConstantesFunciones.IDTIPORADIOVENCI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RadioVenciClienteProveConstantesFunciones.LABEL_DIADESDE, RadioVenciClienteProveConstantesFunciones.DIADESDE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RadioVenciClienteProveConstantesFunciones.LABEL_DIAHASTA, RadioVenciClienteProveConstantesFunciones.DIAHASTA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasRadioVenciClienteProve() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=RadioVenciClienteProveConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RadioVenciClienteProveConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RadioVenciClienteProveConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RadioVenciClienteProveConstantesFunciones.IDTIPORADIOVENCI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RadioVenciClienteProveConstantesFunciones.DIADESDE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RadioVenciClienteProveConstantesFunciones.DIAHASTA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRadioVenciClienteProve() throws Exception  {
		return RadioVenciClienteProveConstantesFunciones.getTiposSeleccionarRadioVenciClienteProve(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRadioVenciClienteProve(Boolean conFk) throws Exception  {
		return RadioVenciClienteProveConstantesFunciones.getTiposSeleccionarRadioVenciClienteProve(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRadioVenciClienteProve(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RadioVenciClienteProveConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(RadioVenciClienteProveConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RadioVenciClienteProveConstantesFunciones.LABEL_IDTIPORADIOVENCI);
			reporte.setsDescripcion(RadioVenciClienteProveConstantesFunciones.LABEL_IDTIPORADIOVENCI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RadioVenciClienteProveConstantesFunciones.LABEL_DIADESDE);
			reporte.setsDescripcion(RadioVenciClienteProveConstantesFunciones.LABEL_DIADESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RadioVenciClienteProveConstantesFunciones.LABEL_DIAHASTA);
			reporte.setsDescripcion(RadioVenciClienteProveConstantesFunciones.LABEL_DIAHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesRadioVenciClienteProve(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesRadioVenciClienteProve(RadioVenciClienteProve radiovenciclienteproveAux) throws Exception {
		
			radiovenciclienteproveAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(radiovenciclienteproveAux.getEmpresa()));
			radiovenciclienteproveAux.settiporadiovenci_descripcion(TipoRadioVenciConstantesFunciones.getTipoRadioVenciDescripcion(radiovenciclienteproveAux.getTipoRadioVenci()));		
	}
	
	public static void refrescarForeignKeysDescripcionesRadioVenciClienteProve(List<RadioVenciClienteProve> radiovenciclienteprovesTemp) throws Exception {
		for(RadioVenciClienteProve radiovenciclienteproveAux:radiovenciclienteprovesTemp) {
			
			radiovenciclienteproveAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(radiovenciclienteproveAux.getEmpresa()));
			radiovenciclienteproveAux.settiporadiovenci_descripcion(TipoRadioVenciConstantesFunciones.getTipoRadioVenciDescripcion(radiovenciclienteproveAux.getTipoRadioVenci()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfRadioVenciClienteProve(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(TipoRadioVenci.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoRadioVenci.class)) {
						classes.add(new Classe(TipoRadioVenci.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfRadioVenciClienteProve(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoRadioVenci.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRadioVenci.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoRadioVenci.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRadioVenci.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfRadioVenciClienteProve(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return RadioVenciClienteProveConstantesFunciones.getClassesRelationshipsOfRadioVenciClienteProve(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRadioVenciClienteProve(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRadioVenciClienteProve(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return RadioVenciClienteProveConstantesFunciones.getClassesRelationshipsFromStringsOfRadioVenciClienteProve(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRadioVenciClienteProve(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(RadioVenciClienteProve radiovenciclienteprove,List<RadioVenciClienteProve> radiovenciclienteproves,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			RadioVenciClienteProve radiovenciclienteproveEncontrado=null;
			
			for(RadioVenciClienteProve radiovenciclienteproveLocal:radiovenciclienteproves) {
				if(radiovenciclienteproveLocal.getId().equals(radiovenciclienteprove.getId())) {
					radiovenciclienteproveEncontrado=radiovenciclienteproveLocal;
					
					radiovenciclienteproveLocal.setIsChanged(radiovenciclienteprove.getIsChanged());
					radiovenciclienteproveLocal.setIsNew(radiovenciclienteprove.getIsNew());
					radiovenciclienteproveLocal.setIsDeleted(radiovenciclienteprove.getIsDeleted());
					
					radiovenciclienteproveLocal.setGeneralEntityOriginal(radiovenciclienteprove.getGeneralEntityOriginal());
					
					radiovenciclienteproveLocal.setId(radiovenciclienteprove.getId());	
					radiovenciclienteproveLocal.setVersionRow(radiovenciclienteprove.getVersionRow());	
					radiovenciclienteproveLocal.setid_empresa(radiovenciclienteprove.getid_empresa());	
					radiovenciclienteproveLocal.setid_tipo_radio_venci(radiovenciclienteprove.getid_tipo_radio_venci());	
					radiovenciclienteproveLocal.setdia_desde(radiovenciclienteprove.getdia_desde());	
					radiovenciclienteproveLocal.setdia_hasta(radiovenciclienteprove.getdia_hasta());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!radiovenciclienteprove.getIsDeleted()) {
				if(!existe) {
					radiovenciclienteproves.add(radiovenciclienteprove);
				}
			} else {
				if(radiovenciclienteproveEncontrado!=null && permiteQuitar)  {
					radiovenciclienteproves.remove(radiovenciclienteproveEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(RadioVenciClienteProve radiovenciclienteprove,List<RadioVenciClienteProve> radiovenciclienteproves) throws Exception {
		try	{			
			for(RadioVenciClienteProve radiovenciclienteproveLocal:radiovenciclienteproves) {
				if(radiovenciclienteproveLocal.getId().equals(radiovenciclienteprove.getId())) {
					radiovenciclienteproveLocal.setIsSelected(radiovenciclienteprove.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesRadioVenciClienteProve(List<RadioVenciClienteProve> radiovenciclienteprovesAux) throws Exception {
		//this.radiovenciclienteprovesAux=radiovenciclienteprovesAux;
		
		for(RadioVenciClienteProve radiovenciclienteproveAux:radiovenciclienteprovesAux) {
			if(radiovenciclienteproveAux.getIsChanged()) {
				radiovenciclienteproveAux.setIsChanged(false);
			}		
			
			if(radiovenciclienteproveAux.getIsNew()) {
				radiovenciclienteproveAux.setIsNew(false);
			}	
			
			if(radiovenciclienteproveAux.getIsDeleted()) {
				radiovenciclienteproveAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesRadioVenciClienteProve(RadioVenciClienteProve radiovenciclienteproveAux) throws Exception {
		//this.radiovenciclienteproveAux=radiovenciclienteproveAux;
		
			if(radiovenciclienteproveAux.getIsChanged()) {
				radiovenciclienteproveAux.setIsChanged(false);
			}		
			
			if(radiovenciclienteproveAux.getIsNew()) {
				radiovenciclienteproveAux.setIsNew(false);
			}	
			
			if(radiovenciclienteproveAux.getIsDeleted()) {
				radiovenciclienteproveAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(RadioVenciClienteProve radiovenciclienteproveAsignar,RadioVenciClienteProve radiovenciclienteprove) throws Exception {
		radiovenciclienteproveAsignar.setId(radiovenciclienteprove.getId());	
		radiovenciclienteproveAsignar.setVersionRow(radiovenciclienteprove.getVersionRow());	
		radiovenciclienteproveAsignar.setid_empresa(radiovenciclienteprove.getid_empresa());
		radiovenciclienteproveAsignar.setempresa_descripcion(radiovenciclienteprove.getempresa_descripcion());	
		radiovenciclienteproveAsignar.setid_tipo_radio_venci(radiovenciclienteprove.getid_tipo_radio_venci());
		radiovenciclienteproveAsignar.settiporadiovenci_descripcion(radiovenciclienteprove.gettiporadiovenci_descripcion());	
		radiovenciclienteproveAsignar.setdia_desde(radiovenciclienteprove.getdia_desde());	
		radiovenciclienteproveAsignar.setdia_hasta(radiovenciclienteprove.getdia_hasta());	
	}
	
	public static void inicializarRadioVenciClienteProve(RadioVenciClienteProve radiovenciclienteprove) throws Exception {
		try {
				radiovenciclienteprove.setId(0L);	
					
				radiovenciclienteprove.setid_empresa(-1L);	
				radiovenciclienteprove.setid_tipo_radio_venci(-1L);	
				radiovenciclienteprove.setdia_desde(0);	
				radiovenciclienteprove.setdia_hasta(0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderRadioVenciClienteProve(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(RadioVenciClienteProveConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RadioVenciClienteProveConstantesFunciones.LABEL_IDTIPORADIOVENCI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RadioVenciClienteProveConstantesFunciones.LABEL_DIADESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RadioVenciClienteProveConstantesFunciones.LABEL_DIAHASTA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataRadioVenciClienteProve(String sTipo,Row row,Workbook workbook,RadioVenciClienteProve radiovenciclienteprove,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(radiovenciclienteprove.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(radiovenciclienteprove.gettiporadiovenci_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(radiovenciclienteprove.getdia_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(radiovenciclienteprove.getdia_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryRadioVenciClienteProve=Constantes.SFINALQUERY;
	
	public String getsFinalQueryRadioVenciClienteProve() {
		return this.sFinalQueryRadioVenciClienteProve;
	}
	
	public void setsFinalQueryRadioVenciClienteProve(String sFinalQueryRadioVenciClienteProve) {
		this.sFinalQueryRadioVenciClienteProve= sFinalQueryRadioVenciClienteProve;
	}
	
	public Border resaltarSeleccionarRadioVenciClienteProve=null;
	
	public Border setResaltarSeleccionarRadioVenciClienteProve(ParametroGeneralUsuario parametroGeneralUsuario/*RadioVenciClienteProveBeanSwingJInternalFrame radiovenciclienteproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//radiovenciclienteproveBeanSwingJInternalFrame.jTtoolBarRadioVenciClienteProve.setBorder(borderResaltar);
		
		this.resaltarSeleccionarRadioVenciClienteProve= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarRadioVenciClienteProve() {
		return this.resaltarSeleccionarRadioVenciClienteProve;
	}
	
	public void setResaltarSeleccionarRadioVenciClienteProve(Border borderResaltarSeleccionarRadioVenciClienteProve) {
		this.resaltarSeleccionarRadioVenciClienteProve= borderResaltarSeleccionarRadioVenciClienteProve;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridRadioVenciClienteProve=null;
	public Boolean mostraridRadioVenciClienteProve=true;
	public Boolean activaridRadioVenciClienteProve=true;

	public Border resaltarid_empresaRadioVenciClienteProve=null;
	public Boolean mostrarid_empresaRadioVenciClienteProve=true;
	public Boolean activarid_empresaRadioVenciClienteProve=true;
	public Boolean cargarid_empresaRadioVenciClienteProve=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaRadioVenciClienteProve=false;//ConEventDepend=true

	public Border resaltarid_tipo_radio_venciRadioVenciClienteProve=null;
	public Boolean mostrarid_tipo_radio_venciRadioVenciClienteProve=true;
	public Boolean activarid_tipo_radio_venciRadioVenciClienteProve=true;
	public Boolean cargarid_tipo_radio_venciRadioVenciClienteProve=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_radio_venciRadioVenciClienteProve=false;//ConEventDepend=true

	public Border resaltardia_desdeRadioVenciClienteProve=null;
	public Boolean mostrardia_desdeRadioVenciClienteProve=true;
	public Boolean activardia_desdeRadioVenciClienteProve=true;

	public Border resaltardia_hastaRadioVenciClienteProve=null;
	public Boolean mostrardia_hastaRadioVenciClienteProve=true;
	public Boolean activardia_hastaRadioVenciClienteProve=true;

	
	

	public Border setResaltaridRadioVenciClienteProve(ParametroGeneralUsuario parametroGeneralUsuario/*RadioVenciClienteProveBeanSwingJInternalFrame radiovenciclienteproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//radiovenciclienteproveBeanSwingJInternalFrame.jTtoolBarRadioVenciClienteProve.setBorder(borderResaltar);
		
		this.resaltaridRadioVenciClienteProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridRadioVenciClienteProve() {
		return this.resaltaridRadioVenciClienteProve;
	}

	public void setResaltaridRadioVenciClienteProve(Border borderResaltar) {
		this.resaltaridRadioVenciClienteProve= borderResaltar;
	}

	public Boolean getMostraridRadioVenciClienteProve() {
		return this.mostraridRadioVenciClienteProve;
	}

	public void setMostraridRadioVenciClienteProve(Boolean mostraridRadioVenciClienteProve) {
		this.mostraridRadioVenciClienteProve= mostraridRadioVenciClienteProve;
	}

	public Boolean getActivaridRadioVenciClienteProve() {
		return this.activaridRadioVenciClienteProve;
	}

	public void setActivaridRadioVenciClienteProve(Boolean activaridRadioVenciClienteProve) {
		this.activaridRadioVenciClienteProve= activaridRadioVenciClienteProve;
	}

	public Border setResaltarid_empresaRadioVenciClienteProve(ParametroGeneralUsuario parametroGeneralUsuario/*RadioVenciClienteProveBeanSwingJInternalFrame radiovenciclienteproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//radiovenciclienteproveBeanSwingJInternalFrame.jTtoolBarRadioVenciClienteProve.setBorder(borderResaltar);
		
		this.resaltarid_empresaRadioVenciClienteProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaRadioVenciClienteProve() {
		return this.resaltarid_empresaRadioVenciClienteProve;
	}

	public void setResaltarid_empresaRadioVenciClienteProve(Border borderResaltar) {
		this.resaltarid_empresaRadioVenciClienteProve= borderResaltar;
	}

	public Boolean getMostrarid_empresaRadioVenciClienteProve() {
		return this.mostrarid_empresaRadioVenciClienteProve;
	}

	public void setMostrarid_empresaRadioVenciClienteProve(Boolean mostrarid_empresaRadioVenciClienteProve) {
		this.mostrarid_empresaRadioVenciClienteProve= mostrarid_empresaRadioVenciClienteProve;
	}

	public Boolean getActivarid_empresaRadioVenciClienteProve() {
		return this.activarid_empresaRadioVenciClienteProve;
	}

	public void setActivarid_empresaRadioVenciClienteProve(Boolean activarid_empresaRadioVenciClienteProve) {
		this.activarid_empresaRadioVenciClienteProve= activarid_empresaRadioVenciClienteProve;
	}

	public Boolean getCargarid_empresaRadioVenciClienteProve() {
		return this.cargarid_empresaRadioVenciClienteProve;
	}

	public void setCargarid_empresaRadioVenciClienteProve(Boolean cargarid_empresaRadioVenciClienteProve) {
		this.cargarid_empresaRadioVenciClienteProve= cargarid_empresaRadioVenciClienteProve;
	}

	public Border setResaltarid_tipo_radio_venciRadioVenciClienteProve(ParametroGeneralUsuario parametroGeneralUsuario/*RadioVenciClienteProveBeanSwingJInternalFrame radiovenciclienteproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//radiovenciclienteproveBeanSwingJInternalFrame.jTtoolBarRadioVenciClienteProve.setBorder(borderResaltar);
		
		this.resaltarid_tipo_radio_venciRadioVenciClienteProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_radio_venciRadioVenciClienteProve() {
		return this.resaltarid_tipo_radio_venciRadioVenciClienteProve;
	}

	public void setResaltarid_tipo_radio_venciRadioVenciClienteProve(Border borderResaltar) {
		this.resaltarid_tipo_radio_venciRadioVenciClienteProve= borderResaltar;
	}

	public Boolean getMostrarid_tipo_radio_venciRadioVenciClienteProve() {
		return this.mostrarid_tipo_radio_venciRadioVenciClienteProve;
	}

	public void setMostrarid_tipo_radio_venciRadioVenciClienteProve(Boolean mostrarid_tipo_radio_venciRadioVenciClienteProve) {
		this.mostrarid_tipo_radio_venciRadioVenciClienteProve= mostrarid_tipo_radio_venciRadioVenciClienteProve;
	}

	public Boolean getActivarid_tipo_radio_venciRadioVenciClienteProve() {
		return this.activarid_tipo_radio_venciRadioVenciClienteProve;
	}

	public void setActivarid_tipo_radio_venciRadioVenciClienteProve(Boolean activarid_tipo_radio_venciRadioVenciClienteProve) {
		this.activarid_tipo_radio_venciRadioVenciClienteProve= activarid_tipo_radio_venciRadioVenciClienteProve;
	}

	public Boolean getCargarid_tipo_radio_venciRadioVenciClienteProve() {
		return this.cargarid_tipo_radio_venciRadioVenciClienteProve;
	}

	public void setCargarid_tipo_radio_venciRadioVenciClienteProve(Boolean cargarid_tipo_radio_venciRadioVenciClienteProve) {
		this.cargarid_tipo_radio_venciRadioVenciClienteProve= cargarid_tipo_radio_venciRadioVenciClienteProve;
	}

	public Border setResaltardia_desdeRadioVenciClienteProve(ParametroGeneralUsuario parametroGeneralUsuario/*RadioVenciClienteProveBeanSwingJInternalFrame radiovenciclienteproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//radiovenciclienteproveBeanSwingJInternalFrame.jTtoolBarRadioVenciClienteProve.setBorder(borderResaltar);
		
		this.resaltardia_desdeRadioVenciClienteProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardia_desdeRadioVenciClienteProve() {
		return this.resaltardia_desdeRadioVenciClienteProve;
	}

	public void setResaltardia_desdeRadioVenciClienteProve(Border borderResaltar) {
		this.resaltardia_desdeRadioVenciClienteProve= borderResaltar;
	}

	public Boolean getMostrardia_desdeRadioVenciClienteProve() {
		return this.mostrardia_desdeRadioVenciClienteProve;
	}

	public void setMostrardia_desdeRadioVenciClienteProve(Boolean mostrardia_desdeRadioVenciClienteProve) {
		this.mostrardia_desdeRadioVenciClienteProve= mostrardia_desdeRadioVenciClienteProve;
	}

	public Boolean getActivardia_desdeRadioVenciClienteProve() {
		return this.activardia_desdeRadioVenciClienteProve;
	}

	public void setActivardia_desdeRadioVenciClienteProve(Boolean activardia_desdeRadioVenciClienteProve) {
		this.activardia_desdeRadioVenciClienteProve= activardia_desdeRadioVenciClienteProve;
	}

	public Border setResaltardia_hastaRadioVenciClienteProve(ParametroGeneralUsuario parametroGeneralUsuario/*RadioVenciClienteProveBeanSwingJInternalFrame radiovenciclienteproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//radiovenciclienteproveBeanSwingJInternalFrame.jTtoolBarRadioVenciClienteProve.setBorder(borderResaltar);
		
		this.resaltardia_hastaRadioVenciClienteProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardia_hastaRadioVenciClienteProve() {
		return this.resaltardia_hastaRadioVenciClienteProve;
	}

	public void setResaltardia_hastaRadioVenciClienteProve(Border borderResaltar) {
		this.resaltardia_hastaRadioVenciClienteProve= borderResaltar;
	}

	public Boolean getMostrardia_hastaRadioVenciClienteProve() {
		return this.mostrardia_hastaRadioVenciClienteProve;
	}

	public void setMostrardia_hastaRadioVenciClienteProve(Boolean mostrardia_hastaRadioVenciClienteProve) {
		this.mostrardia_hastaRadioVenciClienteProve= mostrardia_hastaRadioVenciClienteProve;
	}

	public Boolean getActivardia_hastaRadioVenciClienteProve() {
		return this.activardia_hastaRadioVenciClienteProve;
	}

	public void setActivardia_hastaRadioVenciClienteProve(Boolean activardia_hastaRadioVenciClienteProve) {
		this.activardia_hastaRadioVenciClienteProve= activardia_hastaRadioVenciClienteProve;
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
		
		
		this.setMostraridRadioVenciClienteProve(esInicial);
		this.setMostrarid_empresaRadioVenciClienteProve(esInicial);
		this.setMostrarid_tipo_radio_venciRadioVenciClienteProve(esInicial);
		this.setMostrardia_desdeRadioVenciClienteProve(esInicial);
		this.setMostrardia_hastaRadioVenciClienteProve(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RadioVenciClienteProveConstantesFunciones.ID)) {
				this.setMostraridRadioVenciClienteProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(RadioVenciClienteProveConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaRadioVenciClienteProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(RadioVenciClienteProveConstantesFunciones.IDTIPORADIOVENCI)) {
				this.setMostrarid_tipo_radio_venciRadioVenciClienteProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(RadioVenciClienteProveConstantesFunciones.DIADESDE)) {
				this.setMostrardia_desdeRadioVenciClienteProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(RadioVenciClienteProveConstantesFunciones.DIAHASTA)) {
				this.setMostrardia_hastaRadioVenciClienteProve(esAsigna);
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
		
		
		this.setActivaridRadioVenciClienteProve(esInicial);
		this.setActivarid_empresaRadioVenciClienteProve(esInicial);
		this.setActivarid_tipo_radio_venciRadioVenciClienteProve(esInicial);
		this.setActivardia_desdeRadioVenciClienteProve(esInicial);
		this.setActivardia_hastaRadioVenciClienteProve(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RadioVenciClienteProveConstantesFunciones.ID)) {
				this.setActivaridRadioVenciClienteProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(RadioVenciClienteProveConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaRadioVenciClienteProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(RadioVenciClienteProveConstantesFunciones.IDTIPORADIOVENCI)) {
				this.setActivarid_tipo_radio_venciRadioVenciClienteProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(RadioVenciClienteProveConstantesFunciones.DIADESDE)) {
				this.setActivardia_desdeRadioVenciClienteProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(RadioVenciClienteProveConstantesFunciones.DIAHASTA)) {
				this.setActivardia_hastaRadioVenciClienteProve(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,RadioVenciClienteProveBeanSwingJInternalFrame radiovenciclienteproveBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridRadioVenciClienteProve(esInicial);
		this.setResaltarid_empresaRadioVenciClienteProve(esInicial);
		this.setResaltarid_tipo_radio_venciRadioVenciClienteProve(esInicial);
		this.setResaltardia_desdeRadioVenciClienteProve(esInicial);
		this.setResaltardia_hastaRadioVenciClienteProve(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RadioVenciClienteProveConstantesFunciones.ID)) {
				this.setResaltaridRadioVenciClienteProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(RadioVenciClienteProveConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaRadioVenciClienteProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(RadioVenciClienteProveConstantesFunciones.IDTIPORADIOVENCI)) {
				this.setResaltarid_tipo_radio_venciRadioVenciClienteProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(RadioVenciClienteProveConstantesFunciones.DIADESDE)) {
				this.setResaltardia_desdeRadioVenciClienteProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(RadioVenciClienteProveConstantesFunciones.DIAHASTA)) {
				this.setResaltardia_hastaRadioVenciClienteProve(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,RadioVenciClienteProveBeanSwingJInternalFrame radiovenciclienteproveBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaRadioVenciClienteProve=true;

	public Boolean getMostrarFK_IdEmpresaRadioVenciClienteProve() {
		return this.mostrarFK_IdEmpresaRadioVenciClienteProve;
	}

	public void setMostrarFK_IdEmpresaRadioVenciClienteProve(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaRadioVenciClienteProve= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoRadioVenciRadioVenciClienteProve=true;

	public Boolean getMostrarFK_IdTipoRadioVenciRadioVenciClienteProve() {
		return this.mostrarFK_IdTipoRadioVenciRadioVenciClienteProve;
	}

	public void setMostrarFK_IdTipoRadioVenciRadioVenciClienteProve(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoRadioVenciRadioVenciClienteProve= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaRadioVenciClienteProve=true;

	public Boolean getActivarFK_IdEmpresaRadioVenciClienteProve() {
		return this.activarFK_IdEmpresaRadioVenciClienteProve;
	}

	public void setActivarFK_IdEmpresaRadioVenciClienteProve(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaRadioVenciClienteProve= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoRadioVenciRadioVenciClienteProve=true;

	public Boolean getActivarFK_IdTipoRadioVenciRadioVenciClienteProve() {
		return this.activarFK_IdTipoRadioVenciRadioVenciClienteProve;
	}

	public void setActivarFK_IdTipoRadioVenciRadioVenciClienteProve(Boolean habilitarResaltar) {
		this.activarFK_IdTipoRadioVenciRadioVenciClienteProve= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaRadioVenciClienteProve=null;

	public Border getResaltarFK_IdEmpresaRadioVenciClienteProve() {
		return this.resaltarFK_IdEmpresaRadioVenciClienteProve;
	}

	public void setResaltarFK_IdEmpresaRadioVenciClienteProve(Border borderResaltar) {
		this.resaltarFK_IdEmpresaRadioVenciClienteProve= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaRadioVenciClienteProve(ParametroGeneralUsuario parametroGeneralUsuario/*RadioVenciClienteProveBeanSwingJInternalFrame radiovenciclienteproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaRadioVenciClienteProve= borderResaltar;
	}

	public Border resaltarFK_IdTipoRadioVenciRadioVenciClienteProve=null;

	public Border getResaltarFK_IdTipoRadioVenciRadioVenciClienteProve() {
		return this.resaltarFK_IdTipoRadioVenciRadioVenciClienteProve;
	}

	public void setResaltarFK_IdTipoRadioVenciRadioVenciClienteProve(Border borderResaltar) {
		this.resaltarFK_IdTipoRadioVenciRadioVenciClienteProve= borderResaltar;
	}

	public void setResaltarFK_IdTipoRadioVenciRadioVenciClienteProve(ParametroGeneralUsuario parametroGeneralUsuario/*RadioVenciClienteProveBeanSwingJInternalFrame radiovenciclienteproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoRadioVenciRadioVenciClienteProve= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}