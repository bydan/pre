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


import com.bydan.erp.contabilidad.util.ParametroContaDetalleConstantesFunciones;
import com.bydan.erp.contabilidad.util.ParametroContaDetalleParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.ParametroContaDetalleParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ParametroContaDetalleConstantesFunciones extends ParametroContaDetalleConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ParametroContaDetalle";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ParametroContaDetalle"+ParametroContaDetalleConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ParametroContaDetalleHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ParametroContaDetalleHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ParametroContaDetalleConstantesFunciones.SCHEMA+"_"+ParametroContaDetalleConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ParametroContaDetalleHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ParametroContaDetalleConstantesFunciones.SCHEMA+"_"+ParametroContaDetalleConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ParametroContaDetalleConstantesFunciones.SCHEMA+"_"+ParametroContaDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ParametroContaDetalleHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ParametroContaDetalleConstantesFunciones.SCHEMA+"_"+ParametroContaDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroContaDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroContaDetalleHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroContaDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroContaDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroContaDetalleHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroContaDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ParametroContaDetalleConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ParametroContaDetalleConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ParametroContaDetalleConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ParametroContaDetalleConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Parametro Conta Detalles";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Parametro Conta Detalle";
	public static final String SCLASSWEBTITULO_LOWER="Parametro Conta Detalle";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ParametroContaDetalle";
	public static final String OBJECTNAME="parametrocontadetalle";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="parametro_conta_detalle";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select parametrocontadetalle from "+ParametroContaDetalleConstantesFunciones.SPERSISTENCENAME+" parametrocontadetalle";
	public static String QUERYSELECTNATIVE="select "+ParametroContaDetalleConstantesFunciones.SCHEMA+"."+ParametroContaDetalleConstantesFunciones.TABLENAME+".id,"+ParametroContaDetalleConstantesFunciones.SCHEMA+"."+ParametroContaDetalleConstantesFunciones.TABLENAME+".version_row,"+ParametroContaDetalleConstantesFunciones.SCHEMA+"."+ParametroContaDetalleConstantesFunciones.TABLENAME+".id_parametro_conta,"+ParametroContaDetalleConstantesFunciones.SCHEMA+"."+ParametroContaDetalleConstantesFunciones.TABLENAME+".id_tipo_parametro_conta,"+ParametroContaDetalleConstantesFunciones.SCHEMA+"."+ParametroContaDetalleConstantesFunciones.TABLENAME+".id_cuenta_contable from "+ParametroContaDetalleConstantesFunciones.SCHEMA+"."+ParametroContaDetalleConstantesFunciones.TABLENAME;//+" as "+ParametroContaDetalleConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ParametroContaDetalleConstantesFuncionesAdditional parametrocontadetalleConstantesFuncionesAdditional=null;
	
	public ParametroContaDetalleConstantesFuncionesAdditional getParametroContaDetalleConstantesFuncionesAdditional() {
		return this.parametrocontadetalleConstantesFuncionesAdditional;
	}
	
	public void setParametroContaDetalleConstantesFuncionesAdditional(ParametroContaDetalleConstantesFuncionesAdditional parametrocontadetalleConstantesFuncionesAdditional) {
		try {
			this.parametrocontadetalleConstantesFuncionesAdditional=parametrocontadetalleConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPARAMETROCONTA= "id_parametro_conta";
    public static final String IDTIPOPARAMETROCONTA= "id_tipo_parametro_conta";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDPARAMETROCONTA= "Parametro Conta";
		public static final String LABEL_IDPARAMETROCONTA_LOWER= "Parametro Conta";
    	public static final String LABEL_IDTIPOPARAMETROCONTA= "Tipo Parametro Conta";
		public static final String LABEL_IDTIPOPARAMETROCONTA_LOWER= "Tipo Parametro Conta";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
	
		
		
		
		
		
	
	public static String getParametroContaDetalleLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ParametroContaDetalleConstantesFunciones.IDPARAMETROCONTA)) {sLabelColumna=ParametroContaDetalleConstantesFunciones.LABEL_IDPARAMETROCONTA;}
		if(sNombreColumna.equals(ParametroContaDetalleConstantesFunciones.IDTIPOPARAMETROCONTA)) {sLabelColumna=ParametroContaDetalleConstantesFunciones.LABEL_IDTIPOPARAMETROCONTA;}
		if(sNombreColumna.equals(ParametroContaDetalleConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=ParametroContaDetalleConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getParametroContaDetalleDescripcion(ParametroContaDetalle parametrocontadetalle) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(parametrocontadetalle !=null/* && parametrocontadetalle.getId()!=0*/) {
			if(parametrocontadetalle.getId()!=null) {
				sDescripcion=parametrocontadetalle.getId().toString();
			}//parametrocontadetalleparametrocontadetalle.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getParametroContaDetalleDescripcionDetallado(ParametroContaDetalle parametrocontadetalle) {
		String sDescripcion="";
			
		sDescripcion+=ParametroContaDetalleConstantesFunciones.ID+"=";
		sDescripcion+=parametrocontadetalle.getId().toString()+",";
		sDescripcion+=ParametroContaDetalleConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=parametrocontadetalle.getVersionRow().toString()+",";
		sDescripcion+=ParametroContaDetalleConstantesFunciones.IDPARAMETROCONTA+"=";
		sDescripcion+=parametrocontadetalle.getid_parametro_conta().toString()+",";
		sDescripcion+=ParametroContaDetalleConstantesFunciones.IDTIPOPARAMETROCONTA+"=";
		sDescripcion+=parametrocontadetalle.getid_tipo_parametro_conta().toString()+",";
		sDescripcion+=ParametroContaDetalleConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=parametrocontadetalle.getid_cuenta_contable().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setParametroContaDetalleDescripcion(ParametroContaDetalle parametrocontadetalle,String sValor) throws Exception {			
		if(parametrocontadetalle !=null) {
			//parametrocontadetalleparametrocontadetalle.getId().toString();
		}		
	}
	
		

	public static String getParametroContaDescripcion(ParametroConta parametroconta) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(parametroconta!=null/*&&parametroconta.getId()>0*/) {
			sDescripcion=ParametroContaConstantesFunciones.getParametroContaDescripcion(parametroconta);
		}

		return sDescripcion;
	}

	public static String getTipoParametroContaDescripcion(TipoParametroConta tipoparametroconta) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoparametroconta!=null/*&&tipoparametroconta.getId()>0*/) {
			sDescripcion=TipoParametroContaConstantesFunciones.getTipoParametroContaDescripcion(tipoparametroconta);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDescripcion(CuentaContable cuentacontable) {
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
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cuenta Contable";
		} else if(sNombreIndice.equals("FK_IdParametroConta")) {
			sNombreIndice="Tipo=  Por Parametro Conta";
		} else if(sNombreIndice.equals("FK_IdParametroContaDetalle")) {
			sNombreIndice="Tipo=  Por Tipo Parametro Conta";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable="+id_cuenta_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdParametroConta(Long id_parametro_conta) {
		String sDetalleIndice=" Parametros->";
		if(id_parametro_conta!=null) {sDetalleIndice+=" Codigo Unico De Parametro Conta="+id_parametro_conta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdParametroContaDetalle(Long id_tipo_parametro_conta) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_parametro_conta!=null) {sDetalleIndice+=" Codigo Unico De Tipo Parametro Conta="+id_tipo_parametro_conta.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosParametroContaDetalle(ParametroContaDetalle parametrocontadetalle,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosParametroContaDetalles(List<ParametroContaDetalle> parametrocontadetalles,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ParametroContaDetalle parametrocontadetalle: parametrocontadetalles) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroContaDetalle(ParametroContaDetalle parametrocontadetalle,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && parametrocontadetalle.getConCambioAuxiliar()) {
			parametrocontadetalle.setIsDeleted(parametrocontadetalle.getIsDeletedAuxiliar());	
			parametrocontadetalle.setIsNew(parametrocontadetalle.getIsNewAuxiliar());	
			parametrocontadetalle.setIsChanged(parametrocontadetalle.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			parametrocontadetalle.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			parametrocontadetalle.setIsDeletedAuxiliar(false);	
			parametrocontadetalle.setIsNewAuxiliar(false);	
			parametrocontadetalle.setIsChangedAuxiliar(false);
			
			parametrocontadetalle.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroContaDetalles(List<ParametroContaDetalle> parametrocontadetalles,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ParametroContaDetalle parametrocontadetalle : parametrocontadetalles) {
			if(conAsignarBase && parametrocontadetalle.getConCambioAuxiliar()) {
				parametrocontadetalle.setIsDeleted(parametrocontadetalle.getIsDeletedAuxiliar());	
				parametrocontadetalle.setIsNew(parametrocontadetalle.getIsNewAuxiliar());	
				parametrocontadetalle.setIsChanged(parametrocontadetalle.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				parametrocontadetalle.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				parametrocontadetalle.setIsDeletedAuxiliar(false);	
				parametrocontadetalle.setIsNewAuxiliar(false);	
				parametrocontadetalle.setIsChangedAuxiliar(false);
				
				parametrocontadetalle.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresParametroContaDetalle(ParametroContaDetalle parametrocontadetalle,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresParametroContaDetalles(List<ParametroContaDetalle> parametrocontadetalles,Boolean conEnteros) throws Exception  {
		
		for(ParametroContaDetalle parametrocontadetalle: parametrocontadetalles) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaParametroContaDetalle(List<ParametroContaDetalle> parametrocontadetalles,ParametroContaDetalle parametrocontadetalleAux) throws Exception  {
		ParametroContaDetalleConstantesFunciones.InicializarValoresParametroContaDetalle(parametrocontadetalleAux,true);
		
		for(ParametroContaDetalle parametrocontadetalle: parametrocontadetalles) {
			if(parametrocontadetalle.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroContaDetalle(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ParametroContaDetalleConstantesFunciones.getArrayColumnasGlobalesParametroContaDetalle(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroContaDetalle(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoParametroContaDetalle(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ParametroContaDetalle> parametrocontadetalles,ParametroContaDetalle parametrocontadetalle,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ParametroContaDetalle parametrocontadetalleAux: parametrocontadetalles) {
			if(parametrocontadetalleAux!=null && parametrocontadetalle!=null) {
				if((parametrocontadetalleAux.getId()==null && parametrocontadetalle.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(parametrocontadetalleAux.getId()!=null && parametrocontadetalle.getId()!=null){
					if(parametrocontadetalleAux.getId().equals(parametrocontadetalle.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaParametroContaDetalle(List<ParametroContaDetalle> parametrocontadetalles) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ParametroContaDetalle parametrocontadetalle: parametrocontadetalles) {			
			if(parametrocontadetalle.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaParametroContaDetalle() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ParametroContaDetalleConstantesFunciones.LABEL_ID, ParametroContaDetalleConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContaDetalleConstantesFunciones.LABEL_VERSIONROW, ParametroContaDetalleConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContaDetalleConstantesFunciones.LABEL_IDPARAMETROCONTA, ParametroContaDetalleConstantesFunciones.IDPARAMETROCONTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContaDetalleConstantesFunciones.LABEL_IDTIPOPARAMETROCONTA, ParametroContaDetalleConstantesFunciones.IDTIPOPARAMETROCONTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContaDetalleConstantesFunciones.LABEL_IDCUENTACONTABLE, ParametroContaDetalleConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasParametroContaDetalle() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ParametroContaDetalleConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContaDetalleConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContaDetalleConstantesFunciones.IDPARAMETROCONTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContaDetalleConstantesFunciones.IDTIPOPARAMETROCONTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContaDetalleConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroContaDetalle() throws Exception  {
		return ParametroContaDetalleConstantesFunciones.getTiposSeleccionarParametroContaDetalle(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroContaDetalle(Boolean conFk) throws Exception  {
		return ParametroContaDetalleConstantesFunciones.getTiposSeleccionarParametroContaDetalle(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroContaDetalle(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContaDetalleConstantesFunciones.LABEL_IDPARAMETROCONTA);
			reporte.setsDescripcion(ParametroContaDetalleConstantesFunciones.LABEL_IDPARAMETROCONTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContaDetalleConstantesFunciones.LABEL_IDTIPOPARAMETROCONTA);
			reporte.setsDescripcion(ParametroContaDetalleConstantesFunciones.LABEL_IDTIPOPARAMETROCONTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContaDetalleConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(ParametroContaDetalleConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesParametroContaDetalle(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesParametroContaDetalle(ParametroContaDetalle parametrocontadetalleAux) throws Exception {
		
			parametrocontadetalleAux.setparametroconta_descripcion(ParametroContaConstantesFunciones.getParametroContaDescripcion(parametrocontadetalleAux.getParametroConta()));
			parametrocontadetalleAux.settipoparametroconta_descripcion(TipoParametroContaConstantesFunciones.getTipoParametroContaDescripcion(parametrocontadetalleAux.getTipoParametroConta()));
			parametrocontadetalleAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrocontadetalleAux.getCuentaContable()));		
	}
	
	public static void refrescarForeignKeysDescripcionesParametroContaDetalle(List<ParametroContaDetalle> parametrocontadetallesTemp) throws Exception {
		for(ParametroContaDetalle parametrocontadetalleAux:parametrocontadetallesTemp) {
			
			parametrocontadetalleAux.setparametroconta_descripcion(ParametroContaConstantesFunciones.getParametroContaDescripcion(parametrocontadetalleAux.getParametroConta()));
			parametrocontadetalleAux.settipoparametroconta_descripcion(TipoParametroContaConstantesFunciones.getTipoParametroContaDescripcion(parametrocontadetalleAux.getTipoParametroConta()));
			parametrocontadetalleAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrocontadetalleAux.getCuentaContable()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfParametroContaDetalle(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ParametroConta.class));
				classes.add(new Classe(TipoParametroConta.class));
				classes.add(new Classe(CuentaContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroConta.class)) {
						classes.add(new Classe(ParametroConta.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoParametroConta.class)) {
						classes.add(new Classe(TipoParametroConta.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfParametroContaDetalle(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ParametroConta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroConta.class)); continue;
					}

					if(TipoParametroConta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoParametroConta.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ParametroConta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroConta.class)); continue;
					}

					if(TipoParametroConta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoParametroConta.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroContaDetalle(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroContaDetalleConstantesFunciones.getClassesRelationshipsOfParametroContaDetalle(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroContaDetalle(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroContaDetalle(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroContaDetalleConstantesFunciones.getClassesRelationshipsFromStringsOfParametroContaDetalle(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroContaDetalle(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ParametroContaDetalle parametrocontadetalle,List<ParametroContaDetalle> parametrocontadetalles,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ParametroContaDetalle parametrocontadetalleEncontrado=null;
			
			for(ParametroContaDetalle parametrocontadetalleLocal:parametrocontadetalles) {
				if(parametrocontadetalleLocal.getId().equals(parametrocontadetalle.getId())) {
					parametrocontadetalleEncontrado=parametrocontadetalleLocal;
					
					parametrocontadetalleLocal.setIsChanged(parametrocontadetalle.getIsChanged());
					parametrocontadetalleLocal.setIsNew(parametrocontadetalle.getIsNew());
					parametrocontadetalleLocal.setIsDeleted(parametrocontadetalle.getIsDeleted());
					
					parametrocontadetalleLocal.setGeneralEntityOriginal(parametrocontadetalle.getGeneralEntityOriginal());
					
					parametrocontadetalleLocal.setId(parametrocontadetalle.getId());	
					parametrocontadetalleLocal.setVersionRow(parametrocontadetalle.getVersionRow());	
					parametrocontadetalleLocal.setid_parametro_conta(parametrocontadetalle.getid_parametro_conta());	
					parametrocontadetalleLocal.setid_tipo_parametro_conta(parametrocontadetalle.getid_tipo_parametro_conta());	
					parametrocontadetalleLocal.setid_cuenta_contable(parametrocontadetalle.getid_cuenta_contable());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!parametrocontadetalle.getIsDeleted()) {
				if(!existe) {
					parametrocontadetalles.add(parametrocontadetalle);
				}
			} else {
				if(parametrocontadetalleEncontrado!=null && permiteQuitar)  {
					parametrocontadetalles.remove(parametrocontadetalleEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ParametroContaDetalle parametrocontadetalle,List<ParametroContaDetalle> parametrocontadetalles) throws Exception {
		try	{			
			for(ParametroContaDetalle parametrocontadetalleLocal:parametrocontadetalles) {
				if(parametrocontadetalleLocal.getId().equals(parametrocontadetalle.getId())) {
					parametrocontadetalleLocal.setIsSelected(parametrocontadetalle.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesParametroContaDetalle(List<ParametroContaDetalle> parametrocontadetallesAux) throws Exception {
		//this.parametrocontadetallesAux=parametrocontadetallesAux;
		
		for(ParametroContaDetalle parametrocontadetalleAux:parametrocontadetallesAux) {
			if(parametrocontadetalleAux.getIsChanged()) {
				parametrocontadetalleAux.setIsChanged(false);
			}		
			
			if(parametrocontadetalleAux.getIsNew()) {
				parametrocontadetalleAux.setIsNew(false);
			}	
			
			if(parametrocontadetalleAux.getIsDeleted()) {
				parametrocontadetalleAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesParametroContaDetalle(ParametroContaDetalle parametrocontadetalleAux) throws Exception {
		//this.parametrocontadetalleAux=parametrocontadetalleAux;
		
			if(parametrocontadetalleAux.getIsChanged()) {
				parametrocontadetalleAux.setIsChanged(false);
			}		
			
			if(parametrocontadetalleAux.getIsNew()) {
				parametrocontadetalleAux.setIsNew(false);
			}	
			
			if(parametrocontadetalleAux.getIsDeleted()) {
				parametrocontadetalleAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ParametroContaDetalle parametrocontadetalleAsignar,ParametroContaDetalle parametrocontadetalle) throws Exception {
		parametrocontadetalleAsignar.setId(parametrocontadetalle.getId());	
		parametrocontadetalleAsignar.setVersionRow(parametrocontadetalle.getVersionRow());	
		parametrocontadetalleAsignar.setid_parametro_conta(parametrocontadetalle.getid_parametro_conta());
		parametrocontadetalleAsignar.setparametroconta_descripcion(parametrocontadetalle.getparametroconta_descripcion());	
		parametrocontadetalleAsignar.setid_tipo_parametro_conta(parametrocontadetalle.getid_tipo_parametro_conta());
		parametrocontadetalleAsignar.settipoparametroconta_descripcion(parametrocontadetalle.gettipoparametroconta_descripcion());	
		parametrocontadetalleAsignar.setid_cuenta_contable(parametrocontadetalle.getid_cuenta_contable());
		parametrocontadetalleAsignar.setcuentacontable_descripcion(parametrocontadetalle.getcuentacontable_descripcion());	
	}
	
	public static void inicializarParametroContaDetalle(ParametroContaDetalle parametrocontadetalle) throws Exception {
		try {
				parametrocontadetalle.setId(0L);	
					
				parametrocontadetalle.setid_parametro_conta(-1L);	
				parametrocontadetalle.setid_tipo_parametro_conta(-1L);	
				parametrocontadetalle.setid_cuenta_contable(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderParametroContaDetalle(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContaDetalleConstantesFunciones.LABEL_IDPARAMETROCONTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContaDetalleConstantesFunciones.LABEL_IDTIPOPARAMETROCONTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContaDetalleConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataParametroContaDetalle(String sTipo,Row row,Workbook workbook,ParametroContaDetalle parametrocontadetalle,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocontadetalle.getparametroconta_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocontadetalle.gettipoparametroconta_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocontadetalle.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryParametroContaDetalle=Constantes.SFINALQUERY;
	
	public String getsFinalQueryParametroContaDetalle() {
		return this.sFinalQueryParametroContaDetalle;
	}
	
	public void setsFinalQueryParametroContaDetalle(String sFinalQueryParametroContaDetalle) {
		this.sFinalQueryParametroContaDetalle= sFinalQueryParametroContaDetalle;
	}
	
	public Border resaltarSeleccionarParametroContaDetalle=null;
	
	public Border setResaltarSeleccionarParametroContaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaDetalleBeanSwingJInternalFrame parametrocontadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//parametrocontadetalleBeanSwingJInternalFrame.jTtoolBarParametroContaDetalle.setBorder(borderResaltar);
		
		this.resaltarSeleccionarParametroContaDetalle= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarParametroContaDetalle() {
		return this.resaltarSeleccionarParametroContaDetalle;
	}
	
	public void setResaltarSeleccionarParametroContaDetalle(Border borderResaltarSeleccionarParametroContaDetalle) {
		this.resaltarSeleccionarParametroContaDetalle= borderResaltarSeleccionarParametroContaDetalle;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridParametroContaDetalle=null;
	public Boolean mostraridParametroContaDetalle=true;
	public Boolean activaridParametroContaDetalle=true;

	public Border resaltarid_parametro_contaParametroContaDetalle=null;
	public Boolean mostrarid_parametro_contaParametroContaDetalle=true;
	public Boolean activarid_parametro_contaParametroContaDetalle=true;
	public Boolean cargarid_parametro_contaParametroContaDetalle=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_parametro_contaParametroContaDetalle=false;//ConEventDepend=true

	public Border resaltarid_tipo_parametro_contaParametroContaDetalle=null;
	public Boolean mostrarid_tipo_parametro_contaParametroContaDetalle=true;
	public Boolean activarid_tipo_parametro_contaParametroContaDetalle=true;
	public Boolean cargarid_tipo_parametro_contaParametroContaDetalle=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_parametro_contaParametroContaDetalle=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contableParametroContaDetalle=null;
	public Boolean mostrarid_cuenta_contableParametroContaDetalle=true;
	public Boolean activarid_cuenta_contableParametroContaDetalle=true;
	public Boolean cargarid_cuenta_contableParametroContaDetalle=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableParametroContaDetalle=false;//ConEventDepend=true

	
	

	public Border setResaltaridParametroContaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaDetalleBeanSwingJInternalFrame parametrocontadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontadetalleBeanSwingJInternalFrame.jTtoolBarParametroContaDetalle.setBorder(borderResaltar);
		
		this.resaltaridParametroContaDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridParametroContaDetalle() {
		return this.resaltaridParametroContaDetalle;
	}

	public void setResaltaridParametroContaDetalle(Border borderResaltar) {
		this.resaltaridParametroContaDetalle= borderResaltar;
	}

	public Boolean getMostraridParametroContaDetalle() {
		return this.mostraridParametroContaDetalle;
	}

	public void setMostraridParametroContaDetalle(Boolean mostraridParametroContaDetalle) {
		this.mostraridParametroContaDetalle= mostraridParametroContaDetalle;
	}

	public Boolean getActivaridParametroContaDetalle() {
		return this.activaridParametroContaDetalle;
	}

	public void setActivaridParametroContaDetalle(Boolean activaridParametroContaDetalle) {
		this.activaridParametroContaDetalle= activaridParametroContaDetalle;
	}

	public Border setResaltarid_parametro_contaParametroContaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaDetalleBeanSwingJInternalFrame parametrocontadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontadetalleBeanSwingJInternalFrame.jTtoolBarParametroContaDetalle.setBorder(borderResaltar);
		
		this.resaltarid_parametro_contaParametroContaDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_parametro_contaParametroContaDetalle() {
		return this.resaltarid_parametro_contaParametroContaDetalle;
	}

	public void setResaltarid_parametro_contaParametroContaDetalle(Border borderResaltar) {
		this.resaltarid_parametro_contaParametroContaDetalle= borderResaltar;
	}

	public Boolean getMostrarid_parametro_contaParametroContaDetalle() {
		return this.mostrarid_parametro_contaParametroContaDetalle;
	}

	public void setMostrarid_parametro_contaParametroContaDetalle(Boolean mostrarid_parametro_contaParametroContaDetalle) {
		this.mostrarid_parametro_contaParametroContaDetalle= mostrarid_parametro_contaParametroContaDetalle;
	}

	public Boolean getActivarid_parametro_contaParametroContaDetalle() {
		return this.activarid_parametro_contaParametroContaDetalle;
	}

	public void setActivarid_parametro_contaParametroContaDetalle(Boolean activarid_parametro_contaParametroContaDetalle) {
		this.activarid_parametro_contaParametroContaDetalle= activarid_parametro_contaParametroContaDetalle;
	}

	public Boolean getCargarid_parametro_contaParametroContaDetalle() {
		return this.cargarid_parametro_contaParametroContaDetalle;
	}

	public void setCargarid_parametro_contaParametroContaDetalle(Boolean cargarid_parametro_contaParametroContaDetalle) {
		this.cargarid_parametro_contaParametroContaDetalle= cargarid_parametro_contaParametroContaDetalle;
	}

	public Border setResaltarid_tipo_parametro_contaParametroContaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaDetalleBeanSwingJInternalFrame parametrocontadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontadetalleBeanSwingJInternalFrame.jTtoolBarParametroContaDetalle.setBorder(borderResaltar);
		
		this.resaltarid_tipo_parametro_contaParametroContaDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_parametro_contaParametroContaDetalle() {
		return this.resaltarid_tipo_parametro_contaParametroContaDetalle;
	}

	public void setResaltarid_tipo_parametro_contaParametroContaDetalle(Border borderResaltar) {
		this.resaltarid_tipo_parametro_contaParametroContaDetalle= borderResaltar;
	}

	public Boolean getMostrarid_tipo_parametro_contaParametroContaDetalle() {
		return this.mostrarid_tipo_parametro_contaParametroContaDetalle;
	}

	public void setMostrarid_tipo_parametro_contaParametroContaDetalle(Boolean mostrarid_tipo_parametro_contaParametroContaDetalle) {
		this.mostrarid_tipo_parametro_contaParametroContaDetalle= mostrarid_tipo_parametro_contaParametroContaDetalle;
	}

	public Boolean getActivarid_tipo_parametro_contaParametroContaDetalle() {
		return this.activarid_tipo_parametro_contaParametroContaDetalle;
	}

	public void setActivarid_tipo_parametro_contaParametroContaDetalle(Boolean activarid_tipo_parametro_contaParametroContaDetalle) {
		this.activarid_tipo_parametro_contaParametroContaDetalle= activarid_tipo_parametro_contaParametroContaDetalle;
	}

	public Boolean getCargarid_tipo_parametro_contaParametroContaDetalle() {
		return this.cargarid_tipo_parametro_contaParametroContaDetalle;
	}

	public void setCargarid_tipo_parametro_contaParametroContaDetalle(Boolean cargarid_tipo_parametro_contaParametroContaDetalle) {
		this.cargarid_tipo_parametro_contaParametroContaDetalle= cargarid_tipo_parametro_contaParametroContaDetalle;
	}

	public Border setResaltarid_cuenta_contableParametroContaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaDetalleBeanSwingJInternalFrame parametrocontadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontadetalleBeanSwingJInternalFrame.jTtoolBarParametroContaDetalle.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableParametroContaDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableParametroContaDetalle() {
		return this.resaltarid_cuenta_contableParametroContaDetalle;
	}

	public void setResaltarid_cuenta_contableParametroContaDetalle(Border borderResaltar) {
		this.resaltarid_cuenta_contableParametroContaDetalle= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableParametroContaDetalle() {
		return this.mostrarid_cuenta_contableParametroContaDetalle;
	}

	public void setMostrarid_cuenta_contableParametroContaDetalle(Boolean mostrarid_cuenta_contableParametroContaDetalle) {
		this.mostrarid_cuenta_contableParametroContaDetalle= mostrarid_cuenta_contableParametroContaDetalle;
	}

	public Boolean getActivarid_cuenta_contableParametroContaDetalle() {
		return this.activarid_cuenta_contableParametroContaDetalle;
	}

	public void setActivarid_cuenta_contableParametroContaDetalle(Boolean activarid_cuenta_contableParametroContaDetalle) {
		this.activarid_cuenta_contableParametroContaDetalle= activarid_cuenta_contableParametroContaDetalle;
	}

	public Boolean getCargarid_cuenta_contableParametroContaDetalle() {
		return this.cargarid_cuenta_contableParametroContaDetalle;
	}

	public void setCargarid_cuenta_contableParametroContaDetalle(Boolean cargarid_cuenta_contableParametroContaDetalle) {
		this.cargarid_cuenta_contableParametroContaDetalle= cargarid_cuenta_contableParametroContaDetalle;
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
		
		
		this.setMostraridParametroContaDetalle(esInicial);
		this.setMostrarid_parametro_contaParametroContaDetalle(esInicial);
		this.setMostrarid_tipo_parametro_contaParametroContaDetalle(esInicial);
		this.setMostrarid_cuenta_contableParametroContaDetalle(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroContaDetalleConstantesFunciones.ID)) {
				this.setMostraridParametroContaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaDetalleConstantesFunciones.IDPARAMETROCONTA)) {
				this.setMostrarid_parametro_contaParametroContaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaDetalleConstantesFunciones.IDTIPOPARAMETROCONTA)) {
				this.setMostrarid_tipo_parametro_contaParametroContaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaDetalleConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableParametroContaDetalle(esAsigna);
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
		
		
		this.setActivaridParametroContaDetalle(esInicial);
		this.setActivarid_parametro_contaParametroContaDetalle(esInicial);
		this.setActivarid_tipo_parametro_contaParametroContaDetalle(esInicial);
		this.setActivarid_cuenta_contableParametroContaDetalle(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroContaDetalleConstantesFunciones.ID)) {
				this.setActivaridParametroContaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaDetalleConstantesFunciones.IDPARAMETROCONTA)) {
				this.setActivarid_parametro_contaParametroContaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaDetalleConstantesFunciones.IDTIPOPARAMETROCONTA)) {
				this.setActivarid_tipo_parametro_contaParametroContaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaDetalleConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableParametroContaDetalle(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroContaDetalleBeanSwingJInternalFrame parametrocontadetalleBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridParametroContaDetalle(esInicial);
		this.setResaltarid_parametro_contaParametroContaDetalle(esInicial);
		this.setResaltarid_tipo_parametro_contaParametroContaDetalle(esInicial);
		this.setResaltarid_cuenta_contableParametroContaDetalle(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroContaDetalleConstantesFunciones.ID)) {
				this.setResaltaridParametroContaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaDetalleConstantesFunciones.IDPARAMETROCONTA)) {
				this.setResaltarid_parametro_contaParametroContaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaDetalleConstantesFunciones.IDTIPOPARAMETROCONTA)) {
				this.setResaltarid_tipo_parametro_contaParametroContaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaDetalleConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableParametroContaDetalle(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroContaDetalleBeanSwingJInternalFrame parametrocontadetalleBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCuentaContableParametroContaDetalle=true;

	public Boolean getMostrarFK_IdCuentaContableParametroContaDetalle() {
		return this.mostrarFK_IdCuentaContableParametroContaDetalle;
	}

	public void setMostrarFK_IdCuentaContableParametroContaDetalle(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableParametroContaDetalle= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdParametroContaParametroContaDetalle=true;

	public Boolean getMostrarFK_IdParametroContaParametroContaDetalle() {
		return this.mostrarFK_IdParametroContaParametroContaDetalle;
	}

	public void setMostrarFK_IdParametroContaParametroContaDetalle(Boolean visibilidadResaltar) {
		this.mostrarFK_IdParametroContaParametroContaDetalle= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdParametroContaDetalleParametroContaDetalle=true;

	public Boolean getMostrarFK_IdParametroContaDetalleParametroContaDetalle() {
		return this.mostrarFK_IdParametroContaDetalleParametroContaDetalle;
	}

	public void setMostrarFK_IdParametroContaDetalleParametroContaDetalle(Boolean visibilidadResaltar) {
		this.mostrarFK_IdParametroContaDetalleParametroContaDetalle= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCuentaContableParametroContaDetalle=true;

	public Boolean getActivarFK_IdCuentaContableParametroContaDetalle() {
		return this.activarFK_IdCuentaContableParametroContaDetalle;
	}

	public void setActivarFK_IdCuentaContableParametroContaDetalle(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableParametroContaDetalle= habilitarResaltar;
	}

	public Boolean activarFK_IdParametroContaParametroContaDetalle=true;

	public Boolean getActivarFK_IdParametroContaParametroContaDetalle() {
		return this.activarFK_IdParametroContaParametroContaDetalle;
	}

	public void setActivarFK_IdParametroContaParametroContaDetalle(Boolean habilitarResaltar) {
		this.activarFK_IdParametroContaParametroContaDetalle= habilitarResaltar;
	}

	public Boolean activarFK_IdParametroContaDetalleParametroContaDetalle=true;

	public Boolean getActivarFK_IdParametroContaDetalleParametroContaDetalle() {
		return this.activarFK_IdParametroContaDetalleParametroContaDetalle;
	}

	public void setActivarFK_IdParametroContaDetalleParametroContaDetalle(Boolean habilitarResaltar) {
		this.activarFK_IdParametroContaDetalleParametroContaDetalle= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCuentaContableParametroContaDetalle=null;

	public Border getResaltarFK_IdCuentaContableParametroContaDetalle() {
		return this.resaltarFK_IdCuentaContableParametroContaDetalle;
	}

	public void setResaltarFK_IdCuentaContableParametroContaDetalle(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableParametroContaDetalle= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableParametroContaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaDetalleBeanSwingJInternalFrame parametrocontadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableParametroContaDetalle= borderResaltar;
	}

	public Border resaltarFK_IdParametroContaParametroContaDetalle=null;

	public Border getResaltarFK_IdParametroContaParametroContaDetalle() {
		return this.resaltarFK_IdParametroContaParametroContaDetalle;
	}

	public void setResaltarFK_IdParametroContaParametroContaDetalle(Border borderResaltar) {
		this.resaltarFK_IdParametroContaParametroContaDetalle= borderResaltar;
	}

	public void setResaltarFK_IdParametroContaParametroContaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaDetalleBeanSwingJInternalFrame parametrocontadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdParametroContaParametroContaDetalle= borderResaltar;
	}

	public Border resaltarFK_IdParametroContaDetalleParametroContaDetalle=null;

	public Border getResaltarFK_IdParametroContaDetalleParametroContaDetalle() {
		return this.resaltarFK_IdParametroContaDetalleParametroContaDetalle;
	}

	public void setResaltarFK_IdParametroContaDetalleParametroContaDetalle(Border borderResaltar) {
		this.resaltarFK_IdParametroContaDetalleParametroContaDetalle= borderResaltar;
	}

	public void setResaltarFK_IdParametroContaDetalleParametroContaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaDetalleBeanSwingJInternalFrame parametrocontadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdParametroContaDetalleParametroContaDetalle= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}