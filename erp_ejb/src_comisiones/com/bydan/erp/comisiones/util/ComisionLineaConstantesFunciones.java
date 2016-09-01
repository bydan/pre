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
package com.bydan.erp.comisiones.util;

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


import com.bydan.erp.comisiones.util.ComisionLineaConstantesFunciones;
import com.bydan.erp.comisiones.util.ComisionLineaParameterReturnGeneral;
//import com.bydan.erp.comisiones.util.ComisionLineaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.comisiones.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.comisiones.business.dataaccess.*;
//import com.bydan.erp.comisiones.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ComisionLineaConstantesFunciones extends ComisionLineaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ComisionLinea";
	public static final String SPATHOPCION="Comisiones";	
	public static final String SPATHMODULO="comisiones/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ComisionLinea"+ComisionLineaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ComisionLineaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ComisionLineaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ComisionLineaConstantesFunciones.SCHEMA+"_"+ComisionLineaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ComisionLineaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ComisionLineaConstantesFunciones.SCHEMA+"_"+ComisionLineaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ComisionLineaConstantesFunciones.SCHEMA+"_"+ComisionLineaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ComisionLineaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ComisionLineaConstantesFunciones.SCHEMA+"_"+ComisionLineaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComisionLineaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ComisionLineaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComisionLineaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComisionLineaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ComisionLineaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComisionLineaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ComisionLineaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ComisionLineaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ComisionLineaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ComisionLineaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Comision Lineas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Comision Linea";
	public static final String SCLASSWEBTITULO_LOWER="Comision Linea";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ComisionLinea";
	public static final String OBJECTNAME="comisionlinea";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_COMISIONES;	
	public static final String TABLENAME="comision_linea";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select comisionlinea from "+ComisionLineaConstantesFunciones.SPERSISTENCENAME+" comisionlinea";
	public static String QUERYSELECTNATIVE="select "+ComisionLineaConstantesFunciones.SCHEMA+"."+ComisionLineaConstantesFunciones.TABLENAME+".id,"+ComisionLineaConstantesFunciones.SCHEMA+"."+ComisionLineaConstantesFunciones.TABLENAME+".version_row,"+ComisionLineaConstantesFunciones.SCHEMA+"."+ComisionLineaConstantesFunciones.TABLENAME+".id_empresa,"+ComisionLineaConstantesFunciones.SCHEMA+"."+ComisionLineaConstantesFunciones.TABLENAME+".id_comision_config,"+ComisionLineaConstantesFunciones.SCHEMA+"."+ComisionLineaConstantesFunciones.TABLENAME+".id_vendedor,"+ComisionLineaConstantesFunciones.SCHEMA+"."+ComisionLineaConstantesFunciones.TABLENAME+".id_linea,"+ComisionLineaConstantesFunciones.SCHEMA+"."+ComisionLineaConstantesFunciones.TABLENAME+".id_estado_comision,"+ComisionLineaConstantesFunciones.SCHEMA+"."+ComisionLineaConstantesFunciones.TABLENAME+".porcentaje,"+ComisionLineaConstantesFunciones.SCHEMA+"."+ComisionLineaConstantesFunciones.TABLENAME+".descripcion from "+ComisionLineaConstantesFunciones.SCHEMA+"."+ComisionLineaConstantesFunciones.TABLENAME;//+" as "+ComisionLineaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ComisionLineaConstantesFuncionesAdditional comisionlineaConstantesFuncionesAdditional=null;
	
	public ComisionLineaConstantesFuncionesAdditional getComisionLineaConstantesFuncionesAdditional() {
		return this.comisionlineaConstantesFuncionesAdditional;
	}
	
	public void setComisionLineaConstantesFuncionesAdditional(ComisionLineaConstantesFuncionesAdditional comisionlineaConstantesFuncionesAdditional) {
		try {
			this.comisionlineaConstantesFuncionesAdditional=comisionlineaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDCOMISIONCONFIG= "id_comision_config";
    public static final String IDVENDEDOR= "id_vendedor";
    public static final String IDLINEA= "id_linea";
    public static final String IDESTADOCOMISION= "id_estado_comision";
    public static final String PORCENTAJE= "porcentaje";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDCOMISIONCONFIG= "Configuracion";
		public static final String LABEL_IDCOMISIONCONFIG_LOWER= "Comision Config";
    	public static final String LABEL_IDVENDEDOR= "Vendedor";
		public static final String LABEL_IDVENDEDOR_LOWER= "Vendedor";
    	public static final String LABEL_IDLINEA= "Linea";
		public static final String LABEL_IDLINEA_LOWER= "Linea";
    	public static final String LABEL_IDESTADOCOMISION= "Estado";
		public static final String LABEL_IDESTADOCOMISION_LOWER= "Estado Comision";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getComisionLineaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ComisionLineaConstantesFunciones.IDEMPRESA)) {sLabelColumna=ComisionLineaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ComisionLineaConstantesFunciones.IDCOMISIONCONFIG)) {sLabelColumna=ComisionLineaConstantesFunciones.LABEL_IDCOMISIONCONFIG;}
		if(sNombreColumna.equals(ComisionLineaConstantesFunciones.IDVENDEDOR)) {sLabelColumna=ComisionLineaConstantesFunciones.LABEL_IDVENDEDOR;}
		if(sNombreColumna.equals(ComisionLineaConstantesFunciones.IDLINEA)) {sLabelColumna=ComisionLineaConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(ComisionLineaConstantesFunciones.IDESTADOCOMISION)) {sLabelColumna=ComisionLineaConstantesFunciones.LABEL_IDESTADOCOMISION;}
		if(sNombreColumna.equals(ComisionLineaConstantesFunciones.PORCENTAJE)) {sLabelColumna=ComisionLineaConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(ComisionLineaConstantesFunciones.DESCRIPCION)) {sLabelColumna=ComisionLineaConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
	
	public static String getComisionLineaDescripcion(ComisionLinea comisionlinea) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(comisionlinea !=null/* && comisionlinea.getId()!=0*/) {
			if(comisionlinea.getId()!=null) {
				sDescripcion=comisionlinea.getId().toString();
			}//comisionlineacomisionlinea.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getComisionLineaDescripcionDetallado(ComisionLinea comisionlinea) {
		String sDescripcion="";
			
		sDescripcion+=ComisionLineaConstantesFunciones.ID+"=";
		sDescripcion+=comisionlinea.getId().toString()+",";
		sDescripcion+=ComisionLineaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=comisionlinea.getVersionRow().toString()+",";
		sDescripcion+=ComisionLineaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=comisionlinea.getid_empresa().toString()+",";
		sDescripcion+=ComisionLineaConstantesFunciones.IDCOMISIONCONFIG+"=";
		sDescripcion+=comisionlinea.getid_comision_config().toString()+",";
		sDescripcion+=ComisionLineaConstantesFunciones.IDVENDEDOR+"=";
		sDescripcion+=comisionlinea.getid_vendedor().toString()+",";
		sDescripcion+=ComisionLineaConstantesFunciones.IDLINEA+"=";
		sDescripcion+=comisionlinea.getid_linea().toString()+",";
		sDescripcion+=ComisionLineaConstantesFunciones.IDESTADOCOMISION+"=";
		sDescripcion+=comisionlinea.getid_estado_comision().toString()+",";
		sDescripcion+=ComisionLineaConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=comisionlinea.getporcentaje().toString()+",";
		sDescripcion+=ComisionLineaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=comisionlinea.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setComisionLineaDescripcion(ComisionLinea comisionlinea,String sValor) throws Exception {			
		if(comisionlinea !=null) {
			//comisionlineacomisionlinea.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getComisionConfigDescripcion(ComisionConfig comisionconfig) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(comisionconfig!=null/*&&comisionconfig.getId()>0*/) {
			sDescripcion=ComisionConfigConstantesFunciones.getComisionConfigDescripcion(comisionconfig);
		}

		return sDescripcion;
	}

	public static String getVendedorDescripcion(Vendedor vendedor) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(vendedor!=null/*&&vendedor.getId()>0*/) {
			sDescripcion=VendedorConstantesFunciones.getVendedorDescripcion(vendedor);
		}

		return sDescripcion;
	}

	public static String getLineaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getEstadoComisionDescripcion(EstadoComision estadocomision) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadocomision!=null/*&&estadocomision.getId()>0*/) {
			sDescripcion=EstadoComisionConstantesFunciones.getEstadoComisionDescripcion(estadocomision);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdComisionConfig")) {
			sNombreIndice="Tipo=  Por Configuracion";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoComision")) {
			sNombreIndice="Tipo=  Por Estado";
		} else if(sNombreIndice.equals("FK_IdLinea")) {
			sNombreIndice="Tipo=  Por Linea";
		} else if(sNombreIndice.equals("FK_IdVendedor")) {
			sNombreIndice="Tipo=  Por Vendedor";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdComisionConfig(Long id_comision_config) {
		String sDetalleIndice=" Parametros->";
		if(id_comision_config!=null) {sDetalleIndice+=" Codigo Unico De Configuracion="+id_comision_config.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoComision(Long id_estado_comision) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_comision!=null) {sDetalleIndice+=" Codigo Unico De Estado="+id_estado_comision.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLinea(Long id_linea) {
		String sDetalleIndice=" Parametros->";
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea="+id_linea.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdVendedor(Long id_vendedor) {
		String sDetalleIndice=" Parametros->";
		if(id_vendedor!=null) {sDetalleIndice+=" Codigo Unico De Vendedor="+id_vendedor.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosComisionLinea(ComisionLinea comisionlinea,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		comisionlinea.setdescripcion(comisionlinea.getdescripcion().trim());
	}
	
	public static void quitarEspaciosComisionLineas(List<ComisionLinea> comisionlineas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ComisionLinea comisionlinea: comisionlineas) {
			comisionlinea.setdescripcion(comisionlinea.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresComisionLinea(ComisionLinea comisionlinea,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && comisionlinea.getConCambioAuxiliar()) {
			comisionlinea.setIsDeleted(comisionlinea.getIsDeletedAuxiliar());	
			comisionlinea.setIsNew(comisionlinea.getIsNewAuxiliar());	
			comisionlinea.setIsChanged(comisionlinea.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			comisionlinea.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			comisionlinea.setIsDeletedAuxiliar(false);	
			comisionlinea.setIsNewAuxiliar(false);	
			comisionlinea.setIsChangedAuxiliar(false);
			
			comisionlinea.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresComisionLineas(List<ComisionLinea> comisionlineas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ComisionLinea comisionlinea : comisionlineas) {
			if(conAsignarBase && comisionlinea.getConCambioAuxiliar()) {
				comisionlinea.setIsDeleted(comisionlinea.getIsDeletedAuxiliar());	
				comisionlinea.setIsNew(comisionlinea.getIsNewAuxiliar());	
				comisionlinea.setIsChanged(comisionlinea.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				comisionlinea.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				comisionlinea.setIsDeletedAuxiliar(false);	
				comisionlinea.setIsNewAuxiliar(false);	
				comisionlinea.setIsChangedAuxiliar(false);
				
				comisionlinea.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresComisionLinea(ComisionLinea comisionlinea,Boolean conEnteros) throws Exception  {
		comisionlinea.setporcentaje(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresComisionLineas(List<ComisionLinea> comisionlineas,Boolean conEnteros) throws Exception  {
		
		for(ComisionLinea comisionlinea: comisionlineas) {
			comisionlinea.setporcentaje(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaComisionLinea(List<ComisionLinea> comisionlineas,ComisionLinea comisionlineaAux) throws Exception  {
		ComisionLineaConstantesFunciones.InicializarValoresComisionLinea(comisionlineaAux,true);
		
		for(ComisionLinea comisionlinea: comisionlineas) {
			if(comisionlinea.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			comisionlineaAux.setporcentaje(comisionlineaAux.getporcentaje()+comisionlinea.getporcentaje());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesComisionLinea(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ComisionLineaConstantesFunciones.getArrayColumnasGlobalesComisionLinea(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesComisionLinea(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ComisionLineaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ComisionLineaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoComisionLinea(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ComisionLinea> comisionlineas,ComisionLinea comisionlinea,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ComisionLinea comisionlineaAux: comisionlineas) {
			if(comisionlineaAux!=null && comisionlinea!=null) {
				if((comisionlineaAux.getId()==null && comisionlinea.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(comisionlineaAux.getId()!=null && comisionlinea.getId()!=null){
					if(comisionlineaAux.getId().equals(comisionlinea.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaComisionLinea(List<ComisionLinea> comisionlineas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
	
		for(ComisionLinea comisionlinea: comisionlineas) {			
			if(comisionlinea.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=comisionlinea.getporcentaje();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComisionLineaConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(ComisionLineaConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaComisionLinea() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ComisionLineaConstantesFunciones.LABEL_ID, ComisionLineaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionLineaConstantesFunciones.LABEL_VERSIONROW, ComisionLineaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionLineaConstantesFunciones.LABEL_IDEMPRESA, ComisionLineaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionLineaConstantesFunciones.LABEL_IDCOMISIONCONFIG, ComisionLineaConstantesFunciones.IDCOMISIONCONFIG,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionLineaConstantesFunciones.LABEL_IDVENDEDOR, ComisionLineaConstantesFunciones.IDVENDEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionLineaConstantesFunciones.LABEL_IDLINEA, ComisionLineaConstantesFunciones.IDLINEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionLineaConstantesFunciones.LABEL_IDESTADOCOMISION, ComisionLineaConstantesFunciones.IDESTADOCOMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionLineaConstantesFunciones.LABEL_PORCENTAJE, ComisionLineaConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionLineaConstantesFunciones.LABEL_DESCRIPCION, ComisionLineaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasComisionLinea() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ComisionLineaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionLineaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionLineaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionLineaConstantesFunciones.IDCOMISIONCONFIG;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionLineaConstantesFunciones.IDVENDEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionLineaConstantesFunciones.IDLINEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionLineaConstantesFunciones.IDESTADOCOMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionLineaConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionLineaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComisionLinea() throws Exception  {
		return ComisionLineaConstantesFunciones.getTiposSeleccionarComisionLinea(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComisionLinea(Boolean conFk) throws Exception  {
		return ComisionLineaConstantesFunciones.getTiposSeleccionarComisionLinea(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComisionLinea(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionLineaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ComisionLineaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionLineaConstantesFunciones.LABEL_IDCOMISIONCONFIG);
			reporte.setsDescripcion(ComisionLineaConstantesFunciones.LABEL_IDCOMISIONCONFIG);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionLineaConstantesFunciones.LABEL_IDVENDEDOR);
			reporte.setsDescripcion(ComisionLineaConstantesFunciones.LABEL_IDVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionLineaConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(ComisionLineaConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionLineaConstantesFunciones.LABEL_IDESTADOCOMISION);
			reporte.setsDescripcion(ComisionLineaConstantesFunciones.LABEL_IDESTADOCOMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionLineaConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(ComisionLineaConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionLineaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ComisionLineaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesComisionLinea(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesComisionLinea(ComisionLinea comisionlineaAux) throws Exception {
		
			comisionlineaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(comisionlineaAux.getEmpresa()));
			comisionlineaAux.setcomisionconfig_descripcion(ComisionConfigConstantesFunciones.getComisionConfigDescripcion(comisionlineaAux.getComisionConfig()));
			comisionlineaAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(comisionlineaAux.getVendedor()));
			comisionlineaAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(comisionlineaAux.getLinea()));
			comisionlineaAux.setestadocomision_descripcion(EstadoComisionConstantesFunciones.getEstadoComisionDescripcion(comisionlineaAux.getEstadoComision()));		
	}
	
	public static void refrescarForeignKeysDescripcionesComisionLinea(List<ComisionLinea> comisionlineasTemp) throws Exception {
		for(ComisionLinea comisionlineaAux:comisionlineasTemp) {
			
			comisionlineaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(comisionlineaAux.getEmpresa()));
			comisionlineaAux.setcomisionconfig_descripcion(ComisionConfigConstantesFunciones.getComisionConfigDescripcion(comisionlineaAux.getComisionConfig()));
			comisionlineaAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(comisionlineaAux.getVendedor()));
			comisionlineaAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(comisionlineaAux.getLinea()));
			comisionlineaAux.setestadocomision_descripcion(EstadoComisionConstantesFunciones.getEstadoComisionDescripcion(comisionlineaAux.getEstadoComision()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfComisionLinea(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(ComisionConfig.class));
				classes.add(new Classe(Vendedor.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(EstadoComision.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ComisionConfig.class)) {
						classes.add(new Classe(ComisionConfig.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Vendedor.class)) {
						classes.add(new Classe(Vendedor.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoComision.class)) {
						classes.add(new Classe(EstadoComision.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfComisionLinea(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(ComisionConfig.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionConfig.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(EstadoComision.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoComision.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(ComisionConfig.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionConfig.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(EstadoComision.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoComision.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfComisionLinea(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ComisionLineaConstantesFunciones.getClassesRelationshipsOfComisionLinea(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfComisionLinea(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfComisionLinea(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ComisionLineaConstantesFunciones.getClassesRelationshipsFromStringsOfComisionLinea(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfComisionLinea(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ComisionLinea comisionlinea,List<ComisionLinea> comisionlineas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ComisionLinea comisionlineaEncontrado=null;
			
			for(ComisionLinea comisionlineaLocal:comisionlineas) {
				if(comisionlineaLocal.getId().equals(comisionlinea.getId())) {
					comisionlineaEncontrado=comisionlineaLocal;
					
					comisionlineaLocal.setIsChanged(comisionlinea.getIsChanged());
					comisionlineaLocal.setIsNew(comisionlinea.getIsNew());
					comisionlineaLocal.setIsDeleted(comisionlinea.getIsDeleted());
					
					comisionlineaLocal.setGeneralEntityOriginal(comisionlinea.getGeneralEntityOriginal());
					
					comisionlineaLocal.setId(comisionlinea.getId());	
					comisionlineaLocal.setVersionRow(comisionlinea.getVersionRow());	
					comisionlineaLocal.setid_empresa(comisionlinea.getid_empresa());	
					comisionlineaLocal.setid_comision_config(comisionlinea.getid_comision_config());	
					comisionlineaLocal.setid_vendedor(comisionlinea.getid_vendedor());	
					comisionlineaLocal.setid_linea(comisionlinea.getid_linea());	
					comisionlineaLocal.setid_estado_comision(comisionlinea.getid_estado_comision());	
					comisionlineaLocal.setporcentaje(comisionlinea.getporcentaje());	
					comisionlineaLocal.setdescripcion(comisionlinea.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!comisionlinea.getIsDeleted()) {
				if(!existe) {
					comisionlineas.add(comisionlinea);
				}
			} else {
				if(comisionlineaEncontrado!=null && permiteQuitar)  {
					comisionlineas.remove(comisionlineaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ComisionLinea comisionlinea,List<ComisionLinea> comisionlineas) throws Exception {
		try	{			
			for(ComisionLinea comisionlineaLocal:comisionlineas) {
				if(comisionlineaLocal.getId().equals(comisionlinea.getId())) {
					comisionlineaLocal.setIsSelected(comisionlinea.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesComisionLinea(List<ComisionLinea> comisionlineasAux) throws Exception {
		//this.comisionlineasAux=comisionlineasAux;
		
		for(ComisionLinea comisionlineaAux:comisionlineasAux) {
			if(comisionlineaAux.getIsChanged()) {
				comisionlineaAux.setIsChanged(false);
			}		
			
			if(comisionlineaAux.getIsNew()) {
				comisionlineaAux.setIsNew(false);
			}	
			
			if(comisionlineaAux.getIsDeleted()) {
				comisionlineaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesComisionLinea(ComisionLinea comisionlineaAux) throws Exception {
		//this.comisionlineaAux=comisionlineaAux;
		
			if(comisionlineaAux.getIsChanged()) {
				comisionlineaAux.setIsChanged(false);
			}		
			
			if(comisionlineaAux.getIsNew()) {
				comisionlineaAux.setIsNew(false);
			}	
			
			if(comisionlineaAux.getIsDeleted()) {
				comisionlineaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ComisionLinea comisionlineaAsignar,ComisionLinea comisionlinea) throws Exception {
		comisionlineaAsignar.setId(comisionlinea.getId());	
		comisionlineaAsignar.setVersionRow(comisionlinea.getVersionRow());	
		comisionlineaAsignar.setid_empresa(comisionlinea.getid_empresa());
		comisionlineaAsignar.setempresa_descripcion(comisionlinea.getempresa_descripcion());	
		comisionlineaAsignar.setid_comision_config(comisionlinea.getid_comision_config());
		comisionlineaAsignar.setcomisionconfig_descripcion(comisionlinea.getcomisionconfig_descripcion());	
		comisionlineaAsignar.setid_vendedor(comisionlinea.getid_vendedor());
		comisionlineaAsignar.setvendedor_descripcion(comisionlinea.getvendedor_descripcion());	
		comisionlineaAsignar.setid_linea(comisionlinea.getid_linea());
		comisionlineaAsignar.setlinea_descripcion(comisionlinea.getlinea_descripcion());	
		comisionlineaAsignar.setid_estado_comision(comisionlinea.getid_estado_comision());
		comisionlineaAsignar.setestadocomision_descripcion(comisionlinea.getestadocomision_descripcion());	
		comisionlineaAsignar.setporcentaje(comisionlinea.getporcentaje());	
		comisionlineaAsignar.setdescripcion(comisionlinea.getdescripcion());	
	}
	
	public static void inicializarComisionLinea(ComisionLinea comisionlinea) throws Exception {
		try {
				comisionlinea.setId(0L);	
					
				comisionlinea.setid_empresa(-1L);	
				comisionlinea.setid_comision_config(-1L);	
				comisionlinea.setid_vendedor(-1L);	
				comisionlinea.setid_linea(-1L);	
				comisionlinea.setid_estado_comision(-1L);	
				comisionlinea.setporcentaje(0.0);	
				comisionlinea.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderComisionLinea(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionLineaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionLineaConstantesFunciones.LABEL_IDCOMISIONCONFIG);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionLineaConstantesFunciones.LABEL_IDVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionLineaConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionLineaConstantesFunciones.LABEL_IDESTADOCOMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionLineaConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionLineaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataComisionLinea(String sTipo,Row row,Workbook workbook,ComisionLinea comisionlinea,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionlinea.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionlinea.getcomisionconfig_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionlinea.getvendedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionlinea.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionlinea.getestadocomision_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionlinea.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionlinea.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryComisionLinea=Constantes.SFINALQUERY;
	
	public String getsFinalQueryComisionLinea() {
		return this.sFinalQueryComisionLinea;
	}
	
	public void setsFinalQueryComisionLinea(String sFinalQueryComisionLinea) {
		this.sFinalQueryComisionLinea= sFinalQueryComisionLinea;
	}
	
	public Border resaltarSeleccionarComisionLinea=null;
	
	public Border setResaltarSeleccionarComisionLinea(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionLineaBeanSwingJInternalFrame comisionlineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//comisionlineaBeanSwingJInternalFrame.jTtoolBarComisionLinea.setBorder(borderResaltar);
		
		this.resaltarSeleccionarComisionLinea= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarComisionLinea() {
		return this.resaltarSeleccionarComisionLinea;
	}
	
	public void setResaltarSeleccionarComisionLinea(Border borderResaltarSeleccionarComisionLinea) {
		this.resaltarSeleccionarComisionLinea= borderResaltarSeleccionarComisionLinea;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridComisionLinea=null;
	public Boolean mostraridComisionLinea=true;
	public Boolean activaridComisionLinea=true;

	public Border resaltarid_empresaComisionLinea=null;
	public Boolean mostrarid_empresaComisionLinea=true;
	public Boolean activarid_empresaComisionLinea=true;
	public Boolean cargarid_empresaComisionLinea=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaComisionLinea=false;//ConEventDepend=true

	public Border resaltarid_comision_configComisionLinea=null;
	public Boolean mostrarid_comision_configComisionLinea=true;
	public Boolean activarid_comision_configComisionLinea=true;
	public Boolean cargarid_comision_configComisionLinea=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_comision_configComisionLinea=false;//ConEventDepend=true

	public Border resaltarid_vendedorComisionLinea=null;
	public Boolean mostrarid_vendedorComisionLinea=true;
	public Boolean activarid_vendedorComisionLinea=true;
	public Boolean cargarid_vendedorComisionLinea=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_vendedorComisionLinea=false;//ConEventDepend=true

	public Border resaltarid_lineaComisionLinea=null;
	public Boolean mostrarid_lineaComisionLinea=true;
	public Boolean activarid_lineaComisionLinea=true;
	public Boolean cargarid_lineaComisionLinea=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaComisionLinea=false;//ConEventDepend=true

	public Border resaltarid_estado_comisionComisionLinea=null;
	public Boolean mostrarid_estado_comisionComisionLinea=true;
	public Boolean activarid_estado_comisionComisionLinea=true;
	public Boolean cargarid_estado_comisionComisionLinea=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_comisionComisionLinea=false;//ConEventDepend=true

	public Border resaltarporcentajeComisionLinea=null;
	public Boolean mostrarporcentajeComisionLinea=true;
	public Boolean activarporcentajeComisionLinea=true;

	public Border resaltardescripcionComisionLinea=null;
	public Boolean mostrardescripcionComisionLinea=true;
	public Boolean activardescripcionComisionLinea=true;

	
	

	public Border setResaltaridComisionLinea(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionLineaBeanSwingJInternalFrame comisionlineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionlineaBeanSwingJInternalFrame.jTtoolBarComisionLinea.setBorder(borderResaltar);
		
		this.resaltaridComisionLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridComisionLinea() {
		return this.resaltaridComisionLinea;
	}

	public void setResaltaridComisionLinea(Border borderResaltar) {
		this.resaltaridComisionLinea= borderResaltar;
	}

	public Boolean getMostraridComisionLinea() {
		return this.mostraridComisionLinea;
	}

	public void setMostraridComisionLinea(Boolean mostraridComisionLinea) {
		this.mostraridComisionLinea= mostraridComisionLinea;
	}

	public Boolean getActivaridComisionLinea() {
		return this.activaridComisionLinea;
	}

	public void setActivaridComisionLinea(Boolean activaridComisionLinea) {
		this.activaridComisionLinea= activaridComisionLinea;
	}

	public Border setResaltarid_empresaComisionLinea(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionLineaBeanSwingJInternalFrame comisionlineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionlineaBeanSwingJInternalFrame.jTtoolBarComisionLinea.setBorder(borderResaltar);
		
		this.resaltarid_empresaComisionLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaComisionLinea() {
		return this.resaltarid_empresaComisionLinea;
	}

	public void setResaltarid_empresaComisionLinea(Border borderResaltar) {
		this.resaltarid_empresaComisionLinea= borderResaltar;
	}

	public Boolean getMostrarid_empresaComisionLinea() {
		return this.mostrarid_empresaComisionLinea;
	}

	public void setMostrarid_empresaComisionLinea(Boolean mostrarid_empresaComisionLinea) {
		this.mostrarid_empresaComisionLinea= mostrarid_empresaComisionLinea;
	}

	public Boolean getActivarid_empresaComisionLinea() {
		return this.activarid_empresaComisionLinea;
	}

	public void setActivarid_empresaComisionLinea(Boolean activarid_empresaComisionLinea) {
		this.activarid_empresaComisionLinea= activarid_empresaComisionLinea;
	}

	public Boolean getCargarid_empresaComisionLinea() {
		return this.cargarid_empresaComisionLinea;
	}

	public void setCargarid_empresaComisionLinea(Boolean cargarid_empresaComisionLinea) {
		this.cargarid_empresaComisionLinea= cargarid_empresaComisionLinea;
	}

	public Border setResaltarid_comision_configComisionLinea(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionLineaBeanSwingJInternalFrame comisionlineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionlineaBeanSwingJInternalFrame.jTtoolBarComisionLinea.setBorder(borderResaltar);
		
		this.resaltarid_comision_configComisionLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_comision_configComisionLinea() {
		return this.resaltarid_comision_configComisionLinea;
	}

	public void setResaltarid_comision_configComisionLinea(Border borderResaltar) {
		this.resaltarid_comision_configComisionLinea= borderResaltar;
	}

	public Boolean getMostrarid_comision_configComisionLinea() {
		return this.mostrarid_comision_configComisionLinea;
	}

	public void setMostrarid_comision_configComisionLinea(Boolean mostrarid_comision_configComisionLinea) {
		this.mostrarid_comision_configComisionLinea= mostrarid_comision_configComisionLinea;
	}

	public Boolean getActivarid_comision_configComisionLinea() {
		return this.activarid_comision_configComisionLinea;
	}

	public void setActivarid_comision_configComisionLinea(Boolean activarid_comision_configComisionLinea) {
		this.activarid_comision_configComisionLinea= activarid_comision_configComisionLinea;
	}

	public Boolean getCargarid_comision_configComisionLinea() {
		return this.cargarid_comision_configComisionLinea;
	}

	public void setCargarid_comision_configComisionLinea(Boolean cargarid_comision_configComisionLinea) {
		this.cargarid_comision_configComisionLinea= cargarid_comision_configComisionLinea;
	}

	public Border setResaltarid_vendedorComisionLinea(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionLineaBeanSwingJInternalFrame comisionlineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionlineaBeanSwingJInternalFrame.jTtoolBarComisionLinea.setBorder(borderResaltar);
		
		this.resaltarid_vendedorComisionLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_vendedorComisionLinea() {
		return this.resaltarid_vendedorComisionLinea;
	}

	public void setResaltarid_vendedorComisionLinea(Border borderResaltar) {
		this.resaltarid_vendedorComisionLinea= borderResaltar;
	}

	public Boolean getMostrarid_vendedorComisionLinea() {
		return this.mostrarid_vendedorComisionLinea;
	}

	public void setMostrarid_vendedorComisionLinea(Boolean mostrarid_vendedorComisionLinea) {
		this.mostrarid_vendedorComisionLinea= mostrarid_vendedorComisionLinea;
	}

	public Boolean getActivarid_vendedorComisionLinea() {
		return this.activarid_vendedorComisionLinea;
	}

	public void setActivarid_vendedorComisionLinea(Boolean activarid_vendedorComisionLinea) {
		this.activarid_vendedorComisionLinea= activarid_vendedorComisionLinea;
	}

	public Boolean getCargarid_vendedorComisionLinea() {
		return this.cargarid_vendedorComisionLinea;
	}

	public void setCargarid_vendedorComisionLinea(Boolean cargarid_vendedorComisionLinea) {
		this.cargarid_vendedorComisionLinea= cargarid_vendedorComisionLinea;
	}

	public Border setResaltarid_lineaComisionLinea(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionLineaBeanSwingJInternalFrame comisionlineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionlineaBeanSwingJInternalFrame.jTtoolBarComisionLinea.setBorder(borderResaltar);
		
		this.resaltarid_lineaComisionLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaComisionLinea() {
		return this.resaltarid_lineaComisionLinea;
	}

	public void setResaltarid_lineaComisionLinea(Border borderResaltar) {
		this.resaltarid_lineaComisionLinea= borderResaltar;
	}

	public Boolean getMostrarid_lineaComisionLinea() {
		return this.mostrarid_lineaComisionLinea;
	}

	public void setMostrarid_lineaComisionLinea(Boolean mostrarid_lineaComisionLinea) {
		this.mostrarid_lineaComisionLinea= mostrarid_lineaComisionLinea;
	}

	public Boolean getActivarid_lineaComisionLinea() {
		return this.activarid_lineaComisionLinea;
	}

	public void setActivarid_lineaComisionLinea(Boolean activarid_lineaComisionLinea) {
		this.activarid_lineaComisionLinea= activarid_lineaComisionLinea;
	}

	public Boolean getCargarid_lineaComisionLinea() {
		return this.cargarid_lineaComisionLinea;
	}

	public void setCargarid_lineaComisionLinea(Boolean cargarid_lineaComisionLinea) {
		this.cargarid_lineaComisionLinea= cargarid_lineaComisionLinea;
	}

	public Border setResaltarid_estado_comisionComisionLinea(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionLineaBeanSwingJInternalFrame comisionlineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionlineaBeanSwingJInternalFrame.jTtoolBarComisionLinea.setBorder(borderResaltar);
		
		this.resaltarid_estado_comisionComisionLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_comisionComisionLinea() {
		return this.resaltarid_estado_comisionComisionLinea;
	}

	public void setResaltarid_estado_comisionComisionLinea(Border borderResaltar) {
		this.resaltarid_estado_comisionComisionLinea= borderResaltar;
	}

	public Boolean getMostrarid_estado_comisionComisionLinea() {
		return this.mostrarid_estado_comisionComisionLinea;
	}

	public void setMostrarid_estado_comisionComisionLinea(Boolean mostrarid_estado_comisionComisionLinea) {
		this.mostrarid_estado_comisionComisionLinea= mostrarid_estado_comisionComisionLinea;
	}

	public Boolean getActivarid_estado_comisionComisionLinea() {
		return this.activarid_estado_comisionComisionLinea;
	}

	public void setActivarid_estado_comisionComisionLinea(Boolean activarid_estado_comisionComisionLinea) {
		this.activarid_estado_comisionComisionLinea= activarid_estado_comisionComisionLinea;
	}

	public Boolean getCargarid_estado_comisionComisionLinea() {
		return this.cargarid_estado_comisionComisionLinea;
	}

	public void setCargarid_estado_comisionComisionLinea(Boolean cargarid_estado_comisionComisionLinea) {
		this.cargarid_estado_comisionComisionLinea= cargarid_estado_comisionComisionLinea;
	}

	public Border setResaltarporcentajeComisionLinea(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionLineaBeanSwingJInternalFrame comisionlineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionlineaBeanSwingJInternalFrame.jTtoolBarComisionLinea.setBorder(borderResaltar);
		
		this.resaltarporcentajeComisionLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeComisionLinea() {
		return this.resaltarporcentajeComisionLinea;
	}

	public void setResaltarporcentajeComisionLinea(Border borderResaltar) {
		this.resaltarporcentajeComisionLinea= borderResaltar;
	}

	public Boolean getMostrarporcentajeComisionLinea() {
		return this.mostrarporcentajeComisionLinea;
	}

	public void setMostrarporcentajeComisionLinea(Boolean mostrarporcentajeComisionLinea) {
		this.mostrarporcentajeComisionLinea= mostrarporcentajeComisionLinea;
	}

	public Boolean getActivarporcentajeComisionLinea() {
		return this.activarporcentajeComisionLinea;
	}

	public void setActivarporcentajeComisionLinea(Boolean activarporcentajeComisionLinea) {
		this.activarporcentajeComisionLinea= activarporcentajeComisionLinea;
	}

	public Border setResaltardescripcionComisionLinea(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionLineaBeanSwingJInternalFrame comisionlineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionlineaBeanSwingJInternalFrame.jTtoolBarComisionLinea.setBorder(borderResaltar);
		
		this.resaltardescripcionComisionLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionComisionLinea() {
		return this.resaltardescripcionComisionLinea;
	}

	public void setResaltardescripcionComisionLinea(Border borderResaltar) {
		this.resaltardescripcionComisionLinea= borderResaltar;
	}

	public Boolean getMostrardescripcionComisionLinea() {
		return this.mostrardescripcionComisionLinea;
	}

	public void setMostrardescripcionComisionLinea(Boolean mostrardescripcionComisionLinea) {
		this.mostrardescripcionComisionLinea= mostrardescripcionComisionLinea;
	}

	public Boolean getActivardescripcionComisionLinea() {
		return this.activardescripcionComisionLinea;
	}

	public void setActivardescripcionComisionLinea(Boolean activardescripcionComisionLinea) {
		this.activardescripcionComisionLinea= activardescripcionComisionLinea;
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
		
		
		this.setMostraridComisionLinea(esInicial);
		this.setMostrarid_empresaComisionLinea(esInicial);
		this.setMostrarid_comision_configComisionLinea(esInicial);
		this.setMostrarid_vendedorComisionLinea(esInicial);
		this.setMostrarid_lineaComisionLinea(esInicial);
		this.setMostrarid_estado_comisionComisionLinea(esInicial);
		this.setMostrarporcentajeComisionLinea(esInicial);
		this.setMostrardescripcionComisionLinea(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComisionLineaConstantesFunciones.ID)) {
				this.setMostraridComisionLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionLineaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaComisionLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionLineaConstantesFunciones.IDCOMISIONCONFIG)) {
				this.setMostrarid_comision_configComisionLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionLineaConstantesFunciones.IDVENDEDOR)) {
				this.setMostrarid_vendedorComisionLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionLineaConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaComisionLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionLineaConstantesFunciones.IDESTADOCOMISION)) {
				this.setMostrarid_estado_comisionComisionLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionLineaConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeComisionLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionLineaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionComisionLinea(esAsigna);
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
		
		
		this.setActivaridComisionLinea(esInicial);
		this.setActivarid_empresaComisionLinea(esInicial);
		this.setActivarid_comision_configComisionLinea(esInicial);
		this.setActivarid_vendedorComisionLinea(esInicial);
		this.setActivarid_lineaComisionLinea(esInicial);
		this.setActivarid_estado_comisionComisionLinea(esInicial);
		this.setActivarporcentajeComisionLinea(esInicial);
		this.setActivardescripcionComisionLinea(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComisionLineaConstantesFunciones.ID)) {
				this.setActivaridComisionLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionLineaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaComisionLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionLineaConstantesFunciones.IDCOMISIONCONFIG)) {
				this.setActivarid_comision_configComisionLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionLineaConstantesFunciones.IDVENDEDOR)) {
				this.setActivarid_vendedorComisionLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionLineaConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaComisionLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionLineaConstantesFunciones.IDESTADOCOMISION)) {
				this.setActivarid_estado_comisionComisionLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionLineaConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeComisionLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionLineaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionComisionLinea(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ComisionLineaBeanSwingJInternalFrame comisionlineaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridComisionLinea(esInicial);
		this.setResaltarid_empresaComisionLinea(esInicial);
		this.setResaltarid_comision_configComisionLinea(esInicial);
		this.setResaltarid_vendedorComisionLinea(esInicial);
		this.setResaltarid_lineaComisionLinea(esInicial);
		this.setResaltarid_estado_comisionComisionLinea(esInicial);
		this.setResaltarporcentajeComisionLinea(esInicial);
		this.setResaltardescripcionComisionLinea(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComisionLineaConstantesFunciones.ID)) {
				this.setResaltaridComisionLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionLineaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaComisionLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionLineaConstantesFunciones.IDCOMISIONCONFIG)) {
				this.setResaltarid_comision_configComisionLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionLineaConstantesFunciones.IDVENDEDOR)) {
				this.setResaltarid_vendedorComisionLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionLineaConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaComisionLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionLineaConstantesFunciones.IDESTADOCOMISION)) {
				this.setResaltarid_estado_comisionComisionLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionLineaConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeComisionLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionLineaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionComisionLinea(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ComisionLineaBeanSwingJInternalFrame comisionlineaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdComisionConfigComisionLinea=true;

	public Boolean getMostrarFK_IdComisionConfigComisionLinea() {
		return this.mostrarFK_IdComisionConfigComisionLinea;
	}

	public void setMostrarFK_IdComisionConfigComisionLinea(Boolean visibilidadResaltar) {
		this.mostrarFK_IdComisionConfigComisionLinea= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaComisionLinea=true;

	public Boolean getMostrarFK_IdEmpresaComisionLinea() {
		return this.mostrarFK_IdEmpresaComisionLinea;
	}

	public void setMostrarFK_IdEmpresaComisionLinea(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaComisionLinea= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdComisionConfigComisionLinea=true;

	public Boolean getActivarFK_IdComisionConfigComisionLinea() {
		return this.activarFK_IdComisionConfigComisionLinea;
	}

	public void setActivarFK_IdComisionConfigComisionLinea(Boolean habilitarResaltar) {
		this.activarFK_IdComisionConfigComisionLinea= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaComisionLinea=true;

	public Boolean getActivarFK_IdEmpresaComisionLinea() {
		return this.activarFK_IdEmpresaComisionLinea;
	}

	public void setActivarFK_IdEmpresaComisionLinea(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaComisionLinea= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdComisionConfigComisionLinea=null;

	public Border getResaltarFK_IdComisionConfigComisionLinea() {
		return this.resaltarFK_IdComisionConfigComisionLinea;
	}

	public void setResaltarFK_IdComisionConfigComisionLinea(Border borderResaltar) {
		this.resaltarFK_IdComisionConfigComisionLinea= borderResaltar;
	}

	public void setResaltarFK_IdComisionConfigComisionLinea(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionLineaBeanSwingJInternalFrame comisionlineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdComisionConfigComisionLinea= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaComisionLinea=null;

	public Border getResaltarFK_IdEmpresaComisionLinea() {
		return this.resaltarFK_IdEmpresaComisionLinea;
	}

	public void setResaltarFK_IdEmpresaComisionLinea(Border borderResaltar) {
		this.resaltarFK_IdEmpresaComisionLinea= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaComisionLinea(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionLineaBeanSwingJInternalFrame comisionlineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaComisionLinea= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}