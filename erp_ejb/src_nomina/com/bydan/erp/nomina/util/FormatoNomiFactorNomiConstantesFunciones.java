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
package com.bydan.erp.nomina.util;

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


import com.bydan.erp.nomina.util.FormatoNomiFactorNomiConstantesFunciones;
import com.bydan.erp.nomina.util.FormatoNomiFactorNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.FormatoNomiFactorNomiParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class FormatoNomiFactorNomiConstantesFunciones extends FormatoNomiFactorNomiConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="FormatoNomiFactorNomi";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="FormatoNomiFactorNomi"+FormatoNomiFactorNomiConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="FormatoNomiFactorNomiHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="FormatoNomiFactorNomiHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=FormatoNomiFactorNomiConstantesFunciones.SCHEMA+"_"+FormatoNomiFactorNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/FormatoNomiFactorNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=FormatoNomiFactorNomiConstantesFunciones.SCHEMA+"_"+FormatoNomiFactorNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=FormatoNomiFactorNomiConstantesFunciones.SCHEMA+"_"+FormatoNomiFactorNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/FormatoNomiFactorNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=FormatoNomiFactorNomiConstantesFunciones.SCHEMA+"_"+FormatoNomiFactorNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormatoNomiFactorNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FormatoNomiFactorNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormatoNomiFactorNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormatoNomiFactorNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FormatoNomiFactorNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormatoNomiFactorNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=FormatoNomiFactorNomiConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+FormatoNomiFactorNomiConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=FormatoNomiFactorNomiConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+FormatoNomiFactorNomiConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Formato Nomi Factor Nomis";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Formato Nomi Factor Nomi";
	public static final String SCLASSWEBTITULO_LOWER="Formato Nomi Factor Nomi";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="FormatoNomiFactorNomi";
	public static final String OBJECTNAME="formatonomifactornomi";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="formato_nomi_factor_nomi";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select formatonomifactornomi from "+FormatoNomiFactorNomiConstantesFunciones.SPERSISTENCENAME+" formatonomifactornomi";
	public static String QUERYSELECTNATIVE="select "+FormatoNomiFactorNomiConstantesFunciones.SCHEMA+"."+FormatoNomiFactorNomiConstantesFunciones.TABLENAME+".id,"+FormatoNomiFactorNomiConstantesFunciones.SCHEMA+"."+FormatoNomiFactorNomiConstantesFunciones.TABLENAME+".version_row,"+FormatoNomiFactorNomiConstantesFunciones.SCHEMA+"."+FormatoNomiFactorNomiConstantesFunciones.TABLENAME+".id_empresa,"+FormatoNomiFactorNomiConstantesFunciones.SCHEMA+"."+FormatoNomiFactorNomiConstantesFunciones.TABLENAME+".id_sucursal,"+FormatoNomiFactorNomiConstantesFunciones.SCHEMA+"."+FormatoNomiFactorNomiConstantesFunciones.TABLENAME+".id_formato_nomi,"+FormatoNomiFactorNomiConstantesFunciones.SCHEMA+"."+FormatoNomiFactorNomiConstantesFunciones.TABLENAME+".id_factor_nomi,"+FormatoNomiFactorNomiConstantesFunciones.SCHEMA+"."+FormatoNomiFactorNomiConstantesFunciones.TABLENAME+".ponderacion,"+FormatoNomiFactorNomiConstantesFunciones.SCHEMA+"."+FormatoNomiFactorNomiConstantesFunciones.TABLENAME+".esta_activo from "+FormatoNomiFactorNomiConstantesFunciones.SCHEMA+"."+FormatoNomiFactorNomiConstantesFunciones.TABLENAME;//+" as "+FormatoNomiFactorNomiConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected FormatoNomiFactorNomiConstantesFuncionesAdditional formatonomifactornomiConstantesFuncionesAdditional=null;
	
	public FormatoNomiFactorNomiConstantesFuncionesAdditional getFormatoNomiFactorNomiConstantesFuncionesAdditional() {
		return this.formatonomifactornomiConstantesFuncionesAdditional;
	}
	
	public void setFormatoNomiFactorNomiConstantesFuncionesAdditional(FormatoNomiFactorNomiConstantesFuncionesAdditional formatonomifactornomiConstantesFuncionesAdditional) {
		try {
			this.formatonomifactornomiConstantesFuncionesAdditional=formatonomifactornomiConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDFORMATONOMI= "id_formato_nomi";
    public static final String IDFACTORNOMI= "id_factor_nomi";
    public static final String PONDERACION= "ponderacion";
    public static final String ESTAACTIVO= "esta_activo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDFORMATONOMI= "Formato Nomi";
		public static final String LABEL_IDFORMATONOMI_LOWER= "Formato Nomi";
    	public static final String LABEL_IDFACTORNOMI= "Factor Nomi";
		public static final String LABEL_IDFACTORNOMI_LOWER= "Factor Nomi";
    	public static final String LABEL_PONDERACION= "Ponderacion";
		public static final String LABEL_PONDERACION_LOWER= "Ponderacion";
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "Esta Activo";
	
		
		
		
		
		
		
		
		
	
	public static String getFormatoNomiFactorNomiLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(FormatoNomiFactorNomiConstantesFunciones.IDEMPRESA)) {sLabelColumna=FormatoNomiFactorNomiConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(FormatoNomiFactorNomiConstantesFunciones.IDSUCURSAL)) {sLabelColumna=FormatoNomiFactorNomiConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(FormatoNomiFactorNomiConstantesFunciones.IDFORMATONOMI)) {sLabelColumna=FormatoNomiFactorNomiConstantesFunciones.LABEL_IDFORMATONOMI;}
		if(sNombreColumna.equals(FormatoNomiFactorNomiConstantesFunciones.IDFACTORNOMI)) {sLabelColumna=FormatoNomiFactorNomiConstantesFunciones.LABEL_IDFACTORNOMI;}
		if(sNombreColumna.equals(FormatoNomiFactorNomiConstantesFunciones.PONDERACION)) {sLabelColumna=FormatoNomiFactorNomiConstantesFunciones.LABEL_PONDERACION;}
		if(sNombreColumna.equals(FormatoNomiFactorNomiConstantesFunciones.ESTAACTIVO)) {sLabelColumna=FormatoNomiFactorNomiConstantesFunciones.LABEL_ESTAACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
			
		
	public static String getesta_activoDescripcion(FormatoNomiFactorNomi formatonomifactornomi) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!formatonomifactornomi.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(FormatoNomiFactorNomi formatonomifactornomi) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(formatonomifactornomi.getId(),formatonomifactornomi.getesta_activo());

		return sDescripcion;
	}	
	
	public static String getFormatoNomiFactorNomiDescripcion(FormatoNomiFactorNomi formatonomifactornomi) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(formatonomifactornomi !=null/* && formatonomifactornomi.getId()!=0*/) {
			if(formatonomifactornomi.getId()!=null) {
				sDescripcion=formatonomifactornomi.getId().toString();
			}//formatonomifactornomiformatonomifactornomi.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getFormatoNomiFactorNomiDescripcionDetallado(FormatoNomiFactorNomi formatonomifactornomi) {
		String sDescripcion="";
			
		sDescripcion+=FormatoNomiFactorNomiConstantesFunciones.ID+"=";
		sDescripcion+=formatonomifactornomi.getId().toString()+",";
		sDescripcion+=FormatoNomiFactorNomiConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=formatonomifactornomi.getVersionRow().toString()+",";
		sDescripcion+=FormatoNomiFactorNomiConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=formatonomifactornomi.getid_empresa().toString()+",";
		sDescripcion+=FormatoNomiFactorNomiConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=formatonomifactornomi.getid_sucursal().toString()+",";
		sDescripcion+=FormatoNomiFactorNomiConstantesFunciones.IDFORMATONOMI+"=";
		sDescripcion+=formatonomifactornomi.getid_formato_nomi().toString()+",";
		sDescripcion+=FormatoNomiFactorNomiConstantesFunciones.IDFACTORNOMI+"=";
		sDescripcion+=formatonomifactornomi.getid_factor_nomi().toString()+",";
		sDescripcion+=FormatoNomiFactorNomiConstantesFunciones.PONDERACION+"=";
		sDescripcion+=formatonomifactornomi.getponderacion().toString()+",";
		sDescripcion+=FormatoNomiFactorNomiConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=formatonomifactornomi.getesta_activo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setFormatoNomiFactorNomiDescripcion(FormatoNomiFactorNomi formatonomifactornomi,String sValor) throws Exception {			
		if(formatonomifactornomi !=null) {
			//formatonomifactornomiformatonomifactornomi.getId().toString();
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

	public static String getFormatoNomiDescripcion(FormatoNomi formatonomi) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formatonomi!=null/*&&formatonomi.getId()>0*/) {
			sDescripcion=FormatoNomiConstantesFunciones.getFormatoNomiDescripcion(formatonomi);
		}

		return sDescripcion;
	}

	public static String getFactorNomiDescripcion(FactorNomi factornomi) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(factornomi!=null/*&&factornomi.getId()>0*/) {
			sDescripcion=FactorNomiConstantesFunciones.getFactorNomiDescripcion(factornomi);
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
		} else if(sNombreIndice.equals("FK_IdFactorNomi")) {
			sNombreIndice="Tipo=  Por Factor Nomi";
		} else if(sNombreIndice.equals("FK_IdFormatoNomi")) {
			sNombreIndice="Tipo=  Por Formato Nomi";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
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

	public static String getDetalleIndiceFK_IdFactorNomi(Long id_factor_nomi) {
		String sDetalleIndice=" Parametros->";
		if(id_factor_nomi!=null) {sDetalleIndice+=" Codigo Unico De Factor Nomi="+id_factor_nomi.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormatoNomi(Long id_formato_nomi) {
		String sDetalleIndice=" Parametros->";
		if(id_formato_nomi!=null) {sDetalleIndice+=" Codigo Unico De Formato Nomi="+id_formato_nomi.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosFormatoNomiFactorNomi(FormatoNomiFactorNomi formatonomifactornomi,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosFormatoNomiFactorNomis(List<FormatoNomiFactorNomi> formatonomifactornomis,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(FormatoNomiFactorNomi formatonomifactornomi: formatonomifactornomis) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFormatoNomiFactorNomi(FormatoNomiFactorNomi formatonomifactornomi,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && formatonomifactornomi.getConCambioAuxiliar()) {
			formatonomifactornomi.setIsDeleted(formatonomifactornomi.getIsDeletedAuxiliar());	
			formatonomifactornomi.setIsNew(formatonomifactornomi.getIsNewAuxiliar());	
			formatonomifactornomi.setIsChanged(formatonomifactornomi.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			formatonomifactornomi.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			formatonomifactornomi.setIsDeletedAuxiliar(false);	
			formatonomifactornomi.setIsNewAuxiliar(false);	
			formatonomifactornomi.setIsChangedAuxiliar(false);
			
			formatonomifactornomi.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFormatoNomiFactorNomis(List<FormatoNomiFactorNomi> formatonomifactornomis,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(FormatoNomiFactorNomi formatonomifactornomi : formatonomifactornomis) {
			if(conAsignarBase && formatonomifactornomi.getConCambioAuxiliar()) {
				formatonomifactornomi.setIsDeleted(formatonomifactornomi.getIsDeletedAuxiliar());	
				formatonomifactornomi.setIsNew(formatonomifactornomi.getIsNewAuxiliar());	
				formatonomifactornomi.setIsChanged(formatonomifactornomi.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				formatonomifactornomi.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				formatonomifactornomi.setIsDeletedAuxiliar(false);	
				formatonomifactornomi.setIsNewAuxiliar(false);	
				formatonomifactornomi.setIsChangedAuxiliar(false);
				
				formatonomifactornomi.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresFormatoNomiFactorNomi(FormatoNomiFactorNomi formatonomifactornomi,Boolean conEnteros) throws Exception  {
		formatonomifactornomi.setponderacion(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresFormatoNomiFactorNomis(List<FormatoNomiFactorNomi> formatonomifactornomis,Boolean conEnteros) throws Exception  {
		
		for(FormatoNomiFactorNomi formatonomifactornomi: formatonomifactornomis) {
			formatonomifactornomi.setponderacion(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaFormatoNomiFactorNomi(List<FormatoNomiFactorNomi> formatonomifactornomis,FormatoNomiFactorNomi formatonomifactornomiAux) throws Exception  {
		FormatoNomiFactorNomiConstantesFunciones.InicializarValoresFormatoNomiFactorNomi(formatonomifactornomiAux,true);
		
		for(FormatoNomiFactorNomi formatonomifactornomi: formatonomifactornomis) {
			if(formatonomifactornomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			formatonomifactornomiAux.setponderacion(formatonomifactornomiAux.getponderacion()+formatonomifactornomi.getponderacion());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesFormatoNomiFactorNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=FormatoNomiFactorNomiConstantesFunciones.getArrayColumnasGlobalesFormatoNomiFactorNomi(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesFormatoNomiFactorNomi(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FormatoNomiFactorNomiConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FormatoNomiFactorNomiConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FormatoNomiFactorNomiConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FormatoNomiFactorNomiConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoFormatoNomiFactorNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<FormatoNomiFactorNomi> formatonomifactornomis,FormatoNomiFactorNomi formatonomifactornomi,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(FormatoNomiFactorNomi formatonomifactornomiAux: formatonomifactornomis) {
			if(formatonomifactornomiAux!=null && formatonomifactornomi!=null) {
				if((formatonomifactornomiAux.getId()==null && formatonomifactornomi.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(formatonomifactornomiAux.getId()!=null && formatonomifactornomi.getId()!=null){
					if(formatonomifactornomiAux.getId().equals(formatonomifactornomi.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaFormatoNomiFactorNomi(List<FormatoNomiFactorNomi> formatonomifactornomis) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double ponderacionTotal=0.0;
	
		for(FormatoNomiFactorNomi formatonomifactornomi: formatonomifactornomis) {			
			if(formatonomifactornomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			ponderacionTotal+=formatonomifactornomi.getponderacion();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormatoNomiFactorNomiConstantesFunciones.PONDERACION);
		datoGeneral.setsDescripcion(FormatoNomiFactorNomiConstantesFunciones.LABEL_PONDERACION);
		datoGeneral.setdValorDouble(ponderacionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaFormatoNomiFactorNomi() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,FormatoNomiFactorNomiConstantesFunciones.LABEL_ID, FormatoNomiFactorNomiConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormatoNomiFactorNomiConstantesFunciones.LABEL_VERSIONROW, FormatoNomiFactorNomiConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormatoNomiFactorNomiConstantesFunciones.LABEL_IDEMPRESA, FormatoNomiFactorNomiConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormatoNomiFactorNomiConstantesFunciones.LABEL_IDSUCURSAL, FormatoNomiFactorNomiConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormatoNomiFactorNomiConstantesFunciones.LABEL_IDFORMATONOMI, FormatoNomiFactorNomiConstantesFunciones.IDFORMATONOMI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormatoNomiFactorNomiConstantesFunciones.LABEL_IDFACTORNOMI, FormatoNomiFactorNomiConstantesFunciones.IDFACTORNOMI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormatoNomiFactorNomiConstantesFunciones.LABEL_PONDERACION, FormatoNomiFactorNomiConstantesFunciones.PONDERACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormatoNomiFactorNomiConstantesFunciones.LABEL_ESTAACTIVO, FormatoNomiFactorNomiConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasFormatoNomiFactorNomi() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=FormatoNomiFactorNomiConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormatoNomiFactorNomiConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormatoNomiFactorNomiConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormatoNomiFactorNomiConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormatoNomiFactorNomiConstantesFunciones.IDFORMATONOMI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormatoNomiFactorNomiConstantesFunciones.IDFACTORNOMI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormatoNomiFactorNomiConstantesFunciones.PONDERACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormatoNomiFactorNomiConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormatoNomiFactorNomi() throws Exception  {
		return FormatoNomiFactorNomiConstantesFunciones.getTiposSeleccionarFormatoNomiFactorNomi(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormatoNomiFactorNomi(Boolean conFk) throws Exception  {
		return FormatoNomiFactorNomiConstantesFunciones.getTiposSeleccionarFormatoNomiFactorNomi(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormatoNomiFactorNomi(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormatoNomiFactorNomiConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(FormatoNomiFactorNomiConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormatoNomiFactorNomiConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(FormatoNomiFactorNomiConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormatoNomiFactorNomiConstantesFunciones.LABEL_IDFORMATONOMI);
			reporte.setsDescripcion(FormatoNomiFactorNomiConstantesFunciones.LABEL_IDFORMATONOMI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormatoNomiFactorNomiConstantesFunciones.LABEL_IDFACTORNOMI);
			reporte.setsDescripcion(FormatoNomiFactorNomiConstantesFunciones.LABEL_IDFACTORNOMI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormatoNomiFactorNomiConstantesFunciones.LABEL_PONDERACION);
			reporte.setsDescripcion(FormatoNomiFactorNomiConstantesFunciones.LABEL_PONDERACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormatoNomiFactorNomiConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(FormatoNomiFactorNomiConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesFormatoNomiFactorNomi(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesFormatoNomiFactorNomi(FormatoNomiFactorNomi formatonomifactornomiAux) throws Exception {
		
			formatonomifactornomiAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(formatonomifactornomiAux.getEmpresa()));
			formatonomifactornomiAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(formatonomifactornomiAux.getSucursal()));
			formatonomifactornomiAux.setformatonomi_descripcion(FormatoNomiConstantesFunciones.getFormatoNomiDescripcion(formatonomifactornomiAux.getFormatoNomi()));
			formatonomifactornomiAux.setfactornomi_descripcion(FactorNomiConstantesFunciones.getFactorNomiDescripcion(formatonomifactornomiAux.getFactorNomi()));		
	}
	
	public static void refrescarForeignKeysDescripcionesFormatoNomiFactorNomi(List<FormatoNomiFactorNomi> formatonomifactornomisTemp) throws Exception {
		for(FormatoNomiFactorNomi formatonomifactornomiAux:formatonomifactornomisTemp) {
			
			formatonomifactornomiAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(formatonomifactornomiAux.getEmpresa()));
			formatonomifactornomiAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(formatonomifactornomiAux.getSucursal()));
			formatonomifactornomiAux.setformatonomi_descripcion(FormatoNomiConstantesFunciones.getFormatoNomiDescripcion(formatonomifactornomiAux.getFormatoNomi()));
			formatonomifactornomiAux.setfactornomi_descripcion(FactorNomiConstantesFunciones.getFactorNomiDescripcion(formatonomifactornomiAux.getFactorNomi()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfFormatoNomiFactorNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(FormatoNomi.class));
				classes.add(new Classe(FactorNomi.class));
				
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
					if(clas.clas.equals(FormatoNomi.class)) {
						classes.add(new Classe(FormatoNomi.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(FactorNomi.class)) {
						classes.add(new Classe(FactorNomi.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfFormatoNomiFactorNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(FormatoNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormatoNomi.class)); continue;
					}

					if(FactorNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FactorNomi.class)); continue;
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

					if(FormatoNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormatoNomi.class)); continue;
					}

					if(FactorNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FactorNomi.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormatoNomiFactorNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return FormatoNomiFactorNomiConstantesFunciones.getClassesRelationshipsOfFormatoNomiFactorNomi(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormatoNomiFactorNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(CalificacionEmpleado.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(CalificacionEmpleado.class)) {
						classes.add(new Classe(CalificacionEmpleado.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFormatoNomiFactorNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return FormatoNomiFactorNomiConstantesFunciones.getClassesRelationshipsFromStringsOfFormatoNomiFactorNomi(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFormatoNomiFactorNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(CalificacionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CalificacionEmpleado.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(CalificacionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CalificacionEmpleado.class)); continue;
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(FormatoNomiFactorNomi formatonomifactornomi,List<FormatoNomiFactorNomi> formatonomifactornomis,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			FormatoNomiFactorNomi formatonomifactornomiEncontrado=null;
			
			for(FormatoNomiFactorNomi formatonomifactornomiLocal:formatonomifactornomis) {
				if(formatonomifactornomiLocal.getId().equals(formatonomifactornomi.getId())) {
					formatonomifactornomiEncontrado=formatonomifactornomiLocal;
					
					formatonomifactornomiLocal.setIsChanged(formatonomifactornomi.getIsChanged());
					formatonomifactornomiLocal.setIsNew(formatonomifactornomi.getIsNew());
					formatonomifactornomiLocal.setIsDeleted(formatonomifactornomi.getIsDeleted());
					
					formatonomifactornomiLocal.setGeneralEntityOriginal(formatonomifactornomi.getGeneralEntityOriginal());
					
					formatonomifactornomiLocal.setId(formatonomifactornomi.getId());	
					formatonomifactornomiLocal.setVersionRow(formatonomifactornomi.getVersionRow());	
					formatonomifactornomiLocal.setid_empresa(formatonomifactornomi.getid_empresa());	
					formatonomifactornomiLocal.setid_sucursal(formatonomifactornomi.getid_sucursal());	
					formatonomifactornomiLocal.setid_formato_nomi(formatonomifactornomi.getid_formato_nomi());	
					formatonomifactornomiLocal.setid_factor_nomi(formatonomifactornomi.getid_factor_nomi());	
					formatonomifactornomiLocal.setponderacion(formatonomifactornomi.getponderacion());	
					formatonomifactornomiLocal.setesta_activo(formatonomifactornomi.getesta_activo());	
					
					
					formatonomifactornomiLocal.setCalificacionEmpleados(formatonomifactornomi.getCalificacionEmpleados());
					
					existe=true;
					break;
				}
			}
			
			if(!formatonomifactornomi.getIsDeleted()) {
				if(!existe) {
					formatonomifactornomis.add(formatonomifactornomi);
				}
			} else {
				if(formatonomifactornomiEncontrado!=null && permiteQuitar)  {
					formatonomifactornomis.remove(formatonomifactornomiEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(FormatoNomiFactorNomi formatonomifactornomi,List<FormatoNomiFactorNomi> formatonomifactornomis) throws Exception {
		try	{			
			for(FormatoNomiFactorNomi formatonomifactornomiLocal:formatonomifactornomis) {
				if(formatonomifactornomiLocal.getId().equals(formatonomifactornomi.getId())) {
					formatonomifactornomiLocal.setIsSelected(formatonomifactornomi.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesFormatoNomiFactorNomi(List<FormatoNomiFactorNomi> formatonomifactornomisAux) throws Exception {
		//this.formatonomifactornomisAux=formatonomifactornomisAux;
		
		for(FormatoNomiFactorNomi formatonomifactornomiAux:formatonomifactornomisAux) {
			if(formatonomifactornomiAux.getIsChanged()) {
				formatonomifactornomiAux.setIsChanged(false);
			}		
			
			if(formatonomifactornomiAux.getIsNew()) {
				formatonomifactornomiAux.setIsNew(false);
			}	
			
			if(formatonomifactornomiAux.getIsDeleted()) {
				formatonomifactornomiAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesFormatoNomiFactorNomi(FormatoNomiFactorNomi formatonomifactornomiAux) throws Exception {
		//this.formatonomifactornomiAux=formatonomifactornomiAux;
		
			if(formatonomifactornomiAux.getIsChanged()) {
				formatonomifactornomiAux.setIsChanged(false);
			}		
			
			if(formatonomifactornomiAux.getIsNew()) {
				formatonomifactornomiAux.setIsNew(false);
			}	
			
			if(formatonomifactornomiAux.getIsDeleted()) {
				formatonomifactornomiAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(FormatoNomiFactorNomi formatonomifactornomiAsignar,FormatoNomiFactorNomi formatonomifactornomi) throws Exception {
		formatonomifactornomiAsignar.setId(formatonomifactornomi.getId());	
		formatonomifactornomiAsignar.setVersionRow(formatonomifactornomi.getVersionRow());	
		formatonomifactornomiAsignar.setid_empresa(formatonomifactornomi.getid_empresa());
		formatonomifactornomiAsignar.setempresa_descripcion(formatonomifactornomi.getempresa_descripcion());	
		formatonomifactornomiAsignar.setid_sucursal(formatonomifactornomi.getid_sucursal());
		formatonomifactornomiAsignar.setsucursal_descripcion(formatonomifactornomi.getsucursal_descripcion());	
		formatonomifactornomiAsignar.setid_formato_nomi(formatonomifactornomi.getid_formato_nomi());
		formatonomifactornomiAsignar.setformatonomi_descripcion(formatonomifactornomi.getformatonomi_descripcion());	
		formatonomifactornomiAsignar.setid_factor_nomi(formatonomifactornomi.getid_factor_nomi());
		formatonomifactornomiAsignar.setfactornomi_descripcion(formatonomifactornomi.getfactornomi_descripcion());	
		formatonomifactornomiAsignar.setponderacion(formatonomifactornomi.getponderacion());	
		formatonomifactornomiAsignar.setesta_activo(formatonomifactornomi.getesta_activo());	
	}
	
	public static void inicializarFormatoNomiFactorNomi(FormatoNomiFactorNomi formatonomifactornomi) throws Exception {
		try {
				formatonomifactornomi.setId(0L);	
					
				formatonomifactornomi.setid_empresa(-1L);	
				formatonomifactornomi.setid_sucursal(-1L);	
				formatonomifactornomi.setid_formato_nomi(-1L);	
				formatonomifactornomi.setid_factor_nomi(-1L);	
				formatonomifactornomi.setponderacion(0.0);	
				formatonomifactornomi.setesta_activo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderFormatoNomiFactorNomi(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(FormatoNomiFactorNomiConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormatoNomiFactorNomiConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormatoNomiFactorNomiConstantesFunciones.LABEL_IDFORMATONOMI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormatoNomiFactorNomiConstantesFunciones.LABEL_IDFACTORNOMI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormatoNomiFactorNomiConstantesFunciones.LABEL_PONDERACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormatoNomiFactorNomiConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataFormatoNomiFactorNomi(String sTipo,Row row,Workbook workbook,FormatoNomiFactorNomi formatonomifactornomi,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(formatonomifactornomi.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formatonomifactornomi.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formatonomifactornomi.getformatonomi_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formatonomifactornomi.getfactornomi_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formatonomifactornomi.getponderacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(formatonomifactornomi.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryFormatoNomiFactorNomi=Constantes.SFINALQUERY;
	
	public String getsFinalQueryFormatoNomiFactorNomi() {
		return this.sFinalQueryFormatoNomiFactorNomi;
	}
	
	public void setsFinalQueryFormatoNomiFactorNomi(String sFinalQueryFormatoNomiFactorNomi) {
		this.sFinalQueryFormatoNomiFactorNomi= sFinalQueryFormatoNomiFactorNomi;
	}
	
	public Border resaltarSeleccionarFormatoNomiFactorNomi=null;
	
	public Border setResaltarSeleccionarFormatoNomiFactorNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiFactorNomiBeanSwingJInternalFrame formatonomifactornomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//formatonomifactornomiBeanSwingJInternalFrame.jTtoolBarFormatoNomiFactorNomi.setBorder(borderResaltar);
		
		this.resaltarSeleccionarFormatoNomiFactorNomi= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarFormatoNomiFactorNomi() {
		return this.resaltarSeleccionarFormatoNomiFactorNomi;
	}
	
	public void setResaltarSeleccionarFormatoNomiFactorNomi(Border borderResaltarSeleccionarFormatoNomiFactorNomi) {
		this.resaltarSeleccionarFormatoNomiFactorNomi= borderResaltarSeleccionarFormatoNomiFactorNomi;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridFormatoNomiFactorNomi=null;
	public Boolean mostraridFormatoNomiFactorNomi=true;
	public Boolean activaridFormatoNomiFactorNomi=true;

	public Border resaltarid_empresaFormatoNomiFactorNomi=null;
	public Boolean mostrarid_empresaFormatoNomiFactorNomi=true;
	public Boolean activarid_empresaFormatoNomiFactorNomi=true;
	public Boolean cargarid_empresaFormatoNomiFactorNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaFormatoNomiFactorNomi=false;//ConEventDepend=true

	public Border resaltarid_sucursalFormatoNomiFactorNomi=null;
	public Boolean mostrarid_sucursalFormatoNomiFactorNomi=true;
	public Boolean activarid_sucursalFormatoNomiFactorNomi=true;
	public Boolean cargarid_sucursalFormatoNomiFactorNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalFormatoNomiFactorNomi=false;//ConEventDepend=true

	public Border resaltarid_formato_nomiFormatoNomiFactorNomi=null;
	public Boolean mostrarid_formato_nomiFormatoNomiFactorNomi=true;
	public Boolean activarid_formato_nomiFormatoNomiFactorNomi=true;
	public Boolean cargarid_formato_nomiFormatoNomiFactorNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formato_nomiFormatoNomiFactorNomi=false;//ConEventDepend=true

	public Border resaltarid_factor_nomiFormatoNomiFactorNomi=null;
	public Boolean mostrarid_factor_nomiFormatoNomiFactorNomi=true;
	public Boolean activarid_factor_nomiFormatoNomiFactorNomi=true;
	public Boolean cargarid_factor_nomiFormatoNomiFactorNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_factor_nomiFormatoNomiFactorNomi=false;//ConEventDepend=true

	public Border resaltarponderacionFormatoNomiFactorNomi=null;
	public Boolean mostrarponderacionFormatoNomiFactorNomi=true;
	public Boolean activarponderacionFormatoNomiFactorNomi=true;

	public Border resaltaresta_activoFormatoNomiFactorNomi=null;
	public Boolean mostraresta_activoFormatoNomiFactorNomi=true;
	public Boolean activaresta_activoFormatoNomiFactorNomi=true;

	
	

	public Border setResaltaridFormatoNomiFactorNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiFactorNomiBeanSwingJInternalFrame formatonomifactornomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formatonomifactornomiBeanSwingJInternalFrame.jTtoolBarFormatoNomiFactorNomi.setBorder(borderResaltar);
		
		this.resaltaridFormatoNomiFactorNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridFormatoNomiFactorNomi() {
		return this.resaltaridFormatoNomiFactorNomi;
	}

	public void setResaltaridFormatoNomiFactorNomi(Border borderResaltar) {
		this.resaltaridFormatoNomiFactorNomi= borderResaltar;
	}

	public Boolean getMostraridFormatoNomiFactorNomi() {
		return this.mostraridFormatoNomiFactorNomi;
	}

	public void setMostraridFormatoNomiFactorNomi(Boolean mostraridFormatoNomiFactorNomi) {
		this.mostraridFormatoNomiFactorNomi= mostraridFormatoNomiFactorNomi;
	}

	public Boolean getActivaridFormatoNomiFactorNomi() {
		return this.activaridFormatoNomiFactorNomi;
	}

	public void setActivaridFormatoNomiFactorNomi(Boolean activaridFormatoNomiFactorNomi) {
		this.activaridFormatoNomiFactorNomi= activaridFormatoNomiFactorNomi;
	}

	public Border setResaltarid_empresaFormatoNomiFactorNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiFactorNomiBeanSwingJInternalFrame formatonomifactornomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formatonomifactornomiBeanSwingJInternalFrame.jTtoolBarFormatoNomiFactorNomi.setBorder(borderResaltar);
		
		this.resaltarid_empresaFormatoNomiFactorNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaFormatoNomiFactorNomi() {
		return this.resaltarid_empresaFormatoNomiFactorNomi;
	}

	public void setResaltarid_empresaFormatoNomiFactorNomi(Border borderResaltar) {
		this.resaltarid_empresaFormatoNomiFactorNomi= borderResaltar;
	}

	public Boolean getMostrarid_empresaFormatoNomiFactorNomi() {
		return this.mostrarid_empresaFormatoNomiFactorNomi;
	}

	public void setMostrarid_empresaFormatoNomiFactorNomi(Boolean mostrarid_empresaFormatoNomiFactorNomi) {
		this.mostrarid_empresaFormatoNomiFactorNomi= mostrarid_empresaFormatoNomiFactorNomi;
	}

	public Boolean getActivarid_empresaFormatoNomiFactorNomi() {
		return this.activarid_empresaFormatoNomiFactorNomi;
	}

	public void setActivarid_empresaFormatoNomiFactorNomi(Boolean activarid_empresaFormatoNomiFactorNomi) {
		this.activarid_empresaFormatoNomiFactorNomi= activarid_empresaFormatoNomiFactorNomi;
	}

	public Boolean getCargarid_empresaFormatoNomiFactorNomi() {
		return this.cargarid_empresaFormatoNomiFactorNomi;
	}

	public void setCargarid_empresaFormatoNomiFactorNomi(Boolean cargarid_empresaFormatoNomiFactorNomi) {
		this.cargarid_empresaFormatoNomiFactorNomi= cargarid_empresaFormatoNomiFactorNomi;
	}

	public Border setResaltarid_sucursalFormatoNomiFactorNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiFactorNomiBeanSwingJInternalFrame formatonomifactornomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formatonomifactornomiBeanSwingJInternalFrame.jTtoolBarFormatoNomiFactorNomi.setBorder(borderResaltar);
		
		this.resaltarid_sucursalFormatoNomiFactorNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalFormatoNomiFactorNomi() {
		return this.resaltarid_sucursalFormatoNomiFactorNomi;
	}

	public void setResaltarid_sucursalFormatoNomiFactorNomi(Border borderResaltar) {
		this.resaltarid_sucursalFormatoNomiFactorNomi= borderResaltar;
	}

	public Boolean getMostrarid_sucursalFormatoNomiFactorNomi() {
		return this.mostrarid_sucursalFormatoNomiFactorNomi;
	}

	public void setMostrarid_sucursalFormatoNomiFactorNomi(Boolean mostrarid_sucursalFormatoNomiFactorNomi) {
		this.mostrarid_sucursalFormatoNomiFactorNomi= mostrarid_sucursalFormatoNomiFactorNomi;
	}

	public Boolean getActivarid_sucursalFormatoNomiFactorNomi() {
		return this.activarid_sucursalFormatoNomiFactorNomi;
	}

	public void setActivarid_sucursalFormatoNomiFactorNomi(Boolean activarid_sucursalFormatoNomiFactorNomi) {
		this.activarid_sucursalFormatoNomiFactorNomi= activarid_sucursalFormatoNomiFactorNomi;
	}

	public Boolean getCargarid_sucursalFormatoNomiFactorNomi() {
		return this.cargarid_sucursalFormatoNomiFactorNomi;
	}

	public void setCargarid_sucursalFormatoNomiFactorNomi(Boolean cargarid_sucursalFormatoNomiFactorNomi) {
		this.cargarid_sucursalFormatoNomiFactorNomi= cargarid_sucursalFormatoNomiFactorNomi;
	}

	public Border setResaltarid_formato_nomiFormatoNomiFactorNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiFactorNomiBeanSwingJInternalFrame formatonomifactornomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formatonomifactornomiBeanSwingJInternalFrame.jTtoolBarFormatoNomiFactorNomi.setBorder(borderResaltar);
		
		this.resaltarid_formato_nomiFormatoNomiFactorNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formato_nomiFormatoNomiFactorNomi() {
		return this.resaltarid_formato_nomiFormatoNomiFactorNomi;
	}

	public void setResaltarid_formato_nomiFormatoNomiFactorNomi(Border borderResaltar) {
		this.resaltarid_formato_nomiFormatoNomiFactorNomi= borderResaltar;
	}

	public Boolean getMostrarid_formato_nomiFormatoNomiFactorNomi() {
		return this.mostrarid_formato_nomiFormatoNomiFactorNomi;
	}

	public void setMostrarid_formato_nomiFormatoNomiFactorNomi(Boolean mostrarid_formato_nomiFormatoNomiFactorNomi) {
		this.mostrarid_formato_nomiFormatoNomiFactorNomi= mostrarid_formato_nomiFormatoNomiFactorNomi;
	}

	public Boolean getActivarid_formato_nomiFormatoNomiFactorNomi() {
		return this.activarid_formato_nomiFormatoNomiFactorNomi;
	}

	public void setActivarid_formato_nomiFormatoNomiFactorNomi(Boolean activarid_formato_nomiFormatoNomiFactorNomi) {
		this.activarid_formato_nomiFormatoNomiFactorNomi= activarid_formato_nomiFormatoNomiFactorNomi;
	}

	public Boolean getCargarid_formato_nomiFormatoNomiFactorNomi() {
		return this.cargarid_formato_nomiFormatoNomiFactorNomi;
	}

	public void setCargarid_formato_nomiFormatoNomiFactorNomi(Boolean cargarid_formato_nomiFormatoNomiFactorNomi) {
		this.cargarid_formato_nomiFormatoNomiFactorNomi= cargarid_formato_nomiFormatoNomiFactorNomi;
	}

	public Border setResaltarid_factor_nomiFormatoNomiFactorNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiFactorNomiBeanSwingJInternalFrame formatonomifactornomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formatonomifactornomiBeanSwingJInternalFrame.jTtoolBarFormatoNomiFactorNomi.setBorder(borderResaltar);
		
		this.resaltarid_factor_nomiFormatoNomiFactorNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_factor_nomiFormatoNomiFactorNomi() {
		return this.resaltarid_factor_nomiFormatoNomiFactorNomi;
	}

	public void setResaltarid_factor_nomiFormatoNomiFactorNomi(Border borderResaltar) {
		this.resaltarid_factor_nomiFormatoNomiFactorNomi= borderResaltar;
	}

	public Boolean getMostrarid_factor_nomiFormatoNomiFactorNomi() {
		return this.mostrarid_factor_nomiFormatoNomiFactorNomi;
	}

	public void setMostrarid_factor_nomiFormatoNomiFactorNomi(Boolean mostrarid_factor_nomiFormatoNomiFactorNomi) {
		this.mostrarid_factor_nomiFormatoNomiFactorNomi= mostrarid_factor_nomiFormatoNomiFactorNomi;
	}

	public Boolean getActivarid_factor_nomiFormatoNomiFactorNomi() {
		return this.activarid_factor_nomiFormatoNomiFactorNomi;
	}

	public void setActivarid_factor_nomiFormatoNomiFactorNomi(Boolean activarid_factor_nomiFormatoNomiFactorNomi) {
		this.activarid_factor_nomiFormatoNomiFactorNomi= activarid_factor_nomiFormatoNomiFactorNomi;
	}

	public Boolean getCargarid_factor_nomiFormatoNomiFactorNomi() {
		return this.cargarid_factor_nomiFormatoNomiFactorNomi;
	}

	public void setCargarid_factor_nomiFormatoNomiFactorNomi(Boolean cargarid_factor_nomiFormatoNomiFactorNomi) {
		this.cargarid_factor_nomiFormatoNomiFactorNomi= cargarid_factor_nomiFormatoNomiFactorNomi;
	}

	public Border setResaltarponderacionFormatoNomiFactorNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiFactorNomiBeanSwingJInternalFrame formatonomifactornomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formatonomifactornomiBeanSwingJInternalFrame.jTtoolBarFormatoNomiFactorNomi.setBorder(borderResaltar);
		
		this.resaltarponderacionFormatoNomiFactorNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarponderacionFormatoNomiFactorNomi() {
		return this.resaltarponderacionFormatoNomiFactorNomi;
	}

	public void setResaltarponderacionFormatoNomiFactorNomi(Border borderResaltar) {
		this.resaltarponderacionFormatoNomiFactorNomi= borderResaltar;
	}

	public Boolean getMostrarponderacionFormatoNomiFactorNomi() {
		return this.mostrarponderacionFormatoNomiFactorNomi;
	}

	public void setMostrarponderacionFormatoNomiFactorNomi(Boolean mostrarponderacionFormatoNomiFactorNomi) {
		this.mostrarponderacionFormatoNomiFactorNomi= mostrarponderacionFormatoNomiFactorNomi;
	}

	public Boolean getActivarponderacionFormatoNomiFactorNomi() {
		return this.activarponderacionFormatoNomiFactorNomi;
	}

	public void setActivarponderacionFormatoNomiFactorNomi(Boolean activarponderacionFormatoNomiFactorNomi) {
		this.activarponderacionFormatoNomiFactorNomi= activarponderacionFormatoNomiFactorNomi;
	}

	public Border setResaltaresta_activoFormatoNomiFactorNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiFactorNomiBeanSwingJInternalFrame formatonomifactornomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formatonomifactornomiBeanSwingJInternalFrame.jTtoolBarFormatoNomiFactorNomi.setBorder(borderResaltar);
		
		this.resaltaresta_activoFormatoNomiFactorNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoFormatoNomiFactorNomi() {
		return this.resaltaresta_activoFormatoNomiFactorNomi;
	}

	public void setResaltaresta_activoFormatoNomiFactorNomi(Border borderResaltar) {
		this.resaltaresta_activoFormatoNomiFactorNomi= borderResaltar;
	}

	public Boolean getMostraresta_activoFormatoNomiFactorNomi() {
		return this.mostraresta_activoFormatoNomiFactorNomi;
	}

	public void setMostraresta_activoFormatoNomiFactorNomi(Boolean mostraresta_activoFormatoNomiFactorNomi) {
		this.mostraresta_activoFormatoNomiFactorNomi= mostraresta_activoFormatoNomiFactorNomi;
	}

	public Boolean getActivaresta_activoFormatoNomiFactorNomi() {
		return this.activaresta_activoFormatoNomiFactorNomi;
	}

	public void setActivaresta_activoFormatoNomiFactorNomi(Boolean activaresta_activoFormatoNomiFactorNomi) {
		this.activaresta_activoFormatoNomiFactorNomi= activaresta_activoFormatoNomiFactorNomi;
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
		
		
		this.setMostraridFormatoNomiFactorNomi(esInicial);
		this.setMostrarid_empresaFormatoNomiFactorNomi(esInicial);
		this.setMostrarid_sucursalFormatoNomiFactorNomi(esInicial);
		this.setMostrarid_formato_nomiFormatoNomiFactorNomi(esInicial);
		this.setMostrarid_factor_nomiFormatoNomiFactorNomi(esInicial);
		this.setMostrarponderacionFormatoNomiFactorNomi(esInicial);
		this.setMostraresta_activoFormatoNomiFactorNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormatoNomiFactorNomiConstantesFunciones.ID)) {
				this.setMostraridFormatoNomiFactorNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiFactorNomiConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaFormatoNomiFactorNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiFactorNomiConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalFormatoNomiFactorNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiFactorNomiConstantesFunciones.IDFORMATONOMI)) {
				this.setMostrarid_formato_nomiFormatoNomiFactorNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiFactorNomiConstantesFunciones.IDFACTORNOMI)) {
				this.setMostrarid_factor_nomiFormatoNomiFactorNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiFactorNomiConstantesFunciones.PONDERACION)) {
				this.setMostrarponderacionFormatoNomiFactorNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiFactorNomiConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoFormatoNomiFactorNomi(esAsigna);
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
		
		
		this.setActivaridFormatoNomiFactorNomi(esInicial);
		this.setActivarid_empresaFormatoNomiFactorNomi(esInicial);
		this.setActivarid_sucursalFormatoNomiFactorNomi(esInicial);
		this.setActivarid_formato_nomiFormatoNomiFactorNomi(esInicial);
		this.setActivarid_factor_nomiFormatoNomiFactorNomi(esInicial);
		this.setActivarponderacionFormatoNomiFactorNomi(esInicial);
		this.setActivaresta_activoFormatoNomiFactorNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormatoNomiFactorNomiConstantesFunciones.ID)) {
				this.setActivaridFormatoNomiFactorNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiFactorNomiConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaFormatoNomiFactorNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiFactorNomiConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalFormatoNomiFactorNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiFactorNomiConstantesFunciones.IDFORMATONOMI)) {
				this.setActivarid_formato_nomiFormatoNomiFactorNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiFactorNomiConstantesFunciones.IDFACTORNOMI)) {
				this.setActivarid_factor_nomiFormatoNomiFactorNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiFactorNomiConstantesFunciones.PONDERACION)) {
				this.setActivarponderacionFormatoNomiFactorNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiFactorNomiConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoFormatoNomiFactorNomi(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,FormatoNomiFactorNomiBeanSwingJInternalFrame formatonomifactornomiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridFormatoNomiFactorNomi(esInicial);
		this.setResaltarid_empresaFormatoNomiFactorNomi(esInicial);
		this.setResaltarid_sucursalFormatoNomiFactorNomi(esInicial);
		this.setResaltarid_formato_nomiFormatoNomiFactorNomi(esInicial);
		this.setResaltarid_factor_nomiFormatoNomiFactorNomi(esInicial);
		this.setResaltarponderacionFormatoNomiFactorNomi(esInicial);
		this.setResaltaresta_activoFormatoNomiFactorNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormatoNomiFactorNomiConstantesFunciones.ID)) {
				this.setResaltaridFormatoNomiFactorNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiFactorNomiConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaFormatoNomiFactorNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiFactorNomiConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalFormatoNomiFactorNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiFactorNomiConstantesFunciones.IDFORMATONOMI)) {
				this.setResaltarid_formato_nomiFormatoNomiFactorNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiFactorNomiConstantesFunciones.IDFACTORNOMI)) {
				this.setResaltarid_factor_nomiFormatoNomiFactorNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiFactorNomiConstantesFunciones.PONDERACION)) {
				this.setResaltarponderacionFormatoNomiFactorNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiFactorNomiConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoFormatoNomiFactorNomi(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarCalificacionEmpleadoFormatoNomiFactorNomi=null;

	public Border getResaltarCalificacionEmpleadoFormatoNomiFactorNomi() {
		return this.resaltarCalificacionEmpleadoFormatoNomiFactorNomi;
	}

	public void setResaltarCalificacionEmpleadoFormatoNomiFactorNomi(Border borderResaltarCalificacionEmpleado) {
		if(borderResaltarCalificacionEmpleado!=null) {
			this.resaltarCalificacionEmpleadoFormatoNomiFactorNomi= borderResaltarCalificacionEmpleado;
		}
	}

	public Border setResaltarCalificacionEmpleadoFormatoNomiFactorNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiFactorNomiBeanSwingJInternalFrame formatonomifactornomiBeanSwingJInternalFrame*/) {
		Border borderResaltarCalificacionEmpleado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//formatonomifactornomiBeanSwingJInternalFrame.jTtoolBarFormatoNomiFactorNomi.setBorder(borderResaltarCalificacionEmpleado);
			
		this.resaltarCalificacionEmpleadoFormatoNomiFactorNomi= borderResaltarCalificacionEmpleado;

		 return borderResaltarCalificacionEmpleado;
	}



	public Boolean mostrarCalificacionEmpleadoFormatoNomiFactorNomi=true;

	public Boolean getMostrarCalificacionEmpleadoFormatoNomiFactorNomi() {
		return this.mostrarCalificacionEmpleadoFormatoNomiFactorNomi;
	}

	public void setMostrarCalificacionEmpleadoFormatoNomiFactorNomi(Boolean visibilidadResaltarCalificacionEmpleado) {
		this.mostrarCalificacionEmpleadoFormatoNomiFactorNomi= visibilidadResaltarCalificacionEmpleado;
	}



	public Boolean activarCalificacionEmpleadoFormatoNomiFactorNomi=true;

	public Boolean gethabilitarResaltarCalificacionEmpleadoFormatoNomiFactorNomi() {
		return this.activarCalificacionEmpleadoFormatoNomiFactorNomi;
	}

	public void setActivarCalificacionEmpleadoFormatoNomiFactorNomi(Boolean habilitarResaltarCalificacionEmpleado) {
		this.activarCalificacionEmpleadoFormatoNomiFactorNomi= habilitarResaltarCalificacionEmpleado;
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

		this.setMostrarCalificacionEmpleadoFormatoNomiFactorNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CalificacionEmpleado.class)) {
				this.setMostrarCalificacionEmpleadoFormatoNomiFactorNomi(esAsigna);
				continue;
			}
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

		this.setActivarCalificacionEmpleadoFormatoNomiFactorNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CalificacionEmpleado.class)) {
				this.setActivarCalificacionEmpleadoFormatoNomiFactorNomi(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,FormatoNomiFactorNomiBeanSwingJInternalFrame formatonomifactornomiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarCalificacionEmpleadoFormatoNomiFactorNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CalificacionEmpleado.class)) {
				this.setResaltarCalificacionEmpleadoFormatoNomiFactorNomi(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaFormatoNomiFactorNomi=true;

	public Boolean getMostrarFK_IdEmpresaFormatoNomiFactorNomi() {
		return this.mostrarFK_IdEmpresaFormatoNomiFactorNomi;
	}

	public void setMostrarFK_IdEmpresaFormatoNomiFactorNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaFormatoNomiFactorNomi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFactorNomiFormatoNomiFactorNomi=true;

	public Boolean getMostrarFK_IdFactorNomiFormatoNomiFactorNomi() {
		return this.mostrarFK_IdFactorNomiFormatoNomiFactorNomi;
	}

	public void setMostrarFK_IdFactorNomiFormatoNomiFactorNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFactorNomiFormatoNomiFactorNomi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormatoNomiFormatoNomiFactorNomi=true;

	public Boolean getMostrarFK_IdFormatoNomiFormatoNomiFactorNomi() {
		return this.mostrarFK_IdFormatoNomiFormatoNomiFactorNomi;
	}

	public void setMostrarFK_IdFormatoNomiFormatoNomiFactorNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormatoNomiFormatoNomiFactorNomi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalFormatoNomiFactorNomi=true;

	public Boolean getMostrarFK_IdSucursalFormatoNomiFactorNomi() {
		return this.mostrarFK_IdSucursalFormatoNomiFactorNomi;
	}

	public void setMostrarFK_IdSucursalFormatoNomiFactorNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalFormatoNomiFactorNomi= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaFormatoNomiFactorNomi=true;

	public Boolean getActivarFK_IdEmpresaFormatoNomiFactorNomi() {
		return this.activarFK_IdEmpresaFormatoNomiFactorNomi;
	}

	public void setActivarFK_IdEmpresaFormatoNomiFactorNomi(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaFormatoNomiFactorNomi= habilitarResaltar;
	}

	public Boolean activarFK_IdFactorNomiFormatoNomiFactorNomi=true;

	public Boolean getActivarFK_IdFactorNomiFormatoNomiFactorNomi() {
		return this.activarFK_IdFactorNomiFormatoNomiFactorNomi;
	}

	public void setActivarFK_IdFactorNomiFormatoNomiFactorNomi(Boolean habilitarResaltar) {
		this.activarFK_IdFactorNomiFormatoNomiFactorNomi= habilitarResaltar;
	}

	public Boolean activarFK_IdFormatoNomiFormatoNomiFactorNomi=true;

	public Boolean getActivarFK_IdFormatoNomiFormatoNomiFactorNomi() {
		return this.activarFK_IdFormatoNomiFormatoNomiFactorNomi;
	}

	public void setActivarFK_IdFormatoNomiFormatoNomiFactorNomi(Boolean habilitarResaltar) {
		this.activarFK_IdFormatoNomiFormatoNomiFactorNomi= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalFormatoNomiFactorNomi=true;

	public Boolean getActivarFK_IdSucursalFormatoNomiFactorNomi() {
		return this.activarFK_IdSucursalFormatoNomiFactorNomi;
	}

	public void setActivarFK_IdSucursalFormatoNomiFactorNomi(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalFormatoNomiFactorNomi= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaFormatoNomiFactorNomi=null;

	public Border getResaltarFK_IdEmpresaFormatoNomiFactorNomi() {
		return this.resaltarFK_IdEmpresaFormatoNomiFactorNomi;
	}

	public void setResaltarFK_IdEmpresaFormatoNomiFactorNomi(Border borderResaltar) {
		this.resaltarFK_IdEmpresaFormatoNomiFactorNomi= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaFormatoNomiFactorNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiFactorNomiBeanSwingJInternalFrame formatonomifactornomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaFormatoNomiFactorNomi= borderResaltar;
	}

	public Border resaltarFK_IdFactorNomiFormatoNomiFactorNomi=null;

	public Border getResaltarFK_IdFactorNomiFormatoNomiFactorNomi() {
		return this.resaltarFK_IdFactorNomiFormatoNomiFactorNomi;
	}

	public void setResaltarFK_IdFactorNomiFormatoNomiFactorNomi(Border borderResaltar) {
		this.resaltarFK_IdFactorNomiFormatoNomiFactorNomi= borderResaltar;
	}

	public void setResaltarFK_IdFactorNomiFormatoNomiFactorNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiFactorNomiBeanSwingJInternalFrame formatonomifactornomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFactorNomiFormatoNomiFactorNomi= borderResaltar;
	}

	public Border resaltarFK_IdFormatoNomiFormatoNomiFactorNomi=null;

	public Border getResaltarFK_IdFormatoNomiFormatoNomiFactorNomi() {
		return this.resaltarFK_IdFormatoNomiFormatoNomiFactorNomi;
	}

	public void setResaltarFK_IdFormatoNomiFormatoNomiFactorNomi(Border borderResaltar) {
		this.resaltarFK_IdFormatoNomiFormatoNomiFactorNomi= borderResaltar;
	}

	public void setResaltarFK_IdFormatoNomiFormatoNomiFactorNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiFactorNomiBeanSwingJInternalFrame formatonomifactornomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormatoNomiFormatoNomiFactorNomi= borderResaltar;
	}

	public Border resaltarFK_IdSucursalFormatoNomiFactorNomi=null;

	public Border getResaltarFK_IdSucursalFormatoNomiFactorNomi() {
		return this.resaltarFK_IdSucursalFormatoNomiFactorNomi;
	}

	public void setResaltarFK_IdSucursalFormatoNomiFactorNomi(Border borderResaltar) {
		this.resaltarFK_IdSucursalFormatoNomiFactorNomi= borderResaltar;
	}

	public void setResaltarFK_IdSucursalFormatoNomiFactorNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiFactorNomiBeanSwingJInternalFrame formatonomifactornomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalFormatoNomiFactorNomi= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}